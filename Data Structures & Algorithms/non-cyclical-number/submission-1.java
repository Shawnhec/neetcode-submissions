class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n != 1) {
            if(visited.contains(n)) return false;
            visited.add(n);
            n = nextNum(n);
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