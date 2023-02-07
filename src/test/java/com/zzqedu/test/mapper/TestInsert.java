package com.zzqedu.test.mapper;

import cn.hutool.core.util.RandomUtil;
import com.zzqedu.domain.Interview;
import com.zzqedu.mapper.InterviewMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class TestInsert {

    @Resource
    private InterviewMapper interviewMapper;


    /**
     * 插入一条
     */
    @Test
    void insertOne() {
        Interview interview = new Interview();
        interview.setContext(RandomUtil.randomString(16));
        interview.setCreateTime(System.currentTimeMillis());
        interviewMapper.InsertOne(interview);
    }

    public static final int NUMBER = 1000000;

    /**
     * context为14位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_14_OneSQL() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 0; i < NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(14));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
        }
        log.info("start time " + start);
        interviewMapper.insertBatch(interviews);
        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }


    /**
     * context为32位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_32_OneSQL() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 0; i < NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(32));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
        }
        log.info("start time " + start);
        interviewMapper.insertBatch(interviews);
        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }


    /**
     * context为64位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_64_OneSQL() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 0; i < NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(64));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
        }
        log.info("start time " + start);
        interviewMapper.insertBatch(interviews);
        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }


    /**
     * context为14位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_14_Batch() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(14));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                interviewMapper.insertBatch(interviews);
                interviews = new ArrayList<>();
            }
        }
        log.info("start time " + start);

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }

    /**
     * context为32位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_32_Batch() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(32));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                interviewMapper.insertBatch(interviews);
                interviews = new ArrayList<>();
            }
        }
        log.info("start time " + start);

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }

    /**
     * context为64位字符串 - 拼接一条sql插入
     */
    @Test
    void insert1000000_64_Batch() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(64));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                interviewMapper.insertBatch(interviews);
                interviews = new ArrayList<>();
            }
        }
        log.info("start time " + start);

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }


    /**
     * 线程池批量插入，context为14位字符串
     */
    @Test
    void insert1000000_14_WithThreadPool() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        log.info("start time " + start);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(14));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                // 放入线程池
                this.insertWithThreadPool(interviews);
                interviews = new ArrayList<>();
            }
        }

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }

    /**
     * 线程池批量插入，context为32位字符串
     */
    @Test
    void insert1000000_32_WithThreadPool() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        log.info("start time " + start);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(32));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                // 放入线程池
                this.insertWithThreadPool(interviews);
                interviews = new ArrayList<>();
            }
        }

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }

    /**
     * 线程池批量插入，context为64位字符串
     */
    @Test
    void insert1000000_64_WithThreadPool() {
        long start = System.currentTimeMillis();
        List<Interview> interviews = new ArrayList<>(NUMBER);
        log.info("start time " + start);
        for (int i = 1; i <= NUMBER; i++) {
            Interview interview = new Interview();
            interview.setContext(RandomUtil.randomString(64));
            interview.setCreateTime(System.currentTimeMillis());
            interviews.add(interview);
            if(i % 100000 == 0) {
                // 放入线程池
                this.insertWithThreadPool(interviews);
                interviews = new ArrayList<>();
            }
        }

        long end = System.currentTimeMillis();
        log.info("end time " + end);
        long time = (start - end)/1000;
        log.info("消耗时间：" + time + "秒");
        log.info("每秒插入tps: " + NUMBER/time);
    }



    @Async("taskExecutor")
    void insertWithThreadPool(List<Interview> interviews) {
        interviewMapper.insertBatch(interviews);
    }





}
