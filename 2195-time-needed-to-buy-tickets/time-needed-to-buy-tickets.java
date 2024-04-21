class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<tickets.length; i++) {
            queue.offer(tickets[i]);
        }
        int i = 0;
        int n = queue.size();
        while(true) {
            int ticket = queue.remove();
            if(ticket <= 0) {
                queue.add(ticket);
            } else {
                count++;
                ticket--;
                if(i == k && ticket == 0) {
                    return count;
                }
                queue.add(ticket);
            }
            i++;
            i = i%n;
        }
    }
}