package com.huangxl.springstudy.studycode.code04;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author huangxl
 */
@Getter
@Setter
public class ScopeModel {
    private String beanScope;

    public ScopeModel() {
    }

    public ScopeModel(String beanScope) {
        this.beanScope = beanScope;
        System.out.println(this+",beanScope="+beanScope);
    }
}
