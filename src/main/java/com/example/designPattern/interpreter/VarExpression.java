package com.example.designPattern.interpreter;

import java.util.Map;

/**
 * 变量解释器（终结解释器）
 *
 * @author yupan
 * @date 7/17/21 9:38 PM
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    int interpreter(Map<String, Integer> var) {
        return var.get(this.key);
    }
}
