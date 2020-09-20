package MustKnow.Sort;

public class Merge {
    int[] help;
    public void mergeSort(int[] arr) {
        int[] help = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }
    public void sort(int[] arr, int start, int end) {
        if (start == end) return;
        int mid = start + (end - start) / 2;
        sort(arr, start, mid);
        sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public void merge(int[] arr, int start, int mid, int end) {
        if (end + 1 - start >= 0) System.arraycopy(arr, start, help, start, end + 1
                - start);
        int p = start;
        int q = mid + 1;
        int index = start;
        while (p <= mid && q <= end) {
            if (help[p] < help[q])
                arr[index++] = help[p++];
            else
                arr[index++] = help[q++];
        }
        while (p <= mid) arr[index++] = help[p++];
        while (q <= end) arr[index++] = help[q++];
    }
}
