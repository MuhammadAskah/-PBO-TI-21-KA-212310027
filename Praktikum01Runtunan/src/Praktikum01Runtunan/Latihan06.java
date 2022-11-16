package Praktikum01Runtunan;

import java.util.Scanner;

public class Latihan06 {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String Usia, Firstname, Lastname, NPM;
		
		System.out.print("Masukkan Usia \t\t: ");
		Usia = input.nextLine();
		
		System.out.print("Masukkan Firstname \t: ");
		Firstname = input.nextLine();
		
		System.out.print("Masukkan Lastname  \t: ");
		Lastname = input.nextLine();
		
		System.out.print("Masukkan NPM \t\t: ");
		NPM = input.nextLine();
		
		System.out.println(Usia.concat(Firstname).concat(Lastname.concat(NPM)));
		
		input.close();
	}

}

