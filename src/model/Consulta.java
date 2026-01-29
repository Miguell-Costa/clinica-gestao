package model;

// classe que presenta uma consulta

public class Consulta {
    private int id;
    private int pacienteId;
    private int medicoId;
    private String dataConsulta;
    private String horaConsulta;
    private String obervacoes;

    //construtor com id da consulta;
    public Consulta(int id, int pacienteId, int medicoId, String dataConsulta, String horaConsulta, String obervacoes) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.obervacoes = obervacoes;
    }

    // construtor sem id da consulta
    public Consulta(int pacienteId, int medicoId, String dataConsulta, String horaConsulta, String obervacoes) {
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.obervacoes = obervacoes;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getObervacoes() {
        return obervacoes;
    }

    public void setObervacoes(String obervacoes) {
        this.obervacoes = obervacoes;
    }

    @Override
    public String toString() {
        return "consulta{" +
                "id=" + id +
                ", pacienteId=" + pacienteId +
                ", medicoId=" + medicoId +
                ", dataConsulta='" + dataConsulta + '\'' +
                ", horaConsulta='" + horaConsulta + '\'' +
                ", obervacoes='" + obervacoes + '\'' +
                '}';
    }
}
