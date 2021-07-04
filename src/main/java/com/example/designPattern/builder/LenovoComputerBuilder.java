package com.example.designPattern.builder;

/**
 * 联想电脑建造者
 *
 * @author yupan
 * @date 7/4/21 4:34 PM
 */
public class LenovoComputerBuilder extends AbstractComputerBuilder {

    @Override
    void buildCpu() {
        computer.setCpu("i5");
    }

    @Override
    void buildMemory() {
        computer.setMemory("8G");
    }

    @Override
    void buildDisk() {
        computer.setDisk("256G");
    }
}
