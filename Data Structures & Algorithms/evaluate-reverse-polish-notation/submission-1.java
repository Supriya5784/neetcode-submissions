class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token:tokens){
            if(token.equals("+")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1+num2);
            }
            else if(token.equals("-")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1-num2);
            }
            else if(token.equals("*")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1*num2);
            }
            else if(token.equals("/")){
                int num2 = st.pop();
                int num1 = st.pop();
                st.push(num1/num2);
            }
            else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.peek();
    }
}
