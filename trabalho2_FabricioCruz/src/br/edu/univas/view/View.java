package br.edu.univas.view;

public class View {

//	TODO Fazer essa classe static, pra não precisar criar objeto
	public void mainMenu() {
		System.out.println("::::Auxiliar de Jogos de Loteria::::\n"
				+ "Por favor, digite a opção correspondente ao que deseja acessar:\n"
				+ "1. Mega-Sena\n"
				+ "2. Quina\n"
				+ "3. Lotofácil\n"
				+ "9. Sair\n");
	}
	
	public void subMenu() {
		System.out.println("1. 5 números que mais saíram\n"
				+ "2. 5 números que menos saíram\n"
				+ "3. Gerar números randômicos\n"
				+ "4. Verificar meu jogo\n");
	}
	
	public void valorInvalido() {
		System.out.println("Por favor, digite um valor válido!\n");
	}
	
	public void imprimeMega() {
		System.out.println("::::MEGA-SENA::::");
	}
	
	public void imprimeQuina() {
		System.out.println("::::QUINA::::");
	}
	
	public void imprimeLoto() {
		System.out.println("::::LOTOFACIL::::");
	}
	
	public void menuRandom() {
		System.out.println("Para qual jogo deseja os números aleatórios?");
		System.out.println("1. Mega-Sena\n"
						+ "2. Quina\n"
						+ "3. Lotofácil");
	}
	
	public void numsMaisSairam () {
		System.out.println("Estes foram os 5 números que mais saíram:");
	}
	
	public void numsMenosSairam () {
		System.out.println("Estes foram os 5 números que menos saíram:");
	}
	
	public void msgQtsNumsLer() {
		System.out.println("Quantos números você deseja marcar?");
	}
	
	public void msgLerNumsUsuario() {
		System.out.println("Agora digite, por favor, os números do seu jogo:");
	}
	
	public void msgErroQtdInvalida(int limiteInicial, int limiteFinal) {
		System.out.println("Erro! Você deve digitar uma quantidade de números entre " +  limiteInicial + " e " + limiteFinal + "!");
		System.out.println("Por favor, informe novamente a quantidade:");
	}
}
