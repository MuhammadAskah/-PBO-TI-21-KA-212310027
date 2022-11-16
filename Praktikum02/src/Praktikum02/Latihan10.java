package Praktikum02;

import javax.swing.JOptionPane;


class BankAccount {

    private double balance;
    private String password;

    public BankAccount(String password, double balance) {
        this.password = password;
        this.balance = balance;
    }

    public String getPassword() {
        return this.password;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdraw(double balance) {
        this.balance = balance;
    }
}




public class Latihan10 {
	public static void main(String[] args) {
		Latihan10 atm1 = new Latihan10();
		atm1.createAccounts();
	}

	private int select1 = 1;
	BankAccount[] accounts = new BankAccount[2];

	public void createAccounts() {
		accounts[1] = new BankAccount("6666", 1200000.0);
		MasukkanPin();
	}

	public void MasukkanPin() {
		String PinInput = JOptionPane.showInputDialog(null, "Masukkan PIN Anda: ", "ATM",
				JOptionPane.INFORMATION_MESSAGE);

		if (PinInput == null) {
			int check = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
					JOptionPane.YES_NO_OPTION);
			if (check == 0) {
				JOptionPane.showMessageDialog(null, "Terima kasih telah bertransaksi dengan kami!", "Keluar", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else {
				MasukkanPin();
			}
		} else if (PinInput.equals(accounts[1].getPassword())) {
			MasukMenu();
		} else if (PinInput.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mohon Masukkan PIN Anda", "Pemberitahuan",
					JOptionPane.INFORMATION_MESSAGE);
			MasukkanPin();
		} else {
			JOptionPane.showMessageDialog(null, "Password Salah! Harap Masukkan Kembali", "Error",
					JOptionPane.ERROR_MESSAGE);
			MasukkanPin();
		}

	}

	public void MasukMenu() {
		String label = "Menu : \n";
		label += "1. Lihat Saldo\n";
		label += "2. Setor Tunai\n";
		label += "3. Tarik Tunai\n";
		label += "4. Keluar\n\n";
		label += "Pilih menu: ";
		String menu = JOptionPane.showInputDialog(null, label, "ATM", JOptionPane.QUESTION_MESSAGE);
		if (menu == null) {
			int check = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
					JOptionPane.YES_NO_OPTION);
			if (check == 0) {
				JOptionPane.showMessageDialog(null, "Terima kasih telah bertransaksi dengan kami!", "Keluar", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}

		} else if (menu.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Mohon Masukkan Menu", "Error", JOptionPane.ERROR_MESSAGE);
			MasukMenu();
		}
		int optionsInput = Integer.parseInt(menu);

		switch (optionsInput) {
		case 1:
			LihatSaldo();
			return;
		case 2:
			SetorTunai();
			return;
		case 3:
			TarikTunai();
			return;
		case 4:
			if (optionsInput == 4) {
				int check = JOptionPane.showConfirmDialog(null, "Apakah anda ingin keluar?", "Keluar",
						JOptionPane.YES_NO_OPTION);
				if (check == 0) {
					JOptionPane.showMessageDialog(null, "Terima kasih telah bertransaksi dengan kami!", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				} else {
					MasukMenu();
				}
			}

		default:
			JOptionPane.showMessageDialog(null, "Menu Tidak Tersedia", "Error", JOptionPane.ERROR_MESSAGE);
			MasukMenu();
		}
	}

	public void LihatSaldo() {
		JOptionPane.showMessageDialog(null, "Saldo Anda: " + accounts[select1].getBalance(), "Message",
				JOptionPane.INFORMATION_MESSAGE);
		MasukMenu();
	}

	public void SetorTunai() {
		String input = JOptionPane.showInputDialog(null, "Masukkanlah Jumlah Setor Tunai Anda: ", "ATM",
				JOptionPane.QUESTION_MESSAGE);
		double depositInput = Double.parseDouble(input);
		for (int i = 0; i < accounts.length; i++) {
			if (depositInput <= 0) {
				JOptionPane.showMessageDialog(null, "Jumlah deposit harus lebih besar dari 0", "Error",
						JOptionPane.ERROR_MESSAGE);
				SetorTunai();
			} else {
				accounts[select1].withdraw(accounts[select1].getBalance() + depositInput);
				JOptionPane.showMessageDialog(null, "Saldo Akhir: Rp. " + accounts[select1].getBalance(), "Message",
						JOptionPane.INFORMATION_MESSAGE);
				MasukMenu();
			}

		}
	}

	public void TarikTunai() {
		String input = JOptionPane.showInputDialog(null, "Silahkan Masukkan Jumlah Yang Akan Ditarik: ", "ATM",
				JOptionPane.QUESTION_MESSAGE);
		double withdrawInput = Double.parseDouble(input);
		for (int i = 0; i < accounts.length; i++) {
			if (withdrawInput <= 0 || withdrawInput > accounts[select1].getBalance()) {
				JOptionPane.showMessageDialog(null, "Saldo Tidak Cukup", "Error", JOptionPane.ERROR_MESSAGE);
				TarikTunai();
			} else {
				accounts[select1].withdraw(accounts[select1].getBalance() - withdrawInput);
				JOptionPane.showMessageDialog(null, "Saldo Akhir: Rp. " + accounts[select1].getBalance(), "Message",
						JOptionPane.INFORMATION_MESSAGE);
				MasukMenu();
			}
		}
	}

}
