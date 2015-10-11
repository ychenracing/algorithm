package companies.baidu;

import java.util.ArrayList;
import java.util.List;

/**
 * 8*8的棋盘，马在棋盘的左下角，只能走“日”字，输出其走到右上角的所有可能路径。
 * @author racing
 * @version $Id: HorseRoads.java, v 0.1 Oct 11, 2015 8:22:31 PM racing Exp $
 */
public class HorseRoads {

    public static void main(String[] args) {

        List<List<Point>> result = getRoads(9, 0);
        if (result == null || result.isEmpty())
            System.out.println("no result!");
        for (List<Point> road : result) {
            printRoad(road, 10);
        }

    }

    static class Point {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "<" + this.x + "," + this.y + ">";
        }
    }

    public static List<List<Point>> getRoads(int curRow, int curCol) {
        if (curRow < 0 || curRow > 9 || curCol < 0 || curCol > 9)
            return null;
        List<List<Point>> result = new ArrayList<List<Point>>();
        if (curRow == 0 && curCol == 9) {
            List<Point> pointList = new ArrayList<Point>();
            pointList.add(new Point(curRow, curCol));
            result.add(pointList);
            return result;
        }

        int nextRow1 = curRow - 2;
        int nextCol1 = curCol + 1;
        int nextRow2 = curRow - 1;
        int nextCol2 = curCol + 2;

        List<List<Point>> result1 = getRoads(nextRow1, nextCol1);
        List<List<Point>> result2 = getRoads(nextRow2, nextCol2);

        if (result1 == null && result2 == null)
            return null;

        if (result1 != null) {
            for (List<Point> road1 : result1) {
                List<Point> newResult1 = new ArrayList<Point>();
                newResult1.add(new Point(curRow, curCol));
                newResult1.addAll(road1);
                result.add(newResult1);
            }
        }

        if (result2 != null) {
            for (List<Point> road2 : result2) {
                List<Point> newResult2 = new ArrayList<Point>();
                newResult2.add(new Point(curRow, curCol));
                newResult2.addAll(road2);
                result.add(newResult2);
            }
        }

        return result;
    }

    public static void printRoad(List<Point> road, int num) {
        int[][] matrix = new int[num][num];
        for (Point point : road) {
            matrix[point.x][point.y] = 1;
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(matrix[i][j] + " ");
                if (j == num - 1)
                    System.out.println();
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
