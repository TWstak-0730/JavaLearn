package DAY1;

class phone {
    String brand;
    String price;

    void call() {
        System.out.println(brand+" is Calling...");
    }
    void message() {
        System.out.println(brand+" is Sending message...");
    }
    void call(String number) {
        System.out.println(brand+" is Calling "+number+"...");
    }
    
}
