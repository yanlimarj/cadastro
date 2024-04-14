package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteServicosEspecialidade extends Cliente {

    private String especialidade;
    private String obsProfissional;

    public ClienteServicosEspecialidade() {
        super();
    }

    public ClienteServicosEspecialidade(String nomeCompleto, LocalDate dataNascimento, String endereco, String telefone, LocalDate dataInicio, String especialidade) {
        super(nomeCompleto, dataNascimento, endereco, telefone, dataInicio);
        this.especialidade = especialidade;
        this.obsProfissional = "";
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getObsProfissional() {
        return obsProfissional;
    }

    public void setObsProfissional(String obsProfissional) {
        this.obsProfissional = obsProfissional;
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
                + ", Telefone: "
                + getTelefone()
                + ", Data de inicio do tratamento: "
                + dataInicioFormatted
                + ", Especialidade: "
                + especialidade
                + ", Observação do profissional: "
                + obsProfissional
                + ", Status: "
                + getStatus();

    }


}
