
public class yslListNodeStack {
    private int topPointer;
    private int bottomPointer;
    private yslLinkedList head;
    public yslListNodeStack(yslLinkedList head){
        this.head = head;
        topPointer = 0;
        bottomPointer = 0;
    }
    public boolean isEmpty(){
        return (topPointer == bottomPointer);
    }
    public void push(int data){
        yslLinkedList newNode = new yslLinkedList(data);
        this.head.add(this.head, newNode, this.head.getSize()+1);
        topPointer++;
    }
    public int pop(){
        if(isEmpty()) return -1;
        topPointer--;
        return this.head.remove(this.head, 1).getValue();
    }
    public void print(){
        yslLinkedList temp = this.head;
        System.out.println("=====Current Stack=====");
        for(int i=0; i<this.head.getSize(); i++) {
            temp = temp.next;
            System.out.print(temp.getValue());
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        yslLinkedList stHead = new yslLinkedList();
        yslListNodeStack st = new yslListNodeStack(stHead);
        st.push(1);
        st.push(2);
        st.push(3);
        st.print();
        st.pop();
        st.pop();
        st.print();
    }
}
