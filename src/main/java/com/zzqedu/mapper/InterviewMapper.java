package com.zzqedu.mapper;

import com.zzqedu.domain.Interview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InterviewMapper {

    void InsertOne(Interview interview);

    void insertBatch(List<Interview> interviews);

}




