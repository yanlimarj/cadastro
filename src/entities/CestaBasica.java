package entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class CestaBasica extends Usuario{

    public CestaBasica(){
        super();
    }

    public CestaBasica(String nomeCompleto, LocalDate dataNascimento, String endereco, String bairro, String telefone, LocalDate dataInicio) {
        super(nomeCompleto, dataNascimento, endereco, bairro, telefone, dataInicio);
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

        return "Nome: "
                + getNomeCompleto()
                + ", Data de nascimento: "
                + dataNascimentoFormatted
                + ", Endereço: "
                + getEndereco()
                + ", Bairro: "
                + getBairro()
                + ", Telefone: "
                + getTelefone()
                + " Data de inicio no programa: "
                + dataInicioFormatted;
    }
}
