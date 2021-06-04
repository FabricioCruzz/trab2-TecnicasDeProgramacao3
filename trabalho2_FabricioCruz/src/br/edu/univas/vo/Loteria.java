package br.edu.univas.vo;

import java.util.ArrayList;
import java.util.List;

public abstract class Loteria {
	
	private String idJogo;
	private String data;
	private List<String> numJogos = new ArrayList<>();

	public String getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(String idJogo) {
		this.idJogo = idJogo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<String> getLista() {
		return numJogos;
	}

	public void setLista(List<String> lista) {
		this.numJogos = lista;
	}
	
	

}
