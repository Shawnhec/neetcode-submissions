class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int ans = 0;
        Set<Character> chars = new HashSet<>();
        while(right < s.length()) {
            if(chars.contains(s.charAt(right))) {
                ans = Math.max(ans, chars.size());
                while(chars.contains(s.charAt(right))) {
                    chars.remove(s.charAt(left));
                    left++;
                }
            }
            chars.add(s.charAt(right));
            right++;
        }
        return Math.max(ans,chars.size());
    }
}


/*
s = "zxyzxyz"
      l
         r

chars : {x,y,z }
*/