public class Test {

    private int number;
    public String text;

    public Test() {
        number = 10;
        text = "Hello";
    }

    public void printHello() {
        System.out.println("Hello method");
    }

    public int getNumber() {
        return number;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public String getText() {
        return text;
    }
}