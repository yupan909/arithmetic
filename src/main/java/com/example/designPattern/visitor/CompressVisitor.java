package com.example.designPattern.visitor;

/**
 * 压缩文件
 *
 * @author yupan
 * @date 7/14/21 10:47 AM
 */
public class CompressVisitor implements Visitor {

    @Override
    public void visitPdf(ResourceFile pdfFile) {
        System.out.println("压缩PDF文件：" + pdfFile.fileName);
    }

    @Override
    public void visitWord(ResourceFile wordFile) {
        System.out.println("压缩Word文件：" + wordFile.fileName);
    }
}
