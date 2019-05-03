package DungeonsAndDragons.MainCharacter;

import DungeonsAndDragons.MainCharacter.Login.UserLogin;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;


public class RPGCharacterSheet extends Application {

    private static Label label = new Label("");
    private static String url = "jdbc:mysql://localhost:3306/charactersheet_database";
    private ObservableList armor = FXCollections.observableArrayList();
    private ListView armorList = new ListView();
    private ObservableList inventory = FXCollections.observableArrayList();
    private ListView inventoryList = new ListView();
    private ObservableList weapons = FXCollections.observableArrayList();
    private ListView weaponsList = new ListView();
    private ObservableList instruments = FXCollections.observableArrayList();
    private ListView instrumentsList = new ListView();
    private ObservableList features = FXCollections.observableArrayList();
    private  ListView featuresList = new ListView();
    private ObservableList proficiencies = FXCollections.observableArrayList();
    private  ListView proficienciesList = new ListView();
    private  ObservableList spells = FXCollections.observableArrayList();
    private ListView<ListView> spellsList = new ListView();
    private ObservableList raceTraits = FXCollections.observableArrayList();
    private ListView raceTraitsList = new ListView();
    private ObservableList languages = FXCollections.observableArrayList();
    private ListView languagesList = new ListView(languages);
    private ObservableList misc = FXCollections.observableArrayList();
    private ListView miscList = new ListView(misc);
    private VBox abilities = new VBox();
    private Button editAbilities = new Button("Edit Abilities");
    private Button editLevel = new Button("Edit level");
    private Button editRace = new Button("Edit Race");
    private Button continueButton = new Button("Continue");
    private Button close = new Button("Close");
    private BorderPane borderPane = new BorderPane();


    public static void main(String[] args) {
        launch(args); // Sets up program as javaFX application
    }


    /**
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param choice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public static void abilityAddition(CharacterSheet character, int choice, int modifierAddtion) {
        if (choice == 1) {
            if (character.getCharismaScore() + modifierAddtion > 30){
                character.setCharismaScore(30);
            }else character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma Score : " + character.getCharismaScore());
            character.setCharismaMod(findAbilityMod(character.getCharismaScore()));
            System.out.println("Charisma Modifier : " + character.getCharismaMod());
        }
        if (choice == 2) {
            if (character.getStrengthScore() + modifierAddtion > 30){
                character.setStrengthScore(30);
            }else character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength Score: " + character.getStrengthScore());
            character.setStrengthMod(findAbilityMod(character.getStrengthScore()));
            System.out.println("Strength Modifier " + character.getStrengthMod());
        }
        if (choice == 3) {
            if (character.getDexterityScore() + modifierAddtion > 30){
                character.setDexterityScore(30);
            }else character.setDexterityScore(character.getDexterityScore() + modifierAddtion);
            System.out.println("Dexterity Score : " + character.getDexterityScore());
            character.setDexterityMod(findAbilityMod(character.getDexterityScore()));
            System.out.println("Dexterity Modifier " + character.getDexterityMod());
        }
        if (choice == 4) {
            if (character.getWisdomScore() + modifierAddtion > 30){
                character.setWisdomScore(30);
            }else character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom Score : " + character.getWisdomScore());
            character.setWisdomMod(findAbilityMod(character.getWisdomScore()));
            System.out.println("Wisdom Modifier " + character.getWisdomMod());
        }
        if (choice == 5) {
            if (character.getIntelligenceScore() + modifierAddtion > 30){
                character.setIntelligenceScore(30);
            }else character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence Score : " + character.getIntelligenceScore());
            character.setIntelligenceMod(findAbilityMod(character.getIntelligenceScore()));
            System.out.println("Intelligence Modifier " + character.getIntelligenceMod());
        }
        if (choice == 6) {
            if (character.getConstitutionScore() + modifierAddtion > 30){
                character.setConstitutionScore(30);
            }else character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution Score : " + character.getConstitutionScore());
            character.setConstitutionMod(findAbilityMod(character.getConstitutionScore()));
            System.out.println("Constitution Modifier " + character.getConstitutionMod());

        }
    }


    /**
     * Takes in the Ability Score, and finds the appropriate modifier and returns that modifier
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    protected static int findAbilityMod(int abilityScore) {
        if (abilityScore < 1) {
            return -6;
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

//        //TODO create an Algorithm that can reflects for scores greater than 30
//        int modifier = -5;
//        for (int i = 0; i< abilityScore; i++){
//             if( i%2 == 0){
//                  modifier++;
//             }
//        }
//        return modifier;

    }



    // JavaFX methods


    /**
     * launch(args) calls Application, Application calls start. Calls Ma
     * @param primaryStage Main stage for application
     */
    @Override
    public void start(Stage primaryStage) {
        CharacterSheet character = new CharacterSheet();
        Pane characterCreation = new Pane();
        Scene scene = new Scene(characterCreation,1368,840);
        Stage characterCreationStage = new Stage();
        characterCreationStage.setScene(scene);



        Button login = new Button("Login");
        login.setOnAction(e->{
            // Login page
            boolean userLogin = UserLogin.main(character);
            if (userLogin){
                System.out.println(character.getPrimaryKey());
                mainStage(primaryStage, character);
                characterCreationStage.close();
            }
        });

        Button offline = new Button("Continue Offline");
//        offline.setId("Continue_Offline_Button");
        offline.setTooltip(new Tooltip("You will not be able to save your progress if you select this option"));
        offline.setOnAction(e->{
            System.out.println(character.getPrimaryKey());
            mainStage(primaryStage, character);
            characterCreationStage.close();
        });

        ButtonBar loginOrGuest = new ButtonBar();
        loginOrGuest.getButtons().addAll(login,offline);
        loginOrGuest.setButtonMinWidth(200);
        loginOrGuest.setTranslateX(460);
        loginOrGuest.setTranslateY(785);
        characterCreation.getChildren().add(loginOrGuest);

        scene.setFill(Color.TRANSPARENT);
        characterCreation.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("CharacterCreator.jpg"),1368,840,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        characterCreationStage.initStyle(StageStyle.DECORATED);
        characterCreationStage.initModality(Modality.APPLICATION_MODAL);
        characterCreationStage.showAndWait();
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
        borderPane.setTop(setTop(mainCharacter));
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.2));
        shadow.setRadius(5);
        borderPane.setEffect(shadow);
        Scene scene = new Scene(borderPane, 1368, 840);

        //ListViews
        //TODO add tooltip to find description / quantity for each item.
        armorList.setPlaceholder(new Label("---- Armor ----"));
        armorList.setTooltip(new Tooltip("Armor"));
//        armorList.setCellFactory(new Callback<ListView, ListCell>() {
//            @Override
//            public ListCell call(ListView param) {
//                return null;
//            }
//        });

        inventoryList.setPlaceholder(new Label("---- Inventory ----"));
        inventoryList.setTooltip(new Tooltip("Inventory"));

        weaponsList.setPlaceholder(new Label("---- Weapons ----"));
        weaponsList.setTooltip(new Tooltip("Weapons"));

        instrumentsList.setPlaceholder(new Label("---- Instruments ----"));
        instrumentsList.setTooltip(new Tooltip("Instruments"));

        featuresList.setPlaceholder(new Label("---- Features ----"));
        featuresList.setTooltip(new Tooltip("Features"));

        proficienciesList.setPlaceholder(new Label("---- Proficiencies ----"));
        proficienciesList.setTooltip(new Tooltip("Proficiencies"));

        spellsList.setPlaceholder(new Label("---- Spells ----"));
        spellsList.setTooltip(new Tooltip("Spells"));
        //TODO Add tooltips to the list views reflecting their level
        raceTraitsList.setPlaceholder(new Label("---- Race Traits ----"));
        raceTraitsList.setTooltip(new Tooltip("Race Traits"));

        languagesList.setPrefHeight(290);
        languagesList.setPlaceholder(new Label("--- Languages --- "));
        languagesList.setTooltip(new Tooltip("Languages"));

        borderPane.setCenter(setCenter());

        //Set Skills/ Borderpane Right
        borderPane.setRight(setSkillsPane(mainCharacter));

        //Sets BorderPane left
        borderPane.setLeft(setLeft(mainCharacter,primaryStage,scene));

        close.setOnAction(e-> primaryStage.close());

        borderPane.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;" + "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }

    /**
     *
     * @param mainCharacter User's CharacterSheet
     * @return GridPane that will populate the top of the borderPane
     */
    private GridPane setTop (CharacterSheet mainCharacter){
        GridPane layout = new GridPane();
        layout.setBackground(new Background(new BackgroundFill(Color.gray(1), null, null)));
        layout.setStyle("-fx-background-radius: 10;");
        layout.setPadding(new Insets(5,10,20,10));
        layout.setVgap(10);
        layout.setHgap(20);

        Button editName = new Button("Edit Name");
        Button setAge = new Button("Edit age");
        Button editClass = new Button("Edit Class");

        Label age = new Label("Age: "+ mainCharacter.getAge());
        Label race = new Label("Race: " + mainCharacter.getRace());
        Label characterClass = new Label("Class: " + mainCharacter.getCharacterClass());
        Label ac = new Label("AC: " + mainCharacter.getAc());
        Label hp = new Label("Hit Points: "+ mainCharacter.getHitPoints());
        Label speed = new Label("Speed: "+ mainCharacter.getSpeed());
        Label alignment = new Label("Alignment: ");
        Label level = new Label("Level: "+ mainCharacter.getLevel());

        // Set Name
        Label name = new Label("Name: " + mainCharacter.getName());
        layout.add(name, 0, 0);
        name.setPrefWidth(150);
        editName.setOnAction(e -> {name.setText(chooseName(continueButton,  mainCharacter));
            name.setTooltip(new Tooltip(mainCharacter.getName()));});
        layout.add(editName, 0, 1);
        name.setStyle("-fx-Text-fill: Black;");
        name.setUnderline(true);

        // Set Race
        race.setPrefWidth(100);
        race.setWrapText(true);
        editRace.setDisable(true);
        editRace.setOnAction(e -> {
            if (confirmingPopUp("Continuing will erase your current configurations\nWould you like to continue?")==true){
                if (!mainCharacter.getRace().equals("")){
                    Races.resetPreviousRaceOptions(mainCharacter);
                    Abilities.updateAbilities(abilities,mainCharacter);
                }
                raceTraits.clear();
                mainCharacter.raceTraits.clear();
                languages.clear();
                mainCharacter.languages.clear();
                race.setText(Races.chooseRace(continueButton, mainCharacter));
                race.setTooltip(new Tooltip(mainCharacter.getRace()));
                setAge.setDisable(false);
                age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
                languages.setAll(mainCharacter.languages);
                raceTraits.setAll(mainCharacter.raceTraits);
                raceTraitsList.setItems(raceTraits);
                Abilities.updateAbilities(abilities,mainCharacter);
                speed.setText("Speed: " + mainCharacter.getSpeed());
                hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
                mainCharacter.setBaseHitPoints(mainCharacter.getHitPoints());
                mainCharacter.setBaseSpeed(mainCharacter.getSpeed());
                borderPane.setRight(setSkillsPane(mainCharacter));
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
                armor.clear();
                mainCharacter.weapons.clear();
                weapons.clear();
                mainCharacter.inventory.clear();
                inventory.clear();
                mainCharacter.instruments.clear();
                instruments.clear();
                mainCharacter.classProficienciesList.clear();
                proficiencies.clear();
                mainCharacter.setAc(0);
                characterClass.setText(Classes.chooseClass(continueButton,mainCharacter ));
                for (int i=0 ; i < mainCharacter.armorList.size(); i++){
                    if(checkIfArmorIsNotProficient(mainCharacter.nonProficientArmor,mainCharacter.armorList.get(i).getName())){
                        Label notProficient = new Label(mainCharacter.armorList.get(i).getName()+" (Not Proficient)");
                        notProficient.setTextFill(Color.RED);
                        armor.add(notProficient);

                    } else armor.add((mainCharacter.armorList.get(i).getName()));
                }
                armorList.setItems(armor);

                for (int i = 0 ; i< mainCharacter.weapons.size() ; i++){
                    weapons.add(mainCharacter.weapons.get(i).getName());
                }
                weaponsList.setItems(weapons);

                for (int i = 0; i < mainCharacter.inventory.size(); i++){
                    inventory.add(mainCharacter.inventory.get(i).getName());
                }
                for (int i =0; i<mainCharacter.instruments.size(); i++){
                    instruments.add(mainCharacter.instruments.get(i));
                }
                inventoryList.setItems(inventory);
                instrumentsList.setItems(instruments);
                for (int i =0; i<(mainCharacter.levelProficienciesList.size()+mainCharacter.classProficienciesList.size()); i++){
                    if (i<mainCharacter.classProficienciesList.size()){
                        proficiencies.add(mainCharacter.classProficienciesList.get(i));
                    }else {
                        proficiencies.add(mainCharacter.levelProficienciesList.get(i-mainCharacter.classProficienciesList.size()));
                    }
                }
                proficienciesList.setItems(proficiencies);
                editAbilities.setDisable(false);
                ac.setText("AC: " + mainCharacter.getAc());
                Abilities.updateAbilities(abilities,mainCharacter);
                speed.setText("Speed: " + mainCharacter.getSpeed());
                borderPane.setRight(setSkillsPane(mainCharacter));
            }
        });

        //Set Level
        editLevel.setDisable(true);
        editLevel.setTooltip(new Tooltip("Missing class selection"));
        level.setUnderline(true);
        layout.add(level,4,0);
        layout.add(editLevel,4,1);
        editLevel.setOnAction(levelError->{
            if (confirmingPopUp("Continuing will erase your current configurations\nWould you like to continue?")==true){
                //Removing previous configurations
                mainCharacter.levelProficienciesList.clear();
                proficiencies.clear();
                mainCharacter.getFeaturesList().clear();
                mainCharacter.getMisc().clear();
                mainCharacter.setSpeed(mainCharacter.getBaseSpeed());
                mainCharacter.setHitPoints(mainCharacter.getBaseHitPoints());
                spellsList.getItems().clear();
                mainCharacter.cantripsListView.getItems().clear();
                mainCharacter.firstLevelSpellListView.getItems().clear();
                mainCharacter.secondLevelSpellListView.getItems().clear();
                mainCharacter.thirdLevelSpellListView.getItems().clear();
                mainCharacter.fourthLevelSpellListView.getItems().clear();
                mainCharacter.fifthLevelSpellListView.getItems().clear();
                mainCharacter.sixthLevelSpellListView.getItems().clear();
                mainCharacter.seventhLevelSpellListView.getItems().clear();
                mainCharacter.eighthLevelSpellListView.getItems().clear();
                mainCharacter.ninthLevelSpellListView.getItems().clear();

                //New Level Setup
                Classes.setLevel(mainCharacter);
                level.setText("Level: " + mainCharacter.getLevel());
                for (int i =0; i<(mainCharacter.levelProficienciesList.size()+mainCharacter.classProficienciesList.size()); i++){
                    if (i<mainCharacter.classProficienciesList.size()){
                        proficiencies.add(mainCharacter.classProficienciesList.get(i));
                    }else {
                        proficiencies.add(mainCharacter.levelProficienciesList.get(i-mainCharacter.classProficienciesList.size()));
                    }
                }
                proficienciesList.setItems(proficiencies);
                featuresList.setItems(mainCharacter.getFeaturesList());
                miscList.setItems(mainCharacter.getMisc());
                ac.setText("AC: " + mainCharacter.getAc());
                hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
                Abilities.updateAbilities(abilities,mainCharacter);
                speed.setText("Speed: " + mainCharacter.getSpeed());
                spellsList.getItems().addAll(mainCharacter.cantripsListView,
                        mainCharacter.firstLevelSpellListView,
                        mainCharacter.secondLevelSpellListView,
                        mainCharacter.thirdLevelSpellListView,
                        mainCharacter.fourthLevelSpellListView,
                        mainCharacter.fifthLevelSpellListView,
                        mainCharacter.sixthLevelSpellListView,
                        mainCharacter.seventhLevelSpellListView,
                        mainCharacter.eighthLevelSpellListView,
                        mainCharacter.ninthLevelSpellListView);
                //TODO update ArmorList to reflect any armor proficiencies updates from the college selection (Valor)
                borderPane.setRight(setSkillsPane(mainCharacter));

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


        return layout;
    }

    /**
     * Initial set up for the center pane that contains Armor, Weapons, Inventory, Instruments, Features, Proficiencies, Spells, and Race Trait List views reflecting the character sheet information
     * @return Vbox that will replace the border pane center.
     */
    private VBox setCenter(){
        HBox centerTop = new HBox(1);
        HBox centerBottom = new HBox(1);
        VBox center = new VBox();
        center.setPadding(new Insets(1,2,1,1));
        HBox topLabels = new HBox(new Label("Armor"), new Label("Weapons"),new Label("Inventory"),new Label("Instruments"));
        HBox bottomLabels = new HBox(new Label("Features"),new Label("Proficiencies"),new Label("Spells"),new Label("Race Traits"));
        topLabels.setSpacing(150);
        topLabels.setAlignment(Pos.CENTER);
        centerTop.setAlignment(Pos.CENTER);

        bottomLabels.setSpacing(150);
        bottomLabels.setAlignment(Pos.CENTER);
        centerBottom.setAlignment(Pos.CENTER);
        center.getChildren().addAll(topLabels,centerTop, bottomLabels,centerBottom);

        //ListView SetUp
        centerTop.getChildren().addAll(armorList,weaponsList,inventoryList,instrumentsList);
        armorList.setPrefSize(200,350);
        armorList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        weaponsList.setPrefSize(200,350);
        weaponsList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        inventoryList.setPrefSize(200,350);
        inventoryList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        instrumentsList.setPrefSize(200,350);
        instrumentsList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        featuresList.setPrefSize(200,350);
        featuresList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        proficienciesList.setPrefSize(200,350);
        proficienciesList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        spellsList.setPrefSize(200,350);
        spellsList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        raceTraitsList.setPrefSize(200,350);
        raceTraitsList.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
        centerBottom.getChildren().addAll(featuresList,proficienciesList,spellsList,raceTraitsList);
        center.setMaxWidth(800);


        return center;
    }

    /**
     *
     * @param mainCharacter User's CharacterSheet
     * @return VBox to replace borderpane left pane when returned for primary stage.
     */
    private VBox setLeft(CharacterSheet mainCharacter, Stage primaryStage, Scene primaryScene){
        VBox left = new VBox();
        left.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 2;");
        left.setPadding(new Insets(-14,0,-10,0));
        left.setTranslateY(14);


        //Set Character Specific Misc
        miscList.setPrefHeight(295);
        miscList.setPlaceholder(new Label("--- Miscellaneous ---"));

        // Sets Abilities
        abilities.setTranslateY(12);
        abilities.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 2;");
        abilities.setMaxHeight(150);
        abilities.setPadding(new Insets(10,10,10,10));
        Label charisma = new Label("Charisma: " );
        Label strength = new Label("Strength: " );
        Label dexterity = new Label("Dexterity: " );
        Label wisdom = new Label("Wisdom: " );
        Label intelligence = new Label("Intelligence: " );
        Label constitution = new Label("Constitution: " );

        editAbilities.setDisable(true);
        editAbilities.setOnAction(e-> {
            Abilities.chooseAbilities(continueButton,mainCharacter);
            Abilities.updateAbilities(abilities,mainCharacter);
            editLevel.setDisable(false);
            editLevel.setTooltip(new Tooltip("Edit Level"));
            editRace.setDisable(false);
            editAbilities.setDisable(true);
            borderPane.setRight(setSkillsPane(mainCharacter));

        });

        VBox abilityNames = new VBox(5);
        VBox abilityScores = new VBox(5);
        abilityNames.getChildren().addAll(charisma, strength, dexterity, wisdom, intelligence,constitution);
        abilityScores.getChildren().addAll(
                new Label(mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod()), new Label(mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod()), new Label(mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod()), new Label(mainCharacter.getWisdomScore() + " / " + mainCharacter.getWisdomMod()),new Label(mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod()), new Label( mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod()));
        HBox listOfAbilities = new HBox(5);
        listOfAbilities.getChildren().addAll(abilityNames,abilityScores);

        abilities.getChildren().addAll(editAbilities,listOfAbilities);

        // Save Buttons
        Button save = new Button("Save");
        save.setPrefWidth(75);
        close.setPrefWidth(75);

        save.setOnAction(SaveEvent->{
            borderPane.setDisable(true);
            saveCharacter(mainCharacter);
            borderPane.setDisable(false);
        });


        left.getChildren().addAll(abilities, languagesList, miscList,new HBox(close,save));

        left.setMaxWidth(150);
        left.setMaxHeight(735);
        return left;
    }

    public static boolean checkIfArmorIsNotProficient(String[] nonProficientArmorArray, String armor){
        if (armor == null)
            return false;
        else {
            for (int i = 0; i < nonProficientArmorArray.length; i++){
                if (nonProficientArmorArray[i] != null && nonProficientArmorArray[i].equals(armor)){
                    return true;
                }
            }
        }
        return false;
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
        pane.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        nameStage.initModality(Modality.APPLICATION_MODAL);
        nameStage.showAndWait();

        return "Name: " + name.getText();
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
            pane.setStyle("-fx-border-color: black;"+
                    "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
            scene.setFill(Color.TRANSPARENT);
            setAgeStage.setScene(scene);
            setAgeStage.initModality(Modality.APPLICATION_MODAL);
            setAgeStage.showAndWait();

        }



    /**
     * Pop up message that will either let the user continue or close.
     * @param mainMessage Message that the Pop up will display
     * @return Returns True if the user wants to continue, false otherwise
     */
    private boolean confirmingPopUp(String mainMessage){
        VBox pane = new VBox(30);
        Scene scene = new Scene(pane,300,150);
        Stage popUpStage= new Stage();
        popUpStage.setScene(scene);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        popUpStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        popUpStage.initModality(Modality.APPLICATION_MODAL);

        Label popUpMessage = new Label(mainMessage);
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


        //TODO create Load Character / When loading character, add Race traits based on what race is saved/ When Loading Character, add features/ Proficiency Bonus based on Class and Level Number

    /**
     * Updates character information into MySQL Database
     * @param mainCharacter CharacterSheet that has the information to be saved.
     */
    private Boolean saveCharacter(CharacterSheet mainCharacter){
        Stage saveScreen = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane,260,130);
        pane.setBackground(new Background(new BackgroundImage(new Image(getClass().getResourceAsStream("Save_GIF.gif"),300,300,false,true),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
        saveScreen.setScene(scene);
        Label saving = new Label("Saved");
        saving.setStyle("-fx-font-size: 20;");
        saving.setTranslateY(100);
        saving.setTranslateX(5);
        Button returnButton = new Button("->");
        returnButton.setStyle("-fx-font-size: 15;");
        returnButton.setShape(new Circle());
        returnButton.setTranslateY(100);
        returnButton.setOnAction(continueEvent -> {
            saveScreen.close();
            borderPane.setDisable(false);
        });
        pane.getChildren().addAll(new HBox(saving,returnButton));
        pane.setStyle("-fx-border-color: black;");

        // Save basic Charactersheet information (Name/race/ability scores/etc.)
               try {
                   Connection con = DriverManager.getConnection(url,"generaluser","4Testing");
                   PreparedStatement characterinfoSave = con.prepareStatement("UPDATE characterinfo " +
                           "SET name = (?), " +
                           "age = (?), " +
                           "race = (?), " +
                           "class = (?), " +
                           "level= (?), " +
                           "ac= (?), " +
                           "hitPoints = (?), " +
                           "speed = (?), " +
                           "alignment = (?), " +
                           "charismaScore = (?), " +
                           "strengthScore= (?), " +
                           "dexterityScore = (?), " +
                           "wisdomScore = (?), " +
                           "intelligenceScore = (?), " +
                           "constitutionScore= (?) " +
                           "WHERE id =?;");
                   characterinfoSave.setString(1,mainCharacter.getName());
                   characterinfoSave.setInt(2, mainCharacter.getAge());
                   characterinfoSave.setString(3,mainCharacter.getRace());
                   characterinfoSave.setString(4,mainCharacter.getCharacterClass());
                   characterinfoSave.setInt(5,mainCharacter.getLevel());
                   characterinfoSave.setInt(6,mainCharacter.getAc());
                   characterinfoSave.setInt(7,mainCharacter.getHitPoints());
                   characterinfoSave.setInt(8,mainCharacter.getSpeed());
                   characterinfoSave.setString(9,mainCharacter.getAlignment());
                   characterinfoSave.setInt(10,mainCharacter.getCharismaScore());
                   characterinfoSave.setInt(11,mainCharacter.getStrengthScore());
                   characterinfoSave.setInt(12,mainCharacter.getDexterityScore());
                   characterinfoSave.setInt(13,mainCharacter.getWisdomScore());
                   characterinfoSave.setInt(14,mainCharacter.getIntelligenceScore());
                   characterinfoSave.setInt(15,mainCharacter.getConstitutionScore());
                   characterinfoSave.setInt(16,mainCharacter.getPrimaryKey());
                   characterinfoSave.execute();


                   // Save Languages
                   //TODO Test Languages and confirm that they are saving in MySQL Schema properly.
                   String[] SQLLanguagesArray = {"Common","Dwarvish","Elvish","Giant","Gnomish","Goblin","Halfling","Orc","Abyssal","Celestial","Draconic","Deep_Speech","Infernal","Aquan","Auran","Ignan","Terran","Sylvan","Undercommon","Aarakocra","Druidic","Gith","Thieves_Cant","Dambrathan","Bedine","Alzhedo","Chondathan","Damaran","Waelan","Guran","Halruaan","Illuskan","Roushoum","Chessentan","Mulhorandi","Untheric","Thayan","Rashemi","Shaaran","Shou","Tuigan","Turmic","Uluik","Blink_Dog","Bullywug","Giant_Eagle","Giant_Elk","Giant_Owl","Gnoll","Grell","Grung","Hook_Horror","Kruthik","Modron","Otyugh","Sahuagin","Slaad","Sphinx","Thrikreen","Tlincalli","Troglodyte","Umber_Hulk","Vegepygmy","Winter_Wolf","Worg","Yeti"};
                   for (int i = 0; i< SQLLanguagesArray.length; i++){
                       PreparedStatement removesavedLanguages = con.prepareStatement("UPDATE languages SET " + SQLLanguagesArray[i] + " = 0 WHERE id = ?;");
                       removesavedLanguages.setInt(1,mainCharacter.getPrimaryKey());
                       removesavedLanguages.execute();
                   }
                   for (int i = 0 ; i< mainCharacter.languages.size(); i++){
                       int position = findArrayPosition(mainCharacter.languages.get(i), mainCharacter.allLanguagesArray);

                       PreparedStatement languageSave = con.prepareStatement("UPDATE languages SET " + SQLLanguagesArray[position] + "  = 1 WHERE id = ?;");
                       languageSave.setInt(1,mainCharacter.getPrimaryKey());
                       languageSave.execute();
                   }
                   //TODO need to save proficiencies (Need to have a check for spaced words ex. Light Armor/ Switch Case?) after tables are added in SQL

                   //Save Weapons
                   String[] SQLWeaponsArray = {"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light_Hammer", "Mace", "Quarterstaff", "Sickle", "Spear","Light_Crossbow", "Dart", "Sling","Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance","Longsword", "Maul","Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War_Pick", "Warhammer", "Whip", "Blowgun", "Hand_Crossbow", "Heavy_Crossbow", "Longbow", "Net"};
                   for (int i = 0; i< SQLWeaponsArray.length; i++){
                       PreparedStatement removeSavedWeapons= con.prepareStatement("UPDATE weapons SET " + SQLWeaponsArray[i] + " = 0 WHERE idweapons = ?;");
                       removeSavedWeapons.setInt(1,mainCharacter.getPrimaryKey());
                       removeSavedWeapons.execute();
                   }
                   for (int i = 0 ; i< mainCharacter.weapons.size(); i++){
                       int position = findArrayPosition(mainCharacter.weapons.get(i).getName(),mainCharacter.getAllWeapons());

                       PreparedStatement weaponSave = con.prepareStatement("UPDATE weapons SET " + SQLWeaponsArray[position] + "  = ? WHERE idweapons = ?;");
                       weaponSave.setInt(1, mainCharacter.weapons.get(i).getQuantity());
                       weaponSave.setInt(2,mainCharacter.getPrimaryKey());
                       weaponSave.execute();
                   }

                   // Save Armor
                   String[] SQLArmorArray = {"Padded", "Leather","Studded_Leather","Hide", "Chain_Shirt", "Scale_Mail", "Breastplate", "Halfplate", "Ring_Mail",  "Chain_Mail" , "Splint", "Plate","Shield"};
                   for (int i = 0; i < SQLArmorArray.length;i++){
                       PreparedStatement removeSavedArmor= con.prepareStatement("UPDATE armor SET " + SQLArmorArray[i] + " = 0 WHERE idarmor = ?;");
                       removeSavedArmor.setInt(1,mainCharacter.getPrimaryKey());
                       removeSavedArmor.execute();
                   }
                   for (int i = 0 ; i< mainCharacter.armorList.size(); i++){
                       System.out.println(mainCharacter.armorList.get(i).getName());
                       int position = findArrayPosition(mainCharacter.armorList.get(i).getName(),mainCharacter.getAllArmor());

                       PreparedStatement armorSave = con.prepareStatement("UPDATE armor SET " + SQLArmorArray[position] + "  = ? WHERE idarmor = ?;");
                       armorSave.setInt(1, mainCharacter.armorList.get(i).getQuantity());
                       armorSave.setInt(2,mainCharacter.getPrimaryKey());
                       armorSave.execute();
                   }

                   // Save Musical instruments
                   String[] SQLMusicalInstruments = {"Bagpipes","Drum","Dulcimer","Flute","Lute","Lyre","Horn","Pan_Flute","Shawm","Viol"};
                   for (int i = 0; i < SQLMusicalInstruments.length;i++){
                       PreparedStatement removeInstruments= con.prepareStatement("UPDATE musicalinstruments SET " + SQLMusicalInstruments[i] + " = 0 WHERE idmusicalInstruments = ?;");
                       removeInstruments.setInt(1,mainCharacter.getPrimaryKey());
                       removeInstruments.execute();
                   }

                   for (int i = 0 ; i< mainCharacter.instruments.size(); i++){
                       int position = findArrayPosition(mainCharacter.instruments.get(i),mainCharacter.getMusicalInstruments());

                       PreparedStatement instrumentsSave = con.prepareStatement("UPDATE musicalinstruments SET " + SQLMusicalInstruments[position] + "  = 1 WHERE idmusicalInstruments = ?;");
                       instrumentsSave.setInt(1,mainCharacter.getPrimaryKey());
                       instrumentsSave.execute();
                   }

                   //Save Adventuring Gear
                   //TODO Add tools (PG 154) and Mounts/ Vechicles (Pg 155)
                   String[] SQLAdventuringGear = {"Shovel","Abacus","Acid","Alchemists_Fire","Arrows","Blowgun_Needles","CrossBow_Bolts","Sling_Bullets","Antitoxin","Crystal","Orb","Rod","Staff","Wand","Backpack","Ball_Bearings","Barrel","Basket","Bedroll","Bell","Blanket","Block_And_Tackle","Book","Bottle","Bucket","Caltrops","Candle","Crossbow_Bolt_Case","Map_Or_Scroll_Case","Chain","Chalk","Chest","Climbers_Kit","Common_Clothes","Costume_Clothes","Fine_Clothes","Travelers_Clothes","Component_Pouch","Crowbar","Sprig_Of_Mistletoe","Totem","Wooden_Staff","Yew_Wand","Fishing_Tackle","Flask_Or_Tankard","Grappling_Hook","Hammer","Sledge_Hammer","Healers_Kit","Amulet","Emblem","Reliquary","Holy_Water","Hourglass","Hunting_Trap","Ink","Ink_Pen","Jug_Or_Pitcher","Ladder","Lamp","Bullseye_Lantern","Hooded_Lantern","Locks","Magnifying_Glass","Manacles","Mess_Kit","Steel_Mirror","Oil","Paper","Parchment","Perfume","Miners_Pick","Piton","Basic_Poison","Pole","Iron_Pot","Potion_Of_Healing","Pouch","Quiver","Portable_Ram","Rations","Robes","Hempen_Rope","Silk_Rope","Sack","Merchants_Scale","Sealing_Wax","Signal_Whistle","Signet_Ring","Soap","Spellbook","Iron_Spikes","Spy_Glass","Two_Person_Tent","Tinderbox","Torch","Vial","Waterskin","Whetstone"};

                   for (int i = 0; i < SQLAdventuringGear.length;i++){
                       PreparedStatement removeGear= con.prepareStatement("UPDATE adventuringgear SET " + SQLAdventuringGear[i] + " = 0 WHERE idadventuringgear = ?;");
                       removeGear.setInt(1,mainCharacter.getPrimaryKey());
                       removeGear.execute();
                   }

                   for (int i = 0 ; i< mainCharacter.inventory.size(); i++){
                       int position = findArrayPosition(mainCharacter.inventory.get(i).getName(),mainCharacter.getAdventuringGear());


                       PreparedStatement adventureGearSave = con.prepareStatement("UPDATE adventuringgear SET " + SQLAdventuringGear[position] + "  = ? WHERE idadventuringgear = ?;");
                       adventureGearSave.setInt(1,mainCharacter.inventory.get(i).getQuantity());
                       adventureGearSave.setInt(2,mainCharacter.getPrimaryKey());

                       System.out.println(mainCharacter.inventory.get(i).getQuantity());
                       adventureGearSave.execute();
                   }

                   // Saves all Spells
                   saveAllSpells(mainCharacter);
                   System.out.println("Saved");
                   saveScreen.initStyle(StageStyle.TRANSPARENT);
                   saveScreen.initModality(Modality.APPLICATION_MODAL);
                   saveScreen.show();

               } catch (SQLException e) {
                   e.printStackTrace();
                   if (confirmingPopUp("Server is currently unreachable.\nWould you like to continue or return?")){
                       saveCharacter(mainCharacter);
                   }else return false;
               }
        return true;
    }


    /**
     * Returns the position of the provided item in the given array
     * @param itemToBeFound String of what is being searched for
     * @param arrayThatContainsItem String array that is being searched for given item/string
     * @return Returns position of item in given array, if string is not found in array returns -1.
     */
    protected static int findArrayPosition(String itemToBeFound, Object[] arrayThatContainsItem){

            for (int j = 0; j< arrayThatContainsItem.length;j++){
                if (arrayThatContainsItem[j] == null){
                    if (itemToBeFound == null)
                        return j;

                }else {
                    if (arrayThatContainsItem[j].equals(itemToBeFound)){
                        return j;
                    }
                }
            }
            return -1;
        }

        private HBox setSkillsPane(CharacterSheet character){
            HBox right = new HBox(15);
            right.setMaxHeight(400);
            right.setStyle("-fx-background-radius: 10; -fx-border-color: silver; -fx-border-radius: 10; -fx-border-width: 3;");
            right.setPadding(new Insets(0,25,0,5));
            right.setTranslateY(17);
            VBox skillsList = new VBox(15);
            skillsList.setTranslateY(12);
            VBox modifierList = new VBox(15);
            modifierList.setStyle(" -fx-border-color: silver; -fx-border-width: 1;");
            modifierList.setPadding(new Insets(10,5,10,5));
            VBox additionList = new VBox(15);
            additionList.setTranslateY(12);
            VBox proficiencyList = new VBox(15);
            proficiencyList.setPadding(new Insets(10,5,10,5));
            proficiencyList.setStyle(" -fx-border-color: silver; -fx-border-width: 1;");
            VBox totalList = new VBox(15);
            totalList.setTranslateY(12);

            skillsList.setAlignment(Pos.TOP_CENTER);
            modifierList.setAlignment(Pos.TOP_CENTER);
            additionList.setAlignment(Pos.TOP_CENTER);
            proficiencyList.setAlignment(Pos.TOP_CENTER);
            totalList.setAlignment(Pos.TOP_CENTER);
            String[] allSkills = {"Athletics","Acrobatics","Sleight of Hand","Stealth","Arcana","History","Investigation","Nature","Religion","Animal Handling","Insight","Medicine","Perception","Survival","Deception","Intimidation","Performance","Persuasion"};
            int abilityIterator = 0;
            int skillIterator = 0;
            String[] abilitiesList = {"Strength","Dexterity","Intelligence","Wisdom","Charisma"};
            for(int i =0;i<22; i++){
                switch (i){
                    case 0:
                    case 2:
                    case 6:
                    case 12:
                    case 16:skillsList.getChildren().add(new Label(abilitiesList[abilityIterator]+" Skills"));
                        modifierList.getChildren().add(new Label("Ability Modifiers"));
                        additionList.getChildren().add(new Label(""));
                        proficiencyList.getChildren().add(new Label("Proficiency Bonus"));
                        totalList.getChildren().add(new Label("Total"));
                        if (abilityIterator <5){
                            abilityIterator++;
                        }
                        break;
                    default:
                        int abilitySkillModifier=0;
                        if (abilityIterator==1){
                            modifierList.getChildren().add(new Label(""+character.getStrengthMod()));
                            abilitySkillModifier = character.getStrengthMod();
                        }else if (abilityIterator==2){
                            modifierList.getChildren().add(new Label(""+character.getDexterityMod()));
                            abilitySkillModifier = character.getDexterityMod();
                        }
                        else if (abilityIterator==3){
                            modifierList.getChildren().add(new Label(""+character.getIntelligenceMod()));
                            abilitySkillModifier = character.getIntelligenceMod();
                        }else if (abilityIterator==4){
                            modifierList.getChildren().add(new Label(""+character.getWisdomMod()));
                            abilitySkillModifier = character.getWisdomMod();
                        }else if (abilityIterator==5){
                            modifierList.getChildren().add(new Label(""+character.getCharismaMod()));
                            abilitySkillModifier = character.getCharismaMod();
                        }
                        if (character.levelProficienciesList.contains(allSkills[skillIterator]) || character.classProficienciesList.contains(allSkills[skillIterator])){
                            proficiencyList.getChildren().add(new Label(""+character.getProficiencyMod()));
                            totalList.getChildren().add(new Label(""+(character.getProficiencyMod()+abilitySkillModifier) ));
                        }else  {
                            proficiencyList.getChildren().add(new Label("0"));
                            totalList.getChildren().add(new Label(""+abilitySkillModifier));
                        }
                        skillsList.getChildren().add(new Label(allSkills[skillIterator]+":"));
                        additionList.getChildren().add(new Label("+"));
                        skillIterator++;
                        break;
                }

            }

            right.getChildren().addAll(skillsList,modifierList,additionList,proficiencyList,totalList);
            return right;
        }

     private static void saveAllSpells(CharacterSheet mainCharacter){

         try {
             Connection con = DriverManager.getConnection(url, "generaluser", "4Testing");

             String[] SQLCantrips = {"Acid_Splash","Blade_Ward","Chill_Touch","Dancing_Lights","Druidcraft","Eldritch_Blast","Fire_bolts","Friends","Guidance","Light","Mage_Hand","Mending","Message","Minor_Illusion","Poison_Spray","Prestidigitation","Produce_Flame","Ray_of_Frost","Resistance","Sacred_Flame","Shillelagh","Shocking_Grasp","Spare_the_Dying","Thaumaturgy","Thorn_Whip","True_Strike","Vicious_Mockery"};

             for (int i = 0; i < SQLCantrips.length;i++){
                 PreparedStatement removeCantrips= con.prepareStatement("UPDATE cantrips SET " + SQLCantrips[i] + " = 0 WHERE idcantrips = ?;");
                 removeCantrips.setInt(1,mainCharacter.getPrimaryKey());
                 removeCantrips.execute();
             }

             for (int i = 0 ; i< mainCharacter.cantripsListView.getItems().size(); i++){
                 int position = findArrayPosition(mainCharacter.cantripsListView.getItems().get(i).toString(),Spells.allClassSpellSetUp(10).toArray());

                 PreparedStatement cantripsSave = con.prepareStatement("UPDATE cantrips SET " + SQLCantrips[position] + "  = 1 WHERE idcantrips = ?;");
                 cantripsSave.setInt(1,mainCharacter.getPrimaryKey());
                 cantripsSave.execute();
             }

             System.out.println("Added all cantrips");
             String[] SQLFirstLevelSpells = {"Alarm","Animal_of_Friendship","Armor_of_Agathys","Arms_of_Hadar","Bane","Bless","Burning_Hands","Charm_Person","Chromatic_Orb","Color_Spray","Command","Compelled_Duel","Comprehend_Languages","Create_or_Destroy_Water","Cure_Wounds","Detect_Evil_and_Good","Detect_Magic","Detect_Poison_and_Disease","Disguise_Self","Dissonant_Whispers","Divine_Favor","Ensnaring_Strike","Entangle","Expeditious_Retreat","Faerie_Fire","False_Life","Feather_Fall","Find_Familiar","Fog_Cloud","Good_Berry","Grease","Guiding_Bolt","Hail_of_Thorns","Healing_Word","Hellish_Rebuke","Heroism","Hex","Hunters_Mask","Identify","Illusory_Script","Inflict_Wounds","Jump","Longstrider","Mage_Armor","Magic_Missile","Protection_from_Good_or_Evil","Purify_Food_and_Drink","Ray_of_Sickness","Sanctuary","Searing_Smite","Shield","Shield_of_Faith","Silent_Image","Sleep","Speak_with_Animals","Tashas_Hideous_Laughter","Tensers_Floating_Disk","Thunderous_Smite","Thunderwave","Unseen_Servant","Witch_Bolt","Wrathful_Smite"};
             for (int i = 0; i < SQLFirstLevelSpells.length;i++){
                 PreparedStatement removeFirstLvlSpells= con.prepareStatement("UPDATE firstLevelSpells SET " + SQLFirstLevelSpells[i] + " = 0 WHERE idfirstLevelSpells = ?;");
                 removeFirstLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeFirstLvlSpells.execute();
             }
             int incrementer = 0;
             while (incrementer < mainCharacter.firstLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(1).contains(mainCharacter.firstLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.firstLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(1).toArray());

                 PreparedStatement firstLevelSpellsSave = con.prepareStatement("UPDATE firstLevelSpells SET " + SQLFirstLevelSpells[position] + "  = 1 WHERE idfirstLevelSpells = ?;");
                 firstLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 firstLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all First Level Spells");

             String[] SQLSecondLevelSpells = {"Aid","Alter_Self","Animal_Messenger","Arcane_Lock","Augury","Barkskin","Beast_Sense","Blindness_Deafness","Blur","Branding_Smite","Calm_Emotions","Cloud_of_Daggers","Continual_Flames","Cordon_of_Arrows","Crown_of_Madness","Darkness","Darkvision","Detect_Thoughts","Enhance_Ability","Enlarge_Reduce","Enthrall","Find_Steed","Find_Traps","Flame_Blade","Flaming_Sphere","Gentle_Repose","Gust_of_Wind","Heat_Metal","Hold_Person","Invisibility","Knock","Lesser_Restoration","Levitate","Locate_Animals_or_Plants","Locate_Object","Magic_Mouth","Magic_Weapon","Melfs_Acid_Arrow","Mirror_Image","Misty_Step","Moonbeam","Nystuls_Magic_Aura","Pass_without_Trace","Phantasmal_Force","Prayer_of_Healing","Protection_from_Poison","Ray_of_Enfeeblement","Rope_Trick","Scorching_Ray","See_Invisibility","Shatter","Silence","Spider_Climb","Spike_Growth","Spiritual_Weapon","Suggestion","Warding_Bond","Web","Zone_of_Truth"};
             for (int i = 0; i < SQLSecondLevelSpells.length;i++){
                 PreparedStatement removeSecondLvlSpells= con.prepareStatement("UPDATE secondLevelSpells SET " + SQLSecondLevelSpells[i] + " = 0 WHERE idsecondLevelSpells = ?;");
                 removeSecondLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeSecondLvlSpells.execute();
             }
             while (incrementer < mainCharacter.secondLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(2).contains(mainCharacter.secondLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.secondLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(2).toArray());


                 PreparedStatement secondLevelSpellsSave = con.prepareStatement("UPDATE secondLevelSpells SET " + SQLSecondLevelSpells[position] + "  = 1 WHERE idsecondLevelSpells = ?;");
                 secondLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 secondLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Second Level Spells");

             String[] SQLThirdLevelSpells ={"Animate_Dead","Aura_of_Vitality","Beacon_of_Hope","Bestow_Curse","Blinding_Smite","Blink","Call_Lightning","Clairvoyance","Conjure_Animals","Conjure_Barrage","Counterspell","Create_Food_and_Water","Crusaders_Mantle","Daylight","Dispel_Magic","Elemental_Weapon","Fear","Feign_Death","Fireball","Fly","Gaseous_Form","Glyph_of_Warding","Haste","Hunger_of_Hadar","Hypnotic_Pattern","Tiny_Hut","Lightning_Bolt","Mass_Healing_Word","Magic_Circle","Major_Image","Meld_into_Stone","Nondetection","Phantom_Steed","Plant_Growth","Protection_from_Energy","Remove_Curse","Revivify","Sending","Sleet_Storm","Slow","Speak_with_Dead","Speak_with_Plants","Spirit_Guardians","Stinking_Cloud","Tongues","Vampiric_Touch","Water_Breathing","Water_Walk","Wind_Wall"};
             for (int i = 0; i < SQLThirdLevelSpells.length;i++){
                 PreparedStatement removeThirdLvlSpells= con.prepareStatement("UPDATE thirdLevelSpells SET " + SQLThirdLevelSpells[i] + " = 0 WHERE idthirdLevelSpells = ?;");
                 removeThirdLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeThirdLvlSpells.execute();
             }
             while (incrementer < mainCharacter.thirdLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(3).contains(mainCharacter.thirdLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.thirdLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(3).toArray());

                 PreparedStatement ThirdLevelSpellsSave = con.prepareStatement("UPDATE thirdLevelSpells SET " + SQLThirdLevelSpells[position] + "  = 1 WHERE idthirdLevelSpells = ?;");
                 ThirdLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 ThirdLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Third Level Spells");

             String[] SQLFourthLevelSpells = {"Arcane_Eye","Aura_of_Life","Aura_of_Purity","Banishment","Blight","Compulsion","Confusion","Conjure_Minor_Elementals","Conjure_Woodland_Beings","Control_Water","Death_Ward","Dimension_Door","Divination","Dominate_Beast","Evards_Black_Tentacles","Fabricate","Fire_Shield","Freedom_of_Movement","Giant_Insect","Grasping_Vine","Greater_Invisibility","Guardian_of_Faith","Hallucinatory_Terrain","Ice_Storm","Secret_Chest","Locate_Creature","Mordenkainens_Faithful_Hound","Mordenkainens_Private_Sanctum","Otilukes_Resilient_Sphere","Phantasmal_Killer","Polymorph","Staggering_Smite","Stone_Shape","Stoneskin","Wall_of_Fire"};
             for (int i = 0; i < SQLFourthLevelSpells.length;i++){
                 PreparedStatement removefourthLvlSpells= con.prepareStatement("UPDATE fourthLevelSpells SET " + SQLFourthLevelSpells[i] + " = 0 WHERE idfourthLevelSpells = ?;");
                 removefourthLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removefourthLvlSpells.execute();
             }
             while(incrementer < mainCharacter.fourthLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(4).contains(mainCharacter.fourthLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.fourthLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(4).toArray());

                 PreparedStatement fourthLevelSpellsSave = con.prepareStatement("UPDATE fourthLevelSpells SET " + SQLFourthLevelSpells[position] + "  = 1 WHERE idfourthLevelSpells = ?;");
                 fourthLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 fourthLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Fourth Level Spells");

             String[] SQLFifthLevelSpells = {"Animate_Objects","Antilife_Shell","Awaken","Banishing_Smite","Bigbys_Hand","Circle_of_Power","Cloudkill","Commune","Commune_with_Nature","Cone_of_Cold","Conjure_Elemental","Conjure_Volley","Contact_Other_Plane","Contagion","Creation","Destructive_Wave","Dispel_Evil_and_Good","Dominate_Person","Dream","Flame_Strike","Geas","Greater_Restoration","Hallow","Hold_Monster","Insect_Plague","Legend_Lore","Mass_Cure_Wounds","Mislead","Modify_Memory","Passwall","Planar_Binding","Raise_Dead","Rarys_Telepathic_Bond","Reincarnate","Scrying","Seeming","Swift_Quiver","Telekinesis_Circle","Teleportation_Circle","Tree_Stride","Wall_of_Force","Wall_of_Stone"};
             for (int i = 0; i < SQLFifthLevelSpells.length;i++){
                 PreparedStatement removefifthLvlSpells= con.prepareStatement("UPDATE fifthLevelSpells SET " + SQLFifthLevelSpells[i] + " = 0 WHERE idfifthLevelSpells = ?;");
                 removefifthLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removefifthLvlSpells.execute();
             }
             while (incrementer < mainCharacter.fifthLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(5).contains(mainCharacter.fifthLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.fifthLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(5).toArray());

                 PreparedStatement fifthLevelSpellsSave = con.prepareStatement("UPDATE fifthLevelSpells SET " + SQLFifthLevelSpells[position] + "  = 1 WHERE idfifthLevelSpells = ?;");
                 fifthLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 fifthLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Fifth Level Spells");


             String[] SQLSixthLevelSpells = {"Arcane_Gate","Blade_Barrier","Chain_Lightning","Circle_of_Death","Conjure_Fey","Contingency","Create_Undead","Disintegrate","Drawmijs_Instant_Summons","Eyebite","Find_the_Path","Flesh_to_Stone","Forbiddance","Globe_of_Invulnerability","Guards_of_Wards","Harm","Heal","Heroes_Feast","Magic_Jar","Mass_Suggestion","Move_Earth","Otilukess_Freezing_Sphere","Ottos_Irresistible_Dance","Planar_Ally","Programmed_Illusion","Sunbeam","Transport_via_Plants","True_Seeing","Wall_of_Ice","Wall_of_Thorns","Wind_Walk","Word_of_Recall"};
             for (int i = 0; i < SQLSixthLevelSpells.length;i++){
                 PreparedStatement removesixthLvlSpells= con.prepareStatement("UPDATE sixthLevelSpells SET " + SQLSixthLevelSpells[i] + " = 0 WHERE idsixthLevelSpells = ?;");
                 removesixthLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removesixthLvlSpells.execute();
             }
             while (incrementer < mainCharacter.sixthLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(6).contains(mainCharacter.sixthLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.sixthLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(6).toArray());

                 PreparedStatement sixthLevelSpellsSave = con.prepareStatement("UPDATE sixthLevelSpells SET " + SQLSixthLevelSpells[position] + "  = 1 WHERE idsixthLevelSpells = ?;");
                 sixthLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 sixthLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Sixth Level Spells");

             String[] SQLSeventhLevelSpells = {"Conjure_Celestial","Delayed_Blast_Fireball","Divine_Word","Etherealness","Finger_of_Death","Fire_Storm","Forecage","Mirage_Arcane","Mordenkainens_Magnificent_Mansion","Mordenkainens_Sword","Plane_Shift","Prismatic_Spray","Project_Image","Regenerate","Resurrection","Reverse_Gravity","Sequester","Simulation","Symbol","Teleport"};
             for (int i = 0; i < SQLSeventhLevelSpells.length;i++){
                 PreparedStatement removeseventhLvlSpells= con.prepareStatement("UPDATE seventhLevelSpells SET " + SQLSeventhLevelSpells[i] + " = 0 WHERE idseventhLevelSpells = ?;");
                 removeseventhLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeseventhLvlSpells.execute();
             }
             while (incrementer < mainCharacter.seventhLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(7).contains(mainCharacter.seventhLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.seventhLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(7).toArray());

                 PreparedStatement seventhLevelSpellsSave = con.prepareStatement("UPDATE seventhLevelSpells SET " + SQLSeventhLevelSpells[position] + "  = 1 WHERE idseventhLevelSpells = ?;");
                 seventhLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 seventhLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Seventh Level Spells");

             String[] SQLEighthLevelSpells = {"Animal_Shapes","Antimagic_Field","Antipathy_Sympathy","Clone","Control_Weather","Demiplane","Dominate_Monster","Earthquake","Feeblemind","Glibness","Holy_Aura","Incendiary_Cloud","Maze","Mind_Blank","Power_Word_Stun","Sunburst","Telepathy","Tsunami"};
             for (int i = 0; i < SQLEighthLevelSpells.length;i++){
                 PreparedStatement removeeighthLvlSpells= con.prepareStatement("UPDATE eighthLevelSpells SET " + SQLEighthLevelSpells[i] + " = 0 WHERE ideighthLevelSpells = ?;");
                 removeeighthLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeeighthLvlSpells.execute();
             }
             while (incrementer < mainCharacter.eighthLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(8).contains(mainCharacter.eighthLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.eighthLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(8).toArray());

                 PreparedStatement sixthLevelSpellsSave = con.prepareStatement("UPDATE eighthLevelSpells SET " + SQLEighthLevelSpells[position] + "  = 1 WHERE ideighthLevelSpells = ?;");
                 sixthLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 sixthLevelSpellsSave.execute();
                 incrementer++;
             }
             System.out.println("Added all Eighth Level Spells");

             String[] SQLNinthLevelSpells = {"Astral_Projection","Foresight","Gate","Imprisonment","Mass_Heal","Meteor_Swarm","Power_Word_Heal","Power_Word_Kill","Prismatic_Wall","Shapechange","Storm_of_Vengeance","Time_Stop","True_Polymorph","True_Resurrection","Weird","Wish"};
             for (int i = 0; i < SQLNinthLevelSpells.length;i++){
                 PreparedStatement removeNinthLvlSpells= con.prepareStatement("UPDATE ninthLevelSpells SET " + SQLNinthLevelSpells[i] + " = 0 WHERE idninthLevelSpells = ?;");
                 removeNinthLvlSpells.setInt(1,mainCharacter.getPrimaryKey());
                 removeNinthLvlSpells.execute();
             }
             while (incrementer < mainCharacter.ninthLevelSpellListView.getItems().size() && Spells.allClassSpellSetUp(9).contains(mainCharacter.ninthLevelSpellListView.getItems().get(incrementer))){
                 int position = findArrayPosition(mainCharacter.ninthLevelSpellListView.getItems().get(incrementer).toString(),Spells.allClassSpellSetUp(9).toArray());

                 PreparedStatement sixthLevelSpellsSave = con.prepareStatement("UPDATE ninthLevelSpells SET " + SQLNinthLevelSpells[position] + "  = 1 WHERE idninthLevelSpells = ?;");
                 sixthLevelSpellsSave.setInt(1,mainCharacter.getPrimaryKey());
                 sixthLevelSpellsSave.execute();
                incrementer++;
             }
             System.out.println("Added all Ninth Level Spells");
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
}

