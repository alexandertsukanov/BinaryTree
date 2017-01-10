package tsukanov.sp;

public class DirectedEdge {

    private  int v,w;
    private double weight;


    private int from;
    private int to;

    public double getWeight() {

        return weight;
    }

    public int getFrom() {
        return v;
    }

    public int getTo() {
        return w;
    }

    //Constructors
    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
}
