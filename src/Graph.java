
import java.util.ArrayList;

/*
 *  Graph - directed graph
 *
 * @author Mike Goss <mikegoss@cs.du.edu>
 */
public class Graph {
  // Create a graph with specified number of vertices
  Graph(int numVertices) {
    v = new ArrayList<>(numVertices);
    for (int i = 0; i < numVertices; ++i) {
      v.add(new Vertex(i));
    }
  }
  
  // Copy constructor
  public Graph(Graph other) {
    v = new ArrayList<>(other.v.size());
    for (int i = 0; i < v.size(); ++i) {
      v.add(new Vertex(other.v.get(i)));
    }
  }
  
  ///// TRANSPOSE METHOD REMOVED /////
  
  // Get a vertex
  public Vertex getVertex(int i) {
    return v.get(i);
  }
  
  // Add an edge
  public void AddEdge(int src, int dst, int weight) {
    v.get(src).AddEdge(v.get(dst), weight);
  }
  
  // Find root in DFS search tree of specified vertex
  public int FindRoot(int u) {
    int i = u;
    while (v.get(i).p != Vertex.PNIL) {
      i = v.get(i).p;
    }
    return i;
  }
  
  // Vertex array for graph
  ArrayList<Vertex> v;
}
