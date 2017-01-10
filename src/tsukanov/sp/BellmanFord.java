package tsukanov.sp;

public class BellmanFord {


        public double[] distTo;
        public int[] predecessors;

        public BellmanFord(EdgeWeightedGraph G, int s)
        {
            predecessors = new int[G.V()];
            distTo = new double[G.V()];
            for(int i = 0;i<distTo.length;i++)
            {
                distTo[i] = Integer.MAX_VALUE;
            }

            distTo[s] = 0;

            for(int i=1;i<G.V();i++)
                for(DirectedEdge edge : G.getEdges())
            {
                if(distTo[edge.getFrom()] + edge.getWeight() < distTo[edge.getTo()])
                {
                    distTo[edge.getTo()] = distTo[edge.getFrom()] + edge.getWeight();
                    predecessors[edge.getTo()] = edge.getFrom();
                }
            }

            for(DirectedEdge edge : G.getEdges())
            {
                if (distTo[edge.getFrom()]+edge.getWeight()<distTo[edge.getTo()])
                {
                    System.out.println(("Graph contains cycles of negative length"));
                }
            }
        }

}
