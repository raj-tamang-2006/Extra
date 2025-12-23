import java.util.*;
class Main{
    public static void menu(){
        System.out.println("What does your Stomach want today?");
        System.out.println("1. Drinks");
        System.out.println("2. Food");
        System.out.println("3. Desserts");
        System.out.println("4. Exit");
        System.out.print("Choose (1-4): ");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double totalamt = 0;
        int choice;
        do{
            menu();
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    Drinks d = new Drinks();
                    d.listOfItems();
                    System.out.print("Choose (1-6)");
                    int drink = sc.nextInt();
                    totalamt += d.price[drink - 1];
                    break;
                case 2:
                    Food f = new Food();
                    f.listOfItems();
                    System.out.print("Choose (1-6)");
                    int food = sc.nextInt();
                    totalamt += f.price[food - 1];
                    break;
                case 3:
                    Dessert D = new Dessert();
                    D.listOfItems();
                    System.out.print("Choose (1-6)");
                    int dessert = sc.nextInt();
                    totalamt += D.price[dessert - 1];
                    break;
                case 4:
                    if(totalamt > 0){
                        System.out.println("\nThank you for ordering!");
                        System.out.printf("Total Amount: $%.2f\n", totalamt);
                    }
                    else{
                        System.out.println("\nThank you for Your Visit!");
                    }
                    break;
                default: System.out.println("Invalid order");
            }
            
        }while(choice != 4);
    }
}
abstract class Menu{
    String[] name ;
    double[] price ;
    
    abstract void listOfItems();
}

class Drinks extends Menu{
    Drinks(){
        name = new String[]{"Pepsi", "Coke", "Sprite", "Coffee", "Hot Chocolate", "Tea"};
        price = new double[] {2.50,2.50,2.50,4.55,7.85,4.55};
    }
    
    @Override
    void listOfItems(){
        System.out.println("   Items  Price");
        for(int i = 0; i < name.length; i++){
            System.out.println((i+1)+". "+name[i]+" -$"+price[i] );
        }
    }
}
class Food extends Menu{
    Food(){
        name = new String[]{"Burger", "Pizza", "Pasta", "French Fries", "Chicken Wings", "Salad"};
        price = new double[] {8.0,16.50,10.55,4,11.25,9.35};
    }
    
    @Override
    void listOfItems(){
        System.out.println("   Items  Price");
        for(int i = 0; i < name.length; i++){
            System.out.println((i+1)+". "+name[i]+" -$"+price[i] );
        }
    }
}
class Dessert extends Menu{
    Dessert(){
        name = new String[]{"Ice Cream", "Chocolate Cake", "Apple Pie", "Chesse Cake", "Brownie", "Milkshake"};
        price = new double[] {6.15,8.55,8.35,6.75,9.35, 4.85};
    }
    
    @Override
    void listOfItems(){
        System.out.println("   Items  Price");
        for(int i = 0; i < name.length; i++){
            System.out.println((i+1)+". "+name[i]+" -$"+price[i] );
        }
    }
}