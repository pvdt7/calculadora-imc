import java.util.Scanner;

// Classe de orquestracão que gerencia cadastro e processamento de IMC
public class SistemaIMC {

    // Atributos - composicão com Histórico
    private Scanner scanner = new Scanner(System.in);
    private Historico historico = new Historico();
    private PessoaBase ultimaPessoa = null;

    // Lê um valor double validando entrada
    private double lerDouble(String campo) {
        while (true) {
            String entrada = scanner.next();
            entrada = entrada.replace(",", ".");
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido para " + campo + ". Digite novamente: ");
            }
        }
    }

     // Cadastra uma pessoa comum
    public void cadastrarPessoa() {
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Peso (kg): ");
        double peso = lerDouble("Peso");
        System.out.print("Altura (m): ");
        double altura = lerDouble("Altura");
        try {
            Pessoa p = new Pessoa(nome, idade, peso, altura);
            System.out.println("\n" + p.exibirPerfil());
            processar(p);
            ultimaPessoa = p;
        } catch (EntradaInvalidaException e) {
            System.out.println("\n[ERRO DE VALIDACAO]: " + e.getMessage());
        }
    }

    // Cadastra um atleta
    public void cadastrarAtleta() {
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Peso (kg): ");
        double peso = lerDouble("Peso");
        System.out.print("Altura (m): ");
        double altura = lerDouble("Altura");
        scanner.nextLine();
        System.out.print("Modalidade: ");
        String modalidade = scanner.nextLine();
        try {
            Atleta a = new Atleta(nome, idade, peso, altura, modalidade);
            System.out.println("\n" + a.exibirPerfil());
            processar(a);
            ultimaPessoa = a;
        } catch (EntradaInvalidaException e) {
            System.out.println("\n[ERRO DE VALIDACAO]: " + e.getMessage());
        }
    }


    // Processa o IMC - polimorfismo em ação
    public void processar(PessoaBase pessoa) {
        double pesoAtual = 0;
        double alturaAtual = 0;
        if (pessoa instanceof Pessoa) {
            pesoAtual = ((Pessoa) pessoa).getPeso();
            alturaAtual = ((Pessoa) pessoa).getAltura();
        } else if (pessoa instanceof Atleta) {
            pesoAtual = ((Atleta) pessoa).getPeso();
            alturaAtual = ((Atleta) pessoa).getAltura();
        }
        double imc = pessoa.calcularIMC(pesoAtual, alturaAtual);
        String classificacao = pessoa.classificarIMC(imc);
        String resultado = "Nome: " + pessoa.getNome() +
                " | IMC: " + String.format("%.2f", imc) +
                " | Classificacao: " + classificacao;
        historico.adicionar(resultado);
        System.out.println(resultado);
    }


    //Delega exibição ao histórico interno
    public void exibirHistorico() {
        historico.exibir();
    }

    // Processa o IMC da última pessoa cadastrada
    public void processarUltima() {
        if (ultimaPessoa == null) {
            System.out.println("Nenhuma pessoa cadastrada!");
        } else {
            processar(ultimaPessoa);
        }
    }
}