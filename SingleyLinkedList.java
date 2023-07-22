import java.util.*;

public class SingleyLinkedList {
    class Link {
        int data;
        Link next;
 
        Link(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
 
    Link head = null;
    int length = 0;

    void insertLinkAt(int data,int pos)
    {
        Link newLink = new Link(data);

	if(pos<0 || pos>length){
		System.out.println("#####Cant do that####");
		return;
	}

	Link cur = head;
	int count = 0;
	
	if(length == 0){
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

    void displayLinks()
    {
 
        Link cur = head;
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        while (cur != null) {
 
            System.out.print("-->" + cur.data );
            cur = cur.next;
        }
        System.out.println();
    }
 
    void countLinks()
    {
        System.out.println("Total Links: "
                           + length);
    }
 
    public static void main(String[] args)
    {
 
        SingleyLinkedList SLL = new SingleyLinkedList();
 	Scanner sc = new Scanner(System.in);
	int ch,data,pos;

	while(true){
		System.out.print("\n(1)Insert\n(2)Delete\n(3)Display\n(4)Count\n(5)Exit\nchoice: ");
		ch = sc.nextInt();

		if(ch == 1){
			System.out.print("Enter position: ");
			pos = sc.nextInt();
			System.out.print("Enter data: ");
			data = sc.nextInt();
			SLL.insertLinkAt(data,pos);
		}

		if(ch == 2){
			System.out.print("Enter position: ");
			pos = sc.nextInt();
			SLL.deleteLinkAt(pos);
		}
		
		if(ch == 3){
			SLL.displayLinks();
		}
		
		if(ch == 4){
			SLL.countLinks();
		}

		if(ch == 5){
			return;
		}
	}

    }
}
