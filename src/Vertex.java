/*
 *  Vertex - class for vertex data for directed graph
 *
 * @author Mike Goss <mikegoss@cs.du.edu>
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex implements Comparable {

  static double w(Vertex u, Vertex v){
    for (WeightedAdj anEdge : u.adj){
      if (anEdge.vertex.equals(v)){
        return anEdge.weight;
      }
    }
    throw new IllegalStateException("No edge between these vertices");
  }
  // Constructor
  Vertex(String id_) {
    id = id_;
    adj = new LinkedList<>();
    d = -1;
    f = -1;
    state = State.UNKNOWN;
    p = PNIL;
  }
  
  // Copy constructor
  public Vertex(Vertex other) {
    id = other.id;
    d = other.d;
    f = other.f;
    state = other.state;
    p = other.p;
    // Perform a deep copy (create all new vertices which are copies)
    adj = other.adj.stream().map(WeightedAdj::new).collect(Collectors.toList());
  }
  
  // Vertex ID and data
  public final String id;
  
  // DFS info
  public double d;         // discovery time
  public int f;         // finish time

  // compareTo - order by reverse finish time value
  @Override
  public int compareTo(Object o) {
    return ((Vertex)o).f - f;
  }
  
  public enum State { UNKNOWN, ACTIVE, DONE };
  State state;
  public String p;         // predecessor (pi)
  public static final String PNIL = null;  // nil predecessor
  
  // List of edges 
  public final List<WeightedAdj> adj;  // adjacent vertices
  
  // Add an edge to the graph from this vertex
  public void AddEdge(Vertex dest, double weight) {
    adj.add(new WeightedAdj(dest, weight));
  }

  public double w(Vertex v){
    for (WeightedAdj anEdge : adj){
      if (anEdge.vertex.equals(v)){
        return anEdge.weight;
      }
    }
    throw new IllegalStateException("No edge between these vertices");
  }

  @Override
  public boolean equals(Object obj) {
    Vertex v = (Vertex)obj;
    return id.equals(v.id);
  }
}




class WeightedAdj {

  WeightedAdj(Vertex vertex, double weight){
    this.vertex = vertex;
    this.weight = weight;
  }

  /** Copy constructor */
  WeightedAdj(WeightedAdj other){
    this.vertex = new Vertex(other.vertex);
    this.weight = other.weight;
  }
  Vertex vertex;
  double weight;

  @Override
  public String toString() {
    return vertex + ", " + weight;
  }
}
