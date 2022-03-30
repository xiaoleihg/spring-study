package com.huangxl.springstudy.studycode.code03;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author huangxl
 */
@Getter
@Setter
@ToString
public class ScoreEntity {
    private Integer studentId;
    private Double score;
    private String info;

    public ScoreEntity() {
        this.info="我是无参构造方法创建的ScoreEntity";
    }

    public ScoreEntity(Integer studentId, Double score,String info) {
        this.studentId = studentId;
        this.score = score;
        this.info = info;
    }
}
