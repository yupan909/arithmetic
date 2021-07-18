package com.example.designPattern.chain;

/**
 * 抽象处理器
 *
 * @author yupan
 * @date 7/18/21 2:16 PM
 */
public abstract class Handler {

    /**
     * 下一个处理器
     */
    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public abstract void handleRequest(Integer days);
}
