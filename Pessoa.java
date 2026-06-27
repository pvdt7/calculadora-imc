// Herda PessoaBase e implementa a interface CalculadoraIMC
public class Pessoa extends PessoaBase implements CalculadoraIMC {

    // Atributos privados - encapsulamento
    private double peso;
    private double altura;
    private boolean ativo;

    // Construtor que delega nome e idade para PessoaBase
    public Pessoa(String nome, int idade, double peso, double altura) {
        super(nome, idade);
        this.peso = peso;
        this.altura = altura;
        this.ativo = true;
    }

    // Calcula IMC usando potencia recursiva
    @Override
    public double calcularIMC(double peso, double altura) {
        return peso / CalculadoraRecursiva.potencia(altura, 2);
    }

    // Classifica o IMC conforme faixas da OMS
    @Override
    public String classificarIMC(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25.0) return "Normal";
        else if (imc < 30.0) return "Sobrepeso";
        else if (imc < 35.0) return "Obesidade grau I";
        else if (imc < 40.0) return "Obesidade grau II";
        else return "Obesidade grau III";
    }

    // Exibe perfil completo com IMC calculado
    @Override
    public String exibirPerfil() {
        double imc = calcularIMC(peso, altura);
        return "Nome: " + nome + " | Idade: " + idade +
                " | IMC: " + String.format("%.2f", imc) +
                " | Situacao: " + classificarIMC(imc);
    }

    // Getters e Setters com validacão
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public boolean getAtivo() { return ativo; }

    // Setter com validacão - peso deve ser positivo
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new EntradaInvalidaException("O peso informado deve ser maior que zero!");
        }
        this.peso = peso;
    }

    // Setter com validacão - altura deve ser positiva
    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new EntradaInvalidaException("A altura informada deve ser maior que zero!");
        }
        this.altura = altura;
    }
}