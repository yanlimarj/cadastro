package entities;

import java.awt.*;

public class Funcionario {

    private String nome;
    private String telefone;
    private Integer matricula;
    private String endereco;
    private String email;
    private String funcao;


    public Funcionario(){}


    public Funcionario(String nome, String telefone, Integer matricula, String endereco, String email, String funcao) {
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
        this.endereco = endereco;
        this.email = email;
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
