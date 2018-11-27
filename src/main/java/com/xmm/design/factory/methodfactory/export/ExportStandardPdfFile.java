package com.xmm.design.factory.methodfactory.export;

/**
 * 导出标准的PDF 文件
 * @author xuemingming
 */
public class ExportStandardPdfFile implements ExportFile {
    @Override
    public boolean exportFile(String data) {
        System.out.println("导出标准的PDF 文件");
        return true;
    }
}
