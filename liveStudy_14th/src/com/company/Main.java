package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        WildCardTest wct = new WildCardTest();

        List res1 = wct.wildMethod1();
        List res2 = wct.wildMethod2(res1);
        List res3 = wct.wildMethod3();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
