package com.example.designPattern.builder;

/**
 * 电脑卖家
 *
 * @author yupan
 * @date 7/4/21 4:39 PM
 */
public class ComputerSeller {

    private AbstractComputerBuilder computerBuilder;

    public ComputerSeller(AbstractComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public Computer bulidComputer() {
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildDisk();
        return computerBuilder.getComputer();
    }
}
