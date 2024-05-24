# Assignment 4 from *Algorithms and Data Structures* course
In this repo, you'll find implementations of both weighted and unweighted graphs and 3 traversal methods: DFS, BFS and Dijkstra.

## Project structure
In src folder you can find graph package. There are classes that are related to graph:
- ### Edge
    Contains implementation of edges for graph. There's source, destination and weight inside this class.

- ### Vertex
    Simple class for storing Vertex. All graph implementations doesn't require this class, but let him be. This class contain only one parameter: data.

- ### MyGraph
    Class for common graph. This graph implies the absence of weights, but the implementation allows the presence of weights.
- ### WeightedGraph
    Class for weighted graph. Inherits from MyGraph and expands class for weighted graphs. Every edge have source, destination and weight. Weight must be grated than 0.