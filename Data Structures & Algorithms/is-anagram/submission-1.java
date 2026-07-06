class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> sFreq = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sFreq.merge(c, 1, Integer::sum);
        }
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!sFreq.containsKey(c)) return false;
            sFreq.put(c, sFreq.getOrDefault(c, 0) - 1);
        }

        for(char c : sFreq.keySet()) {
            if(sFreq.get(c) != 0) return false;
        }
        return true;
    }
}


/*
r : 2
a : 2
c : 2
e : 1 

*/