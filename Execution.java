import java.util.Scanner;

class Bank {
    private String account_holder;
    private int account_number;
    private double balance;


    public Bank(String ah, int an, double b){
        this.account_holder = ah;
        this.account_number = an;
        this.balance = b;
    }


    public void deposit(double amount){
        balance += amount;
    }


    public void withdraw(double amount){
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public void display() {
        System.out.println("Information of the Account:");
        System.out.printf("Account Holder: %s\nAccount Number: %d\nBalance: %.2f\n", account_holder, account_number, balance);
    }
}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How many account details are you going to provide?");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        
        String[] name = new String[n];
        int[] num = new int[n];
        double[] bal = new double[n];
        double dep, withdraw;
        Bank[] P = new Bank[n];


        for (int i = 0; i < n; i++) {
            System.out.println("\n\nPerson number: " + (i + 1));
            
            System.out.print("Name: ");
            name[i] = sc.nextLine();
            
            
            System.out.print("Account Number: ");
            num[i] = sc.nextInt();
            sc.nextLine(); 
            
            
            System.out.print("Balance: ");
            bal[i] = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("How much do you want to deposit: ");
            dep = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("How much do you want to withdraw: ");
            withdraw = sc.nextDouble();
            sc.nextLine(); 

            P[i] = new Bank(name[i], num[i], bal[i]);
            P[i].deposit(dep);
            P[i].withdraw(withdraw);
        }

        System.out.println("Press the person's number (1 to " + n + ") whose details you want to see.");
        System.out.println("Press 0 to stop.\n");

        int see;
        do {
            System.out.print("\n\nEnter person's number: ");
            see = sc.nextInt();
            if (see == 0) {
                break;
            } else if (see < 1 || see > n) {
                System.out.println("This person doesn't exist. Please choose a number between 1 and " + n);
            } else {
                P[see - 1].display(); 
            }
        } while (see != 0);

        sc.close(); 
        System.out.println("Thank you for using the banking system.");
    }
}