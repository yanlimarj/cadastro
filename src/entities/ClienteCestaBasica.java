package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ClienteCestaBasica extends Cliente {

    public ClienteCestaBasica(){
        super();
    }

    public ClienteCestaBasica(String nomeCompleto, LocalDate dataNascimento, String endereco, String telefone, LocalDate dataInicio) {
        super(nomeCompleto, dataNascimento, endereco, telefone, dataInicio);
    }

    public static String dataTempoAtual(LocalDate dataInicio){

        LocalDate dataTempoAtual = LocalDate.now();
        Period periodo = Period.between(dataInicio, dataTempoAtual);

        int anos = periodo.getYears();
        int meses = periodo.getMonths();
        int dias = periodo.getDays();

        return "Diferença em anos, meses e dias: " + anos + " anos, " + meses + " meses, " + dias + " dias.";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimentoFormatted = getDataNascimento().format(formatter);
        String dataInicioFormatted = getDataInicio().format(formatter);

        String tempoAtual = dataTempoAtual(getDataInicio());

        return "Nome: "
                + getNomeCompleto()
                + ", Data de nascimento: "
                + dataNascimentoFormatted
                + ", Endereço: "
                + getEndereco()
                + ", Telefone: "
                + getTelefone()
                + ", Data de inicio no programa: "
                + dataInicioFormatted
                + ", Status: "
                + getStatus()
                + ", Tempo desde o inicio: "
                + tempoAtual;
    }
}
