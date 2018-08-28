package DungeonsAndDragons;

public class Item {

    private String name;
    private String itemDescription; // If item has no description, enter "" in constructor.
    private int quantity;
    private int cost;

    public Item(String name, String itemDescription, int quantity,int cost){

        this.name = name;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.cost = cost;
    }


    public String getName() {
        return name;
    }

    public String getItemDescription() {
        if (this.itemDescription.equals("")){
            this.itemDescription = "No Description";
        }
        return itemDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }

    public void ToString(){
        System.out.println("Item Name: " + name + "\nItem Description: " + itemDescription +"\nQuantity: " + quantity);
    }

    /**
     * Adds item quantities together
     * @param item2  second item you would add the quantity to.
     */
    public void Addition(Item item2){
        this.quantity = this.quantity+item2.quantity;
    }


/**
 * "Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2
 * "Bedroll","",1,1
 * "Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2
 * "Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5
 *
 */

}
