package com.example.designPattern.interpreter;

import java.util.Map;
import java.util.Stack;

/**
 * 计算器
 *
 * @author yupan
 * @date 7/17/21 9:46 PM
 */
public class Calculator {

    private Expression expression;

    /**
     * 构建计算器
     * @param expStr
     */
    public Calculator(String expStr) {
        // 运算先后顺序
        Stack<Expression> stack = new Stack<>();
        // 表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();

        Expression left = null;
        Expression right = null;

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        this.expression = stack.pop();
    }

    /**
     * 运算
     * @param var
     * @return
     */
    public int run(Map<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
