package DAY1;
/*
    标准的JavaBean类
    1. 成员变量私有化
    2. 提供无参构造方法
    3. 提供每一个成员变量的setter和getter方法
 */
class javabean {
    private String name;
    private int age;

    javabean() {
        name = "Default Name";
        age = 0;
    }

    javabean(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    

}

public class standjavabean {
    public static void main(String[] args) {
        javabean bean1 = new javabean();
        javabean bean2 = new javabean("John Doe", 25);
        System.out.println("Bean1 Name: " + bean1.getName() + ", Age: " + bean1.getAge());
        System.out.println("Bean2 Name: " + bean2.getName() + ", Age: " + bean2.getAge());

    }

}
