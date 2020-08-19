package com.xmm.design.prototype.deepclone;

import org.apache.poi.ss.formula.functions.T;

import java.io.*;

public abstract class AbstractObject implements Serializable {
    /**
     * 将该对象转换成目标对象
     * @param
     * @param <T>
     * @return
     */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream out = null;
        ObjectOutputStream obs = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        Object o = null;
        try {
            //定义输出流
            out = new ByteArrayOutputStream();
            obs = new ObjectOutputStream(out);
            obs.writeObject(this);
            //定义输入流
            bis = new ByteArrayInputStream(out.toByteArray());
            ois = new ObjectInputStream(bis);
            o =  ois.readObject();
        } catch (Exception e) {

        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (obs != null) {
                    obs.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return o;
    }
}
