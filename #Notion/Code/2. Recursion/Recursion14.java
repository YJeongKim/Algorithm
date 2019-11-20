import java.util.*;
import java.io.*;

class Sub {
    public void readFrom(int n, int[] data, Scanner in) {
        if (n == 0)
            return;
        else {
            readFrom(n - 1, data, in);
            data[n - 1] = in.nextInt();
        }
    }
}

public class Recursion14 {
    public static void main(String[] args) {
        int[] data = new int[5];
        Sub sub = new Sub();
        File file = new File("E:\\data.txt");
        Scanner in;
        try {
            in = new Scanner(file);
            sub.readFrom(5, data, in);
            for (int num : data)
                System.out.println(num);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}