import java.util.ArrayList;
import java.util.Scanner;

public class Customer {

    private static int setID;
    private final int cID;
    private final String name;
    private final String address;
    private float pAccount;
    private float rewardAccount;

    // Functions

    Scanner sc = new Scanner(System.in);

    public Customer(String name, String address) {
        setID += 1;
        this.cID = setID;
        this.name = name;
        this.address = address;
        this.pAccount = 100;
        this.rewardAccount = 0;
    }

    public  void search(){
        ArrayList<Items> items = Merchant.getItems();
        ArrayList<String> cat = Merchant.getCat();

        for (String a: cat) {
            System.out.println(a);
        }

        int c = sc.nextInt();

        System.out.println("Choose item by code");
        for (Items a: items) {
            if(a.getCategory().equalsIgnoreCase(cat.get(c-1))){
                System.out.println(a);
            }
        }

        System.out.println("Enter item code");
        c = sc.nextInt();

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

                    float temp = this.pAccount - a.getPrice() * d;
                    if (temp >= 0) {
                        this.pAccount -= a.getPrice() * d;
                    } else {
                        this.pAccount = 0;
                        this.rewardAccount += this.pAccount - a.getPrice() * d;
                    }

                    // Subtract the quantity from ArrayList as well

                    a.setAvailQuant(a.getAvailQuant() - d);
                }
            }
        }
    }

    public void customerMenu(){
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
                this.search();
            }

            else if(query2 == 2){

            }

            else if(query2 == 3){

            }

            else if(query2 == 4){

            }
        }

    }

    public float getRewardAccount() {
        return rewardAccount;
    }

    public int getcID() {
        return cID;
    }

    public String getName() {
        return name;
    }
}
