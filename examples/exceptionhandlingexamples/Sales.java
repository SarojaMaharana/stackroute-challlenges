public class Sales
{
    String productName;
    int productsSoldInTheQuarter;
    int totalSalesAmount;

    public Sales(String productName, int productsSoldInTheQuarter, int totalSalesAmount) {
        this.productName = productName;
        this.productsSoldInTheQuarter = productsSoldInTheQuarter;
        this.totalSalesAmount = totalSalesAmount;
    }

    public int costOfOneProduct()
    {
        return totalSalesAmount/productsSoldInTheQuarter;
    }
    
}