import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    }
}

abstract class LibraryItem{
    private int itemId;
    private String title;
    private boolean isAvailable = true;
    
    LibraryItems(int i, String t){
        this.itemId = i;
        this.title = t;
    }
    
    void borrowItem(){
        if(this.isAvailable){
            isAvailable = false;
        }
        
        isAvailable = true;
    }
    
    void returnItem(){
        if(!isAvailable){
            isAvailable = true;
            System.out.println(title+" was returned successfully");
        }
        else{
            System.out.println(title+ " was never borrowed");
        }
    }
    
    void displayInfo(){
        System.out.println("Id: "+ itemId);
        System.out.println("Title : "+title);
        System.out.println("is Available: "+ isAvailable);
    }
    abstract int CalculateFine(int days);
}

class Book extends LibraryItem{
    String author;
    double fine = 0.20;
    Book(String id, String t, String au){
        super(id,t);
        this.author = au;
    }
    
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Author: "+ author);
    }
    
    @Override
    int CalculateFine(int days){
        return fine*days;
    }
}

class Magazine extends LibraryItem{
    double fine = 0.10;
    int issueNumber;
    Book(String id, String t, int i){
        super(id,t);
        this.issueNumber = i;
    }
    
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Issue Number: "+ issueNumber);
    }
    
    @Override
    int CalculateFine(int days){
        return fine*days;
    }
}

class DVD extends LibraryItem{
    double fine = 0.50;
    int duration;
    Book(String id, String t, int d){
        super(id,t,a);
        this.duration = d;
    }
    
    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Issue Number: "+ issueNumber);
    }
    
    @Override
    int CalculateFine(int days){
        return fine*days;
    }
}

interface Searchable{
    String title;
    boolean seachByTitle(String title);
}

class Library implements Searchable{
    
}