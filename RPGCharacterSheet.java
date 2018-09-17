package DungeonsAndDragons;

import javafx.application.Application;


import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import  javafx.stage.Stage;
import javafx.stage.Window;
import sun.invoke.empty.Empty;

import static javafx.scene.layout.BackgroundPosition.CENTER;
import static javafx.scene.layout.BackgroundPosition.DEFAULT;
import static javafx.scene.layout.BackgroundRepeat.NO_REPEAT;
import static javafx.scene.layout.BackgroundRepeat.REPEAT;
import static javafx.scene.layout.BackgroundSize.AUTO;


public class RPGCharacterSheet extends Application{

   static CharacterSheet character;

   static String race;
   static String characterClass;
   static String characterName;

    public static void main(String[] args) {
        launch(args); // Sets up program as javaFX application

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your Characters name?");
        String name = scanner.nextLine();
        String[] abilityNames = {"Charisma", "Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        String[] race = {"Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"};
        String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        int raceArrayNumber =ChooseRace(race) ;
        int classArrayNumber = ChooseClass(classes);
        character = new CharacterSheet(name, race[raceArrayNumber], classes[classArrayNumber]);



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
            barbarianCharacter.ChooseArmor();
            barbarianCharacter.ChooseWeapon();
            System.out.println("What level is your Barbarian? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for(int i = 0; i < choice; i++) {
                barbarianCharacter.AddLevel();
            }

        }
        if((classArrayNumber + 1) == 2 ){
            Bard bardCharacter = new Bard(character);
            bardCharacter.ChooseArmor();
            bardCharacter.ChooseWeapon();
            bardCharacter.ToolsProficiencies();
            bardCharacter.ChooseSkillProficiencies();
            System.out.println("What level is your Bard? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for(int i = 0; i < choice; i++) {
                bardCharacter.AddLevel();
            }


        }
        if((classArrayNumber + 1) == 3 ){
            Cleric clericCharacter = new Cleric(character);
            clericCharacter.ChooseArmor();
            clericCharacter.ChooseWeapon();
            clericCharacter.ChooseSkillProficiencies();
            System.out.println("What level is your Cleric? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for(int i = 0; i < choice; i++) {
                clericCharacter.AddLevel();
            }

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
     * @param character CharacterSheet that needs the Ability Modifier added to
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







    // JavaFX methods


    /**
     * launch(args) calls Application, Application calls start
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        // Make Primary stage show the values (Name and such) Make new stages for the methods and use showAndWait.




        Button continueButton = new Button("Continue");

//        while (!name.getText().isEmpty()){
//            pane.getChildren().add(continueButton);
//        }

        String[] abilityNames = {"Charisma", "Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};


        ChooseName(continueButton);

        ChooseRace(continueButton);

        ChooseClass(continueButton);

        CharacterSheet character = new CharacterSheet(RPGCharacterSheet.characterName, RPGCharacterSheet.race, RPGCharacterSheet.characterClass);



        System.out.println(character.getName());
        System.out.println(character.getRace());
        System.out.println(character.getCharacterClass());
        mainStage(primaryStage,character);



    }

    public static void ChooseName(Button continueButton){
        VBox pane = new VBox(5);
        Scene scene = new Scene(pane,600,600);
        Stage nameStage = new Stage();
        nameStage.setScene(scene);
        Label askName = new Label("What is your Characters name?");
        TextArea name = new TextArea();
        name.setWrapText(true);
        continueButton.setOnAction(e-> {
            RPGCharacterSheet.characterName = name.getText();
            nameStage.close();
        });


        pane.getChildren().addAll(askName,name,continueButton);


        nameStage.showAndWait();

    }




        /**
     *  Allows user to select the race of their character though a list of possible races
     * @return Numeric choice by user
     */
    public static void ChooseRace( Button continueButton){
//   "Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"

        VBox layout = new VBox(5);
        Scene scene = new Scene(layout,600,600);
        Stage raceStage = new Stage();
        raceStage.setScene(scene);
        Label chooseRace = new Label("Choose your race.");
        Button elf = new Button("Elf");
        elf.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Elf");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button halfElf = new Button("Half-Elf");
        halfElf.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Half-Elf");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button human = new Button("Human");
        human.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Human");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button dragonBorn = new Button("Dragonborn");
        dragonBorn.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("DragonBorn");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button dwarf = new Button("Dwarf");
        dwarf.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Dwarf");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button halfling = new Button("Halfling");
        halfling.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Halfling" );
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
            ;});
        Button gnome = new Button("Gnome");
        gnome.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Gnome");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button halfOrc = new Button("Half-Orc");
        halfOrc.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Half-Orc");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });
        Button tiefling = new Button("Tiefling");
        tiefling.setOnAction(e-> {
            continueButton.setOnAction(event-> raceStage.close());
            RPGCharacterSheet.race = ("Tiefling");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.race,continueButton));
        });

        layout.getChildren().addAll(chooseRace,elf,halfElf,human,dragonBorn,dwarf,halfling,gnome,halfOrc,tiefling);

        layout.setAlignment(Pos.CENTER);


        raceStage.showAndWait();

    }

    /**
     *  Allows user to select the class of their character though a list of possible races
     * @return Numeric choice by user
     */
    public static void ChooseClass(Button continueButton){
        // "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"

        VBox layout = new VBox(5);
        Scene scene = new Scene(layout,600,600);
        Stage classStage = new Stage();
        classStage.setScene(scene);
        continueButton.setText("Close");
        continueButton.setOnAction(e -> classStage.close());
        Label chooseClass = new Label("Choose your class.");
        Button barbarian = new Button("Barbarian");
        barbarian.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Barbarian");
            layout.getChildren().addAll(new Label ("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button bard = new Button("Bard");
        bard.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Bard");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button cleric = new Button("Cleric");
        cleric.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Cleric");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button druid = new Button("Druid");
        druid.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Druid");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button fighter = new Button("Fighter");
        fighter.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Fighter");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button monk = new Button("Monk");
        monk.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Monk");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button paladin = new Button("Paladin");
        paladin.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Paladin");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button ranger = new Button("Ranger");
        ranger.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Ranger");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button rogue = new Button("Rogue");
        rogue.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Rogue");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button sorcerer = new Button("Sorcerer");
        sorcerer.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Sorcerer");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button warlock = new Button("Warlock");
        warlock.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Warlock");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });
        Button wizard = new Button("Wizard");
        wizard.setOnAction(event -> {
            RPGCharacterSheet.characterClass = ("Wizard");
            layout.getChildren().addAll(new Label("You have chosen "+ RPGCharacterSheet.characterClass,continueButton));
        });

        layout.getChildren().addAll(chooseClass,barbarian,bard,cleric,druid,fighter,monk,paladin,ranger,rogue,sorcerer,warlock,wizard);

        layout.setAlignment(Pos.CENTER);


        classStage.showAndWait();

    }

    public void mainStage (Stage primaryStage, CharacterSheet character){
        primaryStage.setTitle("Character Sheet Creation");
        VBox layout = new VBox(5);
        layout.setBackground(new Background(new BackgroundFill(Color.gray(.7),null,null)));
        Label name = new Label("Name: " + character.getName());
        Label race = new Label("Race: "+ character.getRace());
        Label characterClass = new Label("Class: "+ character.getCharacterClass());
        name.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" + "-fx-Text-fill: Black;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: White;");
        race.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" + "-fx-Text-fill: black;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");
        characterClass.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" + "-fx-Text-fill: black;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");


        layout.getChildren().addAll(name,race,characterClass);
        Scene scene = new Scene(layout, 600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



//    /**
//     * launch(args) calls Application, Application calls start
//     * @param primaryStage
//     */
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Character Sheet Creation");
//        VBox layout = new VBox(5);
//        layout.setBackground(new Background(new BackgroundFill(Color.gray(.2),null,null)));
//        Label name = new Label("Name: " + character.getName());
//        Label race = new Label("Race: "+ character.getRace());
//        Label characterClass = new Label("Class: "+ character.getCharacterClass());
//        name.setStyle("-fx-padding: 10;" +
//                "-fx-border-style: solid inside;" + "-fx-border-fill: white;" +
//                "-fx-border-width: 2;" +
//                "-fx-border-insets: 5;" +
//                "-fx-border-radius: 5;" +
//                "-fx-border-color: black;");
//        race.setStyle("-fx-padding: 10;" +
//                "-fx-border-style: solid inside;" +
//                "-fx-border-width: 2;" +
//                "-fx-border-insets: 5;" +
//                "-fx-border-radius: 5;" +
//                "-fx-border-color: black;");
//        characterClass.setStyle("-fx-padding: 10;" +
//                "-fx-border-style: solid inside;" +
//                "-fx-border-width: 2;" +
//                "-fx-border-insets: 5;" +
//                "-fx-border-radius: 5;" +
//                "-fx-border-color: black;");
//
//
//        layout.getChildren().addAll(name,race,characterClass);
//
////        button = new Button("fgdgfdg");
////        button.setOnAction(e-> System.out.println(button.getText()));   //"This" as a parameter Means that the handle method is in this class
//
//
//
//        //http://www.dreamstime.com/stock-image-lined-paper-image25755721
//        Scene scene = new Scene(layout, 600,600);
//        primaryStage.setScene(scene);
////        primaryStage.show();
//    }

/**
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button){ // This is what determines what is done for each button or source
            System.out.println(button.getText());
        }

    }
    **/
}



