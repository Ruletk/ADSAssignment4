package graph.traversals;

import java.util.*;

public class Search<Vertex> {
    Set<Vertex> visited = new HashSet<>();
    Map<Vertex, Vertex> edgeTo = new HashMap<>();
    final Vertex source;

    public Search(Vertex source) {
        this.source = source;
    }

    public boolean hasPathTo(Vertex dest) {
        return visited.contains(dest);
    }

    public Iterable<Vertex> pathTo(Vertex dest) {
        if (!hasPathTo(dest)) return null;
        List<Vertex> trail = new ArrayList<>();

        for (Vertex v = dest; v != null; v = edgeTo.get(v))
            trail.add(v);

        return trail;
    }
}
