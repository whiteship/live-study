package com.company;

import java.util.List;

public interface GenericTest<T1, T2> {
    T1 testMethod1(T2 t);
    T2 testMethod2(T1 t);
}

class GenericTestImp implements GenericTest<String, Integer>{

    @Override
    public String testMethod1(Integer t) {
        return null;
    }

    @Override
    public Integer testMethod2(String t) {
        return null;
    }

    public <T> List<T> genericMethod(List<T> list, T item){
        list.add(item);
        return list;
    }
}
