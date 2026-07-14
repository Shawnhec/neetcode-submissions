class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> operands = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        
        for(int i = 0; i < n; i++) {
            if(!operators.contains(tokens[i])) {
                operands.add(Integer.parseInt(tokens[i]));
            }
            else {
                int operand1 = operands.pop();
                int operand2 = operands.pop();
                int res = 0;
                if(tokens[i].equals("+")) {
                    res = operand1 + operand2;
                }
                else if(tokens[i].equals("-")) {
                    res = operand2 - operand1;
                }
                else if(tokens[i].equals("*")) {
                    res = operand1 * operand2;
                }
                else if(tokens[i].equals("/")) {
                    res = operand2 / operand1;
                }
                operands.push(res);
            }
        }
        return operands.pop();
    }
}
