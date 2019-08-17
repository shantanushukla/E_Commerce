public class Items {
    static int setiUID;
    private final int iUID;
    private final String iName;
    private int price;
    private int availQuant;
    private String offer;
    private final String category;

    Items(String iName, int price, int availQuant, String category){

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


}
