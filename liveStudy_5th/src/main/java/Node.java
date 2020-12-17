public class Node {
    private  int value;
    Node left;
    Node right;

    public int getValue(){ return this.value; }
    public void setValue(int value) { this.value = value;}

    public static void main(String[] args) {
        Node root = new Node();
        Node node1 = new Node();
        Node node2 = new Node();

        root.setValue(1);
        node1.setValue(10);
        node2.setValue(100);

        System.out.println(root.getValue());
        System.out.println(node1.getValue());
        System.out.println(node2.getValue());
    }
}