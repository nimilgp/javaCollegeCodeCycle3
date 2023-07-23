import java.util.*;

class PolynomialSingleyLinkedList {
	class Link {
		int coef;
		int exp;
		Link next;

		Link(int coef,int exp)
		{
			this.coef = coef;
			this.exp = exp;
			this.next = null;
		}
	}

	Link head = null;
	int length = 0;
	
	PolynomialSingleyLinkedList(){
		Scanner sc = new Scanner(System.in);
		int coef = 1;
		int exp = 1;
		int num_terms;
		String expression;
		System.out.print("Enter number of terms in polynomial: ");
		num_terms = sc.nextInt();
		System.out.print("Enter in descending order of powers: \n");
		for(int i=0;i<num_terms;i++){
			System.out.print("Enter power of term " + (i+1)+ ": ");
			exp = sc.nextInt();
			System.out.print("Enter coef of term: ");
			coef = sc.nextInt();
			this.insertLinkAt(coef,exp,length);
		}
	}

	PolynomialSingleyLinkedList(int init){
		;
	}
			
	void insertLinkAt(int coef,int exp,int pos)
	{
		Link newLink = new Link(coef,exp);

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
			if(cur.coef < 0){
				sign = "-";
			}
			else{
				sign = "+";
			}

			System.out.print(sign + ((cur.coef > 0)?cur.coef:-1*cur.coef) + "x^" + cur.exp + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	void polynomialAddition(PolynomialSingleyLinkedList poly1,PolynomialSingleyLinkedList poly2){
		Link cur1 = poly1.head;		
		Link cur2 = poly2.head;

		while(cur1!=null || cur2!=null){
			if(cur1 == null){
				this.insertLinkAt(cur2.coef,cur2.exp,this.length);
				cur2 = cur2.next;
			}
			else if(cur2 == null){
				this.insertLinkAt(cur1.coef,cur1.exp,this.length);
				cur1 = cur1.next;
			}
			else{
				if(cur1.coef == cur2.coef){
					this.insertLinkAt(cur1.coef + cur2.coef,cur1.exp,this.length);
					cur1 = cur1.next;
					cur2 = cur2.next;
				}
				else if(cur1.coef > cur2.coef){
					this.insertLinkAt(cur1.coef,cur1.exp,this.length);
					cur1 = cur1.next;
				}
				else if(cur1.coef < cur2.coef){
					this.insertLinkAt(cur2.coef,cur2.exp,this.length);
					cur2 = cur2.next;
				}
			}
		}
	}

	public static void main(String[] args){
		System.out.print("\nPolynomial One:\n");
		PolynomialSingleyLinkedList polyOne = new PolynomialSingleyLinkedList();
		polyOne.displayPolynomial();

		System.out.print("\nPolynomial Two:\n");
		PolynomialSingleyLinkedList polyTwo = new PolynomialSingleyLinkedList();
		polyTwo.displayPolynomial();
		
		System.out.print("\nPolynomial Summation:\n");
		PolynomialSingleyLinkedList polyAns = new PolynomialSingleyLinkedList(0);
		polyAns.polynomialAddition(polyOne,polyTwo);
		polyAns.displayPolynomial();
	}
}
