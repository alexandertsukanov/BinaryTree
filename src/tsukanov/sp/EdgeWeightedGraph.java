package tsukanov.sp;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private  int V;


    private ArrayList<ArrayList<DirectedEdge>>  adj =  new ArrayList<>();

    List<DirectedEdge> lst = new ArrayList<DirectedEdge>();

    public Iterable<DirectedEdge> getEdges() {
        return lst;
    }

    public EdgeWeightedGraph(int V)
    {
        this.V = V;

        for (int v = 0; v < V; v++)
            adj.add(v, new ArrayList<DirectedEdge>());
    }


    public void addEdge(DirectedEdge e)
    {
        int v = e.getFrom();
        adj.get(v).add(e);
        lst.add(e);
    }

    public List<DirectedEdge> adj(int v)
    {
        return adj.get(v);
    }

    public int V()
    {
        return V;
    }

}

