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


// TODO create a check all method for JavaFX that updates entire CS after updating any option
public class RPGCharacterSheet extends Application {

    private static ObservableList availableLanguages = new CharacterSheet().getAllLanguages();
    private static Label label = new Label("");
    private static int[] d20Rolls = new int[6];

    public static void main(String[] args) {
        launch(args); // Sets up program as javaFX application

    }


    /**
     * Randomly generates a number between 1 and 20. Simulates a D20
     * @return Random number between 1 and 20
     */
    private static int d20Roll() {
        double randomDouble = (Math.random() * 20) + 1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }

    /**
     * To Set up a dwarf race based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void dwarf(CharacterSheet character, Stage dwarfStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(pane,500,200);
        dwarfStage.setScene(scene);
        dwarfStage.setTitle("Dwarf");

        character.languages.add("Dwarvish");
        RPGCharacterSheet.availableLanguages.remove("Dwarvish");
        abilityAddition(character, 3, 2);
        character.setSpeed(character.getSpeed()+ 30);
        character.skills.add("Darkvision");
        character.skills.add("Dwarven Resilience");
        character.skills.add("Dwarven Combat Training");
        character.skills.add("Tool Proficiency");
        character.skills.add("Stonecunning");
        RPGCharacterSheet.label.setText("Skills added : Darkvision, Dwarven Resilience, Dwarven Combat Training,\nTool Proficiency, and Stonecunning\n\n                             Are you a Hill dwarf or Mountain dwarf?");

        Button hillDwarf = new Button("Hill dwarf");
        Button mountainDwarf = new Button("Mountain dwarf");
        Button continueButton = new Button("Continue");
        continueButton.setDisable(true);
        ButtonBar row1 = new ButtonBar();
        row1.getButtons().addAll(hillDwarf,mountainDwarf);
        row1.setTranslateX(-120);

        mountainDwarf.setOnAction(e->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueButtonEvent ->{
                abilityAddition(character, 4, 2);
                character.setHitPoints(character.getHitPoints() + 1);
                character.setRace("dwarf (Mountain)");
                dwarfStage.close();

            });
        });
        hillDwarf.setOnAction(e->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueButtonEvent ->{
                abilityAddition(character, 2, 2);
                character.skills.add("Dwarven Armor Training");
                character.setRace("dwarf (Hill)");
                dwarfStage.close();

            });
        });
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().addAll(RPGCharacterSheet.label,row1,continueButton);

        }


    /**
     * To Set up an Elf raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void elf(CharacterSheet character, Stage elfStage) {
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(pane,400,400);
        elfStage.setScene(scene);
        elfStage.setHeight(200);
        elfStage.setTitle("Elf");

        abilityAddition(character, 3, 2);
        character.setSpeed(character.getSpeed()+30);
        character.languages.add("Elvish");
        RPGCharacterSheet.availableLanguages.remove("Elvish");
        character.skills.add("Darkvision");
        character.skills.add("Keen Senses");
        character.skills.add("Fey Ancestry");
        character.skills.add("Trance");
       RPGCharacterSheet.label.setText("Skills added : Darkvision, Keen Senses, Fey Ancestry, and Trance\nChoose your elf type");
       Button highElf = new Button("High Elf");
       highElf.setTooltip(new Tooltip("+ Elf Weapon Training\n+1 Language"));

       Button woodElf = new Button("Wood Elf");
       woodElf.setTooltip(new Tooltip("+ Elf Weapon Training\n+ Mask of the Wild\n+35 Speed"));

       Button darkElf = new Button("Dark Elf");
       darkElf.setTooltip(new Tooltip("+ Superior Darkvision\n+ Sunlight Sensitivity\n+Drow Magic\n+Drow Weapon Training"));

       ButtonBar elves = new ButtonBar();
       elves.getButtons().addAll(highElf,woodElf,darkElf);
       elves.setTranslateX(-50);

       Label choice = new Label();

       Button continueButton = new Button("Continue");

       pane.getChildren().addAll(RPGCharacterSheet.label,elves,choice);
        highElf.setOnAction(e->   {
            elfStage.setHeight(400);
            abilityAddition(character, 5, 1);
            character.skills.add("Elf Weapon Training");
            ComboBox<String> languages = new ComboBox<>(availableLanguages);
            Label chooseLanguage = new Label("Choose an additional language");
            continueButton.setDisable(true);
            languages.setOnAction(languageEvent->continueButton.setDisable(false));
            continueButton.setOnAction(continueEvent->{
                character.languages.add(languages.getValue());
                elfStage.close();
            });
            pane.getChildren().addAll(chooseLanguage,languages,continueButton);

        });
       woodElf.setOnAction(e->{
           abilityAddition(character, 4, 1);
           character.skills.add("Elf Weapon Training");
           character.setSpeed(character.getSpeed()+35);
           character.skills.add("Mask of the Wild");
           elfStage.close();


       });
        darkElf.setOnAction(e->{
            abilityAddition(character, 1, 1);
            character.skills.add("Superior Darkvision");
            character.skills.add("Sunlight Sensitivity");
            character.skills.add("Drow Magic");
            character.skills.add("Drow Weapon Training");
            elfStage.close();

        });

        pane.setStyle("-fx-border-color: black");

    }

    /**
     * To Set up a Half elf raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void halfElf(CharacterSheet character, Stage halfElfStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(pane,400,300);
        halfElfStage.setScene(scene);
        halfElfStage.setTitle("Half-Elf");
        halfElfStage.setHeight(250);

        Button continueButton = new Button("Continue");
        character.setSpeed(character.getSpeed()+30);
        character.skills.add("Darkvision");
        character.skills.add("Fey Ancestory");
        character.skills.add("Skill Versatility");
        Label skillsAdded = new Label("Skills added: Darkvision , Fey Ancestory, and Skill Versatility");
        character.languages.add("Elvish");
        RPGCharacterSheet.availableLanguages.remove("Elvish");

        abilityAddition(character, 1, 2);
        RPGCharacterSheet.label.setText("You can add +1 to two other abilities");
        pane.getChildren().addAll(skillsAdded,RPGCharacterSheet.label, abilityPrintoutAndAdd(character,1),continueButton);
       continueButton.setOnAction(e->{
           RPGCharacterSheet.label.setText("You can add +1 to one other ability");
           pane.getChildren().set(2, abilityPrintoutAndAdd(character,1));
           continueButton.setOnAction(event -> {
               halfElfStage.setHeight(300);
               pane.getChildren().remove(continueButton);
               ComboBox<String> languages = new ComboBox<>(availableLanguages);
               Label chooseLanguage = new Label("Choose an additional language");
               pane.getChildren().addAll(chooseLanguage,languages,continueButton);
               continueButton.setOnAction(continueEvent->{
                   character.languages.add(languages.getValue());
                    halfElfStage.close();
                });
           });
       });


    }

    /**
     * To Set up a Half Orc raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void halfOrc(CharacterSheet character, Stage halfOrcStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(pane,450,130);
        halfOrcStage.setScene(scene);
        halfOrcStage.setTitle("Half-Orc");

        abilityAddition(character, 2, 2); // Adds Strength
        abilityAddition(character, 6, 1); // Adds constitution
        character.setSpeed(character.getSpeed()+30);
        character.skills.add("Darkvision");
        character.skills.add("Menacing");
        character.skills.add("Relentless Endurance");
        character.skills.add("Savage Attacks");
        label.setText("Skills added: Darkvision, Menacing, Relentless Endurance, and Savage Attack\n\n Languages learned: Common and Orc");
        character.languages.add("Common");
        character.languages.add("Orc");

        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e-> halfOrcStage.close());
        pane.getChildren().addAll(label,continueButton);

    }

    /**
     * To Set up a human raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void human(CharacterSheet character, Stage humanStage) {
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        Scene scene = new Scene(pane,350,175);
        humanStage.setScene(scene);
        humanStage.setTitle("Human");

        for (int i = 1; i <= 6; i++) {
            abilityAddition(character, i, 1);
        }
        character.setSpeed(character.getSpeed()+30);
        character.languages.add("Common");
        availableLanguages.remove("Common");
        RPGCharacterSheet.label.setText("You have learned Common, and one other language!\nWhat is your second language?");
        RPGCharacterSheet.label.setWrapText(true);
        Button continueButton = new Button("Continue");
        ComboBox<String> languages = new ComboBox<>(availableLanguages);
        pane.getChildren().addAll(RPGCharacterSheet.label,languages,continueButton);
        continueButton.setOnAction(continueEvent->{
            character.languages.add(languages.getValue());
            humanStage.close();
        });

    }

    /**
     * To Set up a Dragonborn raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    private static void dragonBorn(CharacterSheet character, Stage dragonbornStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,30,50,30));
        Scene scene = new Scene(pane,450,250);
        dragonbornStage.setScene(scene);
        dragonbornStage.setTitle("Dragonborn");

        abilityAddition(character, 2, 2);
        abilityAddition(character, 1, 1);
        character.setSpeed(character.getSpeed()+30);
        character.languages.add("Common");
        character.languages.add("Draconic");
        RPGCharacterSheet.availableLanguages.removeAll("Common","Draconic");
        String[] draconicAncestryColor = {"Black", "Blue", "Brass", "Bronze ", "Copper", "Gold", "Green", "Red", "Silver", "White"};
        String[] draconicAncestryElement = {"Acid", "Lightning", "Fire", "Lightning", "Acid", "Fire", "Poison", "Fire", "Cold", "Cold"};
        RPGCharacterSheet.label.setText("Choose your Draconic Ancestry");
        ButtonBar row1 = new ButtonBar();
        row1.setTranslateX(-10);
        ButtonBar row2 = new ButtonBar();
        row2.setTranslateX(-10);
        Button continueButton = new Button("Continue");
        continueButton.setDisable(true);
        for (int i = 0; i < draconicAncestryColor.length; i++) {
            Button ancestryColor = new Button(draconicAncestryColor[i]);
            ancestryColor.setTooltip(new Tooltip(draconicAncestryElement[i]));
            ancestryColor.setOnAction(e->{ continueButton.setOnAction(continueButtonEvent ->{character.skills.add("Damage resistance: " + ancestryColor.getTooltip().getText());
                character.setRace("Dragonborn ("+ancestryColor.getText() +")");
                dragonbornStage.close();});
            continueButton.setDisable(false);
            });
           if (i<5){
               row1.getButtons().add(ancestryColor);
           }else row2.getButtons().add(ancestryColor);
        }
        pane.getChildren().addAll(RPGCharacterSheet.label,row1,row2,continueButton);
        pane.setStyle("-fx-border-color: black");
    }

    /**
     * To Set up a halfling raced based Character if that was the race they chose
     * @param character Character the race attributes are being applied to
     */
    public static void halfling(CharacterSheet character, Stage halflingStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(pane,350,150);
        halflingStage.setScene(scene);
        halflingStage.setTitle("Halfling");

        abilityAddition(character, 3, 2);
        character.setSpeed(character.getSpeed()+25);
        character.skills.add("Lucky");
        character.skills.add("Brave");
        character.skills.add("Halfling Nimbleness");
        character.languages.add("Common");
        character.languages.add("Halfling");
        availableLanguages.removeAll("Common","Halfling");

        RPGCharacterSheet.label.setText("Skills added: Lucky, Brave, Halfling Nimbleness\nWhat type of Halfling are you Lightfoot or Stout");

        ButtonBar row1 = new ButtonBar();
        Button lightfoot = new Button("Lightfoot");
        Button stout = new Button("Stout");
        Button continueButton = new Button("Continue");
        continueButton.setDisable(true);
        row1.getButtons().addAll(lightfoot,stout);
        row1.setTranslateX(-90);

        lightfoot.setOnAction(e->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueButtonEvent ->{
                abilityAddition(character, 1, 1);
                character.skills.add("Naturally Stealthy");
                character.setRace("Halfling (Lightfoot)");
                halflingStage.close();

            });
        });

        stout.setOnAction(e->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueButtonEvent ->{
                abilityAddition(character, 6, 1);
                character.skills.add("Stout Resilience");
                character.setRace("Halfling (Stout)");
                halflingStage.close();

            });
        });

        pane.getChildren().addAll(RPGCharacterSheet.label,row1,continueButton);
    }

    /**
     * To Set up a gnome raced based Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     */
    private static void gnome(CharacterSheet character, Stage gnomeStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(pane,375,150);
        gnomeStage.setScene(scene);
        gnomeStage.setTitle("Gnome");

        abilityAddition(character, 5, 2);
        character.setSpeed(character.getSpeed()+25);
        character.skills.add("Darkvision");
        character.skills.add("Gnome Cunning");
        character.languages.add("Common");
        character.languages.add("Gnomish");


        label.setText("Skills Added: Darkvision and gnome Cunning added to skills\nLanguages learned: Common and Gnomish!\n\nWhich type of gnome are you, a Forest Gnome or Rock Gnome?");
        ButtonBar row1 = new ButtonBar();
        Button forestGnome = new Button("Forest Gnome");
        Button rockGnome = new Button("Rock Gnome");

        row1.getButtons().addAll(forestGnome,rockGnome);
        row1.setTranslateX(-75);

        forestGnome.setOnAction(e->{
            abilityAddition(character, 3, 1);
            character.skills.add("Natural Illusionist");
            character.skills.add("Speak with Small Beasts");
            gnomeStage.close();

        });
        rockGnome.setOnAction(e->{
            abilityAddition(character, 6, 1);
            character.skills.add("Artificer's Lore");
            character.skills.add("Tinker");
            gnomeStage.close();
        });

        pane.getChildren().addAll(label,row1);

    }

    /**
     * To Set up a tiefling raced based Character if that was the race they chose
     *
     * @param character Character the race attributes are being applied to
     */
    private static void tiefling(CharacterSheet character, Stage tieflingStage) {
        VBox pane = new VBox(20);
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setColor(Color.gray(.5));
        pane.setEffect(innerShadow);
        pane.setStyle("-fx-border-color: black");
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(pane, 400, 130);
        tieflingStage.setScene(scene);
        tieflingStage.setTitle("Tiefling");

        abilityAddition(character, 5, 1);
        character.setSpeed(character.getSpeed() + 30);
        character.skills.add("Darkvision");
        character.skills.add("Hellish Resistance");
        character.skills.add("Infernal Legacy");
        character.languages.add("Common");
        character.languages.add("Infernal");
        label.setText("Skills added : Darkvision , Hellish Resistance, and Infernal Legacy\n\nLanguages learned: Common and Infernal");

        Button continueButton = new Button("Continue");
        continueButton.setOnAction(e-> tieflingStage.close());
        pane.getChildren().addAll(label,continueButton);


    }

    /**
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param choice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    private static void abilityAddition(CharacterSheet character, int choice, int modifierAddtion) {
        if (choice == 1) {
            character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma +" + modifierAddtion);
            character.setCharismaMod(findAbilityMod(character.getCharismaScore()));
            System.out.println("Charisma Modifier " + character.getCharismaMod());
        }
        if (choice == 2) {
            character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength +" + modifierAddtion);
            character.setStrengthMod(findAbilityMod(character.getStrengthScore()));
            System.out.println("Strength Modifier " + character.getStrengthMod());
        }
        if (choice == 3) {
            character.setDexterityScore(character.getDexterityScore() + modifierAddtion);
            System.out.println("Dexterity +" + modifierAddtion);
            character.setDexterityMod(findAbilityMod(character.getDexterityScore()));
            System.out.println("Dexterity Modifier " + character.getDexterityMod());
        }
        if (choice == 4) {
            character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom +" + modifierAddtion);
            character.setWisdomMod(findAbilityMod(character.getWisdomScore()));
            System.out.println("Wisdom Modifier " + character.getWisdomMod());
        }
        if (choice == 5) {
            character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence +" + modifierAddtion);
            character.setIntelligenceMod(findAbilityMod(character.getIntelligenceScore()));
            System.out.println("Intelligence Modifier " + character.getIntelligenceMod());
        }
        if (choice == 6) {
            character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution +" + modifierAddtion);
            character.setConstitutionMod(findAbilityMod(character.getConstitutionScore()));
            System.out.println("Constitution Modifier " + character.getConstitutionMod());

        }
    }

    /**
     * Adds scores to a VBox, and on action they will call abilityAddition
     * @param character Character that the code is pulling the abilities / scores from
     */
    private static VBox abilityPrintoutAndAdd(CharacterSheet character, int modifierAddition) {
        VBox abilities = new VBox(20);
        abilities.setAlignment(Pos.CENTER);

        Button charisma = new Button("Charisma");
        charisma.setTooltip(new Tooltip("Charisma : " + character.getCharismaScore()));

        Button strength = new Button("Strength");
        strength.setTooltip(new Tooltip("Strength : " + character.getStrengthScore()));

        Button dexterity = new Button("Dexterity");
        dexterity.setTooltip(new Tooltip("Dexterity : " + character.getDexterityMod()));


        Button wisdom = new Button("Wisdom");
        wisdom.setTooltip(new Tooltip("Wisdom : " + character.getWisdomScore()));


        Button intelligence = new Button("Intelligence");
        intelligence.setTooltip(new Tooltip("Intelligence : " + character.getIntelligenceScore()));


        Button constitution = new Button("Constitution");
        constitution.setTooltip(new Tooltip("Constitution : " + character.getConstitutionScore()));


        ButtonBar row1 = new ButtonBar();
        row1.getButtons().addAll(charisma,strength,dexterity);

        ButtonBar row2 = new ButtonBar();
        row2.getButtons().addAll(wisdom,intelligence,constitution);

        charisma.setOnAction(e->{
            abilityAddition(character,1,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        strength.setOnAction(e-> {
            abilityAddition(character,2,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);});
        dexterity.setOnAction(e->{
            abilityAddition(character,3,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        wisdom.setOnAction(e-> {
            abilityAddition(character,4,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        intelligence.setOnAction(e-> {
            abilityAddition(character,5,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        constitution.setOnAction(e->{
            abilityAddition(character,6,modifierAddition);
            row1.setDisable(true);
            row2.setDisable(true);
        } );

        row1.setButtonMinWidth(100);
        row2.setButtonMinWidth(100);
        row1.setTranslateX(-30);
        row2.setTranslateX(-30);
        abilities.getChildren().addAll(row1,row2);

        return abilities;
    }


    /**
     * Takes in the Ability Score, and finds the appropriate modifier and returns that modifier
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    private static int findAbilityMod(int abilityScore) {
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
     * launch(args) calls Application, Application calls start. Calls Ma
     * @param primaryStage Main stage for application
     */
    @Override
    public void start(Stage primaryStage) {

        CharacterSheet character = new CharacterSheet();
        mainStage(primaryStage, character);


    }

    /** Creates the main Character Sheet stage where all the information is stored.
     *
     * @param primaryStage Primary stage of the application
     * @param mainCharacter Character sheet object to hold character information
     */
    private void mainStage(Stage primaryStage, CharacterSheet mainCharacter) {
       //Stage set up
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

        //Buttons
        Button continueButton = new Button("Continue");
        Button setAge = new Button("Edit age");
        Button editLevel = new Button("Edit level");
        Button editName = new Button("Edit Name");
        Button editRace = new Button("Edit Race");
        Button editClass = new Button("Edit Class");
        Button editAbilities = new Button("Edit Abilities");

        //ListViews
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

        ObservableList languages = FXCollections.observableArrayList(mainCharacter.languages);
        ListView languagesList = new ListView(languages);
        languagesList.setPlaceholder(new Label("--- Languages --- "));


        //ListView SetUp
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

        //Labels
        Label age = new Label("Age: "+ mainCharacter.getAge());
        Label name = new Label("Name: " + mainCharacter.getName());
        Label race = new Label("Race: " + mainCharacter.getRace());
        Label characterClass = new Label("Class: " + mainCharacter.getCharacterClass());
        Label ac = new Label("AC: " + mainCharacter.getAc());
        Label hp = new Label("Hit Points: "+ mainCharacter.getHitPoints());
        Label speed = new Label("Speed: "+ mainCharacter.getSpeed());
        Label alignment = new Label("Alignment: ");
        Label level = new Label("Level: "+ mainCharacter.getLevel());

        //Sets BorderPane left
        VBox left = new VBox();
        VBox abilities = new VBox();

        // Set Name
        layout.add(name, 0, 0);
        name.setPrefWidth(150);

        editName.setOnAction(e -> {name.setText(chooseName(continueButton,  mainCharacter));
            name.setTooltip(new Tooltip(mainCharacter.getName()));});
        layout.add(editName, 0, 1);
        name.setStyle("-fx-Text-fill: Black;");
        name.setUnderline(true);

        // Set Race
        //TODO add specific methods for Race
        // TODO create undo / anti races for when the user changed race
        race.setPrefWidth(100);
        race.setWrapText(true);
//        editRace.setDisable(true);
        editRace.setOnAction(e -> {
            if (confirmingPopUp("Continuing will erase your current configurations\nWould you like to continue?")==true){
                skills.clear();
                mainCharacter.skills.clear();
                languages.clear();
                mainCharacter.languages.clear();
                race.setText(chooseRace(continueButton, mainCharacter));
                race.setTooltip(new Tooltip(mainCharacter.getRace()));
                setAge.setDisable(false);
                age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
                languages.setAll(mainCharacter.languages);
                skills.setAll(mainCharacter.skills);
                skillsList.setItems(skills);
                updateAbilities(abilities,mainCharacter);
                speed.setText("Speed: " + mainCharacter.getSpeed());
                hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
            }
            });

        layout.add(editRace, 1, 1);
        layout.add(race, 1, 0);
        race.setStyle("-fx-Text-fill: black;");
        race.setUnderline(true);

        // Set Class
        layout.add(characterClass, 2, 0);
        characterClass.setPrefWidth(100);
        layout.add(editClass, 2, 1);
        characterClass.setStyle("-fx-Text-fill: black;");
        characterClass.setUnderline(true);

        editClass.setOnAction(e -> {
           if (confirmingPopUp("Continuing will erase your current configurations\nWould you like to continue?")==true){
               mainCharacter.armorList.clear();
               armor.clear();
               mainCharacter.weapons.clear();
               weapons.clear();
               mainCharacter.inventory.clear();
               inventory.clear();
               mainCharacter.setAc(0);
               characterClass.setText(chooseClass(continueButton,mainCharacter ));
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
               editAbilities.setDisable(false);
               ac.setText("AC: " + mainCharacter.getAc());
               updateAbilities(abilities,mainCharacter);
               speed.setText("Speed: " + mainCharacter.getSpeed());
//               primaryStage.setScene(refreshStage(primaryStage,mainCharacter));
           }
           });

        // Set Age
        age.setUnderline(true);
        age.setPrefWidth(100);
        layout.add(age,3,0);
        setAge.setDisable(true);
        age.setTooltip(new Tooltip("Missing race selection"));
        setAge.setOnAction(e->{ setAge(mainCharacter);
            age.setText("Age: " + mainCharacter.getAge());
            age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
        });
        layout.add(setAge,3,1);

        //Set Character Specific Misc
        ObservableList misc = FXCollections.observableArrayList();
        ListView miscList = new ListView(misc);
        miscList.setPlaceholder(new Label("--- Miscellaneous ---"));

        //Sets AC
        ac.setUnderline(true);
        layout.add(ac,5,0);

        //Sets HP
        hp.setUnderline(true);
        layout.add(hp, 5,1);

        //Sets Speed
        speed.setUnderline(true);
        layout.add(speed, 6,0);

        //Sets Alignment
        ObservableList alignmentOptions = FXCollections.observableArrayList();
        alignmentOptions.addAll("Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "True Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Neutral","Chaotic Evil");
        ChoiceBox<String> alignmentChoiceBox = new ChoiceBox<>(alignmentOptions);
        alignmentChoiceBox.setOnAction(e-> mainCharacter.setAlignment(alignmentChoiceBox.getValue()));
        alignment.setUnderline(true);
        layout.add(alignment,6,1);
        layout.add(alignmentChoiceBox,7,1);

        // Sets Abilities
        abilities.setTranslateY(12);
        abilities.setStyle("-fx-border-color: black");
        abilities.setMaxHeight(150);
        abilities.setPadding(new Insets(10,10,10,10));
        Label charisma = new Label("Charisma: " + mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod());
        Label strength = new Label("Strength: " + mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod());
        Label dexterity = new Label("Dexterity: " + mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod());
        Label wisdom = new Label("Wisdom: " + mainCharacter.getWisdomScore() + " / " + mainCharacter.getWisdomMod());
        Label intelligence = new Label("Intelligence: " + mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod());
        Label constitution = new Label("Constitution: " + mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod());

        editAbilities.setDisable(true);
        editAbilities.setOnAction(e-> {
            chooseAbilities(continueButton,mainCharacter);
            updateAbilities(abilities,mainCharacter);
            editLevel.setDisable(false);
            level.setTooltip(null);
            editRace.setDisable(false);
            editAbilities.setDisable(true);

        });
        abilities.getChildren().addAll(editAbilities,charisma, strength, dexterity, wisdom, intelligence,constitution);

        //Set Level
        editLevel.setDisable(true);
        level.setTooltip(new Tooltip("Missing class selection"));
        level.setUnderline(true);
        layout.add(level,4,0);
        layout.add(editLevel,4,1);
        editLevel.setOnAction(e->{
            setLevel(mainCharacter);
            level.setText("Level: " + mainCharacter.getLevel());
            proficienciesList.setItems(mainCharacter.getProficienciesList());
            featuresList.setItems(mainCharacter.getFeaturesList());
            miscList.setItems(mainCharacter.getMisc());
            ac.setText("AC: " + mainCharacter.getAc());
            hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
            updateAbilities(abilities,mainCharacter);
            speed.setText("Speed: " + mainCharacter.getSpeed());
        });


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

    /**
     * Opens new Stage for user to change their name
     * @param continueButton Button that will allow the continuation
     * @param mainCharacter Character that they are changing the name to.
     * @return Name of Character
     */
    private static String chooseName(Button continueButton, CharacterSheet mainCharacter) {
        VBox pane = new VBox(15);

        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        pane.setPadding(new Insets(50, 20, 50, 20));

        Scene scene = new Scene(pane, 400, 200);
        Stage nameStage = new Stage();
        nameStage.setScene(scene);
        nameStage.setResizable(false);

        Label askName = new Label("What is your Characters name?");

        TextArea name = new TextArea();
        name.setMaxSize(165, 20);
        name.setWrapText(true);

        continueButton.setOnAction(e -> {
            mainCharacter.setName(name.getText());
            nameStage.close();
        });

        pane.getChildren().addAll(askName,name,continueButton);
        pane.setAlignment(Pos.TOP_CENTER);
        nameStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black");
        nameStage.initModality(Modality.APPLICATION_MODAL);
        nameStage.showAndWait();

        return "Name: " + name.getText();
    }


    /**
     * Allows user to select the race of their character though a list of possible races
     * @return String of the race the user chose
     */
    private static String chooseRace(Button continueButton, CharacterSheet mainCharacter) {
//   "Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"
        RPGCharacterSheet.label.setText("");
        continueButton.setDisable(true);
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(30,30,30,30));
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        Scene scene = new Scene(pane, 400, 300);
        pane.setPadding(new Insets(20,10,10,20));
        Stage raceStage = new Stage();
        raceStage.setScene(scene);
        raceStage.setResizable(false);
        Label chooseRace = new Label("Choose your race.");
        chooseRace.setMaxWidth(100);
        Button elf = new Button("Elf");
        elf.setOnAction(e -> {
            mainCharacter.setRace("Elf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
            continueButton.setOnAction(continueEvent->
                elf(mainCharacter,raceStage));
        });

        Button halfElf = new Button("Half-elf");
        halfElf.setOnAction(e -> {
            mainCharacter.setRace("Half-elf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
            continueButton.setOnAction(event ->
                halfElf(mainCharacter,raceStage));

        });


        Button human = new Button("Human");
        human.setOnAction(e -> {
            continueButton.setOnAction(event ->
                human(mainCharacter,raceStage));
            mainCharacter.setRace("Human");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button dragonBorn = new Button("Dragonborn");
        dragonBorn.setOnAction(e -> {
            continueButton.setOnAction(event -> dragonBorn(mainCharacter,raceStage));
            mainCharacter.setRace("Dragonborn");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });


        Button dwarf = new Button("Dwarf");
        dwarf.setOnAction(e -> {
            continueButton.setOnAction(event ->
                dwarf(mainCharacter,raceStage));
            mainCharacter.setRace("dwarf");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button halfling = new Button("Halfling");
        halfling.setOnAction(e -> {
            continueButton.setOnAction(event -> halfling(mainCharacter,raceStage)
            );
            mainCharacter.setRace("Halfling");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button gnome = new Button("Gnome");
        gnome.setOnAction(e -> {
            continueButton.setOnAction(event ->
                gnome(mainCharacter,raceStage));
            mainCharacter.setRace("Gnome");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button halfOrc = new Button("Half-Orc");
        halfOrc.setOnAction(e -> {
            continueButton.setOnAction(event -> halfOrc(mainCharacter,raceStage));
            mainCharacter.setRace("Half-Orc");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button tiefling = new Button("Tiefling");
        tiefling.setOnAction(e -> {
            continueButton.setOnAction(event -> tiefling(mainCharacter,raceStage));
            mainCharacter.setRace("Tiefling");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        ButtonBar row1 = new ButtonBar();
        row1.getButtons().addAll(elf,halfElf,human);
        row1.setTranslateX(-60);

        ButtonBar row2 = new ButtonBar();
        row2.getButtons().addAll(dragonBorn,dwarf,halfling);
        row2.setTranslateX(-50);

        ButtonBar row3 = new ButtonBar();
        row3.getButtons().addAll(gnome,halfOrc,tiefling);
        row3.setTranslateX(-60);

        pane.getChildren().addAll(chooseRace,row1,row2,row3,label,continueButton);

        pane.setAlignment(Pos.TOP_CENTER);
        raceStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black");
        raceStage.initModality(Modality.APPLICATION_MODAL);
        raceStage.showAndWait();

        return "Race: " + mainCharacter.getRace();


    }

    /**
     * Allows user to select the class of their character though a list of possible Classes
     * @return String of the Race the user chose
     */
    private static String chooseClass(Button continueButton, CharacterSheet mainCharacter) {
        // "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"

        RPGCharacterSheet.label.setText("");

        VBox layout=new VBox(20);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        layout.setEffect(shadow);
        Scene scene = new Scene(layout, 400, 375);
        Stage classStage = new Stage();
        classStage.setScene(scene);
        classStage.setResizable(false);

        layout.setStyle("-fx-border-color: black");

        continueButton.setOnAction(e ->{
            if (mainCharacter.getCharacterClass().equals("Barbarian")) {
            Barbarian barbarianCharacter = new Barbarian(mainCharacter);
            barbarianCharacter.chooseArmor(classStage); }
        });
        continueButton.setDisable(true);

        Label chooseClass = new Label("Choose your class.");
        Button barbarian = new Button("Barbarian");
        barbarian.setOnAction(event -> {
            mainCharacter.setCharacterClass("Barbarian");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);

        });
        Button bard = new Button("Bard");
        bard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Bard");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button cleric = new Button("Cleric");
        cleric.setOnAction(event -> {
            mainCharacter.setCharacterClass("Cleric");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button druid = new Button("Druid");
        druid.setOnAction(event -> {
            mainCharacter.setCharacterClass("Druid");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button fighter = new Button("Fighter");
        fighter.setOnAction(event -> {
            mainCharacter.setCharacterClass("Fighter");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button monk = new Button("Monk");
        monk.setOnAction(event -> {
            mainCharacter.setCharacterClass("Monk");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button paladin = new Button("Paladin");
        paladin.setOnAction(event -> {
            mainCharacter.setCharacterClass("Paladin");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button ranger = new Button("Ranger");
        ranger.setOnAction(event -> {
            mainCharacter.setCharacterClass("Ranger");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button rogue = new Button("Rogue");
        rogue.setOnAction(event -> {
            mainCharacter.setCharacterClass("Rogue");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button sorcerer = new Button("Sorcerer");
        sorcerer.setOnAction(event -> {
            mainCharacter.setCharacterClass("Sorcerer");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button warlock = new Button("Warlock");
        warlock.setOnAction(event -> {
            mainCharacter.setCharacterClass("Warlock");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button wizard = new Button("Wizard");
        wizard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Wizard");
            RPGCharacterSheet.label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });

        ButtonBar row1 = new ButtonBar();
        row1.getButtons().addAll(barbarian,bard,cleric);
        row1.setTranslateX(-75);

        ButtonBar row2 = new ButtonBar();
        row2.getButtons().addAll(druid,fighter,monk);
        row2.setTranslateX(-75);

        ButtonBar row3 = new ButtonBar();
        row3.getButtons().addAll(paladin,ranger,rogue);
        row3.setTranslateX(-75);

        ButtonBar row4 = new ButtonBar();
        row4.getButtons().addAll(sorcerer,warlock,wizard);
        row4.setTranslateX(-75);

        layout.getChildren().addAll(chooseClass,row1,row2,row3,row4,label,continueButton);

        layout.setAlignment(Pos.CENTER);
        classStage.initStyle(StageStyle.TRANSPARENT);
        classStage.initModality(Modality.APPLICATION_MODAL);
        classStage.showAndWait();

        return "Class: " + mainCharacter.getCharacterClass();

    }

    /**
     * Creates new Stage for user to add their ability scores from a pre-generated list of random D20 rolls
     * @param continueButton Button that will allow continuation on next steps
     * @param characterSheet Character that they are changing the Ability scores to.
     */
    private void chooseAbilities(Button continueButton, CharacterSheet characterSheet) {
        Stage chooseAbilities = new Stage();
        chooseAbilities.setResizable(false);
        chooseAbilities.setTitle("Choose Abilities");
        VBox abilities = new VBox(20);
        abilities.setPadding(new Insets(10,10,10,10));
        abilities.setAlignment(Pos.TOP_CENTER);
        HBox horizontal = new HBox();
        horizontal.setAlignment(Pos.CENTER);
        VBox rollsBox = new VBox(10);
        rollsBox.setAlignment(Pos.CENTER);
        ChoiceBox<Integer> rolls = new ChoiceBox();
        Label selectChoice = new Label("Choice Selection");
        selectChoice.setWrapText(true);
        rollsBox.getChildren().addAll(selectChoice,rolls);
        horizontal.getChildren().addAll(abilities,rollsBox);

//        String[] abilityNames = {"Charisma, ""Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        if (d20Rolls[0] == 0){
            for (int i = 0; i < 6; i++) {
                d20Rolls[i] = d20Roll();
            }
        }
        Label diceRolls = new Label("Your D20 Rolls : " + d20Rolls[0] + " | " + d20Rolls[1] + " | " + d20Rolls[2] + " | " + d20Rolls[3] + " | " + d20Rolls[4] + " | " + d20Rolls[5] + " | \nChoose your ability scores.");


        rolls.setItems(FXCollections.observableArrayList(d20Rolls[0],d20Rolls[1],d20Rolls[2],d20Rolls[3],d20Rolls[4],d20Rolls[5]));
        abilities.getChildren().add(diceRolls);
        abilities.getChildren().add(new Label("Charisma"));
        abilities.getChildren().add(new Label("Strength"));
        abilities.getChildren().add(new Label("Dexterity"));
        abilities.getChildren().add(new Label("Wisdom"));
        abilities.getChildren().add(new Label("Intelligence"));
        abilities.getChildren().add(new Label("Constitution"));
        rolls.setOnAction(charisma -> {

            // Charisma setup
               try {
                   characterSheet.setCharismaScore(rolls.getValue() + characterSheet.getCharismaScore());
                    characterSheet.setCharismaMod(findAbilityMod(characterSheet.getCharismaScore()));
                    rolls.getItems().remove(rolls.getValue());
                    abilities.getChildren().set(1,new Label("Charisma : " + characterSheet.getCharismaScore() + "/ " + characterSheet.getCharismaMod()));

                // Strength Set up

                    rolls.setOnAction(strength -> {
                        try {
                            characterSheet.setStrengthScore(rolls.getValue() + characterSheet.getStrengthScore());
                            characterSheet.setStrengthMod(findAbilityMod(characterSheet.getStrengthScore()));
                            rolls.getItems().remove(rolls.getValue());
                            abilities.getChildren().set(2,new Label("Strength : " + characterSheet.getStrengthScore() + "/ " + characterSheet.getStrengthMod()));

                            // Dexterity setup
                            rolls.setOnAction(dexterity -> {
                                try {
                                    characterSheet.setDexterityScore(rolls.getValue() + characterSheet.getDexterityScore());
                                    characterSheet.setDexterityMod(findAbilityMod(characterSheet.getDexterityScore()));
                                    rolls.getItems().remove(rolls.getValue());
                                    abilities.getChildren().set(3,new Label("Dexterity : " + characterSheet.getDexterityScore() + "/ " + characterSheet.getDexterityMod()));

                                    //Wisdom setup
                                    rolls.setOnAction(wisdom -> {
                                        try {
                                            characterSheet.setWisdomScore(rolls.getValue() + characterSheet.getWisdomScore());
                                            characterSheet.setWisdomMod(findAbilityMod(characterSheet.getWisdomScore()));
                                            rolls.getItems().remove(rolls.getValue());
                                            abilities.getChildren().set(4,new Label("Wisdom : " + characterSheet.getWisdomScore() + "/ " + characterSheet.getWisdomMod()));

                                            //Intelligence setup
                                            rolls.setOnAction(intelligence -> {
                                                try {
                                                    characterSheet.setIntelligenceScore(rolls.getValue() + characterSheet.getIntelligenceScore());
                                                    characterSheet.setIntelligenceMod(findAbilityMod(characterSheet.getIntelligenceScore()));
                                                    rolls.getItems().remove(rolls.getValue());
                                                    abilities.getChildren().set(5,new Label("Intelligence : " + characterSheet.getIntelligenceScore() + "/ " + characterSheet.getIntelligenceMod()));
                                                    // Constitution setup
                                                    rolls.setOnAction(constitution -> {
                                                        try {
                                                            characterSheet.setConstitutionScore(rolls.getValue()+ characterSheet.getConstitutionScore());

                                                            characterSheet.setConstitutionMod(findAbilityMod(characterSheet.getConstitutionScore()));
                                                            rolls.getItems().remove(rolls.getValue());
                                                            abilities.getChildren().set(6,new Label("Constitution : " + characterSheet.getConstitutionScore() + "/ " + characterSheet.getConstitutionMod()));
                                                            abilities.getChildren().add(continueButton);
                                                            horizontal.getChildren().remove(rolls);
                                                            rolls.setDisable(true);
                                                            continueButton.setOnAction(close -> chooseAbilities.close());
                                                        } catch (NullPointerException Con) {
                                                        }
                                                    });
                                                }catch (NullPointerException Intelligence){}});
                                        }catch (NullPointerException Wisdom){}});
                                }catch (NullPointerException Dexterity){}});
                        } catch (NullPointerException Strength){}});
            } catch ( NullPointerException Charisma){}});

            Scene scene = new Scene(horizontal,350,350);
            chooseAbilities.setScene(scene);
            chooseAbilities.initModality(Modality.APPLICATION_MODAL);
            chooseAbilities.initStyle(StageStyle.TRANSPARENT);
            horizontal.setStyle("-fx-border-color: black");
            chooseAbilities.showAndWait();
        }

    /**
     * Creates new Stage for the user to set the age for their Character from 0-350 Maximum
     * @param mainCharacter Character that they are setting the Age for
     */
    private void setAge(CharacterSheet mainCharacter){

            Stage setAgeStage = new Stage();
            setAgeStage.setResizable(false);
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

    /**
     * Creates Stage for the user to set the stage that their character will be. It then calls the respected class that the user has chosen previously for the chosen amount of levels.
     * @param mainCharacter Character that they are setting the level for
     */
    private void setLevel(CharacterSheet mainCharacter){
            Stage setLevelStage = new Stage();
            setLevelStage.setResizable(false);
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
            continueButton.setDisable(true);

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
                    barbarian.addLevel(setLevelStage,Integer.parseInt(choice.getText().split(" ")[1]),1);
                }
            });

            setLevelStage.setScene(scene);
            setLevelStage.initStyle(StageStyle.TRANSPARENT);
            pane.setStyle("-fx-border-color: black");
            setLevelStage.initModality(Modality.APPLICATION_MODAL);
            setLevelStage.showAndWait();


    }

    /**
     * Pop up message that will either let the user continue or close.
     * @param message Message that the Pop up will display
     * @return Returns True if the user wants to continue, false otherwise
     */
    private boolean confirmingPopUp(String message){
        VBox pane = new VBox(50);
        Scene scene = new Scene(pane,300,200);
        Stage popUpStage= new Stage();
        popUpStage.setScene(scene);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black");
        popUpStage.initModality(Modality.APPLICATION_MODAL);

        Label popUpMessage = new Label(message);
        Button continueButton = new Button("Continue");
        Button close = new Button("Close");
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(continueButton,close);
        buttonBar.setTranslateX(-50);
        Label choice = new Label(" ");


        continueButton.setOnAction(e-> {
            choice.setText("Continue");
            popUpStage.close();
        });
        close.setOnAction(e-> {
            choice.setText("Close");
            popUpStage.close();
        });

        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20,20,20,20));
        pane.getChildren().addAll(popUpMessage,buttonBar);
        popUpStage.showAndWait();

        if(choice.getText().equals("Continue")){
            return true;
        }else
            return false;
        }

    /**
     * Updates the abilities scores and their respected modifiers
     * @param abilities VBox that the list of Abilities is stored in
     * @param mainCharacter Character that has the Ability Score and Modifier information
     */
    private void updateAbilities(VBox abilities, CharacterSheet mainCharacter){
            abilities.setTranslateY(12);
            abilities.setStyle("-fx-border-color: black");
            abilities.setMaxHeight(150);
            abilities.setPadding(new Insets(10,10,10,10));
            Label charisma = new Label("Charisma: " + mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod());
            Label strength = new Label("Strength: " + mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod());
            Label dexterity = new Label("Dexterity: " + mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod());
            Label wisdom = new Label("Wisdom: " + mainCharacter.getWisdomScore() + " / " + mainCharacter.getWisdomMod());
            Label intelligence = new Label("Intelligence: " + mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod());
            Label constitution = new Label("Constitution: " + mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod());
            abilities.getChildren().set(1,charisma);
            abilities.getChildren().set(2,strength);
            abilities.getChildren().set(3,dexterity);
            abilities.getChildren().set(4,wisdom);
            abilities.getChildren().set(5,intelligence);
            abilities.getChildren().set(6,constitution);

        }


}

