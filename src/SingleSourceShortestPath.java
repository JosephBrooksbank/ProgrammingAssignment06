public class SingleSourceShortestPath {
    Graph graph;


    /**
     * Method to initialize a Single Source Shorted Path Algorithm
     * @param source        The source of the path
     */
    public void initSingleSouce(Vertex source){
        for (Vertex v: graph.v){
            // Initializing Distances and Predecessors, v.d can't be -1 because negative graphs are allowed
            v.d = Integer.MAX_VALUE;
            // Using PNIL = -1 as defined in the Vertex class
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
    public boolean Relax(Vertex u, Vertex v){
        if (v.d > u.d + Vertex.w(u,v)){
            v.d = u.d + Vertex.w(u,v);
            v.p = u.id;
            return true;
        }
        return false;
    }
}
