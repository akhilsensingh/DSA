package methods;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class LinkedMethods {

    public static Node head = null;
    public static int size = 0;

    public static void push(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            newNode.next = head;
            head = newNode;
        }
        size++;

    }

    public static void pop() {
        if (size == 0) {
            System.out.println("stack empty");
        } else {
            head = head.next;
            size--;
        }
    }

    public static void display() {
        if (size == 0) {
            System.out.println("stack empty");
        } else {

            Node cur = head;
            for (int i = size; i > 0; i--) {
                System.out.println("| " + cur.data + " |");
                cur = cur.next;
            }
        }
    }

    public static void menu() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("    LinkedList-Stack");
        System.out.println("========================");
        System.out.println("1. push");
        System.out.println("2. pop");
        System.out.println("3. exit");
        System.out.println("========================");
        display();
        System.out.println("========================");
        System.out.print("enter choice : ");
        int choice = sc.nextInt();
        System.out.println("\033[H\033[2J");

        switch (choice) {
            case 1:
                System.out.print("enter element : ");
                push(sc.nextInt());
                break;

            case 2:
                pop();
                break;

            case 3:
                System.exit(1);
                break;

            default:
                break;

        }

        menu();

    }
}
