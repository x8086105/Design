package homeconcurrent.juc;

public class Test1 {
    public static void main(String[] args) {
        int i = 0;
        //i++ i = i + 1
        int x = i++;
        System.out.println(x);
        System.out.println(i);
        int j= 0 ;
        System.out.println(++j);
        System.out.println(j);
    }
}
