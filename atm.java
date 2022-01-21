import java.util.*;
public class atm {
    static Scanner sc=new Scanner(System.in);
    static int balance=1000;
    static String username = "Pasupathy";
    static int userpin=9894;
    static int ATM[]=new int[6];

    public static boolean Admin(){
        Boolean b=true;
        for(int x=1;x<=3;x++){
            int a=1;
            System.out.println("Enter your Admin name: ");
            String name=sc.next();
            sc.nextLine();
            System.out.println("Enter Password: ");
            String password=sc.nextLine();
            if(name.equals("Admin1") && password.equals("ADMIN") && a<=3){
                System.out.println("Welcome: "+name);
                b=true;
                break;
            }
            else{
                System.out.println("Invalid name or password");
                b=false;
                break;
            }
        }
        return b;
    }
    public static void user(){
        System.out.println("Welcome to the User");
        System.out.println("1.Cash Withdrawal:");
        System.out.println("2.Cash deposit");
        System.out.println("3.Balance Enquiry");
        System.out.println("4.Change Pin");
        System.out.println("5.Exit");
        System.out.println("Enter Your Choice:");
        int u=sc.nextInt();
        switch(u){
            case 1:
              System.out.print("Enter Withdraw amount: ");
              int i=sc.nextInt();
              if(i>balance){
                  System.out.println("You have insufficient funds");
              }
              else{
                  System.out.println("Balance: "+(balance-i));
              }
              break;
            case 2:
               System.out.println("The Accepted Denominations are 100,200,500,2000 only");
                    System.out.println("Enter Deposit Amount: ");
                    int y1=sc.nextInt();
                    System.out.println("Enter no of 100 rs: ");
                    int m1=sc.nextInt();
                    System.out.println("Enter no of 200 rs: ");
                    int n1=sc.nextInt();
                    System.out.println("Enter no of 500 rs: ");
                    int o1=sc.nextInt();
                    System.out.println("Enter no of 2000 rs: ");
                    int p1=sc.nextInt();
                    System.out.println("100s :"+m1*100);
                    System.out.println("200s :"+n1*200);
                    System.out.println("500s :"+o1*500);
                    System.out.println("2000s :"+p1*2000);
                    System.out.println("Successfully Deposited!!");
               break;
            case 3:
              System.out.println("Your Current Balance is: "+balance);
              break;
            case 4:
              System.out.println("Enter your old pin: ");
              String old=sc.next();
              sc.nextLine();
              System.out.println("Enter New Pin: ");
              String newp=sc.nextLine();
              if(newp.equals(old)){
                  System.out.println("Your new pin is same as your old pin");
              }else{
                  System.out.println("pin has been changed successfully");
              }
              break;
            case 5:
              System.out.println("Logged Out Successfully");

        }


    }
    public static void main(String args[]){
        System.out.println("1.Admin");
        System.out.println("2.User");
        System.out.println("3.Exit");
        int s=sc.nextInt();
        switch(s){
            case 1:
            if(Admin()){
                System.out.println("Welcome to the Admin");
                System.out.println("1.Deposit Amount");
                System.out.println("2.Check Balance");
                System.out.println("3.Exit");
                System.out.println("Enter your choice: ");
                int c=sc.nextInt();
                if(c==1){
                    System.out.println("The Accepted Denominations are 100,200,500,2000 only");
                    System.out.println("Enter Deposit Amount: ");
                    int y=sc.nextInt();
                    System.out.println("Enter no of 100 rs: ");
                    int m=sc.nextInt();
                    System.out.println("Enter no of 200 rs: ");
                    int n=sc.nextInt();
                    System.out.println("Enter no of 500 rs: ");
                    int o=sc.nextInt();
                    System.out.println("Enter no of 2000 rs: ");
                    int p=sc.nextInt();
                    System.out.println("100s :"+m*100);
                    System.out.println("200s :"+n*200);
                    System.out.println("500s :"+o*500);
                    System.out.println("2000s :"+p*2000);
                    break;
                }
                if(c==2){
                    System.out.println("Avalaible balance: "+balance);
                    break;
                }
                if(c==3){
                    System.out.println("Logged Out Successfully");
                    break;
                }
            }
            case 2:
                user();
                break;
            case 3:
                System.out.println("LoggedOut Successfully");
        }
        }

}

