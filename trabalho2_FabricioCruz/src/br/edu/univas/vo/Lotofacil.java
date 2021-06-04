package br.edu.univas.vo;

public class Lotofacil extends Loteria {
	
	
	@Override
	public String toString() {
		return "ID Jogo: " + getIdJogo() + "\nData do Jogo: " + getData() + "\nNúmeros do Jogo: " + getLista();
	}
	
}
