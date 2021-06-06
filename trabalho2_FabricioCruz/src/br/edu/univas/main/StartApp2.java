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
		
		List<Integer> ocorrMega = new ArrayList<>();
		
		//Copia os dados dos jogos pra uma nova lista
		for (int i = 0; i < listaMega.size(); i++) {
			for (int j = 0; j < listaMega.get(i).getLista().size(); j++) {
				
				String s = listaMega.get(i).getLista().get(j);
				int num = Integer.parseInt(s);
				ocorrMega.add(num);
//				ocorrMega.add(listaMega.get(i).getLista().get(j));
			}
		}
		
//		TODO IMPLEMENTAR UM CONTADOR PARA CADA NUMERO E TBM COMO SALVAR O NUMERO COM O COUNTER DELE
//		Verifica os números iguais
//		TODO Resolver duplicados
		List<CountNum> countNum = new ArrayList<>();
		for(int i = 0; i < ocorrMega.size(); i++) {
			CountNum cNum = new CountNum();
			int count = 0;
			cNum.setNum(ocorrMega.get(i));
			for (int j = 0; j < ocorrMega.size(); j++) {
				if(ocorrMega.get(i).equals(ocorrMega.get(j))) {
					count++;
				}
			}
			cNum.setCount(count);
			countNum.add(cNum);
		}
		
		
		int optionMenu;
		int optionSubMenu;
		do {
			vw.mainMenu();
			optionMenu = readInteger(sc);
			validaOpcao(sc, vw, optionMenu);
			
			if(optionMenu == 1) {
				vw.imprimeMega();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, optionMenu, optionSubMenu);
			}
			else if(optionMenu == 2) {
				vw.imprimeQuina();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, optionMenu, optionSubMenu);
			}
			else if(optionMenu == 3) {
				vw.imprimeLoto();
				optionSubMenu = apresentaSubMenu(sc, optionMenu, vw);
				
				direcionaFluxo(sc, vw, optionMenu, optionSubMenu);
			}
			
			
		}while(optionMenu != 9);
		
		sc.close();
		
	}

	private void direcionaFluxo(Scanner sc, View vw, int optionMenu, int optionSubMenu) {
		if(optionSubMenu == 1) {
			
		}
		else if(optionSubMenu == 2) {
			
		}
		else if(optionSubMenu == 3) {
			
			geraNumsAleatorios(optionMenu);
		}
		else if(optionSubMenu == 4) {
			
		}
		
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
