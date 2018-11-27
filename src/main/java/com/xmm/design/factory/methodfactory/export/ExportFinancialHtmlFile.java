package com.xmm.design.factory.methodfactory.export;

/**
 * @author xuemingming
 */
public class ExportFinancialHtmlFile implements ExportFile {
    @Override
    public boolean exportFile(String data) {
        System.out.println("导出财务HTML 表格的信息");
        return true;
    }
}
