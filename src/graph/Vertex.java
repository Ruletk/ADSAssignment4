package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public void addAdjacentVertices(Vertex<V> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

    public V getData() {
        return data;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, adjacentVertices);
    }
}
