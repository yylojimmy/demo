package com.example.guava;

import com.google.common.collect.ComparisonChain;

public class ChainDemo {
    public class Person implements Comparable<Person>{
        private String lastName;
        private String firstName;
        private int zipCode;

        public Person(String lastName, String firstName, int zipCode) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.zipCode = zipCode;
        }

        @Override
        public int compareTo(Person o) {
            return ComparisonChain.start()
                    .compare(this.lastName, o.lastName)
                    .compare(this.firstName, o.firstName)
                    .compare(this.zipCode, o.zipCode).result();

        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public int getZipCode() {
            return zipCode;
        }

        public void setZipCode(int zipCode) {
            this.zipCode = zipCode;
        }
    }

    public static void main(String args[]){
        Person p1 = new ChainDemo().new Person("lo", "1",1);
        Person p2 = new ChainDemo().new Person("lo", "1",1);
        System.out.println(p1.compareTo(p2));
    }
}
