public class ExpFindMax {
    public static void main(String[] args) {
        int[] data = { 3, 2, 6, 7, 9, 1 };
        int result = findMax(data, 0, 5);
        System.out.println("결과 : " + result);
    }

    public static int findMax(int[] data, int begin, int end) {
        if (begin == end)
            return data[begin];
        else
            return Math.max(data[begin], findMax(data, begin + 1, end));
    }
}