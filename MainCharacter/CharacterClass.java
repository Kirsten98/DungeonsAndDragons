package DungeonsAndDragons.MainCharacter;

import DungeonsAndDragons.MainCharacter.CharacterSheet;
import DungeonsAndDragons.MainCharacter.Item;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.Vector;

public class CharacterClass {

    /**
     *
     * @param character CharacterSheet that needs the Ability Modifier added to
     * @param AbilityChoice Ability choice that the modifier is adding to. 1.) Charisma 2.) Strength 3.)Dexterity 4.) Wisdom 5.)Intelligence 6.) Constitution
     * @param modifierAddtion The Value that is getting added to the Modifier
     */
    public static void abilityAddition(CharacterSheet character, String AbilityChoice, int modifierAddtion){
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
    public VBox abilityScoreImprovement(CharacterSheet character,Stage addLevelStage, int maxLevel, int startinglevel){
        Button continueButton = new Button("Continue");
        Label choice = new Label();
        choice.setWrapText(true);
        Button charisma = new Button("Charisma");
        charisma.setMinWidth(95);
        Button strength = new Button("Strength");
        strength.setMinWidth(95);
        Button dexterity = new Button("Dexterity");
        dexterity.setMinWidth(95);
        Button wisdom = new Button("Wisdom");
        wisdom.setMinWidth(95);
        Button intelligence = new Button("Intelligence");
        intelligence.setMinWidth(95);
        Button constitution = new Button("Constitution");
        constitution.setMinWidth(95);

        VBox pane = new VBox();
        Label question = new Label("Would you like to increase one ability score \nby +2 or two ability scores by +1 ");
        Button plus2 = new Button("One ability score by +2");
        Button plus1 = new Button("Two ability scores by +1");

        pane.getChildren().addAll(question,plus2, plus1);
        pane.setSpacing(20);
        pane.setAlignment(Pos.CENTER);


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
            HBox csdAbilites = new HBox(charisma,strength,dexterity);
            HBox wicAbilites = new HBox(wisdom,intelligence,constitution);
            csdAbilites.setAlignment(Pos.CENTER);
            csdAbilites.setSpacing(20);
            wicAbilites.setAlignment(Pos.CENTER);
            wicAbilites.setSpacing(20);

            pane.getChildren().addAll(csdAbilites, wicAbilites,choice,continueButton);
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
            HBox csdAbilites = new HBox(charisma,strength,dexterity);
            HBox wicAbilites = new HBox(wisdom,intelligence,constitution);
            csdAbilites.setAlignment(Pos.CENTER);
            csdAbilites.setSpacing(20);
            wicAbilites.setAlignment(Pos.CENTER);
            wicAbilites.setSpacing(20);

            pane.getChildren().addAll(csdAbilites,wicAbilites,choice,continueButton);
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
    /**
     * Takes current level and continuously adds additional level until maximum level is hit. Throughout the process it will give the users options for selection for their current level
     * @param addLevelStage Stage that will contain all Level choices
     * @param maxLevel Max level that the user has chosen
     * @param startingLevel Level that the user if currently at
     */
    public void addLevel(Stage addLevelStage, int maxLevel, int startingLevel){

    }
    /**
     *
     * @param inventory Vector of items
     * @param item item you are adding in vector, or adding quantity to already existing item
     */
    public static void checkAndAddItemQuantity(Vector<Item> inventory, Item item){
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

    /**
     *
     * @param abilityScore Takes in the Ability Score
     * @return Returns the Modifier based on the Ability Score
     */
    public static int findAbilityMod(int abilityScore) {

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

    }

    public void chooseWeapon(Stage chooseWeaponStage){

    }
}
