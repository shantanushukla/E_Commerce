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

        for (Items a: items) {
            if(a.getCategory().equalsIgnoreCase(cat.get(c-1))){
                System.out.println(a);
            }
        }

        c = sc.nextInt();
        int d = sc.nextInt();

        // Incomplete

        for (Items a: items) {
            if(a.getiUID() == c){
                if(a.getAvailQuant() < d){
                    System.out.println("Error");
                    break;
                }
                if(a.getPrice()*d > this.pAccount+this.rewardAccount){
                    System.out.println("Error");
                    break;
                }

                float temp = this.pAccount - a.getPrice()*d;
                if(temp >= 0){
                    this.pAccount -= a.getPrice()*d;
                }
                else {
                    this.pAccount = 0;
                    this.rewardAccount += this.pAccount-a.getPrice()*d;
                }

            }
        }

    }

    public float getRewardAccount() {
        return rewardAccount;
    }
}
