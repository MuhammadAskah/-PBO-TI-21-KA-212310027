package com.ibik.pbo.praktikum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Latihan01 extends JFrame {
	Latihan01() {
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setSize(300, 150);
		setTitle("Latihan01");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GenerateUI(this);
	}

	public static void main(String[] args) {
		new Latihan01();
	}

	private void GenerateUI(Latihan01 frame) {
		JButton button1 = new JButton(" 你好 ");
		JButton button2 = new JButton("Everyone");
		JButton button3 = new JButton("IBIK");

		// set posisi X dan Y pada komponen button
		button1.setBounds(75, 30, 70, 30);
		button2.setBounds(150, 30, 70, 30);
		button3.setBounds(115, 70, 70, 30);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "is a word for 'Hello'");
			}
		});

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "is a word for 'Everyone'");
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"IBIK is an acronym for 'Institute Bisnis dan Informatika Kesatuan'");
			}
		});
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.setLayout(null);
	}

}
