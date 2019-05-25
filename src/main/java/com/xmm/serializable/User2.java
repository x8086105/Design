package com.xmm.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User2 implements Externalizable {

    private String name;
    private Integer age;
    private transient String className;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.out"));
        User2 u=User2.builder().age(110).name("xmm").className("不会被序列化").build();
        oos.writeObject(u);
        oos.flush();
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("test.out"));
        User2 user =(User2)ois.readObject();
        System.out.println(user.getAge()+ " " +
                user.getName()+"  "+user.getClassName() );
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            name=(String)in.readObject();
    }
}
