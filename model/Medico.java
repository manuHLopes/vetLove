package model;

import java.util.Scanner;

public class Medico extends Usuario{
    private static int contadorMedicos = 0;
    private int id_medico;
    private String crmv;
    private String telefone;
    private String especialidade;
    private String rqe;

    public Medico(){
        super();
        this.id_medico = ++contadorMedicos;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getRqe() {
        return rqe;
    }

    public void setRqe(String rqe) {
        this.rqe = rqe;
    }

    public Medico atualizar_cadastro(){
        Scanner ler = new Scanner(System.in);

        System.out.println("Insira o CRMV: ");
        this.setCrmv(ler.nextLine());

        System.out.println("Insira a Especialidade: ");
        this.setEspecialidade(ler.nextLine());

        System.out.println("Insira o RQE: ");
        this.setRqe(ler.nextLine());

        System.out.println("Insira o telefone: ");
        this.setTelefone(ler.nextLine());

        return this;
    }
}
