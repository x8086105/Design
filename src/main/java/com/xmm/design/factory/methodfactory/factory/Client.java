package com.xmm.design.factory.methodfactory.factory;

import com.xmm.design.factory.methodfactory.export.ExportFile;

/**
 * @author xuemingming
 */
public class Client {
    public static void main(String[] args) {
        ExportFactory exportFactory=new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory(0);
        ef.exportFile("xxx");

    }
}
