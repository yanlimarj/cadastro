package entities;

import java.time.LocalDate;

public class Usuario {

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String endereco;
    private String bairro;
    private String telefone;
    private LocalDate dataInicio;


    public Usuario(){
    }

    public Usuario(String nomeCompleto, LocalDate dataNascimento, String endereco, String bairro, String telefone, LocalDate dataInicio) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.bairro = bairro;
        this.telefone = telefone;
        this.dataInicio = dataInicio;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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
}
