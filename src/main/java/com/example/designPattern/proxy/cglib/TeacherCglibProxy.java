package com.example.designPattern.proxy.cglib;

import com.example.designPattern.proxy.Teacher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 老师 - Cglib动态代理类
 *
 * @author yupan
 * @date 7/11/21 4:52 PM
 */
public class TeacherCglibProxy implements MethodInterceptor {

    private Teacher teacher;

    public TeacherCglibProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getProxy() {
        // 1. 使用Enhancer创建代理类
        Enhancer enhancer = new Enhancer();
        // 2. 继承被代理类
        enhancer.setSuperclass(teacher.getClass());
        // 3. 设置回调
        enhancer.setCallback(this);
        // 4. 生成代理对象
        return (Teacher) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("[Cglib动态代理]上课前起立");
        Object obj = method.invoke(teacher, objects);
        System.out.println("[Cglib动态代理]下课后起立");
        return obj;
    }
}
