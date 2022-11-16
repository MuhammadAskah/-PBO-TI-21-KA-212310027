package Praktikum01Runtunan;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Latihan04 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDateTime waktuSekarang = LocalDateTime.now();
        DateTimeFormatter formatWaktu = DateTimeFormatter.ofPattern("dd MMM yyyy (HH:mm)");
        String waktu = waktuSekarang.format(formatWaktu);
        
        double hargaRoti = 6300;
        double jumlahBeli;
        double totalHarga;
        double diskon;
        double subTotal;

        System.out.println("================== =================");
        System.out.println("\tTOKO SERBAGUNA IBIK");
        System.out.print("===================================\n");
        System.out.print("Masukkan jumlah produk yang dibeli = ");
        
        jumlahBeli = input.nextInt();
        totalHarga = hargaRoti * jumlahBeli;

        System.out.print("\n");

        System.out.println(waktu);
        System.out.println("ITEM \t\tQTY \t\tHARGA \t\tTOTAL");
        System.out.println("===========================================================");

        System.out.println("ROTI ENAK. \t" + jumlahBeli + "\t\tRp " + hargaRoti + "\tRp " + totalHarga);
        System.out.println("------------------------------------------------------------");

        if(jumlahBeli % 3 == 0) {
            diskon = 0.05 * totalHarga;
            subTotal = totalHarga - diskon;
            System.out.println("Diskon: 5%");
        } else {
            diskon = 0.1 * totalHarga;
            subTotal = totalHarga - diskon;
            System.out.println("Diskon: 10%");
        }

        System.out.println("Sub Total = Rp " + subTotal);

        input.close();
    }

}
