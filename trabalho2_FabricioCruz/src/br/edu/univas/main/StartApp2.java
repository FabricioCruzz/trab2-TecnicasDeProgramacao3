package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.vo.Lotofacil;
import br.edu.univas.vo.Mega;
import br.edu.univas.vo.Quina;

public class StartApp2 {
	
	public static void main(String[] args) {
		
		String lotofacil = "resources\\lotofacil.csv";
		String mega = "resources\\mega.csv";
		String quina = "resources\\quina.csv";
		
		List<Lotofacil> listaLoto = new ArrayList<>();
		listaLoto = splitLotofacil(listaLoto, lotofacil);
		
		List<Mega> listaMega = new ArrayList<>();
		listaMega = splitMega(listaMega, mega);
		
		List<Quina> listaQuina = new ArrayList<>();
		listaQuina = splitQuina(listaQuina, quina);
	}
	
	private static List<Lotofacil> splitLotofacil(List<Lotofacil> listaLoto, String jogo) {
		
		BufferedReader br = null;
		String linha = "";
		String divisor = ",";
		
		try {
			br = new BufferedReader(new FileReader(jogo));
		
			while((linha = br.readLine()) != null) {
				
				Lotofacil jogoLoto = new Lotofacil();
				
				String[] nums = linha.split(divisor);
				jogoLoto.setIdJogo(nums[0]);
				jogoLoto.setData(nums[1]);
				
				List<String> lista = new ArrayList<>();
				
				for (int i = 2; i < nums.length; i++) {
					lista.add(nums[i]);
				}
				jogoLoto.setLista(lista);
				listaLoto.add(jogoLoto);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaLoto;
	}
	
	private static List<Mega> splitMega(List<Mega> listaMega, String jogo) {
		
		BufferedReader br = null;
		String linha = "";
		String divisor = ",";
		
		try {
			br = new BufferedReader(new FileReader(jogo));
		
			while((linha = br.readLine()) != null) {
				
				Mega jogoMega = new Mega();
				
				String[] nums = linha.split(divisor);
				jogoMega.setIdJogo(nums[0]);
				jogoMega.setData(nums[1]);
				
				List<String> lista = new ArrayList<>();
				
				for (int i = 2; i < nums.length; i++) {
					lista.add(nums[i]);
				}
				jogoMega.setLista(lista);
				listaMega.add(jogoMega);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaMega;
	}
	
	private static List<Quina> splitQuina(List<Quina> listaQuina, String jogo) {
		
		BufferedReader br = null;
		String linha = "";
		String divisor = ",";
		
		try {
			br = new BufferedReader(new FileReader(jogo));
		
			while((linha = br.readLine()) != null) {
				
				Quina jogoQuina = new Quina();
				
				String[] nums = linha.split(divisor);
				jogoQuina.setIdJogo(nums[0]);
				jogoQuina.setData(nums[1]);
				
				List<String> lista = new ArrayList<>();
				
				for (int i = 2; i < nums.length; i++) {
					lista.add(nums[i]);
				}
				jogoQuina.setLista(lista);
				listaQuina.add(jogoQuina);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return listaQuina;
	}

}
