package calculator;

public class GaussMethod {
    private static final double EPS = 0.0001;

    public Matrix makeTriangle(Matrix matrix){
        double[][] table = matrix.getMatrix();
        for(int i = 0; i < matrix.getColumns() - 1; ++i){
            for(int j = i + 1; j < matrix.getRows(); ++j){
                double coeff = table[j][i] / table[i][i];
                for(int z = i; z < matrix.getColumns(); ++z){
                    table[j][z] -= table[i][z] * coeff;
                    if(Math.abs(table[j][z]) <= 0.0001) table[j][z] = 0;
                }
            }
        }
        matrix.setMatrix(table);
        return matrix;
    }

    public double determinantTriangle(Matrix matrix){
        double answer = 1;
        for(int i = 0; i < matrix.getRows(); ++i){
            answer *= matrix.getMatrix()[i][i];
        }
        return answer;
    }
}
