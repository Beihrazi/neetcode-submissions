class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = heights.length, width = 0, res = 0, rectangle = 0;
        
        for(int i=1;i<=n;i++){     
            
            int currentHeight = (i == n) ? 0 : heights[i];

            if(heights[st.peek()] <= currentHeight){
                st.add(i);
            }else{
                while(!st.isEmpty() && heights[st.peek()] >  currentHeight){
                    int height = st.pop();

                    if(st.isEmpty()){
                        width = i;
                    }else{
                        width = i - st.peek()-1;
                    }

                    rectangle = heights[height] * width;
                    res = Math.max(res, rectangle);

                }
                    st.add(i);

            }
        }
        return res;
    }
}
