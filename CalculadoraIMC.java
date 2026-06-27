//Interface de contrato para cálculo do IMC
public interface CalculadoraIMC {

 //Calcula o IMC a partir do peso e altura
 double calcularIMC(double peso, double altura);

 // Retorna a classificação de texto do IMC
 String classificarIMC(double imc);
}