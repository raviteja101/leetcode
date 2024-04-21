class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closedCount = 0;
        int j = s.length()-1;
        for(int i=0; i<=j; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                openCount--;
            }
            if(s.charAt(j-i) == ')' || s.charAt(j-i) == '*') {
                closedCount++;
            } else {
                closedCount--;
            }
            if(openCount < 0 || closedCount < 0) {
                return false;
            }
        }
        return true;
    }
}