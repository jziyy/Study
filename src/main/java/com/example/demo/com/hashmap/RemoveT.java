package com.example.demo.com.hashmap;

import lombok.Data;

import java.util.HashMap;
import java.util.Objects;

public class RemoveT {

    static class aaa{
        String name;
        String password;
        aaa(String name,String password){
            this.name =name;
            this.password =password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            aaa aaa = (aaa) o;
            return Objects.equals(name, aaa.name) &&
                    Objects.equals(password, aaa.password);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, password);
        }

        @Override
        public String toString() {
            return "aaa{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(new aaa("a","a"),"a");
        hashMap.put(new aaa("a1","a"),"aaa");
        hashMap.put(new String("111"),"");
         hashMap.remove(new String("111"));

        hashMap.remove(new aaa("a","a"));
        System.out.println(new String("111").hashCode());
        System.out.println(new String("111").hashCode());
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        int h;
        Integer a =new Integer(3);
        a.hashCode();

        System.out.println(new aaa("a","a").hashCode());
        System.out.println(new aaa("a","a").hashCode());
    }
}
