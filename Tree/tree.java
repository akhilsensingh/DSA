// package methods;
// package methods;

import java.util.Scanner;

// import Node;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Tree {
    public static Node root = null;
    public static int flag = 0;

    public static void insert(int data) {
        Node element = new Node(data);
        if (root == null)
            root = element;
        else {
            Node current = root, parent = null;
            while (current != null) {
                parent = current;
                if (current.data == data) {
                    System.out.println("cant insert duplicate");
                    return;
                } else if (data < current.data) {
                    current = current.left;
                } else if (data > current.data) {
                    current = current.right;
                }
            }
            if (data > parent.data)
                parent.right = element;
            else if (data < parent.data)
                parent.left = element;
        }
    }

    public static Node delete(Node root, int data) {
        if (root == null)
            return root;
        else if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minimum(root);
            root.right = delete(root.right, data);
        }

        return root;
    }

    public static int minimum(Node root) {
        int min = root.data;
        if (root != null) {
            while (root.left != null) {
                min = root.left.data;
                root = root.left;
            }
        }
        return min;
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + "  ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + "  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "  ");
        }
    }

    public static void search(Node root, int key) {
        if (root.data == key)
            flag = 1;
        if (root.left != null)
            search(root.left, key);
        if (root.right != null)
            search(root.right, key);
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);

        if (left > right)
            return left + 1;
        else
            return right + 1;
    }

    public static int countNode(Node root) {
        if (root == null)
            return 0;
        int left = countNode(root.left);
        int right = countNode(root.right);
        return left + right + 1;
    }

    public static void menu() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("\t Binary Search Tree");
        System.out.println("======================================");
        System.out.println("1. insert");
        System.out.println("2. delete");
        System.out.println("3. search");
        System.out.println("4. height");
        System.out.println("5. nodes");
        System.out.println("6. exit");
        System.out.println("======================================");
        System.out.print("inOrder   : ");
        inOrder(root);
        System.out.println();

        System.out.print("preOrder  : ");
        preOrder(root);
        System.out.println();

        System.out.print("postOrder : ");
        postOrder(root);
        System.out.println();
        System.out.println("======================================");
        System.out.print("enter choice : ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\033[2H\033[2J");
                System.out.print("enter element : ");
                insert(sc.nextInt());
                break;

            case 2:
                System.out.println("\033[2H\033[2J");
                System.out.print("enter element : ");
                delete(root, sc.nextInt());
                break;

            case 3:
                System.out.println("\033[2H\033[2J");
                System.out.print("enter element : ");
                search(root, sc.nextInt());
                if (flag == 1) {
                    System.out.print("found");
                } else
                    System.out.print("not found");
                Thread.sleep(1000);
                break;

            case 4:
                System.out.println("\033[2H\033[2J");
                System.out.print("height : " + height(root));
                Thread.sleep(1000);
                break;

            case 5:
                System.out.println("\033[2H\033[2J");
                System.out.print("nodes : " + countNode(root));
                Thread.sleep(1000);
                break;

            case 6:
                System.exit(1);

            default:
                System.out.println("invalid choice");
                Thread.sleep(1000);
                break;
        }
        System.out.println("\033[2H\033[2J");
        menu();
    }

}
