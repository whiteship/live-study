public class yslArrayQueue {
    private int [] array = new int [1000];
    private int front;
    private int end;

    public int getFront() {return front;}

    public int getEnd() {return end;}

    public yslArrayQueue(){
        front = 0;
        end = 0;
    }
    public void push(int x){
        end = (end+1)%1000;
        array[end] = x;
    }
    public void pop(){
        array[front++] = 0;
    }
    public void print(){
        for(int i=front; i<end; i++) System.out.print(array[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) {
        yslArrayQueue queue = new yslArrayQueue();
        for(int i=1; i<=10; i++) queue.push(i);
        queue.print();
        queue.pop(); queue.pop();
        queue.print();
    }
}
