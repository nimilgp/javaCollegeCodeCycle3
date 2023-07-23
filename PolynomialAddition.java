import java.util.*;

class PolynomialSingleyLinkedList {
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
	
	PolynomialSingleyLinkedList(){
		Scanner sc = new Scanner(System.in);
		int coefficient = 1;
		int exponent = 1;
		int num_terms;
		String expression;
		System.out.print("Enter number of terms in polynomial: ");
		num_terms = sc.nextInt();
		System.out.print("Enter in descending order of powers: \n");
		for(int i=0;i<num_terms;i++){
			System.out.print("Enter power of term " + (i+1)+ ": ");
			exponent = sc.nextInt();
			System.out.print("Enter coefficient of term: ");
			coefficient = sc.nextInt();
			this.insertLinkAt(coefficient,exponent,length);
		}
	}
			
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
		String sign;
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		
		System.out.print("Polynomial: ");
		while (cur != null) {
			if(cur.coefficient < 0){
				sign = "-";
			}
			else{
				sign = "+";
			}

			System.out.print(sign + ((cur.coefficient > 0)?cur.coefficient:-1*cur.coefficient) + "x^" + cur.exponent);
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{

		PolynomialSingleyLinkedList polyOne = new PolynomialSingleyLinkedList();
		//PolynomialSingleyLinkedList polyTwo = new PolynomialSingleyLinkedList();
		//PolynomialSingleyLinkedList polyAns = new PolynomialSingleyLinkedList();

		Scanner sc = new Scanner(System.in);

		polyOne.displayPolynomial();

	}
}
