package com.xmm.design.factory.methodfactory.factory;

import com.xmm.design.factory.methodfactory.export.ExportFile;
import com.xmm.design.factory.methodfactory.export.ExportFinancialPdfFile;
import com.xmm.design.factory.methodfactory.export.ExportStandardPdfFile;

/**
 * 工厂方法模式 工厂类
 * @author xuemingming
 */
public class ExportPdfFactory implements ExportFactory {
    @Override
    public ExportFile factory(Integer type) {
        switch (type){
            case 0:
                return new ExportFinancialPdfFile();

            case 1:
                return new ExportStandardPdfFile();

            default:
                System.out.println("类型异常");
                return null;

        }
    }
}
