class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int[] minCost = new int[n];
        int stops = 0;

        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int cost = flight[2];

            if (!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            adjList.get(source).add(new int[] { destination, cost });
        }

        Arrays.fill(minCost, Integer.MAX_VALUE);
        q.offer(new int[] { src, 0 });

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] currentNode = q.poll();
                if (adjList.containsKey(currentNode[0])) {
                    for (int[] neighbour : adjList.get(currentNode[0])) {
                        int price = neighbour[1];
                        int neighbourCity = neighbour[0];
                        if (price + currentNode[1] >= minCost[neighbourCity]) {
                            continue;
                        }
                        minCost[neighbourCity] = price + currentNode[1];
                        q.offer(new int[] { neighbourCity, minCost[neighbourCity] });
                    }
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];

    }
}