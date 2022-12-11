package com.ibik.pbo.praktikum;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AppBukuTelp {
	public static void main(String[] args) {
		AppBukuTelp app = new AppBukuTelp();
        app.isi();
       
	}
	
	public void isi() {
		ArrayList<String> field = new ArrayList<String>();
        field.add("Nama Lengkap");
        field.add("Alamat");
        field.add("No. Telp");
		
		ArrayList<ArrayList<String>> x = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < field.size(); i++) {
			x.add(new ArrayList<String>());
			for (int j = 0; j < field.size(); j++) {
				String data = JOptionPane.showInputDialog(null, "Masukan " + field.get(j) + ":",
						"Data array ke - " + (i + 1), JOptionPane.QUESTION_MESSAGE);
				x.get(i).add(j, data);
			}
		}

		String output = "";

		for (int i = 0; i < field.size(); i++) {
			output += "Data ke - " + (i + 1) + "\n";
			for (int j = 0; j < field.size(); j++) {
				output += field.get(j) + ": " + x.get(i).get(j) + "\n";
			}
			output += "\n";
		}

		JOptionPane.showMessageDialog(null, output, "Data", JOptionPane.INFORMATION_MESSAGE);
	}
}