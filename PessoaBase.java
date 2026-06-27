// Classe abstrata que serve de molde para pessoa e atleta
public abstract class PessoaBase implements CalculadoraIMC {

    // Atributos acessíveis pelas subclasses
    protected String nome;
    protected int idade;

    // Construtor com validação de entrada
    public PessoaBase(String nome, int idade) throws EntradaInvalidaException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new EntradaInvalidaException("O nome nao pode estar vazio.");
        }
        if (idade <= 0) {
            throw new EntradaInvalidaException("A idade deve ser maior que zero.");
        }
        this.nome = nome;
        this.idade = idade;
    }

    //Getters herdados por todas as subclasses
    public String getNome() { return nome; }
    public int getIdade() { return idade; }

    // Metodo abstrato que cada subclasse deve implementar
    public abstract String exibirPerfil();
}