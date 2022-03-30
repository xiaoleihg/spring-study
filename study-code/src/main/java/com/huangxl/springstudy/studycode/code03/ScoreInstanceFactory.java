package com.huangxl.springstudy.studycode.code03;

/**
 * 通过实例工厂方法创建bean实例
 * @author huangxl
 */
public class ScoreInstanceFactory {

    public ScoreEntity build1(){
        System.out.println(this+"->method:build1");
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setInfo("通过无参实例工厂方法创建的ScoreEntity实例");
        return scoreEntity;
    }

    public ScoreEntity build2(Integer studentId,Double score, String info){
        System.out.println(this+"->method:build2");
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setStudentId(studentId);
        scoreEntity.setScore(score);
        scoreEntity.setInfo(info);
        return scoreEntity;
    }
}
