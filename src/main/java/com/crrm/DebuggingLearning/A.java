package com.crrm.DebuggingLearning;

public class A {
    int x = 10;
    public static void main(String[]args){
        A a1 = new A();
        System.out.println(a1.x);
        int y = a1.test();
        System.out.println(y);
    }
    public int test(){
        return 10;
    }
}
