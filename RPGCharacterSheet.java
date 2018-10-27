package DungeonsAndDragons;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;
import java.util.Scanner;


// TODO create a check all method for JavaFX that updates entire CS after updating any option
public class RPGCharacterSheet extends Application {

    static CharacterSheet character;

    static String race;
    static String characterClass;
    static String characterName;
    static Label label = new Label("");
    static int[] d20Rolls = new int[6];

    public static void main(String[] args) {
        launch(args); // Sets up program as javaFX application

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your Characters name?");
        String name = scanner.nextLine();
        String[] abilityNames = {"Charisma", "Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        String[] race = {"Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome", "Half-Orc", "Tiefling"};
        String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        int raceArrayNumber = ChooseRace(race);
        int classArrayNumber = ChooseClass(classes);
        //TODO Uncomment if needed
//        character = new CharacterSheet(name, race[raceArrayNumber], classes[classArrayNumber]);


        String[] alignment = {"Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "True Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Neutral","Chaotic Evil"};
        int[] d20Rolls = new int[6];
        System.out.println("Ability Score Rolls");
        for (int i = 0; i < 6; i++) {
            d20Rolls[i] = D20Roll();
            System.out.println(i + 1 + ".)" + d20Rolls[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Choose your score for " + abilityNames[i]);
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            while (choice < 1 || choice > 6 || d20Rolls[choice - 1] == -1) {
                System.out.println("Incorrect choice. Please select a different option");
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
            }
            AbilityAddtion(character, i + 1, d20Rolls[choice - 1]);
            d20Rolls[choice - 1] = -1;

        }
        if ((classArrayNumber + 1) == 1) {
            Barbarian barbarianCharacter = new Barbarian(character);
//            barbarianCharacter.ChooseArmor();
//            barbarianCharacter.ChooseWeapon();
            System.out.println("What level is your Barbarian? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for (int i = 0; i < choice; i++) {
                barbarianCharacter.AddLevel();
            }

        }
        if ((classArrayNumber + 1) == 2) {
            Bard bardCharacter = new Bard(character);
            bardCharacter.ChooseArmor();
            bardCharacter.ChooseWeapon();
            bardCharacter.ToolsProficiencies();
            bardCharacter.ChooseSkillProficiencies();
            System.out.println("What level is your Bard? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for (int i = 0; i < choice; i++) {
                bardCharacter.AddLevel();
            }


        }
        if ((classArrayNumber + 1) == 3) {
            Cleric clericCharacter = new Cleric(character);
            clericCharacter.ChooseArmor();
            clericCharacter.ChooseWeapon();
            clericCharacter.ChooseSkillProficiencies();
            System.out.println("What level is your Cleric? ");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            for (int i = 0; i < choice; i++) {
                clericCharacter.AddLevel();
            }

        }
        if ((classArrayNumber + 1) == 4) {

        }
        if ((classArrayNumber + 1) == 5) {

        }
        if ((classArrayNumber + 1) == 6) {

        }
        if ((classArrayNumber + 1) == 7) {

        }
        if ((classArrayNumber + 1) == 8) {

        }
        if ((classArrayNumber + 1) == 9) {

        }
        if ((classArrayNumber + 1) == 10) {

        }
//-------------------------------------------------------//

        if ((raceArrayNumber + 1) == 1) {
            Elf(character, scanner);

        }
        if ((raceArrayNumber + 1) == 2) {
            HalfElf(character, scanner);

        }
        if ((raceArrayNumber + 1) == 3) {
            Human(character, scanner);

        }
        if ((raceArrayNumber + 1) == 4) {
            DragonBorn(character, scanner);

        }
        if ((raceArrayNumber + 1) == 5) {
            Dwarf(character, scanner);

        }
        if ((raceArrayNumber + 1) == 6) {
            Halfling(character, scanner);

        }
        if ((raceArrayNumber + 1) == 7) {
            Gnome(character, scanner);

        }
        if ((raceArrayNumber + 1) == 8) {
            HalfOrc(character, scanner);

        }
        if ((raceArrayNumber + 1) == 9) {
            Tiefling(character, scanner);
        }


        System.out.println("How old is your Character?");
        character.setAge(scanner.nextInt());
        String endOfLine = scanner.nextLine();

        System.out.println("Choose your alignment");
        for (int i = 0; i < alignment.length; i++) {
            System.out.println(i + 1 + ".) " + alignment[i]);
        }
        int choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        while (choice < 1 || choice > alignment.length) {
            System.out.println("Incorrect choice, please choose a different option");
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
        }
        character.setAlignment(alignment[choice - 1]);
        System.out.println("Alignment : " + alignment[choice - 1]);


    }

    /**
     * Allows user to select the race of their character though a list of possible races
     *
     * @param race String array of the possible Races the user can choose from
     * @return Numeric choice by user
     */
    public static int ChooseRace(String[] race) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a race number.");
        for (int i = 0; i < race.length; i++) {
            System.out.println((i + 1) + ".) " + race[i]);
        }
        int raceArrayNumber = scanner.nextInt() - 1;
        if (raceArrayNumber > race.length - 1 || raceArrayNumber < 0) {
            System.out.println("Incorrect Choice");
            raceArrayNumber = ChooseRace(race);
        }
        return raceArrayNumber;
    }

    /**
     * Allows user to select the class of their character though a list of possible races
     *
     * @param classes String array of the possible classes the user can choose from
     * @return Numeric choice by user
     */
    public static int ChooseClass(String[] classes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a class number");
        for (int i = 0; i < classes.length; i++) {
            System.out.println((i + 1) + ".) " + classes[i]);
        }
        int classArrayNumber = scanner.nextInt() - 1;
        if (classArrayNumber > classes.length - 1 || classArrayNumber < 0) {
            System.out.println("Incorrect Choice");
            classArrayNumber = ChooseClass(classes);
        }
        return classArrayNumber;
    }

    /**
     * Sets the Alignment for the Character
     *
     * @param alignment String array of possible choices for their Alignment
     * @return Numeric choice made by user
     */
    public static int SetAlignment(String[] alignment) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your alignment number");
        for (int i = 0; i < alignment.length; i++) {
            System.out.println((i + 1) + ".) " + alignment[i]);
        }
        int alignmentNumber = scanner.nextInt();
        if (alignmentNumber > alignment.length - 1 || alignmentNumber < 0) {
            System.out.println("Incorrect Choice");
            alignmentNumber = SetAlignment(alignment);
        }
        return alignmentNumber;
    }

    /**
     * Randomly generates a number between 1 and 20. Simulates a D20
     *
     * @return Random number between 1 and 20
     */
    public static int D20Roll() {
        double randomDouble = (Math.random() * 20) + 1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }

    /**
     * To Set up a Dwarf Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Dwarf(CharacterSheet character, Scanner scanner) {
        character.languages.add("Dwarvish");
        AbilityAddtion(character, 3, 2);
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
        while (choice != 1 && choice != 2) {
            System.out.println("Incorrect choice.Are you a 1.)Hill Dwarf or 2.)Mountain Dwarf? ");
            choice = scanner.nextInt();
        }
        String endOfLine = scanner.nextLine();
        if (choice == 1) {
            AbilityAddtion(character, 4, 2);
            character.setHitPoints(character.getHitPoints() + 1);
            System.out.println("Hit Points +1");
        }
        if (choice == 2) {
            AbilityAddtion(character, 2, 2);
            character.skills.add("Dwarven Armor Training");
            System.out.println("Dwarven Armor Training added to skills");
        }

    }

    /**
     * To Set up a Elf Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Elf(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 3, 2);
        character.setSpeed(30);
        character.languages.add("Elven");
        character.skills.add("Darkvision");
        character.skills.add("Keen Senses");
        character.skills.add("Fey Ancestry");
        character.skills.add("Trance");
        System.out.println("Skills added : Darkvision, Keen Senses, Fey Ancestry, and Trance");
        System.out.println("Is your Elf a 1.) High Elf , 2.) Wood Elf, or 3.) Dark Elf ?");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Incorrect Choice. Is your Elf a 1.) High Elf , 2.) Wood Elf, or 3.) Dark Elf ?");
            choice = scanner.nextInt();

        }
        String endOfLine = scanner.nextLine();
        if (choice == 1) {
            AbilityAddtion(character, 5, 1);
            character.skills.add("Elf Weapon Training");
            System.out.println("Elf Weapon Training added to skills");
            System.out.println("You learned a new language! What language would you like to add?");
            String language = scanner.nextLine();
            character.languages.add(language);
            System.out.println("You have learned " + language + "!");
        }
        if (choice == 2) {
            AbilityAddtion(character, 4, 1);
            character.skills.add("Elf Weapon Training");
            character.setSpeed(35);
            character.skills.add("Mask of the Wild");
            System.out.println("Skills added : Elf Weapon Training and Mask of the Wild");
            System.out.println("Speed changed to 35");

        }
        if (choice == 3) {
            AbilityAddtion(character, 1, 1);
            character.skills.add("Superior Darkvision");
            character.skills.add("Sunlight Sensitivity");
            character.skills.add("Drow Magic");
            character.skills.add("Drow Weapon Training");
            System.out.println("Skills added : Superior Darkvision, Sunlight Sensitivity, Drow Magic, and Drow Weapon Training  ");


        }

    }

    /**
     * To Set up a Half Elf Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void HalfElf(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 1, 2);
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
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void HalfOrc(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 2, 2); // Adds Strength
        AbilityAddtion(character, 6, 1); // Adds constitution
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
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Human(CharacterSheet character, Scanner scanner) {
        for (int i = 1; i <= 6; i++) {
            AbilityAddtion(character, i, 1);
        }
        character.setSpeed(30);
        character.languages.add("Common");
        System.out.println("You have learned Common, and your choice at one other language! What is your second Language?");
        String language = scanner.nextLine();
        character.languages.add(language);
        System.out.println("You have learned " + language + "!");
    }

    /**
     * To Set up a Dragonborn Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void DragonBorn(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 2, 2);
        AbilityAddtion(character, 1, 1);
        character.setSpeed(30);
        String[] draconicAncestryColor = {"Black", "Blue", "Brass", "Bronze ", "Copper", "Gold", "Green", "Red", "Silver", "White"};
        String[] draconicAncestryElement = {"Acid", "Lightning", "Fire", "Lightning", "Acid", "Fire", "Poison", "Fire", "Cold", "Cold"};
        System.out.println("Choose your Draconic Ancestry");
        for (int i = 0; i < draconicAncestryColor.length; i++) {
            System.out.println(i + 1 + ".) " + draconicAncestryColor[i] + " : " + draconicAncestryElement[i]);
        }
        int choice = scanner.nextInt();
        character.skills.add("Damage resistance to " + draconicAncestryElement[choice - 1]);
        System.out.println("You have added " + draconicAncestryElement[choice - 1] + " damage resistance to your skills");

    }

    /**
     * To Set up a Halfling Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Halfling(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 3, 2);
        character.setSpeed(25);
        character.skills.add("Lucky");
        character.skills.add("Brave");
        character.skills.add("Halfling Nimbleness");
        character.languages.add("Common");
        character.languages.add("Halfling");
        System.out.println("You have learned Common and Halfling!");
        System.out.println("What type of Halfling are you 1.)Lightfoot or 2.)Stout");
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Incorrect option. What type of Halfling are you 1.)Lightfoot or 2.)Stout");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            AbilityAddtion(character, 1, 1);
            character.skills.add("Naturally Stealthy");
            System.out.println("Naturally Stealthy added to skills");

        }
        if (choice == 2) {
            AbilityAddtion(character, 6, 1);
            character.skills.add("Stout Resilience");
            System.out.println("Stout Resilience added to skills");
        }

    }

    /**
     * To Set up a Gnome Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Gnome(CharacterSheet character, Scanner scanner) {
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
        while (choice != 1 && choice != 2) {
            System.out.println("Incorrect choice. Which type of Gnome are you? 1.)Forest Gnome or 2.)Rock Gnome");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            AbilityAddtion(character, 3, 1);
            character.skills.add("Natural Illusionist");
            character.skills.add("Speak with Small Beasts");
            System.out.println("Natural Illusionist and Speak with Small Beasts were added to your skills!");

        }
        if (choice == 2) {
            AbilityAddtion(character, 6, 1);
            character.skills.add("Artificer's Lore");
            character.skills.add("Tinker");
        }

    }

    /**
     * To Set up a Tiefling Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     * @param scanner   Scanner used to get inout from user
     */
    public static void Tiefling(CharacterSheet character, Scanner scanner) {
        AbilityAddtion(character, 5, 1);
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
     *
     * @return The numeric choice on which ability they would like
     */
    public static int AbilityChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");
        System.out.println("Choose your Ability");
        int choice = scanner.nextInt();
        if (choice > 6 || choice < 1) {
            System.out.println("Incorrect option");
            AbilityChoice();
        }
        return choice;
    }

    /**
     * @param character       CharacterSheet that needs the Ability Modifier added to
     * @param choice          Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public static void AbilityAddtion(CharacterSheet character, int choice, int modifierAddtion) {
        if (choice == 1) {
            character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma +" + modifierAddtion);
            character.setCharismaMod(FindAbilityMod(character.getCharismaScore()));
            System.out.println("Charisma Modifier " + character.getCharismaMod());
        }
        if (choice == 2) {
            character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength +" + modifierAddtion);
            character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
            System.out.println("Strength Modifier " + character.getStrengthMod());
        }
        if (choice == 3) {
            character.setDexterityScore(character.getDexterityMod() + modifierAddtion);
            System.out.println("Dexterity +" + modifierAddtion);
            character.setDexterityMod(FindAbilityMod(character.getDexterityScore()));
            System.out.println("Dexterity Modifier " + character.getDexterityMod());
        }
        if (choice == 4) {
            character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom +" + modifierAddtion);
            character.setWisdomMod(FindAbilityMod(character.getWisdomScore()));
            System.out.println("Wisdom Modifier " + character.getWisdomMod());
        }
        if (choice == 5) {
            character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence +" + modifierAddtion);
            character.setIntelligenceMod(FindAbilityMod(character.getIntelligenceScore()));
            System.out.println("Intelligence Modifier " + character.getIntelligenceMod());
        }
        if (choice == 6) {
            character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution +" + modifierAddtion);
            character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));
            System.out.println("Constitution Modifier " + character.getConstitutionMod());

        }
    }

    /**
     * Prints our the abilities with their corresponding scores
     *
     * @param character Character that the code is pulling the abilities / scores from
     */
    public static void AbilityPrintout(CharacterSheet character) {
        System.out.println("Charisma : " + character.getCharismaScore());
        System.out.println("Strength : " + character.getStrengthScore());
        System.out.println("Dexterity : " + character.getDexterityMod());
        System.out.println("Wisdom : " + character.getWisdomScore());
        System.out.println("Intelligence : " + character.getIntelligenceScore());
        System.out.println("Constitution : " + character.getConstitutionScore());
    }


    /**
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    public static int FindAbilityMod(int abilityScore) {
        Scanner scanner = new Scanner(System.in);
        String endOfLine;
        while (abilityScore < 1 || abilityScore > 30) {
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
        if (abilityScore == 10 || abilityScore == 11) {
            return +0;
        }
        if (abilityScore == 12 || abilityScore == 13) {
            return +1;
        }
        if (abilityScore == 14 || abilityScore == 15) {
            return +2;
        }
        if (abilityScore == 16 || abilityScore == 17) {
            return +3;
        }
        if (abilityScore == 18 || abilityScore == 19) {
            return +4;
        }
        if (abilityScore == 20 || abilityScore == 21) {
            return +5;
        }
        if (abilityScore == 22 || abilityScore == 23) {
            return +6;
        }
        if (abilityScore == 24 || abilityScore == 25) {
            return +7;
        }
        if (abilityScore == 26 || abilityScore == 27) {
            return +8;
        }
        if (abilityScore == 28 || abilityScore == 29) {
            return +9;
        }
        return +10;

    }










    // JavaFX methods


    /**
     * launch(args) calls Application, Application calls start
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        CharacterSheet character = new CharacterSheet();
        mainStage(primaryStage, character);


    }

    public void mainStage(Stage primaryStage, CharacterSheet mainCharacter) {
        Button continueButton = new Button("Continue");
        primaryStage.setTitle("Character Sheet Creation");
        primaryStage.setResizable(false);
        BorderPane borderPane = new BorderPane();
        GridPane layout = new GridPane();
        layout.setBackground(new Background(new BackgroundFill(Color.gray(1), null, null)));
        borderPane.setTop(layout);
        layout.setPadding(new Insets(5,10,20,10));
        layout.setVgap(10);
        layout.setHgap(20);
        HBox centerTop = new HBox();
        HBox centerBottom = new HBox();
        VBox center = new VBox();
        center.getChildren().addAll(centerTop,centerBottom);

        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.2));
        shadow.setRadius(5);

        borderPane.setEffect(shadow);

        //TODO add tooltip to find description / quantity for each item.
        ObservableList armor = FXCollections.observableArrayList();
        ListView armorList = new ListView();
        armorList.setPlaceholder(new Label("---- Armor ----"));

        ObservableList inventory = FXCollections.observableArrayList();
        ListView inventoryList = new ListView();
        inventoryList.setPlaceholder(new Label("---- Inventory ----"));

        ObservableList weapons = FXCollections.observableArrayList();
        ListView weaponsList = new ListView();
        weaponsList.setPlaceholder(new Label("---- Weapons ----"));

        ObservableList instruments = FXCollections.observableArrayList();
        ListView instrumentsList = new ListView();
        instrumentsList.setPlaceholder(new Label("---- Instruments ----"));

        ObservableList features = FXCollections.observableArrayList();
        ListView featuresList = new ListView();
        featuresList.setPlaceholder(new Label("---- Features ----"));

        ObservableList proficiencies = FXCollections.observableArrayList();
        ListView proficienciesList = new ListView();
        proficienciesList.setPlaceholder(new Label("---- Proficiencies ----"));

        ObservableList spells = FXCollections.observableArrayList();
        ListView spellsList = new ListView();
        spellsList.setPlaceholder(new Label("---- Spells ----"));

        ObservableList skills = FXCollections.observableArrayList();
        //TODO when getting spells, add cantrips, lvl 1 ... and fourth in between spells
        ListView skillsList = new ListView();
        skillsList.setPlaceholder(new Label("---- Skills ----"));


        centerTop.getChildren().addAll(armorList,weaponsList,inventoryList,instrumentsList);
        armorList.setPrefWidth(200);
        weaponsList.setPrefWidth(200);
        inventoryList.setPrefWidth(200);
        instrumentsList.setPrefWidth(200);
        featuresList.setPrefWidth(200);
        proficienciesList.setPrefWidth(200);
        spellsList.setPrefWidth(200);
        skillsList.setPrefWidth(200);

        centerBottom.getChildren().addAll(featuresList,proficienciesList,spellsList,skillsList);
        center.setTranslateX(30);
        borderPane.setCenter(center);




        Label age = new Label("Age: "+ mainCharacter.getAge());
        Button setAge = new Button("Edit age");
        setAge.setDisable(true);
        age.setTooltip(new Tooltip("Missing race selection"));

        Label level = new Label("Level: "+ mainCharacter.getLevel());
        Button editLevel = new Button("Edit level");
        editLevel.setDisable(true);
        level.setTooltip(new Tooltip("Missing class selection"));

//        Image editIcon = new Image(getClass().getResourceAsStream("EditGraphic.png"),30,30,false,false);

        // Set Name
        Label name = new Label("Name: " + mainCharacter.getName());
        layout.add(name, 0, 0);
        name.setPrefWidth(150);
        Button edit1 = new Button("Edit Name");
        edit1.setOnAction(e -> {name.setText(ChooseName(continueButton,  mainCharacter));
            name.setTooltip(new Tooltip(mainCharacter.getName()));});
        layout.add(edit1, 0, 1);
        name.setStyle("-fx-Text-fill: Black;");
        name.setUnderline(true);

        // Set Race
        Label race = new Label("Race: " + mainCharacter.getRace());
        //TODO add specific methods for Race
        race.setPrefWidth(100);
        Button edit2 = new Button("Edit Race");
        edit2.setOnAction(e -> {race.setText(ChooseRace(continueButton, mainCharacter));
        race.setTooltip(new Tooltip(mainCharacter.getRace()));
        setAge.setDisable(false);
        age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
        });
        layout.add(edit2, 1, 1);
        layout.add(race, 1, 0);
        race.setStyle("-fx-Text-fill: black;");
        race.setUnderline(true);

        // Set Class
        Label characterClass = new Label("Class: " + mainCharacter.getCharacterClass());
        layout.add(characterClass, 2, 0);
        characterClass.setPrefWidth(100);
        Button edit3 = new Button("Edit Class");
        layout.add(edit3, 2, 1);
        characterClass.setStyle("-fx-Text-fill: black;");
        characterClass.setUnderline(true);


        edit3.setOnAction(e -> {
            //TODO add Pop-up to warn about earasing current configurations
            mainCharacter.armorList.clear();
            armor.clear();
            mainCharacter.weapons.clear();
            weapons.clear();
            mainCharacter.inventory.clear();
            inventory.clear();

            characterClass.setText(ChooseClass(continueButton,mainCharacter ));
            for (int i=0 ; i < mainCharacter.armorList.size(); i++){
                armor.add((mainCharacter.armorList.get(i).getName()));
            }
            armorList.setItems(armor);

            for (int i = 0 ; i< mainCharacter.weapons.size() ; i++){
                weapons.add(mainCharacter.weapons.get(i).getName());
            }
            weaponsList.setItems(weapons);

            for (int i = 0; i < mainCharacter.inventory.size(); i++){
                inventory.add(mainCharacter.inventory.get(i).getName());
            }
            inventoryList.setItems(inventory);

            editLevel.setDisable(false);
            level.setTooltip(null);
        });

        // Set Age
        age.setUnderline(true);
        age.setPrefWidth(100);
        layout.add(age,3,0);
        setAge.setOnAction(e->{ SetAge(mainCharacter);
            age.setText("Age: " + mainCharacter.getAge());
            age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
        });
        layout.add(setAge,3,1);

        //Set Character Specific Misc
        ObservableList misc = FXCollections.observableArrayList();
        ListView miscList = new ListView(misc);
        miscList.setPlaceholder(new Label("--- Miscellaneous ---"));

        //Sets AC
        Label ac = new Label("AC: " + mainCharacter.getAc());
        ac.setUnderline(true);
        layout.add(ac,5,0);

        //Sets HP
        Label hp = new Label("Hit Points: "+ mainCharacter.getHitPoints());
        hp.setUnderline(true);
        layout.add(hp, 5,1);
        //Sets Speed
        Label speed = new Label("Speed: "+ mainCharacter.getSpeed());
        speed.setUnderline(true);
        layout.add(speed, 6,0);
        //Sets Alignment
        ObservableList alignmentOptions = FXCollections.observableArrayList();
        alignmentOptions.addAll("Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "True Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Neutral","Chaotic Evil");
        ChoiceBox<String> alignmentChoiceBox = new ChoiceBox<>(alignmentOptions);
        alignmentChoiceBox.setOnAction(e-> mainCharacter.setAlignment(alignmentChoiceBox.getValue()));
        Label alignment = new Label("Alignment: ");
        alignment.setUnderline(true);
        layout.add(alignment,6,1);
        layout.add(alignmentChoiceBox,7,1);

        //Set Level
        level.setUnderline(true);
        layout.add(level,4,0);
        layout.add(editLevel,4,1);
        editLevel.setOnAction(e->{
            SetLevel(mainCharacter);
            level.setText("Level: " + mainCharacter.getLevel());
            proficienciesList.setItems(mainCharacter.getProficienciesList());
            featuresList.setItems(mainCharacter.getFeaturesList());
            miscList.setItems(mainCharacter.getMisc());
            ac.setText("AC: " + mainCharacter.getAc());
            hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
        });


        // Sets Abilities

        VBox left = new VBox();
        Button editAbilities = new Button("Edit Abilities");

        VBox abilities = new VBox();
        abilities.setTranslateY(12);
        abilities.setStyle("-fx-border-color: black");
        abilities.setMaxHeight(150);
        abilities.setPadding(new Insets(10,10,10,10));
        Label charisma = new Label("Charisma: " + mainCharacter.getCharismaScore() + " / +" + mainCharacter.getCharismaMod());
        Label strength = new Label("Strength: " + mainCharacter.getStrengthScore() + " / +" + mainCharacter.getStrengthMod());
        Label dexterity = new Label("Dexterity: " + mainCharacter.getDexterityScore() + " / +" + mainCharacter.getDexterityMod());
        Label wisdom = new Label("Wisdom: " + mainCharacter.getWisdomScore() + " / +" + mainCharacter.getWisdomMod());
        Label intelligence = new Label("Intelligence: " + mainCharacter.getIntelligenceScore() + " / +" + mainCharacter.getIntelligenceMod());
        Label constitution = new Label("Constitution: " + mainCharacter.getConstitutionScore() + " / +" + mainCharacter.getConstitutionMod());

        editAbilities.setOnAction(e-> {
            ChooseAbilities(continueButton,mainCharacter);
            charisma.setText("Charisma: " + mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod());
            strength.setText("Strength: " + mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod());
            dexterity.setText("Dexterity: " + mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod());
            wisdom.setText("Wisdom: " + mainCharacter.getWisdomScore() + " / +" + mainCharacter.getWisdomMod());
            intelligence.setText("Intelligence: " + mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod());
            constitution.setText("Constitution: " + mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod());

        });
        abilities.getChildren().addAll(editAbilities,charisma, strength, dexterity, wisdom, intelligence,constitution);

        // Set Languages
        ObservableList languages = FXCollections.observableArrayList(mainCharacter.languages);
        ListView languagesList = new ListView(languages);
        languagesList.setPlaceholder(new Label("--- Languages --- "));

        // Save Button

        Button save = new Button("Save");
        save.setPrefWidth(150);
        //TODO add functionality to save to a DataBase

        left.setMaxWidth(150);
        borderPane.setLeft(left);
        left.getChildren().addAll(abilities, languagesList, miscList,save);


        Scene scene = new Scene(borderPane, 1000, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static String ChooseName(Button continueButton, CharacterSheet mainCharacter) {
        GridPane pane = new GridPane();
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(50, 20, 50, 20));
        pane.setHgap(25);
        pane.setVgap(15);

        Scene scene = new Scene(pane, 400, 200);
        Stage nameStage = new Stage();
        nameStage.setScene(scene);

        Label askName = new Label("What is your Characters name?");

        TextArea name = new TextArea();
        name.setMaxSize(165, 20);
        name.setWrapText(true);

        continueButton.setOnAction(e -> {
            mainCharacter.setName(name.getText());
            nameStage.close();
        });


//        pane.getChildren().addAll(askName,name,continueButton);
        pane.add(askName, 0, 0);
        pane.add(name, 0, 1);
        pane.add(continueButton, 0, 2);
        pane.setAlignment(Pos.TOP_CENTER);
        nameStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black");
        nameStage.initModality(Modality.APPLICATION_MODAL);
        nameStage.showAndWait();

        return "Name: " + name.getText();
    }


    /**
     * Allows user to select the race of their character though a list of possible races
     *
     * @return Numeric choice by user
     */
    public static String ChooseRace(Button continueButton,CharacterSheet mainCharacter) {
//   "Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"
        RPGCharacterSheet.label.setText("");
        continueButton.setDisable(true);
        GridPane layout = new GridPane();
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        layout.setEffect(shadow);
        Scene scene = new Scene(layout, 600, 600);
        layout.setGridLinesVisible(false);
        layout.setPadding(new Insets(20,10,10,20));
        Stage raceStage = new Stage();
        layout.setVgap(60);
        layout.setHgap(60);
        raceStage.setScene(scene);
        Label chooseRace = new Label("Choose your race.");
        chooseRace.setTranslateX(-25);
        layout.add(chooseRace, 1, 0);
        chooseRace.setMaxWidth(100);
        Button elf = new Button("Elf");
        layout.add(elf, 0, 1);
        elf.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Elf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button halfElf = new Button("Half-Elf");
        layout.add(halfElf, 1, 1);
        halfElf.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Half-Elf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });


        Button human = new Button("Human");
        layout.add(human, 2, 1);
        human.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Human");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button dragonBorn = new Button("Dragonborn");
        layout.add(dragonBorn, 0, 2);
        dragonBorn.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("DragonBorn");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });


        Button dwarf = new Button("Dwarf");
        layout.add(dwarf, 1, 2);
        dwarf.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Dwarf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button halfling = new Button("Halfling");
        layout.add(halfling, 2, 2);
        halfling.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Halfling");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button gnome = new Button("Gnome");
        layout.add(gnome, 0, 3);
        gnome.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Gnome");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button halfOrc = new Button("Half-Orc");
        layout.add(halfOrc, 1, 3);
        halfOrc.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Half-Orc");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button tiefling = new Button("Tiefling");
        layout.add(tiefling, 2, 3);
        tiefling.setOnAction(e -> {
            continueButton.setOnAction(event -> raceStage.close());
            mainCharacter.setRace("Tiefling");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        layout.add(label, 1, 4, 2, 1);
        label.setTranslateX(-25);

        layout.add(continueButton, 1, 5);
        layout.setAlignment(Pos.TOP_CENTER);
        raceStage.initStyle(StageStyle.TRANSPARENT);
        layout.setStyle("-fx-border-color: black");
        raceStage.initModality(Modality.APPLICATION_MODAL);
        raceStage.showAndWait();

        return "Race: " + mainCharacter.getRace();


    }

    /**
     * Allows user to select the class of their character though a list of possible races
     *
     * @return Numeric choice by user
     */
    public static String ChooseClass(Button continueButton,CharacterSheet mainCharacter) {
        // "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"

        RPGCharacterSheet.label.setText("");
        GridPane layout = new GridPane();
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        layout.setEffect(shadow);
        Scene scene = new Scene(layout, 600, 600);
        Stage classStage = new Stage();
        layout.setHgap(60);
        layout.setVgap(60);
        classStage.setScene(scene);

        layout.setPadding(new Insets(20,10,10,10));
        layout.setStyle("-fx-border-color: black");

        continueButton.setOnAction(e ->{
            if (mainCharacter.getCharacterClass().equals("Barbarian")) {
            Barbarian barbarianCharacter = new Barbarian(mainCharacter);
            barbarianCharacter.ChooseArmor(classStage); }
        });

        Label chooseClass = new Label("Choose your class.");
        chooseClass.setTranslateX(-25);
        layout.add(chooseClass, 1, 0, 2, 1);
        Button barbarian = new Button("Barbarian");
        layout.add(barbarian, 0, 1);
        barbarian.setOnAction(event -> {
            mainCharacter.setCharacterClass("Barbarian");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }

        });
        Button bard = new Button("Bard");
        layout.add(bard, 1, 1);
        bard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Bard");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button cleric = new Button("Cleric");
        layout.add(cleric, 2, 1);
        cleric.setOnAction(event -> {
            mainCharacter.setCharacterClass("Cleric");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button druid = new Button("Druid");
        layout.add(druid, 0, 2);
        druid.setOnAction(event -> {
            mainCharacter.setCharacterClass("Druid");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button fighter = new Button("Fighter");
        layout.add(fighter, 1, 2);
        fighter.setOnAction(event -> {
            mainCharacter.setCharacterClass("Fighter");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button monk = new Button("Monk");
        layout.add(monk, 2, 2);
        monk.setOnAction(event -> {
            mainCharacter.setCharacterClass("Monk");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button paladin = new Button("Paladin");
        layout.add(paladin, 0, 3);
        paladin.setOnAction(event -> {
            mainCharacter.setCharacterClass("Paladin");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button ranger = new Button("Ranger");
        layout.add(ranger, 1, 3);
        ranger.setOnAction(event -> {
            mainCharacter.setCharacterClass("Ranger");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button rogue = new Button("Rogue");
        layout.add(rogue, 2, 3);
        rogue.setOnAction(event -> {
            mainCharacter.setCharacterClass("Rogue");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button sorcerer = new Button("Sorcerer");
        layout.add(sorcerer, 0, 4);
        sorcerer.setOnAction(event -> {
            mainCharacter.setCharacterClass("Sorcerer");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button warlock = new Button("Warlock");
        layout.add(warlock, 1, 4);
        warlock.setOnAction(event -> {
            mainCharacter.setCharacterClass("Warlock");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });
        Button wizard = new Button("Wizard");
        layout.add(wizard, 2, 4);
        wizard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Wizard");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            if(!layout.getChildren().contains(continueButton)){
                layout.add(continueButton, 1, 6);
            }
        });

        layout.add(label, 1, 5, 2, 1);
        label.setTranslateX(-25);
        layout.setAlignment(Pos.TOP_CENTER);

        classStage.initStyle(StageStyle.TRANSPARENT);

        classStage.initModality(Modality.APPLICATION_MODAL);
        classStage.showAndWait();

        return "Class: " + mainCharacter.getCharacterClass();

    }


    public void ChooseAbilities(Button continueButton, CharacterSheet characterSheet) {
        Stage chooseAbilities = new Stage();
        chooseAbilities.setTitle("Choose Abilities");
        GridPane abilities = new GridPane();
        abilities.setAlignment(Pos.TOP_CENTER);
        abilities.setVgap(10);
        abilities.setHgap(20);

//        String[] abilityNames = {"Charisma, ""Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};

        if (d20Rolls[0] == 0){
            for (int i = 0; i < 6; i++) {
                d20Rolls[i] = D20Roll();
            }
        }
        Label diceRolls = new Label("Your D20 Rolls : " + d20Rolls[0] + " | " + d20Rolls[1] + " | " + d20Rolls[2] + " | " + d20Rolls[3] + " | " + d20Rolls[4] + " | " + d20Rolls[5] + " | \nChoose your ability scores.");
        abilities.add(diceRolls,0,0);

        ChoiceBox<Integer> rolls = new ChoiceBox();
        rolls.setItems(FXCollections.observableArrayList(d20Rolls[0],d20Rolls[1],d20Rolls[2],d20Rolls[3],d20Rolls[4],d20Rolls[5]));
        abilities.add(new Label("Charisma"),0,1);
        abilities.add(new Label("Strength"),0,2);
        abilities.add(new Label("Dexterity"),0,3);
        abilities.add(new Label("Wisdom"),0,4);
        abilities.add(new Label("Intelligence"),0,5);
        abilities.add(new Label("Constitution"),0,6);
        abilities.add(rolls,1,1);
        rolls.setOnAction(charisma -> {

            // Charisma setup
               try {
                   characterSheet.setCharismaScore(rolls.getValue());
                    characterSheet.setCharismaMod(FindAbilityMod(characterSheet.getCharismaScore()));
                    rolls.getItems().remove(rolls.getValue());
                    abilities.add(new Label("Charisma : " + characterSheet.getCharismaScore() + "/ " + characterSheet.getCharismaMod()), 0, 1);

                // Strength Set up
                    abilities.getChildren().remove(rolls);
                    abilities.add(rolls, 1, 2);
                    rolls.setOnAction(strength -> {
                        try {
                            characterSheet.setStrengthScore(rolls.getValue());
                            characterSheet.setStrengthMod(FindAbilityMod(characterSheet.getStrengthScore()));
                            rolls.getItems().remove(rolls.getValue());
                            abilities.add(new Label("Strength : " + characterSheet.getStrengthScore() + "/ " + characterSheet.getStrengthMod()), 0, 2);

                            // Dexterity setup
                            abilities.getChildren().remove(rolls);
                            abilities.add(rolls, 1, 3);
                            rolls.setOnAction(dexterity -> {
                                try {
                                    characterSheet.setDexterityScore(rolls.getValue());
                                    characterSheet.setDexterityMod(FindAbilityMod(characterSheet.getDexterityScore()));
                                    rolls.getItems().remove(rolls.getValue());
                                    abilities.add(new Label("Dexterity : " + characterSheet.getDexterityScore() + "/ " + characterSheet.getDexterityMod()), 0, 3);

                                    //Wisdom setup
                                    abilities.getChildren().remove(rolls);
                                    abilities.add(rolls, 1, 4);
                                    rolls.setOnAction(wisdom -> {
                                        try {
                                            characterSheet.setWisdomScore(rolls.getValue());
                                            characterSheet.setWisdomMod(FindAbilityMod(characterSheet.getWisdomScore()));
                                            rolls.getItems().remove(rolls.getValue());
                                            abilities.add(new Label("Wisdom : " + characterSheet.getWisdomScore() + "/ " + characterSheet.getWisdomMod()), 0, 4);

                                            //Intelligence setup
                                            abilities.getChildren().remove(rolls);
                                            abilities.add(rolls, 1, 5);
                                            rolls.setOnAction(intelligence -> {
                                                try {
                                                    characterSheet.setIntelligenceScore(rolls.getValue());
                                                    characterSheet.setIntelligenceMod(FindAbilityMod(characterSheet.getIntelligenceScore()));
                                                    rolls.getItems().remove(rolls.getValue());
                                                    abilities.add(new Label("Intelligence : " + characterSheet.getIntelligenceScore() + "/ " + characterSheet.getIntelligenceMod()), 0, 5);
                                                    // Constitution setup
                                                    abilities.getChildren().remove(rolls);
                                                    abilities.add(rolls, 1, 6);
                                                    rolls.setOnAction(constitution -> {
                                                        try {
                                                            characterSheet.setConstitutionScore(rolls.getValue());

                                                            characterSheet.setConstitutionMod(FindAbilityMod(characterSheet.getConstitutionScore()));
                                                            rolls.getItems().remove(rolls.getValue());
                                                            abilities.add(new Label("Constitution : " + characterSheet.getConstitutionScore() + "/ " + characterSheet.getConstitutionMod()), 0, 6);
                                                            abilities.getChildren().remove(rolls);
                                                            abilities.add(continueButton, 1, 7);
                                                            continueButton.setTranslateX(-115);
                                                            continueButton.setTranslateY(30);
                                                            continueButton.setOnAction(close -> chooseAbilities.close());
                                                        } catch (NullPointerException Con) {
                                                        }
                                                    });
                                                }catch (NullPointerException Intelligence){}});
                                        }catch (NullPointerException Wisdom){}});
                                }catch (NullPointerException Dexterity){}});
                        } catch (NullPointerException Strength){}});
            } catch ( NullPointerException Charisma){}});

        Scene scene = new Scene(abilities,300,300);
            chooseAbilities.setScene(scene);
            chooseAbilities.initModality(Modality.APPLICATION_MODAL);
            chooseAbilities.showAndWait();
        }

        public void SetAge (CharacterSheet mainCharacter){

            Stage setAgeStage = new Stage();
            GridPane pane = new GridPane();
            InnerShadow shadow = new InnerShadow();
            shadow.setColor(Color.gray(.5));
            pane.setEffect(shadow);
            Scene scene = new Scene(pane,525,200);
            pane.setPadding(new Insets(20,20,20,20));
            Label age = new Label("Set your age.");
            pane.add(age,5,0,3,1);
            pane.setHgap(20);
            pane.setVgap(10);

            Label ageError = new Label("Age must be under 350");
            pane.add(ageError,5,4,4,1);
            ageError.setTranslateX(-25);
            ageError.setDisable(true);

            Label ageValue = new Label();
            Button backspace = new Button("Backspace");
            backspace.setOnAction(e->{
                Integer numValue = Integer.parseInt(ageValue.getText()) /10;
                ageValue.setText(numValue.toString());
            });
            pane.add(backspace,9,1);

            Button continueButton = new Button("Continue");
            continueButton.setDisable(true);
            continueButton.setOnAction(e->{
                 if (Integer.parseInt(ageValue.getText()) > 350){
                     ageError.setDisable(false);

                 }else{
                     mainCharacter.setAge(Integer.parseInt(ageValue.getText()));
                     setAgeStage.close();
                 }
            });
            pane.add(continueButton,5,3,3,1);

            for (int i = 0; i<9; i++){
                Integer number = i;
                Button numButton = new Button(number.toString());
                pane.add(numButton,i,1);
                numButton.setOnAction(e->{
                    ageValue.setText(ageValue.getText()+numButton.getText());
                    continueButton.setDisable(false);
                });
            }
            pane.add(ageValue,5,2,6,1);

            setAgeStage.initStyle(StageStyle.TRANSPARENT);
            pane.setStyle("-fx-border-color: black");
            setAgeStage.setScene(scene);
            setAgeStage.initModality(Modality.APPLICATION_MODAL);
            setAgeStage.showAndWait();

        }

        public void SetLevel(CharacterSheet mainCharacter){
            Stage setLevelStage = new Stage();
            GridPane pane = new GridPane();
            InnerShadow shadow = new InnerShadow();
            shadow.setColor(Color.gray(.5));
            pane.setEffect(shadow);
            Scene scene = new Scene(pane,450,250);

            pane.setPadding(new Insets(10,30,10,30));
            pane.setHgap(10);
            pane.setVgap(20);

            Label chooseLevel = new Label("Choose your level.");
            pane.add(chooseLevel,4,0,4,1);

            Label choice = new Label("Level: "+ mainCharacter.getLevel());
            pane.add(choice,4,3,2,1);

            Button continueButton = new Button("Continue");

            pane.add(continueButton,4,4,2,1);
//            continueButton.setDisable(true);

            Integer levelNum;
            for (int i =1; i < 21 ; i++){
                levelNum =i;
                Button numButton = new Button(levelNum.toString());
                numButton.setOnAction(e->{
                    choice.setText("Level: " + Integer.parseInt(numButton.getText()));
                    continueButton.setDisable(false);


                });

                if (i <=10){
                    pane.add(numButton,i-1,1);
                }else{
                    pane.add(numButton,i%11,2);
                }

            }
            continueButton.setOnAction(e->{
                if (mainCharacter.getCharacterClass().equals("Barbarian")){
                    Barbarian barbarian = new Barbarian(mainCharacter);
                    barbarian.AddLevel(setLevelStage,Integer.parseInt(choice.getText().split(" ")[1]),1);
                }
            });

            setLevelStage.setScene(scene);
            setLevelStage.initStyle(StageStyle.TRANSPARENT);
            pane.setStyle("-fx-border-color: black");
            setLevelStage.initModality(Modality.APPLICATION_MODAL);
            setLevelStage.showAndWait();


    }


}

