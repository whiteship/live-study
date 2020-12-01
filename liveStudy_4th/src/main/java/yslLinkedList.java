public class yslLinkedList {
    private int value;
    private int size;
    public yslLinkedList next;

    public int getValue() { return value; }
    public int getSize() { return size; }
    public void setSize(int newSize) {this.size = newSize;}
    public yslLinkedList(){
        this.size = 0;
        this.next = null;
    }
    public yslLinkedList(int value){
        this.value = value;
        this.size += 1;
    }

    public yslLinkedList add(yslLinkedList head, yslLinkedList nodeToAdd, int position){
        // node추가 시 제일 앞 / 중간 / 제일 뒤  고려.
        if(position == 1) {  // 첫 노드
            if(head.getSize() > 0){ // 들어올 노드에 기존 노드를 연결해주어야 함.
                nodeToAdd.next = head.next;
            }
            head.next = nodeToAdd;
        }
        else if(1 < position && position <= head.getSize()) {  // 중간 노드
            // 중간이니 탐색을 해야함.
            yslLinkedList temp = head;
            for(int i=0; i<position-1; i++){
                temp = temp.next;
            }
            nodeToAdd.next = temp.next;
            temp.next = nodeToAdd;
        }
        else if(position == head.getSize()+1){  // 끝 노드
            // 중간이니 탐색을 해야함.
            yslLinkedList temp = head;
            for(int i=0; i<position-1; i++){
                temp = temp.next;
            }
            nodeToAdd.next = null;
            temp.next = nodeToAdd;
        }
        else {
            System.out.println("=====Out of Range=====\n("+position+")");
            return nodeToAdd;
        }
        head.setSize(head.getSize()+1);
        return nodeToAdd;
    }

    public yslLinkedList remove(yslLinkedList head, int positionToRemove){
        // 대상 앞 노드 -> 대상 뒤 노드
        yslLinkedList targetNode = null;
        yslLinkedList preNode = head;
        for(int i=0; i<positionToRemove-1; i++){
            preNode = preNode.next;
        }
        targetNode = preNode.next;
        preNode.next = targetNode.next;

        head.setSize(head.getSize()-1);
        System.out.println(positionToRemove+"번째 값 : "+targetNode.getValue()+" 삭제");
        return targetNode;
    }
    public boolean contains(yslLinkedList head, yslLinkedList nodeToCheck) {
        yslLinkedList search = head;
        for (int i = 0; i < head.getSize(); i++) {
            search = search.next;
            if (search == nodeToCheck) {
                System.out.println("in " + (i + 1) + "  value : " + search.getValue());
                return true;
            }
        }
        System.out.println("No Matching Node");
        return false;
    }

    public void print(){
        System.out.println("=====Current State=====");
        yslLinkedList temp = this.next;
        for(int i=0; i<this.size; i++) {
            System.out.print(temp.getValue());
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        yslLinkedList head1 = new yslLinkedList();
        yslLinkedList ll1 = new yslLinkedList(3);
        yslLinkedList ll2 = new yslLinkedList(5);
        yslLinkedList ll3 = new yslLinkedList(7);

        head1.add(head1, ll1, 1);
        head1.add(head1, ll2, 1);
        head1.add(head1, ll3, 1);
        head1.print();

        yslLinkedList head2 = new yslLinkedList();
        yslLinkedList ll21 = new yslLinkedList(3);
        yslLinkedList ll22 = new yslLinkedList(5);
        yslLinkedList ll23 = new yslLinkedList(7);
        yslLinkedList ll24 = new yslLinkedList(10);
        yslLinkedList ll25 = new yslLinkedList(8);
        head2.add(head2, ll21, 1);
        head2.add(head2, ll22, 2);
        head2.add(head2, ll23, 3);
        head2.add(head2, ll24, 1);
        head2.add(head2, ll25, 6);
        head2.print();

        head1.remove(head1, 2);
        head2.remove(head2, 3);
        head1.print();
        head2.print();

        head1.contains(head1, ll21);
        head1.contains(head1, ll1);

        head2.contains(head2, ll2);
        head2.contains(head2, ll21);
    }
}
