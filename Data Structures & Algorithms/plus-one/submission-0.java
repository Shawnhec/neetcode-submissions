class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> lst = new ArrayList<>();
        int carry = 1;
        for(int i = n - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            int curr = sum % 10;
            carry = sum / 10;
            lst.add(curr);
        }
        if(carry != 0) lst.add(carry);
        
        n = lst.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[n - 1 - i] = lst.get(i);
        }
        return ans;
    }
}
