class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;

        if(nums[low] < nums[high]) {
            return nums[low];
        }

        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] < nums[high]) {
                high = mid-1;
                min = Math.min(min, nums[mid]);
            } else {
                low = mid+1;
                min = Math.min(min, nums[mid]);
            }
        }
        return min;
    }
}