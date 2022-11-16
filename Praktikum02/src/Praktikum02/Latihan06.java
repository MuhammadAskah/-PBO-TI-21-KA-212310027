package Praktikum02;

import java.util.Scanner;

public class Latihan06 {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int pilihan;
		char ulang;

		do {
			System.out.println("##  Menu Minuman: ##");
			System.out.println("============================");
			System.out.println("1. Teh Manis Jumbo");
			System.out.println("2. Susu Straberry Jumbo");
			System.out.println("3. GreenTea Jumbo");
			System.out.println();

			System.out.print("Pilihan anda: ");
			pilihan = input.nextInt();

			switch (pilihan) {
			case 1:
				System.out.println("Anda memesan Nasi Goreng dengan harga Rp4.000,-");
				break;
			case 2:
				System.out.println("Anda memesan Nasi Goreng dengan harga Rp9.000,-");
				break;
			case 3:
				System.out.println("Anda memesan Nasi Goreng dengan harga 12.000,-");
				break;
			default:
				System.out.println("Maaf menu yang anda masukan salah.");
			}

			System.out.println();

			System.out.print("Ingin memilih menu lain (y/n)? ");
			ulang = input.next().charAt(0);

			System.out.println();
		} while (ulang != 'n');

		System.out.println("Terima Kasih");
		input.close();
	}
}
