package com.example.designPattern.visitor;

/**
 * 文件访问者
 *
 * @author yupan
 * @date 7/14/21 10:46 AM
 */
public interface Visitor {

    /**
     * 访问PDF文件
     * @param pdfFile
     */
    void visitPdf(PdfFile pdfFile);

    /**
     * 访问Word文件
     * @param wordFile
     */
    void visitWord(WordFile wordFile);
}
