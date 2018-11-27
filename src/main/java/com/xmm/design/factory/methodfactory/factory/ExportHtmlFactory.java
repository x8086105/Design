package com.xmm.design.factory.methodfactory.factory;

import com.xmm.design.factory.methodfactory.export.ExportFile;
import com.xmm.design.factory.methodfactory.export.ExportFinancialHtmlFile;
import com.xmm.design.factory.methodfactory.export.ExportStandardHtmlFile;

public class ExportHtmlFactory implements ExportFactory {
    @Override
    public ExportFile factory(Integer type) {
        switch (type){
            case 0:
                return new ExportFinancialHtmlFile();

            case 1:
                return new ExportStandardHtmlFile();

                default:
                    System.out.println("类型异常");
                    return null;

        }
    }
}
