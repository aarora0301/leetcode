package Tags.meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OceanView {
    public static void main(String[] args) {
        OceanView oceanView= new OceanView();
        oceanView.findBuildings(new int[]{4,2,3,1});
        oceanView.findBuildings(new int[]{4,3,2,1});
        oceanView.findBuildings(new int[]{1,2,3,4});
        oceanView.findBuildings(new int[]{2,2,2,2});

    }

    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) {
            return new int[0];
        }

        int[] right = new int[heights.length];
        right[heights.length-1]= heights.length-1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[right[i + 1]] > heights[i]) {
                right[i] = right[i + 1];
            } else {
                right[i] = i;
            }
        }

        List<Integer> list= new LinkedList<>();
        for (int i=0; i<heights.length-1;i++){
            if (heights[right[i+1]]<heights[i]){
                list.add(i);
            }
        }
        list.add(heights.length-1);
        System.out.println(Arrays.toString(list.toArray()));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
