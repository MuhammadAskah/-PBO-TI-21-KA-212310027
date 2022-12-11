import java.util.Scanner;
import javax.swing.JOptionPane;

public class Latihan06 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		int A[][] = new int[2][2];
		int B[][] = new int[2][2];

		String output = "";

		output += "Matrix A : \n";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				String value = jop.showInputDialog(null, "Masukkan angka :", "Matrix A [" + i + "][" + j + "]",
						jop.QUESTION_MESSAGE);
				A[i][j] = Integer.parseInt(value);
				output += A[i][j] + " ";
			}
			output += "\n";
		}
		output += "Matrix B : \n";
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				String value = jop.showInputDialog(null, "Masukkan angka :", "Matrix B [" + i + "][" + j + "]",
						jop.QUESTION_MESSAGE);
				B[i][j] = Integer.parseInt(value);
				output += B[i][j] + " ";
			}
			output += "\n";
		}

		jop.showMessageDialog(null, output);
	}
}
