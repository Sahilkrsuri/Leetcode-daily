import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutate(nums, 0, nums.length - 1, ans);
        return ans;
    }

    public void permutate(int[] arr, int start, int end, List<List<Integer>> ans) {

        if (start == end) {
            List<Integer> list = new ArrayList<>();

            for (int num : arr) {
                list.add(num);
            }

            ans.add(list);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(arr, start, i);

            permutate(arr, start + 1, end, ans);

            swap(arr, start, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
