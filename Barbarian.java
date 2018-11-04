package DungeonsAndDragons;

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
    private int proficiency;
    private int rageDamage;
    private int rages;
    private String totemSpirit = "Not selected";



    public Barbarian (CharacterSheet character){
        this.character = character;
    }

    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void AbilityAddition(CharacterSheet character, String AbilityChoice, int modifierAddtion){
        if (AbilityChoice.equals("Charisma")){
                character.setCharismaScore(character.getCharismaScore() + modifierAddtion);
                System.out.println("Charisma +" + modifierAddtion);
                character.setCharismaMod(FindAbilityMod(character.getCharismaScore()));

        }
        if (AbilityChoice.equals("Strength")){
                character.setStrengthScore(character.getStrengthScore() + modifierAddtion);
                System.out.println("Strength +" + modifierAddtion);
                character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));

        }
        if (AbilityChoice.equals("Dexterity")){
                character.setDexterityScore(character.getDexterityScore() + modifierAddtion);
                System.out.println("Dexterity +" + modifierAddtion);
                character.setDexterityMod(FindAbilityMod(character.getDexterityScore()));

        }
        if (AbilityChoice.equals("Wisdom")){
                character.setWisdomScore(character.getWisdomScore() + modifierAddtion);
                System.out.println("Wisdom +" + modifierAddtion);
                character.setWisdomMod(FindAbilityMod(character.getWisdomScore()));
        }
        if (AbilityChoice.equals("Intelligence")){
                character.setIntelligenceScore(character.getIntelligenceScore() + modifierAddtion);
                System.out.println("Intelligence +" + modifierAddtion);
                character.setIntelligenceMod(FindAbilityMod(character.getIntelligenceScore()));
        }
        if (AbilityChoice.equals("Constitution")){
                character.setConstitutionScore(character.getConstitutionScore() + modifierAddtion);
                System.out.println("Constitution +" + modifierAddtion);
                character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));

        }
    }

    public GridPane AbilityScoreImprovement (Stage addLevelStage, int maxLevel,int startinglevel){
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
                AbilityAddition(character,choice.getText(),2);
                if (startinglevel == maxLevel){
                    addLevelStage.close();
                }else AddLevel(addLevelStage,maxLevel,startinglevel+1);
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
                        AbilityAddition(character,intChoice[i],1);
                        if (startinglevel == maxLevel){
                            addLevelStage.close();
                        }else AddLevel(addLevelStage,maxLevel,startinglevel+1);
                    }
                });
            });

        });
        return pane;
    }

    public void AddLevel(Stage addLevelStage, int maxLevel, int startingLevel){

            if (startingLevel <= maxLevel){
                Label hp = new Label("Hit Points: "+ character.getHitPoints());
                Label proficiency = new Label("Proficiency : + "+ this.proficiency);
                ListView features = new ListView(character.getFeaturesList());
                ListView proficiencies = new ListView( character.getProficienciesList());
                proficiencies.setTooltip(new Tooltip("Proficiencies"));
                features.setTooltip(new Tooltip("Features"));
                Label rages = new Label("Rages: " + this.rages);
                Label rageDamage = new Label("Rage Damage: " + this.rageDamage);
                Label primalPath = new Label("Primal Path: "+ this.primalPath);
                primalPath.setWrapText(true);

                BorderPane borderPane = new BorderPane();
                borderPane.setTop(new Label("Current level " + startingLevel + " out of " + maxLevel ));
                GridPane pane = new GridPane();
                InnerShadow shadow = new InnerShadow();
                shadow.setColor(Color.gray(.5));
                pane.setEffect(shadow);
                pane.setPadding(new Insets(10,30,10,30));
                pane.setVgap(20);
                pane.setHgap(10);
                borderPane.setCenter(pane);
                Scene scene = new Scene(borderPane,600,600);
                addLevelStage.setScene(scene);
                Label changes = new Label();
                Button continueButton = new Button("Continue");
                addLevelStage.setTitle("Level " + startingLevel);
                ObservableList misc = FXCollections.observableArrayList();
                continueButton.setOnAction(e->{
                    if (startingLevel == maxLevel){
                        addLevelStage.close();
                    }else  AddLevel(addLevelStage,maxLevel,startingLevel+1);
                });

                if (startingLevel ==1){
                    character.setHitPoints(character.getHitPoints()+ character.getConstitutionScore()+12);
                    hp.setText("Hit Points: " + character.getHitPoints());
                    this.proficiency = 2;
                    proficiency.setText("Proficiency : +" + this.proficiency);
                    character.getFeaturesList().add("Rage");
                    character.getFeaturesList().add("Unarmored Defense");
                    this.rages = 2;
                    rages.setText("Rages: " + this.rages);
                    this.rageDamage = 2;
                    rageDamage.setText("Rage Damage: " + this.rageDamage);

                    continueButton.setDisable(true);
                    pane.add(continueButton,1,4);

                    character.getProficienciesList().addAll("Strength","Constitution","Light Armor","Medium Armor","Shields","Simple Weapons","Martial Weapons");

                    Label skillChoices = new Label("You have learned two new skills to be proficient in.\nChoose your fist skill.");
                    pane.add(skillChoices,0,0,3,2);

                    ObservableList skills = FXCollections.observableArrayList("Animal Handling","Athletics","Intimidation", "Nature","Perception","Survival");
                    Label firstSkill = new Label("First skill choice");
                    ChoiceBox firstChoice = new ChoiceBox(skills);
                    firstChoice.setPrefWidth(150);

                    Label secondSkill = new Label("Second skill choice");
                    ChoiceBox secondChoice = new ChoiceBox(skills);
                    secondChoice.setPrefWidth(150);
                    secondChoice.setDisable(true);

                    firstChoice.setOnAction(e-> {
                        continueButton.setDisable(false);
                        continueButton.setOnAction(continueEvent ->{
                            character.getProficienciesList().add(firstChoice.getValue());
                            skills.remove(firstChoice.getValue());
                            firstSkill.setText("First skill choice: " + firstChoice.getValue());
                            pane.getChildren().remove(firstChoice);
                            secondChoice.setDisable(false);
                            continueButton.setDisable(true);
                        } );
                    });

                    secondChoice.setOnAction(e ->{
                        continueButton.setDisable(false);
                        continueButton.setOnAction(continueEvent -> {
                            character.getProficienciesList().add(secondChoice.getValue());
                            pane.getChildren().remove(secondChoice);
                            secondSkill.setText("Second skill choice: " + secondChoice.getValue());
                            secondChoice.setDisable(true);
                           if (startingLevel == maxLevel){
                               addLevelStage.close();
                           }else  AddLevel(addLevelStage,maxLevel,2);

                        });
                    });

                    pane.add(firstSkill,0,2,6,1);
                    pane.add(firstChoice,2,2);
                    pane.add(secondSkill,0,3,2,1);
                    pane.add(secondChoice,2,3);




                }
                if (startingLevel ==2){

                    character.getFeaturesList().add("Reckless Attack");
                    character.getFeaturesList().add("Danger Sense");
                    features.setItems(character.getFeaturesList());
                    proficiencies.setItems( character.getProficienciesList());

                     changes.setText("Added the following to your character.\nFeatures: Reckless Attack and Danger Sense.");
                    pane.add(changes,0,0);
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());

                    pane.add(continueButton,0,1);


                }
                if (startingLevel ==3){
                    this.rages = 3;
                    rages.setText("Rages: " + this.rages);
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());

                    Label choosePath = new Label("Choose your Primal Path");
                    pane.add(choosePath,1,0,6,1);
                    Label choice = new Label("Primal Path: " + this.primalPath);
                    pane.add(choice,1,3,3,1);

                    continueButton.setDisable(true);

                    Button berserker = new Button("Berserker");
                    berserker.setTooltip(new Tooltip("Path of Berserker\nFeatures: Frenzy"));
                    pane.add(berserker,0,1);
                    berserker.setTranslateX(45);
                    berserker.setOnAction(e-> {
                        this.primalPath=berserker.getText();
                       choice.setText("Primal Path: " + this.primalPath);
                        continueButton.setDisable(false);
                    });

                    Button totemWarrior = new Button("Totem Warrior");
                    berserker.setTooltip(new Tooltip("Path of Totem Warrior\nFeatures: Spirit Speaker\nTotem Spirit choice"));
                    pane.add(totemWarrior,2,1);
                    totemWarrior.setOnAction(e-> {
                        this.primalPath=totemWarrior.getText();
                        choice.setText("Primal Path: " + this.primalPath);
                        continueButton.setDisable(false);
                    });

                    pane.add(continueButton,1,4);
                    continueButton.setOnAction(e->{
                        primalPath.setText("Primal Path: "+ this.primalPath);

                        if (this.primalPath.equals("Berserker")){
                            character.getFeaturesList().add("Frenzy");
                            features.setItems(character.getFeaturesList());
                            if (startingLevel == maxLevel){
                                addLevelStage.close();
                            } else AddLevel(addLevelStage,maxLevel,4);
                        }else {

                            pane.getChildren().removeAll(berserker,totemWarrior);

                            choosePath.setText("Choose your Totem Spirit");
                            pane.getChildren().remove(choosePath);
                            pane.add(choosePath,0,0,6,1);
                            choosePath.setTranslateX(20);
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                            choice.setTranslateX(-10);

                            Button bear = new Button("Bear");
                            bear.setTooltip(new Tooltip("While raging, you have resistance to all damage except psychic damage. The spirit of the bear makes you tough enough to stand up to any punishment"));
                            bear.getTooltip().setWrapText(true);
                            bear.setTranslateX(20);
                            pane.add(bear,0,1);
                            Button eagle = new Button("Eagle");
                            eagle.setTooltip(new Tooltip("While you are raging and aren't wearing heavy armor, other creatures have disadvantage on opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn. The spirit of the eagle makes you into a predator who can weave through the fray with ease."));
                            eagle.getTooltip().setWrapText(true);
                            eagle.setTranslateX(20);
                            pane.add(eagle,1,1);
                            Button wolf = new Button("Wolf");
                            wolf.setTooltip(new Tooltip("While you are raging, your friends have advantage on melee attack rolls against any creature within 5 feet of you that is hostile to you. The spirit of the wolf makes you a leader of hunters."));
                            wolf.getTooltip().setWrapText(true);
                            pane.add(wolf,2,1);

                            bear.setOnAction(bearEvent->{
                                this.totemSpirit = "Bear";
                                choice.setText("Totem Spirit: " + this.totemSpirit);
                            });

                            eagle.setOnAction(eagleEvent->{
                                this.totemSpirit = "Eagle";
                                choice.setText("Totem Spirit: " + this.totemSpirit);
                            });

                            wolf.setOnAction(wolfEvent->{
                                this.totemSpirit = "Wolf";
                                choice.setText("Totem Spirit: " + this.totemSpirit);
                            });

                            continueButton.setOnAction(continueButtonEvent -> {
                                character.getFeaturesList().add("Spirit Speaker: " + this.totemSpirit);
                                features.setItems(character.getFeaturesList());
                                primalPath.setText("Primal Path: "+ this.primalPath);
                                if (startingLevel == maxLevel){
                                    addLevelStage.close();
                                }else AddLevel(addLevelStage,maxLevel,4);

                            });
                        }
                    });

                }
                if (startingLevel ==4){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    borderPane.setCenter(AbilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                }
                if (startingLevel ==5){
                    this.proficiency = 3;
                    proficiency.setText("Proficiency : + "+ this.proficiency);
                    character.getFeaturesList().addAll("Extra Attack","Fast Movement");
                    features.setItems(character.getFeaturesList());
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());
                    character.setSpeed(character.getSpeed() + 10);

                    pane.add(new Label("Features added: Extra Attack and Fast Movement\nProficiency bonus +1\nSpeed +10"),0,0);
                    pane.add(continueButton,0,1);

                }
                if (startingLevel ==6){
                    this.rages = 4;
                    rages.setText("Rages: " + this.rages);
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());
                    if (primalPath.getText().split(" ")[2].equals("Berserker")){
                        character.getFeaturesList().add("Mindless Rage");
                        features.setItems(character.getFeaturesList());
                        pane.add(new Label("Features added: Mindless Rage\n Rages +1"),0,0);
                        pane.add(continueButton,2,1);

                    }else {
                        Label choosePath = new Label("Choose your Totem Spirit");;
                        pane.add(choosePath,0,0,6,1);
                        choosePath.setTranslateX(20);
                        Label choice = new Label("Totem Spirit: Not Selected");
                        pane.add(choice,1,2,3,1);
                        choice.setTranslateX(-10);

                        Button bear = new Button("Bear");
                        bear.setTooltip(new Tooltip("You gain the might of a bear. Your carrying capacity (including maximum load and maximum lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects."));
                        bear.getTooltip().setWrapText(true);
                        bear.setTranslateX(20);
                        pane.add(bear,0,1);
                        Button eagle = new Button("Eagle");
                        eagle.setTooltip(new Tooltip("You gain eyesight of an eagle. You can see up to 1 mile away with no difficulty, able to discern even fine details as though looking at something no more than 100 feet away from you. Additionally, dim light doesn't impose disadvantage on your Wisdom (Perception) checks"));
                        eagle.getTooltip().setWrapText(true);
                        eagle.setTranslateX(20);
                        pane.add(eagle,1,1);
                        Button wolf = new Button("Wolf");
                        wolf.setTooltip(new Tooltip("You gain the hunting sensibilities of a wolf. You can track other creatures while travelling at a fast pace, and you can move stealthily while travelling at a normal pace."));
                        wolf.getTooltip().setWrapText(true);
                        pane.add(wolf,2,1);

                        pane.add(continueButton,1,3);

                        bear.setOnAction(bearEvent->{
                            this.totemSpirit = "Bear";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        eagle.setOnAction(eagleEvent->{
                            this.totemSpirit = "Eagle";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        wolf.setOnAction(wolfEvent->{
                            this.totemSpirit = "Wolf";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        continueButton.setOnAction(continueButtonEvent -> {
                            character.getFeaturesList().add("Aspect of the Beast: " + this.totemSpirit);
                            features.setItems(character.getFeaturesList());
                            primalPath.setText("Primal Path: "+ this.primalPath);
                            if (startingLevel == maxLevel){
                                addLevelStage.close();
                            }else AddLevel(addLevelStage,maxLevel,7);

                        });
                    }
                }
                if (startingLevel ==7){
                    character.getFeaturesList().add("Feral Instinct");
                    features.setItems(character.getFeaturesList());
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());

                     changes.setText("Features Added: Feral Instinct");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==8){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());
                    borderPane.setCenter(AbilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                }
                if (startingLevel ==9){
                    this.proficiency = 4;
                    character.getFeaturesList().add("Brutal Critical (1 Die)");
                    features.setItems(character.getFeaturesList());
                    this.rageDamage = 3;
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    proficiency.setText("Proficiency : + "+ this.proficiency);
                    rageDamage.setText("Rage Damage: " + this.rageDamage);
                    changes.setText("Features Added: Brutal Critical (1 Die)\nProficiency +1\nRage Damage +1");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==10){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    if (this.primalPath.equals("Berserker")){
                        character.getFeaturesList().add("Intimidating Presence");
                        changes.setText("Features added: Intimidating Presence");
                    }else {
                        character.getFeaturesList().add("Spirit Walker");
                        changes.setText("Features added: Spirit Walker");
                    }
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==11){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    character.getFeaturesList().add("Relentless Rage");
                    features.setItems(character.getFeaturesList());
                    changes.setText("Features Added: Relentless Rage");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);

                }
                if (startingLevel ==12){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    this.rages = 5;
                    borderPane.setCenter(AbilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                }
                if (startingLevel ==13){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    this.proficiency=5;
                    character.getFeaturesList().remove("Brutal Critical (1 Die)");
                    character.getFeaturesList().add("Brutal Critical (2 Dice)");
                    changes.setText("Features Added: Updated Brutal Critical (1 Die) to Brutal Critical (2 Dice)\nProficiency +1");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==14){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());

                    if (this.primalPath.equals("Berserker")){
                        character.getFeaturesList().add("Retaliation");
                        features.setItems(character.getFeaturesList());
                        changes.setText("Features added: Retaliation");
                        pane.add(changes,0,0);
                        pane.add(continueButton,0,1);
                    }else {
                        Label choosePath = new Label("Choose your Totem Spirit");;
                        pane.add(choosePath,0,0,6,1);
                        choosePath.setTranslateX(20);
                        Label choice = new Label("Totem Spirit: Not Selected");
                        pane.add(choice,1,2,3,1);
                        choice.setTranslateX(-10);

                        Button bear = new Button("Bear");
                        bear.setTooltip(new Tooltip("While you're raging, any creature within 5 feet of you that's hostile to you has a disadvantage on attack rolls against targets other than you or another character with this feature. An enemy is immune to this effect if it can't see or hear you or if it can't be frightened."));
                        bear.getTooltip().setWrapText(true);
                        bear.setTranslateX(20);
                        pane.add(bear,0,1);
                        Button eagle = new Button("Eagle");
                        eagle.setTooltip(new Tooltip("While raging, you have a flying speed equal to your current walking speed. This benefit works only in short bursts; you fall if you end your turn in the air and nothing else is holding you aloft."));
                        eagle.getTooltip().setWrapText(true);
                        eagle.setTranslateX(20);
                        pane.add(eagle,1,1);
                        Button wolf = new Button("Wolf");
                        wolf.setTooltip(new Tooltip("While you're raging, you can use a bonus action on your turn to knock a large or smaller creature prone when you hit it with melee weapon attack."));
                        wolf.getTooltip().setWrapText(true);
                        pane.add(wolf,2,1);

                        pane.add(continueButton,1,3);

                        bear.setOnAction(bearEvent->{
                            this.totemSpirit = "Bear";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        eagle.setOnAction(eagleEvent->{
                            this.totemSpirit = "Eagle";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        wolf.setOnAction(wolfEvent->{
                            this.totemSpirit = "Wolf";
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                        });

                        continueButton.setOnAction(continueButtonEvent -> {
                            character.getFeaturesList().add("Totemic Attunement");
                            features.setItems(character.getFeaturesList());
                            primalPath.setText("Primal Path: "+ this.primalPath);
                            if (startingLevel == maxLevel){
                                addLevelStage.close();
                            }else AddLevel(addLevelStage,maxLevel,startingLevel+1);

                        });
                    }
                }
                if (startingLevel ==15){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    character.getFeaturesList().add("Persistent Rage");
                    features.setItems(character.getFeaturesList());
                    changes.setText("Features Added: Persistent Rage");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==16){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    this.rageDamage = 4;
                    rageDamage.setText("Rage Damage: 4");
                    borderPane.setCenter(AbilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                }
                if (startingLevel ==17){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    this.proficiency = 6;
                    proficiency.setText("Proficiency: " + this.proficiency);
                    character.getFeaturesList().remove("Brutal Critical (2 Dice)");
                    character.getFeaturesList().add("Brutal Critical  (3 Dice)");
                    this.rages = 6;
                    changes.setText("Features Added: Updated Brutal Critical (2 Dice) to Brutal Critical (3 Dice)\nRages +1\nProficiency +1");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==18){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    character.getFeaturesList().add("Indomitable Might");
                    features.setItems(character.getFeaturesList());
                    changes.setText("Features Added: Indomitable Might");
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
                }
                if (startingLevel ==19){
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    borderPane.setCenter(AbilityScoreImprovement(addLevelStage,maxLevel,startingLevel));
                }
                if (startingLevel ==20){
                    continueButton.setText("Close");
                    AbilityAddition(character,"Strength",4);
                    AbilityAddition(character,"Constitution",4);

                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: "+ character.getHitPoints());
                    character.getFeaturesList().add("Primal Champion");
                    features.setItems(character.getFeaturesList());
                    this.rages = 999999999;
                    rages.setText("Rages: Unlimited");
                    changes.setText("Features Added: Primal Champion \nRages are now unlimited");
                    continueButton.setOnAction(e-> addLevelStage.close());
                    pane.add(changes,0,0);
                    pane.add(continueButton,0,1);
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
                borderPane.setStyle("-fx-border-color: black");
            }

    }

    /**
     *
     * @param inventory Vector of items
     * @param item item you are adding in vector, or adding quantity to already existing item
     */
    public void CheckAndAddItemQuantity(Vector<Item> inventory,Item item){
        int counter =0;
        int i;
        for ( i =0; i< inventory.size();i++){
            if (inventory.get(i).getName().equals(item.getName())){
                inventory.get(i).Addition(item);
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
    public int D12Roll(){
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
    public static int FindAbilityMod(int abilityScore) {
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
    public int InputErrorCheck(int choice, int lowerCheck, int higherCheck){
        Scanner scanner = new Scanner(System.in);
        while (choice < lowerCheck || choice > higherCheck){
            System.out.println("Incorrect option, please choose a different option");
            choice = scanner.nextInt();
            String endofLine = scanner.nextLine();
        }
        return choice;
    }

    public void ChooseArmor(Stage chooseArmorStage){
        VBox pane = new VBox(10);
        Scene scene = new Scene(pane,450,200);;
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseArmorStage.setScene(scene);

        pane.setPadding(new Insets(30,30,20,30));

        Button continueButton = new Button("Continue");

        Label armorLabel = new Label("You are proficient in Light Armor, Medium Armor, and Shields.\nChoose your Armor.");


        ChoiceBox<String> armorChoices = new ChoiceBox(FXCollections.observableArrayList(character.getLightArmor()[0],character.getLightArmor()[1],character.getLightArmor()[2],character.getMediumArmor()[0],character.getMediumArmor()[1],character.getMediumArmor()[2],character.getMediumArmor()[3],character.getMediumArmor()[4]));

        ChoiceBox<String> yOrN = new ChoiceBox(FXCollections.observableArrayList("Yes","No"));
        yOrN.setDisable(true);

        Label armor = new Label("Armor: ");
        Label shield = new Label("Shield: ");

        armorChoices.setOnAction(e-> {
            character.setArmor(armorChoices.getValue());
            armor.setText("Armor: " + armorChoices.getValue());
            armorChoices.setDisable(true);
            armorChoices.hide();
            yOrN.setDisable(false);


        });

        armor.setMinWidth(150);



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


            continueButton.setOnAction(e->{

                //finds index of Armor and Adds Armor as an item
                for (int i=0 ;i < character.getAllArmor().length; i++){
                    if (character.getAllArmor()[i].equals(armorChoices.getValue())){
                        CheckAndAddItemQuantity(character.armorList,new Item(armorChoices.getValue() +" armor",character.getAllArmorDescriptions()[i],1,character.getAllArmorCost()[i]) );
                        character.setAc(character.getAc()+character.getAllArmorAC()[i]);
                        break;
                    }
                }


                if (character.isShield() == true){
                    CheckAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
                    character.setAc(character.getAc() +2);
                }
                ChooseWeapon(chooseArmorStage);
            });

        pane.getChildren().addAll(armorLabel,new HBox(armor,armorChoices), new HBox(shield,yOrN));

        yOrN.setTranslateX(112);
        pane.setStyle("-fx-border-color: black");
    }


    public void ChooseWeapon(Stage chooseWeaponStage){

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
                    CheckAndAddItemQuantity(character.weapons, new Item(character.getMartialMeleeWeapons()[i],character.getMartialMeleeWeaponsProperties()[i],1,character.getMartialMeleeWeaponCost()[i]));
                    break;
                }
            }

            if (handaxeOrSMW.getValue().equals("Handaxe")){
                CheckAndAddItemQuantity(character.weapons,new Item(character.getSimpleMeleeWeapons()[3],character.getSimpleMeleeWeaponProperties()[3],2,character.getSimpleMeleeWeaponsCost()[3]));
            } else {
                for (int i =0 ; i<character.getSimpleMeleeWeapons().length ; i++){
                    if (character.getSimpleMeleeWeapons()[i].equals(handaxeOrSMW.getValue().toString())){
                        CheckAndAddItemQuantity(character.weapons,new Item(character.getSimpleMeleeWeapons()[i],character.getSimpleMeleeWeaponProperties()[i],2,character.getSimpleMeleeWeaponsCost()[i]));
                    }
                }
            }
        });

        Label pack = new Label("Barbarian default pack : Explorer's Pack\nBackpack | Bedroll | Mess Kit | Tinderbox\nTorch x10 | Rations x10 | Waterskin | Hempen Rope x50 ft. | Javelin x4");

        pane.getChildren().addAll(weaponLabel,new HBox(42,firstWeapon,greataxeOrMMW), new HBox(10,secondWeapon,handaxeOrSMW),pack);

        CheckAndAddItemQuantity(character.inventory,new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
        CheckAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
        CheckAndAddItemQuantity(character.inventory, new Item("Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2));
        CheckAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
        CheckAndAddItemQuantity(character.inventory,new Item("Torch","A torch burns for 1 hour providing bright light in a 20 foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.",10,1));
        CheckAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5));
        CheckAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
        CheckAndAddItemQuantity(character.inventory, new Item("Hempen Rope","Quantity is in feet",50,0));
        CheckAndAddItemQuantity(character.inventory, new Item("Javelin","",4,0));

        pane.setStyle("-fx-border-color: black");


    }
}
