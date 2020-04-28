package com.springstudy.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testIterator() {
        List<String> list = new ArrayList<>(2);
        list.add("a");
        forIterator(list);
        forIterator(list);
    }

    private void forIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
