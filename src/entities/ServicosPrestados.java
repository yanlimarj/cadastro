package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServicosPrestados extends Usuario {

    private String tratamento;
    private LocalDate dataEncerramento;
    private String status;

    public static final String STATUS_ATIVO = "Ativo";
    public static final String STATUS_ENCERRADO = "Encerrado";

    public ServicosPrestados() {
        super();
        this.status = STATUS_ATIVO;
    }

    public ServicosPrestados(String nomeCompleto, LocalDate dataNascimento, String endereco, String bairro, String telefone, LocalDate dataInicio, String tratamento) {
        super(nomeCompleto, dataNascimento, endereco, bairro, telefone, dataInicio);
        this.tratamento = tratamento;
        this.status = STATUS_ATIVO;
    }

    public String getTratamento() {
        return tratamento;
    }

    public LocalDate getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDate dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
        if (dataEncerramento != null) {
            this.status = STATUS_ENCERRADO;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                + " Data de inicio do tratamento: "
                + dataInicioFormatted
                + " Tratamento: "
                + tratamento
                + " Status: "
                + status;
    }


}
