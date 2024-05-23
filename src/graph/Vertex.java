package graph;

import java.util.Objects;

public class Vertex<V> {
    private final V data;

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
