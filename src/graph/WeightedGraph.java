package graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Class that contains graph. Using HashMap for contain vertex-edges mapping.
 *
 * @param <Vertex> Type of the vertex.
 */
public class WeightedGraph<Vertex> extends MyGraph<Vertex> {
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    private final boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
    }

    public void addVertex(Vertex v) {
        map.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(Vertex src, Vertex dest, double weight) {
        if (!hasVertex(src)) addVertex(src);
        if (!hasVertex(dest)) addVertex(dest);
        if (hasEdge(src, dest) || src.equals(dest)) return;
        if (hasEdge(src, dest)) return;

        map.get(src).add(new Edge<>(src, dest, weight));
        if (!directed) map.get(dest).add(new Edge<>(dest, src, weight));
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex src, Vertex dest) {
        if (!hasVertex(src) || !hasVertex(dest)) return false;
        return map.get(src).contains(new Edge<>(src, dest));
    }

    public List<Vertex> getAdjacentVertices(Vertex src) {
        if (!hasVertex(src)) return null;
        List<Edge<Vertex>> edges = map.get(src);

        return edges.stream().map(Edge::getDest).toList(); // Using stream to extract all dest vertices from src
    }
}
