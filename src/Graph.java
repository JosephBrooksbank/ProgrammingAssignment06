
import java.util.ArrayList;

/*
 *  Graph - directed weighted graph
 *
 * @author Mike Goss <mikegoss@cs.du.edu>
 *
 *
 * Modifications by
 * @author Joseph Brooksbank
 * To allow use of String based IDs for vertices, and to allow weighted graphs
 * NOTE some methods which are irrelevant for shortest paths have been removed
 *
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


  /** Method to return info about the graph (number of edges, number of vertices */
  // This could have simply been an override of toString, but I felt it was best to have a separate method for clarity
  String getInfo(){
    int numVertices = v.size();
    int numEdges = 0;
    for (Vertex vertex : v){
      numEdges += vertex.adj.size();
      }

    return numVertices + "," + numEdges;
    }
  }


