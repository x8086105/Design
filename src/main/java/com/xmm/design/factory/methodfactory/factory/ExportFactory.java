package com.xmm.design.factory.methodfactory.factory;

import com.xmm.design.factory.methodfactory.export.ExportFile;

public interface ExportFactory {
    public  ExportFile factory(Integer type);
}
