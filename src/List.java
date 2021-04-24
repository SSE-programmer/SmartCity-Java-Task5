class Node {
    public Node next;
    public int data;

    Node() {}

    Node(int data) {
        this.data = data;
    }
}
public class List {
    private Node head;

    public void addStart(int data)
    {
        Node a = new Node();
        a.data = data;

        if (head != null)
        {
            a.next = head;
        }

        head = a;
    }

    public void addFinish(int data)
    {
        Node a = new Node();
        a.data = data;

        if (head == null)
        {
            head = a;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = a;
        }
    }

    public void printList()
    {
        Node p = head;
        while (p != null)
        {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.print("null\n");
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        Node p = head;

        while (p != null) {
            string.append(p.data);
            p = p.next;
        }

        return string.reverse().toString();
    }
}
