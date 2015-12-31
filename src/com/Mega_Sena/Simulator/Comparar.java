package com.Mega_Sena.Simulator;

import java.util.Arrays;

public class Comparar {
	
	// Captando e dividindo o palpite do usuário
	static String palpiteDoUsuario;
	static String[] dividir;
	static String separador = " - ";
	
	// Verificando se o jogo é válido
	static boolean jogoValido = true;
	
	// Separando o palpite do usuário para comparação com números sorteados
	static String primeiroPalpite;
	static String segundoPalpite;
	static String terceiroPalpite;
	static String quartoPalpite;
	static String quintoPalpite;
	static String sextoPalpite;
	
	// Conversão dos palpites de String para Integer e adicionando ao array para organização
	static int primeiroPalpiteInt;
	static int segundoPalpiteInt;
	static int terceiroPalpiteInt;
	static int quartoPalpiteInt;
	static int quintoPalpiteInt;
	static int sextoPalpiteInt;
	static int[] arrayDePalpites;
	
	// Verificando se há palpites repetidos
	static boolean palpiteValido = true;
	
	// Captando números sorteados
	static int primeiroSorteado;
	static int segundoSorteado;
	static int terceiroSorteado;
	static int quartoSorteado;
	static int quintoSorteado;
	static int sextoSorteado;
	
	// Convertendo de volta para String e sumarizando
	static String primeiroPalpiteFinal;
	static String segundoPalpiteFinal;
	static String terceiroPalpiteFinal;
	static String quartoPalpiteFinal;
	static String quintoPalpiteFinal;
	static String sextoPalpiteFinal;
	static String sumarizando;
	
	// Contador de acertos
	static int acertos = 0;
	
	public static String Separando() {
		palpiteDoUsuario = MegaSenaSimulator.palpite;
		dividir = palpiteDoUsuario.split(" - ");
		
		primeiroPalpite = dividir[0];
		segundoPalpite = dividir[1];
		terceiroPalpite = dividir[2];
		quartoPalpite = dividir[3];
		quintoPalpite = dividir[4];
		sextoPalpite = dividir[5];
		
		// Convertendo de String para Int
		primeiroPalpiteInt = Integer.parseInt(primeiroPalpite);
		segundoPalpiteInt = Integer.parseInt(segundoPalpite);
		terceiroPalpiteInt = Integer.parseInt(terceiroPalpite);
		quartoPalpiteInt = Integer.parseInt(quartoPalpite);
		quintoPalpiteInt = Integer.parseInt(quintoPalpite);
		sextoPalpiteInt = Integer.parseInt(sextoPalpite);
		
		// Verificação de números inválidos
		if (primeiroPalpiteInt == 00 || primeiroPalpiteInt > 60) {
			jogoValido = false;
		}
		if (segundoPalpiteInt == 00 || segundoPalpiteInt > 60) {
			jogoValido = false;
		}
		if (terceiroPalpiteInt == 00 || terceiroPalpiteInt > 60) {
			jogoValido = false;
		}
		if (quartoPalpiteInt == 00 || quartoPalpiteInt > 60) {
			jogoValido = false;
		}
		if (quintoPalpiteInt == 00 || quintoPalpiteInt > 60) {
			jogoValido = false;
		}
		if (sextoPalpiteInt == 00 || sextoPalpiteInt > 60) {
			jogoValido = false;
		}
		
		// Verificação de repetição
		if (primeiroPalpiteInt == segundoPalpiteInt || primeiroPalpiteInt == terceiroPalpiteInt || primeiroPalpiteInt == quartoPalpiteInt || primeiroPalpiteInt == quintoPalpiteInt || primeiroPalpiteInt == sextoPalpiteInt) {
			palpiteValido = false;
		}
		if (segundoPalpiteInt == terceiroPalpiteInt || segundoPalpiteInt == quartoPalpiteInt || segundoPalpiteInt == quintoPalpiteInt || segundoPalpiteInt == sextoPalpiteInt) {
			palpiteValido = false;
		}
		if (terceiroPalpiteInt == quartoPalpiteInt || terceiroPalpiteInt == quintoPalpiteInt || terceiroPalpiteInt == sextoPalpiteInt) {
			palpiteValido = false;
		}
		if (quartoPalpiteInt == quintoPalpiteInt || quartoPalpiteInt == sextoPalpiteInt) {
			palpiteValido = false;
		}
		if (quintoPalpiteInt == sextoPalpiteInt) {
			palpiteValido = false;
		}
		
		// Colocando os palpites em um array
		arrayDePalpites = new int[6];
		
		arrayDePalpites[0] = primeiroPalpiteInt;
		arrayDePalpites[1] = segundoPalpiteInt;
		arrayDePalpites[2] = terceiroPalpiteInt;
		arrayDePalpites[3] = quartoPalpiteInt;
		arrayDePalpites[4] = quintoPalpiteInt;
		arrayDePalpites[5] = sextoPalpiteInt;
		
		Arrays.sort(arrayDePalpites);
		
		// Convertendo de volta para String
		primeiroPalpiteFinal = String.valueOf(arrayDePalpites[0]);
		segundoPalpiteFinal = String.valueOf(arrayDePalpites[1]);
		terceiroPalpiteFinal = String.valueOf(arrayDePalpites[2]);
		quartoPalpiteFinal = String.valueOf(arrayDePalpites[3]);
		quintoPalpiteFinal = String.valueOf(arrayDePalpites[4]);
		sextoPalpiteFinal = String.valueOf(arrayDePalpites[5]);
		
		if (primeiroPalpiteFinal.length() == 1) {
			primeiroPalpiteFinal = "0" + primeiroPalpiteFinal;
		}
		if (segundoPalpiteFinal.length() == 1) {
			segundoPalpiteFinal = "0" + segundoPalpiteFinal;
		}
		if (terceiroPalpiteFinal.length() == 1) {
			terceiroPalpiteFinal = "0" + terceiroPalpiteFinal;
		}
		if (quartoPalpiteFinal.length() == 1) {
			quartoPalpiteFinal = "0" + quartoPalpiteFinal;
		}
		if (quintoPalpiteFinal.length() == 1) {
			quintoPalpiteFinal = "0" + quintoPalpiteFinal;
		}
		if (sextoPalpiteFinal.length() == 1) {
			sextoPalpiteFinal = "0" + sextoPalpiteFinal;
		}
		
		sumarizando = primeiroPalpiteFinal + separador + segundoPalpiteFinal + separador + terceiroPalpiteFinal + separador + quartoPalpiteFinal + separador + quintoPalpiteFinal + separador + sextoPalpiteFinal;
		return sumarizando;
	}
	
	public static int Comparando() {
		primeiroSorteado = Sorteio.primeiroNumero;
		segundoSorteado = Sorteio.segundoNumero;
		terceiroSorteado = Sorteio.terceiroNumero;
		quartoSorteado = Sorteio.quartoNumero;
		quintoSorteado = Sorteio.quintoNumero;
		sextoSorteado = Sorteio.sextoNumero;
		
		if (arrayDePalpites[0] == primeiroSorteado || arrayDePalpites[1] == primeiroSorteado || arrayDePalpites[2] == primeiroSorteado || arrayDePalpites[3] == primeiroSorteado || arrayDePalpites[4] == primeiroSorteado || arrayDePalpites[5] == primeiroSorteado) {
			acertos++;
		}
		if (arrayDePalpites[0] == segundoSorteado || arrayDePalpites[1] == segundoSorteado || arrayDePalpites[2] == segundoSorteado || arrayDePalpites[3] == segundoSorteado || arrayDePalpites[4] == segundoSorteado || arrayDePalpites[5] == segundoSorteado) {
			acertos++;
		}
		if (arrayDePalpites[0] == terceiroSorteado || arrayDePalpites[1] == terceiroSorteado || arrayDePalpites[2] == terceiroSorteado || arrayDePalpites[3] == terceiroSorteado || arrayDePalpites[4] == terceiroSorteado || arrayDePalpites[5] == terceiroSorteado) {
			acertos++;
		}
		if (arrayDePalpites[0] == quartoSorteado || arrayDePalpites[1] == quartoSorteado || arrayDePalpites[2] == quartoSorteado || arrayDePalpites[3] == quartoSorteado || arrayDePalpites[4] == quartoSorteado || arrayDePalpites[5] == quartoSorteado) {
			acertos++;
		}
		if (arrayDePalpites[0] == quintoSorteado || arrayDePalpites[1] == quintoSorteado || arrayDePalpites[2] == quintoSorteado || arrayDePalpites[3] == quintoSorteado || arrayDePalpites[4] == quintoSorteado || arrayDePalpites[5] == quintoSorteado) {
			acertos++;
		}
		if (arrayDePalpites[0] == sextoSorteado || arrayDePalpites[1] == sextoSorteado || arrayDePalpites[2] == sextoSorteado || arrayDePalpites[3] == sextoSorteado || arrayDePalpites[4] == sextoSorteado || arrayDePalpites[5] == sextoSorteado) {
			acertos++;
		}
		
		return acertos;
	}
	
	public static void main(String[] args) {
		Separando();
		Comparando();
	}

}
