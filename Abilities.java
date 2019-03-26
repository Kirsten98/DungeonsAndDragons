package DungeonsAndDragons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;

public class Abilities extends RPGCharacterSheet {

    private static Integer[] d20Rolls = new Integer[6];

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
     * Creates new Stage for user to add their ability scores from a pre-generated list of random D20 rolls
     * @param continueButton Button that will allow continuation on next steps
     * @param characterSheet Character that they are changing the Ability scores to.
     */
    protected static void chooseAbilities(Button continueButton, CharacterSheet characterSheet) {
        Stage chooseAbilities = new Stage();
        chooseAbilities.setResizable(false);
        chooseAbilities.setTitle("Choose Abilities");
        VBox abilities = new VBox(20);
        abilities.setPadding(new Insets(10, 10, 10, 10));
        abilities.setAlignment(Pos.TOP_LEFT);
        HBox horizontal = new HBox();
        horizontal.setAlignment(Pos.CENTER);
        VBox rollsBox = new VBox(10);
        rollsBox.setAlignment(Pos.CENTER);
        ChoiceBox<Integer> rolls = new ChoiceBox();
        Label selectChoice = new Label("Choice Selection");
        selectChoice.setWrapText(true);

        Label error = new Label("You have selected two of the same rolls for different abilities, please update your selection");
        error.setWrapText(true);
        error.setVisible(false);
        error.setTextFill(Color.RED);

//        String[] abilityNames = {"Charisma, ""Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        if (d20Rolls[0]==null) {
            for (int i = 0; i < 6; i++) {
                d20Rolls[i] = d20Roll();
            }
        }
        Label diceRolls = new Label("Your D20 Rolls : " + d20Rolls[0] + " | " + d20Rolls[1] + " | " + d20Rolls[2] + " | " + d20Rolls[3] + " | " + d20Rolls[4] + " | " + d20Rolls[5] + " | \nChoose your ability scores.");


        rolls.setItems(FXCollections.observableArrayList(d20Rolls[0], d20Rolls[1], d20Rolls[2], d20Rolls[3], d20Rolls[4], d20Rolls[5]));
        ObservableList<Integer> rollList = FXCollections.observableArrayList(d20Rolls[0], d20Rolls[1], d20Rolls[2], d20Rolls[3], d20Rolls[4], d20Rolls[5]);
        ChoiceBox<Integer> charismaRolls = new ChoiceBox(rollList);
        charismaRolls.setMinWidth(50);
        ChoiceBox<Integer> strengthRolls = new ChoiceBox(rollList);
        strengthRolls.setMinWidth(50);
        ChoiceBox<Integer> dexterityRolls = new ChoiceBox(rollList);
        dexterityRolls.setMinWidth(50);
        ChoiceBox<Integer> wisdomRolls = new ChoiceBox(rollList);
        wisdomRolls.setMinWidth(50);
        ChoiceBox<Integer> intelligenceRolls = new ChoiceBox(rollList);
        intelligenceRolls.setMinWidth(50);
        ChoiceBox<Integer> constitutionRolls = new ChoiceBox(rollList);
        constitutionRolls.setMinWidth(50);

        VBox listOfRolls = new VBox(charismaRolls,strengthRolls,dexterityRolls,wisdomRolls,intelligenceRolls,constitutionRolls);
        horizontal.getChildren().addAll(abilities,listOfRolls);
        listOfRolls.setTranslateY(65);
        listOfRolls.setTranslateX(-70);
        listOfRolls.setSpacing(11);

        abilities.getChildren().add(diceRolls);
        abilities.getChildren().add(new Label("Charisma:"));
        abilities.getChildren().add(new Label("Strength:"));
        abilities.getChildren().add(new Label("Dexterity:"));
        abilities.getChildren().add(new Label("Wisdom:"));
        abilities.getChildren().add(new Label("Intelligence:"));
        abilities.getChildren().add(new Label("Constitution:"));
        abilities.getChildren().addAll(continueButton,error);

        rollsBox.getChildren().addAll(selectChoice, rolls);

        HashMap<Integer,Integer> rollsHashMap = new HashMap();
        HashMap<Integer,Integer> choicesHashMap = new HashMap<>();
        for (int i =0; i <6; i++){
            if (rollsHashMap.containsKey(d20Rolls[i])){
                rollsHashMap.replace(d20Rolls[i],rollsHashMap.get(d20Rolls[i]),rollsHashMap.get(d20Rolls[i])+1);
            }
            else {
                rollsHashMap.put(d20Rolls[i],1);
                choicesHashMap.put(d20Rolls[i],0);
            }
    }



        continueButton.setOnAction(continueAction ->{
            error.setVisible(false);
            charismaRolls.setStyle("-fx-border-color: black;");
            strengthRolls.setStyle("-fx-border-color: black;");
            dexterityRolls.setStyle("-fx-border-color: black;");
            wisdomRolls.setStyle("-fx-border-color: black;");
            intelligenceRolls.setStyle("-fx-border-color: black;");
            constitutionRolls.setStyle("-fx-border-color: black;");
            for (int i =0; i <6; i++){
                if (rollsHashMap.containsKey(d20Rolls[i])){
                    choicesHashMap.replace(d20Rolls[i],0);
                }
            }

            for (int i=0 ; i<6; i++){
                switch (i){
                    case 0:
                        //Charisma
                        choicesHashMap.replace(charismaRolls.getValue(),choicesHashMap.get(charismaRolls.getValue()),choicesHashMap.get(charismaRolls.getValue())+1);
                        if (choicesHashMap.get(charismaRolls.getValue()) > rollsHashMap.get(charismaRolls.getValue())){
                            charismaRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Charisma error\nKey: "+choicesHashMap.get(charismaRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;
                    case 1:
                        //Strength
                        choicesHashMap.replace(strengthRolls.getValue(),choicesHashMap.get(strengthRolls.getValue()),choicesHashMap.get(strengthRolls.getValue())+1);
                        if (choicesHashMap.get(strengthRolls.getValue()) > rollsHashMap.get(strengthRolls.getValue())){
                            strengthRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Strength error\nKey: "+choicesHashMap.get(strengthRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;
                    case 2:
                        //Dexterity
                        choicesHashMap.replace(dexterityRolls.getValue(),choicesHashMap.get(dexterityRolls.getValue()),choicesHashMap.get(dexterityRolls.getValue())+1);
                        if (choicesHashMap.get(dexterityRolls.getValue()) > rollsHashMap.get(dexterityRolls.getValue())){
                            dexterityRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Dexterity error\nKey: "+choicesHashMap.get(dexterityRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;

                    case 3:
                        //Wisdom
                        choicesHashMap.replace(wisdomRolls.getValue(),choicesHashMap.get(wisdomRolls.getValue()),choicesHashMap.get(wisdomRolls.getValue())+1);
                        if (choicesHashMap.get(wisdomRolls.getValue()) > rollsHashMap.get(wisdomRolls.getValue())){
                            wisdomRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Wisdom error\nKey: "+choicesHashMap.get(wisdomRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;

                    case 4:
                        //Intelligence
                        choicesHashMap.replace(intelligenceRolls.getValue(),choicesHashMap.get(intelligenceRolls.getValue()),choicesHashMap.get(intelligenceRolls.getValue())+1);
                        if (choicesHashMap.get(intelligenceRolls.getValue()) > rollsHashMap.get(intelligenceRolls.getValue())){
                            intelligenceRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Intelligence error\nKey: "+choicesHashMap.get(intelligenceRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;

                    case 5:
                        //Constitution
                        choicesHashMap.replace(constitutionRolls.getValue(),choicesHashMap.get(constitutionRolls.getValue()),choicesHashMap.get(constitutionRolls.getValue())+1);
                        if (choicesHashMap.get(constitutionRolls.getValue()) > rollsHashMap.get(constitutionRolls.getValue())){
                            constitutionRolls.setStyle("-fx-border-color: red;");
                            System.out.println("Constitution error\nKey: "+choicesHashMap.get(constitutionRolls.getValue()));
                            error.setVisible(true);
                        }
                        break;

                }
            }

            if (!error.isVisible()){
                System.out.println("Move on");
                characterSheet.setCharismaScore(charismaRolls.getValue()+ characterSheet.getCharismaScore());
                characterSheet.setCharismaMod(findAbilityMod(characterSheet.getConstitutionScore()));

                characterSheet.setStrengthScore(strengthRolls.getValue()+ characterSheet.getStrengthScore());
                characterSheet.setStrengthMod(findAbilityMod(characterSheet.getStrengthScore()));

                characterSheet.setDexterityScore(dexterityRolls.getValue()+ characterSheet.getDexterityScore());
                characterSheet.setDexterityMod(findAbilityMod(characterSheet.getDexterityScore()));

                characterSheet.setWisdomScore(wisdomRolls.getValue()+ characterSheet.getWisdomScore());
                characterSheet.setWisdomMod(findAbilityMod(characterSheet.getWisdomScore()));

                characterSheet.setIntelligenceScore(intelligenceRolls.getValue()+ characterSheet.getIntelligenceScore());
                characterSheet.setIntelligenceMod(findAbilityMod(characterSheet.getIntelligenceScore()));

                characterSheet.setConstitutionScore(constitutionRolls.getValue()+ characterSheet.getConstitutionScore());
                characterSheet.setConstitutionMod(findAbilityMod(characterSheet.getConstitutionScore()));

                chooseAbilities.close();
            }

        });


        Scene scene = new Scene(horizontal,350,400);
        chooseAbilities.setScene(scene);
        chooseAbilities.initModality(Modality.APPLICATION_MODAL);
        chooseAbilities.initStyle(StageStyle.TRANSPARENT);
        horizontal.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        chooseAbilities.showAndWait();




    }



    /**
     * Updates the abilities scores and their respected modifiers
     * @param abilities VBox that the list of Abilities is stored in
     * @param mainCharacter Character that has the Ability Score and Modifier information
     */
    protected static void updateAbilities(VBox abilities, CharacterSheet mainCharacter){
        abilities.setTranslateY(12);
        abilities.setMaxHeight(150);
        abilities.setPadding(new Insets(10,10,10,10));
        Label charisma = new Label("Charisma: " );
        Label strength = new Label("Strength: " );
        Label dexterity = new Label("Dexterity: " );
        Label wisdom = new Label("Wisdom: " );
        Label intelligence = new Label("Intelligence: " );
        Label constitution = new Label("Constitution: " );
        VBox abilityNames = new VBox(5);
        VBox abilityScores = new VBox(5);
        abilityNames.getChildren().addAll(charisma, strength, dexterity, wisdom, intelligence,constitution);
        abilityScores.getChildren().addAll(
                new Label(mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod()), new Label(mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod()), new Label(mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod()), new Label(mainCharacter.getWisdomScore() + " / " + mainCharacter.getWisdomMod()),new Label(mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod()), new Label( mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod()));
        HBox listOfAbilities = new HBox(5);
        listOfAbilities.getChildren().addAll(abilityNames,abilityScores);

        abilities.getChildren().set(1,listOfAbilities);


    }
}
