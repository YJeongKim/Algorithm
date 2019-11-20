public class ExpSequentialMid {
    public static void main(String[] args) {
        int[] data = { 4, 7, 1, 5, 9 };
        int result = search(data, 0, 4, 5);
        System.out.println("결과 : " + result);
    }

    public static int search(int[] data, int begin, int end, int target) {
        if (begin > end)
            return -1;
        else {
            int middle = (begin + end) / 2;
            if (data[middle] == target)
                return middle;
            int index = search(data, begin, middle - 1, target);
            if (index != -1)
                return index;
            else
                return search(data, middle + 1, end, target);
        }
    }
}