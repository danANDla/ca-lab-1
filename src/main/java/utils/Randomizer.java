package utils;

import calculator.Matrix;

public class Randomizer {
    public Matrix randomMatrix(int rows, int columns){
        double[][] numbers = new double[rows][columns];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j){
                numbers[i][j] = Math.random()*10 + Math.random()*(Math.random()*10);
            }
        }
        return new Matrix(rows, columns, numbers);
    }
}
