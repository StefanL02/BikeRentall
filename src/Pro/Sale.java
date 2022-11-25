package Pro;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable {

    private double price;
    private Date currentDate;

    public Sale(double price){

        setPrice(price);
        setCurrentDate(currentDate);

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String toString(){

        return "\nDate: " + getCurrentDate() +
                "\nPrice: " + getPrice();
    }
}
