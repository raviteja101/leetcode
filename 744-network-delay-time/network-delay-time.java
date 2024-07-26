class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Integer> visited = new HashSet<>();
        int delay = 0;

        for(int i=0; i<times.length; i++) {
            int sourceNode = times[i][0];
            int destinationNode = times[i][1];
            int time = times[i][2];

            if(!adjList.containsKey(sourceNode)) {
                adjList.put(sourceNode, new ArrayList<>());
            }
            adjList.get(sourceNode).add(new int[]{destinationNode, time});
        }

        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int currentNode = current[1];

            if(visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);
            delay = Math.max(delay, time);
            List<int[]> neighbours = adjList.getOrDefault(currentNode, new ArrayList<>());
            for(int[] neighbour : neighbours) {
                int neighbourTime = neighbour[1];
                int neighbourNode = neighbour[0];
                int timeTillNow = time+neighbourTime;
                pq.offer(new int[]{timeTillNow, neighbourNode});
            }
        }

        if(visited.size() != n) {
            return -1;
        }

        return delay;

    }
}