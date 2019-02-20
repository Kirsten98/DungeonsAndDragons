package DungeonsAndDragons;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.swing.text.LabelView;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Bard {
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


    //TODO Test Spells

    // Tested and verfied 9/10

    /**
     * @param character       CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice   Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void abilityAddition(CharacterSheet character, String AbilityChoice, int modifierAddtion) {
        if (AbilityChoice.equals("Charisma")) {
            character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
            System.out.println("Charisma +" + modifierAddtion);
            character.setCharismaMod(findAbilityMod(character.getCharismaScore()));

        }
        if (AbilityChoice.equals("Strength")) {
            character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
            System.out.println("Strength +" + modifierAddtion);
            character.setStrengthMod(findAbilityMod(character.getStrengthScore()));

        }
        if (AbilityChoice.equals("Dexterity")) {
            character.setDexterityScore(character.getDexterityScore() + modifierAddtion);
            System.out.println("Dexterity +" + modifierAddtion);
            character.setDexterityMod(findAbilityMod(character.getDexterityScore()));

        }
        if (AbilityChoice.equals("Wisdom")) {
            character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
            System.out.println("Wisdom +" + modifierAddtion);
            character.setWisdomMod(findAbilityMod(character.getWisdomScore()));
        }
        if (AbilityChoice.equals("Intelligence")) {
            character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
            System.out.println("Intelligence +" + modifierAddtion);
            character.setIntelligenceMod(findAbilityMod(character.getIntelligenceScore()));
        }
        if (AbilityChoice.equals("Constitution")) {
            character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
            System.out.println("Constitution +" + modifierAddtion);
            character.setConstitutionMod(findAbilityMod(character.getConstitutionScore()));

        }
    }

    /**
     * Prints out the Ability Choices
     */
    public static void abilityChoicePrintout() {
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

    }


    // Tested and Verified 9/3

    /**
     * Gives the user the  choice to either add +2 to 1 ability score, or add 2 separate ability scores by +1
     *
     * @param addLevelStage Stage that the choice will be displayed on
     * @param maxLevel      Maximum level that the user has selected
     * @param startinglevel Level that the user is currently making choices for
     * @return
     */
    public GridPane abilityScoreImprovement(Stage addLevelStage, int maxLevel, int startinglevel) {
        Button continueButton = new Button("Continue");
        Label choice = new Label();
        choice.setWrapText(true);
        Button charisma = new Button("Charisma");
        Button strength = new Button("Strength");
        Button dexterity = new Button("Dexterity");
        Button wisdom = new Button("Wisdom");
        Button intelligence = new Button("Intelligence");
        Button constitution = new Button("Constitution");

        GridPane pane = new GridPane();
        Label question = new Label("Would you like to increase one ability score by +2 or two ability scores by +1 ");
        Button plus2 = new Button("One ability score by +2");
        Button plus1 = new Button("Two ability scores by +1");

        pane.add(question, 0, 0, 6, 1);
        pane.add(plus2, 1, 1);
        pane.add(plus1, 1, 2);
        pane.setVgap(20);
        pane.setHgap(20);

        charisma.setOnAction(charismaEvent -> {
            if (character.getCharismaScore() + 1 > 20 || character.getCharismaScore() + 2 > 20) {
                choice.setText("Charisma ability score is greater than 20.\nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Charisma");
                continueButton.setDisable(false);
            }
        });

        strength.setOnAction(strengthEvent -> {
            if (character.getStrengthScore() + 1 > 20 || character.getStrengthScore() + 2 > 20) {
                choice.setText("Strength ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Strength");
                continueButton.setDisable(false);
            }
        });
        dexterity.setOnAction(dexterityEvent -> {
            if (character.getDexterityScore() + 1 > 20 || character.getDexterityScore() + 2 > 20) {
                choice.setText("Dexterity ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Dexterity");
                continueButton.setDisable(false);
            }
        });
        wisdom.setOnAction(wisdomEvent -> {
            if (character.getWisdomScore() + 1 > 20 || character.getWisdomScore() + 2 > 20) {
                choice.setText("Wisdom ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Wisdom");
                continueButton.setDisable(false);
            }
        });
        intelligence.setOnAction(intelligenceEvent -> {
            if (character.getIntelligenceScore() + 1 > 20 || character.getIntelligenceScore() + 2 > 20) {
                choice.setText("Intelligence ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Intelligence");
                continueButton.setDisable(false);
            }
        });
        constitution.setOnAction(constitutionEvent -> {
            if (character.getConstitutionScore() + 1 > 20 || character.getConstitutionScore() + 2 > 20) {
                choice.setText("Constitution ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            } else {
                choice.setText("Constitution");
                continueButton.setDisable(false);
            }
        });


        plus2.setOnAction(e -> {
            pane.getChildren().remove(plus1);
            pane.getChildren().remove(plus2);
            pane.add(charisma, 0, 1);
            pane.add(strength, 1, 1);
            pane.add(dexterity, 2, 1);
            pane.add(wisdom, 0, 2);
            pane.add(intelligence, 1, 2);
            pane.add(constitution, 2, 2);
            pane.add(choice, 1, 3, 6, 1);
            pane.add(continueButton, 1, 5);
            question.setText("Which Ability score would you like to increase by +2 ?");

            continueButton.setOnAction(continueEvent -> {
                abilityAddition(character, choice.getText(), 2);
                if (startinglevel == maxLevel) {
                    addLevelStage.close();
                } else addLevel(addLevelStage, maxLevel, startinglevel + 1);
            });

        });

        plus1.setOnAction(e -> {
            String[] intChoice = new String[2];
            pane.getChildren().remove(plus1);
            pane.getChildren().remove(plus2);
            pane.add(charisma, 0, 1);
            pane.add(strength, 1, 1);
            pane.add(dexterity, 2, 1);
            pane.add(wisdom, 0, 2);
            pane.add(intelligence, 1, 2);
            pane.add(constitution, 2, 2);
            pane.add(choice, 1, 3, 6, 1);
            pane.add(continueButton, 1, 4);
            continueButton.setDisable(true);
            question.setText("Choose your first ability to increase by +1.");

            continueButton.setOnAction(continueEvent -> {
                intChoice[0] = choice.getText();
                question.setText("Choose your second ability to increase by +1.");
                continueButton.setDisable(true);
                choice.setText("");

                continueButton.setOnAction(continueEvent2 -> {
                    intChoice[1] = choice.getText();
                    for (int i = 0; i < 2; i++) {
                        abilityAddition(character, intChoice[i], 1);
                        if (startinglevel == maxLevel) {
                            addLevelStage.close();
                        } else addLevel(addLevelStage, maxLevel, startinglevel + 1);
                    }
                });
            });

        });
        return pane;
    }


    /**
     * Takes current level and continuously adds additional level until maximum level is hit. Throughout the process it will give the users options for selection for their current level
     *
     * @param addLevelStage Stage that will contain all Level choices
     * @param maxLevel      Max level that the user has chosen
     * @param startingLevel Level that the user if currently at
     */
    public void addLevel(Stage addLevelStage, int maxLevel, int startingLevel) {
        //TODO Note - Possibly make each level a separate method, and instead of dealing with starting level it can just call the method for the next level

        if (startingLevel <= maxLevel) {
            spellSaveDC = 8 + proficiency + character.getCharismaMod();
            spellAttackMod = proficiency + character.getCharismaMod();
            Label hp = new Label("Hit Points: " + character.getHitPoints());
            Label proficiency = new Label("Proficiency : + " + character.getProficiencyMod());
            ListView features = new ListView(character.getFeaturesList());
            ListView proficiencies = new ListView(character.levelProficienciesList);
            proficiencies.setTooltip(new Tooltip("Proficiencies"));
            proficiencies.setPlaceholder(new Label("Level Proficiencies"));
            features.setTooltip(new Tooltip("Features"));
            VBox pane = new VBox(20);
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(pane);
            borderPane.setTop(new Label("Current level " + startingLevel + " out of " + maxLevel));
            Scene scene = new Scene(borderPane, 600, 600);
            addLevelStage.setScene(scene);
            Label changes = new Label();
            Button continueButton = new Button("Continue");
            addLevelStage.setTitle("Level " + startingLevel);
            Label error = new Label();
            error.setTextFill(Color.RED);
//            ObservableList misc = FXCollections.observableArrayList();
            continueButton.setOnAction(e -> {
                if (startingLevel == maxLevel) {
                    addLevelStage.close();
                } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
            });

            if (startingLevel == 1) {
                VBox levelOne = new VBox(20);
//                character.cantrips.setSize(2);
//                character.spells.setSize(4);
                character.setProficiencyMod(2);
                proficiency.setText("Proficiency : +" + character.getProficiencyMod());
                character.setHitPoints(8 + character.getConstitutionMod());
                hp.setText("Hit Points: " + character.getHitPoints());

                character.getFeaturesList().add("Spellcasting");
                character.getFeaturesList().add("Bardic Inspiration (d6)");
                changes.setText("Added the following to your character.\nFeatures: Spellcasting and Bardic Inspiration (d6)");
                Label chooseSpells = new Label("You have learned 2 Cantrips and 4 First level spells. Please choose a Cantrip");
                ListView<CheckBox> cantripsList = convertVectorToList(cantripList);
                ListView<CheckBox>  spellsList = convertVectorToList(firstLevelSpells);
                levelOne.getChildren().addAll(changes,chooseSpells,new HBox(new VBox(new Label("Cantrips: 2 "),cantripsList),new VBox(new Label("First Level Spells: 4"),spellsList)),continueButton,error);

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
                                if (startingLevel == maxLevel) {
                                    addLevelStage.close();
                                } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                     }
                     });

                borderPane.setCenter(levelOne);

            }
            if (startingLevel == 2) {
                System.out.println("Level 2");
//                character.spells.setSize(5);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
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
                        if (startingLevel == maxLevel) {
                            addLevelStage.close();
                        } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                    }
                });

                character.getFeaturesList().add("Jack of All Trades");
                character.getFeaturesList().add("Song of Rest (d6)");
            }
            if (startingLevel == 3) {
                System.out.println("Level 3");
//                character.spells.setSize(6);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
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
                                                if (startingLevel == maxLevel) {
                                                    addLevelStage.close();
                                                } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                                            }
                                        }
                                    });

                                }else{
                                    if (!character.getProficienciesList().contains("Medium Armor")){
                                        character.levelProficienciesList.add("Medium Armor");
                                    }if (!character.getProficienciesList().contains("Shields")){
                                        character.levelProficienciesList.add("Shields");
                                    }if (!character.getProficienciesList().contains("Martial Weapons")){
                                        character.levelProficienciesList.add("Martial Weapons");
                                    }
                                    character.getFeaturesList().add("Combat Inspiration");

                                    if (startingLevel == maxLevel) {
                                        addLevelStage.close();
                                    } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                                }

                            }
                });

        }
        if (startingLevel == 4) {
            System.out.println("Level 4");
//            character.spells.setSize(7);
//            character.cantrips.setSize(4);
            character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
            hp.setText("Hit Points: " + character.getHitPoints());
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
                            borderPane.setCenter(abilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                        }

            });
        }

        if (startingLevel == 5) {
            System.out.println("Level 5");
            character.setProficiencyMod(3);
//            character.spells.setSize(8);
            character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
            hp.setText("Hit Points: " + character.getHitPoints());
            proficiency.setText("Proficiency : + " + character.getProficiencyMod());
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
                    if (startingLevel == maxLevel) {
                        addLevelStage.close();
                    } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                }
            });
            pane.getChildren().addAll(levelSpells,thirdLevelSpellsList,continueButton,error);
            character.getFeaturesList().remove("Bardic Inspiration (d6)");
            character.getFeaturesList().add("Bardic Inspiration (d8)");
            character.getFeaturesList() .add("Font of Inspiration");
            System.out.println("Bardic Inspiration (d6) and Font of Inspiration added to features");

            }
            if (startingLevel == 6) {
                System.out.println("Level 6");
//                character.spells.setSize(9);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
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
                                pane.getChildren().add(magicalSecrects(3,2,continueButton));
                                continueButton.setOnAction(continueButtonEvent ->{
                                    if (startingLevel == maxLevel) {
                                        addLevelStage.close();
                                    } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                                });
                            }

                        }
                        if (college.equals("College of Valor")) {
                            character.getFeaturesList().add("Extra Attack");
                            System.out.println("Countercharm and Extra Attack added to features");
                            if (startingLevel == maxLevel) {
                                addLevelStage.close();
                            } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                        }

                    }
                });
            }
            if (startingLevel == 7) {
                System.out.println("Level 7");
//                character.spells.setSize(10);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
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
                        if (startingLevel == maxLevel) {
                            addLevelStage.close();
                        } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                    }
                });
            }

            if (startingLevel == 8) {
                System.out.println("Level 8");
//                character.spells.setSize(11);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
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
                        borderPane.setCenter(abilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                    }
                });

            }
            if (startingLevel == 9) {
                System.out.println("Level 9");
                character.setProficiencyMod(4);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                hp.setText("Hit Points: " + character.getHitPoints());
                proficiency.setText("Proficiency : + " + character.getProficiencyMod());
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
                        if (startingLevel == maxLevel) {
                            addLevelStage.close();
                        } else addLevel(addLevelStage, maxLevel, startingLevel + 1);

                    }
                });
            }
            if (startingLevel == 10) {
                System.out.println("Level 10");
//                character.spells.setSize(14);
//                character.cantrips.setSize(4);
                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
                System.out.println("Your current Hit Points is : " + character.getHitPoints());
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
                        pane.getChildren().add(magicalSecrects(5,2,continueButton));
                        continueButton.setOnAction(continueButtonEvent ->{
                            if (startingLevel == maxLevel) {
                                addLevelStage.close();
                            } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                        });
                    }
                });
            }

            VBox left = new VBox();
            left.setPrefWidth(150);
            left.setPadding(new Insets(10, 10, 10, 10));
            left.getChildren().addAll(hp, proficiency, proficiencies, features);
            borderPane.setLeft(left);
            borderPane.setStyle("-fx-border-color: black;" +
                    "-fx-background-radius: 10;" + "-fx-border-radius: 10;");
            scene.setFill(Color.TRANSPARENT);
        }

//            if (level == 5) {
//                System.out.println("Level 5");
//                character.setProficiencyMod(3);
//                System.out.println("Proficiency : +" + proficiency);
//                character.spells.setSize(8);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                for (int i = 0; i < 2; i++) {
//                    chooseYourSpell(3);
//                }
//
//                features.remove("Bardic Inspiration (d6)");
//                features.add("Bardic Inspiration (d8)");
//                features.add("Font of Inspiration");
//                System.out.println("Bardic Inspiration (d6) and Font of Inspiration added to features");
//
//            }
//            if (level == 6) {
//                System.out.println("Level 6");
//                character.spells.setSize(9);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(3);
//                features.add("Countercharm");
//                if (college.equals("College of Lore")) {
//                    features.add("Additional Magical Secrets");
//                    System.out.println("Countercharm and Additional Magical Secrets added to features");
//                    for (int i = 0; i < 2; i++) {
//                        magicalSecrects(3);
//                    }
//
//                }
//                if (college.equals("College of Valor")) {
//                    features.add("Extra Attack");
//                    System.out.println("Countercharm and Extra Attack added to features");
//                }
//
//            }
//            if (level == 7) {
//                System.out.println("Level 7");
//                character.spells.setSize(10);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(4);
//
//            }
//            if (level == 8) {
//                System.out.println("Level 8");
//                character.spells.setSize(11);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(4);
//
//                abilityScoreImprovement(character);
//
//            }
//            if (level == 9) {
//                System.out.println("Level 9");
//                character.setProficiencyMod(4);
//                System.out.println("Proficiency : +" + proficiency);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                character.spells.setSize(12);
//                features.remove("Song of Rest (d6)");
//                features.add("Song of Rest (d8)");
//                System.out.println("You have added Song of Rest (d8) to your features");
//                chooseYourSpell(4);
//                chooseYourSpell(5);
//
//            }
//            if (level == 10) {
//                System.out.println("Level 10");
//                character.spells.setSize(14);
//                character.cantrips.setSize(4);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                features.remove("Bardic Inspiration (d8)");
//                features.add("Bardic Inspiration (d10)");
//                features.add("Expertise");
//                features.add("Magical Secrets");
//                System.out.println("You have added Bardic Inspiration (d10), Expertise, Magical Secrets to your features");
//                for (int i = 0; i < 2; i++) {
//                    magicalSecrects(5);
//                }
//                System.out.println("You have learned a new Cantrip");
//                vectorPrintOut(cantripList);
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, cantripList.size());
//                System.out.println("You have added " + cantripList.get(choice - 1));
//                character.cantrips.add(cantripList.get(choice - 1));
//                cantripList.remove(choice - 1);
//                chooseYourSpell(5);
//
//
//            }
//            if (level == 11) {
//                System.out.println("Level 11");
//                character.spells.setSize(15);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(6);
//            }
//            if (level == 12) {
//                System.out.println("Level 12");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                abilityScoreImprovement(character);
//
//            }
//            if (level == 13) {
//                System.out.println("Level 13");
//                proficiency++;
//                System.out.println("Proficiency : +" + proficiency);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                features.remove("Song of Rest (d8)");
//                features.add("Song of Rest (d10)");
//                System.out.println("You added Song of Rest (d10) to features");
//                chooseYourSpell(7);
//
//
//            }
//            if (level == 14) {
//                System.out.println("Level 14");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                if (college.equals("College of Lore")) {
//                    features.add("Peerless Skills");
//                    System.out.println("You have added Peerless Skills and Magical Secrets to features");
//                    for (int i = 0; i < 2; i++) {
//                        magicalSecrects(7);
//                    }
//
//                }
//                if (college.equals("College of Valor")) {
//                    features.add("Battle Magic");
//                    System.out.println("You have added Battle Magic and Magical Secrets to features");
//                }
//            }
//
//            if (level == 15) {
//                System.out.println("Level 15");
//                character.setProficiencyMod(5);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                features.remove("Bardic Inspiration (d10)");
//                features.add("Bardic Inspiration (d12)");
//                chooseYourSpell(8);
//
//            }
//            if (level == 16) {
//                System.out.println("Level 16");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                abilityScoreImprovement(character);
//
//
//            }
//            if (level == 17) {
//                System.out.println("Level 17");
//                character.setProficiencyMod(6);
//                System.out.println("Proficiency : +" + proficiency);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                features.remove("Song of Rest (d10");
//                features.add("Song of Rest (d12)");
//
//                chooseYourSpell(9);
//
//            }
//            if (level == 18) {
//                System.out.println("Level 18");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                for (int i = 0; i < 2; i++) {
//                    magicalSecrects(9);
//                }
//                chooseYourSpell(5);
//            }
//            if (level == 19) {
//                System.out.println("Level 19");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                abilityScoreImprovement(character);
//                chooseYourSpell(6);
//
//            }
//            if (level == 20) {
//                System.out.println("Level 20");
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(7);
//                features.add("Superior Inspiration");
//                System.out.println("You have added Superior Inspiration to your features");
//
//            }


    }

    /**
     * Converts a provided vector to a ListView of checkboxes
     * @param vectorToConvert The vector that will be converted to the ListView
     * @return The ListView that contains the vector information
     */
    public ListView<CheckBox> convertVectorToList (Vector vectorToConvert) {
        ObservableList observableList = FXCollections.observableArrayList();
        for (int i=0 ; i < vectorToConvert.size(); i++){
            observableList.add(new CheckBox(vectorToConvert.get(i).toString()));
        }
        ListView listView = new ListView(observableList);
        listView.setMaxWidth(150);
        return listView ;

    }

    /**
     * Converts a provided array to a ListView of checkboxes
     * @param arrayToConvert The array that will be converted to the ListView
     * @return The ListView that contains the Array information
     */
    public ListView<CheckBox>  convertArrayToList (String[] arrayToConvert) {
        ObservableList observableList = FXCollections.observableArrayList();
        for (int i=0 ; i < arrayToConvert.length; i++){
            observableList.add(new CheckBox(arrayToConvert[i]));
        }
        ListView listView = new ListView(observableList);
        listView.setMaxWidth(150);
        return listView ;

    }


    /**
     * @param inventory Vector of items
     * @param item      item you are adding in vector, or adding quantity to already existing item
     */
    public void checkAndAddItemQuantity(Vector<Item> inventory, Item item) {
        int counter = 0;
        int i;
        for (i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(item.getName())) {
                inventory.get(i).addition(item);
                counter++;
                System.out.println("+1 " + inventory.get(i).getName() + " added to inventory | Quantity: " + inventory.get(i).getQuantity());
            }
        }
        if (counter == 0) {
            inventory.add(item);
            System.out.println(item.getName() + " added to inventory | Quantity: " + inventory.get(inventory.size() - 1).getQuantity());
        }

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


    /**
     * Code needed to complete the Magical Secrets Feature. Allows the user to select any level spell
     * @param maxLevel Max Level that the Spells can be
     * @param maxSelection Maximum spells that the user can select from the available CheckBox's
     * @param continueButton Button to link the method back to the method where it was invoked.
     * @return VBox that will contain all of the necessary spells that the user can select from
     */
    public VBox magicalSecrects(int maxLevel, int maxSelection,  Button continueButton){
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

        switch (maxLevel){
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
                if (maxLevel == 1){
                    break;
                }
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
                if (maxLevel == 3){
                    break;
                }
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
                if (maxLevel == 4){
                    break;
                }
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
                if (maxLevel == 5){
                    break;
                }
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
                if (maxLevel == 6){
                    break;
                }
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
                if (maxLevel == 7){
                    break;
                }
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
                if (maxLevel == 8){
                    break;
                }
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
                if (maxLevel == 9){
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
