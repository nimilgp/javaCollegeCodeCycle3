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

    void addLinkAt(int data,int pos)
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
 
        SingleyLinkedList L1 = new SingleyLinkedList();
 
        L1.addLinkAt(1,0);
        L1.addLinkAt(2,1);
        L1.addLinkAt(3,2);
        L1.addLinkAt(4,1);
 
        L1.displayLinks();
 
	L1.countLinks();

	L1.deleteLinkAt(3);
        L1.displayLinks();
	L1.deleteLinkAt(1);
        L1.displayLinks();
	L1.deleteLinkAt(0);
        L1.displayLinks();

	L1.countLinks();



    }
}
