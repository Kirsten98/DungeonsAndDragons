package DungeonsAndDragons;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Abilities extends RPGCharacterSheet {

    private static int[] d20Rolls = new int[6];

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
        abilities.setPadding(new Insets(10,10,10,10));
        abilities.setAlignment(Pos.TOP_CENTER);
        HBox horizontal = new HBox();
        horizontal.setAlignment(Pos.CENTER);
        VBox rollsBox = new VBox(10);
        rollsBox.setAlignment(Pos.CENTER);
        ChoiceBox<Integer> rolls = new ChoiceBox();
        Label selectChoice = new Label("Choice Selection");
        selectChoice.setWrapText(true);
        rollsBox.getChildren().addAll(selectChoice,rolls);
        horizontal.getChildren().addAll(abilities,rollsBox);

//        String[] abilityNames = {"Charisma, ""Strength", "Dexterity", "Wisdom", "Intelligence", "Constitution"};
        if (d20Rolls[0] == 0){
            for (int i = 0; i < 6; i++) {
                d20Rolls[i] =d20Roll();
            }
        }
        Label diceRolls = new Label("Your D20 Rolls : " + d20Rolls[0] + " | " + d20Rolls[1] + " | " + d20Rolls[2] + " | " + d20Rolls[3] + " | " + d20Rolls[4] + " | " + d20Rolls[5] + " | \nChoose your ability scores.");


        rolls.setItems(FXCollections.observableArrayList(d20Rolls[0],d20Rolls[1],d20Rolls[2],d20Rolls[3],d20Rolls[4],d20Rolls[5]));
        abilities.getChildren().add(diceRolls);
        abilities.getChildren().add(new Label("Charisma"));
        abilities.getChildren().add(new Label("Strength"));
        abilities.getChildren().add(new Label("Dexterity"));
        abilities.getChildren().add(new Label("Wisdom"));
        abilities.getChildren().add(new Label("Intelligence"));
        abilities.getChildren().add(new Label("Constitution"));
        rolls.setOnAction(charisma -> {

            // Charisma setup
            try {
                characterSheet.setCharismaScore(rolls.getValue() + characterSheet.getCharismaScore());
                characterSheet.setCharismaMod(findAbilityMod(characterSheet.getCharismaScore()));
                rolls.getItems().remove(rolls.getValue());
                abilities.getChildren().set(1,new Label("Charisma : " + characterSheet.getCharismaScore() + "/ " + characterSheet.getCharismaMod()));

                // Strength Set up

                rolls.setOnAction(strength -> {
                    try {
                        characterSheet.setStrengthScore(rolls.getValue() + characterSheet.getStrengthScore());
                        characterSheet.setStrengthMod(findAbilityMod(characterSheet.getStrengthScore()));
                        rolls.getItems().remove(rolls.getValue());
                        abilities.getChildren().set(2,new Label("Strength : " + characterSheet.getStrengthScore() + "/ " + characterSheet.getStrengthMod()));

                        // Dexterity setup
                        rolls.setOnAction(dexterity -> {
                            try {
                                characterSheet.setDexterityScore(rolls.getValue() + characterSheet.getDexterityScore());
                                characterSheet.setDexterityMod(findAbilityMod(characterSheet.getDexterityScore()));
                                rolls.getItems().remove(rolls.getValue());
                                abilities.getChildren().set(3,new Label("Dexterity : " + characterSheet.getDexterityScore() + "/ " + characterSheet.getDexterityMod()));

                                //Wisdom setup
                                rolls.setOnAction(wisdom -> {
                                    try {
                                        characterSheet.setWisdomScore(rolls.getValue() + characterSheet.getWisdomScore());
                                        characterSheet.setWisdomMod(findAbilityMod(characterSheet.getWisdomScore()));
                                        rolls.getItems().remove(rolls.getValue());
                                        abilities.getChildren().set(4,new Label("Wisdom : " + characterSheet.getWisdomScore() + "/ " + characterSheet.getWisdomMod()));

                                        //Intelligence setup
                                        rolls.setOnAction(intelligence -> {
                                            try {
                                                characterSheet.setIntelligenceScore(rolls.getValue() + characterSheet.getIntelligenceScore());
                                                characterSheet.setIntelligenceMod(findAbilityMod(characterSheet.getIntelligenceScore()));
                                                rolls.getItems().remove(rolls.getValue());
                                                abilities.getChildren().set(5,new Label("Intelligence : " + characterSheet.getIntelligenceScore() + "/ " + characterSheet.getIntelligenceMod()));
                                                // Constitution setup
                                                rolls.setOnAction(constitution -> {
                                                    try {
                                                        characterSheet.setConstitutionScore(rolls.getValue()+ characterSheet.getConstitutionScore());

                                                        characterSheet.setConstitutionMod(findAbilityMod(characterSheet.getConstitutionScore()));
                                                        rolls.getItems().remove(rolls.getValue());
                                                        abilities.getChildren().set(6,new Label("Constitution : " + characterSheet.getConstitutionScore() + "/ " + characterSheet.getConstitutionMod()));
                                                        abilities.getChildren().add(continueButton);
                                                        horizontal.getChildren().remove(rolls);
                                                        rolls.setDisable(true);
                                                        continueButton.setOnAction(close -> chooseAbilities.close());
                                                    } catch (NullPointerException Con) {
                                                    }
                                                });
                                            }catch (NullPointerException Intelligence){}});
                                    }catch (NullPointerException Wisdom){}});
                            }catch (NullPointerException Dexterity){}});
                    } catch (NullPointerException Strength){}});
            } catch ( NullPointerException Charisma){}});

        Scene scene = new Scene(horizontal,350,350);
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
        abilities.setStyle("-fx-border-color: black;");
        abilities.setMaxHeight(150);
        abilities.setPadding(new Insets(10,10,10,10));
        Label charisma = new Label("Charisma: " + mainCharacter.getCharismaScore() + " / " + mainCharacter.getCharismaMod());
        Label strength = new Label("Strength: " + mainCharacter.getStrengthScore() + " / " + mainCharacter.getStrengthMod());
        Label dexterity = new Label("Dexterity: " + mainCharacter.getDexterityScore() + " / " + mainCharacter.getDexterityMod());
        Label wisdom = new Label("Wisdom: " + mainCharacter.getWisdomScore() + " / " + mainCharacter.getWisdomMod());
        Label intelligence = new Label("Intelligence: " + mainCharacter.getIntelligenceScore() + " / " + mainCharacter.getIntelligenceMod());
        Label constitution = new Label("Constitution: " + mainCharacter.getConstitutionScore() + " / " + mainCharacter.getConstitutionMod());
        abilities.getChildren().set(1,charisma);
        abilities.getChildren().set(2,strength);
        abilities.getChildren().set(3,dexterity);
        abilities.getChildren().set(4,wisdom);
        abilities.getChildren().set(5,intelligence);
        abilities.getChildren().set(6,constitution);

    }
}
