package jvm;

import org.junit.jupiter.api.Test;

/**
 * 测试对象内存分配
 * 添加启动参数
 * -Xmx2560m 最大堆内存空间
 * -Xms2560m 最小堆内存空间
 * -Xss栈内存大小
 * -XX:MetasapceSize = 256m 元空间大小
 * -XX:CMSFullGCsBeforeCompaction = 1
 * 设置CMS收集器在进行若干次垃圾收集后再启动一次内存碎片整理，仅在使用CMS垃圾收集器的时候有用
 * -XX:UseCMSCompactAtFullCollection 设置CMS收集器在老年代空间被使用多少后出发垃圾收集
 * 仅在使用CMS收集器时生效
 * -XX:+HeapDumpBeforeFullGC
 * -XX:+HeapDumpOnOutOfMemoryError
 * -XX:+CMSClassUnloadingEnabled 这个参数表示在使用CMS垃圾回收机制的时候是否启用类卸载功能。
 * 默认这个是设置为不启用的，所以你想启用这个功能你需要在Java参数中明确的设置下面的参数：
 * -XX:useParNewGC 新生代使用ParNew GC
 * -XX:useConcMarkSweepGC 老年代使用CMS GC
 *  -XX:+HeapDumpOnOutOfMemoryError 发生内存泄漏的时候，会生成一个快照文件
 *  -XX:HeapDumpPath=d:/a.dump    HeapDump文件所存放的位置
 * -XX:PrintGCDetails
 * -verbose:gc //表示输出虚拟机中GC的详细情况.
 */
public class TestObject {
    private static int LENGTH = 100000000;
//    public static void main(String[] args) throws Exception {
////        for(int i = 0  ; i < 100 ; i++){
////            newObject();
////            System.out.println("次数" + i);
////            Thread.sleep(1000);
////        }
//        newObject();
//    }
//
//    public static void newObject(){
//
//        for(int i =0;i<100000;i++){
//            byte [] t = new byte[50];
//        }
////        for(int i = 0 ; i < LENGTH ;i++){
////            //new 了是在堆里还是在栈上？执行上👆面命令查看
////            Node node = new Node(i);
////        }
//
//    }
public static void alloc(){
    byte[] b=new byte[2];
    b[0]=1;
}
    public static void main(String[] args) {
        long b=System.currentTimeMillis();
        for(int i=0;i<100000000;i++){
            alloc();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-b);
    }
    //POJO 不用看这里
    static class Node {

        private int valuel;

        private TestObject.Node node;

        public Node(int valuel) {
            this.valuel = valuel;
        }

        public Node(int valuel, TestObject.Node node) {
            this.valuel = valuel;
            this.node = node;
        }

        public int getValuel() {
            return valuel;
        }

        public void setValuel(int valuel) {
            this.valuel = valuel;
        }

        public TestObject.Node getNode() {
            return node;
        }

        public void setNode(TestObject.Node node) {
            this.node = node;
        }
    }

}

/**
 JAVA_OPTS="-server -Xms2560m -Xmx2560m -Xss256k -XX:MetaspaceSize=256M
 -XX:MaxMetaspaceSize=256M -XX:+UseConcMarkSweepGC -XX:+UseParNewGC
 -XX:CMSFullGCsBeforeCompaction=1 -XX:CMSInitiatingOccupancyFraction=75
 -XX:+HeapDumpBeforeFullGC -XX:+HeapDumpOnOutOfMemoryError -XX:+CMSClassUnloadingEnabled
 -XX:+UseCMSInitiatingOccupancyOnly -XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses
 -verbose:gc //表示输出虚拟机中GC的详细情况.
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps -Djava.io.tmpdir=/home/logs/$APP_NAME/
 -XX:HeapDumpPath=/mfsdata/javaHeapDump/btr-zd/ -Xloggc:/home/logs/$APP_NAME/gc.log
 -XX:ErrorFile=/home/logs/$APP_NAME/hs_err_pid%p.log"
**/