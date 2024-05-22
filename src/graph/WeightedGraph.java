package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that contains graph. Using HashMap for contain vertex-edges mapping.
 *
 * @param <Vertex> Type of the vertex.
 */
public class WeightedGraph<Vertex> {
    private final Map<graph.Vertex<Vertex>, List<Edge<Vertex>>> map = new HashMap<>();
}
