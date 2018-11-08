import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgrammingAssignment06 {

    public static void main(String[] args) throws FileNotFoundException{
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

        BellmanFord bford = new BellmanFord(graph, graph.v.get(0));

        bford.start();

        System.out.println();

    }

}
