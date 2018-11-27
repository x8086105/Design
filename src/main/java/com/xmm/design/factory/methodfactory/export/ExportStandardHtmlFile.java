package com.xmm.design.factory.methodfactory.export;

public class ExportStandardHtmlFile implements ExportFile {
    @Override
    public boolean exportFile(String data) {
        System.out.println("导出标准的HTML 文件");
        return true;
    }
}
