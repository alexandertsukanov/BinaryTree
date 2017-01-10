package tsukanov.binarytree;


public class Tree {

    private Node root;
    private int Nodes = 0;


    public Tree() {
        this.root = null;
    }

    public int getNodes() {
        return Nodes;
    }

    public void setNodes(int nodes) {
        Nodes = nodes;
    }

    public void insert(int data) {
        root = insert(root, data, null);
    }

    private Node insert(Node current, int data, Node parent) {
        if (current == null) {
            if(find(data) != null){
                throw new IllegalArgumentException("Vertex can't be duplicated");
            }
            current = new Node();
            current.setData(data);
            current.setLeft(null);
            current.setRight(null);
            current.setParent(parent);
            Nodes++;
        } else if (data < current.getData()) {
            current.setLeft(insert(current.getLeft(), data, current));
        } else {
            current.setRight(insert(current.getRight(), data, current));
        }
        return current;
    }

    public Node find(int data) {
        return find(root, data);
    }


    private Node find(Node current, int data) {
        if (current == null)
            return null;
        if (current.getData() == data)
            return current;
        return find(data < current.getData() ? current.getLeft() : current.getRight(), data);
    }

    public Node findMin(Node min) {
        min = root;
        if (min == null) return null;
        while (min.getLeft() != null) {
            min = min.getLeft();
        }
        return min;
    }


    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node startNode, int data) {
        Node element = find(startNode, data);
        if (element == null) return startNode;
        boolean hasParent = element.getParent() != null;
        boolean isLeft = hasParent && element.getData() < element.getParent().getData();
        if (element.getLeft() == null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(null);
                } else {
                    element.getParent().setRight(null);
                }
            }
        } else if (element.getLeft() != null && element.getRight() == null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getLeft());
                } else {
                    element.getParent().setRight(element.getLeft());
                }
            } else {
                startNode = element.getLeft();
            }
        } else if (element.getLeft() == null && element.getRight() != null) {
            if (hasParent) {
                if (isLeft) {
                    element.getParent().setLeft(element.getRight());
                } else {
                    element.getParent().setRight(element.getRight());
                }
            } else {
                startNode = element.getRight();
            }
        } else {
            Node rightMin = findMin(element.getRight());
            element.setData(rightMin.getData());
            return delete(rightMin, rightMin.getData());
        }
        element = null;
        return startNode;
    }

    public int height() {
        if(root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    private int height(Node current) {
        if(current == null) return 0;
        return 1 + Math.max(height(current.getLeft()), height(current.getRight()));
    }

    public void traverseTree(TraverseType traverseType) {
        traverseTree(root, traverseType);
        System.out.println();

    }

    private void traverseTree(Node current, TraverseType traverseType) {
        if (current == null)
            return;
        switch (traverseType) {
            case INORDER:
                traverseTree(current.getLeft(), traverseType);
                System.out.println(current.getData());
                traverseTree(current.getRight(), traverseType);
                break;
            case PREORDER:
                System.out.println(current.getData());
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                break;
            case POSTORDER:
                traverseTree(current.getLeft(), traverseType);
                traverseTree(current.getRight(), traverseType);
                System.out.println(current.getData());
                break;
        }
    }

    public void DFS(int v) {
        if (find(v) == null)
            return;
        Node current = find(v);
        current.isVisited = true;
        System.out.println(current.getData());
        System.out.println(current.getParent());
        DFS(current.getLeft());
        DFS(current.getRight());
    }

    private void DFS(Node current) {

        if (current == null)
            return;
        System.out.println(current.getData());

        current.isVisited = true;


        if(current.getRight() != null && !current.getRight().isVisited){
            DFS(current.getRight());
        }
        else if(current.getLeft() != null && !current.getLeft().isVisited) {
            DFS(current.getLeft());
        }
        else{
            DFS(current.getParent());
        }

    }
}




