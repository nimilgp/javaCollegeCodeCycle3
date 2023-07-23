import java.util.*;

public class DoublyLinkedList {
	class Link {
		int data;
		Link next;
		Link prev;

		Link(int data)
		{
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Link head = null;
	Link tail = null;
	int length = 0;

	void insertLinkAtHead(int data){
		Link newLink = new Link(data);
		if (head == null){
			head = newLink;
			tail = newLink;
		}

		else{
			newLink.next = head;
			head.prev = newLink;
			head = newLink;
		}
		length++;
	}

	void insertLinkAtTail(int data){
		Link newLink = new Link(data);
		if (tail == null){
			head = newLink;
			tail = newLink;
		}

		else{
			tail.next = newLink;
			newLink.prev = tail;
			tail = newLink;
		}
		length++;
	}

	void insertLinkAt(int data,int pos){
		if(pos<0 || pos>length){
			System.out.println("#####Cant do that####");
			return;
		}

		if(pos == 0){
			insertLinkAtHead(data);
			return;
		}

		if(pos == length){
			insertLinkAtTail(data);
			return;
		}

		Link cur = head;
		int count = 0;
		
		Link newLink = new Link(data);

		while(cur!=null){
			if(count == pos -1){
				newLink.next = cur.next;
				cur.next.prev = newLink;
				newLink.prev = cur;
				cur.next = newLink;
				length++;
				return;
			}
			cur = cur.next;
			count++;
		}
	}
	
	void deleteLinkAtHead(int pos){
		if(head == tail){
			head = null;
			tail = null;
		}

		else{
			Link newLink = head;
			head = head.next;
			head.prev = null;
			newLink.next = null;
		}
		length--;
	}

	void deleteLinkAtTail(int pos){
		if(head == tail){
			head = null;
			tail = null;
		}

		else{
			Link newLink = tail;
			tail = tail.prev;
			tail.next = null;
			newLink.prev = null;
		}
		length--;
	}

	void deleteLinkAt(int pos){
		if(pos<0 || pos>length-1){
			System.out.println("#####Cant do that####");
			return;
		}

		Link cur = head;
		int count = 0;

		if(pos == 0){
			deleteLinkAtHead(pos);
			return;
		}

		if(pos == length - 1){
			deleteLinkAtTail(pos);
			return;
		}

		while(cur!=null){
			if(count == pos - 1){
				cur.prev.next = cur.next;
				cur.next.prev = cur.prev;
				cur.prev = null;
				cur.next = null;
				length--;
				return;
			}
			cur = cur.next;
			count++;
		}
	}

	void displayLinksForward(){

		Link cur = head;
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		System.out.print("(head)");
		while (cur != null) {

			System.out.print("<-->" + cur.data );
			cur = cur.next;
		}
		System.out.print("<-->(tail)\n");
	}

	void displayLinksBackward(){

		Link cur = tail;
		if (head == null) {
			System.out.println("Empty");
			return;
		}
		System.out.print("(tail)");
		while (cur != null) {

			System.out.print("<-->" + cur.data );
			cur = cur.prev;
		}
		System.out.print("<-->(head)\n");
	}

	void countLinks(){
		System.out.println("Total Links: "
				+ length);
	}

	public static void main(String[] args){
		DoublyLinkedList DLL = new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);
		int ch,data,pos;
		
		while(true){
			System.out.print("\n(1)Insert\n(2)Delete\n(3)Display Forward\n(4)Display Backward\n(5)Count\n(6)Sort\n(7)Exit\nchoice: ");
			ch = sc.nextInt();

			if(ch == 1){
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				System.out.print("Enter data: ");
				data = sc.nextInt();
				DLL.insertLinkAt(data,pos);
			}

			if(ch == 2){
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				DLL.deleteLinkAt(pos);
			}

			if(ch == 3){
				DLL.displayLinksForward();
			}

			if(ch == 4){
				DLL.displayLinksBackward();
			}

			if(ch == 5){
				DLL.countLinks();
			}

			if(ch == 7){
				return;
			}
		}
	}
}
