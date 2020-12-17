import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    Node head;
    int size;

    BinaryTree(Node head) {
        this.head = head;
        this.size = 1;
    }

    public void add(Node childNode) {
        // size+1 => 이제 생성될 노드
        // size+1 짝수면 left => true
        // size+1 홀수면 right => false
        // 부모 노드는 (int)(size+1)/2;
        boolean leftRight = (size + 1) % 2 == 0;
        int parentIdx = (size + 1) / 2;
        Stack stack = new Stack<Boolean>();
        while (true) {
            if (parentIdx == 1) break;
            stack.push(parentIdx % 2 == 0);
            parentIdx = parentIdx / 2;
        }
        Node parentNode = this.head;
        while (!stack.empty()) {
            Boolean isLeft = (Boolean) stack.pop();
            if (isLeft) {
                parentNode = parentNode.left;
            } else {
                parentNode = parentNode.right;
            }
        }
        if (leftRight) {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
        this.size++;
    }
    public void dfs(Node node){
        System.out.print(node.getValue()+" ");
        if(node.left != null){
            dfs(node.left);
            if(node.right != null){
                dfs(node.right);
            }
        }
    }

    public void bfs(){
        Queue q = new LinkedList();
        q.offer(this.head);
        while(!q.isEmpty()){
            Node now = (Node) q.poll();
            System.out.print(now.getValue()+" ");
            if(now.left != null) q.offer(now.left);
            if(now.right != null) q.offer(now.right);
        }

    }


    public static void main(String[] args) {
        Node root = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        root.setValue(1);
        node2.setValue(2);
        node3.setValue(3);
        node4.setValue(4);
        node5.setValue(5);
        node6.setValue(6);
        node7.setValue(7);
        node8.setValue(8);
        node9.setValue(9);
        node10.setValue(10);
        BinaryTree bt = new BinaryTree(root);
        bt.add(node2);
        bt.add(node3);
        bt.add(node4);
        bt.add(node5);
        bt.add(node6);
        bt.add(node7);
        bt.add(node8);
        bt.add(node9);
        bt.add(node10);
        System.out.print("dfs : ");
        bt.dfs(root);
        System.out.print("\nbfs : ");
        bt.bfs();

    }
}
