package main.java.Patterns.DFS;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        int startColor = image[sr][sc];
        dfs(image, sr, sc, newColor, startColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int startColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == newColor ||
                image[sr][sc] != startColor) {
            return;
        }
        if (image[sr][sc] == startColor) {
            image[sr][sc] = newColor;
        }
        dfs(image, sr - 1, sc, newColor, startColor);
        dfs(image, sr + 1, sc, newColor, startColor);
        dfs(image, sr, sc - 1, newColor, startColor);
        dfs(image, sr, sc + 1, newColor, startColor);
    }

    public static void main(String[] args) {

    }
}
