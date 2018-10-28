package DungeonsAndDragons;


import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;

import java.util.Scanner;
import java.util.Vector;




// TODO Change VectorPrinOut to print out Item toString
public class Barbarian{
    CharacterSheet character;
    private Vector<String> features = new Vector();
    private int hitDice = 12;
    private int level = 0;
    private String pack;
    private String primalPath = "Not selected";
    private int proficiency;
    Vector<String> proficiencies = new Vector<>();
    private int rageDamage;
    private int rages;
    private String totemSpirit = "Not selected";



    public Barbarian (CharacterSheet character){
        this.character = character;
    }

    // Tested and verfied 9/10
    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public void AbilityAddition(CharacterSheet character, String AbilityChoice, int modifierAddtion){
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
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
                character.setDexterityMod(character.getDexterityMod() + modifierAddtion);
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


    /**
     * Prints out the Ability Choices
     */
    public static void AbilityChoicePrintout(){
        System.out.println("1.) Charisma");
        System.out.println("2.) Strength");
        System.out.println("3.) Dexterity");
        System.out.println("4.) Wisdom");
        System.out.println("5.) Intelligence");
        System.out.println("6.) Constitution");

    }

//    // Tested and Verified 9/3
//    /**
//     *  Gives the user the  choice to either add +2 to 1 ability score, or add 2 separate ability scores by +1
//     * @param character CharacterSheet that the ability improvement is happening to
//     */
//    public void AbilityScoreImprovement(CharacterSheet character){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Would you like to increase 1.) 1 Ability score by +2 or 2.) 2 Ability scores by +1 ");
//        int choice = scanner.nextInt();
//        String endOfLine = scanner.nextLine();
//        choice = InputErrorCheck(choice,1,2);
//        if (choice==1){
//            System.out.println("Which Ability score would you like to increase by +2 ?");
//            AbilityChoicePrintout();
//            choice = scanner.nextInt();
//            endOfLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,6);
//            AbilityAddition(character, choice, 2 );
//            choice = 0;
//        }
//        if (choice==2){
//            System.out.println("Choose your first ability");
//            AbilityChoicePrintout();
//            choice = scanner.nextInt();
//            endOfLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,6);
//            AbilityAddition(character, choice, 1 );
//            System.out.println("What is your second ability?");
//            AbilityChoicePrintout();
//            choice = scanner.nextInt();
//            endOfLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,6);
//            AbilityAddition(character, choice, 1 );
//
//
//        }
//    }

    public GridPane AbilityScoreImprovement (Stage addLevelStage, int maxLevel,int startinglevel){
        Button continueButton = new Button("Continue");
        Label choice = new Label();
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
            if (character.getCharismaScore() >= 20){
                choice.setText("Charisma ability score is greater than 20. Please choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Charisma");
                continueButton.setDisable(false);
            }
        });

        strength.setOnAction(strengthEvent->{
            if (character.getStrengthScore() >= 20){
                choice.setText("Strength ability score is greater than 20. Please choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Strength");
                continueButton.setDisable(false);
            }
        });
        dexterity.setOnAction(dexterityEvent->{
            if (character.getDexterityScore() >= 20){
                choice.setText("Dexterity ability score is greater than 20. Please choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Dexterity");
                continueButton.setDisable(false);
            }
        });
        wisdom.setOnAction(wisdomEvent->{
            if (character.getWisdomScore() >= 20){
                choice.setText("Wisdom ability score is greater than 20. Please choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Wisdom");
                continueButton.setDisable(false);
            }
        });
        intelligence.setOnAction(intelligenceEvent->{
            if (character.getIntelligenceScore() >= 20){
                choice.setText("Intelligence ability score is greater than 20. Please choose a different option.");
                continueButton.setDisable(true);
            }else {
                choice.setText("Intelligence");
                continueButton.setDisable(false);
            }
        });
        constitution.setOnAction(constitutionEvent->{
            if (character.getConstitutionScore() >= 20){
                choice.setText("Constitution ability score is greater than 20. Please choose a different option.");
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
            pane.add(choice,1,3);
            pane.add(continueButton,1,4);
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
            pane.add(choice,1,3);
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
                Label totemSpirit = new Label("Totem Spirit: " + this.totemSpirit);

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

                Button continueButton = new Button("Continue");

                addLevelStage.setTitle("Level " + startingLevel);
                ObservableList misc = FXCollections.observableArrayList();


                if (startingLevel ==1){

                    character.setHitPoints(character.getConstitutionScore()+12);
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

                    Label addedFeatures = new Label("Added the following to your character.\nFeatures: Reckless Attack and Danger Sense.");
                    pane.add(addedFeatures,0,0);
                    character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
                    hp.setText("Hit Points: " + character.getHitPoints());

                    pane.add(continueButton,0,1);

                    continueButton.setOnAction(e->{
                        if (startingLevel == maxLevel){
                            addLevelStage.close();
                        }else AddLevel(addLevelStage,maxLevel,3);
                    });

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
                            totemSpirit.setDisable(true);
                            character.getFeaturesList().add("Frenzy");
                            features.setItems(character.getFeaturesList());
                            if (startingLevel == maxLevel){
                                addLevelStage.close();
                            } else AddLevel(addLevelStage,maxLevel,4);
                        }else {
                            character.getFeaturesList().add("Spirit Speaker");

                            pane.getChildren().removeAll(berserker,totemWarrior);

                            choosePath.setText("Choose your Totem Spirit");
                            pane.getChildren().remove(choosePath);
                            pane.add(choosePath,0,0,6,1);
                            choosePath.setTranslateX(20);
                            choice.setText("Totem Spirit: " + this.totemSpirit);
                            choice.setTranslateX(-10);

                            Button bear = new Button("Bear");
                            bear.setTranslateX(20);
                            pane.add(bear,0,1);
                            Button eagle = new Button("Eagle");
                            eagle.setTranslateX(20);
                            pane.add(eagle,1,1);
                            Button wolf = new Button("Wolf");
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
                                features.setItems(character.getFeaturesList());
                                primalPath.setText("Primal Path: "+ this.primalPath);
                                totemSpirit.setText("Totem Spirit: " + this.totemSpirit);
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

                    GridPane center = new GridPane();
                    center.add(new Label("Features added: Extra Attack and Fast Movement\nProficiency bonus +1\nSpeed +10"),0,0);
                    borderPane.setCenter(center);

                    continueButton.setOnAction(e->{
                        if (startingLevel == maxLevel){
                            addLevelStage.close();
                        }else AddLevel(addLevelStage,maxLevel,6);
                    });


                }
                if (startingLevel ==6){

                }
                if (startingLevel ==7){

                }
                if (startingLevel ==8){

                }
                if (startingLevel ==9){

                }
                if (startingLevel ==10){

                }
                if (startingLevel ==11){

                }
                if (startingLevel ==12){

                }
                if (startingLevel ==13){

                }
                if (startingLevel ==14){

                }
                if (startingLevel ==15){

                }
                if (startingLevel ==16){

                }
                if (startingLevel ==17){

                }
                if (startingLevel ==18){

                }
                if (startingLevel ==19){

                }
                if (startingLevel ==20){

                }
                if (startingLevel == maxLevel){
                    character.setLevel(maxLevel);
                    misc.addAll(new Label("Hit Dice: " + hitDice),proficiency,rages,rageDamage,primalPath,totemSpirit);
                     character.setMisc(misc);

                }





                VBox left = new VBox();
                left.setPrefWidth(150);
                left.setPadding(new Insets(10,10,10,10));
                left.getChildren().addAll(hp,proficiency,rages,rageDamage,primalPath,totemSpirit,proficiencies,features);
                borderPane.setLeft(left);
                borderPane.setStyle("-fx-border-color: black");
            }

    }


//    // Tested and verified 9/3
//    /**
//     * Adds Levels and related information to the character.
//     */
//    public void AddLevel(){
//        Scanner scanner = new Scanner(System.in);
//        level++;
//        if (level == 1){
//            System.out.println("Level 1");
//            character.setHitPoints(character.getConstitutionScore()+12);
//            this.proficiency = 2;
//            this.features.add("Rage");
//            this.features.add("Unarmored Defense");
//            this.rages = 2;
//            this.rageDamage = 2;
//            System.out.println("Proficiency : +2\n Features added : Rage / Unarmored Defense \n Rages : 2 \n Rage Damage : +2");
//            System.out.println("You have learned two new skills to be proficient in, what skills will you choose? 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
//            int choice = scanner.nextInt();
//            String endOfLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,6);
//            if(choice == 1 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Animal Handling");
//            }if(choice == 2 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Athletics");
//            }if(choice == 3 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Intimidation");
//            }if(choice == 4 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Nature");
//            }if(choice == 5 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Perception");
//            }if(choice == 6 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Survival");
//            }
//            System.out.println("And what is your second skill? 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
//            int choice2 = scanner.nextInt();
//            choice2 = InputErrorCheck(choice2,1,6);
//            while(choice == choice2){
//                System.out.println("You already have this skill, please choose another. 1.) Animal Handling 2.) Athletics 3.) Intimidation 4.)Nature 5.) Perception 6.) Survival");
//                choice2 = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice2 = InputErrorCheck(choice2,1,6);
//            }
//            if(choice == 1 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Animal Handling");
//            }if(choice == 2 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Athletics");
//            }if(choice == 3 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Intimidation");
//            }if(choice == 4 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Nature");
//            }if(choice == 5 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Perception");
//            }if(choice == 6 ){
//                CheckVectorAndAdd(proficiencies,"proficiencies","Survival");
//            }
//
//            CheckVectorAndAdd(proficiencies,"proficiencies","Strength");
//            CheckVectorAndAdd(proficiencies,"proficiencies","Constitution");
//            CheckVectorAndAdd(proficiencies,"proficiencies","Light Armor");
//            CheckVectorAndAdd(proficiencies, "proficiencies","Medium Armor");
//            CheckVectorAndAdd(proficiencies,"proficiencies","Shields");
//            CheckVectorAndAdd(proficiencies,"proficiencies","Simple Weapons");
//            CheckVectorAndAdd(proficiencies,"proficiencies","Martial Weapons");
//        }
//        if(level == 2){
//            System.out.println("Level 2");
//            features.add("Reckless Attack");
//            features.add("Danger Sense");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Reckless Attack / Danger Sense");
//        }
//        if(level == 3){
//            System.out.println("Level 3");
//            rages = 3;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Choose your Primal Path 1.) Path of Berserker or 2.) Path of the Totem Warrior");
//            int choice = scanner.nextInt();
//            String endOfLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,2);
//
//            if (choice==1){
//                primalPath = "Path of Berserker";
//                features.add("Primal Path: Frenzy");
//                System.out.println("Features Added : Primal Path - Frenzy\n Rages = 3");
//            }
//            if (choice==2){
//             primalPath = "Path of the Totem Warrior";
//                features.add("Primal Path: Spirit Speaker");
//                System.out.println("Features Added : Primal Path - Spirit Speaker\n Rages = 3");
//                System.out.println("Choose your Totem Spirit");
//                System.out.println("1.) Bear");
//                System.out.println("2.) Eagle");
//                System.out.println("3.) Wolf");
//                choice = scanner.nextInt();
//                endOfLine = scanner.nextLine();
//                choice = InputErrorCheck(choice,1,3);
//
//                if (choice == 1){
//                    totemSpirit = "Bear";
//                }
//                if (choice == 2){
//                    totemSpirit = "Eagle";
//                }
//                if (choice == 3){
//                    totemSpirit = "Wolf";
//                }
//            }
//
//        }
//        if(level == 4){
//            System.out.println("Level 4");
//            features.add("Ability Score Improvement");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Ability Score Improvement ");
//            AbilityScoreImprovement(character);
//        }
//        if (level == 5) {
//            System.out.println("Level 5");
//            proficiency = 3;
//            features.add("Extra Attack");
//            features.add("Fast Movement");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Extra Attack / Fast Movement \n Proficiency = 3");
//            character.setSpeed(character.getSpeed() + 10);
//            System.out.println("Speed changed to " + character.getSpeed());
//        }
//        if (level == 6){
//            System.out.println("Level 6");
//            rages = 4;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            if(primalPath.equals("Path of Berserker")){
//                features.add("Primal Path: Mindless Rage");
//                System.out.println("Features Added : Path Feature - Mindless Rage \n Rages = 4");
//            }
//            if (primalPath.equals("Path of the Totem Warrior")){
//                features.add("Primal Path : Aspect of the Beast");
//                System.out.println("Choose your Totem Spirit");
//                System.out.println("1.) Bear");
//                System.out.println("2.) Eagle");
//                System.out.println("3.) Wolf");
//                int choice = scanner.nextInt();
//                String endOfLine = scanner.nextLine();
//                choice = InputErrorCheck(choice,1,3);
//
//                if (choice == 1){
//                    totemSpirit = "Bear";
//                }
//                if (choice == 2){
//                    totemSpirit = "Eagle";
//                }
//                if (choice == 3){
//                    totemSpirit = "Wolf";
//                }
//                System.out.println("Features Added : Path Feature - Aspect of the Beast \n Rages = 4");
//            }
//
//        }
//        if (level == 7){
//            System.out.println("Level 7");
//            features.add("Feral Instinct");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Feral Instinct");
//
//        }
//        if (level == 8){
//            System.out.println("Level 8");
//            features.add("Ability Score Improvement");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Ability Score Improvement");
//            AbilityScoreImprovement(character);
//        }
//        if (level == 9){
//            System.out.println("Level 9");
//            proficiency = 4;
//            features.add("Brutal Critical (1 Die)");
//            rageDamage = 3;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Brutal Critical (1 Die) \n Proficiency = 4 \n Rage Damage = 3");
//        }
//        if (level == 10){
//            System.out.println("Level 10");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            if(primalPath.equals("Path of Berserker")){
//                features.add("Path Features : Intimidating Presence");
//                System.out.println("Features Added : Path Features - Intimidating Presence");
//
//            }if (primalPath.equals("Path of the Totem Warrior")){
//                features.add("Path Features : Spirit Walker");
//                System.out.println("Features Added : Path Features - Spirit Walker");
//
//            }
//
//        }
//        if (level == 11){
//            System.out.println("Level 11");
//            features.add("Relentless Rage");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Relentless Rage");
//        }
//        if (level == 12) {
//            System.out.println("Level 12");
//            features.add("Ability Score Improvement");
//            rages = 5;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Ability Score Improvement");
//            AbilityScoreImprovement(character);
//        }
//        if (level == 13){
//            System.out.println("Level 13");
//            proficiency=5;
//            features.remove("Brutal Critical (1 Die)");
//            features.add("Brutal Critical (2 Dice)");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Brutal Critical (2 Dice) \n Proficiency = 5");
//        }
//        if (level ==14){
//            System.out.println("Level 14");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            if(primalPath.equals("Path of Berserker")){
//                features.add("Path Feature : Retaliation");
//                System.out.println("Features Added : Path Feature - Retaliation");
//            }if (primalPath.equals("Path of the Totem Warrior")){
//                features.add("Path Feature : Totemic Attunement");
//                System.out.println("Features Added : Path Feature - Totemic Attunement");
//                System.out.println("Choose your Totem Spirit");
//                System.out.println("1.) Bear");
//                System.out.println("2.) Eagle");
//                System.out.println("3.) Wolf");
//                int choice = scanner.nextInt();
//                String endOfLine = scanner.nextLine();
//                choice = InputErrorCheck(choice,1,3);
//
//                if (choice == 1){
//                    totemSpirit = "Bear";
//                }
//                if (choice == 2){
//                    totemSpirit = "Eagle";
//                }
//                if (choice == 3){
//                    totemSpirit = "Wolf";
//                }
//
//            }
//        }
//        if (level==15){
//            System.out.println("Level 15");
//            features.add("Persistent Rage");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Persistent Rage");
//        }
//        if (level == 16){
//            System.out.println("Level 16");
//            features.add("Ability Score Improvement");
//            rageDamage = 4;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Ability Score Improvement \n Rage Damage = 4");
//            AbilityScoreImprovement(character);
//        }
//        if (level == 17){
//            System.out.println("Level 17");
//            proficiency = 6;
//            features.remove("Brutal Critical (2 Dice");
//            features.add("Brutal Critical  (3 Dice)");
//            rages = 6;
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Brutal Critical (3 Dice) \n Proficiency = 6 \n Rages = 6");
//        }
//        if (level == 18){
//            System.out.println("Level 18");
//            features.add("Indomitable Might");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Indomitable Might");
//        }
//        if (level == 19){
//            System.out.println("Level 19");
//            features.add("Ability score improvement");
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Ability Score Improvement");
//            AbilityScoreImprovement(character);
//        }
//        if (level == 20){
//            System.out.println("Level 20");
//            features.add("Primal Champion");
//            rages = 999999999;
//            character.setStrengthScore(character.getStrengthScore()+ 4);
//            character.setStrengthMod(FindAbilityMod(character.getStrengthScore()));
//            character.setConstitutionScore(character.getConstitutionScore() + 4);
//            character.setConstitutionMod(FindAbilityMod(character.getConstitutionScore()));
//            character.setHitPoints(character.getHitPoints() + (D12Roll() + character.getConstitutionMod()));
//            System.out.println("Your current Hit Points is : " + character.getHitPoints());
//            System.out.println("Features Added : Primal Champion \n Rages = Unlimited");
//        }
//
//
//
//
//    }

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


    /**
     * Checks if the contents are already in the vector, if yes nothing happens, if no the contents are added to the vector and prints the contents have been added to the vector.
     * @param vector The vector you are checking/ adding the contents into
     * @param contents String that you are checking/ adding in the vector
     * @param vectorName Name of the vector you are adding the item to
     */
    public void CheckVectorAndAdd(Vector vector,String vectorName, String contents){
        if (!vector.contains(contents)){
            vector.add(contents);
            System.out.println(contents+" added to " + vectorName);
        }

    }


    // TESTED and verified 9/3
    /**
     * Walks user through on choosing their Armor for their Character
     */
////    public void ChooseArmor(){
////        Scanner scanner = new Scanner(System.in);
////        String endOfLine = "";
////        System.out.println("You are proficient in Light Armor, Medium Armor, and Shields");
////        System.out.println("Choose your Armor.");
////        for(int i = 0; i <(character.getLightArmor().length + character.getMediumArmor().length); i++){
////            if(i< character.getLightArmor().length){
////                System.out.println(i+1+".)"+character.getLightArmor()[i]);
////            }
////            if (i>=character.getLightArmor().length){
////                System.out.println(i+1 +".)"+character.getMediumArmor()[i-character.getLightArmor().length]);
////            }
////
////        }
////        int choice = scanner.nextInt();
////        String endLine = scanner.nextLine();
////
////        choice= InputErrorCheck(choice,1,character.getLightArmor().length + character.getMediumArmor().length);
////
////        if(choice < character.getLightArmor().length){
////            System.out.println("You have chosen " + character.getLightArmor()[choice-1]);
////            CheckAndAddItemQuantity(character.armorList, new Item(character.getLightArmor()[choice-1],character.getLightArmorDescription()[choice-1],1,character.getLightArmorCost()[choice-1]));
////            character.setAc(character.getLightArmorAC()[choice-1]);
////        } if(choice >= character.getLightArmor().length){
////            System.out.println("You have chosen "  + character.getMediumArmor()[choice - character.getLightArmor().length - 1]);
////            CheckAndAddItemQuantity(character.armorList, new Item(character.getMediumArmor()[choice - character.getLightArmor().length - 1],character.getMediumArmorDescription()[choice - character.getLightArmor().length - 1],1,character.getMediumArmorCost()[choice - character.getLightArmor().length - 1]));
////            character.setAc(character.getMediumArmorAC()[choice-character.getLightArmor().length - 1]);
////
////        }
////
////        System.out.println("Would you like to have a shield? 1.) Yes or 2.) No ?");
////        choice = scanner.nextInt();
////        endOfLine = scanner.nextLine();
////        choice = InputErrorCheck(choice,1,2);
////        if (choice==1){
////            character.setShield(true);
////            CheckAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
////            character.setAc(character.getAc() +2);
////        }
////
////    }


//
//    // Tested and verified 9/3
//    /**
//     * Walks user through on choosing their Weapons / Equipment for their Character
//     */
//    public void ChooseWeapon(){
//        Scanner scanner = new Scanner(System.in);
//        int choice = -1;
//        String endOfLine = "";
//
//        System.out.println("** Equipment Choices **");
//        System.out.println("Would you like a 1.) Greataxe or 2.) Any Martial Melee Weapon? ");
//        choice = scanner.nextInt();
//        String endLine = scanner.nextLine();
//        choice=InputErrorCheck(choice,1,2);
//
//        if (choice ==1){
//
//            System.out.println("You have chosen a Greataxe");
//            CheckAndAddItemQuantity(character.weapons,new Item("Greataxe","Heavy, two-handed",1,30));
//        }
//        if (choice==2){
//            System.out.println("Which Martial Melee Weapon would you like ?");
//            for (int i =0; i < character.getMartialMeleeWeapons().length; i++){
//                System.out.println(i+1 + ".) " + character.getMartialMeleeWeapons()[i]);
//            }
//            choice = scanner.nextInt();
//            endLine = scanner.nextLine();
//            choice = InputErrorCheck(choice,1,character.getMartialMeleeWeapons().length);
//            System.out.println("You have chosen " + character.getMartialMeleeWeapons()[choice-1]);
//            CheckAndAddItemQuantity(character.weapons, new Item(character.getMartialMeleeWeapons()[choice-1],character.getMartialMeleeWeaponsProperties()[choice-1],1,character.getMartialMeleeWeaponCost()[choice-1]));
//        }
//        System.out.println("For a secondary, would you like 1.)Two Handaxes or 2.) Any Simple Martial Melee Weapon?");
//        choice = scanner.nextInt();
//        endLine = scanner.nextLine();
//        choice =InputErrorCheck(choice,1,2);
//
//        if(choice==1){
//            System.out.println("You have chosen 2 handaxes");
//            CheckAndAddItemQuantity(character.weapons,new Item ("Handaxe","Light, thrown (range 20/60)",2,5));
//
//        }
//        if (choice ==2 ) {
//            System.out.println("Which Simple Melee Weapon do you choose?");
//            for (int i = 0; i < character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length; i++) {
//                if (i < character.getSimpleMeleeWeapons().length){
//                    System.out.println( i+1 + ".) " + character.getSimpleMeleeWeapons()[i]);
//                }
//                if (i >= character.getSimpleMeleeWeapons().length){
//                    System.out.println(i+1 + ".) " + character.getSimpleRangedWeapons()[i-character.getSimpleMeleeWeapons().length]);
//                }
//            }
//            choice = scanner.nextInt();
//            endLine = scanner.nextLine();
//            choice=InputErrorCheck(choice,1,character.getSimpleMeleeWeapons().length + character.getSimpleRangedWeapons().length );
//
//            if (choice <= character.getSimpleMeleeWeapons().length){
//                System.out.println("You have chosen " + character.getSimpleMeleeWeapons()[choice-1] );
//                CheckAndAddItemQuantity(character.weapons, new Item (character.getSimpleMeleeWeapons()[choice-1],character.getSimpleMeleeWeaponProperties()[choice-1],1,character.getSimpleMeleeWeaponsCost()[choice-1] ));
//            }
//            if (choice>character.getSimpleMeleeWeapons().length){
//                System.out.println("You have chosen " + character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1]);
//                CheckAndAddItemQuantity(character.weapons, new Item(character.getSimpleRangedWeapons()[choice-character.getSimpleMeleeWeapons().length -1],character.getSimpleRangedWeaponsProperties()[choice-character.getSimpleMeleeWeapons().length -1],1,character.getSimpleRangedWeaponsCost()[choice-character.getSimpleMeleeWeapons().length -1]));
//            }
//
//        }
//
//        pack="Explorer";
//        CheckAndAddItemQuantity(character.inventory,new Item("Backpack", "1 cubic foot/ 30 pounds of gear capacity",1,2));
//        CheckAndAddItemQuantity(character.inventory, new Item("Bedroll","",1,1));
//        CheckAndAddItemQuantity(character.inventory, new Item("Mess Kit","This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or a shallow bowl.",1,2));
//        CheckAndAddItemQuantity(character.inventory, new Item("Tinderbox","This small contained hold flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it ot light a torch - or anything else with abundant,exposed fuel - takes action. Lighting any other fire takes one minute.",1,5));
//        CheckAndAddItemQuantity(character.inventory,new Item("Torch","A torch burns for 1 hour providing bright light in a 20 foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.",10,1));
//        CheckAndAddItemQuantity(character.inventory, new Item("Rations","Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.",10,5));
//        CheckAndAddItemQuantity(character.inventory, new Item("Waterskin","",1,2));
//        CheckAndAddItemQuantity(character.inventory, new Item("Hempen Rope","Quantity is in feet",50,0));
//        CheckAndAddItemQuantity(character.inventory, new Item("Javelin","",4,0));
//        System.out.println("Explorers pack, and four Javelins were added to your Inventory");
//
//    }

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
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane,650,400);;
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseArmorStage.setScene(scene);
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(50,50,50,50));

        Button continueButton = new Button("Continue");

        pane.setHgap(25);
        pane.setVgap(15);

        Label armorLabel = new Label("You are proficient in Light Armor, Medium Armor, and Shields.\nChoose your Armor.");


        ChoiceBox<String> armorChoices = new ChoiceBox(FXCollections.observableArrayList(character.getLightArmor()[0],character.getLightArmor()[1],character.getLightArmor()[2],character.getMediumArmor()[0],character.getMediumArmor()[1],character.getMediumArmor()[2],character.getMediumArmor()[3],character.getMediumArmor()[4]));

        ChoiceBox<String> yOrN = new ChoiceBox(FXCollections.observableArrayList("Yes","No"));
        yOrN.setDisable(true);

        Label armor = new Label("Armor: ");
        Label shield = new Label("Shield: ");

        armorChoices.setOnAction(e-> {
            character.setArmor(armorChoices.getValue());
            armor.setText("Armor: " + armorChoices.getValue());
            yOrN.setDisable(false);


        });

        armor.setMinWidth(150);



        yOrN.setOnAction(e-> {
            if (yOrN.getValue().equals("Yes")){
                shield.setText("Shield: Yes");
                character.setShield(true);
            }else {
                shield.setText("Shield: No");
                character.setShield(false);            }
            pane.add(continueButton,1,3);
        });


            continueButton.setOnAction(e->{

                //finds index of Armor and Adds Armor as an item
                for (int i=0 ;i < character.getAllArmor().length; i++){
                    if (character.getAllArmor()[i].equals(armorChoices.getValue())){
                        CheckAndAddItemQuantity(character.armorList,new Item(armorChoices.getValue() +" armor",character.getAllArmorDescriptions()[i],1,character.getAllArmorCost()[i]) );
                        break;
                    }
                }


                if (character.isShield() == true){
                    CheckAndAddItemQuantity(character.armorList, new Item("Shield","A shield is made from wood or metal and is carried in one hand. Wielding a shield increases your Armor Class by 2. You can benefit from only one shield at a time.",1,10));
                    character.setAc(character.getAc() +2);
                }
                ChooseWeapon(chooseArmorStage);
            });


        pane.add(armorLabel,1,0,3,1);
        armorLabel.setTranslateX(-100);

        pane.add(armorChoices,1,1);
        pane.add(yOrN,1,2);
        pane.add(shield,0,2);
        pane.add(armor,0,1);

        pane.setStyle("-fx-border-color: black");
    }


    public void ChooseWeapon(Stage chooseWeaponStage){

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane,650,400);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        chooseWeaponStage.setScene(scene);
        pane.setGridLinesVisible(false);
        pane.setHgap(20);
        pane.setVgap(15);

        pane.setPadding(new Insets(50,50,50,50));

        Button continueButton = new Button("Continue");

        pane.setHgap(25);
        pane.setVgap(15);

        Label weaponLabel = new Label("** Equipment Choices **\n Choose between the options below.");

        ObservableList simpleMartialMeleeWeapons = FXCollections.observableArrayList();
        for (int i =0 ; i<character.getSimpleMeleeWeapons().length; i++){
            simpleMartialMeleeWeapons.add(character.getSimpleMeleeWeapons()[i]);
        }

        Label firstWeapon = new Label("Greataxe or any Martial Melee Weapon.");
        ChoiceBox greataxeOrMMW = new ChoiceBox(FXCollections.observableArrayList(character.getMartialMeleeWeapons()[0],character.getMartialMeleeWeapons()[1],character.getMartialMeleeWeapons()[2],character.getMartialMeleeWeapons()[3],character.getMartialMeleeWeapons()[4]));

        Label secondWeapon = new Label("Two handaxes or any Simple Martial Weapon.");
        ChoiceBox handaxeOrSMW = new ChoiceBox(FXCollections.observableArrayList(simpleMartialMeleeWeapons));

        pane.add(weaponLabel,1,0);
        pane.add(firstWeapon,0,1);
        pane.add(greataxeOrMMW,1,1);
        pane.add(secondWeapon,0,2);
        pane.add(handaxeOrSMW,1,2);
        handaxeOrSMW.setDisable(true);

        greataxeOrMMW.setOnAction(e-> handaxeOrSMW.setDisable(false));

        handaxeOrSMW.setOnAction(e-> pane.add(continueButton,1,6));

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


        pane.add(pack,0,4,3,1);

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
