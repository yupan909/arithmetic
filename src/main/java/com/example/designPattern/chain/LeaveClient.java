package com.example.designPattern.chain;

/**
 * 请假管理
 *
 * @author yupan
 * @date 7/18/21 2:24 PM
 */
public class LeaveClient {

    private Handler handler;

    public LeaveClient() {
        // cto
        CTOHandler ctoHandler = new CTOHandler();
        // 经理
        ManagerHandler managerHandler = new ManagerHandler();
        // 组长
        LeaderHandler leaderHandler = new LeaderHandler();

        // 构建一条责任链
        leaderHandler.setHandler(managerHandler);
        managerHandler.setHandler(ctoHandler);
        ctoHandler.setHandler(leaderHandler);

        // 默认处理器随便用哪个
        handler = leaderHandler;
    }

    /**
     * 请假
     * @param days
     */
    public void apply(Integer days) {
        handler.handleRequest(days);
    }
}
