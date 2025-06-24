package DAY3.duotai;

class human{
    int age=10;
    public void print(){
        System.err.println("i am a human"+age);
    }
}

class man extends human{
    int age=20;
    @Override
    public void print(){
        System.out.println("i am a man"+age);
        super.print();
    }
}

public class test {
    public static void main(String[] args) {
        man a = new man();
        human b = new man();

        a.print();
        b.print();

        System.out.println(a.age);
        System.out.println(b.age); //成员变量调用父类，函数调用子类
    }
}
