class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int leftMin = 0;
        int leftMax = 0;
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                leftMin++;
                leftMax++;
            }
            else if(c == ')') {
                leftMin--;
                leftMax--;
            }
            else {
                leftMax++;
                leftMin--;
            }
             if(leftMin < 0) leftMin = 0;
             if(leftMax < 0) return false;
        }
        if(leftMin == 0) return true;
        return false;
    }
}


/*
()*)

leftMin = 1 
leftMax = 2 

(*))

*/