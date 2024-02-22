package Model;

import java.util.Arrays;

public record MatrixResult(int[][][][] matrix, int steps) {

    @Override
    public String toString() {
        return "Steps to solve: " + steps + "\n" + Arrays.deepToString(matrix);
    }
}
