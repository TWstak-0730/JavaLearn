package DAY1;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;

class Student {
    private String name;
    private int age;

    Student() {
        this.name = "Unknown";
        this.age = 0;
    }
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
public class StudentTools {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    public Student getStudent(){
        String name;
        int age;
        name = scanner.next();
        age = scanner.nextInt();
        Student tmp = new Student(name, age);
        return tmp;
    }
}
