import java.sql.SQLOutput;
import java.util.Arrays;

public enum Tottenham {

    //상수를 지정해준다.
    HarryKane(10, "20만 파운드"),
    TanguyNdombele(28, "20만 파운드"),
    HeungminSon(7, "14만 파운드"),
    HugoLloris(1, "10만 파운드"),
    DeleAlie(20, "10만 파운드"),
    LucasMoura(27, "8만 파운드");

    private String pay;
    private int number;
    private Tottenham(int number, String pay){
        this.number = number; this.pay = pay;
        System.out.println(this+"의 등번호 : "+this.number);
        System.out.println(this+"의 주 급 : "+this.pay);
    }

    public static void main(String[] args) {
        Tottenham player;
        player = Tottenham.HeungminSon;

        System.out.println(player);
        System.out.println(player.valueOf(LucasMoura.name()));

        System.out.println(player.HeungminSon.values());
        System.out.println(Arrays.toString(Tottenham.values()));
    }
}


