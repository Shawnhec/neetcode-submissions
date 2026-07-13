class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length; 
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(to2D(mid, matrix) >= target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if(left == m * n || to2D(left, matrix) != target) return false;
        return true;
    }

    public int to2D(int idx, int[][] matrix) {
        int n = matrix[0].length;
        return matrix[idx / n][idx % n];
    }
}
