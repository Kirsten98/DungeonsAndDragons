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


/** Examples:
 * "Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2
 * "Bedroll","",1,1
 * "Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2
 * "Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5
 * "Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5
 * "Chest","",1,5
 * "Waterskin","",1,2
 * "Hempen Rope","Quantity is in feet",50,0
 * "Javelin","",4,0
 * Case","This cylindrical leather case can hold up to ten rolled-up sheets od paper or five rolled-up sheets of parchment ",2,1
 * "Set of Fine Clothes","",1,0
 * "Bottle of Ink","",1,0
 *"Ink Pen","",1,2
 * "Flask of Oil","Oils usually comes in a clay flask that holds 1 pint. As an action you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5 foot square area,provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters or ends its turn in the area. A creature can take this damage only once per turn.",2,0
 * "Lamp","A  lamp casts bright light in a 15 foot radius and dim light for an additional 30 feet. ONce lit, it burns for 6 hours on a flask (1 pint) of oil",1,5
 * "Sheets of Paper","",5,0
 *
 */

}
