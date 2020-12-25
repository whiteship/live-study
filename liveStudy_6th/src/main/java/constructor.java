public class constructor {
    public static class A{
        public A(){
            System.out.println("Default Constructor of A");
        }
        public A(int x){
            System.out.println("Explicit Constructor of A");
        }
    }

    public static class B extends A implements Cloneable{
        private int value = 1;
        public B(){
            super(1);
            System.out.println("Default Constructor of B");
        }
        public B(int x){
            super(2);
            this.value = x;
            System.out.println("Explicit Constructor of B");
        }

//        @Override
//        public String toString() {
//            return "This Class is B";
//        }

        @Override
        public boolean equals(Object obj){
            B temp = (B)obj;
            return this.value == temp.value;
        }

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) {
        B test = new B();
        B test1 = new B(10);

        System.out.println(test);
        System.out.println(test.toString());

        System.out.println(test == test1);
        System.out.println(test.equals(test1));

        try{
            B clone1 = (B)test1.clone();
            System.out.println(clone1.value);
            System.out.println(test1.value);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
