package Assessment3;

public class ShuffledString {

    public static void main(String[] args) {
        ShuffledString shuffledString = new ShuffledString();
        System.out.println(shuffledString.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(shuffledString.restoreString("abc", new int[]{0, 1, 2}));


    }

    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] chars = new char[n];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return String.valueOf(chars);
    }

}
