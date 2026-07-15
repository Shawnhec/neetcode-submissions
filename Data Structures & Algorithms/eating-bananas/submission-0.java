class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(cantEat(piles, h, mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean cantEat(int[] piles, int h, int mid) {
        long sum = 0; 
        for(int i = 0; i < piles.length; i++) {
            sum += piles[i] / mid;
            if(piles[i] % mid != 0) sum++;
        }
        if (sum > h) return false;
        return true; 
    }
}