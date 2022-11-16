package Praktikum02;

import java.util.Scanner;

class Resto {
	private long harga;

	public void chooseMenu(int menu) {
		switch (menu) {
		case 1:
			System.out.println("Anda memesan Nasi Goreng dengan harga Rp." + getPrices(menu) + ",-");
			break;

		case 2:
			System.out.println("Anda memesan Bubur Ayam dengan harga Rp." + getPrices(menu) + ",-");
			break;

		case 3:
			System.out.println("Anda memesan Soto Ayam dengan harga Rp." + getPrices(menu) + ",-");
			break;

		default:
			System.out.println("Maaf menu yang anda masukkan salah");
			break;
		}
	}

	private long getPrices(int menu) {
		if (menu == 1) {
			harga = 4000;
		} else if (menu == 2) {
			harga = 9000;
		} else if (menu == 3) {
			harga = 12000;
		}
		return harga;
	}
}

public class Latihan07 {
	public static void main(String[] args) {
		Resto resto = new Resto();

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

			resto.chooseMenu(pilihan);

			System.out.println();

			System.out.print("Apakah anda akan memesan kembali (y/n)? ");
			ulang = input.next().charAt(0);

			System.out.println();
		} while (ulang != 'n');

		System.out.println("Terima Kasih");
		input.close();
	}
}
