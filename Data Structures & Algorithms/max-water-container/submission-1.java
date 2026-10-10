class Solution {
    public int maxArea(int[] heights) {
        int leftmost=0, rightmost = 0, left =0, right = heights.length - 1;
        int dis = 0, res =0;

        while(left < right){
            if(heights[left] < heights[right]){
                leftmost = Math.max(leftmost, heights[left]);
                dis = right - left;
                res = Math.max(res, dis * heights[left]);
                left++;
            }else{
                rightmost = Math.max(rightmost, heights[right]);
                dis = right - left;
                res = Math.max(res, dis * heights[right]);
                right--;
            }
        }
        return res;
    }
}
