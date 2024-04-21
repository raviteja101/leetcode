class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck);
        int i = 0;
        int j = 0;
        boolean skip = false;
        while(j < n) {
            if(result[i] == 0) {
                if(!skip) {
                    result[i] = deck[j++];
                }
                skip = !skip;
            }
            i = (i+1)%n;
        }
        
        return result;
    }
}