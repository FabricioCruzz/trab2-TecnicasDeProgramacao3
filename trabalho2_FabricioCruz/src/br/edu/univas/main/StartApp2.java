package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.univas.view.View;
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
		
		List<String> ocorrMega = new ArrayList<>();
		
		for (int i = 0; i < listaMega.size(); i++) {
			for (int j = 0; j < listaMega.get(i).getLista().size(); j++) {
				ocorrMega.add(listaMega.get(i).getLista().get(j));
			}
		}
		
//		TODO IMPLEMENTAR UM CONTADOR PARA CADA NUMERO E TBM COMO SALVAR O NUMERO COM O COUNTER DELE
		for(int i = 0; i < ocorrMega.size(); i++) {
			for (int j = 0; j < ocorrMega.size(); j++) {
				if(ocorrMega.get(i).equals(ocorrMega.get(j))) {
					
				}
			}
		}
		
		int option;
		do {
			vw.mainMenu();
			option = readInteger(sc);
			validaOpcao(sc, vw, option);
			
			if(option == 1) {
				vw.imprimeMega();
				option = apresentaSubMenu(sc, option, vw);
				
				direcionaFluxo(option);
			}
			else if(option == 2) {
				vw.imprimeQuina();
				option = apresentaSubMenu(sc, option, vw);
				
				direcionaFluxo(option);
			}
			else if(option == 3) {
				vw.imprimeLoto();
				option = apresentaSubMenu(sc, option, vw);
				
				direcionaFluxo(option);
			}
			
			
		}while(option != 9);
		
		sc.close();
		
	}

	private void direcionaFluxo(int option) {
		if(option == 1) {
			
		}
		else if(option == 2) {
			
		}
		else if(option == 3) {
			
		}
		else if(option == 4) {
			
		}
		
	}

	private int apresentaSubMenu(Scanner sc, int option, View vw) {
		vw.subMenu();
		option = readInteger(sc); 
		option = validaOpcaoSubMenu(sc, option, vw);
		return option;
	}

	private int validaOpcaoSubMenu(Scanner sc, int option, View vw) {
		if(option < 1 || option > 4) {
			while(option < 1 || option > 4) {
				vw.valorInvalido();
				vw.subMenu();
				option = readInteger(sc);
			}
		}
		return option;
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
	
	private void validaOpcao(Scanner sc, View vw ,int option) {
		if(option < 1 || (option > 3 && option != 9)) {
			vw.valorInvalido();
			vw.mainMenu();
			option = readInteger(sc);
		}
		
	}

}
