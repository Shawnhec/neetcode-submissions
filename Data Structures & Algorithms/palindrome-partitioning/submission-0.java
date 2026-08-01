class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backTrack(s, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    public void backTrack(String s, int strt, int end, List<String> lst, List<List<String>> ans) {
        if(strt == s.length()) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = end; i < s.length(); i++) {
            if(isPalindrome(s, strt, i)) {
                lst.add(s.substring(strt, i + 1));
            }
            else continue;

            backTrack(s, i + 1, i + 1, lst, ans);
            lst.removeLast();
        }

    }

    public boolean isPalindrome(String str, int strt, int end) {
        int left = strt, right = end;
        while(left <= right) {
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
