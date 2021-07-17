package com.example.designPattern.interpreter;

import java.util.Map;

/**
 * 符号解释器（非终结解释器）
 *
 * @author yupan
 * @date 7/17/21 9:38 PM
 */
public class SymbolExpression extends Expression {

    protected Expression left;

    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    int interpreter(Map<String, Integer> var) {
        return 0;
    }
}
