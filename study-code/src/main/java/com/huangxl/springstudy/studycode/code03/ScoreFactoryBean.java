package com.huangxl.springstudy.studycode.code03;

import org.springframework.beans.factory.FactoryBean;

/**
 * 通过FactoryBean创建bean对象
 * @author huangxl
 */
public class ScoreFactoryBean implements FactoryBean<ScoreEntity> {
    private int count = 1;

    @Override
    public ScoreEntity getObject() throws Exception {
        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setInfo("我是通过FactoryBean创建的第" + count++ + "个ScoreEntity对象");
        return scoreEntity;
    }

    @Override
    public Class<?> getObjectType() {
        return ScoreEntity.class;
    }

    /**
     * 设置bean是否单例,如果设置false，多次获取bean上面的count会递增
     * @return boolean true-单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
