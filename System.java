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
