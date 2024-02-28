package Client;

import Interface.SudokuInterface;
import Model.SudokuMatrix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SudokuClient {
    public static void main(String[] args) throws IOException {
        int option = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("-- Select a matrix dimension --");
            System.out.println("1. 4x4 Matrix");
            System.out.println("2. 9x9 Matrix");
            System.out.println("3. 16x16 Matrix");
            System.out.println("4. Exit    ");
            System.out.println("--------------------------------");
            System.out.print("Option: ");
            try {
                option=Integer.parseInt(br.readLine());
                if (option!=4) {
                    SudokuInterface sudokuInterface = (SudokuInterface) Naming.lookup("Sudoku");
                    System.out.println();
                    int[][][][] matrix = sudokuInterface.generate(option);
                    //Print original matrix
                    System.out.print("ORIGINAL MATRIX\n\n" + new SudokuMatrix(matrix, 0));

                    //Print solved matrix
                    try{
                        System.out.println("SOLVED MATRIX\n\n" + sudokuInterface.solve(new SudokuMatrix(matrix, 0), 0, 0, 0,0).toString());
                    } catch (NullPointerException ex){
                        System.out.println("It couldn't solve sudoku"+ex.getMessage());
                    }
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(SudokuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (option != 4);
    }
}