package Implement;

import Interface.SudokuInterface;
import Model.SudokuMatrix;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class SudokuImplement extends UnicastRemoteObject implements SudokuInterface {

    public SudokuImplement() throws RemoteException {
    }

    @Override
    public int[][][][] generate(int option) throws RemoteException {
        return switch (option) {
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
    public SudokuMatrix solve(SudokuMatrix solvedSudoku, int i, int j, int k, int l) {

        // Backtracking solution
        for (int number = 1; number <= solvedSudoku.getLength() * solvedSudoku.getLength(); number++) {

            //
            l++;
            if (l == solvedSudoku.getLength()) {
                l = 0;
                k++;
                if (k == solvedSudoku.getLength()) {
                    k = 0;
                    j++;
                    if (j == solvedSudoku.getLength()) {
                        j = 0;
                        i++;
                    }
                }
            }
            if (solvedSudoku.getMatrixNumber(i, j, k, l) == 0 && numberValidation(solvedSudoku.getMatrix(), number, i, j, k, l)) {
                solvedSudoku.setMatrixNumber(i, j, k, l, number);
                solvedSudoku.setSteps(1, 1);
                return solvedSudoku;
            }
            solvedSudoku = solve(solvedSudoku, i, j, k, l);
        }
        return solvedSudoku;
    }

    private static int[][][][] fillMatrix(int[][][][] matrix) {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                for (int k = 0; k < matrix[0][0].length; k++)
                    for (int l = 0; l < matrix[0][0][0].length; l++) {
                        int number;
                        do {
                            number = Math.random() <= 0 ? new Random().nextInt(1, (matrix.length * matrix.length) + 1) : 0;
                            matrix[i][j][k][l] = number;
                        } while (!numberValidation(matrix, number, i, j, k, l) && number != 0);
                    }
        return matrix;
    }

    public static boolean numberValidation(int[][][][] matrix, int number, int externalRow, int externalColumn, int internalRow, int internalColumn) {
        //Check internal matrix
        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix.length; l++) {
                if (matrix[externalRow][externalColumn][k][l] == number
                        && (k != internalRow || l != internalColumn)) return false;
            }
        }

        //Check external number row and column
        int auxCol = 0, auxRow = 0;
        for (int auxMatrix = 0; auxMatrix < matrix.length; auxMatrix++) {
            //Check entire number row
            for (int l = 0; l < matrix.length; l++) {
                if (matrix[externalRow][auxCol][internalRow][l] == number &&
                        auxCol != externalColumn) return false;

                //Next main array column
                if (l == matrix.length - 1) auxCol++;//2
            }

            //Check entire number column
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[auxRow][externalColumn][k][internalColumn] == number &&
                        auxRow != externalRow) return false;

                //Next main array row
                if (k == matrix.length - 1) auxRow++;
            }
        }
        return true;
    }
}

