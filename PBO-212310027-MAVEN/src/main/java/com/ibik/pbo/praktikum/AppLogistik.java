package com.ibik.pbo.praktikum;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import org.apache.commons.lang3.math.NumberUtils;

public class AppLogistik {
    public static ArrayList<String> order = new ArrayList<String>();
    public static String menu, MenuN, field, values, output, NoResi;
    public static int i, exit, options, check, hargaOngkir, vberat, vjarak, totalOngkir, hargaBerat, hargaJarak;

    public static void main(String[] args) {
        AppLogistik app = new AppLogistik();
        app.Menu();
    }

    public static void Menu() {
        menu = "Menu : \n";
        menu += "1. Cek Ongkir\n";
        menu += "2. Cek Resi\n";
        menu += "3. Kirim Paket\n";
        menu += "4. Keluar\n\n";

        menu += "Pilih menu: ";

        MenuN = JOptionPane.showInputDialog(null, menu, "Menu",
                JOptionPane.QUESTION_MESSAGE);

        if (MenuN == null) {
            exit = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (exit == 0) {
                JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan jasa pengiriman kami!",
                        "XYZ Expedition",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else if (MenuN.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mohon Masukkan Menu!", "Alert!", JOptionPane.ERROR_MESSAGE);
        } else if (!NumberUtils.isParsable(MenuN)) {
            JOptionPane.showMessageDialog(null, "Mohon Masukkan Angka!", "Alert!", JOptionPane.ERROR_MESSAGE);
            Menu();
        }

        options = Integer.parseInt(MenuN);

        switch (options) {
            case 1:
                CheckOngkir();
                break;

            case 2:
                CheckResi();
                break;

            case 3:
                SendPackage();
                break;
            case 4:
                check = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
                        JOptionPane.YES_NO_OPTION);
                if (check == 0) {
                    JOptionPane.showMessageDialog(null, "Terima kasih!", "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } else {
                    Menu();
                }
                break;
            default:
                break;
        }
    }

    public static void CheckOngkir() {
        order.clear();
        String field[] = { "Berat Barang (gr)", "Jarak Tempuh (km)" };

        for (i = 0; i < field.length; i++) {
            values = JOptionPane.showInputDialog(null, "Masukkan " + field[i],
                    "Cek Ongkir",
                    JOptionPane.QUESTION_MESSAGE);
            if (values == null) {
                exit = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (exit == 0) {
                    JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan jasa pengiriman kami!",
                            "XYZ Expedition",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            } else if (values.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mohon Masukkan Menu!", "Alert!", JOptionPane.ERROR_MESSAGE);
                CheckOngkir();
            } else if (!NumberUtils.isParsable(values)) {
                JOptionPane.showMessageDialog(null, "Mohon Masukkan Angka!", "Alert!", JOptionPane.ERROR_MESSAGE);
                CheckOngkir();
            }
            order.add(values);
        }

        hargaOngkir = MathOngkir(order.get(0), order.get(1));
        order.add(Integer.toString(hargaOngkir));

        output = "";
        output += "Total ongkir : " + formatNumber(hargaOngkir) + "\n";

        JOptionPane.showMessageDialog(null, output, "Cek Ongkir",
                JOptionPane.INFORMATION_MESSAGE);
        Menu();
    }

    public static void SendPackage() {
        order.clear();
        String field[] = { "Berat Barang (gr)", "Jarak Tempuh (km)" };

        for (i = 0; i < field.length; i++) {
            values = JOptionPane.showInputDialog(null, "Masukkan " + field[i],
                    "Cek Ongkir",
                    JOptionPane.QUESTION_MESSAGE);
            if (values == null) {
                exit = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin keluar?", "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if (exit == 0) {
                    JOptionPane.showMessageDialog(null, "Terima kasih telah menggunakan jasa pengiriman kami!",
                            "XYZ Expedition",
                            JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
            } else if (values.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mohon Masukkan Menu!", "Alert!", JOptionPane.ERROR_MESSAGE);
                CheckOngkir();
            } else if (!NumberUtils.isParsable(values)) {
                JOptionPane.showMessageDialog(null, "Mohon Masukkan Angka!", "Alert!", JOptionPane.ERROR_MESSAGE);
                CheckOngkir();
            }
            order.add(values);
        }

        hargaOngkir = MathOngkir(order.get(0), order.get(1));
        order.add(Integer.toString(hargaOngkir));

        NoResi = "XYZ-001";
        order.add(NoResi);

        output = "";
        output += "Total ongkir : " + formatNumber(hargaOngkir) + "\n";
        output += "Resi         : " + order.get(3);

        JOptionPane.showMessageDialog(null, output, "Cek Ongkir",
                JOptionPane.INFORMATION_MESSAGE);
        Menu();
    }

    public static String formatNumber(double num) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp.");
        formatRp.setMonetaryDecimalSeparator('.');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(num);
    }

    public static int MathOngkir(String berat, String jarak) {
         vberat = Integer.parseInt(berat);
         vjarak = Integer.parseInt(jarak);
         totalOngkir = 0;
         hargaBerat = 0;
         hargaJarak = 0;

        hargaBerat = (vberat / 100) * 5000;
        hargaJarak = (vjarak / 10) * 8000;

        totalOngkir = hargaBerat + hargaJarak;

        return totalOngkir;
    }

    public static void CheckResi() {
        if (order.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data Tidak Tersedia!", "Cek Resi",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            NoResi = JOptionPane.showInputDialog(null, "Masukkan No. Resi : ", "Cek Resi",
                    JOptionPane.QUESTION_MESSAGE);
            if (!NoResi.equals(order.get(3))) {
                JOptionPane.showMessageDialog(null, "Resi Tidak Ditemukan!", "Cek Resi",
                        JOptionPane.ERROR_MESSAGE);
            } else if (NoResi.equals(order.get(3))) {
                output = "";
                output += "       Status Pengiriman      \n";
                output += "     ====================   \n\n";
                output += "No Resi Pengiriman : " + order.get(3) + "\n";
                output += "Total Ongkir : " + order.get(2) + "\n";
                output += "Status : Dalam Proses Pengiriman";
                JOptionPane.showMessageDialog(null, output, "XYZ Expedition",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        Menu();
    }
}