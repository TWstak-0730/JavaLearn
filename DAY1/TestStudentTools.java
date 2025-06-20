package DAY1;

import java.io.*;

public class TestStudentTools {
    public static void main(String[] args) {
        StudentTools st = new StudentTools();
        Student s1 = new Student();
        s1 = st.getStudent();

        System.out.println(s1.getName());
        System.out.println(s1.getAge());
    }
}
