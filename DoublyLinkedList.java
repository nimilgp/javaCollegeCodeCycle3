import java.util.*;

public class DoublyLinkedList {
	class Link {
		int intData;
		String strData;
		Link next;
		Link prev;

		Link(int intData,String strData)
		{
			this.intData = intData;
			this.strData = strData;
			this.next = null;
			this.prev = null;
		}
	}

	Link head = null;
	Link tail = null;
	int length = 0;

	void insertLinkAtHead(int intData,String strData){
		Link newLink = new Link(intData,strData);
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

	void insertLinkAtTail(int intData,String strData){
		Link newLink = new Link(intData,strData);
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

	void insertLinkAt(int intData,String strData,int pos){
		if(pos<0 || pos>length){
			System.out.println("#####Cant do that####");
			return;
		}

		if(pos == 0){
			insertLinkAtHead(intData,strData);
			return;
		}

		if(pos == length){
			insertLinkAtTail(intData,strData);
			return;
		}

		Link cur = head;
		int count = 0;
		
		Link newLink = new Link(intData,strData);

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

			System.out.print("<-->" + "(" + cur.intData + "," + cur.strData + ")" );
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

			System.out.print("<-->" + "(" + cur.intData + "," + cur.strData + ")" );
			cur = cur.prev;
		}
		System.out.print("<-->(head)\n");
	}

	void countLinks(){
		System.out.println("Total Links: "
				+ length);
	}

	Link split(Link head){
		Link fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
        	Link temp = slow.next;
        	slow.next = null;
        	return temp;
    	}
 
    	Link mergeSort(Link node,int type){
        	if (node == null || node.next == null) {
            		return node;
        	}
        	Link second = split(node);
 
		node = mergeSort(node,type);
		second = mergeSort(second,type);
	 
		return merge(node, second,type);
    	}

	boolean compareIntData(Link first,Link second){
		if(first.intData < second.intData){
			return true;
		}
		else{
			return false;
		}
	}

	boolean compareStrData(Link first,Link second){
		if(second.strData.compareTo(first.strData)>0){
			return true;
		}
		else{
			return false;
		}
	}

	Link merge(Link first, Link second,int type){
		if (first == null) {
			return second;
		}
	 
		if (second == null) {
		    	return first;
		}
	 
		if ((type == 1)?compareIntData(first,second):compareStrData(first,second)) {
		    	first.next = merge(first.next, second,type);
		    	first.next.prev = first;
		    	first.prev = null;
		    	return first;
		}
		else {
		    	second.next = merge(first, second.next,type);
		    	second.next.prev = second;
		    	second.prev = null;
		    	return second;
		}
	}

	void sort(int type){
		head = mergeSort(head,type);
	}

	public static void main(String[] args){
		DoublyLinkedList DLL = new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);
		int ch,intData,pos;
		String strData;
		
		while(true){
			System.out.print("\n(1)Insert\n(2)Delete\n(3)Display Forward\n(4)Display Backward\n(5)Count\n(6)Sort\n(7)Exit\nchoice: ");
			ch = sc.nextInt();

			if(ch == 1){
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				System.out.print("Enter Integer Data: ");
				intData = sc.nextInt();
				System.out.print("Enter String Data: ");
				strData = sc.next();	
				DLL.insertLinkAt(intData,strData,pos);
			}

			else if(ch == 2){
				System.out.print("Enter position: ");
				pos = sc.nextInt();
				DLL.deleteLinkAt(pos);
			}

			else if(ch == 3){
				DLL.displayLinksForward();
			}

			else if(ch == 4){
				DLL.displayLinksBackward();
			}

			else if(ch == 5){
				DLL.countLinks();
			}

			else if(ch == 6){
				System.out.print("Sort by \n(1)Integer Data\n(2)String Data\nchoice: ");
				ch = sc.nextInt();
				if(ch == 1){
					DLL.sort(1);
				}
				else if(ch == 2){
					DLL.sort(2);
				}
				else{
					System.out.print("----invalid input----");
				}
			}

			else if(ch == 7){
				return;
			}

			else{
				System.out.print("----invalid input----");

			}
		}
	}
}
