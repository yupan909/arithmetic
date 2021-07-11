package com.example.designPattern.proxy.dynamic;

import com.example.designPattern.proxy.Teacher;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 老师 - JDK动态代理类
 *
 * @author yupan
 * @date 7/11/21 4:52 PM
 */
public class TeacherDynamicProxy {

    private Teacher teacher;

    public TeacherDynamicProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getProxy() {
        return (Teacher) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), teacher.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[JDK动态代理]上课前起立");
                Object obj = method.invoke(teacher, args);
                System.out.println("[JDK动态代理]下课后起立");
                return obj;
            }
        });
    }
}
