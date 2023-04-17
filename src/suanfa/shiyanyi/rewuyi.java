package suanfa.shiyanyi;

public class rewuyi {
    public static void create(Node head, int[] arr) {
        Node temp = head;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new Node(arr[i],null);
            temp = temp.next;
        }
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static Node reverseList(Node head) {
        if(head==null || head.next==null) {
            return head;
        }
        Node cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        Node head = new Node(0,null);
        int[] arr = new int[]{1,2,3,4,5};
        create(head,arr);
        System.out.println("反转前：");
        print(head.next);
        Node node = reverseList(head.next);
        System.out.println();
        System.out.println("反转后：");
        print(node);
    }

}

class Node {
    int val;
    Node next;
    Node() {}
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}




