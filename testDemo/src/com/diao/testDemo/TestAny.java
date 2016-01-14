package com.diao.testDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

public class TestAny {
    public static void main1(String[] args) {
        List<String> list = Arrays.asList("导游,接送车,翻译".split(","));
        System.out.println(list);
        String str = "";
        System.out.println(str + "=======");
    }

    public void test2() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sf.parse("2015-12-28 17:10:20");
        Date d2 = sf.parse("2015-12-28 10:10:20");
        System.out.println(sf.format(d1));
        System.out.println(d2);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        System.out.println(c1.get(Calendar.DAY_OF_YEAR));
        System.out.println(c2.get(Calendar.DAY_OF_YEAR));
        System.out.println(c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR));
    }

    @Test
    public void test1() {

        System.out.println(">>>>>>>>>>>");
        System.out.println(
                "===============================================================picture upload time-consuming: 123 ms");
        System.out.println(">>>>>>>>>>>");
    }

    public static void main(String[] args) throws Exception {
        UserModel userModel = new UserModel();
        userModel.setAge(12);
        int n=0;
        double m=0;
        long start = System.currentTimeMillis();
        for (long i = 0; i < 10000000000L; i++) {
            m=3354000d/10000000000d;
            n=100000+1000000;
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(m);
        System.out.println("=====================================");
        start = System.currentTimeMillis();
        for (long i = 0; i < 10000000000l; i++) {}
        System.out.println(System.currentTimeMillis() - start);
    }
}


