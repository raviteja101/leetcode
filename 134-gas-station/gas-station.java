class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int currentGas = 0;
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0; i<n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost) {
            return -1;
        }
        for(int i=0; i<n; i++) {
            currentGas = currentGas + (gas[i]-cost[i]);
            if(currentGas < 0) {
                start = i+1;
                currentGas = 0;
            }
        }
        return start;

    }
}