class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        
        Map<Integer, Integer> cnts = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();
        for(int num : hand) {
            if(!cnts.containsKey(num)) {
                cnts.put(num, 0);
                pq.offer(num);
            }
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }

        while(!pq.isEmpty()) {
            if(cnts.isEmpty()) return true;
            int curr = pq.peek();
            if(!cnts.containsKey(curr)) {
                pq.poll();
                continue;
            }
            for(int i = 0; i < groupSize; i++) {
                if(!cnts.containsKey(curr + i)) return false;
                cnts.put(curr + i, cnts.getOrDefault(curr + i, 0) - 1);
                if(cnts.get(curr + i) == 0) cnts.remove(curr + i);
            }
            if(!cnts.containsKey(curr)) pq.poll();
        }
        return true;
    }
}


/*
Input: hand = [1,2,3,3,4,5,6,7], groupSize = 4

[1,2,3,3,4,5,6,7]

[1,2,3,4]


Input: hand = [1,2,4,2,3,5,3,4], groupSize = 4
[1,2,2,3,3,4,4,5]
[1,2,3,4],[2,3,4,5]


map:
6 : 1
7 : 1 
8 : 1

pq: 
3 -> 4 -> 5 -> 6 -> 7 -> 8




*/