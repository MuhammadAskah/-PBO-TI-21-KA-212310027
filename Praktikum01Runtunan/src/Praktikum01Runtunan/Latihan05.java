package Praktikum01Runtunan;

import java.util.Scanner;

public class Latihan05 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String kalimat;
		
		System.out.print("Masukkan sebuah kalimat acak = ");
		kalimat = input.nextLine();
		
		System.out.println("\nKalimat dengan huruf kecil = " + kalimat);
		System.out.println("Kalimat dengan huruf besar = " + kalimat.toUpperCase());
		
		input.close();
	}

}