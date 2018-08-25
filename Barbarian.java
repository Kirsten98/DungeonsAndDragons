package DungeonsAndDragons;

import java.util.Scanner;
import java.util.Vector;

public class Barbarian{
    CharacterSheet character;
    private int hitDice = 12;
    private int proficiency;
    private Vector<String> features = new Vector();
    private int rages;
    private int rageDamage;
    private int level = 0;
    private String primalPath;
    private String totemSpirit;

    //TODO Add all proficiencies to vector by using CheckVectorAndAdd
    Vector<String> proficiencies = new Vector<>();



    public Barbarian (CharacterSheet character){
        this.character = character;
    }

    /**
     * Walks user through on choosing their Armor for their Character
     */
    public void ChooseArmor(){
        Scanner scanner = new Scanner(System.in);
        Scanner endOfLine = new Scanner(System.in);
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

        while(choice<0 || choice> (character.getLightArmor().length + character.getMediumArmor().length)){
            System.out.println("Incorrect Choice, please choose again");
            choice = scanner.nextInt();
            endLine = scanner.nextLine();
        }

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
     * Walks user through on choosing their Weapons / Equipment for their Character
     */
    public void ChooseWeapon(){
        Scanner scanner = new Scanner(System.in);
        Scanner endOfLine = new Scanner(System.in);
        System.out.println("Would you like a 1.) Greataxe or 2.) Any Martial Melee Weapon? ");
        int choice = scanner.nextInt();
        String endLine = scanner.nextLine();
        while (choice != 1 && choice !=2){
            System.out.println("Incorrect choice. Would you like a 1.) Greataxe or 2.) Any Martial Melee Weapon?");
            choice = scanner.nextInt();
            endLine = scanner.nextLine();
        }
        if (choice ==1){
            character.weapons.add("Greataxe");
            System.out.println("You have chosen a Greataxe");
        }
        if (choice==2){
            System.out.println("Which Martial Melee Weapon would you like ?");
            for (int i =0; i < character.getMartialMeleeWeapons().length; i++){
                System.out.println(i+1 + ".) " + character.getMartialMeleeWeapons()[i]);
            }
            choice = scanner.nextInt();
            endLine = scanner.nextLine();
            while (choice<1 || choice> character.getMartialMeleeWeapons().length){
                System.out.println("Incorrect choice, please select a different option");
                choice = scanner.nextInt();
                endLine = scanner.nextLine();
            }
            System.out.println("You have chosen " + character.getMartialMeleeWeapons()[choice-1]);
            character.weapons.add(character.getMartialMeleeWeapons()[choice-1]);
        }
        System.out.println("For a secondary, would you like 1.)Two Handaxes or 2.) Any Simple Martial Melee Weapon?");
        choice = scanner.nextInt();
        endLine = scanner.nextLine();
        while(choice!=1 && choice !=2){
            System.out.println("Incorrect choice. Would you like 1.)Two Handaxes or 2.) Any Simple Martial Melee Weapon? ");
            choice = scanner.nextInt();
            endLine = scanner.nextLine();
        }
        if(choice==1){
            character.weapons.add("Handaxe");
            character.weapons.add("Handaxe");
            System.out.println("You have chosen 2 handaxes");

        }
        if (choice ==2 ) {
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
            endLine = scanner.nextLine();

            while (choice < 0 || choice >character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length ){
                System.out.println("Incorrect choice, please select another option");
                choice = scanner.nextInt();
                endLine = scanner.nextLine();
            }
            if (choice < character.getSimpleMeleeWeapons().length){
                System.out.println("You have chosen " + character.getSimpleMeleeWeapons()[choice-1] );
            }
            if (choice>character.getSimpleMeleeWeapons().length){
                System.out.println("You have chosen " + character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1]);
            }
            System.out.println("Explorers pack, and four Javelins were added to your Inventory");
            character.inventory.add("Explorers Pack");
            for (int i = 0 ; i <4; i++){
                character.weapons.add("Javelin");
            }
        }
    }

    /**
     * Randomly Generates a number between 1 and 12. Simulating a D12
     * @return Random number between 1 and 12
     */
    public int D12Roll(){
        double randomDouble = Math.random()*12;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }

    /**
     * Adds Levels and related information to the character.
     */
    public void AddLevel(){
        Scanner scanner = new Scanner(System.in);
        level++;
        if (level == 1){
            System.out.println("Level 1");
            character.setHitPoints(character.getConstitutionScore()+12);
            this.proficiency = 2;
            this.features.add("Rage");
            this.features.add("Unarmored Defense");
            this.rages = 2;
            this.rageDamage = 2;
            System.out.println("Proficiency : +2\n Features added : Rage / Unarmored Defense \n Rages : 2 \n Rage Damage : +2");
            System.out.println("You have learned two new skills, what skills have you learned 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            if(choice == 1 ){
                character.skills.add("Animal Handling");
            }if(choice == 2 ){
                character.skills.add("Athletics");
            }if(choice == 3 ){
                character.skills.add("Intimidation");
            }if(choice == 4 ){
                character.skills.add("Nature");
            }if(choice == 5 ){
                character.skills.add("Perception");
            }if(choice == 6 ){
                character.skills.add("Survival");
            }
            System.out.println("And what is your second skill? 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
            int choice2 = scanner.nextInt();
            while(choice == choice2){
                System.out.println("You already have this skill, please choose another. 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
                choice2 = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            if(choice == 1 ){
                character.skills.add("Animal Handling");
            }if(choice == 2 ){
                character.skills.add("Athletics");
            }if(choice == 3 ){
                character.skills.add("Intimidation");
            }if(choice == 4 ){
                character.skills.add("Nature");
            }if(choice == 5 ){
                character.skills.add("Perception");
            }if(choice == 6 ){
                character.skills.add("Survival");
            }
        }
        if(level == 2){
            System.out.println("Level 2");
            features.add("Reckless Attack");
            features.add("Danger Sense");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Reckless Attack / Danger Sense");
        }
        if(level == 3){
            System.out.println("Level 3");
            rages = 3;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Choose your Primal Path 1.) Path of Berserker or 2.) Path of the Totem Warrior");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            while (choice!=1 && choice!=2){
                System.out.println("Incorrect option, do you want to be 1.) Path of Berserker or 2.) Path of the Totem Warrior");
                choice=scanner.nextInt();
                endOfLine=scanner.nextLine();
            }
            if (choice==1){
                primalPath = "Path of Berserker";
                features.add("Primal Path: Frenzy");
                System.out.println("Features Added : Primal Path - Frenzy\n Rages = 3");
            }
            if (choice==2){
             primalPath = "Path of the Totem Warrior";
                features.add("Primal Path: Spirit Speaker");
                System.out.println("Features Added : Primal Path - Spirit Speaker\n Rages = 3");
                System.out.println("Choose your Totem Spirit");
                System.out.println("1.) Bear");
                System.out.println("2.) Eagle");
                System.out.println("3.) Wolf");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                if(choice<0 || choice > 3){
                    System.out.println("Incorrect choice. Please choose another option");
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                if (choice == 1){
                    totemSpirit = "Bear";
                }
                if (choice == 2){
                    totemSpirit = "Eagle";
                }
                if (choice == 3){
                    totemSpirit = "Wolf";
                }
            }

        }
        if(level == 4){
            System.out.println("Level 4");
            features.add("Ability Score Improvement");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Ability Score Improvement ");
            AbilityScoreImprovement(character);
        }
        if (level == 5) {
            System.out.println("Level 5");
            proficiency = 3;
            features.add("Extra Attack");
            features.add("Fast Movement");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Extra Attack / Fast Movement \n Proficiency = 3");
            character.setSpeed(character.getSpeed() + 10);
            System.out.println("Speed changed to " + character.getSpeed());
        }
        if (level == 6){
            System.out.println("Level 6");
            rages = 4;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            if(primalPath.equals("Path of Berserker")){
                features.add("Primal Path: Mindless Rage");
                System.out.println("Features Added : Path Feature - Mindless Rage \n Rages = 4");
            }
            if (primalPath.equals("Path of the Totem Warrior")){
                features.add("Primal Path : Aspect of the Beast");
                System.out.println("Choose your Totem Spirit");
                System.out.println("1.) Bear");
                System.out.println("2.) Eagle");
                System.out.println("3.) Wolf");
                int choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                if(choice<0 || choice > 3){
                    System.out.println("Incorrect choice. Please choose another option");
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                if (choice == 1){
                    totemSpirit = "Bear";
                }
                if (choice == 2){
                    totemSpirit = "Eagle";
                }
                if (choice == 3){
                    totemSpirit = "Wolf";
                }
                System.out.println("Features Added : Path Feature - Aspect of the Beast \n Rages = 4");
            }

        }
        if (level == 7){
            System.out.println("Level 7");
            features.add("Feral Instinct");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Feral Instinct");

        }
        if (level == 8){
            System.out.println("Level 8");
            features.add("Ability Score Improvement");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Ability Score Improvement");
            AbilityScoreImprovement(character);
        }
        if (level == 9){
            System.out.println("Level 9");
            proficiency = 4;
            features.add("Brutal Critical (1 Die)");
            rageDamage = 3;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Brutal Critical (1 Die) \n Proficiency = 4 \n Rage Damage = 3");
        }
        if (level == 10){
            System.out.println("Level 10");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            if(primalPath.equals("Path of Berserker")){
                features.add("Path Features : Intimidating Presence");
                System.out.println("Features Added : Path Features - Intimidating Presence");

            }if (primalPath.equals("Path of the Totem Warrior")){
                features.add("Path Features : Spirit Walker");
                System.out.println("Features Added : Path Features - Spirit Walker");

            }

        }
        if (level == 11){
            System.out.println("Level 11");
            features.add("Relentless Rage");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Relentless Rage");
        }
        if (level == 12) {
            System.out.println("Level 12");
            features.add("Ability Score Improvement");
            rages = 5;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Ability Score Improvement");
            AbilityScoreImprovement(character);
        }
        if (level == 13){
            System.out.println("Level 13");
            proficiency=5;
            features.remove("Brutal Critical (1 Die)");
            features.add("Brutal Critical (2 Dice)");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Brutal Critical (2 Dice) \n Proficiency = 5");
        }
        if (level ==14){
            System.out.println("Level 14");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            if(primalPath.equals("Path of Berserker")){
                features.add("Path Feature : Retaliation");
                System.out.println("Features Added : Path Feature - Retaliation");
            }if (primalPath.equals("Path of the Totem Warrior")){
                features.add("Path Feature : Totemic Attunement");
                System.out.println("Features Added : Path Feature - Totemic Attunement");
                System.out.println("Choose your Totem Spirit");
                System.out.println("1.) Bear");
                System.out.println("2.) Eagle");
                System.out.println("3.) Wolf");
                int choice = scanner.nextInt();
                String endOfLine = scanner.nextLine();
                if(choice<0 || choice > 3){
                    System.out.println("Incorrect choice. Please choose another option");
                    choice = scanner.nextInt();
                    endOfLine = scanner.nextLine();
                }
                if (choice == 1){
                    totemSpirit = "Bear";
                }
                if (choice == 2){
                    totemSpirit = "Eagle";
                }
                if (choice == 3){
                    totemSpirit = "Wolf";
                }

            }
        }
        if (level==15){
            System.out.println("Level 15");
            features.add("Persistent Rage");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Persistent Rage");
        }
        if (level == 16){
            System.out.println("Level 16");
            features.add("Ability Score Improvement");
            rageDamage = 4;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Ability Score Improvement \n Rage Damage = 4");
            AbilityScoreImprovement(character);
        }
        if (level == 17){
            System.out.println("Level 17");
            proficiency = 6;
            features.remove("Brutal Critical (2 Dice");
            features.add("Brutal Critical  (3 Dice)");
            rages = 6;
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Brutal Critical (3 Dice) \n Proficiency = 6 \n Rages = 6");
        }
        if (level == 18){
            System.out.println("Level 18");
            features.add("Indomitable Might");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Indomitable Might");
        }
        if (level == 19){
            System.out.println("Level 19");
            features.add("Ability score improvement");
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Ability Score Improvement");
            AbilityScoreImprovement(character);
        }
        if (level == 20){
            System.out.println("Level 20");
            features.add("Primal Champion");
            rages = 999999999;
            character.setStrengthScore(character.getStrengthScore()+ 4);
            character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
            character.setConstitutionScore(character.getConstitutionScore() + 4);
            character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));
            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
            System.out.println("Your current Hit Points is : " + character.getHitPoints());
            System.out.println("Features Added : Primal Champion \n Rages = Unlimited");
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


}
