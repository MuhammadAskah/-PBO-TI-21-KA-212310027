package Praktikum02;

import java.util.Scanner;

public class Latihan05 {
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.print("input bintang => ");
		int bintang = x.nextInt();
		int jmlbris = 0;
		int jmlbriss = 2;
		int j, k, l;
		x.close();
		while (jmlbris <= bintang - 1) {
			j = 1;
			k = 0;
			l = 1;
			while (j <= bintang - jmlbris) {
				System.out.print("*");
				j++;
			}
			while (k <= 2 * jmlbris) {
				System.out.print(" ");
				k++;
			}
			while (l <= bintang - jmlbris) {
				System.out.print("*");
				l++;
			}
			System.out.println("");
			jmlbris++;
		}

		while (jmlbriss <= bintang) {
			int a = 1;
			int b = jmlbriss;
			int c = 1;
			while (a <= jmlbriss) {
				System.out.print("*");
				a++;
			}
			while (b <= bintang * 2 - jmlbriss) {
				System.out.print(" ");
				b++;
			}

			while (c <= jmlbriss) {
				System.out.print("*");
				c++;
			}
			
			System.out.println("");
			jmlbriss++;

		}
		System.out.println("");
	}
}
