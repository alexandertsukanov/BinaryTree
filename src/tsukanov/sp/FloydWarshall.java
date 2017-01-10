package tsukanov.sp;

public class FloydWarshall {


    private double[][] weight_matrix;
    private int[][] history_matrix;

    public FloydWarshall(EdgeWeightedGraph Gr) {

        weight_matrix = new double[Gr.V()][Gr.V()];

        history_matrix = new int[Gr.V()][Gr.V()];

        for (int i = 0; i < weight_matrix[0].length; i++)
            for (int j = 0; j < weight_matrix[1].length; j++) {
                weight_matrix[i][j] = Double.MAX_VALUE;
                history_matrix[i][j] = 0;
            }

        for (DirectedEdge edge : Gr.getEdges()) {
            weight_matrix[edge.getFrom()][edge.getTo()] = edge.getWeight();
            history_matrix[edge.getFrom()][edge.getTo()] = edge.getTo();
        }
        for (int A = 0; A < Gr.V(); A++)
            for (int B = 0; B < Gr.V(); B++)
                if (weight_matrix[A][B] != Double.MAX_VALUE)
                    for (int C = 0; C < Gr.V(); C++)
                        if (weight_matrix[A][C] > weight_matrix[A][B] + weight_matrix[B][C]) {
                            weight_matrix[A][C] = weight_matrix[A][B] + weight_matrix[B][C];
                            history_matrix[A][C] = history_matrix[A][B];
                        }
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Shortest paths weight matrix(FROM = ROW, TO = COLUMN):\n");
        for (int i = 0; i < weight_matrix[0].length; i++) {
            for (int j = 0; j < weight_matrix[0].length; j++) {
                if (weight_matrix[i][j] != Double.MAX_VALUE)
                    str.append(weight_matrix[i][j] + "  ");
                else
                    str.append("0 ");
            }
            str.append("\n");
        }
        str.append("History matrix:\n");
        for (int i = 0; i < history_matrix[0].length; i++) {
            for (int j = 0; j < history_matrix.length; j++) {
                str.append(history_matrix[i][j] + " ");
            }
            str.append("\n");
        }
        return str.toString();

    }
}
