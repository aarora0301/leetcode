package AmazonFAQ.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            addNumberInResultSet(result, num);
        }
        return result;
    }


    private void addNumberInResultSet(List<List<Integer>> result, int num) {
        List<Integer> dummy;
        List<List<Integer>> temp= new ArrayList<>();
        for (List<Integer> list : result) {
            dummy = new ArrayList<>(list);
            dummy.add(num);
            temp.add(dummy);
        }
        result.addAll(temp);
    }


    public static void main(String[] args) {
        Subsets subsetsObj = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsetsObj.subsets(nums));
    }
}
