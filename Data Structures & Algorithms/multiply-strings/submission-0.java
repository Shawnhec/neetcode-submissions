class Solution {
    public String multiply(String num1, String num2) {
        if((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0')) return "0";
        
        int[] res = new int[num1.length() + num2.length()];
        
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        num1 = sb1.reverse().toString();
        num2 = sb2.reverse().toString();

        for(int i = 0; i < num1.length(); i++) {
            int strt = i;
            for(int j = 0; j < num2.length(); j++) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int sum = (d1 * d2) + res[strt];
                int curr = sum % 10;
                res[strt] = curr;
                res[strt + 1] += sum / 10;
                strt++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = res.length - 1; i >= 0; i--) {
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        
        
        return sb.toString();
         
    }
}
