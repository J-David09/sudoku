package Server;

import Implement.SudokuImplement;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SudokuServer {
    public static void main(String []args) {
        try {
            Registry reg= LocateRegistry.createRegistry(1099);
            SudokuImplement sudokuImplement=new SudokuImplement();
            //Object Name
            reg.rebind("Sudoku", sudokuImplement);
            System.out.println("Server Started");
        } catch (RemoteException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }
}
