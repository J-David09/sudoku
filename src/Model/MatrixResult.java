package Model;

import java.io.Serializable;
import java.util.Arrays;

public class MatrixResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private int[][][][] matrix;
    private int result;

    public MatrixResult(int[][][][] matrix, int result) {
        this.matrix = matrix;
        this.result = result;
    }

    public int[][][][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][][][] matrix) {
        this.matrix = matrix;
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("| ");
                for (int k = 0; k < matrix[i][j].length; k++) {
                    for (int l = 0; l < matrix[i][j][k].length; l++) {
                        System.out.print(matrix[i][j][k][l] + " ");
                    }
                    if (k < matrix[i][j].length - 1) {
                        System.out.print("| ");
                    }
                }
                System.out.print("|");
                System.out.println();
            }
        }
    }

    @Override
    public String toString() {
        printMatrix();
        return "MatrixResult";
    }
}
