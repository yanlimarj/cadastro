package application;

import entities.CestaBasica;
import entities.Servicos;
import entities.ServicosPrestados;
import entities.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Servicos servicos = new Servicos();
        List<CestaBasica> cestasBasicas = new ArrayList<>();
        List<ServicosPrestados> servicosPrestados = new ArrayList<>();

        boolean continuarCadastro = true;
        System.out.println("----Sistema de cadastro----");
        while (continuarCadastro) {

            System.out.println("Cadastro");
            System.out.print("Nome: ");
            String nomeCompleto = sc.nextLine();
            System.out.print("Data de nascimento(dd/MM/yyyy): ");
            String dataNascimentoStr = sc.next();
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            sc.nextLine();
            System.out.print("Endereço: ");
            String endereco = sc.nextLine();
            System.out.print("Bairro: ");
            String bairro = sc.nextLine();
            System.out.print("Telefone: ");
            String telefone = sc.nextLine();
            System.out.print("Data de cadastro(dd/MM/yyyy): ");
            String dataInicioStr = sc.next();
            LocalDate dataInicio = LocalDate.parse(dataInicioStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.println("Escolha o serviço: ");
            System.out.println("1 - Cesta Basica");
            System.out.println("2 - Tratamento");
            int escolha = sc.nextInt();
            boolean escolhaValida = escolha == 1 || escolha == 2;
            while (!escolhaValida) {
                System.out.println("Opção inválida! Por favor, escolha novamente.");
                System.out.println("Escolha o serviço:");
                System.out.println("1 - Cesta Basica");
                System.out.println("2 - Tratamento");
                escolha = sc.nextInt();

                if (escolha == 1 || escolha == 2) {
                    escolhaValida = true;
                }
            }

            if (escolha == 1) {
                cestasBasicas.add(new CestaBasica(nomeCompleto, dataNascimento, endereco, bairro, telefone, dataInicio));
                System.out.println("Cadastro Cesta basica feito com sucesso!");
            } else {
                System.out.println("Escolha o tratamento: ");
                servicos.mostrarTratamentos();
                int indiceTratamento = sc.nextInt();
                String tratamento = servicos.obterNomeTratamento(indiceTratamento - 1);
                servicosPrestados.add(new ServicosPrestados(nomeCompleto, dataNascimento, endereco, bairro, telefone, dataInicio, tratamento));
                System.out.println("Cadastro de " + tratamento + " feito com sucesso!");
            }
            System.out.println();
            System.out.print("Deseja continuar o cadastro? (s/n): ");
            String continuar = sc.next();
            sc.nextLine();
            continuarCadastro = continuar.equalsIgnoreCase("s");
        }

        System.out.println("Cestas Básicas cadastradas:");
        for (CestaBasica cestaBasica : cestasBasicas) {
            System.out.println(cestaBasica);
        }

        System.out.println("Serviços Prestados cadastrados:");
        for (ServicosPrestados servicoPrestado : servicosPrestados) {
            System.out.println(servicoPrestado);
        }

        sc.close();
    }
}
