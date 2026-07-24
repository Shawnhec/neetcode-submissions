class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] leftProduct = new int[n + 1];
        int[] rightProduct = new int[n + 1];
        
        leftProduct[0] = 1;
        for(int i = 0; i < n; i++) {
            leftProduct[i + 1] = leftProduct[i] * nums[i];
        }

        rightProduct[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i];
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = leftProduct[i] * rightProduct[i + 1];
        }

        return ans;
     }
}  



/*
nums = [1,2,4,6] 
       
   1   1   2  8  48
  48  48  24  6   1

*/