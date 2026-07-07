class Solution {
    public List<String> letterCombinations(String digits) {
            if(digits.length() == 0) return new ArrayList<>();
            Map<Character, List<Character>> dials = new HashMap<>();
            dials.put('2', List.of('a', 'b', 'c'));
            dials.put('3', List.of('d', 'e', 'f'));
            dials.put('4', List.of('g', 'h', 'i'));
            dials.put('5', List.of('j', 'k', 'l'));
            dials.put('6', List.of('m', 'n', 'o'));
            dials.put('7', List.of('p', 'q', 'r', 's'));
            dials.put('8', List.of('t', 'u', 'v'));
            dials.put('9', List.of('w', 'x', 'y', 'z'));

            List<String> ans = new ArrayList<>();
            backTrack(digits.toCharArray(), dials, 0, new StringBuilder(), ans);
            return ans;
        }
  

    public void backTrack(char[] digits, Map<Character, List<Character>> dials, int i, StringBuilder sb, List<String> ans) {
        if(i >= digits.length) {
            ans.add(sb.toString());
            return;
        }

        for(char c : dials.get(digits[i])) {
            sb.append(c);
            backTrack(digits, dials, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
