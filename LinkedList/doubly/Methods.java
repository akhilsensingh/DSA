
import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

public class Methods {

    public static Node head = null;
    public static int size = 0;

    public static void menu() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        System.out.println("\tDoublyLinkedList ");
        System.out.println("--------------------------------------");
        System.out.println("1. insert at beginning");
        System.out.println("2. insert at end");
        System.out.println("3. delete at beginning");
        System.out.println("4. delete at end");
        System.out.println("5. insert at index");
        System.out.println("6. delete at index");
        System.out.println("7. exit");
        System.out.println("======================================");
        display();
        System.out.println("======================================");
        System.out.print("enter choice : ");
        int choice = sc.nextInt();
        System.out.println("\033[H\033[2J");

        switch (choice) {
            case 1:
                System.out.print("enter element : ");
                insertAtBeginning(sc.nextInt());
                break;

            case 2:
                System.out.print("enter element : ");
                insertAtEnd(sc.nextInt());
                break;

            case 3:
                deleteAtBeginning();
                break;

            case 4:
                deleteAtEnd();
                break;

            case 5:
                System.out.print("enter index : ");
                int index = sc.nextInt();
                System.out.print("enter element : ");
                int data = sc.nextInt();
                insertAtIndex(index, data);
                break;

            case 6:
                System.out.print("enter index : ");
                int i = sc.nextInt();
                deleteAtIndex(i);
                break;

            case 7:
                System.exit(1);
                break;

            default:
                break;

        }
        sc.close();
    }

    public static void display() {
        if (size == 0)
            System.out.print("empty");
        else {

            Node cur = head;
            System.out.print("forward : ");
            for (int i = 0; i < size; i++) {
                System.out.print("| " + cur.data + " |");
                if (i < size - 1)
                    System.out.print(" => ");
                cur = cur.next;
            }
            cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            System.out.println();
            System.out.print("reverse : ");
            for (int i = 0; i < size; i++) {
                System.out.print("| " + cur.data + " |");
                if (i < size - 1)
                    System.out.print(" => ");
                cur = cur.prev;
            }
        }
        System.out.println();
    }

    public static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (size == 0)
            head = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        menu();
    }

    public static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (size == 0)
            head = newNode;
        else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
            newNode.prev = cur;
        }
        size++;
        menu();
    }

    public static void deleteAtBeginning() {
        if (size > 0) {
            head = head.next;
            size--;
        }
        menu();
    }

    public static void deleteAtEnd() {
        if (size > 0) {
            Node cur = head;
            for (int i = 0; i < size - 2; i++) {
                cur = cur.next;
            }
            cur.next = null;
            size--;
        }
        menu();
    }

    public static void insertAtIndex(int index, int data) {
        if (index == 0)
            insertAtBeginning(data);
        else if (index <= size) {
            Node newNode = new Node(data);
            Node cur = head;
            if (index <= size) {
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                newNode.prev = cur;
                newNode.next = cur.next;
                cur.next = newNode;
                size++;
            }
        }
        menu();
    }

    public static void deleteAtIndex(int index) {
        if (index == 0)
            deleteAtBeginning();
        else if (index <= size) {
            Node cur = head;
            if (index <= size) {
                for (int i = 0; i < index - 1; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
                cur.next.prev = cur;
                size--;
            }
        }
        menu();
    }
}