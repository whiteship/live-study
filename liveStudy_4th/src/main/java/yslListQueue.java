public class yslListQueue {
    private yslLinkedList head = new yslLinkedList();
    private int front = 0;
    private int end = 1;

    public void push(int x){
        yslLinkedList newNode = new yslLinkedList(x);
        head.add(head, newNode, end++);
    }
    public void pop(){
        head.remove(head, front++);
    }
    public void print(){
        yslLinkedList temp = head.next;
        for(int i=front; i<end-1; i++) {
            System.out.print(temp.getValue()+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        yslListQueue q = new yslListQueue();
        for(int i=1; i<=10; i++) q.push(i);
        q.print();
        q.pop(); q.pop();
        q.print();
    }
}
