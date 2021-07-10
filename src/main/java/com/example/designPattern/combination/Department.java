package com.example.designPattern.combination;

/**
 * 系
 *
 * @author yupan
 * @date 7/10/21 3:39 PM
 */
public class Department extends Organization {

    public Department(String name) {
        super(name);
    }

    @Override
    protected void print() {
        System.out.println("\t\t" + getName());
    }
}
