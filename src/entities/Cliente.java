package entities;

import java.time.LocalDate;

public abstract class Cliente {

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;
    private String status;

    public static final String STATUS_ATIVO = "Ativo";
    public static final String STATUS_ENCERRADO = "Encerrado";

    public Cliente(){
        this.status = STATUS_ATIVO;
    }

    public Cliente(String nomeCompleto, LocalDate dataNascimento, String endereco, String telefone, LocalDate dataInicio) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataInicio = dataInicio;
        this.status = STATUS_ATIVO;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
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
