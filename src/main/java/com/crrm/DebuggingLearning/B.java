package com.crrm.DebuggingLearning;

import java.util.Random;

public class B {
    public static void main(String[]args){
        B b1 = new B();
        int x = b1.otpGen();
        System.out.println(x);

    }
    public int otpGen(){
        return new Random().nextInt();
    }
}
