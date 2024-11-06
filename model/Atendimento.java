package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Atendimento {
    private static int contadorAtendimento = 0;
    private int id_atendimento;
    private int id_pet;
    private int id_usuario;
    private String tipo_atendimento;
    private String status_atendimento;
    private LocalDate data_atendimento;
    private LocalTime hora_atendimento;
    private double valor;
    private ArrayList<Pagamento> pagamentos;

    public Atendimento(){
        id_atendimento= ++contadorAtendimento;
        pagamentos = new ArrayList<Pagamento>();
        data_atendimento = LocalDate.now();
        hora_atendimento = LocalTime.now();
    }

    public Atendimento(int id_pet,int id_usuario, String tipo_atendimento, double valor){
        id_atendimento= ++contadorAtendimento;
        pagamentos = new ArrayList<Pagamento>();
        this.id_usuario = id_usuario;
        this.id_pet = id_pet;
        data_atendimento = LocalDate.now();
        hora_atendimento = LocalTime.now();
        this.tipo_atendimento = tipo_atendimento;
        this.valor = valor;
        this.status_atendimento = "cadastrado";
    }

    //METODOS
    public void adicionar_pagamentos(){
        Scanner ler = new Scanner(System.in);
        double valor_cobrado = valor;
        do{
            System.out.println("valor cobrado: R$ " + valor_cobrado);
            Pagamento pagamento = new Pagamento(id_atendimento);
            pagamento.pagar(valor_cobrado);
            pagamentos.add(pagamento);
            valor_cobrado -= pagamento.getValor();
        }while(valor_cobrado > 0);
        System.out.println("Status do atendimento: Pago!");
        status_atendimento = "pago";
    }

    public int getId_atendimento() {
        return id_atendimento;
    }

    public void setId_atendimento(int id_atendimento) {
        this.id_atendimento = id_atendimento;
    }

    public int getId_pet() {
        return id_pet;
    }

    public void setId_pet(int id_pet) {
        this.id_pet = id_pet;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public String getTipo_atendimento() {
        return tipo_atendimento;
    }

    public void setTipo_atendimento(String tipo_atendimento) {
        this.tipo_atendimento = tipo_atendimento;
    }

    public String getStatus_atendimento() {
        return status_atendimento;
    }

    public void setStatus_atendimento(String status_atendimento) {
        this.status_atendimento = status_atendimento;
    }

    public LocalDate getData_atendimento() {
        return data_atendimento;
    }

    public void setData_atendimento(LocalDate data_atendimento) {
        this.data_atendimento = data_atendimento;
    }

    public LocalTime getHora_atendimento() {
        return hora_atendimento;
    }

    public void setHora_atendimento(LocalTime hora_atendimento) {
        this.hora_atendimento = hora_atendimento;
    }

}
