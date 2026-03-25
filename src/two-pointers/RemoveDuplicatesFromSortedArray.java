public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int low = 0, high = 0;
        while (high < n) {
            if (nums[low] != nums[high]) {
                // unique pair
                low++;
                nums[low] = nums[high];
                // move high till not find next
                while (high < n && nums[high] == nums[high - 1]) {
                    high++;
                }
            } else {
                high++;
            }
        }

        return low + 1;
    }
}
