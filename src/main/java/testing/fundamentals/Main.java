package testing.fundamentals;

public class Main {
    public static void main(String[] args) {
        ArrayStringEx arrayStringEx = new ArrayStringEx();
        String text = "My name is Alex";
        String text2 = arrayStringEx.changeSpaceInString(text);
        System.out.println(text2);
    }
}
