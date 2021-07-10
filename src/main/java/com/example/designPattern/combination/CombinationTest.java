package com.example.designPattern.combination;

/**
 * 《组合模式》
 *      组合模式又叫部分整体模式，它创建了对象组的树形结构，将对象组合成树状结构以表示“整体-部分”的层次关系。
 *  它使得用户对单个对象和组合对象的访问具有一致性。
 *
 *  角色介绍：
 *      1、Component（抽象构件）：它可以是接口或抽象类，为叶子构件和容器构件对象声明接口，在该角色中可以包含所有子类共有行为的声明和实现。
 *         在抽象构件中定义了访问及管理它的子构件的方法，如增加子构件、删除子构件、获取子构件等。
 *
 *      2、Leaf（叶子构件）：它在组合结构中表示叶子节点对象，叶子节点没有子节点，它实现了在抽象构件中定义的行为。
 *         对于那些访问及管理子构件的方法，可以通过异常等方式进行处理。
 *
 *      3、Composite（容器构件）：它在组合结构中表示容器节点对象，容器节点包含子节点，其子节点可以是叶子节点，也可以是容器节点，
 *         它提供一个集合用于存储子节点，实现了在抽象构件中定义的行为，包括那些访问及管理子构件的方法，在其业务方法中可以递归调用其子节点的业务方法。
 *
 *      组合模式的关键是定义了一个抽象构件类，它既可以代表叶子，又可以代表容器，而客户端针对该抽象构件类进行编程，
 *  无须知道它到底表示的是叶子还是容器，可以对其进行统一处理。同时容器对象与抽象构件类之间还建立一个聚合关联关系，
 *  在容器对象中既可以包含叶子，也可以包含容器，以此实现递归组合，形成一个树形结构。
 *
 * @author yupan
 * @date 7/5/21 9:55 PM
 */
public class CombinationTest {

    public static void main(String[] args) {
        School school = new School("武汉大学");

        College college1 = new College("计算机学院");
        College college2 = new College("艺术学院");
        school.add(college1);
        school.add(college2);

        Department department1 = new Department("科学与技术");
        Department department2 = new Department("动漫设计");
        college1.add(department1);
        college1.add(department2);

        Department department3 = new Department("声乐");
        Department department4 = new Department("舞蹈");
        college2.add(department3);
        college2.add(department4);

        school.print();
    }
}
