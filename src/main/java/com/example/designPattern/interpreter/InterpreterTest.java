package com.example.designPattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 《解释器模式》
 *      给定一种语言，定义他的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中句子。
 *
 *  角色介绍：
 *     1、抽象解释器（AbstractExpression）：声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享。
 *     2、终结解释器（TerminalExpression）：实现与文法中的终结符相关联的解释操作。一个句子中的每一个终结符需要该类的一个实例。
 *     3、非终结解释器（NonterminalExpression）：对文法中的规则的解释操作。
 *     4、环境角色（Context）：包含解释器之外的一些全局信息。
 *
 *  优点：
 *     扩展性好，修改语法规则只要修改相应的非终结符表达式就可以了，若扩展语法，则只要增加非终结符类就可以了。
 *
 *  缺点：
 *      1、会引起类膨胀。
 *      2、采用递归调用方法，将会导致调试非常复杂。
 *      3、使用了大量的循环和递归，效率是一个不容忽视的问题。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class InterpreterTest {

    public static void main(String[] args) {
        // 计算器
        String expStr = "a+b-c";
        Calculator calculator = new Calculator(expStr);
        Map<String, Integer> var = new HashMap<>();
        var.put("a", 10);
        var.put("b", 4);
        var.put("c", 6);
        System.out.println("表达式：" + expStr + "=" + calculator.run(var));
    }
}
