package graph;

/**
 * Class that contains graph. Using HashMap for contain vertex-edges mapping.
 *
 * @param <Vertex> Type of the vertex.
 */
public class WeightedGraph<Vertex> extends MyGraph<Vertex> {

    public WeightedGraph() {
        super();
    }

    public WeightedGraph(boolean undirected) {
        super(undirected);
    }

    public void addEdge(Vertex src, Vertex dest, double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        super.addEdge(src, dest, weight);
    }
}
