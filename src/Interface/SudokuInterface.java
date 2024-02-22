package Interface;

import Model.MatrixResult;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SudokuInterface extends Remote {
    int[][][][] generate(int dimension) throws RemoteException;
    MatrixResult solve(int method, int[][][][] matrix) throws RemoteException;
    MatrixResult fundamental(int[][][][] matrix) throws RemoteException;
    MatrixResult simple(int[][][][] matrix) throws RemoteException;
    MatrixResult advanced(int[][][][] matrix) throws RemoteException;
}


