package com.example.designPattern.builder;

/**
 * 电脑建造者抽象类
 *
 * @author yupan
 * @date 7/4/21 4:30 PM
 */
public abstract class AbstractComputerBuilder {

    protected Computer computer = new Computer();

    /**
     * 组装CPU
     */
    abstract void buildCpu();

    /**
     * 组装内存
     */
    abstract void buildMemory();

    /**
     * 组装硬盘
     */
    abstract void buildDisk();

    protected Computer getComputer() {
        return computer;
    }

}
