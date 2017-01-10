package tsukanov.sp;

public class Test {

    public static void main(String[] args) {
        {

            EdgeWeightedGraph Gr = new EdgeWeightedGraph(8);

            DirectedEdge e01 = new DirectedEdge(0, 1, 5);
            DirectedEdge e07 = new DirectedEdge(0, 7, 8);
            DirectedEdge e10 = new DirectedEdge(1,0,15);
            DirectedEdge e17 = new DirectedEdge(1,7,23);
            DirectedEdge e71 = new DirectedEdge(7,1,7);
            DirectedEdge e70 = new DirectedEdge(7,0,6);
            Gr.addEdge(e01);
            Gr.addEdge(e07);
            Gr.addEdge(e10);
            Gr.addEdge(e17);
            Gr.addEdge(e71);
            Gr.addEdge(e70);

            //Алгоритм Деикстры
            System.out.println("Dijkstra Algorithm: ");
            Dijkstra d = new Dijkstra(Gr, 0);
            System.out.println(d.distTo[7]);
            System.out.println();

            //Алгоритм Беллмана-Форда
            System.out.println("Bellman-Ford Algorithm: ");
            BellmanFord bfsp = new BellmanFord(Gr, 0);
            System.out.println(bfsp.distTo[7]);
            System.out.println();

            //Алгоритм Флойда-Уоршолла
            System.out.println("Floyd-Warshall Algorithm: ");
            FloydWarshall fwsp = new FloydWarshall(Gr);
            System.out.println(fwsp.toString());
            System.out.println();

        }
    }
}
