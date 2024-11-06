package model;

import java.util.Scanner;

public class Cartao {
    private static int contadorCartao = 0;
    private String titular;
    private String num_cartao;
    private String tipo_cartao;
    private String validade_cartao;
    private String cvv; // vou colocar uma observação
    private double valor;
    private int qtd_parcelas;
    private int id_cartao;
    private int id_pagamento; //chave estrangeira

    public Cartao(){
        id_cartao = ++contadorCartao;
    }

    public void cadastrar_cartao(int id_pagamento, double valor) {
        this.id_pagamento = id_pagamento;

        Scanner ler = new Scanner(System.in);
        Scanner digitos = new Scanner(System.in);

        System.out.println("Crédito ou Débito (escreva a opção): ");
        this.tipo_cartao = ler.nextLine();

        this.valor = valor;

        if(this.tipo_cartao.equalsIgnoreCase("crédito") || this.tipo_cartao.equalsIgnoreCase("credito")){
            System.out.println("Pretende dividir em quantas vezes? ");
            this.qtd_parcelas = digitos.nextInt();
        } else this.qtd_parcelas = 1;

        System.out.println("Insira o titular do cartão: ");
        this.titular = ler.nextLine();

        System.out.println("Insira o numero do cartão: ");
        this.num_cartao = ler.nextLine();

        System.out.println("Insira a validade do cartão: ");
        this.validade_cartao = ler.nextLine();

        System.out.println("Insira o código do cartão: ");
        this.cvv = ler.nextLine();

        while(this.cvv.length()!=3){
            System.out.println("o CVV deve ter apenas 3 caracteres!\n insira novamente: ");
            this.cvv = ler.nextLine();
        }
    }

    public String imprimir_cartao() {
        return "\n\nid_cartao= " + id_cartao +
                "\ntitular= " + titular +
                "\nnum_cartao= " + num_cartao +
                "\ntipo_cartao= " + tipo_cartao +
                "\nvalor neste cartão= " + valor +
                "\nqtd_parcelas= " + qtd_parcelas +
                "\nid_pagamento= " + id_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    public String getTipo_cartao() {
        return tipo_cartao;
    }

    public void setTipo_cartao(String tipo_cartao) {
        this.tipo_cartao = tipo_cartao;
    }

    public String getValidade_cartao() {
        return validade_cartao;
    }

    public void setValidade_cartao(String validade_cartao) {
        this.validade_cartao = validade_cartao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getQtd_parcelas() {
        return qtd_parcelas;
    }

    public void setQtd_parcelas(int qtd_parcelas) {
        this.qtd_parcelas = qtd_parcelas;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }
}
