package com.example.designPattern.proxy.staticProxy;

import com.example.designPattern.proxy.Teacher;

/**
 * 老师 - 静态代理类
 *
 * @author yupan
 * @date 7/11/21 4:52 PM
 */
public class TeacherStaticProxy implements Teacher {

    private Teacher teacher;

    public TeacherStaticProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("[静态代理]上课前起立");
        teacher.teach();
        System.out.println("[静态代理]下课后起立");
    }
}
