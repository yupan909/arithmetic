package com.example.designPattern.builder;

/**
 * 苹果电脑建造者
 *
 * @author yupan
 * @date 7/4/21 4:34 PM
 */
public class MacbookComputerBuilder extends AbstractComputerBuilder {

    @Override
    void buildCpu() {
        computer.setCpu("i7");
    }

    @Override
    void buildMemory() {
        computer.setMemory("16G");
    }

    @Override
    void buildDisk() {
        computer.setDisk("512G");
    }
}
