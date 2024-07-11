class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            int odd = countPalindromes(s, i, i);
            int even = countPalindromes(s, i, i+1);
            result += odd+even;
        }
        return result;
    }

    public int countPalindromes(String s, int l, int r) {
        int count = 0;
        while(l >=0 && r < s.length() && s.charAt(l--) == s.charAt(r++)) {
            count++;
        }
        return count;
    }
}