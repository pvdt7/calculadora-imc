// Herança multinivel: Atleta > Pessoa > PessoaBase
public class Atleta extends Pessoa {

    // Atributo exclusivo para o atleta
    private String modalidade;

    // Construtor que delega os 4 primeiros para pessoa
    public Atleta(String nome, int idade, double peso,
                  double altura, String modalidade) {
        super(nome, idade, peso, altura);
        this.modalidade = modalidade;
    }

    // Polimorfismo - faixas de IMC específicas para atletas
    @Override
    public String classificarIMC(double imc) {
        if (imc < 20.0) return "Abaixo do ideal para atleta";
        else if (imc < 27.0) return "Ideal para atleta";
        else return "Acima do ideal para atleta";
    }

    // Reutiliza exibir o perfil da superclasse e adiciona modalidade
    @Override
    public String exibirPerfil() {
        return super.exibirPerfil() + " | Modalidade: " + modalidade;
    }

    // Getter da modalidade
    public String getModalidade() { return modalidade; }
}