public interface Mac {
    void modelName();
    default void brand(){
        System.out.println("apple");
    }
    static void cpu(){
        System.out.println("M1");
    }

    private void cpuFaulty(){
        System.out.println("M1 has fault");
    }

    private static gpuFaulty(){
        System.out.println("M1 has fault");
    }
}

class MacBookAir implements Mac{

    public void modelName() {
        System.out.println("This is MacBookAir4");
    }
    public void price(){
        System.out.println("1,600,000 won");
    }

    @Override
    public void brand() {
        System.out.println("new Apple");
    }

    @Override
    public void cpu(){
        System.out.println("M2");
    }
}

class MacBookPro implements Mac{
    public void modelName(){
        System.out.println("This is MacBookPro");
    }
    public void price(){
        System.out.println("2,000,000 won");
    }
}