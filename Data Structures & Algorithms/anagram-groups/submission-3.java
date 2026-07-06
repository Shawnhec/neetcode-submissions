class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String sortedStr = new String(strChars);
            if(!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }
            anagrams.get(sortedStr).add(str);
        }
        for(String str : anagrams.keySet()) {
            ans.add(anagrams.get(str));
        }
        return ans;
    }
}
