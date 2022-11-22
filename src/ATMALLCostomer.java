import java.util.Scanner;

public class ATMALLCostomer {
    public static void main(String[] args) {
        int balance=1000000,withdraw ,deposit;
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Automated Teller  Machine");
            System.out.println("Choose1 for withdraw ");
            System.out.println("Choose2 for deposit");
            System.out.println("Choose 3 for  check Balance");
            System.out.println("Choose 4  for Exit");
            System.out.print("Choose  the operation you want to perform");
            int choice =scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter money to be withdraw:");
                    withdraw=scanner.nextInt();
                    if (balance>=withdraw){
                        balance=balance-withdraw;
                        System.out.println("Please collect your money");
                    }
                    else {
                        System.out.println("insufficient Balance");
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Enter money to be deposited ");
                    deposit=scanner.nextInt();
                    balance=balance+deposit;
                    System.out.println("Your money has been successfully deposited");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Balance :"+balance);
                    System.out.println("");
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
