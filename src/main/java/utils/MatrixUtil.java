package utils;

import calculator.Matrix;

import java.util.ArrayList;
import java.util.Locale;

public class MatrixUtil {
    private IOutil io;
    private Asker asker;
    private Randomizer randomizer;
    private FileUtil fileUtil;

    public MatrixUtil(IOutil io, Asker asker) {
        this.io = io;
        this.asker = asker;
        this.randomizer = new Randomizer();
        this.fileUtil = new FileUtil(io);
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
        ArrayList<String> table = fileUtil.readMatrix("test");
        if(table == null) return null;
        int rows = table.size();
        double[][] matrix = new double[rows][rows + 1];
        boolean badNum = false;
        for (int i = 0; i < rows; i++) {
            String row = table.get(i);
            String[] numbers = row.trim().toLowerCase(Locale.ROOT).split("\\s+");
            if (numbers.length != rows + 1) {
                io.printError("Неверное количество введенных чисел в строке " + Integer.toString(i+1) +
                        "\nОжидалось " + rows + 1 + " чисел");
                break;
            }
            for (int j = 0; j < rows + 1; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(numbers[j]);
                } catch (NumberFormatException e) {
                    io.printError("Неправильный формат вещественного числа " +
                            Integer.toString(j+1) + "в строке " + Integer.toString(i+1));
                    badNum = true;
                }
            }
            if(badNum) break;
        }
        if(badNum) return null;
        return new Matrix(rows, rows + 1, matrix);
    }

}
