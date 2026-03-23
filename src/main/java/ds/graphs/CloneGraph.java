package ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * PROBLEM: Clone Graph (LeetCode 133)  https://leetcode.com/problems/clone-graph/
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node contains a value and a list of its neighbors.
 *
 * APPROACH: DFS + HashMap
 *
 * ALGORITHM (Pseudocode):
 * 1. Create a HashMap to store original -> cloned node mapping
 * 2. If node is null, return null
 * 3. If node already cloned (exists in HashMap), return the clone
 * 4. Create new clone node with same value and empty neighbors list
 * 5. Store original -> clone mapping in HashMap (IMPORTANT: before processing neighbors!)
 * 6. For each neighbor of original node:
 *    - Recursively clone the neighbor
 *    - Add cloned neighbor to clone's neighbors list
 * 7. Return the cloned node
 *
 * KEY INSIGHT: HashMap prevents infinite loops in cyclic graphs and ensures each node is cloned exactly once
 *
 * TIME COMPLEXITY: O(N + E) where N = number of nodes, E = number of edges
 *                  - Visit each node once: O(N)
 *                  - Traverse each edge once: O(E)
 *
 * SPACE COMPLEXITY: O(N)
 *                   - HashMap stores N nodes: O(N)
 *                   - Recursion stack depth: O(N) in worst case
 *                   - Total: O(N)
 */

class Node {
    int value;
    List<Node> neighbors;

    public Node(int value, List<Node> neighbors) {
        this.value = value;
        this.neighbors = neighbors;
    }
}

public class CloneGraph {

    // HashMap to track: original node -> cloned node
    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        // Base Case 1: null check
        if (node == null) return null;

        // Base Case 2: already cloned (prevents cycles)
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Step 1: Create clone with same value, empty neighbors
        Node cloneNode = new Node(node.value, new ArrayList<>());

        // Step 2: Store mapping (MUST do before processing neighbors to handle cycles)
        visited.put(node, cloneNode);

        // Step 3: Clone all neighbors recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // Step 4: Return the cloned node
        return cloneNode;
    }

    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

        // Test Case 1: Two connected nodes (1 <-> 2)
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node cloned = solution.cloneGraph(node1);

        System.out.println("Original node value: " + node1.value);
        System.out.println("Cloned node value: " + cloned.value);
        System.out.println("Different objects? " + (node1 != cloned));
        System.out.println("Same neighbor count? " + (node1.neighbors.size() == cloned.neighbors.size()));
    }
}