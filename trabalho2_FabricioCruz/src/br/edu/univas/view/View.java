package br.edu.univas.view;

public class View {

	public void mainMenu() {
		System.out.println("::::Auxiliar de Jogos de Loteria::::\n"
				+ "Por favor, digite a op��o correspondente ao que deseja acessar:\n"
				+ "1. Mega-Sena\n"
				+ "2. Quina\n"
				+ "3. Lotof�cil\n"
				+ "9. Sair\n");
	}
	
	public void subMenu() {
		System.out.println("1. 5 n�meros que mais sa�ram\n"
				+ "2. 5 n�meros que menos sa�ram\n"
				+ "3. Gerar n�meros rand�micos\n"
				+ "4. Verificar meu jogo\n");
	}
	
	public void valorInvalido() {
		System.out.println("Por favor, digite um valor v�lido!\n");
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
