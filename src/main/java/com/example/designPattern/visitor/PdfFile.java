package com.example.designPattern.visitor;

/**
 * PDF文件
 *
 * @author yupan
 * @date 7/14/21 10:48 AM
 */
public class PdfFile extends ResourceFile {

    public PdfFile(String fileName) {
        super(fileName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPdf(this);
    }
}
