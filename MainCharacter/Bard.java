package DungeonsAndDragons.MainCharacter;

import DungeonsAndDragons.MainCharacter.Item;
import DungeonsAndDragons.MainCharacter.CharacterSheet;
import DungeonsAndDragons.MainCharacter.Spells;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Bard extends CharacterClass{

    public Bard(CharacterSheet character) {
        this.character = character;
    }

    private CharacterSheet character;
    private String college;
    private Vector<String> features = new Vector();
    private int hitDice = 8;
    private int proficiency = 2;
    private int spellAttackMod;
    private int spellSaveDC;
    private Stage addLevelStage;

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
    Vector<String> allEighthLevelSpells = Spells.allClassSpellSetUp(8);
    Vector<String> allNinthLevelSpells = Spells.allClassSpellSetUp(9);

    Vector<String> proficiencies = new Vector<>();

    /**
     * Updates a VBox that will provide a HP label with current character HP, proficiency label with current proficiency modifier, a list view of the level proficiencies, and a list view of the features.
     * @return VBox that contains a HP label, proficiency label, proficiency list, and features list.
     */
    private VBox leftSetUp (){
        VBox left = new VBox();
        Label hp = new Label("Hit Points: " + character.getHitPoints());
        Label proficiency = new Label("Proficiency : + " + character.getProficiencyMod());
        ListView features = new ListView(character.getFeaturesList());
        ListView proficiencies = new ListView(character.levelProficienciesList);
        proficiencies.setTooltip(new Tooltip("Proficiencies"));
        proficiencies.setPlaceholder(new Label("Level Proficiencies"));
        features.setTooltip(new Tooltip("Features"));
        left.setPadding(new Insets(10, 10, 10, 10));
        left.getChildren().addAll(hp,proficiency,proficiencies,features);
        left.setPrefWidth(150);

        return left;
    }

    /**
     * Sets up a HBox with the abilities and their corresponding modifiers.
     * @return HBox of Labels that display the abilities and their corresponding modifiers
     */
    private HBox updateAbilityPane(){
        return new HBox(new Label("  Strength " + character.getStrengthScore()), new Label(" | Charisma " + character.getCharismaScore()), new Label(" | Dexterity " + character.getDexterityScore()), new Label(" | Constitution " + character.getConstitutionScore()), new Label(" | Intelligence " + character.getIntelligenceScore()), new Label(" | Wisdom " + character.getWisdomScore()));
    }

    /**
     * Sets up the addLevel() border pane to display the character abilities and their corresponding modifiers (top), update the border pane top with the HBox from updateAbilityPane(), and will set the border pane center to the pane that is provided.
     * @param borderPane Borderpane that will have the top modified to display the ability modifiers with their corresponding modifiers, top updated with the HBox from updateAbilityPane(), and that will update the center with the pane provided
     * @param pane VBox that will replace the border pane center
     * @return Border pane with the applied changes to the top, left, and center
     */
    private BorderPane borderPaneSetUp(BorderPane borderPane, VBox pane){
        borderPane.setTop(updateAbilityPane());
        borderPane.setLeft(leftSetUp());
        borderPane.setCenter(pane);
        return borderPane;

    }

    /**
     * Will update Character sheet HP with a random D8 roll and their constitution modifier. If their constitution modifier is negative and it is more than the D8 roll resulting in a negative number, 1 HP will be added to the character.
     *
     */
    public void updateCharacterHP(){
        int possibleHPIncrement = (d8Roll() + character.getConstitutionMod());
        if (possibleHPIncrement >= 1){
            character.setHitPoints(character.getHitPoints()+ possibleHPIncrement);
            System.out.println("HP +" +possibleHPIncrement );
        }else  {
            character.setHitPoints(character.getHitPoints() + 1);
            System.out.println("HP + 1");
        }

    }

    /**
     * Takes current level and continuously adds additional level until maximum level is hit. Throughout the process it will give the users options for selection for their current level
     *
     * @param stage Stage that will contain all Level choices
     * @param maxLevel      Max level that the user has chosen
     * @param startingLevel Level that the user if currently at
     */
    public void addLevel (Stage stage, int maxLevel, int startingLevel) {
        spellSaveDC = 8 + proficiency + character.getCharismaMod();
        spellAttackMod = proficiency + character.getCharismaMod();
        addLevelStage = stage;
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(updateAbilityPane());
        Scene scene = new Scene(borderPane, 600, 600);
        addLevelStage.setScene(scene);
        Button continueButton = new Button("Continue");
        addLevelStage.setTitle("Level " + startingLevel);
        Label error = new Label();
        error.setTextFill(Color.RED);
        borderPane.setStyle("-fx-border-color: black;" +
                    "-fx-background-radius: 10;" + "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);

        //Starts the leveling process at one. Each level will check if it is the max label and close the stage if it is, or go to the next level if not.
        switch (startingLevel){
            case 1: levelOne(borderPane,continueButton,error,maxLevel);
                break;
            case 2: levelTwo(borderPane,continueButton,error,maxLevel);
                break;
            case 3: levelThree(borderPane,continueButton,error,maxLevel);
                break;
            case 4: levelFour(borderPane,continueButton,error,maxLevel);
                break;
            case 5: levelFive(borderPane,continueButton,error,maxLevel);
                break;
            case 6: levelSix(borderPane,continueButton,error,maxLevel);
                break;
            case 7: levelSeven(borderPane,continueButton,error,maxLevel);
                break;
            case 8: levelEight(borderPane,continueButton,error,maxLevel);
                break;
            case 9: levelNine(borderPane,continueButton,error,maxLevel);
                break;
            case 10: levelTen(borderPane,continueButton,error,maxLevel);
                break;
            case 11: levelEleven(borderPane,continueButton,error,maxLevel);
                break;
            case 12: levelTwelve(borderPane,continueButton,error,maxLevel);
                break;
            case 13: levelThirteen(borderPane,continueButton,error,maxLevel);
                break;
            case 14: levelFourteen(borderPane,continueButton,error,maxLevel);
                break;
            case 15: levelFifteen(borderPane,continueButton,error,maxLevel);
                break;
            case 16: levelSixteen(borderPane,continueButton,error,maxLevel);
                break;
            case 17: levelSeventeen(borderPane,continueButton,error,maxLevel);
                break;
            case 18: levelEighteen(borderPane,continueButton,error,maxLevel);
                break;
            case 19: levelNineteen(borderPane,continueButton,error,maxLevel);
                break;
            case 20: levelTwenty(borderPane,continueButton,error,maxLevel);

        }

    }

    /** Level one for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelOne (BorderPane borderPane, Button continueButton, Label error, int maxLevel){
    //  Character known Cantrips = 2
    //  Character known spells = 4
        System.out.println("Level 1");
        addLevelStage.setTitle("Level 1");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        character.setProficiencyMod(2);
        character.setHitPoints(8 + character.getConstitutionMod());
        borderPaneSetUp(borderPane, pane);

        character.getFeaturesList().add("Spellcasting");
        character.getFeaturesList().add("Bardic Inspiration (d6)");
        Label chooseSpells = new Label("You have learned 2 Cantrips and 4 First level spells. Please choose a Cantrip");
        ListView<CheckBox> cantripsList = convertVectorToList(cantripList);
        ListView<CheckBox>  spellsList = convertVectorToList(firstLevelSpells);
        pane.getChildren().addAll(chooseSpells,new HBox(new VBox(new Label("Cantrips: 2 "),cantripsList),new VBox(new Label("First Level Spells: 4"),spellsList)),continueButton,error);

        continueButton.setOnAction(continueError -> {
            int counter1= 0;
            int counter2 =0;
            for (int i =0; i <cantripsList.getItems().size();i++){
                if (cantripsList.getItems().get(i).isSelected()){
                    counter1++;
                }
            }
            for (int i =0; i <spellsList.getItems().size();i++){
                if (spellsList.getItems().get(i).isSelected()){
                    counter2++;
                }
            }
            if (counter1 != 2 && counter2 !=4 ){
                error.setText("Please select 2 cantrips and 4 first level spells");
            }else
            if (counter1 != 2){
                error.setText("Please select 2 cantrips");
            }
            else
            if (counter2 != 4){
                error.setText("Please select 4 first level spells");
            } else{
                //Remove selected spells from available spells
                for (int i =0; i <cantripsList.getItems().size(); i++)
                    if (cantripsList.getItems().get(i).isSelected()){
                        character.cantripsListView.getItems().add(cantripsList.getItems().get(i).getText());
                        cantripList.remove(cantripsList.getItems().get(i).getText());
                    }
                for (int i =0; i <spellsList.getItems().size(); i++)
                    if (spellsList.getItems().get(i).isSelected()){
                        character.firstLevelSpellListView.getItems().add(spellsList.getItems().get(i).getText());
                        firstLevelSpells.remove(spellsList.getItems().get(i).getText());
                    }

                //Continues to next level
                    if (maxLevel == 1) {
                        addLevelStage.close();
                    } else levelTwo(borderPane,continueButton,error,maxLevel);
            }
        });
    }

    /** Level two for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTwo(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        System.out.println("Level 2");
        addLevelStage.setTitle("Level 2");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        error.setText("");
//                character.spells.setSize(5);
        updateCharacterHP();
        borderPaneSetUp(borderPane, pane);
        ListView<CheckBox> firstLevelSpell = convertVectorToList(firstLevelSpells);
        pane.getChildren().addAll(new Label("First Level Spells: 1"), firstLevelSpell,continueButton,error);
        continueButton.setOnAction( continueError ->{
            int counter = 0;
            for (int i =0; i< firstLevelSpell.getItems().size(); i++){
                if (firstLevelSpell.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter!=1){
                error.setText("Please select one first level spell");
            }else {
                for (int i =0; i< firstLevelSpell.getItems().size(); i++){
                    if (firstLevelSpell.getItems().get(i).isSelected()){
                        character.firstLevelSpellListView.getItems().add(firstLevelSpell.getItems().get(i).getText());
                        firstLevelSpells.remove(firstLevelSpell.getItems().get(i).getText());
                    }
                }
                if (maxLevel == 2) {
                    addLevelStage.close();
                }
                    else levelThree(borderPane,continueButton,error,maxLevel);
            }
        });

        character.getFeaturesList().add("Jack of All Trades");
        character.getFeaturesList().add("Song of Rest (d6)");
    }

    /** Level three for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelThree(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        System.out.println("Level 3");
        addLevelStage.setTitle("Level 3");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        error.setText("");
//                character.spells.setSize(6);
        updateCharacterHP();
        borderPaneSetUp(borderPane, pane);
        character.getFeaturesList().add("Expertise");
        ListView<CheckBox> firstLevelSpell = convertVectorToList(firstLevelSpells);
        ListView<CheckBox> secondLevelSpell = convertVectorToList(secondLevelSpells);
        ChoiceBox collegeChoice = new ChoiceBox(FXCollections.observableArrayList("College of Lore","College of Valor"));
        pane.getChildren().addAll(new HBox(new VBox(new Label("First Level Spells: 1"),firstLevelSpell), new VBox(new Label("Second Level Spells: 2"),secondLevelSpell)), new HBox(new Label("Select a Bard College: "),collegeChoice),continueButton,error);

        continueButton.setDisable(true);
        collegeChoice.setOnAction(collegeChoiceError -> continueButton.setDisable(false));
        continueButton.setOnAction(continueError ->{
            int firstLevelCounter = 0;
            for (int i =0; i <firstLevelSpell.getItems().size();i++){
                if (firstLevelSpell.getItems().get(i).isSelected()){
                    firstLevelCounter++;
                }
            }

            int secondLevelCounter = 0;
            for (int i =0; i <secondLevelSpell.getItems().size();i++){
                if (secondLevelSpell.getItems().get(i).isSelected()){
                    secondLevelCounter++;
                }
            }
            if (firstLevelCounter!=1 && secondLevelCounter != 2){
                error.setText("Please select 1 first level spell and 2 second level spells");
            }else
            if (firstLevelCounter != 1){
                error.setText("Please select 1 first level spell");
            }else
            if (secondLevelCounter != 2){
                error.setText("Please select 2 second level spells");
            }
            // Successful continue
            else {
                for (int i =0; i <firstLevelSpell.getItems().size();i++){
                    if (firstLevelSpell.getItems().get(i).isSelected()){
                        character.firstLevelSpellListView.getItems().add(firstLevelSpell.getItems().get(i).getText());
                        firstLevelSpells.remove(firstLevelSpell.getItems().get(i).getText());
                    }
                }
                for (int i =0; i <secondLevelSpell.getItems().size();i++){
                    if (secondLevelSpell.getItems().get(i).isSelected()){
                        character.secondLevelSpellListView.getItems().add(secondLevelSpell.getItems().get(i).getText());
                        secondLevelSpells.remove(secondLevelSpell.getItems().get(i).getText());
                    }
                }
                college = collegeChoice.getValue().toString();
                character.getMisc().add(college);
                if (college.equals("College of Lore")){
                    character.getFeaturesList().add("Cutting Words");
                    pane.getChildren().clear();
                    Label skillsLabel = new Label("Please select 3 skills to be proficient in" );
                    Vector availableSkills = new Vector();
                    for (int i =0; i<character.getAllSkills().length; i++){
                        if (!character.classProficienciesList.contains(character.getAllSkills()[i]) && !character.levelProficienciesList.contains(character.getAllSkills()[i])){
                            availableSkills.add(character.getAllSkills()[i]);
                        }
                    }
                    ListView<CheckBox> skillProficiencies = convertVectorToList(availableSkills);
                    pane.getChildren().addAll(skillsLabel,skillProficiencies,continueButton,error);
                    continueButton.setOnAction(continueEvent->{
                        error.setText("");
                        int counter = 0;
                        for (int i=0; i < skillProficiencies.getItems().size();i++){
                            if (skillProficiencies.getItems().get(i).isSelected()){
                                if (character.levelProficienciesList.contains(skillProficiencies.getItems().get(i).getText()) || character.classProficienciesList.contains(skillProficiencies.getItems().get(i).getText())){
                                    error.setText("You are already proficient with " + skillProficiencies.getItems().get(i).getText() + " , please choose a different skill" );
                                }else counter++;
                            }
                        }
                        if ( error.getText().equals("")){
                            if (counter!=3){
                                error.setText("Please select 3 skills");
                            }else {
                                for (int i=0; i < skillProficiencies.getItems().size();i++){
                                    if (skillProficiencies.getItems().get(i).isSelected()){
                                        character.levelProficienciesList.add(skillProficiencies.getItems().get(i).getText());
                                    }
                                }
                                if (maxLevel ==3) {
                                    addLevelStage.close();
                                } else levelFour(borderPane,continueButton,error,maxLevel);
                            }
                        }
                    });

                }else{
                    if (!character.levelProficienciesList.contains("Medium Armor") || !character.classProficienciesList.contains("Medium Armor")){
                        character.levelProficienciesList.add("Medium Armor");
                    }if (!character.levelProficienciesList.contains("Shields")||!character.classProficienciesList.contains("Shields")){
                        character.levelProficienciesList.add("Shields");
                    }if (!character.levelProficienciesList.contains("Martial Weapons") || !character.classProficienciesList.contains("Martial Weapons")){
                        character.levelProficienciesList.add("Martial Weapons");
                    }
                    character.getFeaturesList().add("Combat Inspiration");

                    if (maxLevel ==3) {
                        addLevelStage.close();
                    } else levelFour(borderPane,continueButton,error,maxLevel);
                }

            }
        });

    }

    /** Level four for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFour(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        System.out.println("Level 4");
        addLevelStage.setTitle("Level 4");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPaneSetUp(borderPane, pane);
        error.setText("");
//            character.spells.setSize(7);
//            character.cantrips.setSize(4);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        Button next = new Button("Next");
        ListView<CheckBox> cantripListView = convertVectorToList(cantripList);
        ListView<CheckBox> secondLevelSpellListView = convertVectorToList(secondLevelSpells);
        pane.getChildren().addAll(new HBox(new VBox(new Label("Cantrips: 1"),cantripListView)), new HBox(new VBox(new Label("Second Level Spells: 2"), secondLevelSpellListView)),next,error);

        next.setOnAction(nextError->{
            int cantripsCounter = 0;
            for (int i =0; i<cantripListView.getItems().size(); i++){
                if (cantripListView.getItems().get(i).isSelected()){
                    cantripsCounter++;
                }
            }

            int secondLevelCounter = 0;
            for (int i =0; i<secondLevelSpellListView.getItems().size(); i++){
                if (secondLevelSpellListView.getItems().get(i).isSelected()){
                    secondLevelCounter++;
                }
            }
            if (cantripsCounter !=1 && secondLevelCounter!= 2){
                error.setText("Please select 1 cantrip and 2 second level spells");
            } else
            if (cantripsCounter !=1){
                error.setText("Please select 1 cantrip ");
            }else
            if (secondLevelCounter!= 2){
                error.setText("Please select 2 second level spells");
            }else {
                for (int i =0; i<cantripListView.getItems().size(); i++){
                    if (cantripListView.getItems().get(i).isSelected()){
                        character.cantripsListView.getItems().add(cantripListView.getItems().get(i).getText());
                        cantripList.remove(cantripListView.getItems().get(i).getText());
                    }
                }
                for (int i =0; i<secondLevelSpellListView.getItems().size(); i++){
                    if (secondLevelSpellListView.getItems().get(i).isSelected()){
                        character.secondLevelSpellListView.getItems().add(secondLevelSpellListView.getItems().get(i).getText());
                        secondLevelSpells.remove(secondLevelSpellListView.getItems().get(i).getText());
                    }
                }
                borderPane.setCenter(abilityScoreImprovement(character, addLevelStage,maxLevel,4));
//                levelFive(borderPane,continueButton,error,maxLevel);
            }

        });
    }

    /** Level five for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFive(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 5");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPaneSetUp(borderPane, pane);
        System.out.println("Level 5");
        error.setText("");
        character.setProficiencyMod(3);
//            character.spells.setSize(8);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        Label levelSpells = new Label("Third level spells: 3");
        ListView<CheckBox> thirdLevelSpellsList = convertVectorToList(thirdLevelSpells);

        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i =0; i <thirdLevelSpellsList.getItems().size(); i++){
                if (thirdLevelSpellsList.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter!=3){
                error.setText("Please select 3 third level spells");
            }else {
                for (int i =0; i <thirdLevelSpellsList.getItems().size(); i++){
                    if (thirdLevelSpellsList.getItems().get(i).isSelected()){
                        character.thirdLevelSpellListView.getItems().add(thirdLevelSpellsList.getItems().get(i).getText());
                        thirdLevelSpells.remove(thirdLevelSpellsList.getItems().get(i).getText());
                    }
                }
                if (maxLevel==5) {
                    addLevelStage.close();
                }levelSix(borderPane,continueButton,error,maxLevel);
            }
        });
        pane.getChildren().addAll(levelSpells,thirdLevelSpellsList,continueButton,error);
        character.getFeaturesList().remove("Bardic Inspiration (d6)");
        character.getFeaturesList().add("Bardic Inspiration (d8)");
        character.getFeaturesList() .add("Font of Inspiration");
        System.out.println("Bardic Inspiration (d6) and Font of Inspiration added to features");


    }

    /** Level six for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSix(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 6");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 6");
        error.setText("");
//                character.spells.setSize(9);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        Label chooseThirdLevelSpell = new Label("Third Level Spell: 1");
        ListView<CheckBox> thirdLevelSpellList = convertVectorToList(thirdLevelSpells);
        pane.getChildren().addAll(chooseThirdLevelSpell,thirdLevelSpellList,continueButton,error);
        character.getFeaturesList().add("Countercharm");
        continueButton.setOnAction(continueEvent ->{
            int counter =0;
            for (int i =0; i<thirdLevelSpellList.getItems().size(); i++){
                if (thirdLevelSpellList.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter!=1){
                error.setText("Please select one third level spell.");
            }else{ // Successful continue
                for (int i =0; i<thirdLevelSpellList.getItems().size(); i++){
                    if (thirdLevelSpellList.getItems().get(i).isSelected()){
                        character.thirdLevelSpellListView.getItems().add(thirdLevelSpellList.getItems().get(i).getText());
                        thirdLevelSpellList.getItems().remove(thirdLevelSpellList.getItems().get(i));
                    }
                }
                if (college.equals("College of Lore")) {
                    System.out.println("Countercharm and Additional Magical Secrets added to features");
                    for (int i = 0; i < 2; i++) {
                        pane.getChildren().clear();
                        pane.getChildren().add(magicalSecrets(3,2,continueButton));
                        continueButton.setOnAction(continueButtonEvent ->{
                            if (maxLevel==6) {
                                addLevelStage.close();
                            } levelSeven(borderPane,continueButton,error,maxLevel);
                        });
                    }

                }
                if (college.equals("College of Valor")) {
                    character.getFeaturesList().add("Extra Attack");
                    System.out.println("Countercharm and Extra Attack added to features");
                    if (maxLevel ==6) {
                        addLevelStage.close();
                    }levelSeven(borderPane,continueButton,error,maxLevel);
                }

            }
        });

    }

    /** Level seven for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSeven(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 7");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 7");
        error.setText("");
//                character.spells.setSize(10);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        ListView<CheckBox> fourthLevelSpellsList = convertVectorToList(fourthLevelSpells);
        pane.getChildren().addAll(new Label("Fourth Level Spells: 1"), fourthLevelSpellsList,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter!=1){
                error.setText("Please select 1 fourth level spell");
            }else {
                // Successful continue
                for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                    if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                        character.fourthLevelSpellListView.getItems().add(fourthLevelSpellsList.getItems().get(i).getText());
                        fourthLevelSpells.remove(fourthLevelSpellsList.getItems().get(i).getText());
                    }
                }
                if (maxLevel == 7) {
                    addLevelStage.close();
                } else levelEight(borderPane,continueButton,error,maxLevel);
            }
        });

    }

    /** Level eight for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelEight(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 8");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 8");
        error.setText("");
//                character.spells.setSize(11);
        updateCharacterHP();
       borderPane.setLeft(leftSetUp());
        ListView<CheckBox> fourthLevelSpellsList = convertVectorToList(fourthLevelSpells);
        pane.getChildren().addAll(new Label("Fourth Level Spells: 1"), fourthLevelSpellsList,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter!=1){
                error.setText("Please select 1 fourth level spell");
            }else {
                // Successful continue
                for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                    if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                        character.fourthLevelSpellListView.getItems().add(fourthLevelSpellsList.getItems().get(i).getText());
                        fourthLevelSpells.remove(fourthLevelSpellsList.getItems().get(i).getText());
                    }
                }
                borderPane.setCenter(abilityScoreImprovement(character,addLevelStage,maxLevel,8));
            }
        });

    }

    /** Level nine for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelNine(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 9");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 9");
        error.setText("");
        character.setProficiencyMod(4);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
//                character.spells.setSize(12);
        character.getFeaturesList().remove("Song of Rest (d6)");
        character.getFeaturesList().add("Song of Rest (d8)");
        System.out.println("You have added Song of Rest (d8) to your features");

        ListView<CheckBox> fourthLevelSpellsList = convertVectorToList(fourthLevelSpells);
        ListView<CheckBox> fifthLevelSpellsList = convertVectorToList(fifthLevelSpells);
        pane.getChildren().addAll(new HBox(new VBox(new Label("Fourth Level Spells: 1"), fourthLevelSpellsList), new VBox(new Label("Fifth Level Spells: 1"), fifthLevelSpellsList)),continueButton,error);

        continueButton.setOnAction(continueButtonEvent ->{
            int fourthLevelCounter =0;
            for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                    fourthLevelCounter++;
                }
            }
            int fifthLevelCounter =0;
            for (int i=0; i<fifthLevelSpellsList.getItems().size(); i++){
                if (fifthLevelSpellsList.getItems().get(i).isSelected()){
                    fifthLevelCounter++;
                }
            }

            if (fourthLevelCounter!=1 && fifthLevelCounter!=1){
                error.setText("Please select 1 fourth level spell and 1 fifth level spell");
            }else if (fourthLevelCounter !=1){
                error.setText("Please select 1 fourth level spell");
            }else if (fifthLevelCounter !=1){
                error.setText("Please select 1 fifth level spell");
            }
            else {
                // Successful continue
                for (int i=0; i<fourthLevelSpellsList.getItems().size(); i++){
                    if (fourthLevelSpellsList.getItems().get(i).isSelected()){
                        character.fourthLevelSpellListView.getItems().add(fourthLevelSpellsList.getItems().get(i).getText());
                        fourthLevelSpells.remove(fourthLevelSpellsList.getItems().get(i).getText());
                    }
                }
                for (int i=0; i<fifthLevelSpellsList.getItems().size(); i++){
                    if (fifthLevelSpellsList.getItems().get(i).isSelected()){
                        character.fifthLevelSpellListView.getItems().add(fifthLevelSpellsList.getItems().get(i).getText());
                        fifthLevelSpells.remove(fifthLevelSpellsList.getItems().get(i).getText());
                    }
                }
                if ( maxLevel == 9) {
                    addLevelStage.close();
                } else levelTen(borderPane,continueButton,error,maxLevel);
            }
        });

    }

    /** Level ten for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 10");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 10");
        error.setText("");
//                character.spells.setSize(14);
//                character.cantrips.setSize(4);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        character.getFeaturesList().remove("Bardic Inspiration (d8)");
        character.getFeaturesList().add("Bardic Inspiration (d10)");
        character.getFeaturesList().add("Expertise");
        System.out.println("You have added Bardic Inspiration (d10), Expertise, Magical Secrets to your features");

        System.out.println("You have learned a new Cantrip");
        ListView<CheckBox> cantripListView = convertVectorToList(cantripList);
        ListView<CheckBox> fifthLevelListView = convertVectorToList(fifthLevelSpells);
        pane.getChildren().addAll(new HBox(new VBox(new Label("Cantrips: 1"),cantripListView), new VBox(new Label("Fifth Level Spells: 1"), fifthLevelListView)), continueButton,error);

        continueButton.setOnAction(continueEvent ->{
            int cantripsCounter = 0;
            for (int i=0; i < cantripListView.getItems().size(); i++){
                if (cantripListView.getItems().get(i).isSelected()){
                    cantripsCounter++;
                }
            }
            int fifthLevelCounter = 0;
            for (int i=0; i < fifthLevelListView.getItems().size(); i++){
                if (fifthLevelListView.getItems().get(i).isSelected()){
                    fifthLevelCounter++;
                }
            }

            if(cantripsCounter!=1 && fifthLevelCounter!=1){
                error.setText("Please select 1 cantrip and 1 fifth level spell");
            }else if(fifthLevelCounter!=1){
                error.setText("Please select 1 fifth level spell");
            }else if(cantripsCounter!=1){
                error.setText("Please select 1 cantrip");
            }else{
                //Successful continue
                for (int i=0; i < cantripListView.getItems().size(); i++){
                    if (cantripListView.getItems().get(i).isSelected()){
                        character.cantripsListView.getItems().add(cantripListView.getItems().get(i).getText());
                        cantripList.remove(cantripListView.getItems().get(i).getText());
                    }
                }
                for (int i=0; i < fifthLevelListView.getItems().size(); i++){
                    if (fifthLevelListView.getItems().get(i).isSelected()){
                        character.fifthLevelSpellListView.getItems().add(fifthLevelListView.getItems().get(i).getText());
                        fifthLevelSpells.remove(fifthLevelListView.getItems().get(i).getText());
                    }
                }
                pane.getChildren().clear();
                pane.getChildren().add(magicalSecrets(5,2,continueButton));
                continueButton.setOnAction(continueButtonEvent ->{
                    if (maxLevel == 10) {
                        addLevelStage.close();
                    } else  levelEleven(borderPane,continueButton,error,maxLevel);
                });
            }
        });

    }

    /** Level eleven for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelEleven(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 11");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 11");
        error.setText("");
//                character.spells.setSize(15);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        ListView<CheckBox> sixthLevelListView = convertVectorToList(sixthLevelSpells);
        pane.getChildren().addAll(new Label("Sixth Level Spells: 1"), sixthLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< sixthLevelListView.getItems().size(); i++){
                if (sixthLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 sixth level spell");
            }else {
                //Successful continue
                for (int i=0; i< sixthLevelListView.getItems().size(); i++){
                    if (sixthLevelListView.getItems().get(i).isSelected()){
                        character.sixthLevelSpellListView.getItems().add(sixthLevelListView.getItems().get(i).getText());
                        sixthLevelSpells.remove(sixthLevelListView.getItems().get(i).getText());
                    }
                }
                if (maxLevel == 11) {
                    addLevelStage.close();
                } else levelTwelve(borderPane,continueButton,error,maxLevel);
            }
        });

    }

    /** Level twelve for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTwelve(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 12");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 12");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        pane.getChildren().add(abilityScoreImprovement(character, addLevelStage,maxLevel,12));

    }

    /** Level thirteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelThirteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 13");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 13");
        error.setText("");
        character.setProficiencyMod(5);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        character.getFeaturesList().remove("Song of Rest (d8)");
        character.getFeaturesList().add("Song of Rest (d10)");
        System.out.println("You added Song of Rest (d10) to features");
        ListView<CheckBox> seventhLevelListView = convertVectorToList(seventhLevelSpells);
        pane.getChildren().addAll(new Label("Seventh Level Spells: 1"), seventhLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< seventhLevelListView.getItems().size(); i++){
                if (seventhLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 seventh level spell");
            }else {
                //Successful continue
                for (int i=0; i< seventhLevelListView.getItems().size(); i++){
                    if (seventhLevelListView.getItems().get(i).isSelected()){
                        character.seventhLevelSpellListView.getItems().add(seventhLevelListView.getItems().get(i).getText());
                        seventhLevelSpells.remove(seventhLevelListView.getItems().get(i).getText());
                    }
                }
                if (maxLevel ==13) {
                    addLevelStage.close();
                } else levelFourteen(borderPane,continueButton,error,maxLevel);
            }
        });
    }

    /** Level fourteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFourteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 14");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 14");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        if (college.equals("College of Lore")) {
            character.getFeaturesList().add("Peerless Skills");
            System.out.println("You have added Peerless Skills and Magical Secrets to features");
            pane.getChildren().add(magicalSecrets(7,2,continueButton));

        }
        if (college.equals("College of Valor")) {
            character.getFeaturesList().add("Battle Magic");
            System.out.println("You have added Battle Magic and Magical Secrets to features");
            pane.getChildren().add(magicalSecrets(7,2,continueButton));
        }
        continueButton.setOnAction(continueButtonEvent -> {
            if (maxLevel ==14) {
                addLevelStage.close();
            } else levelFifteen(borderPane,continueButton,error,maxLevel);
        });

    }

    /** Level fifteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFifteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 15");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 15");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        character.getFeaturesList().remove("Bardic Inspiration (d10)");
        character.getFeaturesList().add("Bardic Inspiration (d12)");
        ListView<CheckBox> eighthLevelListView = convertVectorToList(eighthLevelSpells);
        pane.getChildren().addAll(new Label("Eighth Level Spells: 1"), eighthLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< eighthLevelListView.getItems().size(); i++){
                if (eighthLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 eighth level spell");
            }else {
                //Successful continue
                for (int i=0; i< eighthLevelListView.getItems().size(); i++){
                    if (eighthLevelListView.getItems().get(i).isSelected()){
                        character.eighthLevelSpellListView.getItems().add(eighthLevelListView.getItems().get(i).getText());
                        eighthLevelSpells.remove(eighthLevelListView.getItems().get(i).getText());
                    }
                }
                if (maxLevel == 15) {
                    addLevelStage.close();
                } else levelSixteen(borderPane,continueButton,error,maxLevel);
            }
        });

    }

    /** Level sixteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSixteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 16");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 16");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        pane.getChildren().add(abilityScoreImprovement(character, addLevelStage,maxLevel,16));

    }

    /** Level seventeen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSeventeen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 17");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 17");
        error.setText("");
        character.setProficiencyMod(6);
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());
        character.getFeaturesList().remove("Song of Rest (d10");
        character.getFeaturesList().add("Song of Rest (d12)");

        ListView<CheckBox> ninthLevelListView = convertVectorToList(ninthLevelSpells);
        pane.getChildren().addAll(new Label("Ninth Level Spells: 1"), ninthLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< ninthLevelListView.getItems().size(); i++){
                if (ninthLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 ninth level spell");
            }else {
                //Successful continue
                for (int i=0; i< ninthLevelListView.getItems().size(); i++){
                    if (ninthLevelListView.getItems().get(i).isSelected()){
                        character.ninthLevelSpellListView.getItems().add(ninthLevelListView.getItems().get(i).getText());
                        ninthLevelSpells.remove(ninthLevelListView.getItems().get(i).getText());
                    }
                }
                if (maxLevel == 17) {
                    addLevelStage.close();
                } else levelEighteen(borderPane,continueButton,error,maxLevel);
            }
        });

    }

    /** Level eighteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelEighteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 18");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 18");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());

        ListView<CheckBox> fifthLevelListView = convertVectorToList(fifthLevelSpells);
        pane.getChildren().addAll(new Label("Fifth Level Spells: 1"), fifthLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< fifthLevelListView.getItems().size(); i++){
                if (fifthLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 fifth level spell");
            }else {
                //Successful continue
                for (int i=0; i< fifthLevelListView.getItems().size(); i++){
                    if (fifthLevelListView.getItems().get(i).isSelected()){
                        character.fifthLevelSpellListView.getItems().add(fifthLevelListView.getItems().get(i).getText());
                        fifthLevelSpells.remove(fifthLevelListView.getItems().get(i).getText());
                    }
                }
                pane.getChildren().clear();
                pane.getChildren().add(magicalSecrets(9,2, continueButton));
                continueButton.setOnAction(continueButtonE ->{
                    if (maxLevel == 18) {
                        addLevelStage.close();
                    } else levelNineteen(borderPane,continueButton,error,maxLevel);
                });
            }
        });

    }

    /** Level nineteen for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelNineteen(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 19");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 19");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());

        ListView<CheckBox> sixthLevelListView = convertVectorToList(sixthLevelSpells);
        pane.getChildren().addAll(new Label("Sixth Level Spells: 1"), sixthLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< sixthLevelListView.getItems().size(); i++){
                if (sixthLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 sixth level spell");
            }else {
                //Successful continue
                for (int i=0; i< sixthLevelListView.getItems().size(); i++){
                    if (sixthLevelListView.getItems().get(i).isSelected()){
                        character.sixthLevelSpellListView.getItems().add(sixthLevelListView.getItems().get(i).getText());
                        sixthLevelSpells.remove(sixthLevelListView.getItems().get(i).getText());
                    }
                }
                pane.getChildren().clear();
                pane.getChildren().add(abilityScoreImprovement(character, addLevelStage,maxLevel,19));
            }
        });

    }

    /** Level twenty for Bard Character
     *
     * @param borderPane Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param error Label that will display an error in red text
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTwenty(BorderPane borderPane, Button continueButton, Label error,int maxLevel){
        addLevelStage.setTitle("Level 20");
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(15,5,5,5));
        borderPane.setCenter(pane);
        System.out.println("Level 20");
        error.setText("");
        updateCharacterHP();
        borderPane.setLeft(leftSetUp());

        ListView<CheckBox> seventhLevelListView = convertVectorToList(seventhLevelSpells);
        pane.getChildren().addAll(new Label("Seventh Level Spells: 1"), seventhLevelListView,continueButton,error);
        continueButton.setOnAction(continueButtonEvent ->{
            int counter =0;
            for (int i=0; i< seventhLevelListView.getItems().size(); i++){
                if (seventhLevelListView.getItems().get(i).isSelected()){
                    counter++;
                }
            }
            if (counter != 1){
                error.setText("Please select 1 seventh level spell");
            }else {
                //Successful continue
                for (int i=0; i< seventhLevelListView.getItems().size(); i++){
                    if (seventhLevelListView.getItems().get(i).isSelected()){
                        character.seventhLevelSpellListView.getItems().add(seventhLevelListView.getItems().get(i).getText());
                        seventhLevelSpells.remove(seventhLevelListView.getItems().get(i).getText());
                    }
                }
                if (maxLevel ==20) {
                    addLevelStage.close();
                } else addLevel(addLevelStage, maxLevel, 21);
            }
        });
        character.getFeaturesList().add("Superior Inspiration");
        System.out.println("You have added Superior Inspiration to your features");

    }



    /**
     * Checks if the contents are already in the vector, if yes nothing happens, if no the contents are added to the vector and prints the contents have been added to the vector.
     *
     * @param vector     The vector you are checking/ adding the contents into
     * @param contents   String that you are checking/ adding in the vector
     * @param vectorName Name of the vector you are adding the item to
     */
    public void checkVectorAndAdd(Vector vector, String vectorName, String contents) {
        if (!vector.contains(contents)) {
            vector.add(contents);
            System.out.println(contents + " added to " + vectorName);
        }

    }


    // Tested and verified 9/5

    /**
     * Allows user to select their armor including proficient armor, and non-proficient armor
     * @param chooseArmorStage Stage that the options will be displayed on.
     */
    public void chooseArmor(Stage chooseArmorStage) {
        VBox pane = new VBox(10);
        Scene scene = new Scene(pane, 450, 280);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseArmorStage.setScene(scene);

        pane.setPadding(new Insets(30, 30, 20, 30));

        Button continueButton = new Button("Continue");
        continueButton.setPrefWidth(100);
        continueButton.setTranslateX(150);

        Label armorLabel = new Label("You are proficient in Light Armor.\n\nChoose your Armor. Bard's come pre-equipped with Leather armor");
        Label proficiencyWarning = new Label("Note: If you wear armor that you lack proficiency with, you have disadvantage on any ability checks, saving throws, or attack rolls that involves Strength or Dexterity, and you can’t cast spells.");
        proficiencyWarning.setWrapText(true);
        ObservableList proficientArmor = FXCollections.observableArrayList(character.getLightArmor()[0], character.getLightArmor()[1], character.getLightArmor()[2]);
        ObservableList notProficientArmor = FXCollections.observableArrayList(character.getMediumArmor()[0], character.getMediumArmor()[1], character.getMediumArmor()[2], character.getMediumArmor()[3], character.getMediumArmor()[4], character.getHeavyArmor()[0], character.getHeavyArmor()[1], character.getHeavyArmor()[2], character.getHeavyArmor()[3]);

        ComboBox<String> proficientArmorChoices = new ComboBox(proficientArmor);
        proficientArmorChoices.setValue("Proficient ");
        ComboBox<String> nonProficientArmorChoices = new ComboBox<>(notProficientArmor);
        nonProficientArmorChoices.setValue("Non-Proficient");

        ChoiceBox<String> yOrN = new ChoiceBox(FXCollections.observableArrayList("Yes", "No"));
        yOrN.setDisable(true);

        Label armor = new Label("Armor: ");
        Label shield = new Label("Shield: ");

        proficientArmorChoices.setOnAction(proficientArmorError -> {
            character.setArmor(proficientArmorChoices.getValue());
            armor.setText("Armor: " + proficientArmorChoices.getValue());
            proficientArmorChoices.setDisable(true);
            proficientArmorChoices.hide();
            yOrN.setDisable(false);
            nonProficientArmorChoices.setDisable(true);


            continueButton.setOnAction(e -> {
                //finds index of Armor and Adds Armor as an item
                for (int i = 0; i < character.getAllArmor().length; i++) {
                    if (character.getAllArmor()[i].equals(proficientArmorChoices.getValue())) {
                        checkAndAddItemQuantity(character.armorList, new Item(proficientArmorChoices.getValue(), character.getAllArmorDescriptions()[i], 1, character.getAllArmorCost()[i]));
                        character.setAc(character.getAc() + character.getAllArmorAC()[i]);
                        break;
                    }
                }

                if (character.isShield() == true) {
                    checkAndAddItemQuantity(character.armorList, new Item("Shield", "A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.", 1, 10));
                    character.setAc(character.getAc() + 2);
                }
                chooseWeapon(chooseArmorStage);

            });

        });

        nonProficientArmorChoices.setOnAction(nonProficientArmor -> {
            character.setArmor(nonProficientArmorChoices.getValue());
            armor.setText("Armor: " + nonProficientArmorChoices.getValue());
            proficientArmorChoices.setDisable(true);
            proficientArmorChoices.hide();
            yOrN.setDisable(false);
            nonProficientArmorChoices.setDisable(true);

            continueButton.setOnAction(e -> {

                //finds index of Armor and Adds Armor as an item
                for (int i = 0; i < character.getAllArmor().length; i++) {
                    if (character.getAllArmor()[i].equals(nonProficientArmorChoices.getValue())) {
                        checkAndAddItemQuantity(character.armorList, new Item(nonProficientArmorChoices.getValue(), character.getAllArmorDescriptions()[i], 1, character.getAllArmorCost()[i]));
                        character.setAc(character.getAc() + character.getAllArmorAC()[i]);
                        break;
                    }
                }

                if (character.isShield() == true) {
                    checkAndAddItemQuantity(character.armorList, new Item("Shield", "A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.", 1, 10));
                    character.setAc(character.getAc() + 2);
                }
                chooseWeapon(chooseArmorStage);
            });

        });

        armor.setMinWidth(150);
        proficientArmorChoices.setPrefWidth(100);
        nonProficientArmorChoices.setPrefWidth(125);
        nonProficientArmorChoices.setTranslateX(25);

        yOrN.setOnAction(e -> {
            if (yOrN.getValue().equals("Yes")) {
                shield.setText("Shield: Yes");
                character.setShield(true);
            } else {
                shield.setText("Shield: No ");
                character.setShield(false);
            }
            yOrN.setDisable(true);
            yOrN.setTranslateX(93);
            pane.getChildren().add(continueButton);
        });


        pane.getChildren().addAll(armorLabel, new HBox(armor, proficientArmorChoices, nonProficientArmorChoices), new HBox(shield, yOrN), proficiencyWarning);

        yOrN.setTranslateX(112);
        pane.setStyle("-fx-border-color: black;" +
                "-fx-background-radius: 10;" + "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);

        character.nonProficientArmor =new String[] {character.getHeavyArmor()[0],character.getHeavyArmor()[1],character.getHeavyArmor()[2],character.getHeavyArmor()[3],character.getMediumArmor()[0],character.getMediumArmor()[1],character.getMediumArmor()[2],character.getMediumArmor()[3],character.getMediumArmor()[4],"Shield"};

    }


    // Tested and verified 9/5
    /**
     * Walks user through on adding their Weapons / Equipment to their character
     */
    public void chooseWeapon(Stage chooseWeaponStage){
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(pane,475,550);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseWeaponStage.setScene(scene);
        pane.setPadding(new Insets(30,30,30,30));

        VBox equipmentPane = new VBox(20);
        equipmentPane.setDisable(true);
        Button continueButton = new Button("Continue");
        continueButton.setDisable(true);
        Label weaponLabel = new Label("Choose between the options below.");

        Label musicLabel = new Label("Select 3 music instruments");
        Label skillLabel = new Label("Select 3 skills");
        Label error = new Label();

        //Sets the proficiency choices
        VBox proficiencyPane = new VBox(20);
        Label proficienciesLabel = new Label("Proficiency Choices");
        proficienciesLabel.setUnderline(true);

        Button next = new Button("Next");
        ListView<CheckBox> musicList = convertArrayToList(character.getMusicalInstruments());
        ListView<CheckBox> skillList = convertArrayToList(character.getAllSkills());
        skillList.setPrefHeight(150);
        musicList.setPrefHeight(150);

        HBox proficienciesHBox = new HBox(20);
        proficienciesHBox.getChildren().addAll(new VBox(musicLabel,musicList),new VBox(skillLabel,skillList));
        HBox nextHBox = new HBox(20);
        nextHBox.getChildren().addAll(next,error);

        proficiencyPane.getChildren().addAll(proficienciesHBox,nextHBox);

        next.setOnAction(nextError ->{
            //Saves proficiencies
            int counter1 =0;
            for (int i =0; i<musicList.getItems().size(); i++){
                if (musicList.getItems().get(i).isSelected()){
                    counter1++;
                }
            }

            int counter2 = 0;
            for (int i =0; i<skillList.getItems().size(); i++){
                if (skillList.getItems().get(i).isSelected()){
                    counter2++;
                }
            }

            if (counter2 != 3 && counter1!=3){
                error.setText("Please select 3 musical instruments and 3 skills");
            }else if (counter2 != 3){
                error.setText("Please select 3 skills");
            } else if (counter1 != 3){
                error.setText("Please select 3 musical instruments");
            } else {
                for (int i =0; i<skillList.getItems().size(); i++){
                    if (skillList.getItems().get(i).isSelected()){
                        character.classProficienciesList.add(skillList.getItems().get(i).getText());
                    }
                }
                for (int i =0; i<musicList.getItems().size(); i++){
                    if (musicList.getItems().get(i).isSelected()){
                        character.classProficienciesList.add(musicList.getItems().get(i).getText());
                    }
                }
                proficiencyPane.setDisable(true);
                equipmentPane.setDisable(false);
            }
        });




        //Equipment Choice Setup
        Label equipmentChoice = new Label("Equipment Choice");
        equipmentChoice.setUnderline(true);

        Label R_L_SW = new Label("Rapier, LongSword, or any Simple Weapon");
        ObservableList R_L_SW_List = FXCollections.observableArrayList("Rapier","Longsword", character.getSimpleMeleeWeapons()[0],character.getSimpleMeleeWeapons()[1],character.getSimpleMeleeWeapons()[2],character.getSimpleMeleeWeapons()[3],character.getSimpleMeleeWeapons()[4],character.getSimpleMeleeWeapons()[5],character.getSimpleMeleeWeapons()[6],character.getSimpleMeleeWeapons()[7],character.getSimpleMeleeWeapons()[8],character.getSimpleMeleeWeapons()[9],character.getSimpleRangedWeapons()[0],character.getSimpleRangedWeapons()[1],character.getSimpleRangedWeapons()[2],character.getSimpleRangedWeapons()[3]);
        ChoiceBox R_L_SW_ComboBox = new ChoiceBox(R_L_SW_List);
        R_L_SW_ComboBox.setPrefWidth(150);
        R_L_SW_ComboBox.setTranslateX(40);

        Label pack = new Label("Diplomat's pack or Entertainer's pack");
        ChoiceBox packChoice = new ChoiceBox(FXCollections.observableArrayList("Diplomat's pack","Entertainer's pack"));
        packChoice.setPrefWidth(150);
        packChoice.setTranslateX(70);


        Label musicalInstrumentChoice = new Label("Select any musical instrument");
        ChoiceBox musicalInstrumentList = new ChoiceBox(FXCollections.observableArrayList(character.getMusicalInstruments()));
        musicalInstrumentList.setPrefWidth(150);
        musicalInstrumentList.setTranslateX(110);

        packChoice.setDisable(true);
        musicalInstrumentList.setDisable(true);

        R_L_SW_ComboBox.setOnAction(weaponChoice ->{
            packChoice.setDisable(false);
            packChoice.setOnAction(packChoices ->{
                musicalInstrumentList.setDisable(false);
                musicalInstrumentList.setOnAction(musicalInstrument -> {
                    continueButton.setDisable(false);
                });
            });
        });

        checkAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[1],character.getLightArmorDescription()[1],1,character.getLightArmorCost()[1]));
        checkAndAddItemQuantity(character.weapons, new Item(character.getSimpleMeleeWeapons()[1],character.getSimpleMeleeWeaponProperties()[1],1,character.getSimpleMeleeWeaponsCost()[1]));
        System.out.println("Dagger / Leather has been added to your inventory");
        character.classProficienciesList.addAll("Dexterity","Charisma","Light Armor","Simple Weapons","Hand Crossbows","Longswords","Rapiers","Shortsword");

        continueButton.setOnAction(equipmentChoices ->{
            // Saves equipment choice into Charactersheet
            for (int i = 0 ; i< character.getAllWeapons().length ; i++){
                if (character.getAllWeapons()[i].equals(R_L_SW_ComboBox.getValue())){
                    checkAndAddItemQuantity(character.weapons,new Item(character.getAllWeapons()[i],character.getAllWeaponsProperties()[i],1,character.getAllWeaponCost()[i]));
                }
            }
            // Saves Pack Choice into Charactersheet
            if(packChoice.getValue().equals("Diplomat's pack")){
                checkAndAddItemQuantity(character.inventory, new Item("Chest","",1,5));
                checkAndAddItemQuantity(character.inventory, new Item("Map or Scroll Case","This cylindrical leather case can hold up to ten rolled-up sheets of paper or five rolled-up sheets of parchment ",2,1));
                checkAndAddItemQuantity(character.inventory, new Item("Fine Clothes","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Ink","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Ink Pen","",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Lamp","A  lamp casts bright light in a 15 foot radius and dim light for an additional 30 feet. ONce lit, it burns for 6 hours on a flask (1 pint) of oil",1,5));
                checkAndAddItemQuantity(character.inventory, new Item("Oil","Oils usually comes in a clay flask that holds 1 pint. As an action you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5 foot square area,provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters or ends its turn in the area. A creature can take this damage only once per turn.",2,0));
                checkAndAddItemQuantity(character.inventory, new Item("Paper","",5,0));
                checkAndAddItemQuantity(character.inventory, new Item("Perfume","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Sealing Wax","",1,5));
                checkAndAddItemQuantity(character.inventory, new Item("Soap","",1,5));
                System.out.println("Diplomat Pack added to inventory.");

            }if (packChoice.getValue().equals("Entertainer's pack")){
                checkAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
                checkAndAddItemQuantity(character.inventory, new Item("Costume Clothes","",2,0));
                checkAndAddItemQuantity(character.inventory, new Item("Candle","For 1 hour, a candle sheds bright light in a 5 - foot radius and dim light for an additional 5 feet",2,1));
                checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",5,5));
                checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Disguise kit","This pouch of cosmetics, hair dye,and small props let you create disguises that change your physical appearance. Proficiency with this kit lets you add your proficiency bonus to any ability checks you make to create a visual disguise.",1,25));
                System.out.println("Entertainer pack added to inventory.");
            }

            //Saves instrument choice to Charactersheet
            character.instruments.add(musicalInstrumentList.getValue().toString());

            chooseWeaponStage.close();
        });

        continueButton.setTranslateX(175);
        equipmentPane.getChildren().addAll(new HBox(R_L_SW,R_L_SW_ComboBox), new HBox(pack,packChoice),new HBox(musicalInstrumentChoice,musicalInstrumentList));
        pane.getChildren().addAll(weaponLabel,proficienciesLabel,proficiencyPane,equipmentChoice,equipmentPane,continueButton);
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
     * Code needed to complete the Magical Secrets Feature. Allows the user to select any level spell
     * @param maxLevel Max Level that the Spells can be
     * @param maxSelection Maximum spells that the user can select from the available CheckBox's
     * @param continueButton Button to link the method back to the method where it was invoked. Continue button action will need to be set after the magical secrets has been returned.
     * @return VBox that will contain all of the necessary spells that the user can select from
     */
    public VBox magicalSecrets(int maxLevel, int maxSelection, Button continueButton){
        continueButton.setDisable(true);
        Button checkSpells = new Button("Check Spells");
        VBox mainPane = new VBox(20);
        ObservableList<CheckBox> spellsList = FXCollections.observableArrayList();
        ListView spellListView = new ListView();
        spellListView.setPrefSize(100,500);
        LinkedList<CheckBox> selectedBoxes = new LinkedList<>();
        Label error = new Label();
        error.setTextFill(Color.RED);
        mainPane.getChildren().add(new Label("Available Spells: "+ maxSelection));

        for (int iterator =1; iterator<=maxLevel; iterator++){
            switch (iterator){
                case 1:
                    // Cantrips
                    for (int i =0; i < allCantrips.size(); i++){
                        if (!character.cantripsListView.getItems().contains(allCantrips.get(i))){
                            CheckBox checkBox = new CheckBox(allCantrips.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                    //first level spells
                    for (int i =0; i < allFirstLevelSpells.size(); i++){
                        if (!character.firstLevelSpellListView.getItems().contains(allFirstLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allFirstLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;
                case 2:
                    //Second level spells
                    for (int i =0; i < allSecondLevelSpells.size(); i++){
                        if (!character.secondLevelSpellListView.getItems().contains(allSecondLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allSecondLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                    if (maxLevel == 2){
                        break;
                    }
                case 3:
                    //Third level spells
                    for (int i =0; i < allThirdLevelSpells.size(); i++){
                        if (!character.thirdLevelSpellListView.getItems().contains(allThirdLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allThirdLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;
                case 4:
                    //Fourth level spells
                    for (int i =0; i < allFourthLevelSpells.size(); i++){
                        if (!character.fourthLevelSpellListView.getItems().contains(allFourthLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allFourthLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;
                case 5:
                    //Fifth level spells
                    for (int i =0; i < allFifthLevelSpells.size(); i++){
                        if (!character.fifthLevelSpellListView.getItems().contains(allFifthLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allFifthLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;

                case 6:
                    //Sixth level spells
                    for (int i =0; i < allSixthLevelSpells.size(); i++){
                        if (!character.sixthLevelSpellListView.getItems().contains(allSixthLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allSixthLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;

                case 7:
                    //Seventh level spells
                    for (int i =0; i < allSeventhLevelSpells.size(); i++){
                        if (!character.seventhLevelSpellListView.getItems().contains(allSeventhLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allSeventhLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;

                case 8:
                    //Eighth level spells
                    for (int i =0; i < allEighthLevelSpells.size(); i++){
                        if (!character.eighthLevelSpellListView.getItems().contains(allEighthLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allEighthLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;
                case 9:
                    //Ninth level spells
                    for (int i =0; i < allNinthLevelSpells.size(); i++){
                        if (!character.ninthLevelSpellListView.getItems().contains(allNinthLevelSpells.get(i))){
                            CheckBox checkBox = new CheckBox(allNinthLevelSpells.get(i));
                            checkBox.setOnAction(checkBoxEvent ->{
                                if (checkBox.isSelected()){
                                    selectedBoxes.add(checkBox);
                                }else selectedBoxes.remove(checkBox);
                            });
                            spellsList.add(checkBox);
                        }
                    }
                        break;
            }
        }
        spellListView.setItems(spellsList);
        mainPane.getChildren().addAll(spellListView,new HBox(checkSpells,continueButton),error);
        checkSpells.setOnAction(continueEvent ->{
            //confirm user does not already have spell selected
            //check how many are selected
            if (selectedBoxes.size() != maxSelection){
                error.setText("Please select " + maxSelection + " of the listed spells");
            }else{
                for (int i=0; i<selectedBoxes.size(); i++){
                    System.out.println(selectedBoxes.get(i).getText());
                    if (allCantrips.contains(selectedBoxes.get(i).getText())){
                        character.cantripsListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allFirstLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.firstLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allSecondLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.secondLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allThirdLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.thirdLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allFourthLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.fourthLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allFifthLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.fifthLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allSixthLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.sixthLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allSeventhLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.seventhLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allEighthLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.eighthLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }else if (allNinthLevelSpells.contains(selectedBoxes.get(i).getText())){
                        character.ninthLevelSpellListView.getItems().add(selectedBoxes.get(i).getText());
                    }
                    spellListView.setDisable(true);
                    continueButton.setDisable(false);
                }
            }
        });

        return mainPane;

    }



}
