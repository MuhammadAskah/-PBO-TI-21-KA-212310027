package Praktikum01Runtunan;

import java.util.Scanner;

public class Latihan09 {
	
	public static void main(String[] args) {
		Latihan09 myProgram = new Latihan09();

        System.out.println("===SELAMAT DATANG==== \n");
        System.out.println("===SILAHKAN ISI DATA DIRI ANDA===\n");
        
        myProgram.InputStudents();
    }

    void InputStudents() {
        Students myBio = new Students();
        Scanner valueInput = new Scanner(System.in);
        
        // variabel untuk input data oleh user
        int inNPM, inSemester;
        float inGPA;
        String inFullName, inClassName;
    
        // variabel untuk menyimpan data masukkan oleh user
        int objNPM, objSemester;
        float objGPA;
        String objFullName, objClassName;

        System.out.print("Masukkan NPM = ");
        inNPM = valueInput.nextInt();
        objNPM = myBio.getNPM(inNPM);

        valueInput.nextLine();
        
        System.out.print("Masukkan nama lengkap Anda = ");
        inFullName = valueInput.nextLine();
        objFullName = myBio.getFullName(inFullName);

        System.out.print("Masukkan kelas Anda = ");
        inClassName = valueInput.nextLine();
        objClassName = myBio.getClassName(inClassName);

        System.out.print("Masukkan semester Anda = ");
        inSemester = valueInput.nextInt();
        objSemester = myBio.getSemester(inSemester);

        System.out.print("Masukkan GPA / IPK Anda = ");
        inGPA = valueInput.nextFloat();
        objGPA = myBio.getGPA(inGPA);

        OutputStudents(objNPM, objFullName, objClassName, objSemester, objGPA);

        valueInput.close();
    }

    void OutputStudents(int val_NPM, String val_FullName, String val_ClassName, int val_Semester, float val_GPA) {
    	System.out.print("\n");
    	
        System.out.println("NPM            : " + val_NPM);
        System.out.println("Nama Lengkap   : " + val_FullName);
        System.out.println("Kelas          : " + val_ClassName);
        System.out.println("Semester       : " + val_Semester);
        System.out.println("GPA / IPK      : " + val_GPA);
    }

}
