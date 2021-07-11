package com.example.designPattern.proxy;

/**
 * 老师
 *
 * @author yupan
 * @date 7/11/21 4:50 PM
 */
public class TeacherImpl implements Teacher {

    @Override
    public void teach() {
        System.out.println("老师开始讲课...");
    }
}
