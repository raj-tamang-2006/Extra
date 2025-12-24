import java.util.Scanner;

class Bank {
    
    Scanner sc = new Scanner(System.in);
    private String Acc_hol;
    private long Acc_num;
    private double balance;
    
    public Bank(String ah, long an, double b){
        this.Acc_hol = ah;
        this.Acc_num = an;
        this.balance = b;
    }
    
    public void deposit(double amt){
        balance += amt;
    }
    
    public void Withdrawn(double amt){
        if(balance == 0){
            System.out.println("Your Balance is Zero.");
        }
        else if (balance < amt){
            System.out.println("Insufficient Balance.");
        }
        else {
            balance -= amt;
        }
    }
    
    // pin: "0011"
    public String displayInfo(){
        int c = 0;
        while (c < 3) {
            System.out.print("Pin: ");
            String pin = sc.nextLine();
            
            if ("0011".equals(pin)) {
                System.out.println("=========================================");
                return "Account Holder: " + Acc_hol + "\nAccount No.: " + Acc_num + "\nBalance: " + balance;
            } else {
                System.out.println("Wrong Pin, try again.");
                c++;
            }
        }
        return "Your 3 tries are done.";
    }
}

class Execution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many accounts are you going to give? ");
        int n = scan.nextInt();
        scan.nextLine();
        
        Bank[] acc = new Bank[n];  // Size adjusted to n
        
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Name: ");
            String name = scan.nextLine();
            
            System.out.print("Account number: ");
            long num = scan.nextLong();  // Change to long to support larger account numbers
            scan.nextLine();
            
            System.out.print("Balance: ");
            double Bal = scan.nextDouble();
            scan.nextLine();
            
            acc[i] = new Bank(name, num, Bal);  // Initialize the bank account first

            System.out.println("Choose:\nFor Deposit(1)\nFor Withdrawal(2)\nFor nothing(any other number)");
            int c = scan.nextInt();
            scan.nextLine();
            
            double amount = 0;
            if (c == 1 || c == 2) {
                System.out.print("Amount: ");
                amount = scan.nextDouble();
                scan.nextLine();
            }

            switch(c) {
                case 1:
                    acc[i].deposit(amount);
                    break;
                case 2:
                    acc[i].Withdrawn(amount);                    break;
                default:
                    System.out.println(":) Okayyyyy");
            }
        }
        
        // Asking for person number to display their account information
        while (true) {
            System.out.println("If you want to see the account of a person, give me the person number (1 to " + n + "), or give me 0 to exit.");
            System.out.print("Give me the person number: ");
            int per = scan.nextInt();
            scan.nextLine();
            
            if (per == 0) {
                break;
            } else if (per > 0 && per <= n) {
                System.out.println(acc[per - 1].displayInfo());
            } else {
                System.out.println("Invalid person number. Please try again.");
            }
        }

        System.out.println("Program terminated.");
    }
}
