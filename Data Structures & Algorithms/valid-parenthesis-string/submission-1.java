class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        return dp(s, 0, 0, memo);
    }

    public boolean dp (String s, int i, int left , Boolean[][] memo) {
        if(i == s.length() && left == 0) return true ;
        if(i == s.length() && left != 0) return false;
        if(left < 0) return false;

        

        if(memo[i][left] != null) return memo[i][left];
        
        char c = s.charAt(i);
        boolean res = false;
        if(c != '*') {
            if(c == '(') res = dp(s, i + 1, left + 1, memo);
            if(c == ')') res = dp(s, i + 1, left - 1, memo);
            return memo[i][left] = res;
        }
        
        //left
        boolean open = dp(s, i + 1, left + 1, memo);

        //right 
        boolean end = dp(s, i + 1, left - 1, memo);

        //space
        boolean space = dp(s, i + 1, left, memo);

        res = open|| end || space;
        return memo[i][left] = res; 
    }
}


/*
()*)

leftMin = 1 
leftMax = 2 

(*))

*/