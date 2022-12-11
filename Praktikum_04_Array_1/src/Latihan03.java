import javax.swing.JOptionPane;
public class Latihan03 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		String inputJML = jop.showInputDialog(null, "Masukkan jumlah array:");
		int jml_arr = Integer.parseInt(inputJML);
		int x[] = new int[jml_arr];

		for (int i = 0; i < jml_arr; i++) {
			String value = jop.showInputDialog(null, "Masukkan angka :", "Input data ke-" + i, jop.QUESTION_MESSAGE);
			x[i] = Integer.parseInt(value);
		}

		String output = "";
		for (int i = 0; i < jml_arr; i++) {
			output += "x[" + i + "]=" + x[i] + "\n";
		}

		jop.showMessageDialog(null, output, "Hasil Array", jop.INFORMATION_MESSAGE);

	}
}
