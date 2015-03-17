package ctci.chatper2;

import java.util.Scanner;

/**
 * <pre>Compute sum of two linkedlists. A linkedlist represents a number. Nodes in it represent a digit of the number.
 * Digits are in an inverted order. for example, the linkedlist of number "2949" is "9 -> 4 -> 9 -> 2".
 * input two linkedlists, output the sum of them.</pre>
 * 
 * @author racing
 * @since 03-17-2015
 *
 */
public class Question2_5 {
	
	/**
	 * Node of linkedlist
	 * @author racing
	 *
	 */
	static class Node{
		private int num = 0;
		Node next = null;
		Node(){}
		Node(int num){
			this.num = num;
		}
		public void setNum(int num){
			this.num = num;
		}
		public void setNext(Node next){
			this.next = next;
		}
		public String toString(){
			return String.valueOf(this.num);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("input first linklist:");
		String firstLinkList = scanner.nextLine();
		System.out.print("input second linklist:");
		String secondLinkList = scanner.nextLine();
		Node first = new Node(firstLinkList.charAt(0) - '0');
		Node second = new Node(secondLinkList.charAt(0) - '0');
		Node currentFirst = first;
		Node currentSecond = second;
		for(int i = 1;i < firstLinkList.length(); i++){
			Node next = new Node(firstLinkList.charAt(i) - '0');
			currentFirst.setNext(next);
			currentFirst = currentFirst.next;
		}
		for(int i = 1;i < secondLinkList.length(); i++){
			Node next = new Node(secondLinkList.charAt(i) - '0');
			currentSecond.setNext(next);
			currentSecond = currentSecond.next;
		}
		compute(first, second);
		scanner.close();
	}
	
	public static void compute(Node first, Node second){
		Node currentFirst = first;
		Node currentSecond = second;
		int flag = 0;
		int remnant = 0, quotient = 0;
		Node previousFirst = null;
		Node previousSecond = null;
		
		for(;currentFirst != null && currentSecond != null;currentFirst = currentFirst.next,currentSecond = currentSecond.next){
			remnant = (currentFirst.num + currentSecond.num + quotient) % 10;
			quotient = (currentFirst.num + currentSecond.num + quotient) / 10;
			currentFirst.setNum(remnant);
			previousFirst = currentFirst;
			previousSecond = currentSecond;
		}
		if(currentFirst == null && currentSecond != null){ //the first linkedlist is longer
			flag = 2;
			while(true){
				if(currentSecond == null && quotient != 0){
					Node newNode = new Node(quotient);
					previousSecond.next = newNode;
					break;
				}
				if(currentSecond == null && quotient == 0)
					break;
				remnant = (quotient + currentSecond.num) % 10;
				quotient = (quotient + currentSecond.num) / 10;
				currentSecond.setNum(remnant);
				if(currentSecond != null){
					previousSecond = currentSecond;
					currentSecond = currentSecond.next;
				}
			}
		}
		else if(currentSecond == null && currentFirst != null){ //the first linkedlist is longer
			flag = 1;
			while(true){
				if(currentFirst == null && quotient != 0){
					Node newNode = new Node(quotient);
					previousFirst.next = newNode;
					break;
				}
				else if(currentFirst == null && quotient == 0)
					break;
				remnant = (quotient + currentFirst.num) % 10;
				quotient = (quotient + currentFirst.num) / 10;
				currentFirst.setNum(remnant);
				if(currentFirst != null){
					previousFirst = currentFirst;
					currentFirst = currentFirst.next;
				}
			}
		}
		else {										//two linkedlists share the same length
			flag = 0;
			if(quotient != 0){
				Node newNode = new Node(quotient);
				previousFirst.next = newNode;
			}
		}
		if(flag == 2){
			currentFirst = first;
			currentSecond = second;
			while(currentFirst != null){
				System.out.print(currentFirst.num);
				currentFirst = currentFirst.next;
				currentSecond = currentSecond.next;
			}
			while(currentSecond !=null){
				System.out.print(currentSecond.num);
				currentSecond = currentSecond.next;
			}
		}
		else {
			currentFirst = first;
			while(currentFirst !=null){
				System.out.print(currentFirst.num);
				currentFirst = currentFirst.next;
			}
		}
		
	}

	
}
