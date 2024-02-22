package Client;

import Interface.SudokuInterface;

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
        int dimension = 0, method;
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
                dimension=Integer.parseInt(br.readLine());
                if (dimension!=4) {
                    SudokuInterface sudokuInterface = (SudokuInterface) Naming.lookup("Sudoku");
                    System.out.println("-- Select a matrix method solution --");
                    System.out.println("1. Fundamental");
                    System.out.println("2. Simple Clues");
                    System.out.println("3. Advanced");
                    System.out.println("4. Exit");
                    System.out.println("-------------------------------------");
                    System.out.print("Option: ");
                    method=Integer.parseInt(br.readLine());
                    System.out.println();
                    System.out.println(sudokuInterface.solve(method, sudokuInterface.generate(dimension)).toString());
                }
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(SudokuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        } while (dimension != 4);
    }
}