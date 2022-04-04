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
        io.printArrow();
        str = io.readLine().trim();
        while (str.equals("")) {
            str = io.readLine().trim();
        }
        return str;
    }

    public int askRows() {
        io.printText("Введите размерность матрицы матрицы");
        int rowsNumber = 0;
        boolean valid = false;
        while (!valid) {
            try {
                rowsNumber = Integer.parseInt(getNonEmpty());
                valid = true;
                if (rowsNumber < 2 || rowsNumber > 20) {
                    io.printError("Размерность матрицы должна быть больше 1 и меньше 21");
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
        double[][] matrix = new double[rows][rows + 1];
        for (int i = 0; i < rows; i++) {
            boolean validrow = false;
            while (!validrow) {
                String row = getNonEmpty();
                String[] numbers = row.trim().toLowerCase(Locale.ROOT).split("\\s+");
                if (numbers.length != rows + 1) {
                    io.printError("Неверное количество введенных чисел");
                    continue;
                }
                boolean badNum = false;
                for (int j = 0; j < rows + 1; j++) {
                    try {
                        matrix[i][j] = Double.parseDouble(numbers[j]);
                    } catch (NumberFormatException e) {
                        io.printError("Неправильный формат вещественного числа");
                        badNum = true;
                    }
                }
                validrow = !badNum;
            }
        }
        return new Matrix(rows, rows + 1, matrix);
    }

    public int askMode() {
        int mode = 0;
        boolean valid = false;
        io.printDivider();
        io.printText("Выберите способ ввода:\n" +
                "(1) ввести вручную\n" +
                "(2) сгенерировать автоматически\n" +
                "(3) считать из файла\n" +
                "(0) выход из приложения\n");
        while (!valid) {
            try {
                mode = Integer.parseInt(getNonEmpty());
                valid = true;
                if (mode < 0 || mode > 3) {
                    io.printError("Такого режима нет");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                io.printError("Неправильный формат целого числа");
            }
        }
        return mode;
    }

    public String askFilename(){
        io.printText("Введите имя файла");
        return getNonEmpty();
    }
}
