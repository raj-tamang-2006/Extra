import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    }
}

abstract class LibraryItem{
    private int itemId;
    private String title;
    private boolean isAvailable;
    
    LibraryItems(int i, String t, boolean a){
        this.itemId = i;
        this.title = t;
        this.isAvailable = a;
    }
    
    boolean borrowItem(){
        if(this.isAvailable) return false;
        
        return true;
    }
    
    boolean returnItem(){
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
    double fine = 0.20;
    Book(String id, String t, boolean a){
        super(id,t,a);
    }
    
}