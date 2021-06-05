package br.edu.univas.view;

public class View {

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
	
}
