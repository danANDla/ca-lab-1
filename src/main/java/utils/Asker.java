package utils;

import calculator.Matrix;

import java.util.Locale;

public class Asker {
    private IOutil io;

    public Asker(IOutil io) {
        this.io = io;
    }

    private String getNonEmpty() {
        String str;
        str = io.readLine().trim();
        while (str.equals("")) {
            str = io.readLine().trim();
        }
        return str;
    }

    public int askRows(){
        io.printText("Введите размерность матрицы матрицы");
        int rowsNumber = 0;
        boolean valid = false;
        while (!valid) {
            try {
                rowsNumber = Integer.parseInt(getNonEmpty());
                valid = true;
                if (rowsNumber <= 0) {
                    io.printError("Размерность матрицы должна быть больше 0");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return rowsNumber;
    }

    public Matrix askMatrix() {
        int rows = askRows();
        double[][] matrix = new double[rows][rows];
        for (int i = 0; i < rows; i++) {
            boolean validrow = false;
            while(!validrow){
                String row = getNonEmpty();
                String[] numbers = row.trim().toLowerCase(Locale.ROOT).split("\\s+");
                if(numbers.length != rows){
                    io.printError("Неверное количество введенных чисел");
                    continue;
                }
                boolean badNum = false;
                for (int j = 0; j < rows; j++) {
                    try {
                        matrix[i][j] = Integer.parseInt(numbers[j]);
                    } catch (NumberFormatException e) {
                        io.printError("Неправильный формат вещественного числа");
                        badNum = true;
                    }
                }
                validrow = !badNum;
            }
        }
        return new Matrix(rows, rows, matrix);
    }
}
