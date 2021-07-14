package com.example.designPattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件管理
 *
 * @author yupan
 * @date 7/14/21 11:15 AM
 */
public class FileManage {

    /**
     * 文件集合
     */
    List<ResourceFile> fileList = new ArrayList<>();

    /**
     * 添加文件
     * @param file
     */
    public void add(ResourceFile file) {
        fileList.add(file);
    }

    /**
     * 处理文件
     */
    public void process(Visitor visitor) {
        for (ResourceFile file : fileList) {
            file.accept(visitor);
        }
    }

}
