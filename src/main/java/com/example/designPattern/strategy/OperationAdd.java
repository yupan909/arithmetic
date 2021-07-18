package com.example.designPattern.strategy;

/**
 * 加法运算
 *
 * @author yupan
 * @date 7/18/21 1:52 PM
 */
public class OperationAdd implements Strategy {

    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}
