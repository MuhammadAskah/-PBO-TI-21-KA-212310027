package Praktikum_04_Array;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Latihan01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane jop = new JOptionPane();
		
		ArrayList<ArrayList<Integer> > MatriksA = new ArrayList<ArrayList<Integer> >();
		ArrayList<ArrayList<Integer> > MatriksB = new ArrayList<ArrayList<Integer> >();
		ArrayList<ArrayList<Integer> > MatriksC = new ArrayList<ArrayList<Integer> >();

//        int A[][]=new int[2][2];
//
//        int B[][]=new int[2][2];
//
//        int C[][]=new int[2][2];


        System.out.println("Masukkan Matriks A");

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){
            	String input = jop.showInputDialog(null,"Masukkan Nilai x ke ["+i+"] ["+j+"]" ,"Masukkan Data", JOptionPane.INFORMATION_MESSAGE);
            	MatriksA.add(new ArrayList<Integer>());
				MatriksA.get(i).add(j, Integer.parseInt(input));
            }
        }
        
        String Output = "";
        Output += "MATRIKS A: \n";
        for (int i = 0; i<2; i++){
            for(int j=0; j<2; j++){
            	Output += MatriksA.get(i).get(j);
            	Output += " ";
            }
          Output +=  "\n";  
        }
        
        System.out.println("Masukkan Matriks B");

        for(int i=0;i<2;i++){

            for(int j=0;j<2;j++){
            	String input = jop.showInputDialog(null,"Masukkan Nilai x ke ["+i+"] ["+j+"]" ,"Masukkan Data", JOptionPane.INFORMATION_MESSAGE);
            	MatriksB.add(new ArrayList<Integer>());
				MatriksB.get(i).add(j, Integer.parseInt(input));
            }
        }
        
       // String Output = "";
        Output += "MATRIKS B: \n";
        for (int i = 0; i<2; i++){
            for(int j=0; j<2; j++){
            	Output += MatriksB.get(i).get(j);
            	Output += " ";
            }
          Output +=  "\n";  
        }
        
       JOptionPane.showMessageDialog(null, Output);
	}

}

