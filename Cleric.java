package DungeonsAndDragons;

import java.util.Scanner;
import java.util.Vector;

public class Cleric {
    private CharacterSheet character;
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

    //TODO ChooseArmor

    //TODO ChooseWeapon

    //TODO ChooseSkills

    //TODO EquipmentSetUp


public int D8Roll(){
    double randomDouble = Math.random()*8;
    Double randomDouble2 = randomDouble;
    int roll = randomDouble2.intValue();
    return roll;
}

    public void AddLevel(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        level++;


        if (level == 1){
            System.out.println("Proficiency Bonus : " + proficiency);
            character.setHitPoints(8 + character.getConstitutionMod());
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
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

//            TODO Create Methods for each domain for each level call.
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


        }if (level == 11){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);

        }if (level == 12){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());

        }if (level == 13){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);

        }if (level == 14){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            FindDomain(domainChoice,14);
        }if (level == 15){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(8);

        }if (level == 16){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());

        }if (level == 17){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(9);
            FindDomain(domainChoice,17);

        }if (level == 18){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(5);

        }if (level == 19){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);

        }if (level == 20){
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);

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

    // TODO Finish Domain Levels and Such

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


            SpellCheckAndAdd("Command");
            SpellCheckAndAdd("Identify");

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
            SpellCheckAndAdd("Augury");
            SpellCheckAndAdd("Suggestion");

        } if (level == 5){
            SpellCheckAndAdd("Nondetection");
            SpellCheckAndAdd("Speak with Dead");
        } if (level == 6){
            features.add("Channel Divinity: Read Thoughts");
            System.out.println("Channel Divinity: Read Thoughts added to features");
        }
        if (level==7){
            SpellCheckAndAdd("Arcane Eye");
            SpellCheckAndAdd("Confusion");

        }
        if (level == 8){
            features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            SpellCheckAndAdd("Legend Lore");
            SpellCheckAndAdd("Scrying");

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
            SpellCheckAndAdd("Bless");
            SpellCheckAndAdd("Cure Wounds");
            features.add("Proficiency : Heavy Armor");
            features.add("Disciple of Life");
            System.out.println("Proficiency : Heavy Armor and Disciple of Life added to features");

        } if (level == 2){
            features.add("Channel Divinity: Preserve Life");
        }
        if (level == 3){
           SpellCheckAndAdd("Lesser Restoration");
            SpellCheckAndAdd("Spiritual Weapon");

        } if (level == 5){
            SpellCheckAndAdd("Beacon of Hope");
            SpellCheckAndAdd("Revivify");

        }if (level ==6 ){
            features.add("Blessed Healer");
            System.out.println("Blessed Healer added to features");
        }
        if (level==7){
            SpellCheckAndAdd("Death Ward");
            SpellCheckAndAdd("Guardian of Faith");

        }
        if (level==8){
            features.add("Divine Strike (d8)");
            System.out.println("Divine Strike (d8) added to features");
        }
        if (level ==9){
           SpellCheckAndAdd("Mass Cure Wounds");
           SpellCheckAndAdd("Raise Dead");
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
            SpellCheckAndAdd("Burning Hands");
            SpellCheckAndAdd("Faerie Fire");

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
            SpellCheckAndAdd("Flaming Sphere");
            SpellCheckAndAdd("Scorching Ray");


        } if (level == 5){
            SpellCheckAndAdd("Daylight");
            SpellCheckAndAdd("Fireball");

        }
        if (level == 6 ){
            features.remove("Warden Flare");
            features.add("Improved Warden Flare");
            System.out.println("Improved Warden Flare added to features");
        }
        if (level== 7){
                SpellCheckAndAdd("Guardian of Faith");
                SpellCheckAndAdd("Wall of Fire");
        }
        if (level == 8 ){
           features.add("Potent Spellcasting");
            System.out.println("Potent Spellcasting added to features");
        }
        if (level ==9){
            SpellCheckAndAdd("Flame Strike");
            SpellCheckAndAdd("Scrying");

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
            SpellCheckAndAdd("Animal Friendship");
            SpellCheckAndAdd("Speak with Animals");
            int choice;
            Scanner scanner = new Scanner(System.in);
            System.out.println("You have learned 1 Druid Cantrip. What cantrip would you like to learn?");
            Vector<String> druidCantrips = Spells.DruidSpellSetUp(10);
            VectorPrintOut(druidCantrips);
            choice = scanner.nextInt();
            cantrips.add(druidCantrips.get(choice-1));
            System.out.println("You have added " + druidCantrips.get(choice-1) + " to your cantrips");
            druidCantrips.remove(choice-1);
            proficiencies.add("Heavy Armor");
            System.out.println("You have added heavy armor to your proficiencies! ");


        }if (level == 2){
            features.add("Channel Divinity: Charm Animals and Plants");
            System.out.println("Channel Divinity: Charm Animals and Plants added to your features");
        }

        if (level == 3){
            SpellCheckAndAdd("Barkskin");
            SpellCheckAndAdd("Spike Growth");

        } if (level == 5){
            SpellCheckAndAdd("Plant Growth");
            SpellCheckAndAdd("Wind Wall");

        }if (level == 6){
            features.add("Dampen Elements");
            System.out.println("Dampen Elements added to features");
        }if (level==7){
                SpellCheckAndAdd("Dominate Beast");
                SpellCheckAndAdd("Grasping Vine");
        }
        if (level == 8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            SpellCheckAndAdd("Insect Plague");
            SpellCheckAndAdd("Tree Stride ");

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
            SpellCheckAndAdd("Fog Cloud");
            SpellCheckAndAdd("Thunderwave");
            proficiencies.add("Martial Weapons");
            proficiencies.add("Heavy Armor");
            System.out.println("Martial Weapons and Heavy Armor have been added to Proficiencies");
            features.add("Wrath of the Storm");
            System.out.println("Wrath of the Storms added to features");

        }if (level == 2){
            features.add("Channel Divinity: Destructive Wrath");
            System.out.println("Channel Divinity: Destructive Wrath added to features");
        }
        if (level == 3){
            SpellCheckAndAdd("Gust of Wind");
            SpellCheckAndAdd("Shatter");

        } if (level == 5){
            SpellCheckAndAdd("Call Lightning");
            SpellCheckAndAdd("Sleet Storm");

        }if (level == 6){
            features.add("Thunderbolt Strike");
            System.out.println("Thunderbolt Strike added to features");
        }
        if (level==7){
            SpellCheckAndAdd("Control Water");
            SpellCheckAndAdd("Ice Storm");

        }
        if (level==8){
            features.add("Divine Strike (1d8)");
            System.out.println("Divine Strike (1d8) added to features");
        }
        if (level ==9){
            SpellCheckAndAdd("Destructive Wave");
            SpellCheckAndAdd("Insect Plague");
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
    //TODO Stopped here
    /**
     * If character chose Trickery Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void TrickeryDomain (int level){
        if (level ==1){

        }if (level == 3){

        } if (level == 5){

        }if (level==7){

        }
        if (level ==9){

        }
    }
    /**
     * If character chose War Domain, it will apply what's needed for that level.
     * @param level Level that the character is currently at
     */
    public void WarDomain (int level){
        if (level ==1){

        }if (level == 3){

        } if (level == 5){

        }if (level==7){

        }
        if (level ==9){

        }
    }

    public void SpellCheckAndAdd(String spellName){
        if (!spells.contains(spellName)){
            spells.add(spellName);
            System.out.println(spellName+" added to spells");
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


}
