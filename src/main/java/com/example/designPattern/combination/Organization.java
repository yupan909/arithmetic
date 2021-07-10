package com.example.designPattern.combination;

/**
 * 组织抽象类
 *
 * @author yupan
 * @date 7/10/21 3:35 PM
 */
public abstract class Organization {

    /**
     * 名称
     */
    private String name;

    public Organization(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 添加
     */
    protected void add(Organization org) {
        throw new UnsupportedOperationException();
    }

    /**
     * 输出
     */
    protected abstract void print();
}
