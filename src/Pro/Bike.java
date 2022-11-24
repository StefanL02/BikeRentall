package Pro;


import java.io.Serializable;

public class Bike implements Serializable {

    private String category;
    private String bikeManufacturer;
    private String description;
    private double price;

    public Bike(String category, String bikeManufacturer, String description, double price){

          setCategory(category);
          setBikeManufacturer(bikeManufacturer);
          setDescription(description);
          setPrice(price);

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBikeManufacturer() {
        return bikeManufacturer;
    }

    public void setBikeManufacturer(String bikeManufacturer) {
        this.bikeManufacturer = bikeManufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        this.price = price;

    }

    @Override
    public String toString() {
            return  "Category: " + getCategory() +
                    "\nBike: " + getBikeManufacturer() +
                    "\nDescription: " + getDescription() +
                    "\nPrice: " + getPrice();
    }
}
