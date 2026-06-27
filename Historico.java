import java.util.ArrayList;
import java.util.List;

// Classe de composicão que armazena e exibe registros de IMC
public class Historico {

    // Lista inicializada na declaração
    private List<String> registros = new ArrayList<>();

    // Adiciona um novo registro a lista
    public void adicionar(String registro) { registros.add(registro); }

    // Exibe todos os registros e usa for-each
    public void exibir() {
        if (registros.isEmpty()) {
            System.out.println("Historico vazio.");
            return;
        }
        System.out.println("\n===== HISTORICO =====");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }

    // Retorna o total de registros
    public int tamanho() { return registros.size(); }
}