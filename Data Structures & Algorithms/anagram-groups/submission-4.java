class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // S : O(mn)
        Map<String, List<String>> anagrams = new HashMap<>();
        
        List<List<String>> ans = new ArrayList<>();

        // T : O(m)
        for(String str : strs) {
            char[] strChars = str.toCharArray();        // T : O(n)
            Arrays.sort(strChars);                      // T : O(nlogn)
            String sortedStr = new String(strChars);    // T : O(n)
            if(!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }
            anagrams.get(sortedStr).add(str);
        }
        for(String str : anagrams.keySet()) {           // T : O(m)
            ans.add(anagrams.get(str));
        }
        return ans;
    }
}


/*
m = len(strs)
n = average length of string in strings

T : O(mn + mnlogn)
S : O(mn)

*/