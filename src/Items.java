public class Items {
    static int setiUID;
    private final int iUID;
    private final String iName;
    private double price;
    private int availQuant;
    private String offer;
    private final String category;
    private int merID;

    // Functions Start

    Items(String iName, double price, int availQuant, String category, int merID) {
        setiUID += 1;
        this.iUID = setiUID;
        this.iName = iName;
        this.price = price;
        this.availQuant = availQuant;
        this.category = category;
        this.offer = "None";
        this.merID = merID;
    }

    // Getters and setters

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getiUID() {
        return iUID;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailQuant() {
        return availQuant;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailQuant(int availQuant) {
        this.availQuant = availQuant;
    }

    public int getMerID() {
        return merID;
    }

    public String getiName() {
        return iName;
    }

    public String getOffer() {
        return offer;
    }

    // For printing (Special Function)

    @Override
    public String toString() {
        return  iUID + " " + iName + " " + price + " " + availQuant + " " + offer + " " + category;
    }
}
