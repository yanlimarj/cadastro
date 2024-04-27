package entities;

import java.time.LocalDate;

public abstract class Cliente {

    private String nomeCompleto;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String dataInicio;
    private String dataEncerramento;
    private String status;

    public static final String STATUS_ATIVO = "Ativo";
    public static final String STATUS_ENCERRADO = "Encerrado";

    public Cliente(){
        this.status = STATUS_ATIVO;
    }

    public Cliente(String nomeCompleto, String dataNascimento, String endereco, String telefone, String dataInicio, String dataEncerramento) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataInicio = dataInicio;
        this.dataEncerramento = dataEncerramento;
        this.status = STATUS_ATIVO;
    }

    public Cliente(String nomeCompleto, String dataNascimento, String endereco, String telefone, String dataInicio) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataInicio = dataInicio;
        this.status = STATUS_ATIVO;
        this.dataEncerramento ="";
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
        if (dataEncerramento != null) {
            this.status = STATUS_ENCERRADO;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
