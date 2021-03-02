package com.bishe.blood;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.image.AffineTransformOp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@SpringBootTest
class BloodApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        String d = "2020-01-03";
        String now = "2021-01-03";

        int i = now.compareTo(d);
        System.out.println(i);
    }

    @Test
    void test2() {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String format = ft.format(date);
        System.out.println(format);
    }

}
