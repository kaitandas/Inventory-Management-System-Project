package store;

public class Stock {
    
   private int Stock_Id;
   private String Stock_name;
   private String category;
   private double stock_price;
   private int Quantity;
   private String description;

    public Stock(int Stock_Id, String Stock_name, String category, double stock_price, int Quantity, String description) {
        this.Stock_Id = Stock_Id;
        this.Stock_name = Stock_name;
        this.category = category;
        this.stock_price = stock_price;
        this.Quantity = Quantity;
        this.description = description;
    }

    public void setStock_Id(int Stock_Id) {
        this.Stock_Id = Stock_Id;
    }

    public void setStock_name(String Stock_name) {
        this.Stock_name = Stock_name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock_price(double stock_price) {
        this.stock_price = stock_price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock_Id() {
        return Stock_Id;
    }

    public String getStock_name() {
        return Stock_name;
    }

    public String getCategory() {
        return category;
    }

    public double getStock_price() {
        return stock_price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getDescription() {
        return description;
    }
   
}
