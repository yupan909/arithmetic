package com.example.designPattern.visitor;

/**
 * 解压缩文件
 *
 * @author yupan
 * @date 7/14/21 10:47 AM
 */
public class ExtractVisitor implements Visitor {

    @Override
    public void visitPdf(PdfFile pdfFile) {
        System.out.println("解压缩PDF文件：" + pdfFile.fileName);
    }

    @Override
    public void visitWord(WordFile wordFile) {
        System.out.println("解压缩Word文件：" + wordFile.fileName);
    }
}
