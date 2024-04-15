package entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Medico extends Funcionario{

    private String especialidade;
    private List<Cliente> pacientes;

    public Medico(){
        super();
        this.pacientes = new ArrayList<>();
    }
    public Medico(String nome, String telefone, Integer matricula, String endereco, String email, String funcao, String especialidade, Image foto) {
        super(nome, telefone, matricula, endereco, email, funcao, foto);
        this.especialidade = especialidade;
        this.pacientes = new ArrayList<>();
    }

    public void adicionarPaciente(Cliente paciente){
        pacientes.add(paciente);
    }

    public void removerPaciente(Cliente paciente){
        pacientes.remove(paciente);
    }

    public List<Cliente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Cliente> pacientes) {
        this.pacientes = pacientes;
    }

}
