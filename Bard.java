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

        if (startingLevel <= maxLevel) {
            //TODO add level increments by recursion on continue button action
            spellSaveDC = 8 + proficiency + character.getCharismaMod();
            spellAttackMod = proficiency + character.getCharismaMod();
            Label hp = new Label("Hit Points: " + character.getHitPoints());
            Label proficiency = new Label("Proficiency : + " + character.getProficiencyMod());
            ListView features = new ListView(character.getFeaturesList());
            ListView proficiencies = new ListView(character.getProficienciesList());
            proficiencies.setTooltip(new Tooltip("Proficiencies"));
            features.setTooltip(new Tooltip("Features"));

            BorderPane borderPane = new BorderPane();
            borderPane.setTop(new Label("Current level " + startingLevel + " out of " + maxLevel));
            GridPane pane = new GridPane();
            InnerShadow shadow = new InnerShadow();
            shadow.setColor(Color.gray(.5));
            pane.setEffect(shadow);
            pane.setPadding(new Insets(10, 30, 10, 30));
            pane.setVgap(20);
            pane.setHgap(10);
            borderPane.setCenter(pane);
            Scene scene = new Scene(borderPane, 600, 600);
            addLevelStage.setScene(scene);
            Label changes = new Label();
            Button continueButton = new Button("Continue");
            addLevelStage.setTitle("Level " + startingLevel);
            ObservableList misc = FXCollections.observableArrayList();
            continueButton.setOnAction(e -> {
                if (startingLevel == maxLevel) {
                    addLevelStage.close();
                } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
            });

            if (startingLevel == 1) {
                VBox levelOne = new VBox(20);
                character.cantrips.setSize(2);
                character.spells.setSize(4);
                character.setProficiencyMod(2);
                proficiency.setText("Proficiency : +" + character.getProficiencyMod());
                character.setHitPoints(8 + character.getConstitutionMod());
                hp.setText("Hit Points: " + character.getHitPoints());

                character.getFeaturesList().add("Spellcasting");
                character.getFeaturesList().add("Bardic Inspiration (d6)");
                changes.setText("Added the following to your character.\nFeatures: Spellcasting and Bardic Inspiration (d6)");
                Label chooseSpells = new Label("You have learned 2 Cantrips and 4 First level spells. Please choose a Cantrip");
                levelOne.getChildren().addAll(changes, chooseSpells);

                //TODO why is continue button disappearing 
                levelOne.getChildren().add((chooseSpells(continueButton, cantripList, 2)));
                continueButton.setOnAction(e -> {
                    levelOne.getChildren().remove(2);
                    chooseSpells.setText("You have learned 2 Cantrips and 4 First level spells. Please choose a spell");
                    levelOne.getChildren().add((chooseSpells(continueButton, cantripList, 2)));
                    continueButton.setOnAction(ContinueError -> {
                        if (startingLevel == maxLevel) {
                            addLevelStage.close();
                        } else addLevel(addLevelStage, maxLevel, startingLevel + 1);
                    });
                });

//                character.cantrips.add(cantripList.get(choice - 1));
//                cantripList.remove(choice - 1);
//                System.out.println("Please choose your second cantrip");
//                vectorPrintOut(cantripList);
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, cantripList.size());
//                System.out.println("You have added " + cantripList.get(choice - 1) + " to your cantrips.");
//                character.cantrips.add(cantripList.get(choice - 1));
//                cantripList.remove(choice - 1);
//                System.out.println("Please choose your first First Level Spell");
//                vectorPrintOut(firstLevelSpells);
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, firstLevelSpells.size());
//                System.out.println("You have added " + firstLevelSpells.get(choice - 1) + " to your spells.");
//                character.spells.add(firstLevelSpells.get(choice - 1));
//                firstLevelSpells.remove(choice - 1);
//                System.out.println("Please choose your second First Level Spell");
//                vectorPrintOut(firstLevelSpells);
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, firstLevelSpells.size());
//                System.out.println("You have added " + firstLevelSpells.get(choice - 1) + " to your spells.");
//                character.spells.add(firstLevelSpells.get(choice - 1));
//                firstLevelSpells.remove(choice - 1);

                character.getProficienciesList().addAll("Dexterity", "Charisma", "Simple Weapons", "Hand Crossbows", "Longswords", "Rapiers", "Shortswords");
                borderPane.setCenter(levelOne);

            }
            if (startingLevel == 2) {
                System.out.println("Level 2");
                addLevelStage.close();
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
//            if (level == 2) {
//                System.out.println("Level 2");
//                character.spells.setSize(5);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                chooseYourSpell(1);
//                features.add("Jack of All Trades");
//                features.add("Song of Rest (d6)");
//                System.out.println("Jack of All Trades and Song of Rest(d6) added to features");
//
//            }
//            if (level == 3) {
//                System.out.println("Level 3");
//                character.spells.setSize(6);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                features.add("Expertise");
//                chooseYourSpell(1);
//                for (int i = 0; i < 2; i++) {
//                    chooseYourSpell(2);
//                }
//                System.out.println("Choose your Bard College 1.) College of Lore or 2.) College of Valor . ");
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, 2);
//                if (choice == 1) {
//                    features.add("Bard College : College of Lore");
//                    college = "College of Lore";
//                    System.out.println("Bard College : College of Lore and Expertise added to features");
//                }
//                if (choice == 2) {
//                    features.add("Bard College : College of Valor");
//                    college = "College of Valor";
//                    System.out.println("Bard College : College of Valor and Expertise added to features");
//                }
//            }
//            if (level == 4) {
//                System.out.println("Level 4");
//                character.spells.setSize(7);
//                character.cantrips.setSize(4);
//                character.setHitPoints(character.getHitPoints() + (d8Roll() + character.getConstitutionMod()));
//                System.out.println("Your current Hit Points is : " + character.getHitPoints());
//                System.out.println("You learned a new Cantrip, please choose your new cantrip");
//                vectorPrintOut(cantripList);
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = inputErrorCheck(choice, 1, cantripList.size());
//                System.out.println("You added " + cantripList.get(choice - 1));
//                character.cantrips.add(cantripList.get(choice - 1));
//                cantripList.remove(choice - 1);
//
//                chooseYourSpell(2);
//
//                abilityScoreImprovement(character);
//
//            }
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
     * @param continueButton        The continue button that will allow the continuation in the flow
     * @param listOfAvailableSpells The list of spells the user will choose from
     * @param iteration             How many times that this method with the same parameter inputs will be called through recursion
     * @return the VBox that contains the choice for the user
     */
    public VBox chooseSpells(Button continueButton, Vector listOfAvailableSpells, int iteration) {
        VBox chooseSpellsPane = new VBox(20);
        ChoiceBox<String> spellchoices = new ChoiceBox<>();
        spellchoices.setItems(FXCollections.observableArrayList(listOfAvailableSpells));
        continueButton.setDisable(true);
        spellchoices.setOnAction(spellError -> {
            continueButton.setDisable(false);
            continueButton.setOnAction(spellErrorCont -> {
                character.cantrips.add(spellchoices.getValue());
                spellchoices.getItems().remove(spellchoices.getValue());
                if (iteration > 1) {
                    chooseSpells(continueButton, listOfAvailableSpells, iteration - 1);
                }

            });
        });
        chooseSpellsPane.getChildren().addAll(spellchoices, continueButton);
        return chooseSpellsPane;

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
        Scene scene = new Scene(pane,475,350);
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

        Label musicLabel = new Label("Musical Instrument choices 1/3");
        Label skillLabel = new Label("Skills Choices 1/3");

        //Sets the proficiency choices
        VBox proficiencyPane = new VBox(20);
        Label proficienciesLabel = new Label("Proficiency Choices");
        proficienciesLabel.setUnderline(true);
        ObservableList musicList = FXCollections.observableArrayList();
        musicList.setAll(character.getMusicalInstruments());
        ObservableList skillList = FXCollections.observableArrayList();
        skillList.setAll(character.getAllSkills());
        ChoiceBox musicProficiencies = new ChoiceBox(musicList);
        musicProficiencies.setPrefWidth(150);
        musicProficiencies.setTranslateX(100);
        ChoiceBox skillProficiencies = new ChoiceBox(skillList);
        skillProficiencies.setPrefWidth(150);
        skillProficiencies.setTranslateX(172);
        skillProficiencies.setDisable(true);

        musicProficiencies.setOnAction(firstMusicInstrument ->{
            character.getProficienciesList().add(musicProficiencies.getValue());
            musicList.remove(musicProficiencies.getValue());
            musicLabel.setText("Musical Instrument choices 2/3");
                musicProficiencies.setItems(musicList);
                musicProficiencies.setOnAction(secondMusicalInstrument ->{
                    character.getProficienciesList().add(musicProficiencies.getValue());
                    musicList.remove(musicProficiencies.getValue());
                    musicLabel.setText("Musical Instrument choices 3/3");
                       musicProficiencies.setItems(musicList);
                       musicProficiencies.setOnAction(thirdMusicalInstrument ->{
                           character.getProficienciesList().add(musicProficiencies.getValue());
                           musicProficiencies.setDisable(true);
                           skillProficiencies.setDisable(false);
                        });
                });
        });

        skillProficiencies.setOnAction(firstSkill ->{
            character.getProficienciesList().add(skillProficiencies.getValue());
            skillList.remove(skillProficiencies.getValue());
            skillLabel.setText("Skills Choices 2/3");
            skillProficiencies.setOnAction(secondSkill ->{
                character.getProficienciesList().add(skillProficiencies.getValue());
                skillList.remove(skillProficiencies.getValue());
                skillLabel.setText("Skills Choices 3/3");
                skillProficiencies.setOnAction(thirdSkill ->{
                    character.getProficienciesList().add(skillProficiencies.getValue());
                    proficiencyPane.setDisable(true);
                    equipmentPane.setDisable(false);
                });
            });

        });
        proficiencyPane.getChildren().addAll(new HBox(musicLabel,musicProficiencies),new HBox(skillLabel,skillProficiencies));

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
        character.getProficienciesList().addAll("Dexterity","Charisma","Light Armor","Simple Weapons","Hand Crossbows","Longswords","Rapiers","Shortsword");

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
                checkAndAddItemQuantity(character.inventory, new Item("Case","This cylindrical leather case can hold up to ten rolled-up sheets od paper or five rolled-up sheets of parchment ",2,1));
                checkAndAddItemQuantity(character.inventory, new Item("Set of Fine Clothes","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Bottle of Ink","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Ink Pen","",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Lamp","A  lamp casts bright light in a 15 foot radius and dim light for an additional 30 feet. ONce lit, it burns for 6 hours on a flask (1 pint) of oil",1,5));
                checkAndAddItemQuantity(character.inventory, new Item("Flask of Oil","Oils usually comes in a clay flask that holds 1 pint. As an action you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5 foot square area,provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters or ends its turn in the area. A creature can take this damage only once per turn.",2,0));
                checkAndAddItemQuantity(character.inventory, new Item("Sheets of Paper","",5,0));
                checkAndAddItemQuantity(character.inventory, new Item("Vial of Perfume","",1,0));
                checkAndAddItemQuantity(character.inventory, new Item("Sealing Wax","",1,5));
                checkAndAddItemQuantity(character.inventory, new Item("Soap","",1,5));
                System.out.println("Diplomat Pack added to inventory.");

            }if (packChoice.getValue().equals("Entertainer's pack")){
                checkAndAddItemQuantity(character.inventory, new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
                checkAndAddItemQuantity(character.inventory, new Item("Costume","",2,0));
                checkAndAddItemQuantity(character.inventory, new Item("Candle","For 1 hour, a candle sheds bright light in a 5 - foot radius and dim light for an additional 5 feet",2,1));
                checkAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",5,5));
                checkAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
                checkAndAddItemQuantity(character.inventory, new Item("Disguise kit","This pouch of cosmetics, hair dye,and small props let you create disguises that change your physical appearance. Proficiency with this kit lets you add your proficiency bonus to any ability checks you make to create a visual disguise.",1,25));
                System.out.println("Entertainer pack added to inventory.");
            }

            //Saves insrument choice to Charactersheet
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


    // Tested and verified 9/9
    /**
     * Code needed to complete the Magical Secrets Feature
     * @param maxlevel Max Level that the Spells can be
     */
    public void magicalSecrects(int maxlevel){
        Scanner scanner = new Scanner(System.in);
        int level;
        int choice ;
        String endOdLine = "";

        System.out.println("\nMagical Secretes:\nWhat level of Spells would you like to learn from all spells?\n0.) Cantrips , 1, 2, 3, 4, 5, 6, 7, 8, or 9? Your Max Level is :" + maxlevel);
        level = scanner.nextInt();
        endOdLine = scanner.nextLine();
        level = inputErrorCheck(level, 0, maxlevel);
        if(level==0){
            System.out.println("All Cantrips");
            vectorPrintOut(allCantrips);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allCantrips.size());
            if (character.spells.contains(allCantrips.get(choice-1))){
                while(character.spells.contains(allCantrips.get(choice-1))){
                    allCantrips.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);

                }
                choice = -1;
            }
            else{

                character.spells.add(allCantrips.get(choice-1));
                System.out.println("You have added : " +allCantrips.get(choice-1)+ " to your cantrips");
                allCantrips.remove(choice-1);
                choice = -1;
            }

        }

        if(level==1){
            System.out.println("All First Level Spells");
            vectorPrintOut(allFirstLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFirstLevelSpells.size());
            if (character.spells.contains(allFirstLevelSpells.get(choice-1))){
                while(character.spells.contains(allFirstLevelSpells.get(choice-1))){
                    allFirstLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }
            else {
                character.spells.add(allFirstLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFirstLevelSpells.get(choice-1));
                allFirstLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(level==2){
            System.out.println("All Second Level Spells");
            vectorPrintOut(allSecondLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSecondLevelSpells.size());
            if (character.spells.contains(allSecondLevelSpells.get(choice-1))){
                while(character.spells.contains(allSecondLevelSpells.get(choice-1))) {
                    allSecondLevelSpells.remove(choice - 1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);

                }
                choice = -1;
            }else {
                character.spells.add(allSecondLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSecondLevelSpells.get(choice-1));
                allSecondLevelSpells.remove(choice-1);
                choice = -1;
            }

        }


        if(level==3){
            System.out.println("All Third Level Spells");
            vectorPrintOut(allThirdLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allThirdLevelSpells.size());
            if (character.spells.contains(allThirdLevelSpells.get(choice-1))){
                while(character.spells.contains(allThirdLevelSpells.get(choice-1))){
                    allThirdLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allThirdLevelSpells.get(choice-1));
                System.out.println("You have added : " +allThirdLevelSpells.get(choice-1));
                allThirdLevelSpells.remove(choice-1);
                choice = -1;
            }



        }

        if(level==4){
            System.out.println("All Fourth Level Spells");
            vectorPrintOut(allFourthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFourthLevelSpells.size());
            if (character.spells.contains(allFourthLevelSpells.get(choice-1))){
                while(character.spells.contains(allFourthLevelSpells.get(choice-1))){
                    allFourthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allFourthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFourthLevelSpells.get(choice-1));
                allFourthLevelSpells.remove(choice-1);
                choice = -1;
            }


        }

        if(level==5){
            System.out.println("All Fifth Level Spells");
            vectorPrintOut(allFifthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allFifthLevelSpells.size());
            if (character.spells.contains(allFifthLevelSpells.get(choice-1))){
                while(character.spells.contains(allFifthLevelSpells.get(choice-1))){
                    allFifthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allFifthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allFifthLevelSpells.get(choice-1));
                allFifthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==6){
            System.out.println("All Sixth Level Spells");
            vectorPrintOut(allSixthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSixthLevelSpells.size());
            if (character.spells.contains(allSixthLevelSpells.get(choice-1))){
                while(character.spells.contains(allSixthLevelSpells.get(choice-1))){
                    allSixthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allSixthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSixthLevelSpells.get(choice-1));
                allSixthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==7){
            System.out.println("All Seventh Level Spells");
            vectorPrintOut(allSeventhLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allSeventhLevelSpells.size());
            if (character.spells.contains(allSeventhLevelSpells.get(choice-1))){
                while(character.spells.contains(allSeventhLevelSpells.get(choice-1))){
                    allSeventhLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allSeventhLevelSpells.get(choice-1));
                System.out.println("You have added : " +allSeventhLevelSpells.get(choice-1));
                allSeventhLevelSpells.remove(choice-1);
                choice = -1;
            }

        }

        if(level==8){
            System.out.println("All Eighth Level Spells");
            vectorPrintOut(allEighthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allEighthLevelSpells.size());
            if (character.spells.contains(allEighthLevelSpells.get(choice-1))){
                while(character.spells.contains(allEighthLevelSpells.get(choice-1))){
                    allEighthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allEighthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allEighthLevelSpells.get(choice-1));
                allEighthLevelSpells.remove(choice-1);
                choice = -1;

            }

        }

        if(level==9){
            System.out.println("All Ninth Level Spells");
            vectorPrintOut(allNinthLevelSpells);
            choice = scanner.nextInt();
            endOdLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,allNinthLevelSpells.size());
            if (character.spells.contains(allNinthLevelSpells.get(choice-1))){
                while(character.spells.contains(allNinthLevelSpells.get(choice-1))){
                    allNinthLevelSpells.remove(choice-1);
                    System.out.println("You already have this spell, please choose a different spell");
                    magicalSecrects(maxlevel);
                }
                choice = -1;
            }else {
                character.spells.add(allNinthLevelSpells.get(choice-1));
                System.out.println("You have added : " +allNinthLevelSpells.get(choice-1));
                allNinthLevelSpells.remove(choice-1);
                choice = -1;
            }

        }



    }



    //Tested and verified 9/9

    /**
     * Walks user through choosing the tools they want to be proficient in
     */
    public void toolsProficiencies(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        String endOfLine="";
        System.out.println("You are proficient in three musical instruments, choose your first instrument.");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies", character.getMusicalInstruments()[choice-1]);

        System.out.println("Choose your second instrument.");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies",character.getMusicalInstruments()[choice-1]);

        System.out.println("Choose your third instrument");
        for (int i = 0; i < character.getMusicalInstruments().length; i++){
            System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
        }
        choice = scanner.nextInt();
        endOfLine = scanner.nextLine();
        choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        while(proficiencies.contains(character.getMusicalInstruments()[choice-1])){
            System.out.println("You are already proficient in this item, please choose a different option");
            for (int i = 0; i < character.getMusicalInstruments().length; i++){
                System.out.println(i+1 +".) " + character.getMusicalInstruments()[i]);
            }
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice,1,character.getMusicalInstruments().length);
        }
        checkVectorAndAdd(proficiencies,"proficiencies",character.getMusicalInstruments()[choice-1]);

    }


    /**
     * Prints out a vector
     * @param vector Vector that is needing to be printed out
     */
    public static void vectorPrintOut(Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
        }
    }


// Tested and verified 9/9
    /**
     * To choose the a spell from a specific level
     * @param spellLevel The Level of the spells that they are choosing from
     */
    public void chooseYourSpell(int spellLevel){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String endOfLine = "";


        if (spellLevel == 1){
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);
            System.out.println("Choose your spell.");
            vectorPrintOut(firstLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, firstLevelSpells.size());
            System.out.println("You added " + firstLevelSpells.get(choice - 1)+ " to your spells.");
            character.spells.add(firstLevelSpells.get(choice - 1));
            firstLevelSpells.remove(choice - 1);

        }
        if (spellLevel == 2) {
            System.out.println("You learned a new spell! Spell Level: " + spellLevel);

            System.out.println("Choose your spell.");
            vectorPrintOut(secondLevelSpells);
            choice = scanner.nextInt();
            endOfLine = scanner.nextLine();
            choice = inputErrorCheck(choice, 1, secondLevelSpells.size());
            System.out.println("You added " + secondLevelSpells.get(choice - 1) + " to your spells.");
            character.spells.add(secondLevelSpells.get(choice - 1));
            secondLevelSpells.remove(choice - 1);

        }

            if (spellLevel == 3){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(thirdLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, thirdLevelSpells.size());
                System.out.println("You added " + thirdLevelSpells.get(choice - 1) + " to your spells.");
                character.spells.add(thirdLevelSpells.get(choice - 1));
                thirdLevelSpells.remove(choice - 1);
            }

            if (spellLevel == 4){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);

                System.out.println("Choose your spell.");
                vectorPrintOut(fourthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, fourthLevelSpells.size());
                System.out.println("You added " + fourthLevelSpells.get(choice - 1)  + " to your spells.");
                character.spells.add(fourthLevelSpells.get(choice - 1));
                fourthLevelSpells.remove(choice - 1);
            }

            if (spellLevel == 5){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(fifthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, fifthLevelSpells.size());
                System.out.println("You added " + fifthLevelSpells.get(choice - 1) + " to your spells.");
                character.spells.add(fifthLevelSpells.get(choice - 1));
                fifthLevelSpells.remove(choice - 1);

            }

            if (spellLevel == 6){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(sixthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, sixthLevelSpells.size());
                System.out.println("You added " + sixthLevelSpells.get(choice - 1) + " to your spells.");
                character.spells.add(sixthLevelSpells.get(choice - 1));
                sixthLevelSpells.remove(choice - 1);
            }

            if (spellLevel == 7){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(seventhLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, seventhLevelSpells.size());
                System.out.println("You added " + seventhLevelSpells.get(choice - 1)  + " to your spells.");
                character.spells.add(seventhLevelSpells.get(choice - 1));
                seventhLevelSpells.remove(choice - 1);

            }

            if (spellLevel == 8){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(eighthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, eighthLevelSpells.size());
                System.out.println("You added " + eighthLevelSpells.get(choice - 1) + " to your spells.");
                character.spells.add(eighthLevelSpells.get(choice - 1));
                eighthLevelSpells.remove(choice - 1);


            }

            if (spellLevel == 9){
                System.out.println("You learned a new spell! Spell Level: " + spellLevel);
                System.out.println("Choose your spell.");
                vectorPrintOut(ninthLevelSpells);
                choice = scanner.nextInt();
                endOfLine = scanner.nextLine();
                choice = inputErrorCheck(choice, 1, ninthLevelSpells.size());
                System.out.println("You added " + ninthLevelSpells.get(choice - 1)  + " to your spells.");
                character.spells.add(ninthLevelSpells.get(choice - 1));
                ninthLevelSpells.remove(choice - 1);
            }
    }





}
