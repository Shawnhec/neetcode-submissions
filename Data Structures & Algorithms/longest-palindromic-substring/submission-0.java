// class Solution {
//     public String longestPalindrome(String s) {
//         int n = s.length();
//         int[] memo = new int[n];
//         return dp(s, memo, n - 1);
//     }

//     public int dp(String s, int[] memo, int i) {
//         if(i < 0) return 0; 
//         if(i == 0) return 1; 
//         String subStr = s.substring()
//         return memo[i] = 
//     }

//     public boolean isPalindrome(String str) {
//         int left = 0, right = str.length() - 1; 
//         while(left <= right) {
//             if(s.charAt(left) != s.charAt(right)) return false;
//             left++; 
//             right--;
//         }
//         return true;
//     }
// }



class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0; 
        int ansL = 0, ansR = 0;
        for(int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 >= max) {
                    max = Math.max(max, r - l + 1);
                    ansL = l;
                    ansR = r;
                }
                l--;
                r++;
            }
        }

        for(int i = 0; i < n; i++) {
            int l = i;
            int r = i + 1;
             while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 >= max) {
                    max = Math.max(max, r - l + 1);
                    ansL = l;
                    ansR = r;
                }
                l--;
                r++;
            }
        }
        
        return s.substring(ansL, ansR + 1);
  
    }
}

