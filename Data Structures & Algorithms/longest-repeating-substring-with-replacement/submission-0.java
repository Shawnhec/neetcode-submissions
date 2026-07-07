class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int ans = 0;
        HashMap<Character, Integer> charFreqs = new HashMap<>();
        for(int right = 0; right < n; right++) {
              char curr = s.charAt(right);
              charFreqs.merge(curr, 1, Integer::sum);
              int len = right - left + 1;
              int most = 0; 
              for(char c : charFreqs.keySet()) {
                most = Math.max(most, charFreqs.get(c));
              }
              if(len - most <= k) {
                ans = Math.max(ans, len);
              }
              while(right - left + 1 - most > k) {
                char leaving = s.charAt(left);
                charFreqs.put(leaving, charFreqs.getOrDefault(leaving, 0) - 1);
                left++;
                for(char c : charFreqs.keySet()) {
                    most = Math.max(most, charFreqs.get(c));
                 }
              }
        }
        return ans;
    }
}

/*
Input: s = "AAABABBBBBB", k = 1
             l 
                 r 



*/
