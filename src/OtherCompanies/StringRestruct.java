package OtherCompanies;

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
		Scanner scanner = new Scanner(System.in);
		char[] inputString = null;
		while(!(inputString = scanner.nextLine().trim().toCharArray()).equals("exit")){
			int end = inputString.length - 1, start = end - 1;
			while(start >= 0 && end >0){
				while(end > 0 && inputString[end] != '*')
					end--;
				start = end;
				while (start >= 0) {
					if(inputString[start] == '*')
						start--;
					else break;
				}
				if(start < 0)break;
				char temp = inputString[end];
				inputString[end] = inputString[start];
				inputString[start] = temp;
			}
			System.out.println(inputString);
		}
		scanner.close();
		
		
	}

}
