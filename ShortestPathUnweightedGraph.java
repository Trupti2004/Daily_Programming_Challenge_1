import java.util.*;

public class ShortestPathUnweightedGraph {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { {0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4} };
        int start = 0;
        int end = 4;

        int shortestPathLength = findShortestPath(V, edges, start, end);
        System.out.println("Shortest Path Length: " + shortestPathLength);
    }

    public static int findShortestPath(int V, int[][] edges, int start, int end) {
        // Creating an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        // Start BFS from the start node
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // If the end node is found, return the distance
            if (current == end) {
                return distance[current];
            }

            // Traverse all neighbors of the current node
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // If the end node is not reachable, return -1
        return -1;
    }
}