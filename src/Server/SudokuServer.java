package Server;

import Implement.SudokuImplement;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SudokuServer {
    public static void main(String []args) throws RemoteException
    { Registry reg= LocateRegistry.createRegistry(1099);
        SudokuImplement sudokuImplement=new SudokuImplement(0,0);
        //Object Name
        reg.rebind("Sudoku", sudokuImplement);
        System.out.println("Server Started");

    }
}
