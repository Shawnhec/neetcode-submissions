class Solution {
    public int countSubstrings(String s) {
        int cnt = 0; 
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int l = i;
            int r = i; 
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }

        for(int i = 0; i < n; i++) {
            int l = i;
            int r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }
        
        return cnt;
    }
}