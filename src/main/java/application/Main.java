package application;

import utils.Asker;
import utils.IOutil;
import utils.MatrixUtil;

public class Main {
    public static void main(String[] args){
        IOutil io = new IOutil();
        MatrixUtil matrixUtil = new MatrixUtil(io);

        matrixUtil.printMatrix(matrixUtil.generateRandom());
    }
}
