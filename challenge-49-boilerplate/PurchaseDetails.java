public class PurchaseDetails{
    private String date;
    private long customer_id;
    private int product_category;
    private String payment_method;
    private float valueInUSD;
    private float time_on_site;
    private int clicks_in_site;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_category() {
        return product_category;
    }

    public void setProduct_category(int product_category) {
        this.product_category = product_category;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public float getValueInUSD() {
        return valueInUSD;
    }

    public void setValueInUSD(float valueInUSD) {
        this.valueInUSD = valueInUSD;
    }

    public float getTime_on_site() {
        return time_on_site;
    }

    public void setTime_on_site(float time_on_site) {
        this.time_on_site = time_on_site;
    }

    public int getClicks_in_site() {
        return clicks_in_site;
    }

    public void setClicks_in_site(int clicks_in_site) {
        this.clicks_in_site = clicks_in_site;
    }

    public PurchaseDetails(String date, long customer_id, int product_category, String payment_method, float valueInUSD,
            float time_on_site, int clicks_in_site) {
        this.date = date;
        this.customer_id = customer_id;
        this.product_category = product_category;
        this.payment_method = payment_method;
        this.valueInUSD = valueInUSD;
        this.time_on_site = time_on_site;
        this.clicks_in_site = clicks_in_site;
    }

    @Override
    public String toString() {
        return "PurchaseDetails [clicks_in_site=" + clicks_in_site + ", customer_id=" + customer_id + ", date=" + date
                + ", payment_method=" + payment_method + ", product_category=" + product_category + ", time_on_site="
                + time_on_site + ", valueInUSD=" + valueInUSD + "]";
    }
}