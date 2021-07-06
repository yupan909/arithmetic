package com.example.designPattern.bridge;

/**
 * 《桥接模式》
 *      桥接模式是将抽象部分与它的实现部分分离，使它们都可以独立地变化。
 *
 *      桥接模式通过将继承改为组合的方式来解决多维度的扩展问题，实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实现部分独立开来，
 *   这有助于系统进行分层设计，从而产生更好的结构化系统。并且替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本。
 *
 *   使用场景：
 *   1、一个系统需要在构建的抽象化角色和具体化角色间增加更多灵活性，避免在两个层次间建立静态继承关系，可以通过桥接模式使他们在抽象层建立一个关联关系。
 *   2、一个类存在两个独立变化的维度，切两个维度都需要扩展。
 *   3、对于不希望使用继承或因多层次继承导致系统类的个数急剧增加的系统，也可使用桥接模式。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class BridgeTest {

    public static void main(String[] args) {
        // 小米折叠手机
        Phone xiaoMiFoldPhone = new FoldPhone(new XiaoMiBrand());
        xiaoMiFoldPhone.call();

        // 小米滑盖手机
        Phone xiaoMiSlidePhone = new SlidePhone(new XiaoMiBrand());
        xiaoMiSlidePhone.call();

        // vivo折叠手机
        Phone vivoFoldPhone = new FoldPhone(new VivoBrand());
        vivoFoldPhone.call();

        // vivo滑盖手机
        Phone vivoSlidePhone = new SlidePhone(new VivoBrand());
        vivoSlidePhone.call();
    }
}
