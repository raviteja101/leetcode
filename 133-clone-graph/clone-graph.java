/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visitedMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        if(node == null) {
            return null;
        }

        q.add(node);
        Node clonedRoot = new Node(node.val);
        visitedMap.put(node, clonedRoot);

        while(!q.isEmpty()) {
            Node currentNode = q.poll();
            Node currentClonedNode = visitedMap.get(currentNode);
            List<Node> neighbours = currentNode.neighbors;
            for(Node neighbour : neighbours) {
                Node clonedNeighbour = new Node(neighbour.val);
                if(visitedMap.get(neighbour) == null) {
                    visitedMap.put(neighbour, clonedNeighbour);
                    q.add(neighbour);
                }
                currentClonedNode.neighbors.add(visitedMap.get(neighbour));
            }
        }
        return clonedRoot;
    }
}