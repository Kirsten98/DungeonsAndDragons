package DungeonsAndDragons;

import java.util.Scanner;
import java.util.Vector;

public class Bard {
    public Bard(CharacterSheet character){
        this.character = character;
    }


    private CharacterSheet character;
    private int hitDice = 8;
    private int proficiency=2;
    private Vector<String> features = new Vector();
    private int level = 0;
    private Vector<String> spells = new Vector<>();
    private  Vector<String> cantrips = new Vector<>();
    private String pack;
    private String college;
    private int spellSaveDC;
    private int spellAttackMod;
    Vector<String> cantripList = Spells.BardSpellSetUp(10);
    Vector<String> firstLevelSpells = Spells.BardSpellSetUp(1);
    Vector<String> secondLevelSpells = Spells.BardSpellSetUp(2);
    Vector<String> thirdLevelSpells = Spells.BardSpellSetUp(3);
    Vector<String> fourthLevelSpells = Spells.BardSpellSetUp(4);
    Vector<String> fifthLevelSpells = Spells.BardSpellSetUp(5);
    Vector<String> sixthLevelSpells = Spells.BardSpellSetUp(6);
    Vector<String> seventhLevelSpells = Spells.BardSpellSetUp(7);
    Vector<String> eighthLevelSpells = Spells.BardSpellSetUp(8);
    Vector<String> ninthLevelSpells = Spells.BardSpellSetUp(9);

    Vector<String> allCantrips = Spells.AllClassSpellSetUp(10);
    Vector<String> allFirstLevelSpells = Spells.AllClassSpellSetUp(1);
    Vector<String> allSecondLevelSpells = Spells.AllClassSpellSetUp(2);
    Vector<String> allThirdLevelSpells = Spells.AllClassSpellSetUp(3);
    Vector<String> allFourthLevelSpells = Spells.AllClassSpellSetUp(4);
    Vector<String> allFifthLevelSpells = Spells.AllClassSpellSetUp(5);
    Vector<String> allSixthLevelSpells = Spells.AllClassSpellSetUp(6);
    Vector<String> allSeventhLevelSpells = Spells.AllClassSpellSetUp(7);
    Vector<String> allEighthLevelSpells= Spells.AllClassSpellSetUp(8);
    Vector<String> allNinthLevelSpells = Spells.AllClassSpellSetUp(9);

    //TODO Add all proficiencies to vector
    Vector<String> proficiencies = new Vector<>();


    //TODO Test DungeonsAndDragons.Spells

    /**
     * Randomly Generates a number between 1 and 8. Simulating a D8
     * @return Random Number between 1 and 8
     */
    public int D8Roll(){
        double randomDouble = Math.random()*8;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }

    /**
     * Walks user through on adding their Weapons / Equipment ot the character
     */
    public void ChooseWeapon(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        System.out.println("Choose your equipment 1.)Rapier 2.)Longsword or 3.)any simple weapon?");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice, 1,3);
        if(choice==1){
            character.weapons.add("Rapier");
            System.out.println("Rapier added to Weapons");
        }if(choice ==2){
            character.weapons.add("Longsword");
            System.out.println("Longsword added to Weapons");
        }if (choice == 3){
            System.out.println("Which Simple Melee Weapon do you choose?");
            for (int i = 0; i < character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length; i++) {
                if (i < character.getSimpleMeleeWeapons().length){
                    System.out.println( i+1 + ".) " + character.getSimpleMeleeWeapons()[i]);
                }
                if (i > character.getSimpleMeleeWeapons().length){
                    System.out.println(i+1 + ".) " + character.getSimpleRangedWeapons()[i-character.getSimpleMeleeWeapons().length]);
                }
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length);
            if (choice < character.getSimpleMeleeWeapons().length){
                System.out.println("You have chosen " + character.getSimpleMeleeWeapons()[choice-1] );
            }
            if (choice>character.getSimpleMeleeWeapons().length){
                System.out.println("You have chosen " + character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1]);
            }
        }

        System.out.println("Do you want 1.)Diplomat's pack or 2.)Entertainer's pack");
        choice=scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,2);
        if(choice == 1){
            pack = "Diplomat";
            character.inventory.add("Chest");
            character.inventory.add("Case (for maps/scrolls) : x2");
            character.inventory.add("Set of Fine Clothes");
            character.inventory.add("Bottle of ink");
            character.inventory.add("Ink pen");
            character.inventory.add("Lamp");
            character.inventory.add("Flask of oil : x2");
            character.inventory.add("Sheets of Paper  : x5");
            character.inventory.add("Vial of perfume");
            character.inventory.add("Sealing Wax");
            character.inventory.add("Soap");
            System.out.println("Chest, Case (for maps/scrolls) : x2, Set of Fine Clothes, Bottle of ink, Ink pen, Lamp, Flask of oil : x2, Sheets of Paper  : x5, Vial of perfume, Sealing Wax, and Soap added to inventory.");

        }if (choice ==2){
            pack = "Entertainer";
            character.inventory.add("Backpack");
            character.inventory.add("Bedroll");
            character.inventory.add("Costumes : x2");
            character.inventory.add("Candles : x5");
            character.inventory.add("Rations : x5");
            character.inventory.add("Waterskin");
            character.inventory.add("Disguise kit");
            System.out.println("Backpack, Bedroll, Costumes : x2, Candles : x5, Rations : x5, Waterskin, and Disguise kit added to inventory.");

        }

        System.out.println("Do you want 1.)Lute or 2.) any other musical instrument");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice ,1,2);
        if (choice == 1){
            character.instruments.add("Lute");
            System.out.println("Lute added to instruments");
        }
        if (choice ==2){
            System.out.println("Choose your instrument");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
            character.instruments.add(character.getMusicalInstruments()[choice-1]);
            System.out.println(character.getMusicalInstruments()[choice-1] + " added to your instruments");
        }

        System.out.println("Leather Armor and a dagger have been added to your inventory");
        character.armorList.add("Leather");
        character.weapons.add("Dagger");
    }

    /**
     * Adds Levels and related information to the character.
     */
    public void AddLevel(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";
        level++;

        spellSaveDC = 8 + proficiency + character.getCharismaMod();
        spellAttackMod= proficiency + character.getCharismaMod();

        if(level == 1){
            System.out.println("Level 1");
            cantrips.setSize(2);
            spells.setSize(4);
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints( 8 + character.getConstitutionMod());
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.add("Spellcasting");
            features.add("Bardic Inspiration (d6)");
            System.out.println("Spellcasting and Bardic Inspiration (d6) added to features");
            System.out.println("You have learned 2 Cantrips and 4 First level spells. Please choose your first Cantrip");
            VectorPrintOut(cantripList);
            choice=scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
            System.out.println("Please choose your second cantrip");
            VectorPrintOut(cantripList);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
            System.out.println("Please choose your first First Level Spell");
            VectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,firstLevelSpells.size());
            System.out.println("You chose " + firstLevelSpells.get(choice -1 ));
            spells.add(firstLevelSpells.get(choice-1));
            firstLevelSpells.remove(choice -1);
            System.out.println("Please choose your second First Level Spell");
            VectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,firstLevelSpells.size());
            System.out.println("You chose " + firstLevelSpells.get(choice -1 ));
            spells.add(firstLevelSpells.get(choice-1));
            firstLevelSpells.remove(choice -1);


        }
        if(level == 2){
            System.out.println("Level 2");
            spells.setSize(5);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(1);
            features.add("Jack of All Trades");
            features.add("Song of Rest (d6)");
            System.out.println("Jack of All Trades and Song of Rest(d6) added to features");

        }
        if(level == 3){
            System.out.println("Level 3");
            spells.setSize(6);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.add("Expertise");
            ChooseYourSpell(1);
            for (int i = 0 ; i <2 ; i++){
                ChooseYourSpell(2);
            }
            System.out.println("Choose your DungeonsAndDragons.Bard College 1.) College of Lore or 2.) College of Valor . ");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,2);
            if (choice ==1){
                features.add("DungeonsAndDragons.Bard College : College of Lore");
                college = "College of Lore";
                System.out.println("DungeonsAndDragons.Bard College : College of Lore and Expertise added to features");
            }if(choice == 2){
                features.add("DungeonsAndDragons.Bard College : College of Valor");
                college = "College of Valor";
                System.out.println("DungeonsAndDragons.Bard College : College of Valor and Expertise added to features");
            }
        }
        if(level == 4){
            System.out.println("Level 4");
            spells.setSize(7);
            cantrips.setSize(4);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("You learned a new Cantrip, please choose your new cantrip");
            VectorPrintOut(cantripList);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);

            ChooseYourSpell(2);

            AbilityScoreImprovement(character);

        }
        if(level == 5){
            System.out.println("Level 5");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            spells.setSize(8);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for (int i = 0 ; i<2 ; i++){
                ChooseYourSpell(3);
            }

            features.remove("Bardic Inspiration (d6)");
            features.add("Bardic Inspiration (d8)");
            features.add("Font of Inspiration");
            System.out.println("Bardic Inspiration (d6) and Font of Inspiration added to features");

        }
        if(level == 6){
            System.out.println("Level 6");
            spells.setSize(9);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(3);
            features.add("Countercharm");
            if (college.equals("College of Lore")){
                features.add("Additional Magical Secrets");
                System.out.println("Countercharm and Additional Magical Secrets added to features");
                for (int i = 0 ; i<2 ; i++){
                    MagicalSecrects(3);
                }

            }
            if (college.equals("College of Valor")){
                features.add("Extra Attack");
                System.out.println("Countercharm and Extra Attack added to features");
            }

        }
        if(level == 7){
            System.out.println("Level 7");
            spells.setSize(10);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);

        }
        if(level == 8){
            System.out.println("Level 8");
            spells.setSize(11);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(4);

            AbilityScoreImprovement(character);

        }
        if(level == 9){
            System.out.println("Level 9");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            spells.setSize(12);
            features.remove("Song of Rest (d6)");
            features.add("Song of Rest (d8)");
            System.out.println("You have added Song of Rest (d8) to your features");
            ChooseYourSpell(4);
            ChooseYourSpell(5);

        }
        if(level == 10){
            System.out.println("Level 10");
            spells.setSize(14);
            cantrips.setSize(4);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Bardic Inspiration (d8)");
            features.add("Bardic Inspiration (d10)");
            features.add("Expertise");
            features.add("Magical Secrets");
            System.out.println("You have added Bardic Inspiration (d10), Expertise, Magical Secrets to your features");
            for (int i = 0; i < 2 ; i++){
                MagicalSecrects(5);
            }
            System.out.println("You have learned a new Cantrip");
            VectorPrintOut(cantripList);
            choice=scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
           ChooseYourSpell(5);



        }
        if(level == 11){
            System.out.println("Level 11");
            spells.setSize(15);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(6);
        }
        if(level == 12){
            System.out.println("Level 12");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            AbilityScoreImprovement(character);

        }
        if(level == 13){
            System.out.println("Level 13");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Song of Rest (d8)");
            features.add("Song of Rest (d10)");
            System.out.println("You added Song of Rest (d10) to features");
            ChooseYourSpell(7);


        }
        if(level == 14){
            System.out.println("Level 14");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
                if (college.equals("College of Lore")){
                    features.add("Peerless Skills");
                    System.out.println("You have added Peerless Skills and Magical Secrets to features");
                    for (int i =0; i < 2; i++){
                        MagicalSecrects(7);
                    }

                }
                if (college.equals("College of Valor")){
                    features.add("Battle Magic");
                    System.out.println("You have added Battle Magic and Magical Secrets to features");
                }
            }

        if(level == 15){
            System.out.println("Level 15");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Bardic Inspiration (d10)");
            features.add("Bardic Inspiration (d12)");
           ChooseYourSpell(8);

        }
        if(level == 16){
            System.out.println("Level 16");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            AbilityScoreImprovement(character);


        }
        if(level == 17){
            System.out.println("Level 17");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Song of Rest (d10");
            features.add("Song of Rest (d12)");

           ChooseYourSpell(9);

        }
        if(level == 18){
            System.out.println("Level 18");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for (int i = 0; i < 2 ; i++){
                MagicalSecrects(9);
            }ChooseYourSpell(5);
        }
        if(level == 19){
            System.out.println("Level 19");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            AbilityScoreImprovement(character);
            ChooseYourSpell(6);

        }
        if(level == 20){
            System.out.println("Level 20");
            character.setHitPoints(character.getHitPoints() + ( D8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            ChooseYourSpell(7);
            features.add("Superior Inspiration");
            System.out.println("You have added Superior Inspiration to your features");

        }

    }

    /**
     *  Gives the user the  choice to either add +2 to 1 ability score, or add 2 separate ability scores by +1
     * @param character DungeonsAndDragons.CharacterSheet that the ability improvement is happening to
     */
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

    /**
     *
     * @param character DungeonsAndDragons.CharacterSheet that needs the Ability Modifier added to
     * @param choice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
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


    /**
     *
     * @param abilityScore Takes in the Ability Score
     * @return Returns the MOdifier based on the Ability Score
     */
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



    /**
     * Prints out the Ability Choices
     */
    public static void AbilityChoicePrintout(){
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

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

    /**
     * Prints out a vectore
     * @param vector Vector that is needing to be printed out
     */
    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
        }
    }

    /**
     * Code needed to complete the Magical Secrets Feature
     * @param maxlevel Max Level that the DungeonsAndDragons.Spells can be
     */
    public void MagicalSecrects(int maxlevel){
        Scanner scanner = new Scanner(System.in);
        int choice ;
        String endOdLine = "";

        System.out.println("What level of DungeonsAndDragons.Spells would you like to learn 0.) Cantrips , 1, 2, 3, 4, 5, 6, 7, 8, or 9? Your Max Level is :" + maxlevel);
        choice = scanner.nextInt();
        endOdLine = scanner.nextLine();
        choice = inputErrorCheck(choice, 0, maxlevel);
        if(choice==0){
            System.out.println("All Cantrips");
            VectorPrintOut(allCantrips);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allCantrips.size());
            if (spells.contains(allCantrips.get(choice-1))){
                while(spells.contains(allCantrips.get(choice-1))){
                    allCantrips.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                    choice = -1;

                }
            }
            else{
                System.out.println("You have added : " +allCantrips.get(choice-1));
                spells.add(allCantrips.get(choice-1));
                allCantrips.remove(choice-1);
                choice = -1;
            }

        }

        if(choice==1){
            System.out.println("All First Level DungeonsAndDragons.Spells");
            VectorPrintOut(allFirstLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFirstLevelSpells.size());
            if (spells.contains(allFirstLevelSpells.get(choice-1))){
                while(spells.contains(allFirstLevelSpells.get(choice-1))){
                    allFirstLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }
            else {
                System.out.println("You have added : " +allFirstLevelSpells.get(choice-1));
                spells.add(allFirstLevelSpells.get(choice-1));
                allFirstLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(choice==2){
            System.out.println("All Second Level DungeonsAndDragons.Spells");
            VectorPrintOut(allSecondLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSecondLevelSpells.size());
            if (spells.contains(allSecondLevelSpells.get(choice-1))){
                while(spells.contains(allSecondLevelSpells.get(choice-1))) {
                    allSecondLevelSpells.remove(choice - 1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);

                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allSecondLevelSpells.get(choice-1));
                    spells.add(allSecondLevelSpells.get(choice-1));
                    allSecondLevelSpells.remove(choice-1);
                choice = -1;
            }

            }


        if(choice==3){
            System.out.println("All Third Level DungeonsAndDragons.Spells");
            VectorPrintOut(allThirdLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allThirdLevelSpells.size());
            if (spells.contains(allThirdLevelSpells.get(choice-1))){
                while(spells.contains(allThirdLevelSpells.get(choice-1))){
                    allThirdLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allThirdLevelSpells.get(choice-1));
                spells.add(allThirdLevelSpells.get(choice-1));
                allThirdLevelSpells.remove(choice-1);
                choice = -1;
            }



        }

        if(choice==4){
            System.out.println("All Fourth Level DungeonsAndDragons.Spells");
            VectorPrintOut(allFourthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFourthLevelSpells.size());
            if (spells.contains(allFourthLevelSpells.get(choice-1))){
                while(spells.contains(allFourthLevelSpells.get(choice-1))){
                    allFourthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allFourthLevelSpells.get(choice-1));
                spells.add(allFourthLevelSpells.get(choice-1));
                allFourthLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(choice==5){
            System.out.println("All Fifth Level DungeonsAndDragons.Spells");
            VectorPrintOut(allFifthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFifthLevelSpells.size());
            if (spells.contains(allFifthLevelSpells.get(choice-1))){
                while(spells.contains(allFifthLevelSpells.get(choice-1))){
                    allFifthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allFifthLevelSpells.get(choice-1));
                spells.add(allFifthLevelSpells.get(choice-1));
                allFifthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(choice==6){
            System.out.println("All Sixth Level DungeonsAndDragons.Spells");
            VectorPrintOut(allSixthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSixthLevelSpells.size());
            if (spells.contains(allSixthLevelSpells.get(choice-1))){
                while(spells.contains(allSixthLevelSpells.get(choice-1))){
                    allSixthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allSixthLevelSpells.get(choice-1));
                spells.add(allSixthLevelSpells.get(choice-1));
                allSixthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(choice==7){
            System.out.println("All Seventh Level DungeonsAndDragons.Spells");
            VectorPrintOut(allSeventhLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSeventhLevelSpells.size());
            if (spells.contains(allSeventhLevelSpells.get(choice-1))){
                while(spells.contains(allSeventhLevelSpells.get(choice-1))){
                    allSeventhLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allSeventhLevelSpells.get(choice-1));
                spells.add(allSeventhLevelSpells.get(choice-1));
                allSeventhLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(choice==8){
            System.out.println("All Eighth Level DungeonsAndDragons.Spells");
            VectorPrintOut(allEighthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allEighthLevelSpells.size());
            if (spells.contains(allEighthLevelSpells.get(choice-1))){
                while(spells.contains(allEighthLevelSpells.get(choice-1))){
                    allEighthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allEighthLevelSpells.get(choice-1));
                spells.add(allEighthLevelSpells.get(choice-1));
                allEighthLevelSpells.remove(choice-1);
                choice = -1;

            }

        }

        if(choice==9){
            System.out.println("All Ninth Level DungeonsAndDragons.Spells");
            VectorPrintOut(allNinthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allNinthLevelSpells.size());
            if (spells.contains(allNinthLevelSpells.get(choice-1))){
                while(spells.contains(allNinthLevelSpells.get(choice-1))){
                    allNinthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    MagicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                System.out.println("You have added : " +allNinthLevelSpells.get(choice-1));
                spells.add(allNinthLevelSpells.get(choice-1));
                allNinthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }



        }


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
    }


}
