/*
 * Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 *     public Node() {
 *         val = 0;
 *         neighbors = new ArrayList<Node>();
 *     }
 *     public Node(int _val) {
 *         val = _val;
 *         neighbors = new ArrayList<Node>();
 *     }
 *     public Node(int _val, ArrayList<Node> _neighbors) {
 *         val = _val;
 *         neighbors = _neighbors;
 *     }
 * }
 */

class Solution {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Return the clone if this original node was already visited.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create and store the clone before exploring its neighbours.
        Node clone = new Node(node.val);
        visited.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
