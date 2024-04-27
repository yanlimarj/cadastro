package entities;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteServicosEspecialidade extends Cliente {

    private String especialidade;
    private String nomeMedico;
    private String obsProfissional;

    public ClienteServicosEspecialidade() {
        super();
    }

    public ClienteServicosEspecialidade(String nomeCompleto, String dataNascimento, String endereco, String telefone, String dataInicio, String especialidade, String nomeMedico) {
        super(nomeCompleto, dataNascimento, endereco, telefone, dataInicio);
        this.especialidade = especialidade;
        this.nomeMedico = nomeMedico;
        this.obsProfissional = "";
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getObsProfissional() {
        return obsProfissional;
    }

    public void setObsProfissional(String obsProfissional) {
        this.obsProfissional = obsProfissional;
    }


    @Override
    public String toString() {


        return "Nome: "
                + getNomeCompleto()
                + ", Data de nascimento: "
                + getDataNascimento()
                + ", Endereço: "
                + getEndereco()
                + ", Telefone: "
                + getTelefone()
                + ", Data de inicio do tratamento: "
                + getDataInicio()
                + ", Especialidade: "
                + especialidade
                + "Medico: "
                + nomeMedico
                + ", Observação do profissional: "
                + obsProfissional
                + ", Status: "
                + getStatus();

    }


}
