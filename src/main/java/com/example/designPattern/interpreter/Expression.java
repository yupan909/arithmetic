package com.example.designPattern.interpreter;

import java.util.Map;

/**
 * 抽象表达式类
 *
 * @author yupan
 * @date 7/17/21 9:36 PM
 */
public abstract class Expression {

    /**
     * 解释表达式
     * @param var
     * @return
     */
    abstract int interpreter(Map<String, Integer> var);
}
