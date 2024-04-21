class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0, j = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result = 0;
        while(j < nums.length) {
            hm.put(nums[j], hm.getOrDefault(nums[j], 0)+1);
            while(hm.get(nums[j]) > k) {
                hm.put(nums[i], hm.get(nums[i])-1);
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }
}