class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == ')' && stack.size() > 0) {
                stack.pop();
                sb.append(s.charAt(i));
            } else if(s.charAt(i) != ')'){
                sb.append(s.charAt(i));
            }
        }
        if(stack.size() > 0) {
            for(int i=sb.length()-1; i>=0; i--) {
                if(sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    stack.pop();
                }
                if(stack.size() == 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}