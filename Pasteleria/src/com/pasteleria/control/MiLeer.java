package com.pasteleria.control;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MiLeer {

	public final int NULL = 0;
	public final int NOT_NULL = 12;

	public double decimal(String msg, double inf, double sup)
	{
		double resultado = 0.00;
		
		try 
		{
			Scanner teclado = new Scanner(System.in);
			System.out.print (msg);
			resultado = teclado.nextDouble();
			teclado.nextLine();

		} 
		catch (InputMismatchException e) {
			System.out.println("\nValor desconocido, intente otra ves");
		}

		return resultado;	
	}
	public int entero(String msg, int inf, int sup)
	{
		int resultado = 0;
		
		try 
		{
			Scanner teclado = new Scanner(System.in);
			System.out.print (msg);
			resultado = teclado.nextInt();
			teclado.nextLine();

		} 
		catch (InputMismatchException e) {
			System.out.println("\nValor desconocido, intente otra ves");
		}

		return resultado;	
		
	}

	public char caracter(String msg, String valido)
	{
		char resultado = ' ';

		Scanner teclado = new Scanner(System.in);

		System.out.print (msg);
		String texto = teclado.nextLine();
		resultado = texto.charAt(0);
			
		return resultado;		
	}

	public String texto(String msg, int tipo)
	{
		String resultado = null;

		Scanner teclado = new Scanner(System.in);

		System.out.print (msg);
		resultado = teclado.nextLine();

		return resultado;
	}
}

