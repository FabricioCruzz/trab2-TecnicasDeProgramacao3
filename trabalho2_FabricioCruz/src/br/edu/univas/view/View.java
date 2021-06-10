package br.edu.univas.view;

public class View {

	public static void mainMenu() {
		System.out.println("::::Auxiliar de Jogos de Loteria::::\n"
				+ "Por favor, digite a opção correspondente ao que deseja acessar:\n"
				+ "1. Mega-Sena\n"
				+ "2. Quina\n"
				+ "3. Lotofácil\n"
				+ "9. Sair\n");
	}
	
	public static void subMenu() {
		System.out.println("1. 5 números que mais saíram\n"
				+ "2. 5 números que menos saíram\n"
				+ "3. Gerar números randômicos\n"
				+ "4. Verificar meu jogo\n");
	}
	
	public static void valorInvalido() {
		System.out.println("Por favor, digite um valor válido!\n");
	}
	
	public static void imprimeMega() {
		System.out.println("::::MEGA-SENA::::");
	}
	
	public static void imprimeQuina() {
		System.out.println("::::QUINA::::");
	}
	
	public static void imprimeLoto() {
		System.out.println("::::LOTOFACIL::::");
	}
	
	public static void menuRandom() {
		System.out.println("Para qual jogo deseja os números aleatórios?");
		System.out.println("1. Mega-Sena\n"
						+ "2. Quina\n"
						+ "3. Lotofácil");
	}
	
	public static void numsMaisSairam () {
		System.out.println("Estes foram os 5 números que mais saíram:");
	}
	
	public static void numsMenosSairam () {
		System.out.println("Estes foram os 5 números que menos saíram:");
	}
	
	public static void msgQtsNumsLer() {
		System.out.println("Quantos números você deseja marcar?");
	}
	
	public static void msgLerNumsUsuario() {
		System.out.println("Agora digite, por favor, os números do seu jogo:");
	}
	
	public static void msgErroQtdInvalida(int limiteInicial, int limiteFinal) {
		System.out.println("Erro! Você deve digitar uma quantidade de números entre " +  limiteInicial + " e " + limiteFinal + "!");
		System.out.println("Por favor, informe novamente a quantidade:");
	}
	
	public static void msgErroNumInvalido(int limite) {
		System.out.println("Erro! Você deve digitar um valor entre 0 e " + limite + "!");
		System.out.println("Por favor, informe novamente o valor que deseja:");
	}
	
	public static void msgErroValorRepetido() {
		System.out.println("Erro! Você já digitou este número!");
		System.out.println("Por favor, digite outro número:");
	}
	
	public static void nenhumNumAcertado() {
		System.out.println("Você não acertou nenhum número!");
	}
	
	public static void numsAcertados(String s, int valor) {
		System.out.println("Jogo Nº:" + s);
		System.out.println("Números que você acertaria: " + valor);
	}
	
	public static void msgNumsRandomicos() {
		System.out.println("Esses são os seus números:");
	}
	
	public static void imprimeRandomicos(String s) {
		System.out.print("[" + s + "] ");
	}
}
