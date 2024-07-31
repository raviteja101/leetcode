class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Character> stack = new Stack<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, 2*left);
            } else if(right > left) {
                left = right = 0;
            }
        }
        left = right = 0;

        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if(left == right) {
                maxLength = Math.max(maxLength, 2*left);
            } else if(left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }
}