package com.example.designPattern.strategy;

/**
 * 运算
 *
 * @author yupan
 * @date 7/18/21 1:53 PM
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int num1, int num2) {
        return strategy.operate(num1, num2);
    }
}
