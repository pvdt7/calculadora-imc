// Exceção personalizada que herda RuntimeException
// Escolha: RuntimeException pois não exige try/catch obrigatório,
// tornando o código mais limpo para tratar erros de entrada
public class EntradaInvalidaException extends RuntimeException {

    // Construtor que repassa a mensagem para RuntimeException
    public EntradaInvalidaException(String mensagem) {
        super(mensagem);
    }
}