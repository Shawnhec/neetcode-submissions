class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        for(int num : freq.keySet()) {
            pq.offer(new int[] {num, freq.get(num)});
        }

        int[] ans = new int[k];
        int i = 0;
        while(i< k) {
            ans[i] = pq.poll()[0];
            i++;
        }
        return ans;
    }
}
