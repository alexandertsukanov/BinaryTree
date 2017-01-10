package tsukanov.sp;

import java.util.TreeMap;

public class Dijkstra {

    private DirectedEdge[] edgeTo;
    public double[] distTo;
    private TreeMap<Integer, Double> pq = new TreeMap<>();

    public Dijkstra(EdgeWeightedGraph G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];


        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.MAX_VALUE;
            distTo[s] = 0;
            pq.put(s, 0d);
        }
        while(pq.size()>0)
        {
            int v = pq.firstKey();
            pq.remove(v);
            G.adj(v).forEach(this::relax);
        }
    }

    private void relax(DirectedEdge e)
    {
        int v = e.getFrom(), w = e.getTo();
        if (distTo[w] > distTo[v] +  e.getWeight())
        {
            distTo[w] = distTo[v] + e.getWeight();
            edgeTo[w] = e;
            if (pq.containsKey(w))
                pq.replace(w, distTo[w]);
            else
                pq.put(w, distTo[w]);
        }
    }

}
