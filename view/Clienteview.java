package view;

import java.util.Scanner;

public class Clienteview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- CADASTRO DE PESSOAS -----");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Buscar pessoa");
            System.out.println("3. Remover pessoa");
            System.out.println("4. Ver lista de nomes");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarPessoa(scanner);
                    break;
                case 2:
                    buscarPessoa(scanner);
                    break;
                case 3:
                    removerPessoa(scanner);
                    break;
                case 4:
                    listarNomes();
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
