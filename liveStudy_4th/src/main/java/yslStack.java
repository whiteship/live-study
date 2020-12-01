import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

public class yslStack {
    private int topPointer;
    private int bottomPointer;
    private int[] data = new int[1024];
    public yslStack(){
        topPointer = 0;
        bottomPointer = 0;
    }

    public boolean isEmpty(){
        return (topPointer==bottomPointer);
    }

    public void push(int x){
        data[topPointer++] = x;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Do Not Pop");
            return -1;
        }
        return data[--topPointer];
    }

    public void clear(){
        topPointer = bottomPointer = 0;
    }

    public void print(){
        if(isEmpty()){ System.out.print("---clear---\n"); return;}
        for (int i = 0; i < topPointer; i++) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        yslStack st = new yslStack();
        st.print();
        st.pop();
        st.push(1);
        st.push(3);
        st.push(5);
        st.print();
        st.pop();
        st.print();
        st.clear();
        st.print();
    }
}
