package com.zzqedu.domain;

import lombok.Data;

import java.io.Serializable;


@Data
public class Interview implements Serializable {
    private Long id;

    private String context;

    private Long createTime;
}