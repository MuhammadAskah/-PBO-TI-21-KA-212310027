package com.ibik.pbo.praktikum;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TicTacToe {

	int clicked = 1;
	JButton Button[];
    int player1Score = 0;
    int player2Score = 0;
	TicTacToe() {
		JFrame frame = new JFrame("Tic Tac Toe");
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 300);
		frame.setTitle("TicTacToe");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(true);
		GenerateUI(frame);
	}

	public static void main(String[] args) {
		new TicTacToe();
	}

	private void GenerateUI(JFrame frame) {
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new GridLayout(3, 3));
		Button = new JButton[9];

		JPanel panelScore = new JPanel();
		panelScore.setLayout(new GridLayout(1, 2));
		final JLabel labelPlayer1 = new JLabel("Player X : 0");
		labelPlayer1.setHorizontalAlignment(JLabel.CENTER);
		final JLabel labelPlayer2 = new JLabel("Player O : 0");
		labelPlayer2.setHorizontalAlignment(JLabel.CENTER);
		panelScore.add(labelPlayer1);
		panelScore.add(labelPlayer2);
		frame.add(panelScore, BorderLayout.PAGE_START);

		for (int i = 0; i < Button.length; i++) {
			Button[i] = new JButton();
			Button[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent evt) {
					AbstractButton EventSource = (AbstractButton) evt.getSource();
					if (clicked % 2 == 1) {
						EventSource.setText("X");
					} else {
						EventSource.setText("O");
					}
					clicked++;
					checkWinner(labelPlayer1, labelPlayer2);
				}
			});
			panelButton.add(Button[i]);

		}
		frame.add(panelButton);

	}

	private void checkWinner(JLabel labelPlayer1, JLabel labelPlayer2) {
		String output = "";
		if (Button[0].getText().equals(Button[1].getText()) && Button[1].getText().equals(Button[2].getText())) {
		    output = Button[0].getText();
		} else if (Button[3].getText().equals(Button[4].getText()) && Button[4].getText().equals(Button[5].getText())) {
		    output = Button[3].getText();
		} else if (Button[6].getText().equals(Button[7].getText()) && Button[7].getText().equals(Button[8].getText())) {
		    output = Button[6].getText();
		} else if (Button[0].getText().equals(Button[3].getText()) && Button[3].getText().equals(Button[6].getText())) {
		    output = Button[0].getText();
		} else if (Button[1].getText().equals(Button[4].getText()) && Button[4].getText().equals(Button[7].getText())) {
		    output = Button[1].getText();
		} else if (Button[2].getText().equals(Button[5].getText()) && Button[5].getText().equals(Button[8].getText())) {
		    output = Button[2].getText();
		} else if (Button[0].getText().equals(Button[4].getText()) && Button[4].getText().equals(Button[8].getText())) {
		    output = Button[0].getText();
		} else if (Button[2].getText().equals(Button[4].getText()) && Button[4].getText().equals(Button[6].getText())) {
		    output = Button[2].getText();
		}

		if (output.length() > 0) {
			if (output.equals("X")) {
				player1Score++;
				labelPlayer1.setText("Player X: " + player1Score);
			} else {
				player2Score++;
				labelPlayer2.setText("Player O: " + player2Score);
			}
			JOptionPane.showMessageDialog(null, output + " got point 1");
			restartGame();
		}

	}
	
	private void restartGame() {
	    // Reset the clicked counter and the text on all buttons
	    clicked = 1;
	    for (int i = 0; i < Button.length; i++) {
	        Button[i].setText("");
	    }
	}
	
}