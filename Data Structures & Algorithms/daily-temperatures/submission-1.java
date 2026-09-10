class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();
        if(st.isEmpty()){
            st.add(n-1);
        }
        int index = -1;
        for(int i = n - 2; i>=0;i--){
            int cur = temperatures[i];
            
            while(!st.isEmpty() && cur >= temperatures[st.peek()]){
                st.pop();
            }
            if(!st.isEmpty() && cur < temperatures[st.peek()]){
                index = st.peek() - i;
                res[i] = index;
            }
            st.add(i);
        }
        return res;
    }
}
