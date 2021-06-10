package br.edu.univas.view;

public class View {

	public static void mainMenu() {
		System.out.println("::::Auxiliar de Jogos de Loteria::::\n"
				+ "Por favor, digite a op��o correspondente ao que deseja acessar:\n"
				+ "1. Mega-Sena\n"
				+ "2. Quina\n"
				+ "3. Lotof�cil\n"
				+ "9. Sair\n");
	}
	
	public static void subMenu() {
		System.out.println("1. 5 n�meros que mais sa�ram\n"
				+ "2. 5 n�meros que menos sa�ram\n"
				+ "3. Gerar n�meros rand�micos\n"
				+ "4. Verificar meu jogo\n");
	}
	
	public static void valorInvalido() {
		System.out.println("Por favor, digite um valor v�lido!\n");
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
		System.out.println("Para qual jogo deseja os n�meros aleat�rios?");
		System.out.println("1. Mega-Sena\n"
						+ "2. Quina\n"
						+ "3. Lotof�cil");
	}
	
	public static void numsMaisSairam () {
		System.out.println("Estes foram os 5 n�meros que mais sa�ram:");
	}
	
	public static void numsMenosSairam () {
		System.out.println("Estes foram os 5 n�meros que menos sa�ram:");
	}
	
	public static void msgQtsNumsLer() {
		System.out.println("Quantos n�meros voc� deseja marcar?");
	}
	
	public static void msgLerNumsUsuario() {
		System.out.println("Agora digite, por favor, os n�meros do seu jogo:");
	}
	
	public static void msgErroQtdInvalida(int limiteInicial, int limiteFinal) {
		System.out.println("Erro! Voc� deve digitar uma quantidade de n�meros entre " +  limiteInicial + " e " + limiteFinal + "!");
		System.out.println("Por favor, informe novamente a quantidade:");
	}
	
	public static void msgErroNumInvalido(int limite) {
		System.out.println("Erro! Voc� deve digitar um valor entre 0 e " + limite + "!");
		System.out.println("Por favor, informe novamente o valor que deseja:");
	}
	
	public static void msgErroValorRepetido() {
		System.out.println("Erro! Voc� j� digitou este n�mero!");
		System.out.println("Por favor, digite outro n�mero:");
	}
	
	public static void nenhumNumAcertado() {
		System.out.println("Voc� n�o acertou nenhum n�mero!");
	}
	
	public static void numsAcertados(String s, int valor) {
		System.out.println("Jogo N�:" + s);
		System.out.println("N�meros que voc� acertaria: " + valor);
	}
	
	public static void msgNumsRandomicos() {
		System.out.println("Esses s�o os seus n�meros:");
	}
	
	public static void imprimeRandomicos(String s) {
		System.out.print("[" + s + "] ");
	}
}
