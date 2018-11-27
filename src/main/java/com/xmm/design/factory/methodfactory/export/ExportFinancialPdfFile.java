package com.xmm.design.factory.methodfactory.export;

public class ExportFinancialPdfFile implements ExportFile {
    @Override
    public boolean exportFile(String data) {
        System.out.println("导出财务的PDF 文件");
        return true;
    }
}
