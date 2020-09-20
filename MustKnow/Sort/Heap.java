package MustKnow.Sort;

public class Heap {
    public void add(int[]nums,int i,int num){
        nums[i] = num;
        int curIndex = i;
        while(curIndex>0){
            int parentIndex = (curIndex-1)/2;
            if(nums[parentIndex]<nums[curIndex])
                swap(nums,parentIndex,curIndex);
            else
                break;
            curIndex = parentIndex;
        }
    }
    public int remove(int[]nums,int size){
        int result = nums[0];
        nums[0] = nums[size-1];
        int curIndex = 0;
        while(true){
            int leftIndex = curIndex*2+1;
            int rightIndex = curIndex*2+2;
            if(leftIndex>=size)break;
            int maxIndex = leftIndex;
            if(rightIndex<size && nums[maxIndex]<nums[rightIndex])
                maxIndex = rightIndex;
            if(nums[curIndex] < nums[maxIndex])
                swap(nums,curIndex,maxIndex);
            else break;
            curIndex = maxIndex;
        }
        return result;
    }
    private void swap(int[] nums, int index, int miniIndex) {
        int tmp = 0;
        tmp = nums[index];
        nums[index] = nums[miniIndex];
        nums[miniIndex] = tmp;
    }
}
