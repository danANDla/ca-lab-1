package application;

import calculator.GaussMethod;
import calculator.Matrix;
import utils.Asker;
import utils.IOutil;
import utils.MatrixUtil;

public class Main {
    public static void main(String[] args) {
        IOutil io = new IOutil();
        Asker asker = new Asker(io);
        GaussMethod gauss = new GaussMethod();
        MatrixUtil matrixUtil = new MatrixUtil(io, asker);

        boolean running = true;

        while (running) {
            int mode = asker.askMode();
            Matrix matrix = new Matrix();
            switch (mode) {
                case (1): {
                    matrix = matrixUtil.readMatrix();
                    break;
                }
                case (2): {
                    matrix = matrixUtil.generateRandom();
                    break;
                }
                case (3): {
                    matrix = matrixUtil.readFile();
                    break;
                }
                case (0): {
                    running = false;
                    break;
                }
            }
            if (running && matrix != null) {
                io.printWarning("Расширенная матрица");
                matrixUtil.printMatrix(matrix);

                io.printWarning("Треугольная матрица");
                Matrix triangle = gauss.makeTriangle(matrix);
                matrixUtil.printMatrix(triangle);

                io.printWarning("Детерминант матрицы");
                io.printlnDouble(gauss.determinantTriangle(triangle));

                io.printWarning("Столбец неизвестных");
                Matrix unknowns = gauss.unknowns(triangle);
                io.printTable(triangle.getRows(), 1, unknowns.getMatrix());

                io.printWarning("Столбец невязок");
                io.printTable(matrix.getRows(), 1, gauss.residuals(matrix, unknowns).getMatrix());
            }
        }
    }
}
