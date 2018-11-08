/*
 *  Vertex - class for vertex data for directed graph
 *
 * @author Mike Goss <mikegoss@cs.du.edu>
 *
 * Modifications made by
 * @author Joseph Brooksbank
 * To allow for Vertex names using Strings and weighted graphs
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex implements Comparable {

  static double w(Vertex u, Vertex v){
//    for (WeightedVertex anEdge : u.adj){
//      if (anEdge.vertex.equals(v)){
//        return anEdge.weight;
//      }
//    }
//    throw new IllegalStateException("No edge between these vertices");

    return u.weights.get(v);
  }
  // Constructor
  Vertex(String id_) {
    id = id_;
    adj = new LinkedList<>();
    weights = new HashMap<>();
    d = -1;
    state = State.UNKNOWN;
    p = PNIL;
  }
  
  // Copy constructor
  public Vertex(Vertex other) {
    id = other.id;
    d = other.d;
    state = other.state;
    p = other.p;
    // Perform a deep copy (create all new vertices which are copies)
    adj = other.adj.stream().map(WeightedVertex::new).collect(Collectors.toList());
    weights = (HashMap<Vertex, Double>) other.weights.clone();
  }
  
  // Vertex ID and data
  public final String id;
  
  // DFS info
  public double d;         // discovery time

  // compareTo - order by reverse finish time value
  @Override
  public int compareTo(Object o) {
    return Double.compare(d, ((Vertex) o).d);
  }

  
  public enum State { UNKNOWN, ACTIVE, DONE };
  State state;
  public String p;         // predecessor (pi)
  public static final String PNIL = null;  // nil predecessor
  
  // List of edges 
  public final List<WeightedVertex> adj;  // adjacent vertices
  public final HashMap<Vertex, Double> weights; // Map of weights for adjacent vertices
  // Add an edge to the graph from this vertex
  public void AddEdge(Vertex dest, double weight) {

    adj.add(new WeightedVertex(dest, weight));
    weights.put(dest, weight);
  }


  @Override
  public boolean equals(Object obj) {
    Vertex v = (Vertex)obj;
    return id.equals(v.id);
  }
}


/**
 * Tuple class to allow for weighted edges with minimal changes to code elsewhere
 */
class WeightedVertex {

  WeightedVertex(Vertex vertex, double weight){
    this.vertex = vertex;
    this.weight = weight;
  }

  /** Copy constructor */
  WeightedVertex(WeightedVertex other){
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
