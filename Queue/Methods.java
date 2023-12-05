
import java.util.Scanner;

public class Methods {

    public static int array[] = new int[0];

    public static void menu() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("\t QUEUE\t");
        System.out.println("========================");
        System.out.println("1. enqueue");
        System.out.println("2. dequeue");
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
                enqueue(sc.nextInt());
                break;

            case 2:
                dequeue();
                break;

            case 3:
                System.exit(1);
                break;

            default:
                System.out.println("invalid response");
                break;

        }

    }

    public static void display() {
        if (array.length == 0) {
            System.out.print("queue empty");
        } else {
            for (int i : array) {
                if (i != 0)
                    System.out.print(" " + i + " ");
            }
        }
        System.out.println();
    }

    public static void enqueue(int data) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = data;
        array = newArray;
        menu();
    }

    public static void dequeue() {
        if (array.length != 0) {
            int[] newArray = new int[array.length - 1];

            for (int i = 1; i < array.length; i++) {
                newArray[i - 1] = array[i];
            }

            array = newArray;
        }
        menu();
    }

}