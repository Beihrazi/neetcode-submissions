class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length, l=0,r=0;
        long sum=0;
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]){
                continue;
                }
                l = j+1;
                r = n-1;
                while(l<r){
                    sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum==target){
                        ls.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[l] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum>target){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
            
        }
        return ls;
        }
        
    }
