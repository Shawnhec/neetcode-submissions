/*
T : O(nlogn)
S : O(n)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length < 2) return stones[0];
        // T : O(nlogn)
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) {
            maxHeap.offer(stone);
        }


        // T : O(nlogn)
        while(maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int diff = first - second;
            if(diff == 0) continue;
            maxHeap.offer(diff);
        }

        if(maxHeap.size() == 0) return 0;
        return maxHeap.peek();
    }
}
