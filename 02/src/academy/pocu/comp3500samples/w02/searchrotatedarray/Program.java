package academy.pocu.comp3500samples.w02.searchrotatedarray;

public class Program {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 25, 26, 29, 33, 1, 3, 5, 6, 10, 11, 19};

        int index = indexOfRotatedArray(arr, 0, arr.length - 1, 0);
        System.out.println(index);

        index = indexOfRotatedArray(arr, 0, arr.length - 1, 1);
        System.out.println(index);

        index = indexOfRotatedArray(arr, 0, arr.length - 1, 29);
        System.out.println(index);

        index = indexOfRotatedArray(arr, 0, arr.length - 1, 6);
        System.out.println(index);
    }

    private static int indexOfRotatedArray(int[] arr, int start, int end, int num) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == num) {
            return mid;
        }

        // 어찌됐든 찾는 값이 앞쪽인지 뒤쪽인지 판별
        if (arr[start] <= arr[mid]) {
            // 1. 앞쪽이 정렬되어 있고 찾는 값도 앞쪽에 있음 -> 일반적인 이진 탐색
            if (arr[start] <= num && num <= arr[mid]) {
                return indexOfRotatedArray(arr, start, mid - 1, num);
            }

            // 2. 뒤쪽에 어긋난 부분이 있지만 그건 별 상관없고 쨌든 찾는 값이 뒤쪽에 있음
            return indexOfRotatedArray(arr, mid + 1, end, num);
        } else {
            // 3. 뒤쪽이 정렬되어 있고 찾는 값도 뒤쪽에 있음 -> 일반적인 이진 탐색
            if (arr[mid] <= num && num <= arr[end]) {
                return indexOfRotatedArray(arr, mid + 1, end, num);
            }

            // 4. 쨌든 찾는 값이 앞쪽에 있음
            return indexOfRotatedArray(arr, start, mid - 1, num);
        }
    }
}
