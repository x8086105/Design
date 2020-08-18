package com.xmm.design.proxy.JdkProxy;

import java.io.FileOutputStream;
import java.io.IOException;

public class ProxyGeneratorUtils {
    public static void writeProxyClassToHardDisk(String path, Class<?>[] intfs) {
        byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass("$SuperStarProxy",intfs);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

