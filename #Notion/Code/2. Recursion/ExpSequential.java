public class ExpSequential {
    public static void main(String[] args) {
        int[] data = { 4, 7, 1, 5, 9 };
        int result = search(data, 0, 4, 5);
        System.out.println("결과 : " + result);
    }

    public static int search(int[] data, int begin, int end, int target) {
        if (begin > end)
            return -1;
        else if (target == data[begin])
            return begin;
        else
            return search(data, begin + 1, end, target);
    }
}