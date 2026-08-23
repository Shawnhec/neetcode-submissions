class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(slow != 1 && fast != 1) {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
            if(fast == 1) return true;
            if(slow == fast) return false;
        }
        return true;
    }


    public int nextNum(int num) {
        int res = 0;
        while(num != 0) {
            res += Math.pow(num % 10, 2);
            num = num / 10;
        }
        return res;
    }
}


/*
12 % 10 = 2



*/