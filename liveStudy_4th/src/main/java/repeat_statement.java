public class repeat_statement{
    public int for_statement(int num, int iter){
        for(int i=0; i<iter; i++) num++;
        return num;
    }
    public int while_statement(int num, int iter){
        while(iter != 0){
            num++;
            iter--;
        }
        return num;
    }
    public int do_statement(int num, int iter){
        do{
            num++;
            iter--;
        }while(iter!=0);
        return num;
    }
    public void foreach_statement(int [] data){
        for(int datum : data) System.out.print(datum+" ");
    }
    public static void main(String[] args) {
        repeat_statement state = new repeat_statement();
        int forNum = state.for_statement(10, 5);
        int whileNum = state.while_statement(10, 5);
        int doNum = state.do_statement(10, 5);
        int[] temp = {1, 2, 3, 4, 5};
        System.out.println(forNum);
        System.out.println(whileNum);
        System.out.println(doNum);
        state.foreach_statement(temp);
    }

}

