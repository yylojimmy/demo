package com.example.guava;

import com.google.common.base.Objects;

public class ObjectDemo {
    public static void main(String args[]){
        System.out.println(Objects.equal("a", "a")); // returns true

        System.out.println(Objects.equal(null, "a")); // returns false

        System.out.println(Objects.equal("a", null)); // returns false

        System.out.println(Objects.equal(null, null)); // returns true


        System.out.println(Objects.hashCode("a", "a"));
        System.out.println(Objects.hashCode("a", "a"));
        Integer i = new Integer(1);
        System.out.println(Objects.hashCode(i));
        System.out.println(Objects.hashCode(i));

    }
}
