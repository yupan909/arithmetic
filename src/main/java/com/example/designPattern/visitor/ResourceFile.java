package com.example.designPattern.visitor;

/**
 * 抽象文件类
 *
 * @author yupan
 * @date 7/14/21 10:37 AM
 */
public abstract class ResourceFile {

    /**
     * 文件名
     */
    protected String fileName;

    public ResourceFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 接收访问者
     */
    public abstract void accept(Visitor visitor);
}
