package com.ibik.pbo.praktikum;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Login() {
		
		pack();
		setLocationRelativeTo(null);
		setSize(310, 260);
		setTitle("Login");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GenerateUI(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

	private void GenerateUI(Login Login) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		Login.setContentPane(mainPanel);

		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		mainPanel.add(panel1, BorderLayout.NORTH);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 23, 80, 16);
		panel1.add(lblEmail);
		final JTextField textEmail = new JTextField();
		textEmail.setBounds(105, 18, 169, 30);
		panel1.add(textEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 69, 61, 16);
		panel1.add(lblPassword);
		final JPasswordField textPassword = new JPasswordField();
		textPassword.setBounds(105, 64, 169, 30);
		panel1.add(textPassword);

		JCheckBox chkRemember = new JCheckBox("Remember account ?");
		chkRemember.setBounds(105, 90, 169, 40);
		panel1.add(chkRemember);

		JButton btnSubmit = new JButton("Login");
		btnSubmit.setBounds(155, 135, 100, 40);
		panel1.add(btnSubmit);
		Login.add(panel1);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> out = new ArrayList<String>();

				String email = textEmail.getText();
				String pass = new String(textPassword.getPassword());
				String output = "";

				if (email.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Silakan mengisi data dengan benar");
					return;
				}
				if (!email.contains("@") && !email.contains(".ibik.ac.id")) {
					JOptionPane.showMessageDialog(null, "Data yang anda masukan salah");
					return;
				}

				if (pass.equals("222310041")) {
					out.add(email);
					output += "Selamat Datang " + out.get(0) + "\n";
					JOptionPane.showMessageDialog(null, output, "Data Diri", JOptionPane.INFORMATION_MESSAGE);
					
					Form form = new Form();
					dispose();
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Password Anda Salah");
					return;
				}

			}
		});

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(50, 135, 100, 40);
		panel1.add(btnRegister);
		Login.add(panel1);

		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register othFrame = new Register();
				othFrame.setVisible(true);
				dispose();
			}
		});
		
	}

}