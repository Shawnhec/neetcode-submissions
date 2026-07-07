class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        List<Integer> ans = new ArrayList<>();
        while(left <= right && top <= bottom) {

            for(int col = left; col <= right; col++) {
                ans.add(matrix[top][col]);
            }
            top++;

            for(int row = top; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            right--;

            if(top <= bottom) {
                for(int col = right; col >= left; col--) {
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if(left <= right) {
                for(int row = bottom; row >= top; row--) {
                    ans.add(matrix[row][left]);
                }
                left++;
            }
        }
        return ans;
    }
}


/*
7
9
6
9

top = 1
bottom = 3
left = 0 
right = -1

*/