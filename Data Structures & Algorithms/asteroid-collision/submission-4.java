class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        for(int cur : asteroids){
            boolean destroy = false;

            if(cur < 0){
                while(!st.isEmpty() && st.peek() > 0){
                    
                    if(st.peek() < Math.abs(cur)){
                        st.pop();
                    }else if(st.peek() == Math.abs(cur)){
                        st.pop();
                        destroy = true;
                        break;
                    }else{
                        destroy = true;
                        break;
                    }
                }
            }
            if(!destroy){
               st.push(cur) ;
            }
        }
        int res[] = new int[st.size()];
        for(int i = st.size() - 1;i>= 0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}