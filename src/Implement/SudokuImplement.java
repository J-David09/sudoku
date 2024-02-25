package Implement;

import Interface.SudokuInterface;
import Model.MatrixResult;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SudokuImplement extends UnicastRemoteObject implements SudokuInterface {
    private float num1;
    private float num2;

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public SudokuImplement(float num1, float num2) throws RemoteException {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public int[][][][] generate(int dimension) throws RemoteException {
        return switch (dimension) {
            case 1 -> fillMatrix(new int[2][2][2][2]);
            case 2 -> fillMatrix(new int[3][3][3][3]);
            case 3 -> fillMatrix(new int[4][4][4][4]);
            default -> {
                System.out.println("ERROR");
                yield null;
            }
        };
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixResult solve(int method, int[][][][] matrix) throws RemoteException {
        return switch (method) {
            case 1 -> fundamental(matrix);
            case 2 -> simple(matrix);
            case 3 -> advanced(matrix);
            default -> {
                System.out.println("ERROR");
                yield null;
            }
        };
    }

    @Override
    public MatrixResult fundamental(int[][][][] matrix) {
        return new MatrixResult(matrix, 1);
    }

    @Override
    public MatrixResult simple(int[][][][] matrix) {
        return new MatrixResult(matrix, 1);
    }

    @Override
    public MatrixResult advanced(int[][][][] matrix) {
        return new MatrixResult(matrix, 1);
    }

    private int[][][][] fillMatrix(int[][][][] matrix){
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                for (int k = 0; k < matrix[0][0].length; k++)
                    for (int l = 0; l < matrix[0][0][0].length; l++)
                        matrix[i][j][k][l] = Math.round((Math.random()*100.00)/100.00) <= 0.4 ? new Random().nextInt(1, (matrix.length*matrix.length)+1) : 0;
        return matrix;
    }
}

