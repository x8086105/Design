package jvm;

import jvm.entity.UserEntity;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        String fileName = name.substring(name.lastIndexOf("1")+1)+".class";
        InputStream is = getClass().getResourceAsStream(fileName);
        if(is == null){
            return super.loadClass(name);
        }
        try {
            byte[] b = new byte[is.available()];
            is.read(b);
            return defineClass(name,b,0,b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }

    public static void main(String[] args) {
        ClassLoaderTest c = new ClassLoaderTest();
        try {
            Object o = c.loadClass(UserEntity.class.getName());
            System.out.println(((Class) o).getName());
            //不一样的原因 一个是由运用程序类加载器加载的，一个是由用户自定义类加载器加载的
            System.out.println(o instanceof jvm.entity.UserEntity);
            UserEntity u = new UserEntity();
            System.out.println(u instanceof jvm.entity.UserEntity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
