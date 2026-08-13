class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(s.toCharArray(), n - 1, memo);
    }


    public int dp(char[] s, int i, int[] memo) {
        if(i == 0 && s[i] == '0') return 0;
        if(i < 0 || (i == 0 && s[i] != 0)) return 1;

        if(memo[i] != -1) return memo[i];

        
        int curr = s[i] - '0';
        int prev = s[i - 1] - '0';
        
        int oneLetter = 0;
        int twoLetters = 0;

        if(curr > 0 && curr <= 9) {
            oneLetter = dp(s, i - 1, memo);
        }
        
        int comb = prev * 10 + curr;
        if(comb >= 10 && comb <= 26) {
            twoLetters = dp(s, i - 2, memo);
        }
        
        if(comb > 26 && comb % 10 == 0) return 0;
    
        return memo[i] = oneLetter + twoLetters;
    }
}



/*
13

AC

A B C D E F G H I  J  K  L  M  N  O  P  Q  R S T U V 
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17


1212 
->
ABAB
LL
ABL
LAB



1012

1210

*/