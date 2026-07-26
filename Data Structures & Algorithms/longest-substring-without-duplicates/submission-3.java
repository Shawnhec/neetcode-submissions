class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int max = 0;
        Set<Character> window = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            if(!window.contains(s.charAt(right))) window.add(s.charAt(right));
            else {
                max = Math.max(max, right - left);
                while(window.contains(s.charAt(right))) {
                    window.remove(s.charAt(left));
                    left++;
                }
                window.add(s.charAt(right));
            }
        }
        return Math.max(max, s.length() - left);
    }
}


/*
"xzyzxyz"
   l 
    r
*/