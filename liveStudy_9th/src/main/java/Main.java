public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for(int i=1; i<=20; i++){
            try{
                if(i %2 != 0) throw new customException(i);
                sum += i;
            } catch (customException e) {
                e.printStackTrace();
            }
        }
    }
}
