// Classe com métodos estáticos de recursão e funcões simples
public class CalculadoraRecursiva {

    // Calcula base elevada a exp sem usar Math.pow()
    public static double potencia(double base, int exp) {
        // Caso-base: qualquer numero elevado a 0 e 1
        if (exp == 0) return 1;
        // Passo recursivo: base * base^(exp-1)
        return base * potencia(base, exp - 1);
    }

    // Calcula IMC usando a potencia recursiva
    public static double calcularIMCRecursivo(double peso,
                                              double altura) {
        return peso / potencia(altura, 2);
    }

    // Metodo simples que arredonda valor para 2 casas decimais
    public static double arredondar(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}