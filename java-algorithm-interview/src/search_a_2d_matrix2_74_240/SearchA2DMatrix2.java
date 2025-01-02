package search_a_2d_matrix2_74_240;

public class SearchA2DMatrix2 {

    public static void main(String[] args) {
        
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        
        while (row < matrix.length && col >= 0) {
            
            if (matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
