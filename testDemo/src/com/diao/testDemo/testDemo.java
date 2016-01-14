package com.diao.testDemo;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class testDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String str = sc.nextLine();
        System.out.println(str);
        byte[] b = str.getBytes("gbk");
        System.out.println(new String(b, "gbk"));
        sc.close();
    }
}
