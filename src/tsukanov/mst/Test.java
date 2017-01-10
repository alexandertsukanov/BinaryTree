package tsukanov.mst;

public class Test {

    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(7, 6);

        //Алгоритм Прима
        PrimMST mst = new PrimMST(G);
        for (Edge e : mst.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst.weight());
        System.out.println();

        //Алгоритм Крускала
        KruskalMST mst2 = new KruskalMST(G);
        for (Edge e : mst2.edges()) {
            System.out.println(e);
        }
        System.out.printf("%.5f\n", mst2.weight());
    }

}
