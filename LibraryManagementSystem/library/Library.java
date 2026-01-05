package library;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Book\n2.View Books\n3.Issue Book\n4.Return Book\n5.Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        books.add(new Book(id, name));
        System.out.println("Book Added");
    }

    static void viewBooks() {
        for (Book b : books)
            System.out.println(b.id + " " + b.name + " Issued:" + b.issued);
    }

    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book b : books)
            if (b.id == id && !b.issued) {
                b.issued = true;
                System.out.println("Book Issued");
                return;
            }
        System.out.println("Not Available");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        for (Book b : books)
            if (b.id == id && b.issued) {
                b.issued = false;
                System.out.println("Book Returned");
                return;
            }
        System.out.println("Invalid ID");
    }
}
