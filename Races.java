package DungeonsAndDragons;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Vector;

public class Races extends RPGCharacterSheet {
    private static ObservableList availableLanguages = new CharacterSheet().getAllLanguages();
    private static Label label = new Label("");
    protected static Vector<Integer> raceAbilityChoices = new Vector<>();


    /**
     * Allows user to select the race of their character though a list of possible races
     * @return String of the race the user chose
     */
    protected static String chooseRace(Button continueButton, CharacterSheet mainCharacter) {
//   "Elf", "Half - Elf", "Human", "Dragonborn", "Dwarf", "Halfling", "Gnome","Half-Orc", "Tiefling"

        Races.label.setText("");
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
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
            continueButton.setOnAction(continueEvent->
                    elf(mainCharacter,raceStage));
        });

        Button halfElf = new Button("Half-Elf");
        halfElf.setOnAction(e -> {
            mainCharacter.setRace("Half-Elf");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
            continueButton.setOnAction(event ->
                    halfElf(mainCharacter,raceStage));

        });


        Button human = new Button("Human");
        human.setOnAction(e -> {
            continueButton.setOnAction(event ->
                    human(mainCharacter,raceStage));
            mainCharacter.setRace("Human");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button dragonBorn = new Button("Dragonborn");
        dragonBorn.setOnAction(e -> {
            continueButton.setOnAction(event -> dragonBorn(mainCharacter,raceStage));
            mainCharacter.setRace("Dragonborn");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });


        Button dwarf = new Button("Dwarf");
        dwarf.setOnAction(e -> {
            continueButton.setOnAction(event ->
                    dwarf(mainCharacter,raceStage));
            mainCharacter.setRace("Dwarf");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button halfling = new Button("Halfling");
        halfling.setOnAction(e -> {
            continueButton.setOnAction(event -> halfling(mainCharacter,raceStage)
            );
            mainCharacter.setRace("Halfling");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });

        Button gnome = new Button("Gnome");
        gnome.setOnAction(e -> {
            continueButton.setOnAction(event ->
                    gnome(mainCharacter,raceStage));
            mainCharacter.setRace("Gnome");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button halfOrc = new Button("Half-Orc");
        halfOrc.setOnAction(e -> {
            continueButton.setOnAction(event -> halfOrc(mainCharacter,raceStage));
            mainCharacter.setRace("Half-Orc");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
            continueButton.setDisable(false);
        });
        Button tiefling = new Button("Tiefling");
        tiefling.setOnAction(e -> {
            continueButton.setOnAction(event -> tiefling(mainCharacter,raceStage));
            mainCharacter.setRace("Tiefling");
            Races.label.setText("You have chosen " + mainCharacter.getRace());
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
     * Removes old presets from previous race choices
     * @param mainCharacter Character that you are removing the previous race choices for
     */
    protected static void resetPreviousRaceOptions(CharacterSheet mainCharacter){

        if (mainCharacter.getRace().equals("High Elf")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore() - 2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));
            System.out.println("Dex -2");
            mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-1);
            mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));
            System.out.println("Int -1");

        }
        if (mainCharacter.getRace().equals("Wood Elf")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore() - 2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));
            System.out.println("Dex -2");
            mainCharacter.setWisdomScore(mainCharacter.getWisdomScore()-1);
            mainCharacter.setWisdomMod(findAbilityMod(mainCharacter.getWisdomScore()));
            System.out.println("Wis -1");
            mainCharacter.setSpeed(mainCharacter.getSpeed() - 35);

        }
        if (mainCharacter.getRace().equals("Dark Elf")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore() - 2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));
            System.out.println("Dex -2");
            mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-1);
            mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));
            System.out.println("Char -1");

        }
        if (mainCharacter.getRace().equals("Half-Elf")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-2);
            mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));

            for (int i =0 ; i<2; i++){
                if (raceAbilityChoices.get(i)==1){
                    mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-1);
                    mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));
                }
                if (raceAbilityChoices.get(i)==2){
                    mainCharacter.setStrengthScore(mainCharacter.getStrengthScore()-1);
                    mainCharacter.setStrengthMod(mainCharacter.getStrengthScore());
                }
                if (raceAbilityChoices.get(i)==3){
                    mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-1);
                    mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));
                }
                if (raceAbilityChoices.get(i)==4){
                    mainCharacter.setWisdomScore(mainCharacter.getWisdomScore()-1);
                    mainCharacter.setWisdomMod(findAbilityMod(mainCharacter.getWisdomScore()));
                }
                if (raceAbilityChoices.get(i)==5){
                    mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-1);
                    mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));
                }
                if (raceAbilityChoices.get(i)==6){
                    mainCharacter.setConstitutionScore(mainCharacter.getConstitutionScore()-1);
                    mainCharacter.setConstitutionMod(findAbilityMod(mainCharacter.getConstitutionMod()));

                }
            }

        }
        if (mainCharacter.getRace().equals("Human")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);
            mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-1);
            mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));

            mainCharacter.setStrengthScore(mainCharacter.getStrengthScore()-1);
            mainCharacter.setStrengthMod(mainCharacter.getStrengthScore());

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-1);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

            mainCharacter.setWisdomScore(mainCharacter.getWisdomScore()-1);
            mainCharacter.setWisdomMod(findAbilityMod(mainCharacter.getWisdomScore()));

            mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-1);
            mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));

            mainCharacter.setConstitutionScore(mainCharacter.getConstitutionScore()-1);
            mainCharacter.setConstitutionMod(findAbilityMod(mainCharacter.getConstitutionMod()));

        }
        if (mainCharacter.getRace().contains("Dragonborn")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setStrengthScore(mainCharacter.getStrengthScore()-2);
            mainCharacter.setStrengthMod(findAbilityMod(mainCharacter.getStrengthScore()));

            mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-1);
            mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));

        }
        if (mainCharacter.getRace().equals("Dwarf (Mountain)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

            mainCharacter.setWisdomScore(mainCharacter.getWisdomScore()-2);
            mainCharacter.setWisdomMod(findAbilityMod(mainCharacter.getWisdomScore()));
        }
        if (mainCharacter.getRace().equals("Dwarf (Hill)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);
            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

            mainCharacter.setStrengthScore(mainCharacter.getStrengthScore()-2);
            mainCharacter.setStrengthMod(findAbilityMod(mainCharacter.getStrengthScore()));
        }
        if (mainCharacter.getRace().equals("Halfling (Lightfoot)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-25);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

            mainCharacter.setCharismaScore(mainCharacter.getCharismaScore()-1);
            mainCharacter.setCharismaMod(findAbilityMod(mainCharacter.getCharismaScore()));

        }
        if (mainCharacter.getRace().equals("Halfling (Stout)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-25);

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-2);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

            mainCharacter.setConstitutionScore(mainCharacter.getConstitutionScore()-1);
            mainCharacter.setConstitutionMod(findAbilityMod(mainCharacter.getConstitutionMod()));

        }
        if (mainCharacter.getRace().equals("Gnome (Forest)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-25);

            mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-2);
            mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));

            mainCharacter.setDexterityScore(mainCharacter.getDexterityScore()-1);
            mainCharacter.setDexterityMod(findAbilityMod(mainCharacter.getDexterityScore()));

        }
        if (mainCharacter.getRace().equals("Gnome (Rock)")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-25);

            mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-2);
            mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));

            mainCharacter.setConstitutionScore(mainCharacter.getConstitutionScore()-1);
            mainCharacter.setConstitutionMod(findAbilityMod(mainCharacter.getConstitutionMod()));

        }
        if (mainCharacter.getRace().equals("Half-Orc")){
            mainCharacter.setSpeed(mainCharacter.getSpeed()-30);

            mainCharacter.setStrengthScore(mainCharacter.getStrengthScore()-2);
            mainCharacter.setStrengthMod(findAbilityMod(mainCharacter.getStrengthScore()));

            mainCharacter.setConstitutionScore(mainCharacter.getConstitutionScore()-1);
            mainCharacter.setConstitutionMod(findAbilityMod(mainCharacter.getConstitutionMod()));


        }if (mainCharacter.getRace().equals("Tiefling")){
            mainCharacter.setSpeed(mainCharacter.getSpeed() -30);

            mainCharacter.setIntelligenceScore(mainCharacter.getIntelligenceScore()-1);
            mainCharacter.setIntelligenceMod(findAbilityMod(mainCharacter.getIntelligenceScore()));

        }


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
        Races.availableLanguages.remove("Dwarvish");
        abilityAddition(character, 3, 2);
        character.setSpeed(character.getSpeed()+ 30);
        character.skills.add("Darkvision");
        character.skills.add("Dwarven Resilience");
        character.skills.add("Dwarven Combat Training");
        character.skills.add("Tool Proficiency");
        character.skills.add("Stonecunning");
        Races.label.setText("Skills added : Darkvision, Dwarven Resilience, Dwarven Combat Training,\nTool Proficiency, and Stonecunning\n\n                             Are you a Hill Dwarf or Mountain Dwarf?");

        Button hillDwarf = new Button("Hill Dwarf");
        Button mountainDwarf = new Button("Mountain Dwarf");
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
                character.setRace("Dwarf (Mountain)");
                dwarfStage.close();

            });
        });
        hillDwarf.setOnAction(e->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueButtonEvent ->{
                abilityAddition(character, 2, 2);
                character.skills.add("Dwarven Armor Training");
                character.setRace("Dwarf (Hill)");
                dwarfStage.close();

            });
        });
        pane.setAlignment(Pos.TOP_CENTER);
        pane.getChildren().addAll(Races.label,row1,continueButton);

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
        Races.availableLanguages.remove("Elvish");
        character.skills.add("Darkvision");
        character.skills.add("Keen Senses");
        character.skills.add("Fey Ancestry");
        character.skills.add("Trance");
        Races.label.setText("Skills added : Darkvision, Keen Senses, Fey Ancestry, and Trance\nChoose your elf type");
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

        pane.getChildren().addAll(Races.label,elves,choice);
        highElf.setOnAction(e->{
            elfStage.setHeight(325);
            abilityAddition(character, 5, 1);
            character.skills.add("Elf Weapon Training");
            ComboBox<String> languages = new ComboBox<>(availableLanguages);
            Label chooseLanguage = new Label("Choose an additional language");
            continueButton.setDisable(true);
            languages.setOnAction(languageEvent->continueButton.setDisable(false));
            continueButton.setOnAction(continueEvent->{
                character.setRace("High Elf");
                character.languages.add(languages.getValue());
                elfStage.close();
            });
            pane.getChildren().addAll(chooseLanguage,languages,continueButton);

        });
        woodElf.setOnAction(e->{
            abilityAddition(character, 4, 1);
            character.setRace("Wood Elf");
            character.skills.add("Elf Weapon Training");
            character.setSpeed(character.getSpeed()+35);
            character.skills.add("Mask of the Wild");
            elfStage.close();


        });
        darkElf.setOnAction(e->{
            abilityAddition(character, 1, 1);
            character.setRace("Dark Elf");
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

        raceAbilityChoices.clear();
        Button continueButton = new Button("Continue");
        character.setSpeed(character.getSpeed()+30);
        character.skills.add("Darkvision");
        character.skills.add("Fey Ancestory");
        character.skills.add("Skill Versatility");
        Label skillsAdded = new Label("Skills added: Darkvision , Fey Ancestory, and Skill Versatility");
        character.languages.add("Elvish");
        Races.availableLanguages.remove("Elvish");

        abilityAddition(character, 1, 2);
        Races.label.setText("You can add +1 to two other abilities");
        pane.getChildren().addAll(skillsAdded,Races.label, abilityPrintoutAndAdd(character,1),continueButton);
        continueButton.setOnAction(e->{
            Races.label.setText("You can add +1 to one other ability");
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
        Races.label.setText("You have learned Common, and one other language!\nWhat is your second language?");
        Races.label.setWrapText(true);
        Button continueButton = new Button("Continue");
        ComboBox<String> languages = new ComboBox<>(availableLanguages);
        pane.getChildren().addAll(Races.label,languages,continueButton);
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
        Races.availableLanguages.removeAll("Common","Draconic");
        String[] draconicAncestryColor = {"Black", "Blue", "Brass", "Bronze ", "Copper", "Gold", "Green", "Red", "Silver", "White"};
        String[] draconicAncestryElement = {"Acid", "Lightning", "Fire", "Lightning", "Acid", "Fire", "Poison", "Fire", "Cold", "Cold"};
        Races.label.setText("Choose your Draconic Ancestry");
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
        pane.getChildren().addAll(Races.label,row1,row2,continueButton);
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

        Races.label.setText("Skills added: Lucky, Brave, Halfling Nimbleness\nWhat type of Halfling are you Lightfoot or Stout");

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

        pane.getChildren().addAll(Races.label,row1,continueButton);
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
            character.setRace("Gnome (Forest)");
            abilityAddition(character, 3, 1);
            character.skills.add("Natural Illusionist");
            character.skills.add("Speak with Small Beasts");
            gnomeStage.close();

        });
        rockGnome.setOnAction(e->{
            character.setRace("Gnome (Rock)");
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
            Races.raceAbilityChoices.add(1);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        strength.setOnAction(e-> {
            abilityAddition(character,2,modifierAddition);
            Races.raceAbilityChoices.add(2);
            row1.setDisable(true);
            row2.setDisable(true);});
        dexterity.setOnAction(e->{
            abilityAddition(character,3,modifierAddition);
            Races.raceAbilityChoices.add(3);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        wisdom.setOnAction(e-> {
            abilityAddition(character,4,modifierAddition);
            Races.raceAbilityChoices.add(4);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        intelligence.setOnAction(e-> {
            abilityAddition(character,5,modifierAddition);
            Races.raceAbilityChoices.add(5);
            row1.setDisable(true);
            row2.setDisable(true);
        });
        constitution.setOnAction(e->{
            abilityAddition(character,6,modifierAddition);
            Races.raceAbilityChoices.add(6);
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
}
