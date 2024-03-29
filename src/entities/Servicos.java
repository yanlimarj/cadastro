package entities;

import java.util.ArrayList;

public class Servicos {

    private ArrayList<String> listaServicos;

    public Servicos() {
        listaServicos = new ArrayList<>();
        listaServicos.add("fisioterapia");
        listaServicos.add("fonoaudiologia");
        listaServicos.add("tratamento traumático muscular");
        listaServicos.add("psicologia");
    }

    public String obterNomeTratamento(int indice) {
        return listaServicos.get(indice);
    }

    public void mostrarTratamentos() {
        for (int i = 0; i < listaServicos.size(); i++) {
            System.out.println((i + 1) + "- " + listaServicos.get(i));
        }
    }
}
