package Model;

import java.io.Serial;
import java.io.Serializable;

public class SudokuMatrix implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int[][][][] matrix;
    private int steps;

    public SudokuMatrix(int[][][][] matrix, int steps) {
        this.matrix = matrix;
        this.steps = steps;
    }

    public int[][][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][][][] matrix) {
        this.matrix = matrix;
    }

    public int getMatrixNumber(int i, int j, int k, int l) {
        return matrix[i][j][k][l];
    }

    public void setMatrixNumber(int i, int j, int k, int l, int number) {
        matrix[i][j][k][l] = number;
    }

    public int getSteps() {
        return steps;
    }

    /**
     * @param acum  - set -1 to diminish, set 1 to increase, set any valor to set exactly value
     * @param steps - steps to solve
     */
    public void setSteps(int acum, int steps) {
        switch (acum) {
            case -1:
                this.steps -= steps;
            case 1:
                this.steps += steps;
                break;
            default:
                this.steps = steps;
        }
    }

    public int getLength() {
        return this.matrix.length;
    }

    /**
     * Prints line by line the sudoku matrix
     *
     * @return Matrix in sudoku format
     */
    public String printMatrix() {
        int i = 0, j = 0, k = 0;
        String sudokuMatrix = "";
        while (i < matrix.length) {
            sudokuMatrix += "| ";
            for (int l = 0; l < matrix.length; l++) {
                //If the number length is 2 then prints one blank space whether prints two blank space
                if (String.valueOf(matrix[i][j][k][l]).length() < 2) sudokuMatrix += matrix[i][j][k][l] + "  ";
                else {
                    sudokuMatrix += matrix[i][j][k][l] + " ";
                }
                //Next main array column
                if (l == matrix.length - 1) j++;
            }
            if (!(j < matrix.length)) {
                sudokuMatrix += "| \n";
                j = 0;
                k++;
            }
            if (!(k < matrix.length)) {
                sudokuMatrix += "\n";
                k = 0;
                i++;
            }
        }
        if (steps > 0) sudokuMatrix += "Steps to get solve: " + steps + "\n";
        return sudokuMatrix;
    }

    @Override
    public String toString() {
        return printMatrix();
    }
}
