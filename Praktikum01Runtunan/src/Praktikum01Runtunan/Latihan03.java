package Praktikum01Runtunan;

class LayangLayang {
	double luas, keliling;
    
    double setLuas(double d1, double d2) {
        luas = 0.5 * (d1 * d2);

        return luas;
    }

    double setKeliling(double sisi1, double sisi2) {
        keliling = (2 * (sisi1 + sisi1)) + (2 * (sisi2 + sisi2));

        return keliling;
    }
}

class PrismaSegitia {
    double luas, volume;
    
    double setLuas(double a_segitiga, double t_segitiga, double s_miring_segitiga, double t) {
        double luasAlas = (0.5 * (a_segitiga * t_segitiga));
        double kelilingAlas = (a_segitiga + t_segitiga + s_miring_segitiga);

        luas = (2 * (luasAlas)) + (kelilingAlas * t);

        return luas;
    }

    double setVolume(double t, double a, double t_prisma) {
        volume = (0.5 * (a * t)) * t_prisma;

        return volume;
    }
}

public class Latihan03 {
    
    public static void main(String[] args) {
        LayangLayang rumusLayang = new LayangLayang();
        PrismaSegitia rumusPrismaSegitiga = new PrismaSegitia();

        // variabel dan nilai untuk layang-layang
        double diagonal1 = 10;
        double diagonal2 = 5;
        double sisiA = 5;
        double sisiB = 13;

        // variabel dan nilai untuk prisma segitiga
        double alasSegitiga = 5;       
        double tinggiSegitiga = 3;
        double sisiMiring = 4;
        double tinggi = 4;

        double getLuasLayang = rumusLayang.setLuas(diagonal1, diagonal2);
        double getKelilingLayang = rumusLayang.setKeliling(sisiA, sisiB);

        double getLuasPrisma = rumusPrismaSegitiga.setLuas(alasSegitiga, tinggiSegitiga, sisiMiring, tinggi);
        double getVolumePrisma = rumusPrismaSegitiga.setVolume(tinggiSegitiga, alasSegitiga, tinggi);

        System.out.println("Luas layang-layang  = " + getLuasLayang);
        System.out.println("Keliling layang-layang = " + getKelilingLayang + "\n");

        System.out.println("Luas prisma segitiga  = " + getLuasPrisma);
        System.out.println("Volume prisma segitiga = " + getVolumePrisma);
    }

}