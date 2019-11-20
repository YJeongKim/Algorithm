public class ExpFindMax2 {
    public static void main(String[] args) {
        int[] data = { 3, 2, 6, 7, 9, 1 };
        int result = findMax(data, 0, 5);
        System.out.println("결과 : " + result);
    }

    public static int findMax(int[] data, int begin, int end) {
        if (begin == end)
            return data[begin];
        else {
            int middle = (begin + end) / 2;
            int max1 = findMax(data, begin, middle);
            int max2 = findMax(data, middle + 1, end);
            return Math.max(max1, max2);
        }
    }
}