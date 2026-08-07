class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowHasZero = false;
        for(int j = 0; j < n; j++) if(matrix[0][j] == 0) {
            firstRowHasZero = true;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = m - 1; i >= 1; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(firstRowHasZero) Arrays.fill(matrix[0], 0);
        
    }
}


/*
[0, 1]
[1, 1]

bool: true




*/
