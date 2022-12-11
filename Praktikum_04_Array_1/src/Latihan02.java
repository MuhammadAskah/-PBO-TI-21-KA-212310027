public class Latihan02 {
	public static void main(String[] args) {
		int jml_arr = 3;
		int x[] = new int[jml_arr];

		x[0] = 1;
		x[1] = 2;
		x[2] = 3;

		for (int i = 0; i < jml_arr; i++) {
			x[i] = i + 5;
		}

		System.out.println("=Output by index=");
		System.out.println("x[0]=" + x[0]);
		System.out.println("x[1]=" + x[1]);
		System.out.println("x[2]=" + x[2]);

		System.out.println("=Output by loop=");
		for (int i = 0; i < jml_arr; i++) {
			System.out.println("x[" + i + "]" + x[i]);
		}
	}
}
