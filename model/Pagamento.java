package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Pagamento {
    private static int contadorPagamento = 0;
    private int id_pagamento;
    private int id_atendimento;
    private String forma_pagamento; // dinheiro, pix ou cartão
    private LocalDate data_pagamento;
    private double valor;
    private ArrayList<Cartao> cartoes;

    public Pagamento(int id_atendimento){
        id_pagamento = ++contadorPagamento;
        this.id_atendimento = id_atendimento;
    }

    private void cadastrar_pagamento(String forma_pagamento){
        this.forma_pagamento = forma_pagamento;
        this.data_pagamento = LocalDate.now();
        System.out.println("insira o valor pago: ");
        Scanner ler = new Scanner(System.in);
        this.valor = ler.nextDouble();
    }

    public void pagar(double valor_cobrado){
        Scanner ler = new Scanner(System.in);
        System.out.println("\nComo deseja realizar o pagamento?\n" +
                "1 - dinheiro\n2 - pix\n3 - cartão\n");
        int opcao = ler.nextInt();

        switch (opcao){
            case 1:
                cadastrar_pagamento("Dinheiro");
                break;
            case 2:
                cadastrar_pagamento("Pix");
                break;
            case 3:
                cadastrar_pagamento("Cartão");
                cartoes = new ArrayList<Cartao>();
                int continuar;
                double total = 0;
                int i = 0;
                do{
                    continuar = 1;
                    cadastrar_cartao();
                    total += cartoes.get(i).getValor();
                    while(total < valor_cobrado && continuar == 1){
                        System.out.println("O valor neste cartão é muito baixo, deseja alterar o valor ou cadastrar mais um cartão?\n1- alterar valor\n2- cadastrar mais um cartão\n3- Nova forma de pagamento");
                        continuar = ler.nextInt();
                        if(continuar == 1){
                            total -= cartoes.get(i).getValor();
                            System.out.println("insira o novo valor: ");
                            cartoes.get(i).setValor(ler.nextDouble());
                            total += cartoes.get(i).getValor();
                        }else if(continuar == 2){
                            System.out.println("\nvalor restante: R$ " + (valor_cobrado - total));
                        }
                    }
                    i++;
                }while(continuar == 2);
                break;
            default:
                System.out.println("você precisa escolher uma das opções, tente novamente: ");
                do {
                    System.out.println("\nComo deseja realizar o pagamento?\n" +
                            "1 - dinheiro ou pix\n2 - apenas um cartão\n3 - mais de um cartão");
                    opcao = ler.nextInt();
                }while (opcao < 1 || opcao > 4);
        }
    }

    private void cadastrar_cartao(){
        Cartao cartao = new Cartao();
        cartao.cadastrar_cartao(id_pagamento, valor);
        cartoes.add(cartao);
    }

    public void imprimir_pagamento(){
        System.out.println(imprimir());
    }

    private String imprimir(){
        StringBuilder dados = new StringBuilder();
        if(this.forma_pagamento.equals("Cartão")){
            dados.append("\n==== cartões ====\n");
            for(Cartao cartao : cartoes){
                dados.append(cartao.imprimir_cartao());
            }
        }
        return "\n====== pagamento =======\n" + "\nid: " + id_pagamento + "\ndata: " + data_pagamento + "\nforma: "+ forma_pagamento +"\nvalor: " + valor + dados;
    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
