class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        Map<Character, int[]> charMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!charMap.containsKey(c)) charMap.put(c, new int[]{i, i});
            else charMap.get(c)[1] = i;
        }

        List<int[]> intervals = new ArrayList<>();
        for(char c : charMap.keySet()) {
            intervals.add(charMap.get(c));
        }
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int i = 0;
        while(i < intervals.size()) {
            int min = intervals.get(i)[0];
            int max = intervals.get(i)[1];
            int j = i + 1;
            while(j < intervals.size() && max > intervals.get(j)[0]) {
                min = Math.min(min, intervals.get(j)[0]);
                max = Math.max(max, intervals.get(j)[1]);
                j++;
            }
            ans.add(max - min + 1);
            i = j;
        }

        return ans; 
    }
}



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