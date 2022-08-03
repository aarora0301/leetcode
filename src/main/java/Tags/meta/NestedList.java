package Tags.meta;

import java.util.List;

public class NestedList {

    public static void main(String[] args) {

    }


    private void recurdepthSum(List<NestedInteger> nestedList, int depth) {

        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                sum += depth * nestedList.get(i).getInteger();
            } else {
                recurdepthSum(nestedList.get(i).getList(), depth + 1);
            }
        }
    }

    int sum = 0;

    private void recur(List<NestedInteger> nestedList, int curr, int nestedCurr, int depth) {
        if (curr >= nestedList.size()) {
            return;
        }

        if (nestedCurr == 0 && nestedList.get(curr).isInteger()) {
            sum += depth * nestedList.get(curr).getInteger();
            recur(nestedList, curr + 1, nestedCurr, depth);
        } else {

        }
        recur(nestedList.get(curr).getList(), curr + 1, nestedCurr, depth + 1);

    }


}

interface NestedInteger {
    // Constructor initializes an empty nested list.
    // public NestedInteger();

    // Constructor initializes a single integer.
    //    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
