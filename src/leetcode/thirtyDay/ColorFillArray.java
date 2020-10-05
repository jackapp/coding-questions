package leetcode.thirtyDay;

public class ColorFillArray {

    public static void main(String[] args) {

    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return image;
    }

    public static void floodFill(int[][] image, int sr, int sc,int oldColor, int newColor) {
        if (isValid(image,sr,sc,oldColor)) {
            image[sr][sc]=-1;
            floodFill(image,sr+1,sc,oldColor,newColor);
            floodFill(image,sr,sc+1,oldColor,newColor);
            floodFill(image,sr-1,sc,oldColor,newColor);
            floodFill(image,sr,sc-1,oldColor,newColor);
            image[sr][sc]=newColor;
        }
    }

    public static boolean isValid(int arr[][],int x,int y,int color) {
        if (x>=0 && y>=0 && x <arr.length && y <arr[0].length) {
            if (arr[x][y]==-1 || arr[x][y]!=color) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
