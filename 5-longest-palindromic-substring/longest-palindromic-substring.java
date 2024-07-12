class Solution {
    public String longestPalindrome(String s) {
        
        String result = s.substring(0,1);
        
        for(int i=0; i<s.length()-1; i++) {
            String oddResult = checkPalindromeSubstring(s, i, i);
            String evenResult = checkPalindromeSubstring(s, i, i+1);
            
            if(oddResult.length() > result.length()) {
                result = oddResult;
            } 
            if(evenResult.length() > result.length()){
                result = evenResult;
            }
        }
        return result;
    }

    public String checkPalindromeSubstring(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }

}