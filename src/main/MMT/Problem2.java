//package main.MMT;
//
//// string 1
//// string 2
////min len substring in string 1 having all characters of string 2
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///****
// *  S= "Rohit Malhotrao"
// *  t= "hot"
// *
// *  Map <char, Int[]>
// *
// * r --- >0
// * o====> 1,9
// * h--->  2,8
// * i--->3
// * t----> 4,10
// * Map : 26 character:
// *
// * n + len(t) + n ~ n == n
// *
// *
// */
//public class Problem2 {
//
//
//    private int getSubstringLen(String s, String t) {
//        if (s == null) {
//            return 0;
//        }
//
//        Map<Character, List<Integer>> map = new HashMap<>();
//        List<Integer> val;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                val = map.get(s.charAt(i));
//                val.add(i);
//            } else {
//                val = new ArrayList<>();
//                val.add(i);
//            }
//            map.put(s.charAt(i), val);
//        }
//
//
//        int minSize = Integer.MAX_VALUE;
//        for (int i = 0; i < t.length(); i++) {
//            if (!map.containsKey(t.charAt(i))) {
//                return 0;
//            }
//            minSize = Math.min(minSize, map.get(t.charAt(i)).size());
//
//        }
//
//
//        int j = 0;
//        int result = Integer.MAX_VALUE;
//
//        int minIndex = Integer.MAX_VALUE;
//        int maxIndex = Integer.MIN_VALUE;
//
//        while (j < minSize) {
//
//            minIndex = Integer.MAX_VALUE;
//            maxIndex = Integer.MIN_VALUE;
//            for (int i = 0; i < t.length(); i++) {
//                minIndex = Math.min(map.get(t.charAt(i)).get(j), minIndex);
//                maxIndex = Math.max(map.get(t.charAt(i)).get(j), maxIndex);
//
//            }
//            System.out.println("Max " + maxIndex);
//            System.out.println("Min " + minIndex);
//            result = Math.min(result, maxIndex - minIndex + 1);
//            j++;
//        }
//
//        return result;
//
//
//    }
//
//
//
//     */
//    public static Integer bestAverageGrade(String[][] scores) throws Exception
//    {
//
//        if (scores==null){
//            return 0;
//        }
//
//        Map<String, Integer> map= new HashMap();
//        int score, val;
//        int maxScore= Integer.MIN_VALUE;
//        for (String[] arr: scores){
//
//
//            if (arr.length!=2){
//                throw new Exception("Invalid Input");
//            }
//            if (map.containsKey(arr[0])){
//
//                val= map.get(arr[0]);
//                score= Integer.parseInt(arr[1])+val/2;
//            }
//            else{
//                score = Integer.parseInt(arr[1]);
//            }
//            score= Math.max(score, maxScore);
//            map.put(arr[0], score);
//            return maxScore;
//        }
//        // TODO: implement this function
//
//        public static void main(String[] args) {
//        Problem2 problem2 = new Problem2();
//        int ans = problem2.getSubstringLen("abc", "hot");
//        System.out.println(ans);
//    }
//}
//
///****
// *  angle between min and hour hand 90
// *  12:30
// *
// *    60min hour ----> 360
// *    30 min     ----> 180
// *    12---> 0
// *
// *    24 hours
// *    in 12 hours -----> hour hand --> 360
// *      1---> 360/ 12----> 30
// *      h/f-----> 15 degree
// *
// *    in 60 min ------ > 360 degree
// *    30 min----> 180 degre
// *
// *    180- 15---> 165 degree
// *
// *
// *
// * */
