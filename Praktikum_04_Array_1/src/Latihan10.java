import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Latihan10 {
	public static void main(String[] args) {
		String field[] = { "Nama Lengkap", "Alamat", "No Telp" };
		int jml_arr = field.length;
		ArrayList<String> x = new ArrayList<String>();

		for (int i = 0; i < jml_arr; i++) {
			String value = JOptionPane.showInputDialog(null, "Masukkan " + field[i] + " :", "Data array ke-" + i,
					JOptionPane.QUESTION_MESSAGE);
			x.add(value);
		}

		String output = "";
		for (int i = 0; i < jml_arr; i++) {
			output += "" + field[i] + " : " + x.get(i) + "\n";

		}

		JOptionPane.showMessageDialog(null, output, "Data Diri", JOptionPane.INFORMATION_MESSAGE);

	}
}
