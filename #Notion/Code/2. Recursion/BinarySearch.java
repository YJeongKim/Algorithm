public class BinarySearch {
    public static void main(String[] args) {
        String[] items = { "orange", "apple", "pineapple", "watermelon", "banana" };
        int result = binarySearch(items, "watermelon", 0, 4);
        System.out.println("결과 : " + result + " " + items[result]);
    }

    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end)
            return -1;
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0)
                return middle;
            else if (compResult < 0)
                return binarySearch(items, target, begin, middle - 1);
            else
                return binarySearch(items, target, middle + 1, end);
        }
    }
}