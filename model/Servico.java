package model;

public class Servico extends Atendimento {
    private static int contadorServico = 0;
    private int id_servico;
    private TipoServico tipoServico; // ex.: limpeza, exame, vacina...


    public Servico(TipoServico tipoServico, int id_pet, int id_usuario){
        super(id_pet, id_usuario, "Serviço", tipoServico.getValor_servico());
        id_servico = ++contadorServico;
        this.tipoServico = tipoServico;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String imprimir() {
        return "Nome do serviço: " + this.tipoServico.getNome_tipo_servico();
    }
}
