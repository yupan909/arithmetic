package com.example.designPattern.interpreter;

import java.util.Map;

/**
 * 减号解析器
 *
 * @author yupan
 * @date 7/17/21 9:42 PM
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int interpreter(Map<String, Integer> var) {
        return left.interpreter(var) - right.interpreter(var);
    }
}
