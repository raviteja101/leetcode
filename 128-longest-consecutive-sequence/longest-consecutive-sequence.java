class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int result = 0;

        for(int i=0; i<nums.length; i++) {
            numSet.add(nums[i]);
        }
        Iterator<Integer> iterator = numSet.iterator();
        while(iterator.hasNext()) {
            int tempCount = 0;
            int num = iterator.next();
            if(!numSet.contains(num-1)) {
                while(numSet.contains(num)) {
                    tempCount++;
                    num++;
                }
                result = Math.max(result, tempCount);
            }
        }
        return result;
    }
}