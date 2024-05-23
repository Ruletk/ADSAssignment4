package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> graph;

    public MyGraph() {
        this(false);
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        graph = new HashMap<>();
    }

    public void addVertex(Vertex vertex) {
        graph.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex from, Vertex to) {
        if (!graph.containsKey(from)) addVertex(from);
        if (!graph.containsKey(to)) addVertex(to);
        graph.get(from).add(new Edge<>(from, to));
    }

    public List<Vertex> getAdjacentVertices(Vertex vertex) {
        if (!graph.containsKey(vertex)) return new ArrayList<>();
        List<Vertex> adjacentVertices = new ArrayList<>();
        for (Edge<Vertex> edge : graph.get(vertex))
            adjacentVertices.add(edge.getDest());
        return adjacentVertices;
    }
}
