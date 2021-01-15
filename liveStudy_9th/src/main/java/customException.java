public class customException extends Exception{
    customException(){
        System.out.println("홀수입니다");
    }
    customException(int i){
        System.out.println(i+"는 홀수입니다.");
    }
}
