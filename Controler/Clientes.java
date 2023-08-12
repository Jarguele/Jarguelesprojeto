import java.util.Scanner;

public class CadastroPessoas {
    private static final int CAPACIDADE_MAXIMA = 100;
    private static String[] listaNomes = new String[CAPACIDADE_MAXIMA];
    private static int totalPessoas = 0;

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

    private static void cadastrarPessoa(Scanner scanner) {
        if (totalPessoas >= CAPACIDADE_MAXIMA) {
            System.out.println("Cadastro de pessoas atingiu o limite máximo.");
            return;
        }

        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        listaNomes[totalPessoas] = nome;
        totalPessoas++;

        System.out.println("Pessoa cadastrada com sucesso.");
    }

    private static void buscarPessoa(Scanner scanner) {
        System.out.print("Digite o nome da pessoa a ser buscada: ");
        String nome = scanner.nextLine();

        boolean encontrada = false;

        for (int i = 0; i < totalPessoas; i++) {
            if (listaNomes[i].equalsIgnoreCase(nome)) {
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println("A pessoa \"" + nome + "\" foi encontrada.");
        } else {
            System.out.println("A pessoa \"" + nome + "\" não foi encontrada.");
        }
    }

    private static void removerPessoa(Scanner scanner) {
        System.out.print("Digite o nome da pessoa a ser removida: ");
        String nome = scanner.nextLine();

        boolean encontrada = false;

        for (int i = 0; i < totalPessoas; i++) {
            if (listaNomes[i].equalsIgnoreCase(nome)) {
                encontrada = true;

                for (int j = i; j < totalPessoas - 1; j++) {
                    listaNomes[j] = listaNomes[j + 1];
                }

                totalPessoas--;

                break;
            }
        }

        if (encontrada) {
            System.out.println("A pessoa \"" + nome + "\" foi removida com sucesso.");
        } else {
            System.out.println("A pessoa \"" + nome + "\" não foi encontrada.");
        }
    }

    private static void listarNomes() {
        if (totalPessoas == 0) {
            System.out.println("Nenhuma pessoa cadastrada até o momento.");
        } else {
            System.out.println("Lista de nomes cadastrados:");

            for (int i = 0; i < totalPessoas; i++) {
                System.out.println((i + 1) + ". " + listaNomes[i]);
            }
        }
    }
}
