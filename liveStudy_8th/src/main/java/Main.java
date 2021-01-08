public class Main {
    public static void main(String[] args) {
        Mac macAir = new MacBookAir();
        Mac macPro = new MacBookPro();
        MacBookAir air = new MacBookAir();
        MacBookPro pro = new MacBookPro();

        macAir.modelName();
        ((MacBookAir)macAir).price();
        macPro.modelName();
        ((MacBookPro)macPro).price();

        air.modelName();
        air.price();
        pro.modelName();
        pro.price();

        air.brand();
        pro.brand();
    }
}
