class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0, right = heights.length - 1;
        while(left <= right) {
            int height = Math.min(heights[left], heights[right]);
            max = Math.max(max, height * (right - left));
            if(heights[left] >= heights[right]) right--;
            else if(heights[right] > heights[left]) left++;
        }
        return max;
    }
}
