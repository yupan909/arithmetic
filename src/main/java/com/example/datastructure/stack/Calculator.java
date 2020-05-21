package com.example.datastructure.stack;

import java.util.Stack;

/**
 * 栈实现综合计算器(中缀表达式)
 *
 *  使用栈实现表达式计算思路：
 *  1、创建两个栈，一个数栈（存放数字），一个符号栈（存放符号）
 *  2、遍历表达式，开始依次扫描
 *    2.1 当扫描的是一个数字时，直接入数栈（需要考虑多位数）；
 *    2.2 当扫描的是一个操作符时，分如下情况：
 *       (1) 同时满足：符号栈不为空 && 符号栈栈顶的操作符不是左括号 && 当前操纵符的优先级小于或等于栈顶的操作符
 *           需要从数栈中取出栈顶和次栈顶，从符号栈中取出栈顶进行运算，将运算结果压入数栈中，最后将当前操作符压入符号栈；
 *       (2) 当前操作符是右括号时，需要从数栈中取出栈顶和次栈顶，从符号栈中取出栈顶进行运算，将运算结果压入数栈中，重复此操作，直到符号栈取出的是左括号，则跳出此操作；
 *       (3) 当不满足上面两个条件时，直接压入符合栈即可；
 *  3、当表达式扫描完毕，就顺序的从数栈依次取出两个数、从符号栈取出一个符号，进行运算后再放入数栈，依次循环，直到数栈中只有一个数字，就是表达式的结果
 *
 * @author yupan@yijiupi.cn
 * @date 2020-05-20 15:44
 */
public class Calculator {

    /**
     * 计算表达式
     * @return
     */
    public Integer calculate(String exp) {
        if (exp == null) {
            throw new RuntimeException("表达式不能为空！");
        }
        // 1、创建两个栈，一个数栈（存放数字），一个符号栈（存放符号）
        Stack<Integer> numStack = new Stack();
        Stack<Character> operStack = new Stack();

        // 用于拼接多位数
        String tempNum = "";

        // 2、遍历表达式
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            // 当前扫描的是操作符
            if (isOper(ch)) {
                // (1)符号栈不为空 && 符号栈栈顶的操作符不是左括号 && 当前操纵符的优先级小于或等于栈顶的操作符
                if (!operStack.isEmpty() && operStack.peek() != '(' && priority(ch) <= priority(operStack.peek())) {
                    int num1 = numStack.pop();
                    int num2 = numStack.pop();
                    char oper = operStack.pop();
                    int sum = cal(num1, num2, oper);
                    // 从数栈中取出栈顶和次栈顶，从符号栈中取出栈顶进行运算，将运算结果压入数栈，当前操作符压入符号栈
                    numStack.push(sum);
                    operStack.push(ch);

                // (2)当前操作符是右括号时，需要从数栈中取出栈顶和次栈顶，从符号栈中取出栈顶进行运算，将运算结果压入数栈中，重复此操作，直到符号栈取出的是左括号，则跳出此操作；
                } else if (ch == ')') {
                    while(true) {
                        char oper = operStack.pop();
                        if (oper == '(') {
                            break;
                        }
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int sum = cal(num1, num2, oper);
                        numStack.push(sum);
                    }
                // (3)当不满足上面两个条件时，直接压入符合栈即可；
                } else {
                    operStack.push(ch);
                }
            // 当前扫描的是数字
            } else {
                // 如果连续下一次是数字的话，说明是多位数，记录下来，暂时不入栈
                tempNum += ch;
                if (i == exp.length() -1 || isOper(exp.charAt(i+1)) ) {
                    numStack.push(Integer.parseInt(tempNum));
                    tempNum = "";
                }
            }
        }

        // 3、计算结果
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            char oper = operStack.pop();
            int sum = cal(num1, num2, oper);
            numStack.push(sum);
        }
        return numStack.pop();
    }

    /**
     * 判断是不是操作符
     */
    private boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }

    /**
     * 返回优先级
     * @return 返回值越大说明优先级越大
     */
    private int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '(' || ch == ')') {
            return 3;
        } else {
            return -1;
        }
    }

    /**
     * 计算
     */
    private int cal(int num1, int num2, char oper) {
        if (oper == '+') {
            return num1 + num2;
        } else if (oper == '-') {
            // 后弹出的作为减数
            return num2 - num1;
        } else if (oper == '*') {
            return num1 * num2;
        } else if (oper == '/') {
            return num1 / num2;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String exp = "10+(20*6-30)";
        System.out.println(exp + "=" + calculator.calculate(exp));
    }
}
