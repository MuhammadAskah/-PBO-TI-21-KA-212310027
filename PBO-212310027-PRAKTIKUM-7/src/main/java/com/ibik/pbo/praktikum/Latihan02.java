package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Latihan02 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Latihan02() {
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
		setSize(310, 370);
		setTitle("Latihan 02");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GenerateUI(this);
	}

	public static void main(String[] args) {
		new Latihan02();
	}

	private void GenerateUI(Latihan02 frame) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		frame.setContentPane(mainPanel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		mainPanel.add(panel1, BorderLayout.NORTH);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setBounds(22, 23, 80, 16);
		panel1.add(lblFullname);
		final JTextField textFullname = new JTextField();
		textFullname.setBounds(105, 18, 169, 30);
		panel1.add(textFullname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 69, 61, 16);
		panel1.add(lblEmail);

		final JTextField textEmail = new JTextField();
		textEmail.setBounds(105, 64, 169, 30);
		panel1.add(textEmail);
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(22, 109, 61, 16);
		panel1.add(lblPhone);

		final JTextField txtPhone = new JTextField();
		txtPhone.setBounds(105, 104, 169, 30);
		panel1.add(txtPhone);

		final JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(22, 150, 61, 16);
		panel1.add(lblGender);
		final JRadioButton radioGender1 = new JRadioButton("Female");
		radioGender1.setBounds(105, 145, 100, 30);
		panel1.add(radioGender1);
		final JRadioButton radioGender2 = new JRadioButton("Male");
		radioGender2.setBounds(200, 145, 100, 30);
		panel1.add(radioGender2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioGender1);
		bg.add(radioGender2);

		JLabel lblCityzen = new JLabel("Citizenship");
		lblCityzen.setBounds(22, 185, 100, 16);
		panel1.add(lblCityzen);
		String country[] = { "Indonesia", "India", "Australia", "U.S.A", "England", "Newzealand" };
		final JComboBox selectCitizen = new JComboBox(country);
		selectCitizen.setBounds(105, 180, 169, 30);
		panel1.add(selectCitizen);

		JCheckBox chkRemember = new JCheckBox("Remember account ?");
		chkRemember.setBounds(105, 220, 169, 40);
		panel1.add(chkRemember);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(105, 260, 169, 40);
		panel1.add(btnSubmit);
		frame.add(panel1);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> out = new ArrayList<String>();

				String nama = textFullname.getText();
				String email = textEmail.getText();
				String phone = txtPhone.getText();

				String output = "";

				if (nama.isBlank() || email.isBlank() || phone.isBlank()) {

					JOptionPane.showMessageDialog(null, "Data tidak boleh kosong. Silakan periksa kembali isian anda.");
				} else {
					out.add(nama);
					out.add(email);
					out.add(phone);
				}

				if (!radioGender1.isSelected() && !radioGender2.isSelected()) {
					JOptionPane.showMessageDialog(null, "Data tidak boleh kosong. Silakan periksa kembali isian anda.");

				} else if (radioGender1.isSelected()) {
					out.add(radioGender1.getText());
				} else if (radioGender2.isSelected()) {
					out.add(radioGender1.getText());
				}

				out.add(selectCitizen.getSelectedItem().toString());

				output += "Name 		: " + out.get(0) + "\n";
				output += "Email 		: " + out.get(1) + "\n";
				output += "Phone 		: " + out.get(2) + "\n";
				output += "Gender 		: " + out.get(3) + "\n";
				output += "Citizenship 	: " + out.get(4) + "\n";
				JOptionPane.showMessageDialog(null, output, "Data Diri", JOptionPane.INFORMATION_MESSAGE);
			}
		});

	}

}
