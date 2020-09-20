package MustKnow.Sort;

public class Insert {
    public void insertionSort(int[] nums) {
        //以第一个数为标准，从第二个数开始，从后往前看，后面的大数都后移一位，然后插入
        for (int i = 1; i < nums.length; i++) {
            int insertNum = nums[i];
            int insertIndex;
            for (insertIndex = i - 1; insertIndex >= 0 && nums[insertIndex] > insertNum; insertIndex--) {
                nums[insertIndex + 1] = nums[insertIndex];
            }
            nums[insertIndex + 1] = insertNum;
        }
        for (int num : nums)
            System.out.println(num);
    }

    public void binaryInsertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertNum = nums[i];
            int insertIndex = -1;
            int start = 0;
            int end = i - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (insertNum > nums[mid]) {
                    start = mid + 1;
                } else if (insertNum < nums[mid])
                    end = mid - 1;
                else {
                    insertIndex = mid + 1;
                    break;
                }
            }
            if (insertIndex == -1)
                insertIndex = start;
            if (i - insertIndex >= 0) {
                System.arraycopy(nums, insertIndex, nums, insertIndex + 1, i - insertIndex);
            }
            nums[insertIndex] = insertNum;
        }
        for (int num : nums)
            System.out.println(num);
    }

    // 插排的一种改进，记录按下标的一定增量分组，对每组进行插入排序，每次排序后减少增量，增量减少到1时，完成排序
    // 就是给一个d=nums.length;d/=2;然后用d代替1的位置
    public void shellSort(int[] nums) {
        for (int d = nums.length / 2; d > 0; d /= 2) {
            for (int i = d; i < nums.length; i++) {
                int insertNum = nums[i];
                int insertIndex;
                for (insertIndex = i - d; insertIndex >= 0 && nums[insertIndex] > insertNum; insertIndex -= d) {
                    nums[insertIndex + d] = nums[insertIndex];
                }
                nums[insertIndex + d] = insertNum;
            }

        }
        for (int num : nums)
            System.out.print("shell:" + num+" ");
    }


    public static void main(String[] args) {
        Insert insert = new Insert();
        int[] nums = new int[]{2, 1, 3, 5, 6};

        //insert.insertionSort(nums);
        //insert.shellSort(nums);
        insert.binaryInsertionSort(nums);

    }
}
