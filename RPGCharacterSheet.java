package DungeonsAndDragons;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.InputStream;
import java.sql.*;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RPGCharacterSheet extends Application {

    private static Label label = new Label("");
    private static String url = "jdbc:mysql://localhost:3306/charactersheet_database";

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
     * Takes in the Ability Score, and finds the appropriate modifier and returns that modifier
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    protected static int findAbilityMod(int abilityScore) {
        if (abilityScore < 1) {
            return 0;
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
        //TODO add close button
       //Stage set up
        primaryStage.setTitle("Character Sheet Creation");
        primaryStage.setResizable(false);
        BorderPane borderPane = new BorderPane();
        GridPane layout = new GridPane();
        layout.setBackground(new Background(new BackgroundFill(Color.gray(1), null, null)));
        layout.setStyle("-fx-background-radius: 10;");
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
        Button close = new Button("Close");

        close.setOnAction(e-> primaryStage.close());

        //ListViews
        //TODO add tooltip to find description / quantity for each item.
        ObservableList armor = FXCollections.observableArrayList();
        ListView armorList = new ListView();
        armorList.setPlaceholder(new Label("---- Armor ----"));
        armorList.setTooltip(new Tooltip("Armor"));
//        armorList.setCellFactory(new Callback<ListView, ListCell>() {
//            @Override
//            public ListCell call(ListView param) {
//                return null;
//            }
//        });

        ObservableList inventory = FXCollections.observableArrayList();
        ListView inventoryList = new ListView();
        inventoryList.setPlaceholder(new Label("---- Inventory ----"));
        inventoryList.setTooltip(new Tooltip("Inventory"));

        ObservableList weapons = FXCollections.observableArrayList();
        ListView weaponsList = new ListView();
        weaponsList.setPlaceholder(new Label("---- Weapons ----"));
        weaponsList.setTooltip(new Tooltip("Weapons"));

        ObservableList instruments = FXCollections.observableArrayList();
        ListView instrumentsList = new ListView();
        instrumentsList.setPlaceholder(new Label("---- Instruments ----"));
        instrumentsList.setTooltip(new Tooltip("Instruments"));

        ObservableList features = FXCollections.observableArrayList();
        ListView featuresList = new ListView();
        featuresList.setPlaceholder(new Label("---- Features ----"));
        featuresList.setTooltip(new Tooltip("Features"));

        ObservableList proficiencies = FXCollections.observableArrayList();
        ListView proficienciesList = new ListView();
        proficienciesList.setPlaceholder(new Label("---- Proficiencies ----"));
        proficienciesList.setTooltip(new Tooltip("Proficiencies"));

        ObservableList spells = FXCollections.observableArrayList();
        ListView spellsList = new ListView();
        spellsList.setPlaceholder(new Label("---- Spells ----"));
        spellsList.setTooltip(new Tooltip("Spells"));

        ObservableList skills = FXCollections.observableArrayList();
        //TODO when getting spells, add cantrips, lvl 1 ... and fourth in between spells
        ListView skillsList = new ListView();
        skillsList.setPlaceholder(new Label("---- Skills ----"));
        skillsList.setTooltip(new Tooltip("Skills"));

        ObservableList languages = FXCollections.observableArrayList(mainCharacter.languages);
        ListView languagesList = new ListView(languages);
        languagesList.setPlaceholder(new Label("--- Languages --- "));
        languagesList.setTooltip(new Tooltip("Languages"));


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
        left.setStyle("-fx-background-radius: 10;");
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
        race.setPrefWidth(100);
        race.setWrapText(true);
        editRace.setDisable(true);
        editRace.setOnAction(e -> {
            if (confirmingPopUp("Continuing will erase your current configurations\nWould you like to continue?")==true){
                if (!mainCharacter.getRace().equals("")){
                    Races.resetPreviousRaceOptions(mainCharacter);
                    Abilities.updateAbilities(abilities,mainCharacter);
                }
                skills.clear();
                mainCharacter.skills.clear();
                languages.clear();
                mainCharacter.languages.clear();
                race.setText(Races.chooseRace(continueButton, mainCharacter));
                race.setTooltip(new Tooltip(mainCharacter.getRace()));
                setAge.setDisable(false);
                age.setTooltip(new Tooltip(Integer.toString(mainCharacter.getAge())));
                languages.setAll(mainCharacter.languages);
                skills.setAll(mainCharacter.skills);
                skillsList.setItems(skills);
                Abilities.updateAbilities(abilities,mainCharacter);
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
               characterClass.setText(Classes.chooseClass(continueButton,mainCharacter ));
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
               Abilities.updateAbilities(abilities,mainCharacter);
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
        abilities.setStyle("-fx-border-color: black;");
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
            Abilities.chooseAbilities(continueButton,mainCharacter);
            Abilities.updateAbilities(abilities,mainCharacter);
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
            Classes.setLevel(mainCharacter);
            level.setText("Level: " + mainCharacter.getLevel());
            proficienciesList.setItems(mainCharacter.getProficienciesList());
            featuresList.setItems(mainCharacter.getFeaturesList());
            miscList.setItems(mainCharacter.getMisc());
            ac.setText("AC: " + mainCharacter.getAc());
            hp.setText("Hit Points: "+ mainCharacter.getHitPoints());
            Abilities.updateAbilities(abilities,mainCharacter);
            speed.setText("Speed: " + mainCharacter.getSpeed());
        });


        // Save Button
        Button save = new Button("Save");
        save.setPrefWidth(75);
        close.setPrefWidth(75);
        save.setOnAction(e-> saveCharacter(mainCharacter));

        left.setMaxWidth(150);
        borderPane.setLeft(left);
        left.getChildren().addAll(abilities, languagesList, miscList,new HBox(close,save));

        Scene scene = new Scene(borderPane, 1000, 800);
        borderPane.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;" + "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
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
     * @param message Message that the Pop up will display
     * @return Returns True if the user wants to continue, false otherwise
     */
    private boolean confirmingPopUp(String message){
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


        //TODO create Load Character

    /**
     * Updates character information into MySQL Database
     * @param mainCharacter CharacterSheet that has the information to be saved.
     */
    private static void saveCharacter(CharacterSheet mainCharacter){

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
                //TODO need to save Armor/  Skills/ Instruments/ Inventory/ features/ proficiencies after tables are added in SQL

                //Save Weapons
                //TODO see why it is only saving Club in Weapons Schema

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
                    System.out.println( mainCharacter.weapons.get(i).getQuantity());
                    weaponSave.setInt(2,mainCharacter.getPrimaryKey());
                    weaponSave.execute();
                }


                String[] SQLArmorArray = {"Padded", "Leather","Studded_Leather","Hide", "Chain_Shirt", "Scale_Mail", "Breastplate", "Halfplate", "Ring_Mail",  "Chain_Mail" , "Splint", "Plate"};


                String[] SQLMusicalInstruments = {"Bagpipes","Drum","Dulcimer","Flute","Lute","Lyre","Horn","Pan_Flute","Shawm","Viol"};

                //TODO complete making SQL tables for Skills/ Inventory/ Features/   Proficiencies/Spells

                System.out.println("Saved");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    /**
     * Returns the position of the provided item in the given array
     * @param itemToBeFound String of what is being searched for
     * @param arrayThatContainsItem String array that is being searched for given item/string
     * @return Returns position of item in given array, if string is not found in array returns -1.
     */
    protected static int findArrayPosition(String itemToBeFound, String[] arrayThatContainsItem){
            int position = -1;
            for (int j = 0; j< arrayThatContainsItem.length;j++){
                if (arrayThatContainsItem[j].equals(itemToBeFound)){
                    position = j;
                }
            }
            return position;
        }
}

