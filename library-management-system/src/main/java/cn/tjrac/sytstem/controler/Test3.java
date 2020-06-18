package cn.tjrac.sytstem.controler;

import java.math.BigInteger;

/**
 * @author Rui3g
 * @date 2020/6/4 10:25
 */
public class Test3 {

    /*写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。*/
    public static void main(String[] args) {
        BigInteger bi1=new BigInteger(String.valueOf(10));
        BigInteger bi2=new BigInteger(String.valueOf(20));
        System.out.println(bi1.add(bi2).intValue());
    }
}
