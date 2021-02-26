package com.company;

import java.util.ArrayList;
import java.util.List;

public class WildCardTest {
    public List<? extends Object> wildMethod1(){
        return new ArrayList<Long>();
    }
    public <T> List<? extends String> wildMethod2 (T t){
        return new ArrayList<String>();
    }
    public List<?> wildMethod3(){
        return new ArrayList<>();
    }

}
