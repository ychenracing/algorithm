package companies.mi;

import java.util.Scanner;

/**
 * @xiaomi
 * <pre>input a string, move the token {@code *} to the front of string, other characters to the end.
 * such as {@code ****abc*.....} to {@code *****abc.....}. Note the order of characters back-end.
 * </pre>
 * @author racing
 * @since 03-12-2015
 */
public class StringRestruct {

	public static void main(String[] args) {
		StringRestruct sr = new StringRestruct();
		Scanner scanner = new Scanner(System.in);
		String inputString = null;
		while(!(inputString = scanner.nextLine()).equals("exit")){
			sr.method1(inputString);
//			sr.method2(inputString);
		}
		scanner.close();
	}
	
	/**
	 * <pre>time complexity: {@code O(n)}
	 * space complexity: {@code O(1)}</pre>
	 * 
	 */
	public void method1(String input){
		char[] inputChars = input.toCharArray();
		int end = inputChars.length - 1, start = end - 1;
		while(start >= 0 && end >0){
			while(end > 0 && inputChars[end] != '*')
				end--;
			start = end;
			while (start >= 0) {
				if(inputChars[start] == '*')
					start--;
				else break;
			}
			if(start < 0)break;
			char temp = inputChars[end];
			inputChars[end] = inputChars[start];
			inputChars[start] = temp;
		}
		System.out.println(inputChars);
	}
	
	/**
	 * <pre>time complexity: {@code O(n)}
	 * space complexity: {@code O(n)}</pre>
	 * 
	 */
	public void method2(String input){
		StringBuilder sbstars = new StringBuilder();
		StringBuilder sbchars = new StringBuilder();
		int iter = 0;
		while(iter < input.length()){
			if(input.charAt(iter) == '*')
				sbstars.append(input.charAt(iter));
			else sbchars.append(input.charAt(iter));
			iter++;
		}
		sbstars.append(sbchars);
		System.out.println(sbstars);
	}
}
