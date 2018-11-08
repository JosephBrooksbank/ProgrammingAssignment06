import java.util.PriorityQueue;

/**
 * Modified Implementation of Dijkstra's Algorithm from 24.3 in Intro to Algorithms
 * Modified to a less efficient version as found on canvas to allow for Java's implementation of Priority Queue
 *
 * @author Joseph Brooksbank
 */
public class DijkstraModified extends SingleSourceShortestPath {

    private PriorityQueue<Vertex> Q = new PriorityQueue<>();
    DijkstraModified(Graph graph, Vertex source){
        this.graph = graph;
        this.source = source;
    }

    void start(){
        initSingleSouce(source);
        Q.add(source);
        while (!Q.isEmpty()) {
            Vertex u = Q.poll();
            for (WeightedVertex v : u.adj){
                if (relax(u,v.vertex)){
                    if (Q.contains(v.vertex)){
                        Q.remove(v.vertex);
                    }
                    Q.add(v.vertex);
                }
            }
        }


    }
}
