package DungeonsAndDragons;

import sun.java2d.InvalidPipeException;

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

    //TODO Add all proficiencies to vector
    Vector<String> proficiencies = new Vector<>();


    public Cleric(CharacterSheet character){
        this.character = character;
    }

    //TODO Test Out Method
    public void ChooseArmor(){
        Scanner scanner = new Scanner(System.in);
        String endOfLine ="";

        System.out.println("You are proficient in Light Armor, Medium Armor, and Shields");
        for(int i = 0; i <(character.getLightArmor().length + character.getMediumArmor().length); i++){
            if(i< character.getLightArmor().length){
                System.out.println(i+1+".)"+character.getLightArmor()[i]);
            }
            if (i>character.getLightArmor().length){
                System.out.println(i+1 +".)"+character.getMediumArmor()[i-character.getLightArmor().length]);
            }

        }
        int choice = scanner.nextInt();
        String endLine = scanner.nextLine();

        choice= InputErrorCheck(choice,1,character.getLightArmor().length + character.getMediumArmor().length);

        if(choice < character.getLightArmor().length){
            System.out.println("You have chosen " + character.getLightArmor()[choice-1]);
            character.setArmor(character.getLightArmor()[choice-1]);
            character.setAc(character.getLightArmorAC()[choice-1]);
        } if(choice > character.getLightArmor().length){
            System.out.println("You have chosen "  + character.getMediumArmor()[choice - character.getLightArmor().length - 1]);
            character.setArmor(character.getMediumArmor()[choice-character.getLightArmor().length - 1]);
            character.setAc(character.getMediumArmorAC()[choice-character.getLightArmor().length - 1]);

        }


    }

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
            CheckVectorAndAdd(character.weapons,"Mace");
            }if (choice==2){
                CheckVectorAndAdd(character.weapons, "Warhammer");
            }
        }else {
            CheckVectorAndAdd(character.weapons,"Mace");
        }

        if (proficiencies.contains("Chain Mail")){

            System.out.println("Choose an armor. 1.) Scale Mail 2.) Leather Armor or 3.) Chain Mail.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice=InputErrorCheck(choice,1,2);
            if (choice==1){
                CheckVectorAndAdd(character.armorList,"Scale Mail");
            }if (choice==2){
                CheckVectorAndAdd(character.armorList,"Leather Armor");
            }
            if (choice==3){
                CheckVectorAndAdd(character.armorList,"Chain Mail");
            }

        }else {
            System.out.println("Choose an armor. 1.) Scale Mail or 2.) Leather Armor.");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice=InputErrorCheck(choice,1,2);
            if (choice==1){
                CheckVectorAndAdd(character.armorList,"Scale Mail");
            }if (choice==2){
                CheckVectorAndAdd(character.armorList,"Leather Armor");
            }

        }

        System.out.println("Choose a weapon. 1.) Light Crossbow and 20 Bolts oe 2.) Any Simple Weapon.");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice=InputErrorCheck(choice,1,2);
        if (choice==1){
            CheckVectorAndAdd(character.weapons,"Light Crossbow");
            character.inventory.add("20 Bolts");
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
                CheckVectorAndAdd(character.weapons,character.getSimpleMeleeWeapons()[choice-1]);

            }if (choice>= character.getSimpleMeleeWeapons().length){
                CheckVectorAndAdd(character.weapons, character.getSimpleRangedWeapons()[choice-1-character.getSimpleMeleeWeapons().length]);
            }

        }

        System.out.println("Choose your pack. 1.)Priest's Pack or 2.) Explorer's Pack");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice=InputErrorCheck(choice,1,2);
        if (choice==1){
            pack="Priest";
            character.inventory.add("Backpack");
            character.inventory.add("Blanket");
            character.inventory.add("Candles : x10");
            character.inventory.add("Tinderbox");
            character.inventory.add("Alms Box");
            character.inventory.add("Blocks of Incense : x2");
            character.inventory.add("Censer");
            character.inventory.add("Vestments");
            character.inventory.add("Rations : x2");
            character.inventory.add("Waterskin");
            System.out.println("Backpack, Bedroll, Candles : x10, Tinderbox, Alms Box, Blocks of Incense : x2, Censer, Vestments, Rations : x2, and Waterskin added to inventory. ");

        }if (choice==2){
            pack="Explorer";
            character.inventory.add("Backpack");
            character.inventory.add("Bedroll");
            character.inventory.add("Mess Kit");
            character.inventory.add("Tinderbox");
            character.inventory.add("Torches : x10");
            character.inventory.add("Rations : x10");
            character.inventory.add("Waterskin");
            character.inventory.add("Hempen Rope : 50 ft");
            System.out.println("Backpack, Bedroll, Mess Kit, Tinderbox, Torches : x10, Rations : x10, Waterskin, and Hempen Rope : 50 ft added to inventory. ");
        }
        character.setShield(true);
        character.inventory.add("Shield");
        character.inventory.add("Holy Symbol");

        System.out.println("Shield and Holy Symbol added to inventory.");

        System.out.println("Would you like to equip your shield? 1.) Yes or 2.) No ?");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = InputErrorCheck(choice,1,2);
        if (choice==1){
            character.setAc(character.getAc() +2);
        }


    }


    //TODO test method

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
            CheckVectorAndAdd(proficiencies,tempskills.get(choice-1));
            tempskills.remove(choice-1);
        }

    }



public int D8Roll(){
    double randomDouble = Math.random()*8;
    Double randomDouble2 = randomDouble;
    int roll = randomDouble2.intValue();
    return roll;
}
//TODO Finish
    public void AddLevel(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        level++;


        if (level == 1){
            System.out.println("Proficiency Bonus : " + proficiency);
            character.setHitPoints(8 + character.getConstitutionMod());
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            CheckVectorAndAdd(proficiencies,"Light Armor");
            CheckVectorAndAdd(proficiencies,"Medium Armor");
            CheckVectorAndAdd(proficiencies,"Shields");
            CheckVectorAndAdd(proficiencies,"Simple Weapons");
            CheckVectorAndAdd(proficiencies,"Wisdom");
            CheckVectorAndAdd(proficiencies,"Charisma");
            cantripList.setSize(3);
            for (int i = 0 ; i<2; i++){
                ChooseYourSpell(1);
            }
            for (int i = 0 ; i<3 ; i++){
                CantripChoice();
            }

            System.out.println("Choose your Divine Domain");
            for(int i = 0; i < domains.length; i++){
                System.out.println(i+".) " + domains[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            domainChoice = choice -1;
            System.out.println("You have chosen domain " + domains[domainChoice]);
            FindDomain(domainChoice,1);




        }if (level == 2){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(1);
            FindDomain(domainChoice,2);

        }if (level == 3){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(1);
            for (int i = 0 ; i<2 ; i++){
                ChooseYourSpell(2);
            }
            FindDomain(domainChoice,3);

        }if (level == 4){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(2);
            CantripChoice();
            FindDomain(domainChoice,4);

        }if (level == 5){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for(int i = 0; i<2 ;i++){
                ChooseYourSpell(3);
            }
            FindDomain(domainChoice,5);

        }if (level == 6){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(3);
            FindDomain(domainChoice,6);

        }if (level == 7){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            FindDomain(domainChoice,7);

        }if (level == 8){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            FindDomain(domainChoice,8);

        }if (level == 9){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);
            ChooseYourSpell(5);
            FindDomain(domainChoice,9);

        }if (level == 10){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(5);
            CantripChoice();
            FindDomain(domainChoice,10);


        }if (level == 11){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);
            FindDomain(domainChoice,11);

        }if (level == 12){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,12);

        }if (level == 13){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);
            FindDomain(domainChoice,13);

        }if (level == 14){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,14);
        }if (level == 15){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(8);
            FindDomain(domainChoice,15);

        }if (level == 16){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,16);

        }if (level == 17){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(9);
            FindDomain(domainChoice,17);

        }if (level == 18){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(5);
            FindDomain(domainChoice,18);

        }if (level == 19){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);
            FindDomain(domainChoice,19);

        }if (level == 20){
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


    /**
     * If character chose Knowledge Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void KnowledgeDomain (int level){
        String choice;
        int numChoice;
        Scanner scanner = new Scanner(System.in);
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


            CheckVectorAndAdd(spells,"Command");
            CheckVectorAndAdd(spells,"Identify");

            Vector<String> divineSkills = new Vector<>();
            divineSkills.add("Arcana");
            divineSkills.add("History");
            divineSkills.add("Nature");
            divineSkills.add("Religion");
            System.out.println("You can become proficient in two skills. Choose your first skill");
            VectorPrintOut(divineSkills);
            numChoice = scanner.nextInt();
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
            CheckVectorAndAdd(spells,"Augury");
            CheckVectorAndAdd(spells,"Suggestion");

        } if (level == 5){
            CheckVectorAndAdd(spells,"Nondetection");
            CheckVectorAndAdd(spells,"Speak with Dead");
        } if (level == 6){
            features.add("Channel Divinity: Read Thoughts");
            System.out.println("Channel Divinity: Read Thoughts added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"Arcane Eye");
            CheckVectorAndAdd(spells,"Confusion");

        }
        if (level == 8){
            features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"Legend Lore");
            CheckVectorAndAdd(spells,"Scrying");

        }
        if (level ==17){
            features.add("Visions of the Past");
            System.out.println("Features of the Past added to features");
        }
    }
    /**
     * If character chose Life Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void LifeDomain (int level){
        if (level ==1){
            CheckVectorAndAdd(spells,"Bless");
            CheckVectorAndAdd(spells,"Cure Wounds");
            CheckVectorAndAdd(proficiencies,"Heavy Armor");
            features.add("Disciple of Life");

        } if (level == 2){
            features.add("Channel Divinity: Preserve Life");
        }
        if (level == 3){
           CheckVectorAndAdd(spells,"Lesser Restoration");
            CheckVectorAndAdd(spells,"Spiritual Weapon");

        } if (level == 5){
            CheckVectorAndAdd(spells,"Beacon of Hope");
            CheckVectorAndAdd(spells,"Revivify");

        }if (level ==6 ){
            features.add("Blessed Healer");
            System.out.println("Blessed Healer added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"Death Ward");
            CheckVectorAndAdd(spells,"Guardian of Faith");

        }
        if (level==8){
            features.add("Divine Strike (d8)");
            System.out.println("Divine Strike (d8) added to features");
        }
        if (level ==9){
           CheckVectorAndAdd(spells,"Mass Cure Wounds");
           CheckVectorAndAdd(spells,"Raise Dead");
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
            CheckVectorAndAdd(spells,"Burning Hands");
            CheckVectorAndAdd(spells,"Faerie Fire");

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
            CheckVectorAndAdd(spells,"Flaming Sphere");
            CheckVectorAndAdd(spells,"Scorching Ray");


        } if (level == 5){
            CheckVectorAndAdd(spells,"Daylight");
            CheckVectorAndAdd(spells,"Fireball");

        }
        if (level == 6 ){
            features.remove("Warden Flare");
            features.add("Improved Warden Flare");
            System.out.println("Improved Warden Flare added to features");
        }
        if (level== 7){
                CheckVectorAndAdd(spells,"Guardian of Faith");
                CheckVectorAndAdd(spells,"Wall of Fire");
        }
        if (level == 8 ){
           features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"Flame Strike");
            CheckVectorAndAdd(spells,"Scrying");

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
            CheckVectorAndAdd(spells,"Animal Friendship");
            CheckVectorAndAdd(spells,"Speak with Animals");
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have learned 1 Druid Cantrip. What cantrip would you like to learn?");
            Vector<String> druidCantrips = Spells.DruidSpellSetUp(10);
            VectorPrintOut(druidCantrips);
            choice = scanner.nextInt();
            cantrips.add(druidCantrips.get(choice-1));
            System.out.println("You have added " + druidCantrips.get(choice-1) + " to your cantrips");
            druidCantrips.remove(choice-1);
           CheckVectorAndAdd(proficiencies, "Heavy Armor");



        }if (level == 2){
            features.add("Channel Divinity: Charm Animals and Plants");
            System.out.println("Channel Divinity: Charm Animals and Plants added to your features");
        }

        if (level == 3){
            CheckVectorAndAdd(spells,"Barkskin");
            CheckVectorAndAdd(spells,"Spike Growth");

        } if (level == 5){
            CheckVectorAndAdd(spells,"Plant Growth");
            CheckVectorAndAdd(spells,"Wind Wall");

        }if (level == 6){
            features.add("Dampen Elements");
            System.out.println("Dampen Elements added to features");
        }if (level==7){
                CheckVectorAndAdd(spells,"Dominate Beast");
                CheckVectorAndAdd(spells,"Grasping Vine");
        }
        if (level == 8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"Insect Plague");
            CheckVectorAndAdd(spells,"Tree Stride ");

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
            CheckVectorAndAdd(spells,"Fog Cloud");
            CheckVectorAndAdd(spells,"Thunderwave");
            CheckVectorAndAdd(proficiencies,"Martial Weapons");
            CheckVectorAndAdd(proficiencies,"Heavy Armor");
            features.add("Wrath of the Storm");
            System.out.println("Wrath of the Storms added to features");

        }if (level == 2){
            features.add("Channel Divinity: Destructive Wrath");
            System.out.println("Channel Divinity: Destructive Wrath added to features");
        }
        if (level == 3){
            CheckVectorAndAdd(spells,"Gust of Wind");
            CheckVectorAndAdd(spells,"Shatter");

        } if (level == 5){
            CheckVectorAndAdd(spells,"Call Lightning");
            CheckVectorAndAdd(spells,"Sleet Storm");

        }if (level == 6){
            features.add("Thunderbolt Strike");
            System.out.println("Thunderbolt Strike added to features");
        }
        if (level==7){
            CheckVectorAndAdd(spells,"Control Water");
            CheckVectorAndAdd(spells,"Ice Storm");

        }
        if (level==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"Destructive Wave");
            CheckVectorAndAdd(spells,"Insect Plague");
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
            CheckVectorAndAdd(spells,"Charm Person");
            CheckVectorAndAdd(spells,"Disguise Self");
            features.add("Blessing of the Trickster");
            System.out.println("Blessing of the Trickster added to features");

        }
        if (level ==2){
            features.add("Channel Divinity: Invoke Duplicity");
            System.out.println("Channel Divinity: Invoke Duplicity added to features");

        }if (level == 3){
            CheckVectorAndAdd(spells,"Mirror Image");
            CheckVectorAndAdd(spells,"Pass Without Trace");


        } if (level == 5){
            CheckVectorAndAdd(spells,"Blink");
            CheckVectorAndAdd(spells,"Dispel Magic");

        }if (level ==6){
            features.add("Channel Divinity: Cloak of Shadows");
            System.out.println("Channel Divinity: Cloak of Shadows added to features");

        }
        if (level==7){
            CheckVectorAndAdd(spells,"Dimension Door");
            CheckVectorAndAdd(spells,"Polymorph");

        }
        if (level ==8){
            features.add("Channel Divinity: Divine Strike (1d8)");
            System.out.println("Channel Divinity: Divine Strike (1d8) added to features");
        }
        if (level ==9){
            CheckVectorAndAdd(spells,"Dominate Person");
            CheckVectorAndAdd(spells,"Modify Memory");
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
            CheckVectorAndAdd(spells,"Divine Favor");
            CheckVectorAndAdd(spells,"Shield of Faith");
            CheckVectorAndAdd(proficiencies,"Martial Weapons");
            CheckVectorAndAdd(proficiencies,"Heavy Armor");
            features.add("War Priest");
            System.out.println("War Priest added to features");

        }if (level==2){
            features.add("Channel Divinity: Guided Strike");
            System.out.println("Channel Divinity: Guided Strike added to features");

        }
        if (level == 3){
            CheckVectorAndAdd(spells,"Magic Weapon");
            CheckVectorAndAdd(spells, "Spiritual Weapon");

        } if (level == 5){
            CheckVectorAndAdd(spells, "Crusader's Mantle");
            CheckVectorAndAdd(spells, "Spirit Guardians");

        } if (level ==6){
            features.add("Channel Divinity: War God's Blessing");
            System.out.println("Channel Divinity: War God's Blessing added to features");

        }
        if (level==7){
            CheckVectorAndAdd(spells,"Freedom of Movement");
            CheckVectorAndAdd(spells,"Stoneskin");

        }
        if (level ==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");

        }
        if (level ==9){
            CheckVectorAndAdd(spells, "Flame Strike");
            CheckVectorAndAdd(spells,"Hold Monster");

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
     */
    public void CheckVectorAndAdd(Vector vector, String contents){
        if (!vector.contains(contents)){
            vector.add(contents);
            System.out.println(contents+" added to " + vector);
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
        cantrips.add(cantripList.get(choice-1));
        cantripList.remove(choice-1);



    }

    public static void AbilityScoreImprovement(CharacterSheet character){
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
            AbilityAddtion(character, choice, 2 );
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
            AbilityAddtion(character, choice, 1 );
            System.out.println("What is your second ability?");
            AbilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            while (choice<0 || choice > 6){
                System.out.println("Incorrect choice please select another option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddtion(character, choice, 1 );


        }
    }

    public static void AbilityAddtion(CharacterSheet character, int choice, int modifierAddtion){
        Scanner scanner = new Scanner(System.in);
        if (choice == 1){
            if(character.getCharismaScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();

                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma +" + modifierAddtion);
            character.setCharismaMod(FindAbilityMod(character.getCharismaScore()));
        }
        if (choice == 2){
            if(character.getStrengthScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength +" + modifierAddtion);
            character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
        }
        if (choice == 3){
            if(character.getDexterityScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setDexterityMod(character.getDexterityMod() + modifierAddtion);
            System.out.println("Dexterity +" + modifierAddtion);
            character.setDexterityMod(FindAbilityMod(character.getDexterityScore()));
        }
        if (choice == 4){
            if(character.getWisdomScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom +" + modifierAddtion);
            character.setWisdomMod(FindAbilityMod(character.getWisdomScore()));
        }
        if (choice == 5){
            if(character.getIntelligenceScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence +" + modifierAddtion);
            character.setIntelligenceMod(FindAbilityMod(character.getIntelligenceScore()));
        }
        if (choice == 6){
            if(character.getConstitutionScore() >20){
                System.out.println("Ability score is Greater than 20. Please choose a different option.");
                AbilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                while (choice <0 || choice >6){
                    System.out.println("Incorrect Choice. Please choose a different option.");
                    AbilityChoicePrintout();
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                AbilityAddtion(character, choice, modifierAddtion);
            }
            character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution +" + modifierAddtion);
            character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));

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


    public void ChooseYourSpell (int spellLevel){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";


        if (spellLevel == 1){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(firstLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, firstLevelSpells.size());
                System.out.println("You added " + firstLevelSpells.get(choice - 1));
                spells.add(firstLevelSpells.get(choice - 1));
                firstLevelSpells.remove(choice - 1);

            }

        }
        if (spellLevel == 2) {
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(secondLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, secondLevelSpells.size());
                System.out.println("You added " + secondLevelSpells.get(choice - 1));
                spells.add(secondLevelSpells.get(choice - 1));
                secondLevelSpells.remove(choice - 1);

            }
        }

        if (spellLevel == 3){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(thirdLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, thirdLevelSpells.size());
                System.out.println("You added " + thirdLevelSpells.get(choice - 1));
                spells.add(thirdLevelSpells.get(choice - 1));
                thirdLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 4){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(fourthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, fourthLevelSpells.size());
                System.out.println("You added " + fourthLevelSpells.get(choice - 1));
                spells.add(fourthLevelSpells.get(choice - 1));
                fourthLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 5){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(fifthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, fifthLevelSpells.size());
                System.out.println("You added " + fifthLevelSpells.get(choice - 1));
                spells.add(fifthLevelSpells.get(choice - 1));
                fifthLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 6){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(sixthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, sixthLevelSpells.size());
                System.out.println("You added " + sixthLevelSpells.get(choice - 1));
                spells.add(sixthLevelSpells.get(choice - 1));
                sixthLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 7){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(seventhLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, seventhLevelSpells.size());
                System.out.println("You added " + seventhLevelSpells.get(choice - 1));
                spells.add(seventhLevelSpells.get(choice - 1));
                seventhLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 8){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(eighthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, eighthLevelSpells.size());
                System.out.println("You added " + eighthLevelSpells.get(choice - 1));
                spells.add(eighthLevelSpells.get(choice - 1));
                eighthLevelSpells.remove(choice - 1);

            }

        }

        if (spellLevel == 9){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            if (choice == 1) {
                System.out.println("Choose your spell.");
                VectorPrintOut(ninthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, ninthLevelSpells.size());
                System.out.println("You added " + ninthLevelSpells.get(choice - 1));
                spells.add(ninthLevelSpells.get(choice - 1));
                ninthLevelSpells.remove(choice - 1);

            }

        }

        while(spellLevel<1 || spellLevel>9){
            System.out.println("Incorrect Spell Level, please choose a different level");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            ChooseYourSpell(choice);
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


}
