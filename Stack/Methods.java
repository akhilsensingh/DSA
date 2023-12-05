
import java.util.Scanner;

public class Methods {

    public static int array[] = new int[0];

    public static void menu() {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        System.out.println("========================");
        System.out.println("\t STACK\t");
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
                System.out.println("invalid response");
                break;

        }

    }

    public static void display() {
        if (array.length == 0) {
            System.out.print("stack empty");
            System.out.println();
        } else {
            for (int i : array) {
                if (i != 0)
                    System.out.println(" || " + i + " || ");
            }
        }
    }

    public static void push(int data) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = data;

        for (int i = 1; i < newArray.length; i++) {
            newArray[i] = array[i - 1];
        }
        array = newArray;
        menu();
    }

    public static void pop() {
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