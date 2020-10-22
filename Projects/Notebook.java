import java.util.Scanner;
import java.util.Arrays;

public class Notebook {
    public static void main(String[] args) {

        System.out.println("Hello! Welcome to NOTEBOOK, a program where you can add notes and manage inputted data");
        System.out.println("Enter 'help' to see more functions");
        Scanner sc = new Scanner(System.in);
        int n = 15;
       //TODO adding to notes[j] that got deleted
       // int j = 0;
       // int[] deletedElements = new int[n];
        String[] notes = new String[n];

        for (int i = 0; i < n ; i++) {
            notes[i] = "";
        }

        int counter = 0;

        while (true) {
            System.out.println("\nPlease enter command");
            String command = sc.nextLine();
            
            switch (command) {
                case "add":
                    if (counter == n) {
                            System.out.println("notes are full, you can't add anything");
                    } 
                    else {
                            counter = add(counter, notes, sc);
                    }
                    break;

                case "remove":
                    remove(sc, notes, counter, n);
                    break;

                case "findElement":
                    findElement(sc, notes);
                    break;

                case "findTheLongest":
                    findTheLongest(notes);
                    break;

                case "help":
                    System.out.println("command list: add <string> , remove <index> , findElement <string> , exit , help , findTheLongest, printArr");
                    break;

                case "printArr":
                    System.out.println(Arrays.toString(notes));
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unknown command! Try again");
            }
        }
    }

    public static int add(int counter, String[] notes, Scanner sc) {
        System.out.println("please, enter an element that you want to add to notes");
        notes[counter] = sc.nextLine();
        counter += 1;
        return counter;
    }

    public static void remove(Scanner sc, String[] notes, int counter, int n) {
        System.out.println("enter an index of element that you want to delete");
        int index = -1;
        boolean flag = true;

        try {
            index = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("please, input a number, try again");
            flag = false;
        }

        if ( (flag) && (index < 0) ) {
            System.out.println("the index of the element that you want to delete must be a positive number, try again");
        } 
        else if (flag) {
            if (index >= n) {
                System.out.println("no existing elements under such index");
            } else {
                if (index >= counter) {
                    System.out.println("the element notes[" + index + "] is already empty");
                } else {
                    notes[index] = "";
                }
            }
        }
    }

    public static void findElement(Scanner sc, String[] notes) {
        System.out.println("enter the element that you want to find");
        String elem = sc.nextLine();
        Boolean flag = false;
        for (int i = 0; i < notes.length && !flag ; i++) {
            if (elem.equals(notes[i])) {
                System.out.printf("your element '%s' is in notes on the %d index\n", elem, i);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("element isn't in notes");
        }
    }

    public static void findTheLongest(String[] notes) {
        int len = 0;
        int maxind = -1;
        for (int i = 0; i < notes.length ; i++) {
            if ((notes[i] != "") && (notes[i].length() > len) ) {
                len = notes[i].length();
                maxind = i;
            }
        }
        if (maxind > -1) {
            System.out.println("the max length = " + len + " , the element = " + notes[maxind]);
        }
        else {
            System.out.println("notes are empty, impossible to find the longest element");
        }
    }
}
