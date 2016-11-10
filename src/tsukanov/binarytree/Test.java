package tsukanov.binarytree;

import java.util.PriorityQueue;

/**
 * Created by alex on 11/9/16.
 */
public class Test {

    public static void main(String[] args) {
        Tree tree = new Tree();


        tree.insert(2);
        tree.insert(3);
        tree.insert(0);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);
        tree.insert(4);
        tree.insert(8);


        System.out.println();
        tree.DFS(0);


    }

}
