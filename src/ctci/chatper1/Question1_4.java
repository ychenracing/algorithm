package ctci.chatper1;

import java.util.Scanner;

/**
 * <pre>replace space Characters in a string with {@code %20}.
 * for example:
 * input: "Mr John Smith "
 * output:"Mr%20John%20Smith"</pre>
 * @author racing
 * @since 03-16-2015
 */
public class Question1_4 {

	private static final int MAX_LENGTH = 100;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = null;
		char[] chars = new char[MAX_LENGTH];
		while(!(inputString = scanner.nextLine()).equals("exit")){
			for(int i = 0;i < inputString.length();i++){
				chars[i] = inputString.charAt(i);
			}
			solution(chars, inputString.length());
		}
		scanner.close();
	}
	
	/**
	 * <pre>time complexity: {@code O(n)}
	 * </pre>
	 * @param chars
	 * @param stringLength
	 */
	public static void solution(char[] chars, int stringLength){
		int spaceCount = 0;
		int trueLength = 0;
		int sumLength = 0;
		for(int i = stringLength - 1;i >= 0;i--)
			if(chars[i] != ' '){
				trueLength = i + 1;
				break;
			}
		for(int i = trueLength - 1; i >= 0 ; i--){
			if(chars[i] == ' ')
				spaceCount++;
		}
		sumLength = trueLength + spaceCount * 2;
		for(int i = trueLength - 1, j = sumLength - 1;i >= 0 && j >= 0;i--){
			if(chars[i] == ' '){
				chars[j--] = '0';
				chars[j--] = '2';
				chars[j--] = '%';
			}
			else{
				chars[j] = chars[i];
				j--;
			}
		}
		chars[sumLength] = '\0';
		System.out.println(chars);
	}

}
