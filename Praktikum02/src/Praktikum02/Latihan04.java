package Praktikum02;

import java.util.Scanner;

public class Latihan04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Faktorisasi Bilangan Secara Descending\n");

        System.out.print("Masukkan bilangan : ");
        int bil = input.nextInt();
        
        if (bil < 20) {
            System.out.println("Maaf bilangan kurang dari 20");
        } else {
            int n = bil;
            for (int i = bil; i >= 1; i--) {
                if (bil % n == 0) {
                	System.out.print(n + " ");
                }
                n--;
            }
        }
        input.close();
    }


}
