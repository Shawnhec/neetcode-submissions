/*
T : O(n + *log*)
S : O(*)
*/

// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         int n = s.length();
//         List<Integer> ans = new ArrayList<>();                      
//         Map<Character, int[]> charMap = new HashMap<>();                    // S : O(*)
//         for(int i = 0; i < n; i++) {                                        // T : O(n)
//             char c = s.charAt(i);           
//             if(!charMap.containsKey(c)) charMap.put(c, new int[]{i, i});
//             else charMap.get(c)[1] = i;
//         }

//         List<int[]> intervals = new ArrayList<>();                          // S : O(*)
//         for(char c : charMap.keySet()) {                                    // T : O(*)
//             intervals.add(charMap.get(c));
//         }
//         Collections.sort(intervals, (a, b) -> a[0] - b[0]);                 // T : O(*log*)
//                                                                             // S : O(log*)
//         int i = 0;                                                           
//         while(i < intervals.size()) {                                       // T : O(*)
//             int min = intervals.get(i)[0];
//             int max = intervals.get(i)[1];
//             int j = i + 1;
//             while(j < intervals.size() && max > intervals.get(j)[0]) {
//                 min = Math.min(min, intervals.get(j)[0]);
//                 max = Math.max(max, intervals.get(j)[1]);
//                 j++;
//             }
//             ans.add(max - min + 1);
//             i = j;
//         }

//         return ans; 
//     }
// }



/*
Input: s = "xyxxyzbzbb i s l"  
            0123456789101112

x: 0, 3
y: 1, 4
z: 5, 7
b: 6, 9
i:10,10
s:11,11
l:12,12

*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();                      
        Map<Character, Integer> lastIndexOf = new HashMap<>();  
        for(int i = 0; i < n; i++) {
            lastIndexOf.put(s.charAt(i), i);
        }                
        
        int farthest = 0, size = 0;
        for(int i = 0; i < n; i++) {
            size++;
            farthest = Math.max(lastIndexOf.get(s.charAt(i)), farthest);
            
            if(i == farthest) {
                ans.add(size);
                size = 0;
            }
        }
        
        return ans; 
    }
}
