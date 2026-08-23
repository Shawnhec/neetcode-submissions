class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = nextNum(n);
        while(slow != fast) {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        return slow == 1;
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