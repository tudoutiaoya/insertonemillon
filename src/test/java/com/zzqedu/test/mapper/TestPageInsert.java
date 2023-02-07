package com.zzqedu.test.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestPageInsert {

    @Resource
    private TestPageMapper testPageMapper;

    @Test
    void demo1() {
        for (int i = 10; i < 12; i++) {
            TestPage testPage = new TestPage();
            testPage.setContent("测试" + (i+1));
            testPage.setCreateTime(System.currentTimeMillis());
            testPageMapper.InsertOne(testPage);
        }
    }

}
