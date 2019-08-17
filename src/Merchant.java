import java.util.ArrayList;
import java.util.Scanner;

public class Merchant {

    private static int setID;
    private final int mID;
    private final String name;
    private final String address;
    private int rewardSlots;

    private static ArrayList<Items> items = new ArrayList<>();
    private ArrayList<Items> local_items = new ArrayList<>();
    private static ArrayList<String> cat = new ArrayList<>();

    // Functions

    Scanner sc = new Scanner(System.in);

    public Merchant(String name, String address) {
        setID += 1;
        this.mID = setID;
        this.name = name;
        this.address = address;
        this.rewardSlots = 0;
    }

    // possible use for interface

    public void addItem(String name, float price, int quantity, String category){
        Items t = new Items(name,price,quantity,category);
        items.add(t);
        local_items.add(t);
    }

    public void editItems(int id, float price, int quantity){
        boolean flag = false;

        for (Items a: local_items) {
            if(id == a.getiUID()){
                a.setPrice(price);
                a.setAvailQuant(quantity);
                System.out.println(a);
                flag = true;
                break;
            }
        }

        if(flag){
            for (Items a: items) {
                if(id == a.getiUID()){
                    a.setPrice(price);
                    a.setAvailQuant(quantity);
                    System.out.println(a);
                    break;
                }
            }
        }
    }

    public void search(){
        for (Items a: items) {
            if(!cat.contains(a.getCategory())){
                cat.add(a.getCategory());
            }
        }

        int i = 0;

        for (String a:cat) {
            System.out.println(i+1 + ") " + a);
        }

        i = sc.nextInt();
        String c = cat.get(i-1);

        for (Items a: items) {
            if(a.getCategory().equalsIgnoreCase(c)){
                System.out.println(a);
            }
        }
    }

    public void Offer(){
        int s = sc.nextInt();

        for (Items a: local_items) {
            if(a.getiUID() == s){
                System.out.println("choose offer \n1) buy one get one \n2) 25% off ");

                int n = sc.nextInt();

                if(n==1){
                    a.setOffer("buy one get one");
                }

                else{
                    a.setOffer("25% off");
                }

                System.out.println(a);

                for (Items b: items) {
                    if(b.getiUID() == s){
                        if(n==1){
                            b.setOffer("buy one get one");
                        }

                        else{
                            b.setOffer("25% off");
                        }
                    }
                }
            }
        }
    }

    public static ArrayList<Items> getItems() {
        return items;
    }

    public static ArrayList<String> getCat() {
        return cat;
    }
}
