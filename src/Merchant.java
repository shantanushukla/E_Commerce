import java.util.ArrayList;
import java.util.Scanner;

public class Merchant implements funct {

    private static int setID;
    private final int mID;
    private final String name;
    private final String address;
    private double contribution;
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
        this.contribution = 0;
    }

    // possible use for interface

    public void addItem(String name, double price, int quantity, String category){
        Items t = new Items(name,price,quantity,category,this.mID);
        items.add(t);
        local_items.add(t);
        System.out.println(t);
    }

    public void editItems(int id, double price, int quantity){
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
                    break;
                }
            }
        }
    }

    @Override
    public void search(){
        for (Items a: items) {
            if(!cat.contains(a.getCategory())){
                cat.add(a.getCategory());
            }
        }

        int i = 0;

        for (String a:cat) {
            System.out.println(i+1 + ") " + a);
            i++;
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
        for (Items a: local_items) {
            System.out.println(a);
        }
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

    public void ser(funct a){
        a.search();
    }

    public void Menu(){
        System.out.println("Welcome "+this.name);
        int query1 = 0;
        while (query1 != 6){
            System.out.println("Merchant Menu ");
            System.out.println("1) Add item ");
            System.out.println("2) Edit item ");
            System.out.println("3) Search by category ");
            System.out.println("4) Add offer ");
            System.out.println("5) Rewards won ");
            System.out.println("6) Exit ");
            query1 = sc.nextInt();

            if(query1 == 1){
                System.out.println("Enter Item Details");

                System.out.println("Item Name");
                sc.nextLine();
                String a = sc.nextLine();

                System.out.println("Item Price");
                double b = sc.nextFloat();

                System.out.println("Item Quantity");
                int c = sc.nextInt();

                System.out.println("Item Category");
                sc.nextLine();
                String d = sc.nextLine();

                this.addItem(a,b,c,d);
            }

            else if(query1 == 2){
                System.out.println("Choose Item by code");
                for (Items a: local_items) {
                    System.out.println(a);
                }
                int b = sc.nextInt();
                System.out.println("Enter Edit Details");
                System.out.println("Item Price:");
                double c = sc.nextFloat();
                System.out.println("Item Quantity:");
                int d = sc.nextInt();

                this.editItems(b,c,d);
            }

            else if(query1 == 3){
                System.out.println("Choose a category");
                //this.search();
                ser(this);
            }

            else if(query1 == 4){
                System.out.println("Choose Item by code");
                this.Offer();
            }

            else if(query1 == 5){
                System.out.println("Rewards Won are: \n"+this.getRewardSlots());
            }
        }

    }

    public static ArrayList<Items> getItems() {
        return items;
    }

    public static ArrayList<String> getCat() {
        return cat;
    }

    public int getmID() {
        return mID;
    }

    public String getName() {
        return name;
    }

    public int getRewardSlots() {
        return rewardSlots;
    }

    public double getContribution() {
        return contribution;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    public String getAddress() {
        return address;
    }
}
