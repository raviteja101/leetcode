class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int i=0, j=0;
        int tempLength = 0;
        Set<Character> set = new HashSet<>();
        while(i < n && j < n) {
            if(set.isEmpty() || !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                tempLength = j-i;
                maxLength = Math.max(maxLength, tempLength);
            } else {
                while(!set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}