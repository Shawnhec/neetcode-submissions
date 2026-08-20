class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int num : hand) cnts.merge(num, 1, Integer::sum);
        
        Arrays.sort(hand);
        for(int i = 0; i < n; i++) {
            if(cnts.get(hand[i]) > 0) {
                for(int j = hand[i]; j < hand[i] + groupSize; j++) {
                    if(!cnts.containsKey(j) || cnts.get(j) == 0) return false;
                    cnts.put(j, cnts.getOrDefault(j, 0) - 1);
                }
            }
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