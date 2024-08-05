class Solution {
    public int balancedString(String s) {
        int n = s.length();
        int target = n/4;      // QQQQEWWW
        int minLen = n;
        int left = 0;
        Map<Character, Integer> hm = new HashMap<>();

        hm.put('Q', 0);
        hm.put('W', 0);
        hm.put('E', 0);
        hm.put('R', 0);

        for(char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        for(int right=0; right<n; right++) {
            hm.put(s.charAt(right), hm.get(s.charAt(right))-1);
            
            while(left<n && (hm.get('Q') <= target && hm.get('W') <= target && 
            hm.get('E') <= target && hm.get('R') <= target)) {
                minLen = Math.min(minLen, right-left+1);
                hm.put(s.charAt(left), hm.get(s.charAt(left))+1);
                left++;
            }
        }

        return minLen;

    }
    
}