package application;

import entities.ClienteCestaBasica;
import entities.Servicos;
import entities.ClienteServicosEspecialidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Servicos servicos = new Servicos();
        List<ClienteCestaBasica> cestasBasicas = new ArrayList<>();
        List<ClienteServicosEspecialidade> servicosPrestados = new ArrayList<>();

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
                cestasBasicas.add(new ClienteCestaBasica(nomeCompleto, dataNascimento, endereco, telefone, dataInicio));
                System.out.println("Cadastro Cesta basica feito com sucesso!");
            } else {
                System.out.println("Escolha a especialidade: ");
                servicos.mostrarEspecialides();
                int indiceEspecialidade = sc.nextInt();
                String especialidade = servicos.obterNomeEspecialide(indiceEspecialidade - 1);
                servicosPrestados.add(new ClienteServicosEspecialidade(nomeCompleto, dataNascimento, endereco, telefone, dataInicio, especialidade));
                System.out.println("Cadastro de " + especialidade + " feito com sucesso!");
            }
            System.out.println();
            System.out.print("Deseja continuar o cadastro? (s/n): ");
            String continuar = sc.next();
            sc.nextLine();
            continuarCadastro = continuar.equalsIgnoreCase("s");
        }

        System.out.println("Cestas Básicas cadastradas:");
        for (ClienteCestaBasica cestaBasica : cestasBasicas) {
            System.out.println(cestaBasica);
        }

        System.out.println("Serviços Prestados cadastrados:");
        for (ClienteServicosEspecialidade servicoPrestado : servicosPrestados) {
            System.out.println(servicoPrestado);
        }

        sc.close();
    }
}
