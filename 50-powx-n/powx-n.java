class Solution {
    public double myPow(double x, int n) {

        if(x == 1.0) {
            return x;
        }
        if(x == -1.0 && n%2 == 0) {
            return -x;
        } 
        if(x == -1.0 && n%2 == 1) {
            return x;
        }
        if(n == 0) {
            return 1.0;
        }
        double result = 1.0;
        long exp = n;

        if(n< 0) {
            x = 1/x;
            exp = -exp;
        }
        
        while(exp > 0) {
            if(exp%2 == 1) {
                result *= x;
            } 
            x *= x;
            exp /= 2;
        }

        return result;
    }
}