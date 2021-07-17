package com.example.designPattern.interpreter;

import java.util.Map;

/**
 * 加号解析器
 *
 * @author yupan
 * @date 7/17/21 9:42 PM
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int interpreter(Map<String, Integer> var) {
        return left.interpreter(var) + right.interpreter(var);
    }
}
