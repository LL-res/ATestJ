package initializationP;

public class Pojo1 {

    private String simpleObject = "abc";
    public static Integer staticObject;
    public static final Integer staticFinalObject = 3;
    public static final int staticFinalNative = 4;
    //初始化类时会执行
    static {
        System.out.println("static code block");
    }
    public Pojo1(){
        System.out.println("instance constructor");
    }
    //会被按顺序加到构造函数之前
    {
        System.out.println("instance code block");
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "2";
        String c = "12";
        String d = a + b;
        System.out.println(c == d);
    }
}
