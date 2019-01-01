package DungeonsAndDragons;

import java.util.Scanner;
import java.util.Vector;

public class Bard {
    public Bard(CharacterSheet character){
        this.character = character;
    }

    private  Vector<String> cantrips = new Vector<>();
    private CharacterSheet character;
    private String college;
    private Vector<String> features = new Vector();
    private int hitDice = 8;
    private int level = 0;
    private String pack;
    private int proficiency=2;
    private int spellAttackMod;
    private Vector<String> spells = new Vector<>();
    private int spellSaveDC;

    Vector<String> cantripList = Spells.bardSpellSetUp(10);
    Vector<String> firstLevelSpells = Spells.bardSpellSetUp(1);
    Vector<String> secondLevelSpells = Spells.bardSpellSetUp(2);
    Vector<String> thirdLevelSpells = Spells.bardSpellSetUp(3);
    Vector<String> fourthLevelSpells = Spells.bardSpellSetUp(4);
    Vector<String> fifthLevelSpells = Spells.bardSpellSetUp(5);
    Vector<String> sixthLevelSpells = Spells.bardSpellSetUp(6);
    Vector<String> seventhLevelSpells = Spells.bardSpellSetUp(7);
    Vector<String> eighthLevelSpells = Spells.bardSpellSetUp(8);
    Vector<String> ninthLevelSpells = Spells.bardSpellSetUp(9);

    Vector<String> allCantrips = Spells.allClassSpellSetUp(10);
    Vector<String> allFirstLevelSpells = Spells.allClassSpellSetUp(1);
    Vector<String> allSecondLevelSpells = Spells.allClassSpellSetUp(2);
    Vector<String> allThirdLevelSpells = Spells.allClassSpellSetUp(3);
    Vector<String> allFourthLevelSpells = Spells.allClassSpellSetUp(4);
    Vector<String> allFifthLevelSpells = Spells.allClassSpellSetUp(5);
    Vector<String> allSixthLevelSpells = Spells.allClassSpellSetUp(6);
    Vector<String> allSeventhLevelSpells = Spells.allClassSpellSetUp(7);
    Vector<String> allEighthLevelSpells= Spells.allClassSpellSetUp(8);
    Vector<String> allNinthLevelSpells = Spells.allClassSpellSetUp(9);

    Vector<String> proficiencies = new Vector<>();



    //TODO Test Spells

 // Tested and verfied 9/10
    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void abilityAddition(CharacterSheet character, int AbilityChoice, int modifierAddtion){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        if (AbilityChoice == 1){
            if(character.getCharismaScore() >= 20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            }else {
                character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
                System.out.println("Charisma +" + modifierAddtion);
                character.setCharismaMod(findAbilityMod(character.getCharismaScore()));
            }

        }
        if (AbilityChoice == 2){
            if(character.getStrengthScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            }else {
                character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
                System.out.println("Strength +" + modifierAddtion);
                character.setStrengthMod(findAbilityMod(character.getStrengthScore()));
            }

        }
        if (AbilityChoice == 3){
            if(character.getDexterityScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            } else {
                character.setDexterityMod(character.getDexterityMod() + modifierAddtion);
                System.out.println("Dexterity +" + modifierAddtion);
                character.setDexterityMod(findAbilityMod(character.getDexterityScore()));
            }

        }
        if (AbilityChoice == 4){
            if(character.getWisdomScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            } else{
                character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
                System.out.println("Wisdom +" + modifierAddtion);
                character.setWisdomMod(findAbilityMod(character.getWisdomScore()));
            }

        }
        if (AbilityChoice == 5){
            if(character.getIntelligenceScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            } else {
                character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
                System.out.println("Intelligence +" + modifierAddtion);
                character.setIntelligenceMod(findAbilityMod(character.getIntelligenceScore()));
            }

        }
        if (AbilityChoice == 6){
            if(character.getConstitutionScore() >=20){
                System.out.println("Ability score is greater than 20. Please choose a different option.");
                abilityChoicePrintout();
                choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice,1,6);
                abilityAddition(character, choice, modifierAddtion);
            }else {
                character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
                System.out.println("Constitution +" + modifierAddtion);
                character.setConstitutionMod(findAbilityMod(character.getConstitutionScore()));
            }


        }
    }

    /**
     * Prints out the Ability Choices
     */
    public static void abilityChoicePrintout(){
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

    }


    // Tested and Verified 9/3
    /**
     *  Gives the user the  choice to either add +2 to 1 ability score, or add 2 separate ability scores by +1
     * @param character CharacterSheet that the ability improvement is happening to
     */
    public void abilityScoreImprovement(CharacterSheet character){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to increase 1.) 1 Ability score by +2 or 2.) 2 Ability scores by +1 ");
        int choice = scanner.nextInt();
        String endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,2);
        if (choice==1){
            System.out.println("Which Ability score would you like to increase by +2 ?");
            abilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,6);
            abilityAddition(character, choice, 2 );
            choice = 0;
        }
        if (choice==2){
            System.out.println("Choose your first ability");
            abilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,6);
            abilityAddition(character, choice, 1 );
            System.out.println("What is your second ability?");
            abilityChoicePrintout();
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,6);
            abilityAddition(character, choice, 1 );


        }
    }



    // Tested and verified 9/9
    /**
     * Adds Levels and related information to the character.
     */
    public void addLevel(){
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
            vectorPrintOut(cantripList);
            choice=scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1) + " to your cantrips.");
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
            System.out.println("Please choose your second cantrip");
            vectorPrintOut(cantripList);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1) + " to your cantrips.");
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
            System.out.println("Please choose your first First Level Spell");
            vectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,firstLevelSpells.size());
            System.out.println("You have added " + firstLevelSpells.get(choice -1 )+" to your spells.");
            spells.add(firstLevelSpells.get(choice-1));
            firstLevelSpells.remove(choice -1);
            System.out.println("Please choose your second First Level Spell");
            vectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,firstLevelSpells.size());
            System.out.println("You have added " + firstLevelSpells.get(choice -1 )+ " to your spells.");
            spells.add(firstLevelSpells.get(choice-1));
            firstLevelSpells.remove(choice -1);

            checkVectorAndAdd(proficiencies,"proficiencies","Dexterity");
            checkVectorAndAdd(proficiencies,"proficiencies","Charisma");
            checkVectorAndAdd(proficiencies,"proficiencies","Simple Weapons");
            checkVectorAndAdd(proficiencies,"proficiencies","Hand Crossbows");
            checkVectorAndAdd(proficiencies,"proficiencies","Longswords");
            checkVectorAndAdd(proficiencies,"proficiencies","Rapiers");
            checkVectorAndAdd(proficiencies,"proficiencies","Shortswords");



        }
        if(level == 2){
            System.out.println("Level 2");
            spells.setSize(5);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(1);
            features.add("Jack of All Trades");
            features.add("Song of Rest (d6)");
            System.out.println("Jack of All Trades and Song of Rest(d6) added to features");

        }
        if(level == 3){
            System.out.println("Level 3");
            spells.setSize(6);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.add("Expertise");
            chooseYourSpell(1);
            for (int i = 0 ; i <2 ; i++){
                chooseYourSpell(2);
            }
            System.out.println("Choose your Bard College 1.) College of Lore or 2.) College of Valor . ");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,2);
            if (choice ==1){
                features.add("Bard College : College of Lore");
                college = "College of Lore";
                System.out.println("Bard College : College of Lore and Expertise added to features");
            }if(choice == 2){
                features.add("Bard College : College of Valor");
                college = "College of Valor";
                System.out.println("Bard College : College of Valor and Expertise added to features");
            }
        }
        if(level == 4){
            System.out.println("Level 4");
            spells.setSize(7);
            cantrips.setSize(4);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("You learned a new Cantrip, please choose your new cantrip");
            vectorPrintOut(cantripList);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);

            chooseYourSpell(2);

            abilityScoreImprovement(character);

        }
        if(level == 5){
            System.out.println("Level 5");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            spells.setSize(8);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for (int i = 0 ; i<2 ; i++){
                chooseYourSpell(3);
            }

            features.remove("Bardic Inspiration (d6)");
            features.add("Bardic Inspiration (d8)");
            features.add("Font of Inspiration");
            System.out.println("Bardic Inspiration (d6) and Font of Inspiration added to features");

        }
        if(level == 6){
            System.out.println("Level 6");
            spells.setSize(9);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(3);
            features.add("Countercharm");
            if (college.equals("College of Lore")){
                features.add("Additional Magical Secrets");
                System.out.println("Countercharm and Additional Magical Secrets added to features");
                for (int i = 0 ; i<2 ; i++){
                    magicalSecrects(3);
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
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(4);

        }
        if(level == 8){
            System.out.println("Level 8");
            spells.setSize(11);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(4);

            abilityScoreImprovement(character);

        }
        if(level == 9){
            System.out.println("Level 9");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            spells.setSize(12);
            features.remove("Song of Rest (d6)");
            features.add("Song of Rest (d8)");
            System.out.println("You have added Song of Rest (d8) to your features");
            chooseYourSpell(4);
            chooseYourSpell(5);

        }
        if(level == 10){
            System.out.println("Level 10");
            spells.setSize(14);
            cantrips.setSize(4);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Bardic Inspiration (d8)");
            features.add("Bardic Inspiration (d10)");
            features.add("Expertise");
            features.add("Magical Secrets");
            System.out.println("You have added Bardic Inspiration (d10), Expertise, Magical Secrets to your features");
            for (int i = 0; i < 2 ; i++){
                magicalSecrects(5);
            }
            System.out.println("You have learned a new Cantrip");
            vectorPrintOut(cantripList);
            choice=scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,cantripList.size());
            System.out.println("You have added " + cantripList.get(choice-1));
            cantrips.add(cantripList.get(choice-1));
            cantripList.remove(choice-1);
            chooseYourSpell(5);



        }
        if(level == 11){
            System.out.println("Level 11");
            spells.setSize(15);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(6);
        }
        if(level == 12){
            System.out.println("Level 12");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            abilityScoreImprovement(character);

        }
        if(level == 13){
            System.out.println("Level 13");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Song of Rest (d8)");
            features.add("Song of Rest (d10)");
            System.out.println("You added Song of Rest (d10) to features");
            chooseYourSpell(7);


        }
        if(level == 14){
            System.out.println("Level 14");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            if (college.equals("College of Lore")){
                features.add("Peerless Skills");
                System.out.println("You have added Peerless Skills and Magical Secrets to features");
                for (int i =0; i < 2; i++){
                    magicalSecrects(7);
                }

            }
            if (college.equals("College of Valor")){
                features.add("Battle Magic");
                System.out.println("You have added Battle Magic and Magical Secrets to features");
            }
        }

        if(level == 15){
            System.out.println("Level 15");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Bardic Inspiration (d10)");
            features.add("Bardic Inspiration (d12)");
            chooseYourSpell(8);

        }
        if(level == 16){
            System.out.println("Level 16");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            abilityScoreImprovement(character);


        }
        if(level == 17){
            System.out.println("Level 17");
            proficiency++;
            System.out.println("Proficiency : +" + proficiency);
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            features.remove("Song of Rest (d10");
            features.add("Song of Rest (d12)");

            chooseYourSpell(9);

        }
        if(level == 18){
            System.out.println("Level 18");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            for (int i = 0; i < 2 ; i++){
                magicalSecrects(9);
            }
            chooseYourSpell(5);
        }
        if(level == 19){
            System.out.println("Level 19");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            abilityScoreImprovement(character);
            chooseYourSpell(6);

        }
        if(level == 20){
            System.out.println("Level 20");
            character.setHitPoints(character.getHitPoints() + ( d8Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            chooseYourSpell(7);
            features.add("Superior Inspiration");
            System.out.println("You have added Superior Inspiration to your features");

        }

    }


    /**
     *
     * @param inventory Vector of items
     * @param item item you are adding in vector, or adding quantity to already existing item
     */
    public void checkAndAddItemQuantity(Vector<Item> inventory, Item item){
        int counter =0;
        int i;
        for ( i =0; i< inventory.size();i++){
            if (inventory.get(i).getName().equals(item.getName())){
                inventory.get(i).addition(item);
                counter++;
                System.out.println("+1 " + inventory.get(i).getName() + " added to inventory | Quantity: " + inventory.get(i).getQuantity());
            }
        }
        if (counter == 0){
            inventory.add(item);
            System.out.println(item.getName() + " added to inventory | Quantity: " + inventory.get(inventory.size()-1).getQuantity());
        }

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


    // Tested and verified 9/5
    public void chooseArmor(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        String endOfLine = "";
        System.out.println("You are proficient in Light Armor. Choose your Armor");
        for (int i =0 ; i<character.getLightArmor().length; i++){
            System.out.println(i+1 + ".) " + character.getLightArmor()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getLightArmor().length);
        checkAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[choice-1],character.getLightArmorDescription()[choice-1],1,character.getLightArmorCost()[choice-1]));
        character.setAc(character.getLightArmorAC()[choice-1]);

    }

    //Tested and verified 9/10
    /**
     * Allows user to add the raceTraits they want to be proficient in.
     */
    public void chooseSkillProficiencies(){
        Scanner scanner = new Scanner(System.in);
        int choice =-1;
        String endOfLine = "";
        System.out.println("Choose your first skill to be proficient in.");
        for (int k =0; k<3; k++){
            if (k==1){
                System.out.println("Choose your second skill to be proficient in.");

            }if (k==2){
                System.out.println("Choose your third skill to be proficient in.");
            }
            for (int i =0; i< character.getAllSkills().length; i++){
                System.out.println(i+1 + ".) " + character.getAllSkills()[i]);
            }
            choice = scanner.nextInt();
            endOfLine =scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getAllSkills().length);
            while (proficiencies.contains(character.getAllSkills()[choice-1])){
                System.out.println("You are already proficient in this skill, please choose a different skill.");
                choice = scanner.nextInt();
                endOfLine =scanner.nextLine();
                choice = inputErrorCheck(choice,1,character.getAllSkills().length);

            }
            checkVectorAndAdd(proficiencies, "proficiencies",character.getAllSkills()[choice-1]);

        }

    }

    // Tested and verified 9/5
    /**
     * Walks user through on adding their Weapons / Equipment ot the character
     */
    public void chooseWeapon(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";


        System.out.println("** Equipment Choice **");
        System.out.println("Choose your equipment 1.)Rapier 2.)Longsword or 3.)any simple weapon?");
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice, 1,3);
        if(choice==1){
            character.weapons.add(new Item("Rapier",character.getMartialMeleeWeaponsProperties()[11],1,character.getMartialMeleeWeaponCost()[11]));
            System.out.println("Rapier added to Weapons");
        }if(choice ==2){
            character.weapons.add(new Item("Longsword", character.getMartialMeleeWeaponsProperties()[7],1,character.getMartialMeleeWeaponCost()[7]));
            System.out.println("Longsword added to Weapons");
        }if (choice == 3){
            System.out.println("Which Simple Melee Weapon do you choose?");
            for (int i = 0; i < character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length; i++) {
                if (i < character.getSimpleMeleeWeapons().length){
                    System.out.println( i+1 + ".) " + character.getSimpleMeleeWeapons()[i]);
                }
                if (i >= character.getSimpleMeleeWeapons().length){
                    System.out.println(i+1 + ".) " + character.getSimpleRangedWeapons()[i-character.getSimpleMeleeWeapons().length]);
                }
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length);
            if (choice < character.getSimpleMeleeWeapons().length){
                character.weapons.add(new Item(character.getSimpleMeleeWeapons()[choice-1],character.getSimpleMeleeWeaponProperties()[choice-1],1,character.getSimpleMeleeWeaponsCost()[choice-1]));
                System.out.println("You have chosen " + character.getSimpleMeleeWeapons()[choice-1] );
            }
            if (choice>=character.getSimpleMeleeWeapons().length){
                character.weapons.add(new Item(character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1],character.getSimpleRangedWeaponsProperties()[choice-character.getSimpleMeleeWeapons().length -1],1,character.getSimpleRangedWeaponsCost()[choice-character.getSimpleMeleeWeapons().length -1]));
                System.out.println("You have chosen " + character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1]);
            }
        }

        System.out.println("Do you want 1.)Diplomat's pack or 2.)Entertainer's pack");
        choice=scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,2);
        if(choice == 1){
            pack = "Diplomat";

            checkAndAddItemQuantity(character.inventory, new Item("Chest","",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Case","This cylindrical leather case can hold up to ten rolled-up sheets od paper or five rolled-up sheets of parchment ",2,1));
            checkAndAddItemQuantity(character.inventory, new Item("Set of Fine Clothes","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Bottle of Ink","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Ink Pen","",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Lamp","A  lamp casts bright light in a 15 foot radius and dim light for an additional 30 feet. ONce lit, it burns for 6 hours on a flask (1 pint) of oil",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Flask of Oil","Oils usually comes in a clay flask that holds 1 pint. As an action you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5 foot square area,provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters or ends its turn in the area. A creature can take this damage only once per turn.",2,0));
            checkAndAddItemQuantity(character.inventory, new Item("Sheets of Paper","",5,0));
            checkAndAddItemQuantity(character.inventory, new Item("Vial of Perfume","",1,0));
            checkAndAddItemQuantity(character.inventory, new Item("Sealing Wax","",1,5));
            checkAndAddItemQuantity(character.inventory, new Item("Soap","",1,5));
            System.out.println("Diplomat Pack added to inventory.");

        }if (choice ==2){
            pack = "Entertainer";
            checkAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
            checkAndAddItemQuantity(character.inventory, new Item("Costume","",2,0));
            checkAndAddItemQuantity(character.inventory, new Item("Candle","For 1 hour, a candle sheds bright light in a 5 - foot radius and dim light for an additional 5 feet",2,1));
            checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",5,5));
            checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
            checkAndAddItemQuantity(character.inventory, new Item("Disguise kit","This pouch of cosmetics, hair dye,and small props let you create disguises that change your physical appearance. Proficiency with this kit lets you add your proficiency bonus to any ability checks you make to create a visual disguise.",1,25));

            System.out.println("Entertainer pack added to inventory.");

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

//        character.armorList.add("Leather");
        checkAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
//        character.weapons.add("Dagger");
        System.out.println("Dagger has been added to your inventory");
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
     *
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    public static int findAbilityMod(int abilityScore) {
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


    // Tested and verified 9/9
    /**
     * Code needed to complete the Magical Secrets Feature
     * @param maxlevel Max Level that the Spells can be
     */
    public void magicalSecrects(int maxlevel){
        Scanner scanner = new Scanner(System.in);
        int level;
        int choice ;
        String endOdLine = "";

        System.out.println("\nMagical Secretes:\nWhat level of Spells would you like to learn from all spells?\n0.) Cantrips , 1, 2, 3, 4, 5, 6, 7, 8, or 9? Your Max Level is :" + maxlevel);
        level = scanner.nextInt();
        endOdLine = scanner.nextLine();
        level = inputErrorCheck(level, 0, maxlevel);
        if(level==0){
            System.out.println("All Cantrips");
            vectorPrintOut(allCantrips);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allCantrips.size());
            if (spells.contains(allCantrips.get(choice-1))){
                while(spells.contains(allCantrips.get(choice-1))){
                    allCantrips.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);

                }
                choice = -1;
            }
            else{

                spells.add(allCantrips.get(choice-1));
                System.out.println("You have added : " +allCantrips.get(choice-1)+ " to your cantrips");
                allCantrips.remove(choice-1);
                choice = -1;
            }

        }

        if(level==1){
            System.out.println("All First Level Spells");
            vectorPrintOut(allFirstLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFirstLevelSpells.size());
            if (spells.contains(allFirstLevelSpells.get(choice-1))){
                while(spells.contains(allFirstLevelSpells.get(choice-1))){
                    allFirstLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }
            else {
                spells.add(allFirstLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFirstLevelSpells.get(choice-1));
                allFirstLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(level==2){
            System.out.println("All Second Level Spells");
            vectorPrintOut(allSecondLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSecondLevelSpells.size());
            if (spells.contains(allSecondLevelSpells.get(choice-1))){
                while(spells.contains(allSecondLevelSpells.get(choice-1))) {
                    allSecondLevelSpells.remove(choice - 1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);

                }
                choice = -1;
            }else {
                spells.add(allSecondLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSecondLevelSpells.get(choice-1));
                allSecondLevelSpells.remove(choice-1);
                choice = -1;
            }

        }


        if(level==3){
            System.out.println("All Third Level Spells");
            vectorPrintOut(allThirdLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allThirdLevelSpells.size());
            if (spells.contains(allThirdLevelSpells.get(choice-1))){
                while(spells.contains(allThirdLevelSpells.get(choice-1))){
                    allThirdLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allThirdLevelSpells.get(choice-1));
                System.out.println("You have added : " +allThirdLevelSpells.get(choice-1));
                allThirdLevelSpells.remove(choice-1);
                choice = -1;
            }



        }

        if(level==4){
            System.out.println("All Fourth Level Spells");
            vectorPrintOut(allFourthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFourthLevelSpells.size());
            if (spells.contains(allFourthLevelSpells.get(choice-1))){
                while(spells.contains(allFourthLevelSpells.get(choice-1))){
                    allFourthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allFourthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFourthLevelSpells.get(choice-1));
                allFourthLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(level==5){
            System.out.println("All Fifth Level Spells");
            vectorPrintOut(allFifthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFifthLevelSpells.size());
            if (spells.contains(allFifthLevelSpells.get(choice-1))){
                while(spells.contains(allFifthLevelSpells.get(choice-1))){
                    allFifthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allFifthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFifthLevelSpells.get(choice-1));
                allFifthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==6){
            System.out.println("All Sixth Level Spells");
            vectorPrintOut(allSixthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSixthLevelSpells.size());
            if (spells.contains(allSixthLevelSpells.get(choice-1))){
                while(spells.contains(allSixthLevelSpells.get(choice-1))){
                    allSixthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allSixthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSixthLevelSpells.get(choice-1));
                allSixthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==7){
            System.out.println("All Seventh Level Spells");
            vectorPrintOut(allSeventhLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSeventhLevelSpells.size());
            if (spells.contains(allSeventhLevelSpells.get(choice-1))){
                while(spells.contains(allSeventhLevelSpells.get(choice-1))){
                    allSeventhLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allSeventhLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSeventhLevelSpells.get(choice-1));
                allSeventhLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==8){
            System.out.println("All Eighth Level Spells");
            vectorPrintOut(allEighthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allEighthLevelSpells.size());
            if (spells.contains(allEighthLevelSpells.get(choice-1))){
                while(spells.contains(allEighthLevelSpells.get(choice-1))){
                    allEighthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allEighthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allEighthLevelSpells.get(choice-1));
                allEighthLevelSpells.remove(choice-1);
                choice = -1;

            }

        }

        if(level==9){
            System.out.println("All Ninth Level Spells");
            vectorPrintOut(allNinthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allNinthLevelSpells.size());
            if (spells.contains(allNinthLevelSpells.get(choice-1))){
                while(spells.contains(allNinthLevelSpells.get(choice-1))){
                    allNinthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                spells.add(allNinthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allNinthLevelSpells.get(choice-1));
                allNinthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }



    }



    //Tested and verified 9/9

    /**
     * Walks user through choosing the tools they want to be proficient in
     */
    public void toolsProficiencies(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        String endOfLine="";
        System.out.println("You are proficient in three musical instruments, choose your first instrument.");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies", character.getMusicalInstruments()[choice-1]);

        System.out.println("Choose your second instrument.");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies",character.getMusicalInstruments()[choice-1]);

        System.out.println("Choose your third instrument");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies",character.getMusicalInstruments()[choice-1]);

    }


    /**
     * Prints out a vector
     * @param vector Vector that is needing to be printed out
     */
    public static void vectorPrintOut(Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
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





}
