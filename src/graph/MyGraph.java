package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph<Vertex> {
    protected final boolean undirected;
    protected final Map<Vertex, List<Edge<Vertex>>> graph;

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
        addEdge(from, to, 0);
    }

    public boolean hasVertex(Vertex v) {
        return graph.containsKey(v);
    }

    public boolean hasEdge(Vertex src, Vertex dest) {
        if (!hasVertex(src) || !hasVertex(dest)) return false;
        return graph.get(src).contains(new Edge<>(src, dest));
    }

    public List<Vertex> getAdjacentVertices(Vertex vertex) {
        if (!graph.containsKey(vertex)) return new ArrayList<>();

        // Using stream to extract all adjacent vertices from vertex
        return graph.get(vertex).stream().map(Edge::getDest).toList();
    }

    protected void addEdge(Vertex from, Vertex to, double weight) {
        if (!hasVertex(from)) addVertex(from);
        if (!hasVertex(to)) addVertex(to);
        if (hasEdge(from, to) || from.equals(to)) return;

        graph.get(from).add(new Edge<>(from, to, weight));
        if (undirected) graph.get(to).add(new Edge<>(to, from, weight));
    }
}
