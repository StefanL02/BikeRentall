package Pro;


import java.io.Serializable;

/**
 * Created by Stefan Lajtar on 25/11/2022
 * @author Stefan Lajtar
 * @version 1.0
 */

public class Bike implements Serializable {

    private String category;
    private String bikeManufacturer;
    private String description;
    private double price;

    /**
     * Multi-argument constructor
     * @param category The category of the bike
     * @param bikeManufacturer The name of the Bike Manufacturer
     * @param description The simple description of the bike
     * @param price The price of the bike
     */


    public Bike(String category, String bikeManufacturer, String description, double price){

          setCategory(category);
          setBikeManufacturer(bikeManufacturer);
          setDescription(description);
          setPrice(price);

    }

    /**
     * Accessor(getter) method to return the category of the bike.
     * @return The category of the bike
     */

    public String getCategory() {
        return category;
    }

    /**
     * Mutator(setter) method to set the category of the bike
     * @param category The category of the bike
     */

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Accessor(getter) method to return Bike Manufacturer
     * @return the Bike Manufacturer of the bike
     */

    public String getBikeManufacturer() {
        return bikeManufacturer;
    }

    /**
     * Mutator(setter) method to set the Bike Manufacturer of the bike
     * @param bikeManufacturer the Bike Manufacturer of the bike
     */
    public void setBikeManufacturer(String bikeManufacturer) {
        this.bikeManufacturer = bikeManufacturer;
    }

    /**
     * Accessor(getter) to return the description of the bike
     * @return The description of the bike
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mutator(setter) method to set the description of the bike
     * @param description The description of the bike
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Accessor(getter) method to return the price of the bike
     * @return The price of the bike
     */
    public double getPrice() {
        return price;
    }

    /**
     * Mutator(setter) method to set the price of the bike
     * @param price The price of the bike
     */
    public void setPrice(double price) {

        this.price = price;

    }

    /**
     * Accessor method to return the details of the bike
     * @return The details of the  bike
     */
    @Override
    public String toString() {
            return  "Category: " + getCategory() +
                    "\nBike: " + getBikeManufacturer() +
                    "\nDescription: " + getDescription() +
                    "\nPrice: " + getPrice();
    }
}
