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
public class StudentEntity {
    private Integer id;
    private String name;
    private ScoreEntity scoreEntity;

    public StudentEntity() {
        System.out.println("我是StudentEntity的无参构造方法");
        this.name="我是无参构造方法创建的StudentEntity";
    }

    public StudentEntity(Integer id, String name) {
        System.out.println("我是StudentEntity的有参构造方法1");
        this.id = id;
        this.name = name;
    }
    public StudentEntity(Integer id, String name, ScoreEntity scoreEntity) {
        System.out.println("我是StudentEntity的有参构造方法2");
        this.id = id;
        this.name = name;
        this.scoreEntity = scoreEntity;
    }
}
