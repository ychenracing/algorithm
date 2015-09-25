package companies.mi;

import java.util.Scanner;

/**
 * 推箱子
 * @author racing
 *
 */
public class PushBoxes {

	/**
	 * 5 4 3 
	 * 00000 
	 * 13000 
	 * 00200 
	 * 00000 
	 * 4 rurd 
	 * 6 urdldr 
	 * 6 rrrurd
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, m, s;
		n = in.nextInt();
		m = in.nextInt();
		s = in.nextInt();
		int originPosition_x = 0, originPosition_y = 0;
		int originBox_x = 0, originBox_y = 0;
		int terminal_x = 0, terminal_y = 0;
		int[][] origin = new int[m][n];
		int[][] input = null;

		for (int i = 0; i < m; i++) {
			String tempinput = in.next();
			int j = 0;
			while (j < n) {
				if (tempinput.charAt(j) == '1') {
					originPosition_x = i;
					originPosition_y = j;
				}
				if (tempinput.charAt(j) == '3') {
					originBox_x = i;
					originBox_y = j;
				}
				if (tempinput.charAt(j) == '2') {
					terminal_x = i;
					terminal_y = j;
				}

				origin[i][j] = tempinput.charAt(j) - '0';
				j++;
			}
		}

		int position_x, position_y;
		int box_x, box_y;

		for (int j = 0; j < s; j++) {
			input = new int[m][n];

			for (int w = 0; w < m; w++) {
				System.arraycopy(origin[w], 0, input[w], 0, n);
			}

			position_x = originPosition_x;
			position_y = originPosition_y;
			box_x = originBox_x;
			box_y = originBox_y;

			int stepCounts = in.nextInt();
			char[] steps = in.next().toCharArray();
			for (int i = 0; i < stepCounts; i++) {
				if (steps[i] == 'u') {
					if (position_x == 0)
						continue;
					if (position_x == 1 && input[position_x - 1][position_y] == 3)
						continue;
					if (input[position_x - 1][position_y] != 3) {
						input[position_x - 1][position_y] = 1;
						input[position_x--][position_y] = 0;
						continue;
					} 
					else {
						if (box_x != terminal_x || box_y != terminal_y) {
							input[box_x - 1][box_y] = 3;
							input[box_x--][box_y] = 0;

							input[position_x - 1][position_y] = 1;
							input[position_x--][position_y] = 0;
						}
						continue;
					}
				}
				if (steps[i] == 'd') {
					if (position_x == m - 1)
						continue;
					if (position_x == m - 2
							&& input[position_x + 1][position_y] == 3)
						continue;
					if (input[position_x + 1][position_y] != 3) {
						input[position_x + 1][position_y] = 1;
						input[position_x++][position_y] = 0;
						continue;
					}
					else {
						if (box_x != terminal_x || box_y != terminal_y) {
							input[box_x + 1][box_y] = 3;
							input[box_x++][box_y] = 0;

							input[position_x + 1][position_y] = 1;
							input[position_x++][position_y] = 0;
						}
						continue;
					}
				}
				if (steps[i] == 'l') {
					if (position_y == 0)
						continue;
					if (position_y == 1
							&& input[position_x][position_y - 1] == 3)
						continue;
					if (input[position_x][position_y - 1] != 3) {
						input[position_x][position_y - 1] = 1;
						input[position_x][position_y--] = 0;
						continue;
					} else {
						if (box_x != terminal_x || box_y != terminal_y) {
							input[box_x][box_y - 1] = 3;
							input[box_x][box_y--] = 0;

							input[position_x][position_y - 1] = 1;
							input[position_x][position_y--] = 0;
						}
						continue;
					}
				}
				if (steps[i] == 'r') {
					if (position_y == n - 1)
						continue;
					if (position_y == n - 2
							&& input[position_x][position_y + 1] == 3)
						continue;
					if (input[position_x][position_y + 1] != 3) {
						input[position_x][position_y + 1] = 1;
						input[position_x][position_y++] = 0;
						continue;
					} else {
						if (box_x != terminal_x || box_y != terminal_y) {
							input[box_x][box_y + 1] = 3;
							input[box_x][box_y++] = 0;

							input[position_x][position_y + 1] = 1;
							input[position_x][position_y++] = 0;
						}
						continue;
					}
				}
			}
			if (box_x == terminal_x && box_y == terminal_y) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}
