class Solution {
    public int evalRPN(String[] tokens) {
        //1,2, 3,4
        //+,*,-
        //3*3 = 9-4 = 5
        Stack<Integer> operand = new Stack<>();

        for(String st : tokens){
            if(st.equals("+") || st.equals("-") || st.equals("*") ||   st.equals("/")){
            int first = operand.pop();    
            int second = operand.pop();    
            
            if(st.equals("+")){
                operand.add(second + first);
            }else if (st.equals("-")){
                operand.add(second - first);
            }else if(st.equals("*")){
                operand.add(second * first);
            }else{
                operand.add(second/first);
            }
        }
            else{
                int no = Integer.parseInt(st);
                operand.add(no);
            }
        }
        return operand.peek();
    }
}
