import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("How many Accounts do you want to make?\nDrop a Number: ");
        int n = sc.nextInt();

        Bank obj[] = new Bank[n];
        for(int i = 0; i < n; i++){
            int acc_number = rand.nextInt(10000000);
            System.out.println("\n\n#HashNumber: " + (i+1));
            System.out.println("Account Number : " + acc_number );
            
            sc.nextLine();
            System.out.print("Account holder's name: ");
            String name = sc.nextLine();
            

            System.out.print("Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();

            int pin = 1000 + rand.nextInt(9000);
            
            System.out.println("Your Pin : " +pin );

            obj[i] = new Bank(name, balance, acc_number, pin);
        }

        System.out.println("\n\n************************");
        System.out.println("1. Deposit ");
        System.out.println("2. Withdraw");      
        System.out.println("3. Display Informations");
        System.out.println("************************");

        System.out.print("Enter: ");
        int choice = sc.nextInt();
        System.out.print("Enter the HashNumber: ");
        int hashnumber = sc.nextInt();
        if(0 < hashnumber && hashnumber <= n){
            System.out.print("Pin: ");
            int num = sc.nextInt();
            if(obj[hashnumber - 1].check(num)){
                switch(choice){    
                    case 1 -> {
                        System.out.print("Amount : ");
                        double amount = sc.nextDouble();
                        obj[hashnumber-1].Deposit(amount);
                        System.out.println("Your new Data is as Follows");
                        obj[hashnumber-1].Display(num);
                    }
                    case 2 -> {
                        System.out.print("Amount : ");
                        double amount = sc.nextDouble();
                        obj[hashnumber-1].Withdraw(amount);
                        System.out.println("\n\nYour new Data is as Follows");
                        obj[hashnumber-1].Display(num);
                    }
                    case 3 -> {
                        obj[hashnumber-1].Display(num);
                    }
                    default -> System.out.println("You have entered a wrong choice. Try Again.");          
                }
            }            
            else {
                System.out.println("Incorrect Pin");
            }
           
        }
        else {
             System.out.println("No Such person Exists in this Bank");
        }
        
    }
}

class Bank{
    //Basic members 
    private String accholder;
    private double Balance = 0;
    private int accnumber;
    private int pin;
    
    public Bank (String name, double balance, int number,int num){
        this.accholder = name;
        this.Balance = balance;
        this.accnumber = number; 
        this.pin = num; 
    }
    public boolean check(int num){
        if(num == pin){
            return true;
        }
        else {
            return false;
        }
    }

    public void Deposit(double amount){
        Balance += amount;
    }

    public void Withdraw(double amount){
        if(amount > Balance){
            System.out.println("Insufficient Balance.\nYour Balance: "+ Balance);
        }
        else {
            Balance -= amount;
            System.out.println("Your Balance: " + Balance);
        }
    }

    public void Display(int number){
        if(pin == number){            
            System.out.println("Account Holder: "+ accholder);
            System.out.println("Account Number:" + accnumber);
            System.out.println("Balance: "+ Balance);
        }
        else {
            System.out.println("Pin is incorrect");
        }
    }
}


