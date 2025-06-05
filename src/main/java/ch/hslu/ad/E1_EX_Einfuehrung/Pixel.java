package ch.hslu.ad.E1_EX_Einfuehrung;

import java.util.Arrays;

public class Pixel {
    static final int WIDTH = 11;
    static final int HEIGHT = 10;
    static char[][] grid = {
            //1   2   3   4   5   6   7   8   9   10  11
            {'B','B','B','B','B','B','B','B','B','B','B'},//10
            {'B','W','W','W','W','W','W','W','B','B','B'},//9
            {'B','W','B','B','B','B','B','W','B','B','B'},//8
            {'B','W','B','B','w','W','W','W','B','B','B'},//7
            {'B','W','B','B','W','B','B','B','B','B','B'},//6
            {'B','W','B','B','W','W','W','W','W','W','B'},//5
            {'B','W','W','W','W','W','W','W','W','W','B'},//4
            {'B','W','W','W','W','W','B','B','W','W','B'},//3
            {'B','W','W','W','B','B','B','B','B','B','B'},//2
            {'B','B','B','B','B','B','B','B','B','B','B'} //1
    };

    static int[][] visitOrder = new int[HEIGHT][WIDTH];
    static int step = 1;
    static int methodCalls = 0;

    public static void colorArea(int x, int y, char fillColor, char outsideColor) {
        methodCalls++;
        System.out.println("colorArea(int " + (x + 1) + ", int " + Math.abs(y - HEIGHT) + ")");
        System.out.println("methodCalls: " + methodCalls);
        System.out.println("step: " + step);
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return;

        char actualColor = grid[y][x];

        if (actualColor != outsideColor && actualColor != fillColor) {
            grid[y][x] = fillColor;
            System.out.println("Fill Color at x: " + (x + 1) + " y: " + Math.abs(y - HEIGHT));
            visitOrder[y][x] = step++;
            colorArea(x + 1, y, fillColor, outsideColor); // right
            colorArea(x, y - 1, fillColor, outsideColor); // up (since y grows downward in arrays)
            colorArea(x - 1, y, fillColor, outsideColor); // left
            colorArea(x, y + 1, fillColor, outsideColor); // down
        }
    }

    public static void main(String[] args) {
        // Diagram: (x=4, y=3) → Java grid: y = HEIGHT - y = 10 - 3 = 7
        int diagramX = 4;
        int diagramY = 3;
        int javaX = diagramX - 1;
        int javaY = HEIGHT - diagramY;

        colorArea(javaX, javaY, 'F', 'B');

        // Print result in diagram orientation (y=1 bottom → y=10 top)
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.printf("%3s", visitOrder[y][x] == 0 ? "." : visitOrder[y][x]);
            }
            System.out.println();
        }

        // Print color grid
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.printf(String.valueOf(grid[y][x]));
            }
            System.out.println();
        }
    }
}
