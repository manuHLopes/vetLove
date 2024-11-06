package model;

import java.time.LocalDate;

public class Consulta extends Atendimento {
    private static int contadorConsulta = 0;
    private int id_consulta;
    private LocalDate data_hora_consulta;

    //construtor
    public Consulta(int id_pet, int id_usuario) {
        super(id_pet, id_usuario, "Consulta", 150.00);
        id_consulta = ++contadorConsulta;
        data_hora_consulta = LocalDate.now();
    }

    public Consulta(int id_consulta, LocalDate data_hora_consulta, Atendimento atendimento){
        super();
        this.id_consulta = id_consulta;
        this.data_hora_consulta = data_hora_consulta;
    }

    //métodos de acesso
    public int getId_consulta() {
        return id_consulta;
    }
    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }
    public LocalDate getData_hora_consulta() {
        return data_hora_consulta;
    }
    public void setData_hora_consulta(LocalDate dataHoraConsulta) {
        this.data_hora_consulta = dataHoraConsulta;
    }
    public String destalhesConsulta(){
        return "Data e Hora: " + data_hora_consulta + ", " + "\nValor: R$" + super.getValor();
    }
}