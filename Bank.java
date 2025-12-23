import java.util.Scanner;

class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Your Name: ");
        String n = sc.nextLine();

        System.out.print("Enter Your Account Number: ");
        int num = sc.nextInt();

        System.out.print("Enter Your Balance: ");
        double b = sc.nextDouble();

        BankAccount acc = new BankAccount(n, num, b);

        int choice;

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Details");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("How much do you want to deposit? ");
                    double amtd = sc.nextDouble();
                    acc.deposit(amtd);
                    break;

                case 2:
                    System.out.print("How much do you want to withdraw? ");
                    double amtw = sc.nextDouble();
                    acc.withdraw(amtw);
                    break;
                    
                case 3:
                    acc.display();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Please choose between 1 and 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}

class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;

    BankAccount(String n, int num, double b) {
        accountHolderName = n;
        accountNumber = num;
        balance = b;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Amount successfully deposited.");
    }

    void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amt;
            System.out.println("Amount successfully withdrawn.");
        }
    }

    void display() {
        System.out.printf(
            "\nAccount Details\nAccount Holder: %s\nAccount Number: %d\nBalance: $%.2f\n",
            accountHolderName, accountNumber, balance
        );
    }
}

/*
OUTPUT

Enter Your Name: Raj Tamang
Enter Your Account Number: 92837892
Enter Your Balance: 9200000

Choose an option:
1. Deposit
2. Withdraw
3. Details
4. Exit
1
How much do you want to deposit? 9923.12
Amount successfully deposited.

Choose an option:
1. Deposit
2. Withdraw
3. Details
4. Exit
2
How much do you want to withdraw? 100.55
Amount successfully withdrawn.

Choose an option:
1. Deposit
2. Withdraw
3. Details
4. Exit
3

Account Details
Account Holder: Raj Tamang
Account Number: 92837892
Balance: $9209822.57

Choose an option:
1. Deposit
2. Withdraw
3. Details
4. Exit
4
Thank you!

*/
