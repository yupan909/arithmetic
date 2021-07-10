package com.example.designPattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 学校
 *
 * @author yupan
 * @date 7/10/21 3:39 PM
 */
public class School extends Organization {

    /**
     * 学院
     */
    private List<Organization> orgList = new ArrayList<>();

    public School(String name) {
        super(name);
    }

    @Override
    public void add(Organization org) {
        orgList.add(org);
    }

    @Override
    protected void print() {
        System.out.println(getName());
        for (Organization org : orgList) {
            org.print();
        }
    }
}
