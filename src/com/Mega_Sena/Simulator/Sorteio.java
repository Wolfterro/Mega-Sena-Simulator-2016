package com.Mega_Sena.Simulator;

import java.util.Random;
import java.util.Arrays;

public class Sorteio {
	
	static int[] numerosSorteados;
	static int primeiroNumero;
	static int segundoNumero;
	static int terceiroNumero;
	static int quartoNumero;
	static int quintoNumero;
	static int sextoNumero;
	
	static String primeiroNumeroS;
	static String segundoNumeroS;
	static String terceiroNumeroS;
	static String quartoNumeroS;
	static String quintoNumeroS;
	static String sextoNumeroS;
	static String separator = " - ";
	static String resultado;
	
	public static String sorteioDaMegaSena() {
		numerosSorteados = new int[6];
		Random sorteio = new Random();
		
		for(int i=0; i < numerosSorteados.length ; i++){
			numerosSorteados[i] = sorteio.nextInt(60) + 1;
		}
		Arrays.sort(numerosSorteados);
		
		primeiroNumero = numerosSorteados[0];
		segundoNumero = numerosSorteados[1];
		terceiroNumero = numerosSorteados[2];
		quartoNumero = numerosSorteados[3];
		quintoNumero = numerosSorteados[4];
		sextoNumero = numerosSorteados[5];
		
		
		if (primeiroNumero == segundoNumero || segundoNumero == terceiroNumero || terceiroNumero == quartoNumero || quartoNumero == quintoNumero || quintoNumero == sextoNumero) {
			sorteioDaMegaSena();
		}
		
		primeiroNumeroS = String.valueOf(primeiroNumero);
		segundoNumeroS = String.valueOf(segundoNumero);
		terceiroNumeroS = String.valueOf(terceiroNumero);
		quartoNumeroS = String.valueOf(quartoNumero);
		quintoNumeroS = String.valueOf(quintoNumero);
		sextoNumeroS = String.valueOf(sextoNumero);
		
		if (primeiroNumeroS.length() == 1) {
			primeiroNumeroS = "0" + primeiroNumeroS;
		}
		if (segundoNumeroS.length() == 1) {
			segundoNumeroS = "0" + segundoNumeroS;
		}
		if (terceiroNumeroS.length() == 1) {
			terceiroNumeroS = "0" + terceiroNumeroS;
		}
		if (quartoNumeroS.length() == 1) {
			quartoNumeroS = "0" + quartoNumeroS;
		}
		if (quintoNumeroS.length() == 1) {
			quintoNumeroS = "0" + quintoNumeroS;
		}
		if (sextoNumeroS.length() == 1) {
			sextoNumeroS = "0" + sextoNumeroS;
		}
		
		resultado = primeiroNumeroS + separator + segundoNumeroS + separator + terceiroNumeroS + separator + quartoNumeroS + separator + quintoNumeroS + separator + sextoNumeroS;
		return resultado;
	}
	
	public static void main(String[] args) {
		sorteioDaMegaSena();
	}

}
