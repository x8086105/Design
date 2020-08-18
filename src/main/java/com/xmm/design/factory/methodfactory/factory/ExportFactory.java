package com.xmm.design.factory.methodfactory.factory;

import com.xmm.design.factory.methodfactory.export.ExportFile;

public interface ExportFactory {

    ExportFile factory(Integer type);
}
