import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for Programming Assignment 06, runs and times the two algorithms in question
 */
public class ProgrammingAssignment06 {

    public static void main(String[] args) throws FileNotFoundException{

        // Reading graph from file into a Graph object
        Scanner fileIn = new Scanner(new FileInputStream(args[0]));
        Graph graph = new Graph();
        while (fileIn.hasNextLine()){
            String line = fileIn.nextLine();
            Scanner readLine = new Scanner(line);
            String src = readLine.next();
            while (readLine.hasNext()){
                String dst = readLine.next();
                double weight = readLine.nextDouble();
                graph.AddEdge(src, dst, weight);
            }
        }

        // Creating search algorithms
        BellmanFord bford = new BellmanFord(graph, graph.v.get(0));
        DijkstraModified dijkstra = new DijkstraModified(graph, graph.v.get(0));

        // TODO time them here
        dijkstra.start();
        bford.start();

        // TODO write output to file
        System.out.println(graph.getInfo());
        System.out.println();

    }

}
