import java.util.ArrayList;
import java.util.Scanner;

public class Customer implements funct {

    private static int setID;
    private final int cID;
    private final String name;
    private final String address;
    private double pAccount;
    private double rewardAccount;
    private int nofOrders;

    private ArrayList<Integer> itmC = new ArrayList<>();
    private ArrayList<Integer> itmQ = new ArrayList<>();
    private ArrayList<Items> items = Merchant.getItems();
    private ArrayList<String> cat = Merchant.getCat();
    private ArrayList<String> orders = new ArrayList<>();

    // Functions Start

    Scanner sc = new Scanner(System.in);

    public Customer(String name, String address) {
        setID += 1;
        this.cID = setID;
        this.name = name;
        this.address = address;
        this.pAccount = 100;
        this.rewardAccount = 0;
        this.nofOrders = 0;
    }

    // Polymorphism

    @Override
    public  void search(){
        for (Items a: items) {
            if(!cat.contains(a.getCategory())){
                cat.add(a.getCategory());
            }
        }

        int i = 1;
        for (String a: cat) {
            System.out.println(i+") "+a);
            i++;
        }

        int cl = sc.nextInt();

        System.out.println("Choose item by code");
        for (Items a: items) {
            if(a.getCategory().equalsIgnoreCase(cat.get(cl-1))){
                System.out.println(a);
            }
        }

        System.out.println("Enter item code");
        int c = sc.nextInt();

        System.out.println("Enter item quantity");
        int d = sc.nextInt();

        // Incomplete
        System.out.println("Choose method of transaction ");
        System.out.println("1) Buy item \n2) Add item to cart \n3) Exit");
        int y = sc.nextInt();

        if(y == 1) {
            for (Items a : items) {
                if (a.getiUID() == c) {
                    if (a.getAvailQuant() < d) {
                        System.out.println("Error: Quantity greater than available");
                        break;
                    }
                    if (a.getPrice() * d > this.pAccount + this.rewardAccount) {
                        System.out.println("Error: Not enough funds available");
                        break;
                    }

                    double temp = this.pAccount - a.getPrice() * d;
                    if (temp >= 0) {
                        this.pAccount -= a.getPrice() * d;
                    } else {
                        this.pAccount = 0;
                        this.rewardAccount += this.pAccount - a.getPrice() * d;
                    }

                    a.setAvailQuant(a.getAvailQuant() - d);

                    String name = "";

                    double pr =  (a.getPrice() * d)*(0.005);
                    for (Merchant k: Main.mer) {
                        if(k.getmID() == a.getMerID()){
                            k.setContribution(k.getContribution()+pr);
                            name = k.getName();
                        }
                    }

                    Main.account_balance += (a.getPrice() * d)*(.01);
                    this.nofOrders += 1;

                    if(this.nofOrders % 5 == 0) {
                        this.rewardAccount += 10;
                    }

                    System.out.println("Item Successfully bought");

                    orders.add( "Bought item "+a.getiName()+" quantity: "+d+" for Rs "+a.getPrice()*d+" from Merchant: "+name);

                    break;
                }
            }
        }

        else if(y == 2){
            itmC.add(c);
            itmQ.add(d);
        }
    }

    // Implementing function for polymorphism

    public void ser(funct a){
        a.search();
    }

    // Starting of menu for Customer

    public void Menu(){
        System.out.println("Welcome "+this.name);
        System.out.println("Customer Menu");
        int query2 = 0;

        while (query2 != 5){
            System.out.println("1) Search item \n" +
                    "2) checkout cart \n" +
                    "3) Reward won \n" +
                    "4) print latest orders \n" +
                    "5) Exit");

            query2 = sc.nextInt();

            if(query2 == 1){
                System.out.println("Choose a category");
                //this.search();
                ser(this);
            }

            else if(query2 == 2){

                label:

                for (int i = 0; i < this.itmQ.size(); i++) {

                    for (Items a : items) {
                        if (a.getiUID() == this.itmC.get(i)) {
                            if (a.getAvailQuant() < this.itmQ.get(i)) {
                                System.out.println("Error: Quantity greater than available");
                                break label;
                            }
                            if (a.getPrice() * this.itmQ.get(i) > this.pAccount + this.rewardAccount) {
                                System.out.println("Error: Not enough funds available");
                                break label;
                            }

                            double temp = this.pAccount - a.getPrice() * this.itmQ.get(i);
                            if (temp >= 0) {
                                this.pAccount -= a.getPrice() * this.itmQ.get(i);
                            } else {
                                this.pAccount = 0;
                                this.rewardAccount += this.pAccount - a.getPrice() * this.itmQ.get(i);
                            }

                            a.setAvailQuant(a.getAvailQuant() - this.itmQ.get(i));
                            String namew = "";

                            double pr = (a.getPrice() * this.itmQ.get(i))*(0.005);
                            for (Merchant k: Main.mer) {
                                if(k.getmID() == a.getMerID()){
                                    k.setContribution(k.getContribution()+pr);
                                    namew = k.getName();
                                }
                            }

                            Main.account_balance += (a.getPrice() * this.itmQ.get(i))*(0.01);
                            this.nofOrders += 1;

                            if(this.nofOrders % 5 == 0) {
                                this.rewardAccount += 10;
                            }

                            System.out.println("Item Successfully bought");

                            orders.add( "Bought item "+a.getiName()+" quantity: "+this.itmQ.get(i)+" for Rs "+a.getPrice()*this.itmQ.get(i)+" from Merchant: "+namew);
                            break;
                        }
                    }
                }
            }

            else if(query2 == 3){
                System.out.println(this.rewardAccount);
            }

            else if(query2 == 4){
                int i = orders.size()-1;
                int j = 10;
                while(i>=0 && j>0) {
                    System.out.println(orders.get(i));
                    i--;
                    j--;
                }
            }
        }

    }

    // Getters and setters

    public int getcID() {
        return cID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getNofOrders() {
        return nofOrders;
    }
}
