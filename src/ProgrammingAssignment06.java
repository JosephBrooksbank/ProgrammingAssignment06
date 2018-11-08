import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for Programming Assignment 06, runs and times the two algorithms in question
 */
public class ProgrammingAssignment06 {

    private static final long NUMBER_OF_RUNS = 100;
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

        float bfordTime = 0;
        float dijkTime = 0;

        // Writing output to file
        bford.start();
        graph.writeToFile(args[0] + ".bout");
        dijkstra.start();
        graph.writeToFile(args[0] + ".dout");

        // Timing algorithms
        for (int i = 0; i < NUMBER_OF_RUNS; i++){
            CpuTimer bfordTimer = new CpuTimer();
            bford.start();
            bfordTime += bfordTimer.getElapsedCpuTime();

            CpuTimer dijkTimer = new CpuTimer();
            dijkstra.start();
            dijkTime += dijkTimer.getElapsedCpuTime();

        }

        // Writing avg times to stdout
        bfordTime = bfordTime / NUMBER_OF_RUNS;
        dijkTime = dijkTime / NUMBER_OF_RUNS;
        System.out.println(graph.getInfo() + ",\"B\"," + bfordTime + ",\"" + args[0] + "\"");
        System.out.println(graph.getInfo() + ",\"D\"," + dijkTime + ",\"" + args[0] + "\"");


    }

}
