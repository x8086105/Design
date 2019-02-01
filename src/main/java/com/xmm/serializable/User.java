package com.xmm.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * 测试java中实现的序列化
 * @author xuemingming
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 6355727801958768665L;
    private String name;
    private Integer age;
    private transient String className;
    private static Integer stInteger1=110;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serializable();
        deserializable();

    }
    private static void serializable() throws  IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.out"));
        User u=User.builder().age(10).name("xmm").className("不会被序列化").build();
        oos.writeObject(u);
        oos.flush();
    }
    private static void deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("test.out"));
        User user =(User)ois.readObject();
        System.out.println(user.getAge()+ " " +
                user.getName()+"  "+user.getClassName() );
    }
    private void writeObject(ObjectOutputStream s) throws Exception{
         System.out.println("我想自己控制序列化的过程");
         s.defaultWriteObject();
         //可以通过该方法 自定义让把transient 关键字修饰的属性进行序列化
        s.writeInt(className.length());
        for(int i=0;i<className.length();i++){
            s.writeChar(className.charAt(i));
        }

    }
    private void readObject(ObjectInputStream s) throws Exception {
        System.out.println("自定义反序列化的过程");
        s.defaultReadObject();
        int length=s.readInt();
        char[] cs=new char[length];
        for(int i=0;i<length;i++){
            cs[i] = s.readChar();
        }
        className = new String(cs, 0, length);
    }
}
