package com.example.designPattern.builder;

/**
 * 电脑类
 *
 * @author yupan
 * @date 7/4/21 4:25 PM
 */
public class Computer {

    /**
     * CPU
     */
    private String cpu;

    /**
     * 内存
     */
    private String memory;

    /**
     * 硬盘
     */
    private String disk;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}
