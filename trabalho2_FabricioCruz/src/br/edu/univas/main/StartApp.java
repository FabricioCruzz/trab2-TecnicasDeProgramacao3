package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import br.edu.univas.vo.*;


public class StartApp {
	
	
	public static void main(String[] args) {
		Random r = new Random();
		DecimalFormat df = new DecimalFormat("00");
//		
//		int x = r.nextInt(2);
//		System.out.println(x);
		
		Set<Integer> nums = new HashSet<>();
		for (int i = 0; i < 20; i++) {
			int num = r.nextInt(26);
			nums.add(num);
			System.out.println(df.format(num));
//			String s = form.format(num);
		}
		
//		for (int i = 0; i < 20; i++) {
//			int y = 1;
//			String s = df.format(y);
//			System.out.println(s);
//		}
//		for (int i = 0; i < 16; i++) {			
//			Integer n = 1 + (int) (Math.random() * 25);
//			System.out.println(n);
//		}
		
//		Gerando nums aleatórios sem random e usando Colletion.shuffle
//		for (int i = 0; i < 25; i++) {
//			jgRandom.add(i);
//		}
//	
//		Collections.shuffle(jgRandom);
//	
//		for (int i = 0; i < 20; i++) {
//			System.out.print(jgRandom.get(i) + ",");
//		}
		
	}
	
//	public static void main(String[] args) {
//		
//		StartApp myApp = new StartApp();
//		myApp.inicializador();
//	}
	
//	private void inicializador() {
//		
//		String lotofacil = "resources\\lotofacil.csv";
//		String mega = "resources\\mega.csv";
//		String quina = "resources\\quina.csv";
//		
//		List<Lotofacil> loto = fazSplit(lotofacil);
//		
////		TODO Procurar saber porque imprime o hashCode ao invés do conteúdo
////		ArrayList<String[]> loto = fazSplit(lotofacil);
//		ArrayList<String[]> ms = fazSplit(mega);
//		ArrayList<String[]> qui = fazSplit(quina);
//		
////		for (int i = 0; i < loto.size(); i++) {
////			System.out.println(loto.get(i));
////		}
//		
//		int i = 0;
//		while(true) {
//			for (int j = 0; j < loto.get(i).length; j++) {
//				System.out.println(loto.get(i)[j]);				
//			}
//			i++;
//			if(i == 17) {
//				i = 0;
//				continue;
//			}
//		}
//		
//	}
//	
//	private ArrayList<String[]> fazSplit(String arq) {
//		BufferedReader br = null;
//		String linha = "";
//		String divisor = ",";
//		ArrayList<String> array = new ArrayList<>();
//		
//		try {
//			br = new BufferedReader(new FileReader(arq));
//		
//			while((linha = br.readLine()) != null) {
//
//				array.add(linha.split(divisor));
//			}			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if(br != null) {
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return array;
//	}

}
