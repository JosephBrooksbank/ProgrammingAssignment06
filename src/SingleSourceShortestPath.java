/**
 * Parent class for any Single Source Shortest Path algorithms
 */
public class SingleSourceShortestPath {
    Graph graph;
    Vertex source;

    /**
     * Method to initialize a Single Source Shorted Path Algorithm
     * @param source        The source of the path
     */
    void initSingleSouce(Vertex source){
        for (Vertex v: graph.v){
            // Initializing Distances and Predecessors
            // If negative weight graphs were allowed, this would have to be changed
            v.d = -1;
            // Using PNIL = null as defined in the Vertex class
            v.p = Vertex.PNIL;
        }

        source.d = 0;
    }

    /**
     * Method to relax an edge between two vertices
     * @param u     The first vertex
     * @param v     The second vertex
     * @return      Whether or not the distance was changed (Modification as specified by the assignment)
     */
    public boolean relax(Vertex u, Vertex v){
        if (v.d > u.d + Vertex.w(u,v)){
            v.d = u.d + Vertex.w(u,v);
            v.p = u.id;
            return true;
        }
        return false;
    }

}
