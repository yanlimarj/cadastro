package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ClienteCestaBasica extends Cliente {

    public ClienteCestaBasica(){
        super();
    }

    public ClienteCestaBasica(String nomeCompleto, String dataNascimento, String endereco, String telefone, String dataInicio, String dataEncerramento) {
        super(nomeCompleto, dataNascimento, endereco, telefone, dataInicio, dataEncerramento);
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
                + ", Data de inicio no programa: "
                + getDataInicio()
                + ", Status: "
                + getStatus();

    }
}
