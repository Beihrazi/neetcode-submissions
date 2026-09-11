class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        int n = position.length;
        for(int i=0;i<n;i++){
            cars.add(new int[] {position[i], speed[i]});
        }
        Collections.sort(cars, (a,b) -> Integer.compare(b[0], a[0]));
        // (0,1) (1,2) (4,2) (7,1)
        Stack<Double> st = new Stack<>();

        for(int i=0;i<n;i++){
            double ac = (double)(target - cars.get(i)[0])/cars.get(i)[1];

            if(!st.isEmpty()){
                if(ac > st.peek()){
                    st.push(ac);
                }
            }else{
                st.push(ac);
            }
        }
        return st.size();
    }
}
