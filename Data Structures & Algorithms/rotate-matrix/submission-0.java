class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);

        int m = matrix.length; 
        for(int i = 0; i < m; i++) {
            for(int j = i; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    
    public void reverse(int[][] matrix) {
        int m = matrix.length;
        int i = 0;
        while(i < m / 2) {
            int[] top = matrix[i];
            matrix[i] = matrix[m - 1 - i];
            matrix[m - 1 - i] = top;
            i++;
        }
    }
}

/*
 
*/


/*
7, 8, 9
4, 5, 6
1, 2, 3




*/