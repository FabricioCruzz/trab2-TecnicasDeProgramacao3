package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import br.edu.univas.view.View;
import br.edu.univas.vo.CountNum;
import br.edu.univas.vo.Lotofacil;
import br.edu.univas.vo.Mega;
import br.edu.univas.vo.Quina;

public class StartApp2 {
	
	public static void main(String[] args) {
		StartApp2 myApp = new StartApp2();
		myApp.run();
	}
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		View vw = new View();
		
		String lotofacil = "resources\\lotofacil.csv";
		String mega = "resources\\mega.csv";
		String quina = "resources\\quina.csv";
		
		List<Mega> listaMega = new ArrayList<>();
		listaMega = splitMega(listaMega, mega);
		
		List<Quina> listaQuina = new ArrayList<>();
		listaQuina = splitQuina(listaQuina, quina);
		
		List<Lotofacil> listaLoto = new ArrayList<>();
		listaLoto = splitLotofacil(listaLoto, lotofacil);	
		
		int optionMenu;
		int optionSubMenu;
		do {
			vw.mainMenu();
			optionMenu = readInteger(sc);
			validaOpcao(sc, vw, optionMenu);
			
			if(optionMenu == 1) {
				vw.imprimeMega();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, listaMega, listaQuina, listaLoto, optionMenu, optionSubMenu);
			}
			else if(optionMenu == 2) {
				vw.imprimeQuina();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, listaMega, listaQuina, listaLoto, optionMenu, optionSubMenu);
			}
			else if(optionMenu == 3) {
				vw.imprimeLoto();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, listaMega, listaQuina, listaLoto, optionMenu, optionSubMenu);
			}
			
			
		}while(optionMenu != 9);
		
		sc.close();
		
	}
	
	private void direcionaFluxo(Scanner sc, View vw, List<Mega> listaMega, List<Quina> listaQuina, List<Lotofacil> listaLoto, int optionMenu, int optionSubMenu) {
		if(optionSubMenu == 1) {
			contabilizaNumerosRepetidos(listaMega, listaQuina, listaLoto, vw, optionMenu, optionSubMenu);
		}
		else if(optionSubMenu == 2) {
			contabilizaNumerosRepetidos(listaMega, listaQuina, listaLoto, vw, optionMenu, optionSubMenu);
		}
		else if(optionSubMenu == 3) {
			geraNumsAleatorios(optionMenu);
		}
		else if(optionSubMenu == 4) {
			verificarJogo(sc, vw, optionMenu);
		}
		
	}

	private void verificarJogo(Scanner sc, View vw, int optionMenu) {
		
		ArrayList<Integer> jogoUsuario = leituraNumerosUsuario(sc, vw, optionMenu);
		
		if(optionMenu == 1) {
			
		}
		else if(optionMenu == 2) {
			
		}
		else {
			
		}
	}

	private ArrayList<Integer> leituraNumerosUsuario(Scanner sc, View vw, int optionMenu) {
		ArrayList<Integer> numsUsuario = new ArrayList<>();
		
		vw.msgQtsNumsLer();
		int qtdNumsJogo = readInteger(sc);
		qtdNumsJogo = validaQtdNumsJogo(sc, vw, qtdNumsJogo, optionMenu);
		
		vw.msgLerNumsUsuario();
		int num;
		for (int i = 0; i < qtdNumsJogo; i++) {
			num = readInteger(sc);
			numsUsuario.add(num);
		}
		return numsUsuario;
	}

	private int validaQtdNumsJogo(Scanner sc, View vw, int qtdNumsJogo, int optionMenu) {
		
		int limiteInicial = 0;
		int limiteFinal = 0;
		if(optionMenu == 1) {
			limiteInicial = 6;
			limiteFinal = 15;
		}
		else if(optionMenu == 2) {
			limiteInicial = 5;
			limiteFinal = 15;
		}
		else {
			limiteInicial = 15;
			limiteFinal = 20;
		}
		boolean validarLeitura = (qtdNumsJogo < limiteInicial || qtdNumsJogo > limiteFinal);
		while(validarLeitura) {
			vw.msgErroQtdInvalida(limiteInicial, limiteFinal);
			qtdNumsJogo = readInteger(sc);
			validarLeitura = (qtdNumsJogo < limiteInicial || qtdNumsJogo > limiteFinal);
			if(!validarLeitura) {
				break;
			}
		}
		return qtdNumsJogo;
	}

	private void contabilizaNumerosRepetidos(List<Mega> listaMega, List<Quina> listaQuina, List<Lotofacil> listaLoto, View vw,
			int optionMenu, int optionSubMenu) {
		
		DecimalFormat df = new DecimalFormat("00");
		int qtd = 5;
		
		if(optionMenu == 1) { // Tipo de Jogo escolhido: Mega Sena
			
			int qtdNumerosMega = 60;
			
			//Copia os dados dos jogos pra uma nova lista
			List<String> numerosMega = new ArrayList<>();		
			for (int i = 0; i < listaMega.size(); i++) {
				for (int j = 0; j < listaMega.get(i).getLista().size(); j++) {
					numerosMega.add(listaMega.get(i).getLista().get(j));
				}
			}
			
			List<CountNum> ocorrenciasMega = new ArrayList<>();
			for (int i = 0; i < qtdNumerosMega; i++) {
				int count = 0;
				CountNum nums = new CountNum();
				String s = df.format(i);
				nums.setNome(s);
				for (int j = 0; j < numerosMega.size(); j++) {
					if(s.equals(numerosMega.get(j).toString())) {
						count++;
					}				
				}
				nums.setCount(count);
				ocorrenciasMega.add(nums);
			}
			
			Collections.sort(ocorrenciasMega);
			
			if(optionSubMenu == 1) { // 5 números qua mais saíram
				vw.numsMaisSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasMega.get(i).toString());
				}
			}
			else { // 5 números que menos saíram
				Collections.reverse(ocorrenciasMega);
				vw.numsMenosSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasMega.get(i).toString());
				}
			}
			
			
		}
		else if(optionMenu == 2) { // Tipo de Jogo escolhido: Quina
			
			int qtdNumerosQuina = 80;
			List<String> numerosQuina = new ArrayList<>();
			
			for (int i = 0; i < listaQuina.size(); i++) {
				for (int j = 0; j < listaQuina.get(i).getLista().size(); j++) {
					numerosQuina.add(listaQuina.get(i).getLista().get(j));
				}
			}
			
			List<CountNum> ocorrenciasQuina = new ArrayList<>();
			for (int i = 0; i < qtdNumerosQuina; i++) {
				int count = 0;
				CountNum nums = new CountNum();
				String s = df.format(i);
				nums.setNome(s);
				for (int j = 0; j < numerosQuina.size(); j++) {
					if(s.equals(numerosQuina.get(j).toString())) {
						count++;
					}				
				}
				nums.setCount(count);
				ocorrenciasQuina.add(nums);
			}
			
			Collections.sort(ocorrenciasQuina);
			
			if(optionSubMenu == 1) { // 5 números qua mais saíram
				vw.numsMaisSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasQuina.get(i).toString());
				}
			}
			else { // 5 números que menos saíram
				Collections.reverse(ocorrenciasQuina);
				vw.numsMenosSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasQuina.get(i).toString());
				}
			}
			
		}
		else { // Tipo de Jogo escolhido: Lotofacil
			
			int qtdNumerosLoto = 25;
			List<String> numerosLoto = new ArrayList<>();
			
			for (int i = 0; i < listaLoto.size(); i++) {
				for (int j = 0; j < listaLoto.get(i).getLista().size(); j++) {
					numerosLoto.add(listaLoto.get(i).getLista().get(j));
				}
			}
			
			List<CountNum> ocorrenciasLoto = new ArrayList<>();
			for (int i = 0; i < qtdNumerosLoto; i++) {
				int count = 0;
				CountNum nums = new CountNum();
				String s = df.format(i);
				nums.setNome(s);
				for (int j = 0; j < numerosLoto.size(); j++) {
					if(s.equals(numerosLoto.get(j).toString())) {
						count++;
					}				
				}
				nums.setCount(count);
				ocorrenciasLoto.add(nums);
			}
			
			Collections.sort(ocorrenciasLoto);
			
			if(optionSubMenu == 1) { // 5 números qua mais saíram
				vw.numsMaisSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasLoto.get(i).toString());
				}
			}
			else { // 5 números que menos saíram
				Collections.reverse(ocorrenciasLoto);
				vw.numsMenosSairam();
				for (int i = 0; i < qtd; i++) {
					System.out.print(ocorrenciasLoto.get(i).toString());
				}
			}
		}
		System.out.println();
	}

	private void geraNumsAleatorios(int optionMenu) {
		Random ran = new Random();
		DecimalFormat df = new DecimalFormat("00");
		Set<Integer> numeros = new HashSet<>();
		int num;
		
		if(optionMenu == 1) {
			for (int i = 0; i < 6; i++) {
				num = ran.nextInt(60);
				numeros.add(num);
				System.out.println(df.format(num));
			}		
		}
		else if(optionMenu == 2) {
			for (int i = 0; i < 15; i++) {
				num = ran.nextInt(80);
				numeros.add(num);
				System.out.println(df.format(num));
			}		
		}
		else {			
			for (int i = 0; i < 20; i++) {
				num = ran.nextInt(26);
				numeros.add(num);
				System.out.println(df.format(num));
			}			
		}
		
	}

	private int apresentaSubMenu(Scanner sc, int optionSubMenu, View vw) {
		vw.subMenu();
		optionSubMenu = readInteger(sc); 
		optionSubMenu = validaOpcaoSubMenu(sc, optionSubMenu, vw);
		return optionSubMenu;
	}

	private int validaOpcaoSubMenu(Scanner sc, int optionSubMenu, View vw) {
		if(optionSubMenu < 1 || optionSubMenu > 4) {
			while(optionSubMenu < 1 || optionSubMenu > 4) {
				vw.valorInvalido();
				vw.subMenu();
				optionSubMenu = readInteger(sc);
			}
		}
		return optionSubMenu;
	}

	// TODO TENTAR RETORNAR List<Loteria> na assinatura da função e dentro trabalhar com o objeto que extende dessa classe. Talvez funcione!
	private static List<Lotofacil> splitLotofacil(List<Lotofacil> listaLoto, String jogo) {
		
		BufferedReader br = null;
		String linha = "";
		String divisor = ",";
		
		try {
			br = new BufferedReader(new FileReader(jogo));
		
			while((linha = br.readLine()) != null) {
				
				Lotofacil jogoLoto = new Lotofacil();
				
				String[] nums = linha.split(divisor);
				List<String> lista = new ArrayList<>();
				for (int i = 0; i < nums.length; i++) {
					if(i == 0) {
						jogoLoto.setIdJogo(nums[i]);						
					}
					if(i == 1) {
						jogoLoto.setData(nums[i]);						
					}
					if(i >= 2) {
						lista.add(nums[i]);						
					}
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

				List<String> lista = new ArrayList<>();
				
				for (int i = 0; i < nums.length; i++) {
				
					if(i == 0) {
						jogoMega.setIdJogo(nums[i]);						
					}
					if(i == 1) {
						jogoMega.setData(nums[i]);						
					}
					if(i >= 2) {
						lista.add(nums[i]);										
					}
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
				List<String> lista = new ArrayList<>();

				for (int i = 0; i < nums.length; i++) {
					if(i == 0) {
						jogoQuina.setIdJogo(nums[i]);
					}
					if(i == 1) {
						jogoQuina.setData(nums[i]);
					}
					if(i >= 2) {
						lista.add(nums[i]);						
					}
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
	
	private static int readInteger(Scanner sc) {
		int num = sc.nextInt();
		sc.nextLine();		
		return num;
	}
	
	private void validaOpcao(Scanner sc, View vw, int optionMenu) {
		if(optionMenu < 1 || (optionMenu > 3 && optionMenu != 9)) {
			vw.valorInvalido();
			vw.mainMenu();
			optionMenu = readInteger(sc);
		}
		
	}

}
