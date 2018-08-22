package DungeonsAndDragons;

import java.util.Scanner;


public class RPGCharacterSheet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your Characters name?");
        String name = scanner.nextLine();
        String[] abilityNames = {"Charisma", "Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        String[] race = {"Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"};
        String[] classes = {"DungeonsAndDragons.Barbarian", "DungeonsAndDragons.Bard", "DungeonsAndDragons.Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        int raceArrayNumber =ChooseRace(race) ;
        int classArrayNumber = ChooseClass(classes);
        CharacterSheet character = new CharacterSheet(name, race[raceArrayNumber], classes[classArrayNumber]);
        String[] alignment = {"Good", "Neutral", "Chaotic Neutral", "Chaotic"};
        int[] d20Rolls = new int[6];
        System.out.println("Ability Score Rolls");
        for(int i = 0 ; i < 6; i++){
            d20Rolls[i] = D20Roll();
            System.out.println(i+1 + ".)" + d20Rolls[i]);
        }
        for (int i = 0; i <6; i++){
            System.out.println("Choose your score for " + abilityNames[i]);
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            while (choice<1 || choice > 6 || d20Rolls[choice-1] == -1){
                System.out.println("Incorrect choice. Please select a different option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddtion(character, i+1 , d20Rolls[choice-1]);
            d20Rolls[choice-1] = -1;

        }
        if((classArrayNumber + 1) == 1 ){
            Barbarian barbarianCharacter = new Barbarian(character);
            System.out.println("What level is your DungeonsAndDragons.Barbarian? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for(int i = 0; i < choice; i++) {
                barbarianCharacter.AddLevel();
            }
            barbarianCharacter.ChooseArmor();
            barbarianCharacter.ChooseWeapon();
        }
        if((classArrayNumber + 1) == 2 ){
            Bard bardCharacter = new Bard(character);
            System.out.println("What level is your DungeonsAndDragons.Bard? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for(int i = 0; i < choice; i++) {
                bardCharacter.AddLevel();
            }
            bardCharacter.ChooseWeapon();

        }
        if((classArrayNumber + 1) == 3 ){

        }
        if((classArrayNumber + 1) == 4 ){

        }
        if((classArrayNumber + 1) == 5 ){

        }
        if((classArrayNumber + 1) == 6 ){

        }
        if((classArrayNumber + 1) == 7 ){

        }
        if((classArrayNumber + 1) == 8 ){

        }
        if((classArrayNumber + 1) == 9 ){

        }
        if((classArrayNumber + 1) == 10 ){

        }
//-------------------------------------------------------//

        if ((raceArrayNumber+1) == 1){
            Elf(character, scanner);

        }if ((raceArrayNumber+1)== 2){
            HalfElf(character,scanner);

        }if ((raceArrayNumber+1) == 3){
               Human(character,scanner);

        }if ((raceArrayNumber+1) == 4){
            DragonBorn(character,scanner);

        }if ((raceArrayNumber+1) == 5){
            Dwarf(character,scanner);

        }if ((raceArrayNumber+1) == 6){
            Halfling(character, scanner);

        }if ((raceArrayNumber+1) == 7){
            Gnome(character, scanner);

        }if ((raceArrayNumber+1) == 8){
            HalfOrc(character,scanner);

        }if ((raceArrayNumber+1) == 9) {
            Tiefling(character, scanner);
        }


        System.out.println("How old is your Character?");
        character.setAge(scanner.nextInt());
        String endOfLine = scanner.nextLine();

        System.out.println("Choose your alignment");
        for (int i = 0 ; i<alignment.length; i++){
            System.out.println(i+1 +".) " + alignment[i]);
        }
        int choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        while(choice<1 || choice > alignment.length){
            System.out.println("Incorrect choice, please choose a different option");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
        }
        character.setAlignment(alignment[choice-1]);
        System.out.println("Alignment : " +alignment[choice-1]);


    }

    /**
     *  Allows user to select the race of their character though a list of possible races
     * @param race String array of the possible Races the user can choose from
     * @return Numeric choice by user
     */
    public static int ChooseRace(String[] race){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a race number.");
        for (int i = 0; i < race.length; i++){
            System.out.println((i+1) + ".) " + race[i]);
        }
       int raceArrayNumber = scanner.nextInt()-1;
        if ( raceArrayNumber > race.length-1 || raceArrayNumber < 0) {
            System.out.println("Incorrect Choice");
            raceArrayNumber = ChooseRace(race);
        }
        return raceArrayNumber;
    }

    /**
     *  Allows user to select the class of their character though a list of possible races
     * @param classes String array of the possible classes the user can choose from
     * @return Numeric choice by user
     */
    public static int ChooseClass(String[] classes){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a class number");
        for (int i = 0; i < classes.length; i++){
            System.out.println((i+1)+".) " + classes[i]);
        }
        int classArrayNumber = scanner.nextInt() -1;
        if (classArrayNumber > classes.length -1 || classArrayNumber < 0){
            System.out.println("Incorrect Choice");
            classArrayNumber = ChooseClass(classes);
        }
        return classArrayNumber;
    }

    /**
     * Sets the Alignment for the Character
     * @param alignment String array of possible choices for their Alignment
     * @return Numeric choice made by user
     */
    public static int SetAlignment(String[] alignment){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your alignment number");
        for (int i = 0 ; i < alignment.length; i++){
            System.out.println((i+1) + ".) " + alignment[i]);
        }
        int alignmentNumber = scanner.nextInt();
        if (alignmentNumber > alignment.length -1 || alignmentNumber < 0){
            System.out.println("Incorrect Choice");
            alignmentNumber = SetAlignment(alignment);
        }
        return alignmentNumber;
    }

    /**
     * Randomly generates a number between 1 and 20. Simulates a D20
     * @return Random number between 1 and 20
     */
    public static int D20Roll(){
        double randomDouble = (Math.random()*20) +1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }

    /**
     * To Set up a Dwarf Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Dwarf(CharacterSheet character, Scanner scanner ){
        character.languages.add("Dwarvish");
        AbilityAddtion(character,3,2);
        character.setSpeed(30);
        character.skills.add("Darkvision");
        character.skills.add("Dwarven Resilience");
        character.skills.add("Dwarven Combat Training");
        character.skills.add("Tool Proficiency");
        character.skills.add("Stonecunning");
        System.out.println("Skills added : Darkvision, Dwarven Resilience, Dwarven Combat Training, Tool Proficiency, and Stonecunning");
        System.out.println("You have learned Dwarvish");

        System.out.println("Are you a 1.)Hill Dwarf or 2.)Mountain Dwarf?");
        int choice = scanner.nextInt();
        while(choice != 1 && choice != 2){
            System.out.println("Incorrect choice.Are you a 1.)Hill Dwarf or 2.)Mountain Dwarf? ");
            choice = scanner.nextInt();
        }
        String endOfLine = scanner.nextLine();
        if(choice == 1){
            AbilityAddtion(character,4,2);
            character.setHitPoints(character.getHitPoints()+1);
            System.out.println("Hit Points +1");
        }if (choice == 2){
            AbilityAddtion(character,2,2);
            character.skills.add("Dwarven Armor Training");
            System.out.println("Dwarven Armor Training added to skills");
        }

    }

    /**
     * To Set up a Elf Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Elf (CharacterSheet character, Scanner scanner ){
        AbilityAddtion(character,3,2);
        character.setSpeed(30);
        character.languages.add("Elven");
        character.skills.add("Darkvision");
        character.skills.add("Keen Senses");
        character.skills.add("Fey Ancestry");
        character.skills.add("Trance");
        System.out.println("Skills added : Darkvision, Keen Senses, Fey Ancestry, and Trance");
        System.out.println("Is your Elf a 1.) High Elf , 2.) Wood Elf, or 3.) Dark Elf ?");
        int choice = scanner.nextInt();
        while (choice != 1 && choice !=2 && choice!=3){
            System.out.println("Incorrect Choice. Is your Elf a 1.) High Elf , 2.) Wood Elf, or 3.) Dark Elf ?");
            choice = scanner.nextInt();

        }
        String endOfLine = scanner.nextLine();
        if (choice==1){
            AbilityAddtion(character,5,1);
            character.skills.add("Elf Weapon Training");
            System.out.println("Elf Weapon Training added to skills");
            System.out.println("You learned a new language! What language would you like to add?");
            String language = scanner.nextLine();
            character.languages.add(language);
            System.out.println("You have learned " + language + "!");
        } if (choice==2){
            AbilityAddtion(character,4,1);
            character.skills.add("Elf Weapon Training");
            character.setSpeed(35);
            character.skills.add("Mask of the Wild");
            System.out.println("Skills added : Elf Weapon Training and Mask of the Wild");
            System.out.println("Speed changed to 35");

        }if (choice==3){
            AbilityAddtion(character,1,1);
            character.skills.add("Superior Darkvision");
            character.skills.add("Sunlight Sensitivity");
            character.skills.add("Drow Magic");
            character.skills.add("Drow Weapon Training");
            System.out.println("Skills added : Superior Darkvision, Sunlight Sensitivity, Drow Magic, and Drow Weapon Training  ");


        }

    }

    /**
     * To Set up a Half Elf Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void HalfElf(CharacterSheet character, Scanner scanner ){
        AbilityAddtion(character,1,2);
        System.out.println("You can add +1 to two other abilities");
        int choice = AbilityChoice();
        AbilityAddtion(character, choice, 1);
        System.out.println("You can add +1 to one other ability");
        choice = AbilityChoice();
        AbilityAddtion(character, choice, 1);
        character.setSpeed(30);
        character.skills.add("Darkvision");
        character.skills.add("Fey Ancestory");
        character.skills.add("Skill Versatility");
        System.out.println("Skills added: Darkvision , Fey Ancestory, and Skill Versatility");
        character.languages.add("Elvish");
        System.out.println("You learned Elvish! You can learn one more Language, what language are you learning?");
        String language = scanner.nextLine();
        character.languages.add(language);
        System.out.println("You have learned " + language + "!");

    }

    /**
     * To Set up a Half Orc Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void HalfOrc(CharacterSheet character, Scanner scanner ){
        AbilityAddtion(character, 2, 2); // Adds Strength
        AbilityAddtion(character, 6 , 1); // Adds constitution
        character.setSpeed(30);
        character.skills.add("Darkvision");
        character.skills.add("Menacing");
        character.skills.add("Relentless Endurance");
        character.skills.add("Savage Attacks");
        System.out.println("Skills added : Darkvision, Menacing, Relentless Endurance, and Savage Attack ");
        character.languages.add("Common");
        character.languages.add("Orc");
        System.out.println("You have learned Common and Orc languages!");
    }

    /**
     * To Set up a Human Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Human(CharacterSheet character, Scanner scanner ){
        for (int i = 1; i <=6; i++){
            AbilityAddtion(character,i,1);
        }
        character.setSpeed(30);
        character.languages.add("Common");
        System.out.println("You have learned Common, and your choice at one other language! What is your second Language?");
        String language = scanner.nextLine();
        character.languages.add(language);
        System.out.println("You have learned " + language +"!");
    }

    /**
     * To Set up a Dragonborn Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void DragonBorn(CharacterSheet character, Scanner scanner){
         AbilityAddtion(character,2,2);
         AbilityAddtion(character,1,1);
         character.setSpeed(30);
         String[] draconicAncestryColor = {"Black", "Blue", "Brass", "Bronze ","Copper","Gold","Green", "Red", "Silver","White"};
        String[] draconicAncestryElement = {"Acid", "Lightning", "Fire", "Lightning", "Acid","Fire","Poison","Fire","Cold","Cold"};
        System.out.println("Choose your Draconic Ancestry");
        for (int i =0; i<draconicAncestryColor.length; i++){
            System.out.println(i+1 +".) " + draconicAncestryColor[i] + " : " + draconicAncestryElement[i]);
        }
        int choice = scanner.nextInt();
        character.skills.add("Damage resistance to " + draconicAncestryElement[choice-1]);
        System.out.println("You have added " + draconicAncestryElement[choice-1] + " damage resistance to your skills");

    }

    /**
     * To Set up a Halfling Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Halfling(CharacterSheet character, Scanner scanner){
        AbilityAddtion(character,3,2);
        character.setSpeed(25);
        character.skills.add("Lucky");
        character.skills.add("Brave");
        character.skills.add("Halfling Nimbleness");
        character.languages.add("Common");
        character.languages.add("Halfling");
        System.out.println("You have learned Common and Halfling!");
        System.out.println("What type of Halfling are you 1.)Lightfoot or 2.)Stout");
        int choice = scanner.nextInt();
        while(choice!= 1 && choice != 2 ){
            System.out.println("Incorrect option. What type of Halfling are you 1.)Lightfoot or 2.)Stout");
            choice = scanner.nextInt();
        }
        if(choice == 1){
            AbilityAddtion(character, 1, 1);
            character.skills.add("Naturally Stealthy");
            System.out.println("Naturally Stealthy added to skills");

        }if (choice ==2 ){
            AbilityAddtion(character, 6, 1);
            character.skills.add("Stout Resilience");
            System.out.println("Stout Resilience added to skills");
        }

    }

    /**
     * To Set up a Gnome Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Gnome(CharacterSheet character, Scanner scanner){
        AbilityAddtion(character, 5, 2);
        character.setSpeed(25);
        character.skills.add("Darkvision");
        character.skills.add("Gnome Cunning");
        System.out.println("Darkvision and Gnome Cunning added to skills!");
        character.languages.add("Common");
        character.languages.add("Gnomish");
        System.out.println("You have learned Common and Gnomish!");
        System.out.println("Which type of Gnome are you? 1.)Forest Gnome or 2.)Rock Gnome");
        int choice = scanner.nextInt();
        while(choice!= 1 && choice != 2 ){
            System.out.println("Incorrect choice. Which type of Gnome are you? 1.)Forest Gnome or 2.)Rock Gnome");
            choice = scanner.nextInt();
        }
        if (choice == 1){
            AbilityAddtion(character,3,1);
            character.skills.add("Natural Illusionist");
            character.skills.add("Speak with Small Beasts");
            System.out.println("Natural Illusionist and Speak with Small Beasts were added to your skills!");

        } if (choice == 2){
            AbilityAddtion(character,6,1);
            character.skills.add("Artificer's Lore");
            character.skills.add("Tinker");
        }

    }

    /**
     * To Set up a Tiefling Character if that was the race they chose
     * @param character  Character the race attributes are being applied to
     * @param scanner Scanner used to get inout from user
     */
    public static void Tiefling(CharacterSheet character, Scanner scanner){
        AbilityAddtion(character,5,1);
        character.setSpeed(30);
        character.skills.add("Darvision");
        character.skills.add("Hellish Resistance");
        character.skills.add("Infernal Legacy");
        System.out.println("Skills added : Darkvision , Hellish Resistance, and Infernal Legacy");
        character.languages.add("Common");
        character.languages.add("Infernal");
        System.out.println("You have learned Common and Infernal!");
    }

    /**
     * To choose their ability
     * @return The numeric choice on which ability they would like
     */
    public static int AbilityChoice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.) Charisma") ;
        System.out.println("2.) Strength") ;
        System.out.println("3.) Dexterity") ;
        System.out.println("4.) Wisdom") ;
        System.out.println("5.) Intelligence") ;
        System.out.println("6.) Constitution") ;
        System.out.println("Choose your Ability");
        int choice =  scanner.nextInt();
        if (choice > 6 || choice < 1){
            System.out.println("Incorrect option");
            AbilityChoice();
        }
        return choice;
    }

    /**
     *
     * @param character DungeonsAndDragons.CharacterSheet that needs the Ability Modifier added to
     * @param choice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public static void AbilityAddtion(CharacterSheet character, int choice, int modifierAddtion){
        if (choice == 1){
            character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma +" + modifierAddtion);
            character.setCharismaMod(FindAbilityMod(character.getCharismaScore()));
            System.out.println("Charisma Modifier " + character.getCharismaMod());
        }
        if (choice == 2){
            character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength +" + modifierAddtion);
            character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
            System.out.println("Strength Modifier " + character.getStrengthMod());
        }
        if (choice == 3){
            character.setDexterityScore(character.getDexterityMod() + modifierAddtion);
            System.out.println("Dexterity +" + modifierAddtion);
            character.setDexterityMod(FindAbilityMod(character.getDexterityScore()));
            System.out.println("Dexterity Modifier " + character.getDexterityMod());
        }
        if (choice == 4){
            character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom +" + modifierAddtion);
            character.setWisdomMod(FindAbilityMod(character.getWisdomScore()));
            System.out.println("Wisdom Modifier " + character.getWisdomMod());
        }
        if (choice == 5){
            character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence +" + modifierAddtion);
            character.setIntelligenceMod(FindAbilityMod(character.getIntelligenceScore()));
            System.out.println("Intelligence Modifier " + character.getIntelligenceMod());
        }
        if (choice == 6){
            character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution +" + modifierAddtion);
            character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));
            System.out.println("Constitution Modifier " + character.getConstitutionMod());

        }
    }

    /**
     * Prints our the abilities with their corresponding scores
     * @param character Character that the code is pulling the abilities / scores from
     */
    public static void AbilityPrintout(CharacterSheet character){
        System.out.println("Charisma : " + character.getCharismaScore() );
        System.out.println("Strength : " + character.getStrengthScore());
        System.out.println("Dexterity : " + character.getDexterityMod());
        System.out.println("Wisdom : " + character.getWisdomScore());
        System.out.println("Intelligence : " + character.getIntelligenceScore());
        System.out.println("Constitution : " + character.getConstitutionScore());
    }


    /**
     *
     * @param abilityScore Takes in the Ability Score
     * @return Returns the MOdifier based on the Ability Score
     */
    public static int FindAbilityMod(int abilityScore) {
        Scanner scanner = new Scanner(System.in);
        String endOfLine;
        while(abilityScore<1 || abilityScore>30){
            System.out.println("Incorrect Ability Score, please enter correct score between 1 and 30");
            int choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
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



