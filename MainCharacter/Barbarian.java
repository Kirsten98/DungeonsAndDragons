package DungeonsAndDragons.MainCharacter;

import DungeonsAndDragons.MainCharacter.Item;
import DungeonsAndDragons.MainCharacter.CharacterSheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.Vector;


public class Barbarian{
    CharacterSheet character;
    private int hitDice = 12;
    private String primalPath = "Not selected";
    private int rageDamage;
    private int rages;
    private String totemSpirit = "Not selected";
    private Stage addLevelStage;


// TODO move Continue button to the bottom left of the screen in AddLevel
    // TODO Make it to where if a user quits the Add Level process it does not save any progress. Return a Barbarian and if they quite it does not return anything back
    public Barbarian (CharacterSheet character){
        this.character = character;
    }

    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void abilityAddition(CharacterSheet character, String AbilityChoice, int modifierAddtion){
        if (AbilityChoice.equals("Charisma")){
                character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
                System.out.println("Charisma +" + modifierAddtion);
                character.setCharismaMod(findAbilityMod(character.getCharismaScore()));

        }
        if (AbilityChoice.equals("Strength")){
                character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
                System.out.println("Strength +" + modifierAddtion);
                character.setStrengthMod(findAbilityMod(character.getStrengthScore()));

        }
        if (AbilityChoice.equals("Dexterity")){
                character.setDexterityScore(character.getDexterityScore() + modifierAddtion);
                System.out.println("Dexterity +" + modifierAddtion);
                character.setDexterityMod(findAbilityMod(character.getDexterityScore()));

        }
        if (AbilityChoice.equals("Wisdom")){
                character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
                System.out.println("Wisdom +" + modifierAddtion);
                character.setWisdomMod(findAbilityMod(character.getWisdomScore()));
        }
        if (AbilityChoice.equals("Intelligence")){
                character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
                System.out.println("Intelligence +" + modifierAddtion);
                character.setIntelligenceMod(findAbilityMod(character.getIntelligenceScore()));
        }
        if (AbilityChoice.equals("Constitution")){
                character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
                System.out.println("Constitution +" + modifierAddtion);
                character.setConstitutionMod(findAbilityMod(character.getConstitutionScore()));

        }
    }

    /**
     *  Gives the user the  choice to either add +2 to 1 ability score, or add 2 separate ability scores by +1
     * @param addLevelStage Stage that the choice will be displayed on
     * @param maxLevel Maximum level that the user has selected
     * @param startinglevel Level that the user is currently making choices for
     * @return
     */
    public GridPane abilityScoreImprovement(Stage addLevelStage, int maxLevel, int startinglevel){
        //TODO update UI/ Return VBox?
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
        Label question = new Label("Would you like to increase one ability score \nby +2 or two ability scores by +1 ");
        Button plus2 = new Button("One ability score by +2");
        Button plus1 = new Button("Two ability scores by +1");

        pane.add(question,0,0,6,1);
        pane.add(plus2,1,1);
        pane.add(plus1,1,2);
        pane.setVgap(20);
        pane.setHgap(20);

        charisma.setOnAction(charismaEvent->{
            if (character.getCharismaScore() +1 > 20 ||character.getCharismaScore() +2 > 20  ){
                choice.setText("Charisma ability score is greater than 20.\nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Charisma");
                continueButton.setDisable(false);
            }
        });

        strength.setOnAction(strengthEvent->{
            if (character.getStrengthScore()+1 > 20 ||character.getStrengthScore() +2 > 20){
                choice.setText("Strength ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Strength");
                continueButton.setDisable(false);
            }
        });
        dexterity.setOnAction(dexterityEvent->{
            if (character.getDexterityScore()+1 > 20 ||character.getDexterityScore() +2 > 20){
                choice.setText("Dexterity ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Dexterity");
                continueButton.setDisable(false);
            }
        });
        wisdom.setOnAction(wisdomEvent->{
            if (character.getWisdomScore()+1 > 20||character.getWisdomScore() +2 > 20){
                choice.setText("Wisdom ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Wisdom");
                continueButton.setDisable(false);
            }
        });
        intelligence.setOnAction(intelligenceEvent->{
            if (character.getIntelligenceScore()+1 > 20 ||character.getIntelligenceScore() +2 > 20){
                choice.setText("Intelligence ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Intelligence");
                continueButton.setDisable(false);
            }
        });
        constitution.setOnAction(constitutionEvent->{
            if (character.getConstitutionScore()+1 > 20||character.getConstitutionScore() +2 > 20){
                choice.setText("Constitution ability score is greater than 20. \nPlease choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Constitution");
                continueButton.setDisable(false);
            }
        });


        plus2.setOnAction(e->{
            pane.getChildren().remove(plus1);
            pane.getChildren().remove(plus2);
            pane.add(charisma,0,1);
            pane.add(strength,1,1);
            pane.add(dexterity,2,1);
            pane.add(wisdom,0,2);
            pane.add(intelligence,1,2);
            pane.add(constitution,2,2);
            pane.add(choice,1,3,6,1);
            pane.add(continueButton,1,5);
            question.setText("Which Ability score would you like to increase by +2 ?");

            continueButton.setOnAction(continueEvent->{
                abilityAddition(character,choice.getText(),2);
                if (startinglevel == maxLevel){
                    addLevelStage.close();
                }else addLevel(addLevelStage,maxLevel,startinglevel+1);
            });

        });

        plus1.setOnAction(e->{
            String[] intChoice = new String[2];
            pane.getChildren().remove(plus1);
            pane.getChildren().remove(plus2);
            pane.add(charisma,0,1);
            pane.add(strength,1,1);
            pane.add(dexterity,2,1);
            pane.add(wisdom,0,2);
            pane.add(intelligence,1,2);
            pane.add(constitution,2,2);
            pane.add(choice,1,3,6,1);
            pane.add(continueButton,1,4);
            continueButton.setDisable(true);
            question.setText("Choose your first ability to increase by +1.");

            continueButton.setOnAction(continueEvent->{
                intChoice[0] = choice.getText();
                question.setText("Choose your second ability to increase by +1.");
                continueButton.setDisable(true);
                choice.setText("");

                continueButton.setOnAction(continueEvent2 ->{
                    intChoice[1] = choice.getText();
                    for (int i = 0 ; i <2; i++){
                        abilityAddition(character,intChoice[i],1);
                        if (startinglevel == maxLevel){
                            addLevelStage.close();
                        }else addLevel(addLevelStage,maxLevel,startinglevel+1);
                    }
                });
            });

        });
        return pane;
    }

    //TODO Create separate methods for each level
    /**
     * Sets up a HBox with the abilities and their corresponding modifiers.
     * @return HBox of Labels that display the abilities and their corresponding modifiers
     */
    private HBox updateAbilityPane(){
        HBox abilityPane = new HBox(new Label("  Strength " + character.getStrengthScore()), new Label(" | Charisma " + character.getCharismaScore()), new Label(" | Dexterity " + character.getDexterityScore()), new Label(" | Constitution " + character.getConstitutionScore()), new Label(" | Intelligence " + character.getIntelligenceScore()), new Label(" | Wisdom " + character.getWisdomScore()));
        abilityPane.setAlignment(Pos.TOP_CENTER);
        return abilityPane;
    }
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
        Label rages = new Label("Rages: " + this.rages);
        Label rageDamage = new Label("Rage Damage: " + this.rageDamage);
        Label primalPath = new Label("Primal Path: "+ this.primalPath);
        primalPath.setWrapText(true);
        left.getChildren().addAll(hp,proficiency,rages,rageDamage,primalPath,proficiencies,features);
        left.setPrefWidth(150);

        return left;
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
        int possibleHPIncrement = (d12Roll() + character.getConstitutionMod());
        if (possibleHPIncrement >= 1){
            character.setHitPoints(character.getHitPoints()+ possibleHPIncrement);
            System.out.println("HP +" +possibleHPIncrement );
        }else  {
            character.setHitPoints(character.getHitPoints() + 1);
            System.out.println("HP + 1");
        }

    }

    /**
     * Barbarian Level One changes to charactersheet
     * HP += Constitution Modifier + 12
     * Features + Rage / Unarmored defense
     * Rages = 2
     * Rage Damage = 2
     * User selects two race traits to be proficient in
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelOne(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        //TODO why doesn't level 1 display proper HP
        character.setHitPoints(character.getHitPoints()+ character.getConstitutionMod()+12);
        System.out.println(character.getHitPoints());
        character.setProficiencyMod(2);
        borderPaneSetUp(borderPane, pane);

        character.getFeaturesList().add("Rage");
        character.getFeaturesList().add("Unarmored Defense");

        this.rages = 2;
        this.rageDamage = 2;

        continueButton.setDisable(true);

        character.levelProficienciesList.addAll("Strength","Constitution","Light Armor","Medium Armor","Shields","Simple Weapons","Martial Weapons");
        Label skillChoices = new Label("You have learned two new race traits to be proficient in.\nChoose your fist skill.\n ");

        ObservableList skills = FXCollections.observableArrayList("Animal Handling","Athletics","Intimidation", "Nature","Perception","Survival");

        Label firstSkill = new Label("First skill choice: ");
        ChoiceBox firstChoice = new ChoiceBox(skills);
        HBox firstSkillChoice = new HBox(30);
        firstSkillChoice.getChildren().addAll(firstSkill, firstChoice);
        firstSkillChoice.setAlignment(Pos.BASELINE_LEFT);
        firstSkillChoice.setPrefWidth(300);
        firstChoice.setPrefWidth(150);

        Label secondSkill = new Label("Second skill choice: ");
        ChoiceBox secondChoice = new ChoiceBox(skills);
        HBox secondSkillChoice = new HBox(15);
        secondSkillChoice.getChildren().addAll(secondSkill, secondChoice);
        secondSkillChoice.setPrefWidth(300);
        secondSkillChoice.setAlignment(Pos.BASELINE_LEFT);
        secondChoice.setPrefWidth(150);
        secondChoice.setDisable(true);

        firstChoice.setOnAction(e-> {
            continueButton.setDisable(false);
            continueButton.setOnAction(continueEvent ->{
                character.levelProficienciesList.add(firstChoice.getValue());
                skills.remove(firstChoice.getValue());
                firstSkill.setText("First skill choice: " + firstChoice.getValue());
                firstSkillChoice.getChildren().remove(firstChoice);
                secondChoice.setDisable(false);
                continueButton.setDisable(true);
            } );
        });

        secondChoice.setOnAction(e ->{
            continueButton.setDisable(false);
            continueButton.setOnAction(continueEvent -> {
                character.levelProficienciesList.add(secondChoice.getValue());
                secondSkillChoice.getChildren().remove(secondChoice);
                secondSkill.setText("Second skill choice: " + secondChoice.getValue());
                secondChoice.setDisable(true);
                if (maxLevel == 1){
                    addLevel(addLevelStage,1,1);
                    addLevelStage.close();
                }else  levelTwo(borderPane,continueButton,maxLevel);

            });
        });
        pane.getChildren().addAll(skillChoices,firstSkillChoice,secondSkillChoice,continueButton);
        pane.setAlignment(Pos.TOP_CENTER);

    }

    /** Barbarian Level two changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Reckless Attack/ Danger Sense
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTwo(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        character.getFeaturesList().add("Reckless Attack");
        character.getFeaturesList().add("Danger Sense");
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        Label changes = new Label("The following has been added to your character.\nFeatures: Reckless Attack and Danger Sense.\n");
        pane.getChildren().addAll(changes,continueButton);
        continueButton.setOnAction(continueButtonEvent -> {
            if (maxLevel == 2){
                addLevel(addLevelStage,2,2);
                addLevelStage.close();
            }else  levelThree(borderPane,continueButton,maxLevel);
        });
    }

    /** Barbarian Level three changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Rages = 3
     * User selects Primal Path, either Berserker or Totem Warrior (Bear, Eagle, or Wolf)
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelThree(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));

        this.rages = 3;
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        Label choosePath = new Label("Choose your Primal Path");
        Label choice = new Label("Primal Path: " + this.primalPath);

        continueButton.setDisable(true);

        Button berserker = new Button("Berserker");
        berserker.setTooltip(new Tooltip("Path of Berserker\nFeatures: Frenzy"));
        berserker.setPrefWidth(100);
        berserker.setOnAction(e-> {
            this.primalPath=berserker.getText();
            choice.setText("Primal Path: " + this.primalPath);
            continueButton.setDisable(false);
        });

        Button totemWarrior = new Button("Totem Warrior");
        totemWarrior.setPrefWidth(100);
        berserker.setTooltip(new Tooltip("Path of Totem Warrior\nFeatures: Spirit Speaker\nTotem Spirit choice"));
        totemWarrior.setOnAction(e-> {
            this.primalPath=totemWarrior.getText();
            choice.setText("Primal Path: " + this.primalPath);
            continueButton.setDisable(false);
        });

        HBox pathChoices = new HBox(30);
        pathChoices.getChildren().addAll(berserker,totemWarrior);
        pathChoices.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(choosePath,choice,pathChoices,continueButton);
        pane.setAlignment(Pos.TOP_CENTER);

        continueButton.setOnAction(e->{
            if (this.primalPath.equals("Berserker")){
                character.getFeaturesList().add("Frenzy");
                if ( maxLevel ==3){
                    addLevel(addLevelStage,3,3);
                    addLevelStage.close();
                } else levelFour(borderPane,continueButton,maxLevel);
            }else {
                pane.getChildren().clear();

                choosePath.setText("Choose your Totem Spirit");
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(true);


                Button bear = new Button("Bear");
                bear.setTooltip(new Tooltip("While raging, you have resistance to all damage \nexcept psychic damage. The spirit of the bear makes \nyou tough enough to stand up to any punishment"));
                bear.getTooltip().setWrapText(true);

                Button eagle = new Button("Eagle");
                eagle.setTooltip(new Tooltip("While you are raging and aren't wearing heavy armor, other creatures \nhave disadvantage on opportunity attack rolls against you, \nand you can use the Dash action as a bonus action on your turn. \nThe spirit of the eagle makes you into a predator who can weave \nthrough the fray with ease."));
                eagle.getTooltip().setWrapText(true);

                Button wolf = new Button("Wolf");
                wolf.setTooltip(new Tooltip("While you are raging, your friends have advantage on melee attack \nrolls against any creature within 5 feet of you that is hostile to you. \nThe spirit of the wolf makes you a leader of hunters."));
                wolf.getTooltip().setWrapText(true);

                HBox primalPathChoices = new HBox(20);
                primalPathChoices.getChildren().addAll(bear,eagle,wolf);
                primalPathChoices.setAlignment(Pos.TOP_CENTER);

                pane.getChildren().addAll(choosePath,choice,primalPathChoices,new Label(),continueButton);

                bear.setOnAction(bearEvent->{
                    this.totemSpirit = "Bear";
                    choice.setText("Totem Spirit: " + this.totemSpirit);
                    continueButton.setDisable(false);
                });

                eagle.setOnAction(eagleEvent->{
                    this.totemSpirit = "Eagle";
                    choice.setText("Totem Spirit: " + this.totemSpirit);
                    continueButton.setDisable(false);
                });

                wolf.setOnAction(wolfEvent->{
                    this.totemSpirit = "Wolf";
                    choice.setText("Totem Spirit: " + this.totemSpirit);
                    continueButton.setDisable(false);
                });

                continueButton.setOnAction(continueButtonEvent -> {
                    character.getFeaturesList().add("Spirit Speaker: " + this.totemSpirit);
                    if ( maxLevel ==3){
                        addLevel(addLevelStage,3,3);
                        addLevelStage.close();
                    } else levelFour(borderPane,continueButton,maxLevel);
                });
            }
        });
    }

    /** Barbarian Level four changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * User is presented the option to either update one ability modifier by two points, or two ability modifiers by one point.
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFour(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        GridPane abilityPane = abilityScoreImprovement(addLevelStage,maxLevel,4);
        abilityPane.setAlignment(Pos.TOP_CENTER);
        abilityPane.setPadding(new Insets(50,20,50,20));
        borderPane.setCenter(abilityPane);

    }

    /** Barbarian Level five changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Proficiency modifier = 3
     * Features + Extra attack/ Fast Movement
     * Speed += 10
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFive(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));

        character.setProficiencyMod(3);
        character.getFeaturesList().addAll("Extra Attack","Fast Movement");
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        character.setSpeed(character.getSpeed() + 10);
        continueButton.setOnAction(continueButtonEvent ->{
            if ( maxLevel ==4){
                addLevel(addLevelStage,4,4);
                addLevelStage.close();
            } else levelSix(borderPane,continueButton,maxLevel);
        });

        pane.getChildren().addAll(new Label("Features added: Extra Attack and Fast Movement\nProficiency bonus +1\nSpeed +10"),continueButton);
    }

    /** Barbarian Level six changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Rages = 4
     * If primal path equals Berserker, then Features + Mindless Rage, else user will select a totem spirit (bear, eagle, wolf)
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSix (BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));

        this.rages = 4;
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        pane.setAlignment(Pos.TOP_CENTER);

        if (this.primalPath.equals("Berserker")){
            character.getFeaturesList().add("Mindless Rage");
            pane.getChildren().addAll(new Label("Features added: Mindless Rage\nRages +1"),continueButton);
            continueButton.setOnAction(continueButtonEvent -> {
                if (maxLevel == 6){
                    addLevel(addLevelStage,6,6);
                    addLevelStage.close();
                }else levelSeven(borderPane,continueButton,maxLevel);
            });

        }else {
            continueButton.setDisable(true);
            Label choosePath = new Label("Choose your Totem Spirit");;
            Label choice = new Label("Totem Spirit: Not Selected");

            Button bear = new Button("Bear");
            bear.setTooltip(new Tooltip("You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) is doubled, \nand you have advantage on Strength checks made to push, pull, lift, or break objects."));
            bear.getTooltip().setWrapText(true);

            Button eagle = new Button("Eagle");
            eagle.setTooltip(new Tooltip("You gain eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern even fine details as though \nlooking at something no more than 100 feet away from you. Additionally, dim light doesn't \nimpose disadvantage on your Wisdom (Perception) checks"));
            eagle.getTooltip().setWrapText(true);


            Button wolf = new Button("Wolf");
            wolf.setTooltip(new Tooltip("You gain the hunting sensibilities of a wolf. You can track other creatures while travelling at a fast pace, \nand you can move stealthily while travelling at a normal pace."));
            wolf.getTooltip().setWrapText(true);

            HBox primalPathChoices = new HBox(20);
            primalPathChoices.getChildren().addAll(bear, eagle,wolf);
            primalPathChoices.setAlignment(Pos.TOP_CENTER);

            pane.getChildren().addAll(choosePath, choice,primalPathChoices, continueButton );

            bear.setOnAction(bearEvent->{
                this.totemSpirit = "Bear";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            eagle.setOnAction(eagleEvent->{
                this.totemSpirit = "Eagle";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            wolf.setOnAction(wolfEvent->{
                this.totemSpirit = "Wolf";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            continueButton.setOnAction(continueButtonEvent -> {
                character.getFeaturesList().add("Aspect of the Beast: " + this.totemSpirit);

                if (maxLevel == 6){
                    addLevel(addLevelStage,6,6);
                    addLevelStage.close();
                }else levelSeven(borderPane,continueButton,maxLevel);

            });
        }
    }

    /** Barbarian Level seven changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Feral Instincts
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelSeven(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        pane.setAlignment(Pos.TOP_CENTER);

        character.getFeaturesList().add("Feral Instinct");

        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        Label changes = new Label("Features Added: Feral Instinct");

        continueButton.setOnAction(continueButtonEvent -> {
            if (maxLevel == 7){
                addLevel(addLevelStage,7,7);
                addLevelStage.close();
            }else levelEight(borderPane,continueButton,maxLevel);

        });
        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level eight changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * User is presented the option to either update one ability modifier by two points, or two ability modifiers by one point
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelEight(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        updateCharacterHP();
        GridPane abilityPane = abilityScoreImprovement(addLevelStage,maxLevel,8);
        pane.getChildren().add(abilityPane);
        borderPaneSetUp(borderPane,pane);
        abilityPane.setPadding(new Insets(50,20,50,20));
        abilityPane.setAlignment(Pos.TOP_CENTER);
        borderPane.setCenter(abilityPane);
    }

    /** Barbarian Level nine changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Proficiency modifier = 4
     * Rage damage = 3
     * Features + Brutal Critical (1 Die)
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelNine(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        pane.setAlignment(Pos.TOP_CENTER);
        character.setProficiencyMod(4);
        character.getFeaturesList().add("Brutal Critical (1 Die)");

        this.rageDamage = 3;
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        Label changes = new Label("Features Added: Brutal Critical (1 Die)\nProficiency +1\nRage Damage +1");

        continueButton.setOnAction(continueButtonEvent -> {
            if (maxLevel == 9){
                addLevel(addLevelStage,9,9);
                addLevelStage.close();
            }else levelTen(borderPane,continueButton,maxLevel);

        });
        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level ten changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Intimidating Presence OR Spirit Walker (based on Primal Path)
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        pane.setAlignment(Pos.TOP_CENTER);
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        Label changes = new Label("");

        if (this.primalPath.equals("Berserker")){
            character.getFeaturesList().add("Intimidating Presence");
            changes.setText("Features added: Intimidating Presence");
        }else {
            character.getFeaturesList().add("Spirit Walker");
            changes.setText("Features added: Spirit Walker");
        }

        continueButton.setOnAction(continueButtonEvent -> {
            if (maxLevel == 10){
                addLevel(addLevelStage,10,10);
                addLevelStage.close();
            }else levelEleven(borderPane,continueButton,maxLevel);
        });

        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level eleven changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Relentless Rage
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelEleven(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        pane.setAlignment(Pos.TOP_CENTER);

        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        Label changes = new Label("Features Added: Relentless Rage");
        character.getFeaturesList().add("Relentless Rage");

        continueButton.setOnAction(continueButtonEvent ->{
            if (maxLevel == 11){
                addLevel(addLevelStage,11,11);
                addLevelStage.close();
            }else levelTwelve(borderPane,continueButton,maxLevel);
        });

        pane.getChildren().addAll(changes, continueButton);
}

    /** Barbarian Level twelve changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Rages = 5
     * User is presented the option to either update one ability modifier by two points, or two ability modifiers by one point
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelTwelve(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        this.rages = 5;
        GridPane center = abilityScoreImprovement(addLevelStage,maxLevel,12);
        center.setAlignment(Pos.TOP_CENTER);
        center.setPadding(new Insets(50,20,50,20));
        borderPane.setCenter(center);
    }

    /** Barbarian Level thirteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Proficiency Modifier = 5
     * Features - "Brutal Critical (1 Die)"
     * Features + "Brutal Critical (2 Die)"
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelThirteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,20,50,20));

        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        character.setProficiencyMod(5);
        character.getFeaturesList().remove("Brutal Critical (1 Die)");
        character.getFeaturesList().add("Brutal Critical (2 Dice)");
        Label changes = new Label ("Features Added: Updated Brutal Critical (1 Die) to Brutal Critical (2 Dice)\nProficiency +1");

        continueButton.setOnAction(continueButtonEvent ->{
            if (maxLevel == 13){
                addLevel(addLevelStage,13,13);
                addLevelStage.close();
            }else levelFourteen(borderPane,continueButton,maxLevel);
        });

        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level fourteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Feature + Retaliation (If primal path is Berserker) OR Totem Attunement (If Primal path is other)
     * User chooses Totem Spirit if they are not a Berserker
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    private void levelFourteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setPadding(new Insets(50,20,50,20));
        pane.setAlignment(Pos.TOP_CENTER);

        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        Label changes = new Label();
        if (this.primalPath.equals("Berserker")){
            character.getFeaturesList().add("Retaliation");
            changes.setText("Features added: Retaliation");
            continueButton.setOnAction(continueButtonEvent -> {
                if (maxLevel == 14){
                    addLevel(addLevelStage,14,14);
                    addLevelStage.close();
                }else levelFifteen(borderPane,continueButton,maxLevel);
            });
            pane.getChildren().addAll(changes, continueButton);
        }else {
            continueButton.setDisable(true);
            pane.setAlignment(Pos.TOP_CENTER);
            Label choosePath = new Label("Choose your Totem Spirit");;
            Label choice = new Label("Totem Spirit: Not Selected");

            HBox primalPathChoices = new HBox(20);

            Button bear = new Button("Bear");
            bear.setTooltip(new Tooltip("While you're raging, any creature within 5 feet of you that's hostile to you has a disadvantage on attack rolls against targets other than you or another character with this feature. An enemy is immune to this effect if it can't see or hear you or if it can't be frightened."));
            bear.getTooltip().setWrapText(true);
            bear.getTooltip().setWidth(75);

            Button eagle = new Button("Eagle");
            eagle.setTooltip(new Tooltip("While raging, you have a flying speed equal to your current walking speed. This benefit works only in short bursts; you fall if you end your turn in the air and nothing else is holding you aloft."));
            eagle.getTooltip().setWrapText(true);
            eagle.getTooltip().setWidth(75);

            Button wolf = new Button("Wolf");
            wolf.setTooltip(new Tooltip("While you're raging, you can use a bonus action on your turn to knock a large or smaller creature prone when you hit it with melee weapon attack."));
            wolf.getTooltip().setWrapText(true);
            wolf.getTooltip().setWidth(75);

            primalPathChoices.getChildren().addAll(bear,eagle,wolf);
            primalPathChoices.setAlignment(Pos.TOP_CENTER);
            pane.getChildren().addAll(choosePath, choice,primalPathChoices,continueButton);

            bear.setOnAction(bearEvent->{
                this.totemSpirit = "Bear";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            eagle.setOnAction(eagleEvent->{
                this.totemSpirit = "Eagle";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            wolf.setOnAction(wolfEvent->{
                this.totemSpirit = "Wolf";
                choice.setText("Totem Spirit: " + this.totemSpirit);
                continueButton.setDisable(false);
            });

            continueButton.setOnAction(continueButtonEvent -> {
                character.getFeaturesList().add("Totemic Attunement");
                if (maxLevel == 14){
                    addLevel(addLevelStage,14,14);
                    addLevelStage.close();
                }else levelFifteen(borderPane,continueButton,maxLevel);

            });
        }
    }

    /** Barbarian Level fifteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Persistent Rage
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelFifteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,20,50,20));
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        Label changes = new Label("Features Added: Persistent Rage");
        character.getFeaturesList().add("Persistent Rage");

        continueButton.setOnAction(continueButtonEvent ->{
            if (maxLevel == 15){
                addLevel(addLevelStage,15,15);
                addLevelStage.close();
            }else levelSixteen(borderPane,continueButton,maxLevel);
        });
        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level sixteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Rages = 4
     *  User is presented the option to either update one ability modifier by two points, or two ability modifiers by one point
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelSixteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        this.rageDamage = 4;

        GridPane center = abilityScoreImprovement(addLevelStage,maxLevel,16);
        center.setAlignment(Pos.TOP_CENTER);
        center.setPadding(new Insets(50,20,50,20));

        borderPane.setCenter(center);


    }

    /** Barbarian Level seventeen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features - Brutal Critical (2 Dice)
     * Features + Brutal Critical (3 Dice)
     * Proficiency Modifier = 6
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelSeventeen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,20,50,20));
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        character.setProficiencyMod(6);
        character.getFeaturesList().remove("Brutal Critical (2 Dice)");
        character.getFeaturesList().add("Brutal Critical  (3 Dice)");
        this.rages = 6;
        Label changes = new Label("Features Added: Updated Brutal Critical (2 Dice) to Brutal Critical (3 Dice)\nRages +1\nProficiency +1");

        continueButton.setOnAction(continueButtonEvent ->{
            if (maxLevel == 17){
                addLevel(addLevelStage,17,17);
                addLevelStage.close();
            }else levelEighteen(borderPane,continueButton,maxLevel);
        });
        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level eighteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Features + Indomitable Might
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelEighteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,20,50,20));
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        character.getFeaturesList().add("Indomitable Might");
        Label changes = new Label("Features Added: Indomitable Might");

        continueButton.setOnAction(continueButtonEvent ->{
            if (maxLevel == 18){
                addLevel(addLevelStage,18,18);
                addLevelStage.close();
            }else levelNineteen(borderPane,continueButton,maxLevel);
        });

        pane.getChildren().addAll(changes,continueButton);
    }

    /** Barbarian Level Nineteen changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * User is presented the option to either update one ability modifier by two points, or two ability modifiers by one point
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelNineteen(BorderPane borderPane, Button continueButton,int maxLevel){
        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);

        GridPane center = abilityScoreImprovement(addLevelStage,maxLevel,19);
        center.setAlignment(Pos.TOP_CENTER);
        center.setPadding(new Insets(50,20,50,20));

        borderPane.setCenter(center);

    }

    /** Barbarian Level twenty changes to charactersheet
     * HP += Random number between 1 and 12 + Constitution Modifier
     * Rages = Unlimited
     * Strength Score +4
     * Constitution +4
     * Features + Primal Champion
     *
     * @param borderPane  Borderpane that will be used across all levels to organize the ability modifieres (top). HP,  proficiency Mod, features, and level proficiencies (Left), and user choices that will be displayed in the center
     * @param continueButton Button to navigate the user between their choices and the next level
     * @param maxLevel The maximum level that the user has selected
     */
    public void levelTwenty(BorderPane borderPane, Button continueButton,int maxLevel){
        continueButton.setText("Close");
        abilityAddition(character,"Strength",4);
        abilityAddition(character,"Constitution",4);

        VBox pane = new VBox(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(50,20,50,20));
        updateCharacterHP();
        borderPaneSetUp(borderPane,pane);
        character.getFeaturesList().add("Primal Champion");
        this.rages = 999999999;
        Label changes = new Label("Features Added: Primal Champion \nRages are now unlimited");
        continueButton.setOnAction(e-> {
            addLevel(addLevelStage,20,20);
            addLevelStage.close();
        });
        pane.getChildren().addAll(changes,continueButton);
    }
    /**
     * Takes current level and continuously adds additional level until maximum level is hit. Throughout the process it will give the users options for selection for their current level
     * @param addLevelStage Stage that will contain all Level choices
     * @param maxLevel Max level that the user has chosen
     * @param startingLevel Level that the user if currently at
     */
    public void addLevel(Stage addLevelStage, int maxLevel, int startingLevel){

            if (startingLevel <= maxLevel){
                Label hp = new Label("Hit Points: "+ character.getHitPoints());
                Label proficiency = new Label("Proficiency : + "+ character.getProficiencyMod());
                ListView features = new ListView(character.getFeaturesList());
                ListView proficiencies = new ListView( character.levelProficienciesList);
                proficiencies.setTooltip(new Tooltip("Proficiencies"));
                features.setTooltip(new Tooltip("Features"));

                //TODO Remove after completing individual methods for each level
                Label rages = new Label("Rages: " + this.rages);
                Label rageDamage = new Label("Rage Damage: " + this.rageDamage);
                Label primalPath = new Label("Primal Path: "+ this.primalPath);
                primalPath.setWrapText(true);

                BorderPane borderPane = new BorderPane();
                borderPane.setTop(new Label("Current level " + startingLevel + " out of " + maxLevel ));
                VBox pane = new VBox(20);
                InnerShadow shadow = new InnerShadow();
                shadow.setColor(Color.gray(.5));
                pane.setEffect(shadow);
                pane.setPadding(new Insets(10,30,10,30));
                borderPane.setCenter(pane);
                Scene scene = new Scene(borderPane,600,600);
                this.addLevelStage = addLevelStage;
                addLevelStage.setScene(scene);
                Label changes = new Label();
                Button continueButton = new Button("Continue");

                addLevelStage.setTitle("Level " + startingLevel);
                ObservableList misc = FXCollections.observableArrayList();

                switch (startingLevel){
                    case 1: levelOne(borderPane,continueButton,maxLevel);
                        break;
                    case 2: levelTwo(borderPane,continueButton,maxLevel);
                        break;
                    case 3: levelThree(borderPane,continueButton,maxLevel);
                        break;
                    case 4: levelFour(borderPane,continueButton,maxLevel);
                        break;
                    case 5: levelFive(borderPane,continueButton,maxLevel);
                        break;
                    case 6: levelSix(borderPane,continueButton,maxLevel);
                        break;
                    case 7: levelSeven(borderPane,continueButton,maxLevel);
                        break;
                    case 8: levelEight(borderPane,continueButton,maxLevel);
                        break;
                    case 9: levelNine(borderPane,continueButton,maxLevel);
                        break;
                    case 10: levelTen(borderPane,continueButton,maxLevel);
                        break;
                    case 11: levelEleven(borderPane,continueButton,maxLevel);
                        break;
                    case 12: levelTwelve(borderPane,continueButton,maxLevel);
                        break;
                    case 13: levelThirteen(borderPane,continueButton,maxLevel);
                        break;
                    case 14: levelFourteen(borderPane,continueButton,maxLevel);
                        break;
                    case 15: levelFifteen(borderPane,continueButton,maxLevel);
                        break;
                    case 16: levelSixteen(borderPane,continueButton,maxLevel);
                        break;
                    case 17: levelSeventeen(borderPane,continueButton,maxLevel);
                        break;
                    case 18: levelEighteen(borderPane,continueButton,maxLevel);
                        break;
                    case 19: levelNineteen(borderPane,continueButton,maxLevel);
                        break;
                    case 20: levelTwenty(borderPane,continueButton,maxLevel);

                }

                if (startingLevel == maxLevel){
                    character.setLevel(maxLevel);
                    misc.addAll(new Label("Hit Dice: " + hitDice),proficiency,rages,rageDamage,primalPath);
                     character.setMisc(misc);

                }

                VBox left = new VBox();
                left.setPrefWidth(150);
                left.setPadding(new Insets(10,10,10,10));
                left.getChildren().addAll(hp,proficiency,rages,rageDamage,primalPath,proficiencies,features);
                borderPane.setLeft(left);
                borderPane.setStyle("-fx-border-color: black;"        +
                        "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
                scene.setFill(Color.TRANSPARENT);
            }

    }

    /**
     *
     * @param inventory Vector of items
     * @param item item you are adding in vector, or adding quantity to already existing item
     */
    public void checkAndAddItemQuantity(Vector<Item> inventory, Item item){
        int counter =0;
        int i;
        for ( i =0; i< inventory.size();i++){
            if (inventory.get(i).getName().equals(item.getName())){
                inventory.get(i).addition(item);
                counter++;
                System.out.println("+1 " + inventory.get(i).getName() + " added to inventory | Quantity: " + inventory.get(i).getQuantity());
            }
        }
        if (counter == 0){
            inventory.add(item);
            System.out.println(item.getName() + " added to inventory | Quantity: " + inventory.get(inventory.size()-1).getQuantity());
        }

    }

    // Tested and verified 9/3
    /**
     * Randomly Generates a number between 1 and 12. Simulating a D12
     * @return Random number between 1 and 12
     */
    public int d12Roll(){
        double randomDouble = Math.random()*12 +1;
        Double randomDouble2 = randomDouble;
        int roll = randomDouble2.intValue();
        return roll;
    }


    /**
     *
     * @param abilityScore Takes in the Ability Score
     * @return Returns the MOdifier based on the Ability Score
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


    public void chooseArmor(Stage chooseArmorStage){
        VBox pane = new VBox(10);
        Scene scene = new Scene(pane,450,280);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseArmorStage.setScene(scene);

        pane.setPadding(new Insets(30,30,20,30));

        Button continueButton = new Button("Continue");
        continueButton.setPrefWidth(100);
        continueButton.setTranslateX(150);

        Label armorLabel = new Label("You are proficient in Light Armor, Medium Armor, and Shields.\nChoose your Armor.");
        Label proficiencyWarning = new Label("Note: If you wear armor that you lack proficiency with, you have disadvantage on any ability checks, saving throws, or attack rolls that involves Strength or Dexterity, and you can’t cast spells.");
        proficiencyWarning.setWrapText(true);
        ObservableList proficientArmor = FXCollections.observableArrayList(character.getLightArmor()[0],character.getLightArmor()[1],character.getLightArmor()[2],character.getMediumArmor()[0],character.getMediumArmor()[1],character.getMediumArmor()[2],character.getMediumArmor()[3],character.getMediumArmor()[4]);
        ObservableList notProficientArmor =  FXCollections.observableArrayList(character.getHeavyArmor()[0],character.getHeavyArmor()[1],character.getHeavyArmor()[2],character.getHeavyArmor()[3]);

        ComboBox<String> proficientArmorChoices = new ComboBox(proficientArmor);
        proficientArmorChoices.setValue("Proficient ");
        ComboBox<String> nonProficientArmorChoices = new ComboBox<>(notProficientArmor);
        nonProficientArmorChoices.setValue("Non-Proficient");

        character.nonProficientArmor = character.getHeavyArmor();
        ChoiceBox<String> yOrN = new ChoiceBox(FXCollections.observableArrayList("Yes","No"));
        yOrN.setDisable(true);

        Label armor = new Label("Armor: ");
        Label shield = new Label("Shield: ");

        proficientArmorChoices.setOnAction(proficientArmorError-> {
            character.setArmor(proficientArmorChoices.getValue());
            armor.setText("Armor: " + proficientArmorChoices.getValue());
            proficientArmorChoices.setDisable(true);
            proficientArmorChoices.hide();
            yOrN.setDisable(false);
            nonProficientArmorChoices.setDisable(true);


            continueButton.setOnAction(e->{
                //finds index of Armor and Adds Armor as an item
                for (int i=0 ;i < character.getAllArmor().length; i++){
                    if (character.getAllArmor()[i].equals(proficientArmorChoices.getValue())){
                        checkAndAddItemQuantity(character.armorList,new Item(proficientArmorChoices.getValue() ,character.getAllArmorDescriptions()[i],1,character.getAllArmorCost()[i]) );
                        character.setAc(character.getAc()+character.getAllArmorAC()[i]);
                        break;
                    }
                }

                if (character.isShield() == true){
                    checkAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
                    character.setAc(character.getAc() +2);
                }
                chooseWeapon(chooseArmorStage);
            });

        });

        nonProficientArmorChoices.setOnAction(nonProficientArmor ->{
            character.setArmor(nonProficientArmorChoices.getValue());
            armor.setText("Armor: " + nonProficientArmorChoices.getValue());
            proficientArmorChoices.setDisable(true);
            proficientArmorChoices.hide();
            yOrN.setDisable(false);
            nonProficientArmorChoices.setDisable(true);

            continueButton.setOnAction(e->{

                //finds index of Armor and Adds Armor as an item
                for (int i=0 ;i < character.getAllArmor().length; i++){
                    if (character.getAllArmor()[i].equals(nonProficientArmorChoices.getValue())){
                        checkAndAddItemQuantity(character.armorList,new Item(nonProficientArmorChoices.getValue() ,character.getAllArmorDescriptions()[i],1,character.getAllArmorCost()[i]) );
                        character.setAc(character.getAc()+character.getAllArmorAC()[i]);
                        break;
                    }
                }

                if (character.isShield() == true){
                    checkAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
                    character.setAc(character.getAc() +2);
                }
                chooseWeapon(chooseArmorStage);
            });

        });

        armor.setMinWidth(150);
        proficientArmorChoices.setPrefWidth(100);
        nonProficientArmorChoices.setPrefWidth(125);
        nonProficientArmorChoices.setTranslateX(25);

        yOrN.setOnAction(e-> {
            if (yOrN.getValue().equals("Yes")){
                shield.setText("Shield: Yes");
                character.setShield(true);
            }else {
                shield.setText("Shield: No ");
                character.setShield(false);
            }
            yOrN.setDisable(true);
            yOrN.setTranslateX(93);
            pane.getChildren().add(continueButton);
        });


        pane.getChildren().addAll(armorLabel,new HBox(armor,proficientArmorChoices,nonProficientArmorChoices), new HBox(shield,yOrN),proficiencyWarning);

        yOrN.setTranslateX(112);
        pane.setStyle("-fx-border-color: black;"        +
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
    }


    public void chooseWeapon(Stage chooseWeaponStage){

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(pane,475,250);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseWeaponStage.setScene(scene);

        pane.setPadding(new Insets(30,30,30,30));

        Button continueButton = new Button("Continue");

        Label weaponLabel = new Label("Choose between the options below.");

        ObservableList simpleMartialMeleeWeapons = FXCollections.observableArrayList();
        for (int i =0 ; i<character.getSimpleMeleeWeapons().length; i++){
            simpleMartialMeleeWeapons.add(character.getSimpleMeleeWeapons()[i]);
        }

        Label firstWeapon = new Label("Greataxe or any Martial Melee Weapon.");
        ChoiceBox greataxeOrMMW = new ChoiceBox(FXCollections.observableArrayList(character.getMartialMeleeWeapons()[0],character.getMartialMeleeWeapons()[1],character.getMartialMeleeWeapons()[2],character.getMartialMeleeWeapons()[3],character.getMartialMeleeWeapons()[4]));

        Label secondWeapon = new Label("Two handaxes or any Simple Martial Weapon.");
        ChoiceBox handaxeOrSMW = new ChoiceBox(FXCollections.observableArrayList(simpleMartialMeleeWeapons));

        handaxeOrSMW.setDisable(true);

        greataxeOrMMW.setOnAction(e-> {handaxeOrSMW.setDisable(false);
        greataxeOrMMW.setDisable(true);});

        handaxeOrSMW.setOnAction(e-> {pane.getChildren().add(continueButton);
        handaxeOrSMW.setDisable(true);});

        continueButton.setOnAction(e -> {
            chooseWeaponStage.close();

            for (int i = 0 ; i< character.getMartialMeleeWeapons().length ; i++){
                if (character.getMartialMeleeWeapons()[i].equals(greataxeOrMMW.getValue())){
                    checkAndAddItemQuantity(character.weapons, new Item(character.getMartialMeleeWeapons()[i],character.getMartialMeleeWeaponsProperties()[i],1,character.getMartialMeleeWeaponCost()[i]));
                    break;
                }
            }

            if (handaxeOrSMW.getValue().equals("Handaxe")){
                checkAndAddItemQuantity(character.weapons,new Item(character.getSimpleMeleeWeapons()[3],character.getSimpleMeleeWeaponProperties()[3],2,character.getSimpleMeleeWeaponsCost()[3]));
            } else {
                for (int i =0 ; i<character.getSimpleMeleeWeapons().length ; i++){
                    if (character.getSimpleMeleeWeapons()[i].equals(handaxeOrSMW.getValue().toString())){
                        checkAndAddItemQuantity(character.weapons,new Item(character.getSimpleMeleeWeapons()[i],character.getSimpleMeleeWeaponProperties()[i],1,character.getSimpleMeleeWeaponsCost()[i]));
                    }
                }
            }
        });

        Label pack = new Label("Barbarian default pack : Explorer's Pack\nBackpack | Bedroll | Mess Kit | Tinderbox\nTorch x10 | Rations x10 | Waterskin | Hempen Rope x50 ft. | Javelin x4");

        pane.getChildren().addAll(weaponLabel,new HBox(42,firstWeapon,greataxeOrMMW), new HBox(10,secondWeapon,handaxeOrSMW),pack);

        checkAndAddItemQuantity(character.inventory,new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
        checkAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
        checkAndAddItemQuantity(character.inventory, new Item("Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2));
        checkAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
        checkAndAddItemQuantity(character.inventory,new Item("Torch","A torch burns for 1 hour providing bright light in a 20 foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.",10,1));
        checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5));
        checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
        checkAndAddItemQuantity(character.inventory, new Item("Hempen Rope","Quantity is in feet",50,0));
        checkAndAddItemQuantity(character.weapons, new Item("Javelin","",4,0));

        pane.setStyle("-fx-border-color: black;"        +
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);


    }
}
