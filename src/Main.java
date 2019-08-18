import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static double account_balance = 0;

    // Storing Customer and Merchant objects

    static ArrayList<Merchant> mer = new ArrayList<>();
    static ArrayList<Customer> cus = new ArrayList<>();

    // Polymorphism for showing Menu

    public static void showMenu(funct b){
        b.Menu();
    }

    public static void main(String[] args) {

        // Declaring 5 Merchants

        mer.add(new Merchant("jack","address1"));
        mer.add(new Merchant("john","address2"));
        mer.add(new Merchant("james","address3"));
        mer.add(new Merchant("jeff","address4"));
        mer.add(new Merchant("joseph","address5"));

        // Declaring 5 Customers

        cus.add(new Customer("ali","address1"));
        cus.add(new Customer("bruno","address2"));
        cus.add(new Customer("nobby","address3"));
        cus.add(new Customer("borat","address4"));
        cus.add(new Customer("aladeen","address5"));

        // Program Starts

        int query = 0;

        while (query != 5){
            System.out.println("Welcome to Mercury");
            System.out.println("1) Enter as Merchant");
            System.out.println("2) Enter as Customer");
            System.out.println("3) See user details");
            System.out.println("4) Company account balance");
            System.out.println("5) Exit");
            query = sc.nextInt();

            if (query == 1){
                System.out.println("choose merchant");
                for (Merchant a: mer) {
                    System.out.println(a.getmID() + " " + a.getName());
                }
                int s = sc.nextInt();
                for (Merchant a: mer) {
                    if(a.getmID() == s){
                        //a.Menu();
                        showMenu(a);
                    }
                }
            }

            else if(query == 2){
                System.out.println("choose customer");
                for (Customer a: cus) {
                    System.out.println(a.getcID() + " " + a.getName());
                }
                int s = sc.nextInt();
                for (Customer a: cus) {
                    if(a.getcID() == s){
                        //a.Menu();
                        showMenu(a);
                    }
                }
            }

            else if(query == 3){
                System.out.println("Enter M or C followed by user ID to see the details");
                sc.nextLine();
                String kn = sc.nextLine();
                int mn = sc.nextInt();

                if(kn.equalsIgnoreCase("M")){
                    for (Merchant b: mer) {
                        if(b.getmID() == mn){
                            System.out.println(b.getName()+" "+b.getAddress()+" "+b.getContribution());
                        }
                    }
                }

                else{
                    for (Customer b: cus) {
                        if(b.getcID() == mn){
                            System.out.println(b.getName()+" "+b.getAddress()+" "+b.getNofOrders());
                        }
                    }
                }
            }

            else if(query == 4){
                System.out.print("Account balance of the company is: ");
                System.out.printf("%.4f",account_balance);
                System.out.println();
            }
        }
    }
}
