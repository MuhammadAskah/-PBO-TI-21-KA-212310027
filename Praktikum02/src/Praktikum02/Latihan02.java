package Praktikum02;

import java.util.Scanner;

public class Latihan02 {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		System.out.println("## Cek Bilangan Prima ##");
		System.out.println();

		int n, i;
		boolean angka_prima = true;

		System.out.print("Masukkan NPM Anda: ");
		n = input.nextInt();
		input.close();
		if (n == 0 || n == 1) {
			angka_prima = false;
		} else {
			for (i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					angka_prima = false;
					break;
				}
			}
		}
		
		
		if (angka_prima)
			System.out.println(n + " Termasuk Bilangan PRIMA");
		else
			System.out.println(n + " Bukan termasuk bilangan prima karna dapat dibagi dengan 2");
	}
}
