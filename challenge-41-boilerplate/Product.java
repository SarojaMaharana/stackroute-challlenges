public class Product {
    private String pid;
    private String productName;
    private String brand;
    private String productUrl;
    private int retailPrice;
    private int discountedPrice;
    private String rating;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(int discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Product(String data) {
        String[] str = data.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        setPid(str[0]);
        setProductName(str[1]);
        setBrand(str[2]);
        setProductUrl(str[3]);
        setRetailPrice(Integer.parseInt(str[4]));
        setDiscountedPrice(Integer.parseInt(str[5]));
        setRating(str[6]);
    }
}
