package com.example.designPattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 学院
 *
 * @author yupan
 * @date 7/10/21 3:39 PM
 */
public class College extends Organization {

    /**
     * 系
     */
    private List<Organization> orgList = new ArrayList<>();

    public College(String name) {
        super(name);
    }

    @Override
    public void add(Organization org) {
        orgList.add(org);
    }

    @Override
    public void print() {
        System.out.println("\t" + getName());
        for (Organization org : orgList) {
            org.print();
        }
    }
}
