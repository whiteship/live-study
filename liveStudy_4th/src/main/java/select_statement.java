public class select_statement{
    void ifelse(int number){
        if(number < 10){
            System.out.println("0 ~ 10");
        }else if(number == 10){
            System.out.println("10");
        }
        else{
            System.out.println("10 ~");
        }
    }
    void _switch(int number){
        switch(number){
            case 5:
                System.out.println("5");
                break;
            case 10:
                System.out.println("10");
                break;
            case 100:
                System.out.println("100");
                break;
        }
    }
    public static void main(String[] args) {
        select_statement state = new select_statement();
        int num1 = 5;
        int num2 = 10;
        int num3 = 100;
        state.ifelse(num1);
        state.ifelse(num2);
        state.ifelse(num3);
        state._switch(num1);
        state._switch(num2);
        state._switch(num3);
    }

}

