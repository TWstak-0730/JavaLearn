package DAY1;

public class test_phone {
    public static void main(String[] args) {
        phone p = new phone();
        p.brand = "Samsung";
        p.price = "1000";
        p.call("9876543210");
        p.message();
        phone p1 = new phone();
        p1.brand = "Apple";
        p1.price = "1200";
        p1.call("1234567890"); 
        p1.message();
    }
}
