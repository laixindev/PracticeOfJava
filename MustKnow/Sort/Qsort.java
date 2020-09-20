package MustKnow.Sort;

public class Qsort {
    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivotIndex = getPivotIndex(nums, start, end);
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);

        }

    }

    public int getPivotIndex(int[] nums, int start, int end) {
        int pivot = nums[start];
        int low = start;
        int high = end;
        while (low < high) {
            while (low <= high && nums[low] <= pivot)
                low++;
            while (low <= high && nums[low] > pivot)
                high--;
            if (low < high)
                swap(nums, low, high);
        }
        swap(nums, start, end);
        return high;
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = 0;
        tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;

    }

    public static void main(String[] args) {
        int []nums = {2,1,3,4,5};
        Qsort qsort = new Qsort();
        qsort.quickSort(nums,0,nums.length-1);
        for(int num:nums){
            System.out.print(num+" ");
        }

    }


}
