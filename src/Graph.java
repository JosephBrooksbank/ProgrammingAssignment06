
import java.util.ArrayList;

/*
 *  Graph - directed graph
 *
 * @author Mike Goss <mikegoss@cs.du.edu>
 */
public class Graph {
  // Create a graph with specified number of vertices
  Graph() {
    v = new ArrayList<>();
  }

  public void AddVertex(String id){
    v.add(new Vertex(id));
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
  public void AddEdge(String srcString, String dstString, double weight) {

    Vertex src = null;
    Vertex dst = null;

    // Iterating through ArrayList of Vertices to find correct ones
    for (Vertex vert : v){
      // If matches the src String, point src to that
      if (vert.id.equals(srcString))
        src = vert;
      // same with dst
      if (vert.id.equals(dstString))
        dst = vert;
    }

    // If they don't exist, make new Vertex objects for them
    if (src == null){
      src = new Vertex(srcString);
      v.add(src);
    }
    if (dst == null){
      dst = new Vertex(dstString);
      v.add(dst);
    }

    // Add the edge between them
    src.AddEdge(dst, weight);
  }
  
  // Find root in DFS search tree of specified vertex
  ///// FINDROOT REMOVED /////
  
  // Vertex array for graph
  ArrayList<Vertex> v;
  
}

