import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Latihan09 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		String inputJML = jop.showInputDialog(null, "Masukkan jumlah array:");
		int jml_arr = Integer.parseInt(inputJML);
		ArrayList<Integer> x = new ArrayList<Integer>();

		for (int i = 0; i < jml_arr; i++) {
			String value = jop.showInputDialog(null, "Masukkan angka :", "Input data ke-" + i, jop.QUESTION_MESSAGE);
			x.add(Integer.parseInt(value));
		}

		String output = "";
		for (int i = 0; i < jml_arr; i++) {
			output += "x[" + i + "]=" + x.get(i) + "\n";

		}

		jop.showMessageDialog(null, output, "Hasil Array", jop.INFORMATION_MESSAGE);
	}
}
