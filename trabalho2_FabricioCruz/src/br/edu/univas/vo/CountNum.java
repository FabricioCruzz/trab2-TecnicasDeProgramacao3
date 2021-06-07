package br.edu.univas.vo;

public class CountNum implements Comparable<CountNum> {
	
	private String nome;
	private int count;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "[" + getNome() + "] ";
	}

	@Override
	public int compareTo(CountNum numComp) {
		return (numComp.getCount() - this.count);
	}	
}
