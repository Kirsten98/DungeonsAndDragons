package DungeonsAndDragons;

import java.util.Scanner;
import java.util.Vector;

public class Cleric {
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
    Vector<String> cantripList = Spells.ClericSpellSetUp(10);
    Vector<String> firstLevelSpells = Spells.ClericSpellSetUp(1);
    Vector<String> secondLevelSpells = Spells.ClericSpellSetUp(2);
    Vector<String> thirdLevelSpells = Spells.ClericSpellSetUp(3);
    Vector<String> fourthLevelSpells = Spells.ClericSpellSetUp(4);
    Vector<String> fifthLevelSpells = Spells.ClericSpellSetUp(5);
    Vector<String> sixthLevelSpells = Spells.ClericSpellSetUp(6);
    Vector<String> seventhLevelSpells = Spells.ClericSpellSetUp(7);
    Vector<String> eighthLevelSpells = Spells.ClericSpellSetUp(8);
    Vector<String> ninthLevelSpells = Spells.ClericSpellSetUp(9);

    Vector<String> proficiencies = new Vector<>();


    public Cleric(CharacterSheet character){
        this.character = character;
    }

// Tested and verified
    public void ChooseArmor(){
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

        choice= InputErrorCheck(choice,1,character.getLightArmor().length + character.getMediumArmor().length);

        if(choice <= character.getLightArmor().length){
            System.out.println("You have chosen " + character.getLightArmor()[choice-1]);
            CheckAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[choice-1],character.getLightArmorDescription()[choice-1],1,character.getLightArmorCost()[choice-1]));
//            character.setArmor(character.getLightArmor()[choice-1]);
            character.setAc(character.getLightArmorAC()[choice-1]);
        } if(choice > character.getLightArmor().length){
            System.out.println("You have chosen "  + character.getMediumArmor()[choice - character.getLightArmor().length - 1]);
            CheckAndAddItemQuantity(character.armorList, new Item(character.getMediumArmor()[choice - character.getLightArmor().length - 1], character.getMediumArmorDescription()[choice - character.getLightArmor().length - 1],1,character.getMediumArmorCost()[choice - character.getLightArmor().length - 1]));
//            character.setArmor(character.getMediumArmor()[choice-character.getLightArmor().length - 1]);
            character.setAc(character.getMediumArmorAC()[choice-character.getLightArmor().length - 1]);

        }


    }

    // Tested and verified 9/10
    /**
     * Walks user through on adding their Weapons / Equipment ot the character
     */
    public void ChooseWeapon(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String endOfLine = "";

        if (proficiencies.contains("Warhammer")){
            System.out.println("Choose a weapon. 1.) Mace or 2.) Warhammer");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice=InputErrorCheck(choice,1,2);
            if (choice==1){
            CheckVectorAndAdd(character.weapons,"weapons","Mace");
            }if (choice==2){
                CheckVectorAndAdd(character.weapons, "weapons","Warhammer");
            }
        }else {
            CheckVectorAndAdd(character.weapons,"weapons","Mace");
        }

        if (proficiencies.contains("Chain Mail")){

            System.out.println("Choose an armor. 1.) Scale Mail 2.) Leather Armor or 3.) Chain Mail.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice=InputErrorCheck(choice,1,2);
            if (choice==1){
                CheckAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[2],character.getMediumArmorDescription()[2],1,character.getMediumArmorCost()[2]));
            }if (choice==2){
                CheckAndAddItemQuantity(character.armorList,new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
            }
            if (choice==3){
                CheckAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[1],character.getMediumArmorDescription()[1],1,character.getMediumArmorCost()[1]));
            }

        }else {
            System.out.println("Choose an armor. 1.) Scale Mail or 2.) Leather Armor.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice=InputErrorCheck(choice,1,2);
            if (choice==1){
                CheckAndAddItemQuantity(character.armorList,new Item(character.getMediumArmor()[2],character.getMediumArmorDescription()[2],1,character.getMediumArmorCost()[2]));
            }if (choice==2){
                CheckAndAddItemQuantity(character.armorList,new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
            }

        }

        System.out.println("Choose a weapon. 1.) Light Crossbow and 20 Bolts or 2.) Any Simple Weapon.");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice=InputErrorCheck(choice,1,2);
        if (choice==1){
            CheckVectorAndAdd(character.weapons,"weapons","Light Crossbow");
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
            choice=InputErrorCheck(choice,1,character.getSimpleMeleeWeapons().length+character.getSimpleRangedWeapons().length);
            if (choice<character.getSimpleMeleeWeapons().length){
                CheckVectorAndAdd(character.weapons,"weapons",character.getSimpleMeleeWeapons()[choice-1]);

            }if (choice>= character.getSimpleMeleeWeapons().length){
                CheckVectorAndAdd(character.weapons, "weapons",character.getSimpleRangedWeapons()[choice-1-character.getSimpleMeleeWeapons().length]);
            }

        }

        System.out.println("Choose your pack. 1.)Priest's Pack or 2.) Explorer's Pack");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice=InputErrorCheck(choice,1,2);
        if (choice==1){
            pack="Priest";
            CheckAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
            CheckAndAddItemQuantity(character.inventory, new Item("Blanket","",1,5));
            CheckAndAddItemQuantity(character.inventory, new Item("Candle","For 1 hour, a candle sheds bright light in a 5 - foot radius and dim light for an additional 5 feet",10,1));
            CheckAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
            CheckAndAddItemQuantity(character.inventory, new Item("Alms Box","",1,0));
            CheckAndAddItemQuantity(character.inventory, new Item("Blocks of Incense","",2,0));
            CheckAndAddItemQuantity(character.inventory, new Item("Censer","",1,0));
            CheckAndAddItemQuantity(character.inventory, new Item("Vestments","",1,0));
            CheckAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",2,5));
            CheckAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
            System.out.println("Priest Pack added to inventory. ");

        }if (choice==2){
            pack="Explorer";
            CheckAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
            CheckAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
            CheckAndAddItemQuantity(character.inventory, new Item("Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2));
            CheckAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
            CheckAndAddItemQuantity(character.inventory, new Item("Torch","A torch burns for 1 hour providing bright light in a 20 foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.",10,1));
            CheckAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5));
            CheckAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
            CheckAndAddItemQuantity(character.inventory, new Item("Hempen Rope","Quantity is in feet",50,0));

            System.out.println("Explorer added to inventory. ");
        }
        character.setShield(true);
        CheckAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
        character.setShield(true);
        CheckAndAddItemQuantity(character.inventory, new Item("Holy Symbol","A holy symbol us a representation of a god or pantheon. It might be an amulet depicting a symbol representing s deity, the same symbol carefully engraved or inlaid as an emblem on a shield, or a tiny box holding a fragment of a sacred relic. Appendix B lists the symbols commonly associated with many gods in the multiverse. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in chapter 10. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield. ",1,5));

        System.out.println("Shield and Holy Symbol added to inventory.");

        System.out.println("Would you like to equip your shield? 1.) Yes or 2.) No ?");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = InputErrorCheck(choice,1,2);
        if (choice==1){
            character.setAc(character.getAc() +2);
            System.out.println("AC +2\n" + "Current AC : 1" +character.getAc());
        }


    }


    //Tested and verified 9/10

    /**
     * Allows user to add the skills they want to be proficient in.
     */
    public void ChooseSkillProficiencies(){
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
            VectorPrintOut(tempskills);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice= InputErrorCheck(choice,1,tempskills.size());
            CheckVectorAndAdd(proficiencies,"proficiencies",tempskills.get(choice-1));
            tempskills.remove(choice-1);
        }

    }


    // Tested and verified 9/5
    /**
     * Randomly Generates a number between 1 and 8. Simulating a D8
     * @return Random Number between 1 and 8
     */
    public int D8Roll(){
        double randomDouble = Math.random()*8 +1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }


    // Tested and verified 9/10
    /**
     * Adds Levels and related information to the character.
     */
    public void AddLevel(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        level++;


        if (level == 1){
            System.out.println("\nLevel 1");
            System.out.println("Proficiency Bonus : " + proficiency);
            character.setHitPoints(8 + character.getConstitutionMod());
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            CheckVectorAndAdd(proficiencies,"proficiencies","Light Armor");
            CheckVectorAndAdd(proficiencies,"proficiencies","Medium Armor");
            CheckVectorAndAdd(proficiencies,"proficiencies","Shields");
            CheckVectorAndAdd(proficiencies,"proficiencies","Simple Weapons");
            CheckVectorAndAdd(proficiencies,"proficiencies","Wisdom");
            CheckVectorAndAdd(proficiencies,"proficiencies","Charisma");
            cantrips.setSize(3);
            for (int i = 0 ; i<2; i++){
                ChooseYourSpell(1);
            }
            for (int i = 0 ; i<3 ; i++){
                CantripChoice();
            }

            System.out.println("Choose your Divine Domain");
            for(int i = 0; i < domains.length; i++){
                System.out.println(i+1 +".) " + domains[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            domainChoice = choice -1;
            System.out.println("You have chosen domain " + domains[domainChoice]);
            FindDomain(domainChoice,1);




        }if (level == 2){
            System.out.println("\nLevel 2");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(1);
            FindDomain(domainChoice,2);

        }if (level == 3){
            System.out.println("\nLevel 3");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(1);
            for (int i = 0 ; i<2 ; i++){
                ChooseYourSpell(2);
            }
            FindDomain(domainChoice,3);

        }if (level == 4){
            System.out.println("\nLevel 4");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(2);
            CantripChoice();
            FindDomain(domainChoice,4);

        }if (level == 5){
            System.out.println("\nLevel 5");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for(int i = 0; i<2 ;i++){
                ChooseYourSpell(3);
            }
            FindDomain(domainChoice,5);

        }if (level == 6){
            System.out.println("\nLevel 6");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(3);
            FindDomain(domainChoice,6);

        }if (level == 7){
            System.out.println("\nLevel 7");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            FindDomain(domainChoice,7);

        }if (level == 8){
            System.out.println("\nLevel 8");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            FindDomain(domainChoice,8);

        }if (level == 9){
            System.out.println("\nLevel 9");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            ChooseYourSpell(5);
            FindDomain(domainChoice,9);

        }if (level == 10){
            System.out.println("\nLevel 10");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(5);
            CantripChoice();
            FindDomain(domainChoice,10);


        }if (level == 11){
            System.out.println("\nLevel 11");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);
            FindDomain(domainChoice,11);

        }if (level == 12){
            System.out.println("\nLevel 12");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,12);

        }if (level == 13){
            System.out.println("\nLevel 13");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);
            FindDomain(domainChoice,13);

        }if (level == 14){
            System.out.println("\nLevel 14");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,14);
        }if (level == 15){
            System.out.println("\nLevel 15");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(8);
            FindDomain(domainChoice,15);

        }if (level == 16){
            System.out.println("\nLevel 16");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,16);

        }if (level == 17){
            System.out.println("\nLevel 17");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(9);
            FindDomain(domainChoice,17);

        }if (level == 18){
            System.out.println("\nLevel 18");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(5);
            FindDomain(domainChoice,18);

        }if (level == 19){
            System.out.println("\nLevel 19");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);
            FindDomain(domainChoice,19);

        }if (level == 20){
            System.out.println("\nLevel 20");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);
            FindDomain(domainChoice,20);

        }

        spellSaveDC = 8 + proficiency + character.getWisdomMod();
        spellAttackMod= proficiency + character.getWisdomMod();

    }

    /**
     * Finds the Domain that user has chosen, then Calls the specific domain method with the level corresponding to that specific domain
     * @param domainChoice The Domain chosen by user
     * @param level What Level the Domain is
     */

    public void FindDomain(int domainChoice, int level){
        if (domainChoice == 0){
         KnowledgeDomain(level);
        }
        if (domainChoice == 1){
            LifeDomain(level);
        }
        if (domainChoice == 2){
            LightDomain(level);
        }
        if (domainChoice == 3){
            NatureDomain(level);
        }
        if (domainChoice == 4){
            TempestDomain(level);
        }
        if (domainChoice == 5){
            TrickeryDomain(level);
        }
        if (domainChoice == 6){
            WarDomain(level);
        }
    }


    //Tested and verified 9/10
    /**
     * If character chose Knowledge Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void KnowledgeDomain (int level){
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


            CheckVectorAndAdd(spells,"spells","Command");
            CheckVectorAndAdd(spells,"spells","Identify");

            Vector<String> divineSkills = new Vector<>();
            divineSkills.add("Arcana");
            divineSkills.add("History");
            divineSkills.add("Nature");
            divineSkills.add("Religion");
            System.out.println("You can become proficient in two skills. Choose your first skill");
            VectorPrintOut(divineSkills);
            numChoice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            numChoice = InputErrorCheck(numChoice,1,divineSkills.size());
            features.add("Proficiency: " + divineSkills.get(numChoice-1));
            System.out.println("Proficiency: " + divineSkills.get(numChoice-1) + " added to features");
            divineSkills.remove(numChoice-1);
            System.out.println("Choose your second skill");
            VectorPrintOut(divineSkills);
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
            CheckVectorAndAdd(spells,"spells","Augury");
            CheckVectorAndAdd(spells,"spells","Suggestion");

        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Nondetection");
            CheckVectorAndAdd(spells,"spells","Speak with Dead");
        } if (level == 6){
            features.add("Channel Divinity: Read Thoughts");
            System.out.println("Channel Divinity: Read Thoughts added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"spells","Arcane Eye");
            CheckVectorAndAdd(spells,"spells","Confusion");

        }
        if (level == 8){
            features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells","Legend Lore");
            CheckVectorAndAdd(spells,"spells","Scrying");

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
    public void LifeDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Bless");
            CheckVectorAndAdd(spells,"spells","Cure Wounds");
            CheckVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("Disciple of Life");

        } if (level == 2){
            features.add("Channel Divinity: Preserve Life");
        }
        if (level == 3){
           CheckVectorAndAdd(spells,"spells","Lesser Restoration");
            CheckVectorAndAdd(spells,"spells","Spiritual Weapon");

        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Beacon of Hope");
            CheckVectorAndAdd(spells,"spells","Revivify");

        }if (level ==6 ){
            features.add("Blessed Healer");
            System.out.println("Blessed Healer added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"spells","Death Ward");
            CheckVectorAndAdd(spells,"spells","Guardian of Faith");

        }
        if (level==8){
            features.add("Divine Strike (d8)");
            System.out.println("Divine Strike (d8) added to features");
        }
        if (level ==9){
           CheckVectorAndAdd(spells,"spells","Mass Cure Wounds");
           CheckVectorAndAdd(spells,"spells","Raise Dead");
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
    public void LightDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Burning Hands");
            CheckVectorAndAdd(spells,"spells","Faerie Fire");

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
            CheckVectorAndAdd(spells,"spells","Flaming Sphere");
            CheckVectorAndAdd(spells,"spells","Scorching Ray");


        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Daylight");
            CheckVectorAndAdd(spells,"spells","Fireball");

        }
        if (level == 6 ){
            features.remove("Warden Flare");
            features.add("Improved Warden Flare");
            System.out.println("Improved Warden Flare added to features");
        }
        if (level== 7){
                CheckVectorAndAdd(spells,"spells","Guardian of Faith");
                CheckVectorAndAdd(spells,"spells","Wall of Fire");
        }
        if (level == 8 ){
           features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells","Flame Strike");
            CheckVectorAndAdd(spells,"spells","Scrying");

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
    public void NatureDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Animal Friendship");
            CheckVectorAndAdd(spells,"spells","Speak with Animals");
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have learned 1 Druid Cantrip. What cantrip would you like to learn?");
            Vector<String> druidCantrips = Spells.DruidSpellSetUp(10);
            VectorPrintOut(druidCantrips);
            choice = scanner.nextInt();
            cantrips.add(druidCantrips.get(choice-1));
            System.out.println("You have added " + druidCantrips.get(choice-1) + " to your cantrips");
            druidCantrips.remove(choice-1);
           CheckVectorAndAdd(proficiencies, "proficiencies","Heavy Armor");



        }if (level == 2){
            features.add("Channel Divinity: Charm Animals and Plants");
            System.out.println("Channel Divinity: Charm Animals and Plants added to your features");
        }

        if (level == 3){
            CheckVectorAndAdd(spells,"spells","Barkskin");
            CheckVectorAndAdd(spells,"spells","Spike Growth");

        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Plant Growth");
            CheckVectorAndAdd(spells,"spells","Wind Wall");

        }if (level == 6){
            features.add("Dampen Elements");
            System.out.println("Dampen Elements added to features");
        }if (level==7){
                CheckVectorAndAdd(spells,"spells","Dominate Beast");
                CheckVectorAndAdd(spells,"spells","Grasping Vine");
        }
        if (level == 8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells","Insect Plague");
            CheckVectorAndAdd(spells,"spells","Tree Stride ");

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
    public void TempestDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Fog Cloud");
            CheckVectorAndAdd(spells,"spells","Thunderwave");
            CheckVectorAndAdd(proficiencies,"proficiencies","Martial Weapons");
            CheckVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("Wrath of the Storm");
            System.out.println("Wrath of the Storms added to features");

        }if (level == 2){
            features.add("Channel Divinity: Destructive Wrath");
            System.out.println("Channel Divinity: Destructive Wrath added to features");
        }
        if (level == 3){
            CheckVectorAndAdd(spells,"spells","Gust of Wind");
            CheckVectorAndAdd(spells,"spells","Shatter");

        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Call Lightning");
            CheckVectorAndAdd(spells,"spells","Sleet Storm");

        }if (level == 6){
            features.add("Thunderbolt Strike");
            System.out.println("Thunderbolt Strike added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"spells","Control Water");
            CheckVectorAndAdd(spells,"spells","Ice Storm");

        }
        if (level==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells","Destructive Wave");
            CheckVectorAndAdd(spells,"spells","Insect Plague");
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
    public void TrickeryDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Charm Person");
            CheckVectorAndAdd(spells,"spells","Disguise Self");
            features.add("Blessing of the Trickster");
            System.out.println("Blessing of the Trickster added to features");

        }
        if (level ==2){
            features.add("Channel Divinity: Invoke Duplicity");
            System.out.println("Channel Divinity: Invoke Duplicity added to features");

        }if (level == 3){
            CheckVectorAndAdd(spells,"spells","Mirror Image");
            CheckVectorAndAdd(spells,"spells","Pass Without Trace");


        } if (level == 5){
            CheckVectorAndAdd(spells,"spells","Blink");
            CheckVectorAndAdd(spells,"spells","Dispel Magic");

        }if (level ==6){
            features.add("Channel Divinity: Cloak of Shadows");
            System.out.println("Channel Divinity: Cloak of Shadows added to features");

        }
        if (level==7){
            CheckVectorAndAdd(spells,"spells","Dimension Door");
            CheckVectorAndAdd(spells,"spells","Polymorph");

        }
        if (level ==8){
            features.add("Channel Divinity: Divine Strike (1d8)");
            System.out.println("Channel Divinity: Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells","Dominate Person");
            CheckVectorAndAdd(spells,"spells","Modify Memory");
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
    public void WarDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"spells","Divine Favor");
            CheckVectorAndAdd(spells,"spells","Shield of Faith");
            CheckVectorAndAdd(proficiencies,"proficiencies","Martial Weapons");
            CheckVectorAndAdd(proficiencies,"proficiencies","Heavy Armor");
            features.add("War Priest");
            System.out.println("War Priest added to features");

        }if (level==2){
            features.add("Channel Divinity: Guided Strike");
            System.out.println("Channel Divinity: Guided Strike added to features");

        }
        if (level == 3){
            CheckVectorAndAdd(spells,"spells","Magic Weapon");
            CheckVectorAndAdd(spells,"spells", "Spiritual Weapon");

        } if (level == 5){
            CheckVectorAndAdd(spells,"spells", "Crusader's Mantle");
            CheckVectorAndAdd(spells,"spells", "Spirit Guardians");

        } if (level ==6){
            features.add("Channel Divinity: War God's Blessing");
            System.out.println("Channel Divinity: War God's Blessing added to features");

        }
        if (level==7){
            CheckVectorAndAdd(spells,"spells","Freedom of Movement");
            CheckVectorAndAdd(spells,"spells","Stoneskin");

        }
        if (level ==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");

        }
        if (level ==9){
            CheckVectorAndAdd(spells,"spells", "Flame Strike");
            CheckVectorAndAdd(spells,"spells","Hold Monster");

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

    /**
     * Checks if the contents are already in the vector, if yes nothing happens, if no the contents are added to the vector and prints the contents have been added to the vector.
     * @param vector The vector you are checking/ adding the contents into
     * @param contents String that you are checking/ adding in the vector
     * @param vectorName Name of the vector you are adding the item to
     */
    public void CheckVectorAndAdd(Vector vector,String vectorName, String contents){
        if (!vector.contains(contents)){
            vector.add(contents);
            System.out.println(contents+" added to " + vectorName);
        }

    }

    public void CantripChoice(){
        int choice = 0;
        String endOfLine = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("You learned a new Cantrip! Choose your new Cantrip");
        VectorPrintOut(cantripList);
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = InputErrorCheck(choice,1,cantripList.size());
        cantrips.add(cantripList.get(choice-1));
        System.out.println("You added " + cantripList.get(choice-1) + " to your cantrips");
        cantripList.remove(choice-1);



    }

    public void AbilityScoreImprovement(CharacterSheet character){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to increase 1.) 1 Ability score by +2 or 2.) 2 Ability scores by +1 ");
        int choice = scanner.nextInt();
        String endOfLine = scanner.nextLine();
        while(choice!=1 && choice !=2){
            System.out.println("Incorrect choice. Would you like to increase 1.) 1 Ability score by +2 or 2.) 2 Ability scores by +1");
            choice= scanner.nextInt();
            endOfLine= scanner.nextLine();
        }
        if (choice==1){
            System.out.println("Which Ability score would you like to increase by +2 ?");
            AbilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            while (choice<0 || choice > 6){
                System.out.println("Incorrect choice please select another option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddition(character, choice, 2 );
        }
        if (choice==2){
            System.out.println("Choose your first ability");
            AbilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            while (choice<0 || choice > 6){
                System.out.println("Incorrect choice please select another option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddition(character, choice, 1 );
            System.out.println("What is your second ability?");
            AbilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            while (choice<0 || choice > 6){
                System.out.println("Incorrect choice please select another option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddition(character, choice, 1 );


        }
    }

    // Tested and verfied 9/10
    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void AbilityAddition(CharacterSheet character, int AbilityChoice, int modifierAddtion){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        if (AbilityChoice == 1){
            if(character.getCharismaScore() >= 20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            }else {
                character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
                System.out.println("Charisma +" + modifierAddtion);
                character.setCharismaMod(FindAbilityMod(character.getCharismaScore()));
            }

        }
        if (AbilityChoice == 2){
            if(character.getStrengthScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            }else {
                character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
                System.out.println("Strength +" + modifierAddtion);
                character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
            }

        }
        if (AbilityChoice == 3){
            if(character.getDexterityScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            } else {
                character.setDexterityMod(character.getDexterityMod() + modifierAddtion);
                System.out.println("Dexterity +" + modifierAddtion);
                character.setDexterityMod(FindAbilityMod(character.getDexterityScore()));
            }

        }
        if (AbilityChoice == 4){
            if(character.getWisdomScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            } else{
                character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
                System.out.println("Wisdom +" + modifierAddtion);
                character.setWisdomMod(FindAbilityMod(character.getWisdomScore()));
            }

        }
        if (AbilityChoice == 5){
            if(character.getIntelligenceScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            } else {
                character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
                System.out.println("Intelligence +" + modifierAddtion);
                character.setIntelligenceMod(FindAbilityMod(character.getIntelligenceScore()));
            }

        }
        if (AbilityChoice == 6){
            if(character.getConstitutionScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = InputErrorCheck(choice,1,6);
                AbilityAddition(character, choice, modifierAddtion);
            }else {
                character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
                System.out.println("Constitution +" + modifierAddtion);
                character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));
            }


        }
    }

    public static int FindAbilityMod(int abilityScore) {
        Scanner scanner = new Scanner(System.in);
        Scanner endOfLine = new Scanner(System.in);
        while(abilityScore<0 || abilityScore>30){
            System.out.println("Incorrect Ability Score, please enter correct score between 1 and 30");
            scanner.nextInt();
            endOfLine.nextLine();
        }

        if (abilityScore == 1) {
            return -5;
        }
        if (abilityScore == 2 || abilityScore == 3) {
            return -4;
        }
        if (abilityScore == 4 || abilityScore == 5) {
            return -3;
        }
        if (abilityScore == 6 || abilityScore == 7) {
            return -2;
        }
        if (abilityScore == 8 || abilityScore == 9) {
            return -1;
        }
        if (abilityScore == 10 || abilityScore == 11){
            return 0;
        }
        if (abilityScore == 12 || abilityScore ==13) {
            return 1;
        }
        if (abilityScore == 14 || abilityScore ==15) {
            return 2;
        }
        if (abilityScore == 16 || abilityScore ==17) {
            return 3;
        }
        if (abilityScore == 18 || abilityScore ==19) {
            return 4;
        }
        if (abilityScore == 20 || abilityScore ==21) {
            return 5;
        }
        if (abilityScore == 22 || abilityScore ==23) {
            return 6;
        }
        if (abilityScore == 24 || abilityScore ==25) {
            return 7;
        }
        if (abilityScore == 26 || abilityScore ==27) {
            return 8;
        }
        if (abilityScore == 28 || abilityScore ==29) {
            return 9;
        }
        return 10;

    }



    public static void AbilityChoicePrintout(){
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

    }

    public int inputErrorCheck(int choice, int lowerCheck, int higherCheck){
        Scanner scanner = new Scanner(System.in);
        while (choice < lowerCheck || choice > higherCheck){
            System.out.println("Incorrect option, please choose a different option");
            choice = scanner.nextInt();
            String endofLine = scanner.nextLine();
        }
        return choice;
    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
        }
    }


    // Tested and verified 9/9
    /**
     * To choose the a spell from a specific level
     * @param spellLevel The Level of the spells that they are choosing from
     */
    public void ChooseYourSpell (int spellLevel){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";


        if (spellLevel == 1){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, firstLevelSpells.size());
            System.out.println("You added " + firstLevelSpells.get(choice - 1)+ " to your spells.");
            spells.add(firstLevelSpells.get(choice - 1));
            firstLevelSpells.remove(choice - 1);

        }
        if (spellLevel == 2) {
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);

            System.out.println("Choose your spell.");
            VectorPrintOut(secondLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, secondLevelSpells.size());
            System.out.println("You added " + secondLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(secondLevelSpells.get(choice - 1));
            secondLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 3){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(thirdLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, thirdLevelSpells.size());
            System.out.println("You added " + thirdLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(thirdLevelSpells.get(choice - 1));
            thirdLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 4){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);

            System.out.println("Choose your spell.");
            VectorPrintOut(fourthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, fourthLevelSpells.size());
            System.out.println("You added " + fourthLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(fourthLevelSpells.get(choice - 1));
            fourthLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 5){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(fifthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, fifthLevelSpells.size());
            System.out.println("You added " + fifthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(fifthLevelSpells.get(choice - 1));
            fifthLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 6){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(sixthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, sixthLevelSpells.size());
            System.out.println("You added " + sixthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(sixthLevelSpells.get(choice - 1));
            sixthLevelSpells.remove(choice - 1);
        }

        if (spellLevel == 7){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(seventhLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, seventhLevelSpells.size());
            System.out.println("You added " + seventhLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(seventhLevelSpells.get(choice - 1));
            seventhLevelSpells.remove(choice - 1);

        }

        if (spellLevel == 8){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(eighthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, eighthLevelSpells.size());
            System.out.println("You added " + eighthLevelSpells.get(choice - 1) + " to your spells.");
            spells.add(eighthLevelSpells.get(choice - 1));
            eighthLevelSpells.remove(choice - 1);


        }

        if (spellLevel == 9){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            VectorPrintOut(ninthLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = InputErrorCheck(choice, 1, ninthLevelSpells.size());
            System.out.println("You added " + ninthLevelSpells.get(choice - 1)  + " to your spells.");
            spells.add(ninthLevelSpells.get(choice - 1));
            ninthLevelSpells.remove(choice - 1);
        }
    }

    /**
     * Checks to make sure that the choice from the user does not exceed the lower or upper bounds
     * @param choice Numberic Choice made by user
     * @param lowerCheck The lower bound
     * @param higherCheck The upper bound
     * @return Returns choice once it is a valid option
     */
    public int InputErrorCheck(int choice, int lowerCheck, int higherCheck){
        Scanner scanner = new Scanner(System.in);
        while (choice < lowerCheck || choice > higherCheck){
            System.out.println("Incorrect option, please choose a different option");
            choice = scanner.nextInt();
            String endofLine = scanner.nextLine();
        }
        return choice;
    }

    /**
     *
     * @param inventory Vector of items
     * @param item item you are adding in vector, or adding quantity to already existing item
     */
    public void CheckAndAddItemQuantity(Vector<Item> inventory,Item item){
        int counter =0;
        int i;
        for ( i =0; i< inventory.size();i++){
            if (inventory.get(i).getName().equals(item.getName())){
                inventory.get(i).Addition(item);
                counter++;
                System.out.println("+1 " + inventory.get(i).getName() + " added to inventory | Quantity: " + inventory.get(i).getQuantity());
            }
        }
        if (counter == 0){
            inventory.add(item);
            System.out.println(item.getName() + " added to inventory | Quantity: " + inventory.get(inventory.size()-1).getQuantity());
        }

    }


}
