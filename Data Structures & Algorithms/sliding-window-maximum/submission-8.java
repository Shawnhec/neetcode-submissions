class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        int left = -k;
        for(int right = 0; right < n; right++) {
            while(!deq.isEmpty() && nums[right] > nums[deq.getLast()]) {
                deq.removeLast();
            }
            deq.offerLast(right);
            left++;

            if(left < 0) continue;

            ans[left] = nums[deq.getFirst()];

            if(right - deq.getFirst() + 1 >= k) deq.removeFirst();
        }
        return ans;
    }
}



/*



*/