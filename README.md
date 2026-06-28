# Calculadora IMC

Disciplina: Programação Orientada a Objetos Professor: Romes - Instituição: UniCEUB — Centro Universitário de Brasília

Aluno: Paulo Vitor David Trindade - RA: 72600985 E-mail: paulo.trindade@sempreceub.com

Sistematização da disciplina Programação Orientada a Objetos — UniCEUB, Campus Virtual, turma B.

Sistema de cálculo de IMC desenvolvido em Java, demonstrando os fundamentos de POO via Maven.

## Pré-Requisitos
- Java 17 ou superior
- Maven 3.8 ou superior

## Como Compilar
Abra o terminal na pasta raiz do projeto (onde está o pom.xml) e execute:
mvn package

## Como Executar
Após compilar, execute:
java -jar target/calculadora-imc-poo-sistematizacao-1.jar

## Demonstração de Uso
Ao executar o programa, o seguinte menu será exibido:

===== CALCULADORA IMC =====
1. Cadastrar Pessoa
2. Cadastrar Atleta
3. Calcular e exibir IMC
4. Exibir Histórico
0. Sair
   Escolha uma opção: 1

Nome: Paulo
Idade: 29
Peso (kg): 90
Altura (m): 1,90

Nome: Paulo | Idade: 29 | IMC: 24,93 | Situacao: Normal
Nome: Paulo | IMC: 24,93 | Classificacao: Normal

===== CALCULADORA IMC =====
Escolha uma opção: 2

Nome: JK
Idade: 24
Peso (kg): 82
Altura (m): 1.73
Modalidade: futebol

Nome: JK | Idade: 24 | IMC: 27,40 | Situacao: Acima do ideal para atleta | Modalidade: futebol
Nome: JK | IMC: 27,40 | Classificacao: Acima do ideal para atleta

## Estrutura do Projeto
- CalculadoraIMC.java — Interface com o contrato de cálculo de IMC
- PessoaBase.java — Classe abstrata com atributos e método abstrato exibirPerfil()
- Pessoa.java — Herança + encapsulamento + implementação da interface
- Atleta.java — Herança multinível + polimorfismo com faixas de IMC específicas
- Historico.java — Composição: armazena e exibe registros de IMC
- SistemaIMC.java — Orquestração: cadastro, processamento e exibição
- CalculadoraRecursiva.java — Recursão: calcula potência sem Math.pow()
- EntradaInvalidaException.java — Exceção personalizada para entradas inválidas
- Main.java — Ponto de entrada e menu interativo via CLI

## Conceitos aplicados

Conceito | Onde aparece no código
Encapsulamento | Atributos private em Pessoa (peso, altura, ativo) com getters e setters com validação
Herança | Pessoa extends PessoaBase reutilizando nome e idade via super()
Herança multinível | Atleta extends Pessoa extends PessoaBase (3 níveis de herança)
Polimorfismo | Atleta sobrescreve classificarIMC() com faixas específicas para atletas
Abstração | PessoaBase é classe abstrata com exibirPerfil(); CalculadoraIMC é interface
Composição | SistemaIMC tem um Historico como atributo interno
Recursão | CalculadoraRecursiva.potencia() calcula potência sem Math.pow() com caso-base exp == 0
Exceção personalizada | EntradaInvalidaException lançada nas validações e capturada em Main e SistemaIMC
Controle de fluxo | Loop while no menu e switch nas opções em Main.java
Instanciação de objetos | new Pessoa() e new Atleta() criados dinamicamente em SistemaIMC

## Conceito praticado
- Validação de entrada nos setters de peso e altura em Pessoa, lançando EntradaInvalidaException para valores inválidos
- Validação de nome e idade no construtor de PessoaBase, impedindo objetos em estado inválido
- Separação de responsabilidades entre as classes: Main gerencia o menu, SistemaIMC orquestra o fluxo, Historico armazena os registros
- Tratamento de exceções com mensagens claras ao usuário, sem encerrar o programa abruptamente
- Fechamento do Scanner com scanner.close() ao final do programa em Main.java
- Reaproveitamento de código via herança, evitando duplicação de atributos e métodos entre Pessoa e Atleta
- Uso de recursão para calcular potência em CalculadoraRecursiva, sem depender de bibliotecas externas como Math.pow()
