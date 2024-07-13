class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, result, 0);
        return result;
    }

    public void generatePermutations(int[] nums, List<List<Integer>> result, int index) {
        if(index== nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
        } 
        for(int i=index; i<nums.length; i++) {
            swap(nums, i, index);
            generatePermutations(nums, result, index+1);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;    
    }

}