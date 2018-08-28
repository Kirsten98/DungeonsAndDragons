package DungeonsAndDragons;
//TODO set up after inventory is added
public class Weapon {

    private String name;
    private String itemProperties; // If item has no description, enter "" in constructor.
    private int quantity;

    public Weapon(String name, String itemProperties, int quantity){

        this.name = name;
        this.itemProperties = itemProperties;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getItemProperties() {
        if (this.itemProperties.equals("")){
            this.itemProperties = "No Properties";
        }
        return itemProperties;
    }

    public int getQuantity() {
        return quantity;
    }

    public void ToString(){
        System.out.println("Item Name: " + name + "\nItem Description: " + itemProperties +"\nQuantity: " + quantity);
    }

    /**
     * Adds item quantities together
     * @param weapon2 second weapon you would add the quantity to.
     */
    public void Addition(Weapon weapon2){
        this.quantity = this.quantity+weapon2.quantity;
    }

}
