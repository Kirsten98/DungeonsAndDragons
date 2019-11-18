package DungeonsAndDragons.MainCharacter;

import DungeonsAndDragons.MainCharacter.Item;
import DungeonsAndDragons.MainCharacter.CharacterSheet;
import DungeonsAndDragons.MainCharacter.Spells;

import java.util.Scanner;
import java.util.Vector;

public class Cleric extends CharacterClass{
    private CharacterSheet character;
    private String pack;
    private int hitDice = 8;
    private int proficiency=2;
    private Vector<String> features = new Vector();
    private int level = 0;
    private Vector<String> spells = new Vector<>();
    private  Vector<String> cantrips = new Vector<>();
    private int spellSaveDC;
    private int spellAttackMod;
    private String[] domains = {"Knowledge","Life", "Light", "Nature", "Tempest", "Trickery","War"};
    private int domainChoice;
    Vector<String> cantripList = Spells.clericSpellSetUp(10);
    Vector<String> firstLevelSpells = Spells.clericSpellSetUp(1);
    Vector<String> secondLevelSpells = Spells.clericSpellSetUp(2);
    Vector<String> thirdLevelSpells = Spells.clericSpellSetUp(3);
    Vector<String> fourthLevelSpells = Spells.clericSpellSetUp(4);
    Vector<String> fifthLevelSpells = Spells.clericSpellSetUp(5);
    Vector<String> sixthLevelSpells = Spells.clericSpellSetUp(6);
    Vector<String> seventhLevelSpells = Spells.clericSpellSetUp(7);
    Vector<String> eighthLevelSpells = Spells.clericSpellSetUp(8);
    Vector<String> ninthLevelSpells = Spells.clericSpellSetUp(9);

    Vector<String> proficiencies = new Vector<>();


    public Cleric(CharacterSheet character){
        this.character = character;
    }


    public static void abilityChoicePrintout(){
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

    }


    // Tested and verified 9/10
    /**
     * Adds Levels and related information to the character.
     */
    public void addLevel(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        level++;


        if (level == 1){
            System.out.println("\nLevel 1");
            System.out.println("Proficiency Bonus : " + proficiency);
            character.setHitPoints(8 + character.getConstitutionMod());
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            checkVectorAndAdd(proficiencies,"proficiencies","Light Armor");
            checkVectorAndAdd(proficiencies,"proficiencies","Medium Armor");
            checkVectorAndAdd(proficiencies,"proficiencies","Shields");
            checkVectorAndAdd(proficiencies,"proficiencies","Simple Weapons");
            checkVectorAndAdd(proficiencies,"proficiencies","Wisdom");
            checkVectorAndAdd(proficiencies,"proficiencies","Charisma");
            cantrips.setSize(3);
            for (int i = 0 ; i<2; i++){
                chooseYourSpell(1);
            }
            for (int i = 0 ; i<3 ; i++){
                cantripChoice();
            }

            System.out.println("Choose your Divine Domain");
            for(int i = 0; i < domains.length; i++){
                System.out.println(i+1 +".) " + domains[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            domainChoice = choice -1;
            System.out.println("You have chosen domain " + domains[domainChoice]);
            findDomain(domainChoice,1);




        }if (level == 2){
            System.out.println("\nLevel 2");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(1);
            findDomain(domainChoice,2);

        }if (level == 3){
            System.out.println("\nLevel 3");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(1);
            for (int i = 0 ; i<2 ; i++){
                chooseYourSpell(2);
            }
            findDomain(domainChoice,3);

        }if (level == 4){
            System.out.println("\nLevel 4");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(2);
            cantripChoice();
            findDomain(domainChoice,4);

        }if (level == 5){
            System.out.println("\nLevel 5");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for(int i = 0; i<2 ;i++){
                chooseYourSpell(3);
            }
            findDomain(domainChoice,5);

        }if (level == 6){
            System.out.println("\nLevel 6");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(3);
            findDomain(domainChoice,6);

        }if (level == 7){
            System.out.println("\nLevel 7");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(4);
            findDomain(domainChoice,7);

        }if (level == 8){
            System.out.println("\nLevel 8");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(4);
            findDomain(domainChoice,8);

        }if (level == 9){
            System.out.println("\nLevel 9");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(4);
            chooseYourSpell(5);
            findDomain(domainChoice,9);

        }if (level == 10){
            System.out.println("\nLevel 10");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(5);
            cantripChoice();
            findDomain(domainChoice,10);


        }if (level == 11){
            System.out.println("\nLevel 11");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(6);
            findDomain(domainChoice,11);

        }if (level == 12){
            System.out.println("\nLevel 12");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            findDomain(domainChoice,12);

        }if (level == 13){
            System.out.println("\nLevel 13");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(7);
            findDomain(domainChoice,13);

        }if (level == 14){
            System.out.println("\nLevel 14");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            findDomain(domainChoice,14);
        }if (level == 15){
            System.out.println("\nLevel 15");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(8);
            findDomain(domainChoice,15);

        }if (level == 16){
            System.out.println("\nLevel 16");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            findDomain(domainChoice,16);

        }if (level == 17){
            System.out.println("\nLevel 17");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(9);
            findDomain(domainChoice,17);

        }if (level == 18){
            System.out.println("\nLevel 18");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(5);
            findDomain(domainChoice,18);

        }if (level == 19){
            System.out.println("\nLevel 19");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(6);
            findDomain(domainChoice,19);

        }if (level == 20){
            System.out.println("\nLevel 20");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(7);
            findDomain(domainChoice,20);

        }

        spellSaveDC = 8 + proficiency + character.getWisdomMod();
        spellAttackMod= proficiency + character.getWisdomMod();

    }

    //Tested and verified 9/10
    /**
     * Sets up user to choose a new cantrips from available cantrips
     */
    public void cantripChoice(){
        int choice = 0;
        String endOfLine = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("You learned a new Cantrip! Choose your new Cantrip");
        vectorPrintOut(cantripList);
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,cantripList.size());
        cantrips.add(cantripList.get(choice-1));
        System.out.println("You added " + cantripList.get(choice-1) + " to your cantrips");
        cantripList.remove(choice-1);



    }

    /**
     * Checks if the contents are already in the vector, if yes nothing happens, if no the contents are added to the vector and prints the contents have been added to the vector.
     * @param vector The vector you are checking/ adding the contents into
     * @param contents String that you are checking/ adding in the vector
     * @param vectorName Name of the vector you are adding the item to
     */
    public void checkVectorAndAdd(Vector vector, String vectorName, String contents){
        if (!vector.contains(contents)){
            vector.add(contents);
            System.out.println(contents+" added to " + vectorName);
        }

    }

// Tested and verified
    public void chooseArmor(){
        Scanner scanner = new Scanner(System.in);
        String endOfLine ="";

        System.out.println("You are proficient in Light Armor, Medium Armor, and Shields. Choose your Armor.");
        for(int i = 0; i <(character.getLightArmor().length + character.getMediumArmor().length); i++){
            if(i< character.getLightArmor().length){
                System.out.println(i+1+".)"+character.getLightArmor()[i]);
            }
            if (i>=character.getLightArmor().length){
                System.out.println(i+1 +".)"+character.getMediumArmor()[i-character.getLightArmor().length]);
            }

        }
        int choice = scanner.nextInt();
        String endLine = scanner.nextLine();

        choice= inputErrorCheck(choice,1,character.getLightArmor().length + character.getMediumArmor().length);

        if(choice <= character.getLightArmor().length){
            System.out.println("You have chosen " + character.getLightArmor()[choice-1]);
            checkAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[choice-1],character.getLightArmorDescription()[choice-1],1,character.getLightArmorCost()[choice-1]));
            character.setAc(character.getLightArmorAC()[choice-1]);
        } if(choice > character.getLightArmor().length){
            System.out.println("You have chosen "  + character.getMediumArmor()[choice - character.getLightArmor().length - 1]);
            checkAndAddItemQuantity(character.armorList, new Item(character.getMediumArmor()[choice - character.getLightArmor().length - 1], character.getMediumArmorDescription()[choice - character.getLightArmor().length - 1],1,character.getMediumArmorCost()[choice - character.getLightArmor().length - 1]));
            character.setAc(character.getMediumArmorAC()[choice-character.getLightArmor().length - 1]);

        }


    }

    //Tested and verified 9/10

    /**
     * Allows user to add the raceTraits they want to be proficient in.
     */
    public void chooseSkillProficiencies(){
        Scanner scanner = new Scanner(System.in);
        int choice =-1;
        String endOfLine = "";
        Vector<String> tempskills = new Vector<>();
        tempskills.add("History");
        tempskills.add("Insight");
        tempskills.add("Medicine");
        tempskills.add("Persuasion");
        tempskills.add("Religion");

        System.out.println("Choose your first skill to be proficient in from the list below.");
        for(int i =0; i<2;i++){
            if (i ==1){
                System.out.println("Choose your second skill to be proficient in from the list below.");
            }
            vectorPrintOut(tempskills);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= inputErrorCheck(choice,1,tempskills.size());
            checkVectorAndAdd(proficiencies,"proficiencies",tempskills.get(choice-1));
            tempskills.remove(choice-1);
        }

    }

    // Tested and verified 9/10
    /**
     * Walks user through on adding their Weapons / Equipment ot the character
     */
    public void chooseWeapon(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String endOfLine = "";

        if (proficiencies.contains("Warhammer")){
            System.out.println("Choose a weapon. 1.) Mace or 2.) Warhammer");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= inputErrorCheck(choice,1,2);
            if (choice==1){
            checkVectorAndAdd(character.weapons,"weapons","Mace");
            }if (choice==2){
                checkVectorAndAdd(character.weapons, "weapons","Warhammer");
            }
        }else {
            checkVectorAndAdd(character.weapons,"weapons","Mace");
        }

        if (proficiencies.contains("Chain Mail")){

            System.out.println("Choose an armor. 1.) Scale Mail 2.) Leather Armor or 3.) Chain Mail.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= inputErrorCheck(choice,1,2);
            if (choice==1){
                checkAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[2],character.getMediumArmorDescription()[2],1,character.getMediumArmorCost()[2]));
            }if (choice==2){
                checkAndAddItemQuantity(character.armorList,new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
            }
            if (choice==3){
                checkAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[1],character.getMediumArmorDescription()[1],1,character.getMediumArmorCost()[1]));
            }

        }else {
            System.out.println("Choose an armor. 1.) Scale Mail or 2.) Leather Armor.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= inputErrorCheck(choice,1,2);
            if (choice==1){
                checkAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[2],character.getMediumArmorDescription()[2],1,character.getMediumArmorCost()[2]));
            }if (choice==2){
                checkAndAddItemQuantity(character.armorList,new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
            }

        }

        System.out.println("Choose a weapon. 1.) Light Crossbow and 20 Bolts or 2.) Any Simple Weapon.");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice= inputErrorCheck(choice,1,2);
        if (choice==1){
            checkVectorAndAdd(character.weapons,"weapons","Light Crossbow");
        }if (choice==2){
            System.out.println("Choose any simple weapon");
            System.out.println("** Simple Melee Weapons **");
            for (int i =0; i<character.getSimpleMeleeWeapons().length; i++){
                System.out.println(i+1 + ".) " + character.getSimpleMeleeWeapons()[i]);
            }
            System.out.println("** Simple Ranged Weapons **");
            for (int i =0 ; i <character.getSimpleRangedWeapons().length; i++ ){
                System.out.println(character.getSimpleMeleeWeapons().length+i+1 + ".) " + character.getSimpleRangedWeapons()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= inputErrorCheck(choice,1,character.getSimpleMeleeWeapons().length+character.getSimpleRangedWeapons().length);
            if (choice<character.getSimpleMeleeWeapons().length){
                checkVectorAndAdd(character.weapons,"weapons",character.getSimpleMeleeWeapons()[choice-1]);

            }if (choice>= character.getSimpleMeleeWeapons().length){
                checkVectorAndAdd(character.weapons, "weapons",character.getSimpleRangedWeapons()[choice-1-character.getSimpleMeleeWeapons().length]);
            }

        }

        System.out.println("Choose your pack. 1.)Priest's Pack or 2.) Explorer's Pack");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice= inputErrorCheck(choice,1,2);
        if (choice==1){
            pack="Priest";
            checkAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Blanket","",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Candle","For 1 hour, a candle sheds bright light in a 5 - foot radius and dim light for an additional 5 feet",10,1));
            checkAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Alms Box","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Blocks of Incense","",2,0));
            checkAndAddItemQuantity(character.inventory, new Item("Censer","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Vestments","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",2,5));
            checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
            System.out.println("Priest Pack added to inventory. ");

        }if (choice==2){
            pack="Explorer";
            checkAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
            checkAndAddItemQuantity(character.inventory, new Item("Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Torch","A torch burns for 1 hour providing bright light in a 20 foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.",10,1));
            checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5));
            checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Hempen Rope","Quantity is in feet",50,0));

            System.out.println("Explorer added to inventory. ");
        }
        character.setShield(true);
        checkAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
        character.setShield(true);
        checkAndAddItemQuantity(character.inventory, new Item("Holy Symbol","A holy symbol us a representation of a god or pantheon. It might be an amulet depicting a symbol representing s deity, the same symbol carefully engraved or inlaid as an emblem on a shield, or a tiny box holding a fragment of a sacred relic. Appendix B lists the symbols commonly associated with many gods in the multiverse. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in chapter 10. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield. ",1,5));

        System.out.println("Shield and Holy Symbol added to inventory.");

        System.out.println("Would you like to equip your shield? 1.) Yes or 2.) No ?");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,2);
        if (choice==1){
            character.setAc(character.getAc() +2);
            System.out.println("AC +2\n" + "Current AC : 1" +character.getAc());
        }


    }


    // Tested and verified 9/9
    /**
     * To choose the a spell from a specific level
     * @param spellLevel The Level of the spells that they are choosing from
     */
    public void chooseYourSpell(int spellLevel){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";


        if (spellLevel == 1){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, firstLevelSpells.size());
            System.out.println("You added " + firstLevelSpells.get(choice - 1)+ " to your spells.");
            spells.add(firstLevelSpells.get(choice - 1));
            firstLevelSpells.remove(choice - 1);

        }
        if (spellLevel == 2) {
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);

            System.out.println("Choose your spell.");
            vectorPrintOut(secondLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, secondLevelSpells.size());
            System.out.println("You added " + secondLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(secondLevelSpells.get(choice - 1));
            secondLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 3){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(thirdLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, thirdLevelSpells.size());
            System.out.println("You added " + thirdLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(thirdLevelSpells.get(choice - 1));
            thirdLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 4){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);

            System.out.println("Choose your spell.");
            vectorPrintOut(fourthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, fourthLevelSpells.size());
            System.out.println("You added " + fourthLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(fourthLevelSpells.get(choice - 1));
            fourthLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 5){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(fifthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, fifthLevelSpells.size());
            System.out.println("You added " + fifthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(fifthLevelSpells.get(choice - 1));
            fifthLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 6){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(sixthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, sixthLevelSpells.size());
            System.out.println("You added " + sixthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(sixthLevelSpells.get(choice - 1));
            sixthLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 7){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(seventhLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, seventhLevelSpells.size());
            System.out.println("You added " + seventhLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(seventhLevelSpells.get(choice - 1));
            seventhLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 8){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(eighthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, eighthLevelSpells.size());
            System.out.println("You added " + eighthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(eighthLevelSpells.get(choice - 1));
            eighthLevelSpells.remove(choice - 1);


        }

        if (spellLevel == 9){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(ninthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, ninthLevelSpells.size());
            System.out.println("You added " + ninthLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(ninthLevelSpells.get(choice - 1));
            ninthLevelSpells.remove(choice - 1);
        }
    }

    // Tested and verified 9/5
    /**
     * Randomly Generates a number between 1 and 8. Simulating a D8
     * @return Random Number between 1 and 8
     */
    public int d8Roll(){
        double randomDouble = Math.random()*8 +1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }


    /**
     * Finds the Domain that user has chosen, then Calls the specific domain method with the level corresponding to that specific domain
     * @param domainChoice The Domain chosen by user
     * @param level What Level the Domain is
     */

    public void findDomain(int domainChoice, int level){
        if (domainChoice == 0){
         knowledgeDomain(level);
        }
        if (domainChoice == 1){
            lifeDomain(level);
        }
        if (domainChoice == 2){
            lightDomain(level);
        }
        if (domainChoice == 3){
            natureDomain(level);
        }
        if (domainChoice == 4){
            tempestDomain(level);
        }
        if (domainChoice == 5){
            trickeryDomain(level);
        }
        if (domainChoice == 6){
            warDomain(level);
        }
    }


    /**
     * Checks to make sure that the choice from the user does not exceed the lower or upper bounds
     * @param choice Numberic Choice made by user
     * @param lowerCheck The lower bound
     * @param higherCheck The upper bound
     * @return Returns choice once it is a valid option
     */
    public int inputErrorCheck(int choice, int lowerCheck, int higherCheck){
        Scanner scanner = new Scanner(System.in);
        while (choice < lowerCheck || choice > higherCheck){
            System.out.println("Incorrect option, please choose a different option");
            choice = scanner.nextInt();
            String endofLine = scanner.nextLine();
        }
        return choice;
    }



    //Tested and verified 9/10
    /**
     * If character chose Knowledge Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void knowledgeDomain(int level){
        String choice;
        int numChoice;
        Scanner scanner = new Scanner(System.in);
        String endOfLine ="";
        if (level ==1){
            System.out.println("You have learned two new languages! What is the first language you would like to learn?");
            choice = scanner.nextLine();
            while(character.languages.contains(choice)){
                System.out.println("You already know this language, choose another language.");
                choice = scanner.nextLine();
            }
            character.languages.add(choice);

            System.out.println("You have added " + choice + " to your languages");
            System.out.println("What is your second language?");
            choice = scanner.nextLine();
            while(character.languages.contains(choice)){
                System.out.println("You already know this language, choose another language.");
                choice = scanner.nextLine();
            }
            character.languages.add(choice);

            System.out.println("You have added " + choice + " to your languages");


            checkVectorAndAdd(spells,"spells","Command");
            checkVectorAndAdd(spells,"spells","Identify");

            Vector<String> divineSkills = new Vector<>();
            divineSkills.add("Arcana");
            divineSkills.add("History");
            divineSkills.add("Nature");
            divineSkills.add("Religion");
            System.out.println("You can become proficient in two raceTraits. Choose your first skill");
            vectorPrintOut(divineSkills);
            numChoice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            numChoice = inputErrorCheck(numChoice,1,divineSkills.size());
            features.add("Proficiency: " + divineSkills.get(numChoice-1));
            System.out.println("Proficiency: " + divineSkills.get(numChoice-1) + " added to features");
            divineSkills.remove(numChoice-1);
            System.out.println("Choose your second skill");
            vectorPrintOut(divineSkills);
            numChoice = scanner.nextInt();
            features.add("Proficiency: " + divineSkills.get(numChoice-1));
            System.out.println("Proficiency: " + divineSkills.get(numChoice-1) + " added to features");
            divineSkills.remove(numChoice-1);
        }

        if (level == 2){
            features.add("Channel Divinity: Knowledge of the Ages");
            System.out.println("Channel Divinity: Knowledge of the Ages was added to features");
        }
        if (level == 3){
            checkVectorAndAdd(spells,"spells","Augury");
            checkVectorAndAdd(spells,"spells","Suggestion");

        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Nondetection");
            checkVectorAndAdd(spells,"spells","Speak with Dead");
        } if (level == 6){
            features.add("Channel Divinity: Read Thoughts");
            System.out.println("Channel Divinity: Read Thoughts added to features");
        }
        if (level==7){
            checkVectorAndAdd(spells,"spells","Arcane Eye");
            checkVectorAndAdd(spells,"spells","Confusion");

        }
        if (level == 8){
            features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells","Legend Lore");
            checkVectorAndAdd(spells,"spells","Scrying");

        }
        if (level ==17){
            features.add("Visions of the Past");
            System.out.println("Features of the Past added to features");
        }
    }

    //Tested and verified 9/10
    /**
     * If character chose Life Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void lifeDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Bless");
            checkVectorAndAdd(spells,"spells","Cure Wounds");
            checkVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("Disciple of Life");

        } if (level == 2){
            features.add("Channel Divinity: Preserve Life");
        }
        if (level == 3){
           checkVectorAndAdd(spells,"spells","Lesser Restoration");
            checkVectorAndAdd(spells,"spells","Spiritual Weapon");

        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Beacon of Hope");
            checkVectorAndAdd(spells,"spells","Revivify");

        }if (level ==6 ){
            features.add("Blessed Healer");
            System.out.println("Blessed Healer added to features");
        }
        if (level==7){
            checkVectorAndAdd(spells,"spells","Death Ward");
            checkVectorAndAdd(spells,"spells","Guardian of Faith");

        }
        if (level==8){
            features.add("Divine Strike (d8)");
            System.out.println("Divine Strike (d8) added to features");
        }
        if (level ==9){
           checkVectorAndAdd(spells,"spells","Mass Cure Wounds");
           checkVectorAndAdd(spells,"spells","Raise Dead");
        }
        if (level==14){
            features.remove("Divine Strike (d8)");
            features.add("Divine Strike (2d8)");
            System.out.println("Divine Strike (2d8) added to features");
        }
        if (level == 17){
            features.add("Supreme Healing");
            System.out.println("Supreme Healing added to features");
        }
    }
    /**
     * If character chose Light Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void lightDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Burning Hands");
            checkVectorAndAdd(spells,"spells","Faerie Fire");

            if (!cantrips.contains("Light")){
                cantrips.add("Light");
                System.out.println("Light added to Cantrips");
            }
            features.add("Warding Flare");
            System.out.println("Warding Flare added to features");


        } if (level == 2){
            features.add("Channel Divinity: Radiance of the Dawn");
            System.out.println("Channel Divinity: Radiance of the Dawn added to features");
        }
        if (level == 3){
            checkVectorAndAdd(spells,"spells","Flaming Sphere");
            checkVectorAndAdd(spells,"spells","Scorching Ray");


        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Daylight");
            checkVectorAndAdd(spells,"spells","Fireball");

        }
        if (level == 6 ){
            features.remove("Warden Flare");
            features.add("Improved Warden Flare");
            System.out.println("Improved Warden Flare added to features");
        }
        if (level== 7){
                checkVectorAndAdd(spells,"spells","Guardian of Faith");
                checkVectorAndAdd(spells,"spells","Wall of Fire");
        }
        if (level == 8 ){
           features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells","Flame Strike");
            checkVectorAndAdd(spells,"spells","Scrying");

        }
        if (level == 17) {
            features.add("Corona of Light");
            System.out.println("Corona of Light added to features");
        }
    }

    /**
     * If character chose Nature Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void natureDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Animal Friendship");
            checkVectorAndAdd(spells,"spells","Speak with Animals");
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have learned 1 Druid Cantrip. What cantrip would you like to learn?");
            Vector<String> druidCantrips = Spells.druidSpellSetUp(10);
            vectorPrintOut(druidCantrips);
            choice = scanner.nextInt();
            cantrips.add(druidCantrips.get(choice-1));
            System.out.println("You have added " + druidCantrips.get(choice-1) + " to your cantrips");
            druidCantrips.remove(choice-1);
           checkVectorAndAdd(proficiencies, "proficiencies","Heavy Armor");



        }if (level == 2){
            features.add("Channel Divinity: Charm Animals and Plants");
            System.out.println("Channel Divinity: Charm Animals and Plants added to your features");
        }

        if (level == 3){
            checkVectorAndAdd(spells,"spells","Barkskin");
            checkVectorAndAdd(spells,"spells","Spike Growth");

        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Plant Growth");
            checkVectorAndAdd(spells,"spells","Wind Wall");

        }if (level == 6){
            features.add("Dampen Elements");
            System.out.println("Dampen Elements added to features");
        }if (level==7){
                checkVectorAndAdd(spells,"spells","Dominate Beast");
                checkVectorAndAdd(spells,"spells","Grasping Vine");
        }
        if (level == 8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells","Insect Plague");
            checkVectorAndAdd(spells,"spells","Tree Stride ");

        }
        if (level == 14){
            features.remove("Divine Strike (1d8)");
            features.add("Divine Strike (2d8)");
            System.out.println("Divine Strike (2d8) added to features");

        }
        if (level == 17){
            features.add("Master of Nature");
            System.out.println("Master of Nature added to features");
        }
    }


    /**
     * If character chose Tempest Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void tempestDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Fog Cloud");
            checkVectorAndAdd(spells,"spells","Thunderwave");
            checkVectorAndAdd(proficiencies,"proficiencies","Martial Weapons");
            checkVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("Wrath of the Storm");
            System.out.println("Wrath of the Storms added to features");

        }if (level == 2){
            features.add("Channel Divinity: Destructive Wrath");
            System.out.println("Channel Divinity: Destructive Wrath added to features");
        }
        if (level == 3){
            checkVectorAndAdd(spells,"spells","Gust of Wind");
            checkVectorAndAdd(spells,"spells","Shatter");

        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Call Lightning");
            checkVectorAndAdd(spells,"spells","Sleet Storm");

        }if (level == 6){
            features.add("Thunderbolt Strike");
            System.out.println("Thunderbolt Strike added to features");
        }
        if (level==7){
            checkVectorAndAdd(spells,"spells","Control Water");
            checkVectorAndAdd(spells,"spells","Ice Storm");

        }
        if (level==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells","Destructive Wave");
            checkVectorAndAdd(spells,"spells","Insect Plague");
        }
        if (level==14){
            features.remove("Divine Strike (1d8)");
            features.add("Divine Strike (2d8)");
            System.out.println("Divine Strike (2d8) added to features");
        }if (level == 17){
            features.add("Stormborn");
            System.out.println("Stormborn added to features");
        }
    }
    /**
     * If character chose Trickery Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void trickeryDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Charm Person");
            checkVectorAndAdd(spells,"spells","Disguise Self");
            features.add("Blessing of the Trickster");
            System.out.println("Blessing of the Trickster added to features");

        }
        if (level ==2){
            features.add("Channel Divinity: Invoke Duplicity");
            System.out.println("Channel Divinity: Invoke Duplicity added to features");

        }if (level == 3){
            checkVectorAndAdd(spells,"spells","Mirror Image");
            checkVectorAndAdd(spells,"spells","Pass Without Trace");


        } if (level == 5){
            checkVectorAndAdd(spells,"spells","Blink");
            checkVectorAndAdd(spells,"spells","Dispel Magic");

        }if (level ==6){
            features.add("Channel Divinity: Cloak of Shadows");
            System.out.println("Channel Divinity: Cloak of Shadows added to features");

        }
        if (level==7){
            checkVectorAndAdd(spells,"spells","Dimension Door");
            checkVectorAndAdd(spells,"spells","Polymorph");

        }
        if (level ==8){
            features.add("Channel Divinity: Divine Strike (1d8)");
            System.out.println("Channel Divinity: Divine Strike (1d8) added to features");
        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells","Dominate Person");
            checkVectorAndAdd(spells,"spells","Modify Memory");
        }
        if (level== 14){
            features.remove("Channel Divinity: Divine Strike (1d8)");
            features.add("Channel Divinity: Divine Strike (2d8)");
            System.out.println("Channel Divinity: Divine Strike (2d8) added to features");
        }
        if (level ==17){
            features.remove("Channel Divinity: Invoke Duplicity");
            features.add("Channel Divinity: Improved Duplicity");
            System.out.println("Channel Divinity: Improved Duplicity added to features");
        }
    }
    /**
     * If character chose War Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void warDomain(int level){
        if (level ==1){
            checkVectorAndAdd(spells,"spells","Divine Favor");
            checkVectorAndAdd(spells,"spells","Shield of Faith");
            checkVectorAndAdd(proficiencies,"proficiencies","Martial Weapons");
            checkVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("War Priest");
            System.out.println("War Priest added to features");

        }if (level==2){
            features.add("Channel Divinity: Guided Strike");
            System.out.println("Channel Divinity: Guided Strike added to features");

        }
        if (level == 3){
            checkVectorAndAdd(spells,"spells","Magic Weapon");
            checkVectorAndAdd(spells,"spells", "Spiritual Weapon");

        } if (level == 5){
            checkVectorAndAdd(spells,"spells", "Crusader's Mantle");
            checkVectorAndAdd(spells,"spells", "Spirit Guardians");

        } if (level ==6){
            features.add("Channel Divinity: War God's Blessing");
            System.out.println("Channel Divinity: War God's Blessing added to features");

        }
        if (level==7){
            checkVectorAndAdd(spells,"spells","Freedom of Movement");
            checkVectorAndAdd(spells,"spells","Stoneskin");

        }
        if (level ==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");

        }
        if (level ==9){
            checkVectorAndAdd(spells,"spells", "Flame Strike");
            checkVectorAndAdd(spells,"spells","Hold Monster");

        }
        if (level ==14){
            features.remove("Divine Strike (1d8)");
            features.add("Divine Strike (2d8)");
            System.out.println("Divine Strike (2d8) added to features");

        }
        if (level == 17){
            features.add("Avatar of Battle");
            System.out.println("Avatar of Battle added to features");

        }
    }



    public static void vectorPrintOut(Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
        }
    }




}
