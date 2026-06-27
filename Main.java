import java.util.Scanner;

// Menu Interativo - Ponto de entrada do programa
public class Main {


    public static void main(String[] args) {
        SistemaIMC sistema = new SistemaIMC();
        Scanner scanner = new Scanner(System.in);


        // Tipos,variáveis e operadores - Uso de int e boolean para controle de estado
        int opcao = -1;
        boolean pessoaCadastrada = false;


        // Loop de repetição (while) para manter o menu ativo
        while (opcao != 0) {
            System.out.println("\n===== CALCULADORA IMC =====");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Cadastrar Atleta");
            System.out.println("3. Calcular e exibir IMC");
            System.out.println("4. Exibir Histórico");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");


            // Tratamento de Exceções - Bloco try para proteger leitura de dados
            try {
                opcao = scanner.nextInt();


               1 // Switch para direcionamento de escolhas
                switch (opcao) {
                    case 1 -> {
                        //Instanciação de objetos e uso de polimorfismo
                        sistema.cadastrarPessoa();
                        pessoaCadastrada = true;
                    }
                    case 2 -> {
                        // Instanciação de objetos (Atleta)
                        sistema.cadastrarAtleta();
                        pessoaCadastrada = true;
                    }
                    case 3 -> {
                        // Uso de variável lógica para controle antes do cálculo
                        if (!pessoaCadastrada) {
                            System.out.println("Nenhuma pessoa cadastrada ainda!");
                        } else {
                            // Recursão - Chamada de função recursiva demonstrada aqui
                            System.out.println("(Recursão ativa no cálculo)");
                            sistema.processarUltima();
                        }
                    }
                    case 4 -> {
                        if (!pessoaCadastrada) {
                            System.out.println("Nenhuma pessoa cadastrada ainda!");
                        } else {
                            sistema.exibirHistorico();
                        }
                    }
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (java.util.InputMismatchException e) {
                // Erros não encerram o programa - exibe erro e retorna ao menu
                System.out.println("Digite apenas números!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}