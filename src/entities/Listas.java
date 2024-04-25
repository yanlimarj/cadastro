package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Listas {

    private final ArrayList<String> listaServicos;

    private final Map<String, ArrayList<String>> listaPacientesPorMedico;


    public Listas() {
        listaServicos = new ArrayList<>();
        listaServicos.add("fisioterapia");
        listaServicos.add("fonoaudiologia");
        listaServicos.add("tratamento neural");
        listaServicos.add("psicologia");

        ArrayList<String> listaMedicosFisioterapia = new ArrayList<>();
        listaMedicosFisioterapia.add("Dra. Renata Silva");
        listaMedicosFisioterapia.add("Dr. André Santos");

        ArrayList<String> listaMedicosFonoaudiologia = new ArrayList<>();
        listaMedicosFonoaudiologia.add("Dra. Juliana Mendes");
        listaMedicosFonoaudiologia.add("Dr. Thiago Oliveira");

        ArrayList<String> listaMedicosTratamentoNeural = new ArrayList<>();
        listaMedicosTratamentoNeural.add("Dr. Marcos Costa");
        listaMedicosTratamentoNeural.add("Dra. Carolina Fernandes");

        ArrayList<String> listaMedicosPsicologia = new ArrayList<>();
        listaMedicosPsicologia.add("Dra. Ana Torres");
        listaMedicosPsicologia.add("Dr. Lucas Pereira");

        listaPacientesPorMedico = new HashMap<>();

        for (String medico : listaMedicosFisioterapia) {
            listaPacientesPorMedico.put(medico, new ArrayList<>());
        }
        for (String medico : listaMedicosFonoaudiologia) {
            listaPacientesPorMedico.put(medico, new ArrayList<>());
        }
        for (String medico : listaMedicosTratamentoNeural) {
            listaPacientesPorMedico.put(medico, new ArrayList<>());
        }
        for (String medico : listaMedicosPsicologia) {
            listaPacientesPorMedico.put(medico, new ArrayList<>());
        }

    }

    public void adicionarPaciente(String nomeMedico, String nomePaciente) {
        ArrayList<String> listaPacientes = listaPacientesPorMedico.get(nomeMedico);
        if (listaPacientes != null) {
            listaPacientes.add(nomePaciente);
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    public String obterNomeEspecialide(int indice) {
        return listaServicos.get(indice);
    }

    public void mostrarEspecialides() {
        for (int i = 0; i < listaServicos.size(); i++) {
            System.out.println((i + 1) + "- " + listaServicos.get(i));
        }
    }










}
