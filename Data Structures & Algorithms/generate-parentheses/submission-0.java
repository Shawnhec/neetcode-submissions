class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, new char[2 * n], 0, 0, n);
        return ans;
    }

    public void backTrack(List<String> ans, char[] path, int open, int close, int n) {
        if(close == n) {
            ans.add(new String(path));
            return;
        }

        if(open < n) {
            path[open + close] = '(';
            backTrack(ans, path, open + 1, close, n);
        }

        if(close < open) {
            path[open + close] = ')';
            backTrack(ans, path, open, close + 1, n);
        }
    }
}
