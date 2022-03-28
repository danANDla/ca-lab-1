package utils;

import calculator.Matrix;

public class MatrixUtil {
    private IOutil io;
    private Asker asker;
    private Randomizer randomizer;

    public MatrixUtil(IOutil io, Asker asker) {
        this.io = io;
        this.asker = asker;
        this.randomizer = new Randomizer();
    }

    public void printMatrix(Matrix matrix){
        io.printTable(matrix.getRows(), matrix.getColumns(), matrix.getMatrix());
    }

    public Matrix readMatrix(){
        return asker.askMatrix();
    }

    public Matrix generateRandom(){
        int rows = asker.askRows();
        return randomizer.randomMatrix(rows, rows+1);
    }

    public Matrix readFile(){
        // todo do readfile
        return randomizer.randomMatrix(4, 5);
    }

}
