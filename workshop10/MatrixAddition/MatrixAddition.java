
/**
 * add two matrices of same size(matrixA row = matrixB row and matrixA column= matrixB column
 * @param   matrix1 the first matrix of type double
 * @param   matrix2 the second matrix of type double
 * @return  returns a double array that holds the addition result
**/
class MatrixAddition{
    public static double[][] calculate(double [][] matrix1, double [][] matrix2)throws Exception{
        double result[][]=null;
        //row size for both matrices must be equal otherwise throw exception
        if(matrix1.length==matrix2.length){
            result= new double[matrix1.length][];
            for(int i=0; i<matrix1.length; i++){
                //column length for both row must be equal, else throw exception
                if(matrix1[i].length==matrix2[i].length){
                    result[i]=new double[matrix1[i].length];
                    for(int j=0; j<matrix1[i].length; j++){
                        result[i][j]= matrix1[i][j] +  matrix2[i][j];
                    }
                }
                else{
                    throw new Exception("Both matrix must have same number of columns");
                }
            }
        }
        else{
            throw new Exception("Both matrix must have same number of rows");
        }
        return result;
    }
}
