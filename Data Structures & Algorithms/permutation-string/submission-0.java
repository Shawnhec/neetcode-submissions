class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m > n) return false;
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        int[] chars1Freq = new int[26];

        for(char c : chars1) {
            c -= 'a';
            chars1Freq[c]++;
        }

        int[] window = new int[26];

        int left = -m + 1;
        for(int right = 0; right < n; right++) {
            
            char curr = chars2[right];
            window[curr - 'a']++;

            if(left < 0) {
                left++;
                continue;
            }

            int matchCnt = 0;
            for(int i = 0; i < 26; i++) {
                if(window[i] == chars1Freq[i]) matchCnt++;
            }
            if(matchCnt == 26) return true;
            
            char leaving = s2.charAt(left);
            leaving -= 'a';
            window[leaving]--;
            left++;
        }
        return false;
    }
}

/*

left = -1
right = 0

Input: s1 = "ab", 
             
       s2 = "lecabee"
                l
                 r
                 

freq : {a : 0, b : 1}

len(s1) = 3
l = 0
r = 0



*/
