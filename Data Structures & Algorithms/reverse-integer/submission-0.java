class Solution {
    public int reverse(int x) {
        int cnt = 0;
        int ans = 0; 
        while(x != 0) {
            int mod = x % 10;
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) return 0;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10)) return 0;
            x /= 10;
            ans = ans * 10 + mod; 
            cnt++;
        }
        return ans;
    }
}


/*
x = 1
cnt = 2
ans = 43

mod = 2


*/