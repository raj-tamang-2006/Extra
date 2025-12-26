import java.util.*;

class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addItem(new Book(1, "Java", "James"));
        library.addItem(new Magazine(2, "Tech Today", 45));
        library.addItem(new DVD(3, "Inception", 148));

        library.borrowItem(3);
        library.returnItem(3);

        library.searchByTitle("Java");
        library.displayAllItems();
    }
}
abstract class LibraryItem {
    private int itemId;
    private String title;
    private boolean isAvailable = true;

    LibraryItem(int i, String t) {
        this.itemId = i;
        this.title = t;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    void borrowItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " borrowed successfully");
        } else {
            System.out.println(title + " is already borrowed");
        }
    }

    void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " returned successfully");
        } else {
            System.out.println(title + " was not borrowed");
        }
    }

    void displayInfo() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Available: " + isAvailable);
    }

    abstract double calculateFine(int days);
}

class Book extends LibraryItem {
    private String author;

    Book(int id, String t, String au) {
        super(id, t);
        this.author = au;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + author);
    }

    @Override
    double calculateFine(int days) {
        return days * 0.20;
    }
}

class Magazine extends LibraryItem {
    private int issueNumber;

    Magazine(int id, String t, int i) {
        super(id, t);
        this.issueNumber = i;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Issue Number: " + issueNumber);
    }

    @Override
    double calculateFine(int days) {
        return days * 0.10;
    }
}

class DVD extends LibraryItem {
    private int duration;

    DVD(int id, String t, int d) {
        super(id, t);
        this.duration = d;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Duration: " + duration + " minutes");
    }

    @Override
    double calculateFine(int days) {
        return days * 0.50;
    }
}

interface Searchable {
    void searchByTitle(String title);
}

class Library implements Searchable {
    private ArrayList<LibraryItem> items = new ArrayList<>();

    void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("Item added successfully");
    }

    void borrowItem(int id) {
        for (LibraryItem item : items) {
            if (item.getItemId() == id) {
                item.borrowItem();
                return;
            }
        }
        System.out.println("Item not found");
    }

    void returnItem(int id) {
        for (LibraryItem item : items) {
            if (item.getItemId() == id) {
                item.returnItem();
                return;
            }
        }
        System.out.println("Item not found");
    }

    @Override
    public void searchByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                item.displayInfo();
                return;
            }
        }
        System.out.println("Item not found");
    }

    void displayAllItems() {
        for (LibraryItem item : items) {
            item.displayInfo();
            System.out.println("-----------");
        }
    }
}

/*

Ouptut


Welcome to KL Library
---------------------
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 1
ID: 1
Title: To Kill a Mockingbird
Available: true
Author: Harper Lee
-----------
ID: 2
Title: 1984
Available: true
Author: George Orwell
-----------
ID: 3
Title: Pride and Prejudice
Available: true
Author: Jane Austen
-----------
ID: 4
Title: The Great Gatsby
Available: true
Author: F. Scott Fitzgerald
-----------
ID: 5
Title: Moby-Dick
Available: true
Author: Herman Melville
-----------
ID: 6
Title: The Catcher in the Rye
Available: true
Author: J.D. Salinger
-----------
ID: 7
Title: The Hobbit
Available: true
Author: J.R.R. Tolkien
-----------
ID: 8
Title: Fahrenheit 451
Available: true
Author: Ray Bradbury
-----------
ID: 9
Title: Brave New World
Available: true
Author: Aldous Huxley
-----------
ID: 10
Title: The Lord of the Rings
Available: true
Author: J.R.R. Tolkien
-----------
ID: 11
Title: National Geographic
Available: true
Issue Number: 101
-----------
ID: 12
Title: Forbes
Available: true
Issue Number: 202
-----------
ID: 13
Title: The Economist
Available: true
Issue Number: 303
-----------
ID: 14
Title: Scientific American
Available: true
Issue Number: 404
-----------
ID: 15
Title: Popular Science
Available: true
Issue Number: 505
-----------
ID: 16
Title: Wired
Available: true
Issue Number: 606
-----------
ID: 17
Title: Reader's Digest
Available: true
Issue Number: 707
-----------
ID: 18
Title: New Scientist
Available: true
Issue Number: 808
-----------
ID: 19
Title: Rolling Stone
Available: true
Issue Number: 909
-----------
ID: 20
Title: Sports Illustrated
Available: true
Issue Number: 1001
-----------
ID: 21
Title: Avatar
Available: true
Duration: 162 minutes
-----------
ID: 22
Title: The Avengers
Available: true
Duration: 143 minutes
-----------
ID: 23
Title: Star Wars: A New Hope
Available: true
Duration: 121 minutes
-----------
ID: 24
Title: The Lion King
Available: true
Duration: 88 minutes
-----------
ID: 25
Title: Back to the Future
Available: true
Duration: 116 minutes
-----------
ID: 26
Title: Jurassic World
Available: true
Duration: 124 minutes
-----------
ID: 27
Title: Spider-Man: No Way Home
Available: true
Duration: 148 minutes
-----------
ID: 28
Title: Harry Potter and the Sorcerer's Stone
Available: true
Duration: 152 minutes
-----------
ID: 29
Title: Pirates of the Caribbean
Available: true
Duration: 143 minutes
-----------
ID: 30
Title: Toy Story
Available: true
Duration: 81 minutes
-----------
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 2
Enter title to search: Java
Item not found
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 2
Enter title to search: Avatar
ID: 21
Title: Avatar
Available: true
Duration: 162 minutes
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 3
Enter item ID to borrow: 21
Avatar borrowed successfully
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 2
Enter title to search: Avatar
ID: 21
Title: Avatar
Available: false
Duration: 162 minutes
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 4
Enter item ID to return: 21
Avatar returned successfully
----------------
How may I help you?
1. List all the items we have.
2. Search for something
3. Borrow something
4. Return something
5. Exit
Choose(1-5): 5
Thank you for using KL Library!

*/