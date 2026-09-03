class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int column = matrix[0].length;
        int low = 0, high = matrix.length * column - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid/column;
            int col = mid%column;

            int val = matrix[row][col];
            if( val == target){
                return true;
            }else if(val > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
