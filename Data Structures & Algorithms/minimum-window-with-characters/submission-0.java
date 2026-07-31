class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tm = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            tm.merge(t.charAt(i), 1, Integer::sum);
        }
        int distinctCnt = tm.size();
        int totalCnt = t.length();
        
        Map<Character, Integer> window = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int left = 0; 
        int searchDistinctCnt = 0;
        int searchTotalCnt = 0; 

        int min = Integer.MAX_VALUE;
        int ansL = 0, ansR = s.length();
        
        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(tm.containsKey(c)) {
                if(!window.containsKey(c)) searchDistinctCnt++;
                if(!window.containsKey(c) || window.get(c) < tm.get(c)) searchTotalCnt++;
            }


            window.merge(c, 1, Integer::sum);

            while(searchDistinctCnt >= distinctCnt && searchTotalCnt >= totalCnt) {
                char leaving = s.charAt(left);
                if(tm.get(leaving) == window.get(leaving)) {
                    searchTotalCnt--;
                }
                window.put(leaving, window.getOrDefault(leaving, 0) - 1);
                if(window.get(leaving) == 0) window.remove(leaving);

                if(!window.containsKey(leaving) && tm.containsKey(leaving)) searchDistinctCnt--;
                int tmp = min;
                min = Math.min(min, right - left + 1);
                if(min < tmp) {
                    ansL = left;
                    ansR = right;
                }
                left++;
            }
        }
        if(ansR - ansL == s.length()) return "";
        return s.substring(ansL, ansR + 1 );
    }
}


/*
Input: s = "OUZODYXAZX", t = "XXYZ"
                    r 

Output: "YXAZX"
            

distinctCnt = 3
totalCnt = 4

searchDistinctCnt = 3
searchTotalCnt = 4

tm = {X:2, Y:1, Z:1}
window = {O: 2, U: 1, Z: 2, D: 1, Y: 1, X: 2, A: 1, }


*/