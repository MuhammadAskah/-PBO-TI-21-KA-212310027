import javax.swing.JOptionPane;

public class Latihan04 {

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
		int max = x[0];
		int min = x[0];
		for (int i = 0; i < jml_arr; i++) {
			output += "x[" + i + "]=" + x[i] + "\n";
			if (x[i] > max) {
				max = x[i];
			} else {
				min = x[i];
			}
		}
		output += "Nilai Terbesar adalah " + max + "\n";
		output += "Nilai Terkecil adalah " + min;
		jop.showMessageDialog(null, output, "Hasil Array", jop.INFORMATION_MESSAGE);

	}

}
