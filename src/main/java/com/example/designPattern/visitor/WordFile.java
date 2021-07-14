package com.example.designPattern.visitor;

/**
 * Word文件
 *
 * @author yupan
 * @date 7/14/21 10:48 AM
 */
public class WordFile extends ResourceFile {

    public WordFile(String fileName) {
        super(fileName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitWord(this);
    }
}
