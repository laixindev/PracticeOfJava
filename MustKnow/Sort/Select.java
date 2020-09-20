package MustKnow.Sort;

//和插入排序方向相反，过程类似
public class Select {
    public void selectSort(int[] nums) {
        int miniIndex;
        for (int index = 0; index < nums.length - 1; index++) {
            miniIndex = index;
            for (int i = index + 1; i < nums.length; i++) {
                if (nums[i] < nums[miniIndex])
                    miniIndex = i;
            }
            if (index != miniIndex) {
                swap(nums, index, miniIndex);
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private void swap(int[] nums, int index, int miniIndex) {
        int tmp = 0;
        tmp = nums[index];
        nums[index] = nums[miniIndex];
        nums[miniIndex] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        Select select = new Select();
        select.selectSort(nums);
    }
}
