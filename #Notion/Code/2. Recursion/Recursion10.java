public class Recursion10 {
    public static void main(String[] args) {
        printChars("abc");
    }

    public static void printChars(String str) {
        if (str.length() == 0)
            return;
        else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }
}