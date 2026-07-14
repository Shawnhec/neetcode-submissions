/*
T : O(klogn + nlogn)
S : O(n)
*/
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // S : O(n)
//         Map<Integer, Integer> freq = new HashMap<>();                 // S : O(n)
//         for(int num : nums) {                                         // T : O(n)
//             freq.merge(num, 1, Integer::sum);
//         }
//         for(int num : freq.keySet()) {
//             pq.offer(new int[] {num, freq.get(num)});                // T : O(nlogn)
//         }

//         int[] ans = new int[k];
//         int i = 0;
//         while(i< k) {                                                // T : O(klogn)
//             ans[i] = pq.poll()[0];
//             i++;
//         }
//         return ans;
//     }
// }




class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freq.merge(nums[i], 1, Integer::sum);
        }
        
        List<Integer>[] cnts = new List[nums.length + 1];
        for(int num : freq.keySet()) {
            if(cnts[freq.get(num)] == null) {
                cnts[freq.get(num)] = new ArrayList<>();
            }
            cnts[freq.get(num)].add(num);
        }

        int i = nums.length;
        int j = 0;
        while(i > 0) {
            if(cnts[i] == null) {
                i--;
                continue;
            } 
            for(int num : cnts[i]) {
                if(j == k) break;
                res[j] = num;
                j++;
            }
            i--;
        }
        return res;
    }
}
