
import java.util.Scanner;

public class Methods {

    public static int array[] = new int[0];

    public static void menu() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("\t ARRAY\t");
        System.out.println("========================");
        System.out.println("1. insert at beginning");
        System.out.println("2. insert at end");
        System.out.println("3. delete at beginning");
        System.out.println("4. delete at end");
        System.out.println("5. insert at index");
        System.out.println("6. delete at index");
        System.out.println("7. exit");
        System.out.println("========================");
        display();
        System.out.println("========================");
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

    }

    public static void display() {
        if (array.length == 0)
            System.out.print("array empty");
        else {
            for (int i : array) {
                if (i != 0)
                    System.out.print(" " + i + "  ");
            }
            System.out.println();
            for (int i = 0; i < array.length; i++) {
                System.out.print("[" + i + "] ");
            }
        }
        System.out.println();
    }

    public static void insertAtBeginning(int data) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = data;

        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        array = newArray;
        menu();
    }

    public static void insertAtEnd(int data) {
        int[] newArray = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        newArray[array.length] = data;
        array = newArray;
        menu();
    }

    public static void deleteAtBeginning() {
        if (array.length != 0) {

            int[] newArray = new int[array.length - 1];

            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = array[i + 1];
            }

            array = newArray;
        }
        menu();
    }

    public static void deleteAtEnd() {
        if (array.length != 0) {

            int[] newArray = new int[array.length - 1];

            for (int i = 0; i < array.length - 1; i++) {
                newArray[i] = array[i];
            }

            array = newArray;
        }
        menu();
    }

    public static void insertAtIndex(int index, int data) {
        if (index <= array.length) {

            int[] newArray = new int[array.length + 1];

            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }

            newArray[index] = data;

            for (int i = index; i < array.length; i++) {
                newArray[i + 1] = array[i];
            }

            array = newArray;
        }
        menu();
    }

    public static void deleteAtIndex(int i) {
        if (i < array.length) {

            int[] newArray = new int[array.length - 1];

            for (int j = 0; j < i; j++) {
                newArray[j] = array[j];
            }

            for (int j = i; j < newArray.length; j++) {
                newArray[i] = array[i + 1];
            }

            array = newArray;
        }
        menu();
    }
}
