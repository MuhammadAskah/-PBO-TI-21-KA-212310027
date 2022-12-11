import javax.swing.JOptionPane;

public class Latihan05 {
	public static void main(String[] args) {
		JOptionPane jop = new JOptionPane();
		String field[] = { "Nama Lengkap", "Alamat", "No Telp" };
		int jml_arr = field.length;
		String x[] = new String[jml_arr];

		for (int i = 0; i < jml_arr; i++) {
			String value = jop.showInputDialog(null, "Masukkan " + field[i] + " :", "Data array ke-" + i,
					jop.QUESTION_MESSAGE);
			x[i] = value;
		}

		String output = "";
		for (int i = 0; i < jml_arr; i++) {
			output += "" + field[i] + " : " + x[i] + "\n";
		}

		jop.showMessageDialog(null, output, "Data Diri", jop.INFORMATION_MESSAGE);

	}
}
