class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    public void mergeSort(int[] nums, int left, int right){
        if(left>=right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }
    public void merge(int[] nums, int left, int mid, int right){
        int l = mid-left + 1;
        int r = right - mid;

        int[] n1 = new int[l];
        int[] n2 = new int[r];

        for(int i=0;i<n1.length;i++){
            n1[i] = nums[left+i];
        }
        for(int j=0;j<n2.length;j++){
            n2[j] = nums[mid+1+j];
        }

        int i=0,j=0,k=left;
        while(i<n1.length && j<n2.length){
            if(n1[i]<n2[j]){
                nums[k++] = n1[i++];
            }else{
                nums[k++] = n2[j++];
            }
        }

        while(i<n1.length){
            nums[k++] = n1[i++];
        }
        while(j<n2.length){
            nums[k++] = n2[j++];
        }

    }
}