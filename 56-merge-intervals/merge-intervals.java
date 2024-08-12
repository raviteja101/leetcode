class Solution {
    public int[][] merge(int[][] intervals) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedList = new ArrayList<>();

        for(int[] interval : intervals) {
            pq.add(new int[]{interval[0], interval[1]});
        }

        int currentEndTime = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            if(mergedList.isEmpty()) {
                mergedList.add(curr);
                currentEndTime = curr[1];
            } else {
                if(currentEndTime >= curr[0]) {
                    int[] prev = mergedList.remove(mergedList.size()-1);
                    prev[1] = Math.max(prev[1], curr[1]);
                    currentEndTime = prev[1];
                    mergedList.add(prev);
                } else {
                    mergedList.add(curr);
                    currentEndTime = curr[1];
                }
            }
        }

        int[][] result = new int[mergedList.size()][2];

        for(int i=0; i<mergedList.size(); i++) {
            int[] curr = mergedList.get(i);
            result[i][0] = curr[0];
            result[i][1] = curr[1];
        }

        return result;
    }
}