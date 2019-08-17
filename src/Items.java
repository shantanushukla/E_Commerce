public class Items {
    static int setiUID;
    private final int iUID;
    private final String iName;
    private float price;
    private int availQuant;
    private String offer;
    private final String category;

    Items(String iName, float price, int availQuant, String category) {
        setiUID += 1;
        this.iUID = setiUID;
        this.iName = iName;
        this.price = price;
        this.availQuant = availQuant;
        this.category = category;
        this.offer = "";
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public int getiUID() {
        return iUID;
    }

    public float getPrice() {
        return price;
    }

    public int getAvailQuant() {
        return availQuant;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAvailQuant(int availQuant) {
        this.availQuant = availQuant;
    }

    @Override
    public String toString() {
        return  iUID + " " + iName + " " + price + " " + availQuant + " " + offer + " " + category;
    }
}
