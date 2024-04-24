package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ClienteCestaBasica extends Cliente {

    public ClienteCestaBasica(){
        super();
    }

    public ClienteCestaBasica(String nomeCompleto, LocalDate dataNascimento, String endereco, String telefone, String dataInicio, String dataEncerramento) {
        super(nomeCompleto, dataNascimento, endereco, telefone, dataInicio, dataEncerramento);
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatted = getDataNascimento().format(formatter);


        return "Nome: "
                + getNomeCompleto()
                + ", Data de nascimento: "
                + dataNascimentoFormatted
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
