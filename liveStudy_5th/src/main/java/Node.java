public class Node {
    int value;
    Node left;
    Node right;

    Node(int initValue){
        this.value = initValue;
        this.left = null;
        this.right = null;
    }

    private int getValue(){
        return this.value;
    }

    public Node add(Node childNode){
        if(this.left == null){
            this.left = childNode;
            return this.left;
        }else{
            this.right = childNode;
            return this.right;
        }
    }

    public void print(Node cur){
        System.out.println(cur.getValue());
        if(cur.left != null){
            print(cur.left);
            if(cur.right != null){
                print(cur.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.print(root);

        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);

        root.add(child1);
        root.add(child2);
        child1.add(child3);

        root.print(root);
    }
}
