class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n= people.length;
        int l=0, r = n-1, res=0;
        while(l<=r){
            if(people[l] + people[r] <= limit){
                res+= 1;
                r--;
                l++;
            }else{
                res+= 1;
                r--;
            }  
        }
        return res;
    }
}