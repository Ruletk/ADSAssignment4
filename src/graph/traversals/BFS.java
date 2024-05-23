package graph.traversals;

import graph.MyGraph;

import java.util.ArrayDeque;
import java.util.Deque;

public class BFS<Vertex> extends Search<Vertex> {
    private final MyGraph<Vertex> graph;

    public BFS(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;

        findPaths();
    }

    private void findPaths() {
        Deque<Vertex> queue = new ArrayDeque<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            Vertex cur = queue.poll();
            for (Vertex v : graph.getAdjacentVertices(cur)) {
                visited.add(v);
                queue.add(v);
                edgeTo.put(v, cur);
            }
        }
    }
}
