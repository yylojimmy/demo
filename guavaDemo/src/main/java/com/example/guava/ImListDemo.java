package com.example.guava;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

public class ImListDemo {
    public static void main(String args[]){
        //use guava
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String result = Joiner.on("-").join(list);
        System.out.println("result = "+result);
        //result为  aa-bb-cc
    }
}
