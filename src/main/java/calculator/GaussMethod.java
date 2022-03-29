package calculator;

public class GaussMethod {
    private static final double EPS = 0.0001;

    public Matrix makeTriangle(Matrix matrix) {
        double[][] table = matrix.getMatrix();
        for (int i = 0; i < matrix.getColumns() - 1; ++i) {
            for (int j = i + 1; j < matrix.getRows(); ++j) {
                double coeff = table[j][i] / table[i][i];
                for (int z = i; z < matrix.getColumns(); ++z) {
                    table[j][z] -= table[i][z] * coeff;
                    if (Math.abs(table[j][z]) <= EPS) table[j][z] = 0;
                }
            }
        }
        matrix.setMatrix(table);
        return matrix;
    }

    public double determinantTriangle(Matrix matrix) {
        double answer = 1;
        for (int i = 0; i < matrix.getRows(); ++i) {
            answer *= matrix.getMatrix()[i][i];
        }
        return answer;
    }

    public Matrix unknowns(Matrix triangle) {
        double[][] answer = new double[triangle.getRows()][1];
        double[][] table = triangle.getMatrix();
        for (int i = triangle.getRows() - 1; i >= 0; --i) {
            double temp = 0;
            for (int j = triangle.getRows() - 1; j > i; --j) {
                temp += answer[j][0] * table[i][j];
            }
            answer[i][0] = (table[i][triangle.getRows()] - temp) / table[i][i];
        }
        return new Matrix(triangle.getRows(), 1, answer);
    }

    public Matrix residuals(Matrix matrix, Matrix unknowns) {
        double [][] answer = new double[matrix.getRows()][1];
        for(int i = 0; i < matrix.getRows(); ++i){
            double sum = 0;
            for(int j = 0; j < matrix.getRows(); ++j){
                sum += matrix.getMatrix()[i][j] * unknowns.getMatrix()[j][0];
            }
            answer[i][0] = sum - matrix.getMatrix()[i][matrix.getRows()];
        }
        return new Matrix(matrix.getRows(), 1, answer);
    }
}
