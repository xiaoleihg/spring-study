package com.huangxl.springstudy.studycode.code03;

/**
 * 通过静态工厂方法创建bean实例
 * @author huangxl
 */
public class ScoreStaticFactory {

    /**
     * 静态无参方法创建ScoreEntity
     * @return scoreEntity
     */
    public static ScoreEntity buildScoreEntity1(){
        System.out.println(ScoreStaticFactory.class+"->method:buildScoreEntity1");
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setInfo("静态无参方法buildScoreEntity1的创建ScoreEntity");
        return scoreEntity;
    }

    /**
     * 静态有参参方法创建ScoreEntity
     * @param studentId
     * @param score
     * @param info
     * @return
     */
    public static ScoreEntity buildScoreEntity2(Integer studentId,Double score, String info){
        System.out.println(ScoreStaticFactory.class+"->method:buildScoreEntity2");
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setStudentId(studentId);
        scoreEntity.setScore(score);
        scoreEntity.setInfo(info);
        return scoreEntity;
    }

}
