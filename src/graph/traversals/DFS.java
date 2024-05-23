package graph.traversals;

import graph.MyGraph;

import java.util.Stack;

public class DFS<Vertex> extends Search<Vertex> {
    private final MyGraph<Vertex> graph;

    public DFS(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        this.graph = graph;

        findPaths(source);
    }

    private void findPaths(Vertex current) {
        visited.add(current);
        for (Vertex v : graph.getAdjacentVertices(current))
            if (!visited.contains(v)) {
                edgeTo.put(v, current);
                findPaths(v);
            }
    }
}
