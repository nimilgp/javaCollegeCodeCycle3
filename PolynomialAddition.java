import java.util.*;

public class PolynomialSingleyLinkedList {
	class Link {
		int coefficient;
		int exponent;
		Link next;

		Link(int coefficient,int exponent)
		{
			this.coefficient = coefficient;
			this.exponent = exponent;
			this.next = null;
		}
	}

	Link head = null;
	int length = 0;

	void insertLinkAt(int coefficient,int exponent,int pos)
	{
		Link newLink = new Link(coefficient,exponent);

		if(pos<0 || pos>length){
			System.out.println("#####Cant do that####");
			return;
		}

		Link cur = head;
		int count = 0;

		if(pos == 0){
			newLink.next = head;
			head = newLink;
			length++;
			return;
		}

		while(cur!=null){
			if(count == pos -1){
				newLink.next = cur.next;
				cur.next = newLink;
				length++;
				return;
			}
			cur = cur.next;
			count++;
		}
	}

	void deleteLinkAt(int pos)
	{
		if(pos<0 || pos>length-1){
			System.out.println("#####Cant do that####");
			return;
		}

		Link cur = head;
		int count = 0;

		if(pos == 0){
			head = cur.next;
			length--;
			return;
		}

		while(cur!=null){
			if(count == pos -1){
				cur.next = cur.next.next;
				length--;
				return;
			}
			cur = cur.next;
			count++;
		}
	}

	void displayPolynomial()
	{

		Link cur = head;
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		while (cur != null) {

			System.out.print(cur.coefficient + "x^" + cur.exponent);
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{

		PolynomialSingleyLinkedList polyOne = new PolynomialSingleyLinkedList();
		PolynomialSingleyLinkedList polyTwo = new PolynomialSingleyLinkedList();
		PolynomialSingleyLinkedList polyAns = new PolynomialSingleyLinkedList();

		Scanner sc = new Scanner(System.in);

	}
}
