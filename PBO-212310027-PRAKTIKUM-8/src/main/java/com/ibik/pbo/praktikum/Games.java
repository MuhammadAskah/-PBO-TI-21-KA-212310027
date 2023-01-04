package com.ibik.pbo.praktikum;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Games extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7294027637590305295L;
	private ImageIcon rocket;
	private JLabel lblBox;

	Games() {
		setVisible(true);
		pack();
		setTitle("Rocket Games");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(null);
		addKeyListener(this);
		getContentPane().setBackground(Color.BLUE);
		initialize(this);
	}

	public static void main(String[] args) {
		new Games();
	}

	private void initialize(Games frame) {
		lblBox = new JLabel();
		rocket = new ImageIcon(
				"D:\\2023\\Askah\\pbo\\PBO-212310027-PRAKTIKUM-8\\src\\main\\java\\com\\ibik\\pbo\\praktikum\\rocket.png");
		lblBox.setIcon(rocket);
		lblBox.setBounds(0, 0, 50, 105);
		frame.add(lblBox);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		int x = lblBox.getX();
		int y = lblBox.getY();    // Rotate the ImageIcon by 90 degrees
	    BufferedImage bufferedImage = new BufferedImage(rocket.getIconWidth(), rocket.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = bufferedImage.createGraphics();

	    ImageIcon rotatedIcon = new ImageIcon(bufferedImage);
		switch (e.getKeyChar()) {
	    case 'a':
	        lblBox.setLocation(lblBox.getX() - 10, lblBox.getY());
		    g2d.rotate(Math.toRadians(-90), rocket.getIconWidth() / 2, rocket.getIconHeight() / 2);
		    g2d.drawImage(rocket.getImage(), 0, 0, null);
		    g2d.dispose();
	        lblBox.setIcon(rotatedIcon);
	        break;
	    case 'w':
	        lblBox.setLocation(lblBox.getX(), lblBox.getY() - 10);
		    g2d.rotate(Math.toRadians(0), rocket.getIconWidth() / 2, rocket.getIconHeight() / 2);
		    g2d.drawImage(rocket.getImage(), 0, 0, null);
		    g2d.dispose();
	        lblBox.setIcon(rotatedIcon);
	        break;
	    case 's':
	        lblBox.setLocation(lblBox.getX(), lblBox.getY() + 10);
		    g2d.rotate(Math.toRadians(180), rocket.getIconWidth() / 2, rocket.getIconHeight() / 2);
		    g2d.drawImage(rocket.getImage(), 0, 0, null);
		    g2d.dispose();
	        lblBox.setIcon(rotatedIcon);
	        break;
	    case 'd':
	        lblBox.setLocation(lblBox.getX() + 10, lblBox.getY());
		    g2d.rotate(Math.toRadians(90), rocket.getIconWidth() / 2, rocket.getIconHeight() / 2);
		    g2d.drawImage(rocket.getImage(), 0, 0, null);
		    g2d.dispose();
	        lblBox.setIcon(rotatedIcon);
	        break;
	}


		if (x < 0) {
			lblBox.setLocation(0, y);
		} else if (x > getWidth() - lblBox.getWidth()) {
			lblBox.setLocation(getWidth() - lblBox.getWidth(), y);
		} else if (y < 0) {
			lblBox.setLocation(x, 0);
		} else if (y > getHeight() - lblBox.getHeight()) {
			lblBox.setLocation(x, getHeight() - lblBox.getHeight());
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int x = lblBox.getX();
		int y = lblBox.getY();

		switch (e.getKeyCode()) {
		case 37:
			lblBox.setLocation(lblBox.getX() - 10, lblBox.getY());
			break;
		case 38:
			lblBox.setLocation(lblBox.getX(), lblBox.getY() - 10);
			break;
		case 40:
			lblBox.setLocation(lblBox.getX(), lblBox.getY() + 10);
			break;
		case 39:
			lblBox.setLocation(lblBox.getX() + 10, lblBox.getY());
			break;
		default:
			break;
		}
		if (x < 0) {
			lblBox.setLocation(0, y);
		} else if (x > getWidth() - lblBox.getWidth()) {
			lblBox.setLocation(getWidth() - lblBox.getWidth(), y);
		} else if (y < 0) {
			lblBox.setLocation(x, 0);
		} else if (y > getHeight() - lblBox.getHeight()) {
			lblBox.setLocation(x, getHeight() - lblBox.getHeight());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());
	}
	
	
}