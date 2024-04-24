package application;

import entities.ClienteCestaBasica;
import entities.Servicos;
import entities.ClienteServicosEspecialidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            try {
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
                    cestasBasicas.add(new ClienteCestaBasica());
                    System.out.println("Cadastro Cesta basica feito com sucesso!");
                } else {
                    System.out.println("Escolha a especialidade: ");
                    servicos.mostrarEspecialides();
                    int indiceEspecialidade = sc.nextInt();
                    String especialidade = servicos.obterNomeEspecialide(indiceEspecialidade - 1);
                    servicosPrestados.add(new ClienteServicosEspecialidade());
                    System.out.println("Cadastro de " + especialidade + " feito com sucesso!");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Erro ao processar data. Certifique-se de inserir a data no formato correto (dd/MM/yyyy).");
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada. Certifique-se de inserir um número inteiro.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                sc.nextLine();
            }
            System.out.println();
            try {
                System.out.print("Deseja continuar o cadastro? (s/n): ");
                char continuar = Character.toLowerCase(sc.next().charAt(0));
                sc.nextLine();
                if(continuar != 's' && continuar != 'n'){
                    throw new IllegalArgumentException("Entrada invalida. Por favor, digite apenas 's' ou 'n'.");
                }
                continuarCadastro = (continuar == 's');
            }
            catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }
        System.out.println("Cestas Básicas cadastradas:");
        cestasBasicas.forEach(System.out::println);

        System.out.println("Serviços Prestados cadastrados:");
        servicosPrestados.forEach(System.out::println);

        sc.close();
    }
}
