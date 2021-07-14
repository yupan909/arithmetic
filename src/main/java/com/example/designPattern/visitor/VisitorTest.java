package com.example.designPattern.visitor;

/**
 * 《访问者模式》
 *     提供一个作用于某对象结构中的各元素的操作表示，它使得可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 *
 *  角色介绍：
 *      1、抽象访问者（Visitor）：主要是为了访问者的扩展。里面定义了一系列的visit方法（这个方法可以通过方法名来区分，也可以使用参数来重载），用来指定不同元素对象该访问者所需要对应的不同操作逻辑。一般就一个元素提供一个visit方法。
 *
 *      2、具体访问者（ConcreteVisitor）：实现抽象的访问逻辑。
 *
 *      3、抽象元素（Element）：定义一个accept方法，参数通常就是抽象访问者。
 *
 *      4、具体元素（ConcreteElement）：实现accept完成对一个元素访问想要做的操作。本质就是调用传递来的抽象访问者的方法（即调用visitor的visit方法）。
 *                                    这种机制也称为双重分派，这样利用参数重载的特性，我们可以不用修改任何代码，添加的访问者都可以这种方式进行传递调用（通过参数重载来调用对应的方法）。
 *
 *      5、对象结构（ObjectStructure）：用来存放元素对象的。并提供遍历内部元素的方法。可以使用组合模式来实现。也可以是一个简单的集合对象。
 *
 *  优点：
 *      1、各角色的职责相互隔离，符合单一职责原则。Visitor、Element 、ObjectStructure各司其责，职责清晰。
 *      2、扩展性好，添加新的访问者不需要修改原代码，对于访问者来说，符合开闭原则。
 *
 *  缺点：
 *      1、增加新的元素类很困难，需要在每一个访问者类中增加相应访问操作代码，这违背了开闭原则；
 *      2、可能破坏元素类的封装性，元素对象有时候必须暴露一些自己的内部操作和状态，否则无法供访问者访问。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class VisitorTest {

    public static void main(String[] args) {
        FileManage fileManage = new FileManage();
        fileManage.add(new PdfFile("访问者模式第1版.pdf"));
        fileManage.add(new PdfFile("访问者模式第2版.pdf"));
        fileManage.add(new WordFile("访问者模式.word"));

        // 压缩文件
        CompressVisitor compressVisitor = new CompressVisitor();
        fileManage.process(compressVisitor);

        System.out.println();

        // 解压缩文件
        ExtractVisitor extractVisitor = new ExtractVisitor();
        fileManage.process(extractVisitor);
    }
}
