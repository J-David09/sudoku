package Model;

import java.io.Serial;
import java.io.Serializable;

public class MatrixResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int[][][][] matrix;
    private int steps;

    public MatrixResult(int[][][][] matrix, int steps) {
        this.matrix = matrix;
        this.steps = steps;
    }

    public int[][][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][][][] matrix) {
        this.matrix = matrix;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Prints line by line the sudoku matrix
     * @return Matrix in sudoku format
     */
    public String printMatrix() {
        int i = 0, j = 0, k = 0;
        String sudokuMatrix = "";
        while(i < matrix.length) {
            sudokuMatrix += "| ";
            for (int l = 0; l < matrix.length; l++) {
                //If the number length is 2 then prints one blank space whether prints two blank space
                if (String.valueOf(matrix[i][j][k][l]).length() < 2) sudokuMatrix += matrix[i][j][k][l] + "  ";
                else{
                    sudokuMatrix += matrix[i][j][k][l] + " ";
                }
                //Next main array column
                if(l == matrix.length - 1)j++;
            }
            if(!(j < matrix.length)) {
                sudokuMatrix += "| ";
                j = 0;
                k++;
            }
            if(!(k < matrix.length)){
                sudokuMatrix += "\n";
                k = 0;
                i++;
            }
        }
        return sudokuMatrix;
    }

    @Override
    public String toString() {
        return printMatrix();
    }
}
