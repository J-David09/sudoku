package Interface;

import Model.SudokuMatrix;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SudokuInterface extends Remote {
    int[][][][] generate(int option) throws RemoteException;
    SudokuMatrix solve(SudokuMatrix solvedSudoku, int i, int j, int k, int l) throws RemoteException;
}



