package DungeonsAndDragons;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Classes {

    private static Label label = new Label("");

    /**
     * Allows user to select the class of their character though a list of possible Classes
     * @return String of the Race the user chose
     */
    protected static String chooseClass(Button continueButton, CharacterSheet mainCharacter) {
        // "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"

        label.setText("");

        VBox layout=new VBox(20);
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        layout.setEffect(shadow);
        Scene scene = new Scene(layout, 400, 375);
        Stage classStage = new Stage();
        classStage.setScene(scene);
        classStage.setResizable(false);

        layout.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);

        continueButton.setOnAction(e ->{
            if (mainCharacter.getCharacterClass().equals("Barbarian")) {
                Barbarian barbarianCharacter = new Barbarian(mainCharacter);
                barbarianCharacter.chooseArmor(classStage); }
            if (mainCharacter.getCharacterClass().equals("Bard")) {
                Bard bardCharacter = new Bard(mainCharacter);
                bardCharacter.chooseArmor(classStage);
              }
        });
        continueButton.setDisable(true);

        Label chooseClass = new Label("Choose your class.");
        Button barbarian = new Button("Barbarian");
        barbarian.setOnAction(event -> {
            mainCharacter.setCharacterClass("Barbarian");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);

        });
        Button bard = new Button("Bard");
        bard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Bard");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button cleric = new Button("Cleric");
        cleric.setOnAction(event -> {
            mainCharacter.setCharacterClass("Cleric");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button druid = new Button("Druid");
        druid.setOnAction(event -> {
            mainCharacter.setCharacterClass("Druid");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button fighter = new Button("Fighter");
        fighter.setOnAction(event -> {
            mainCharacter.setCharacterClass("Fighter");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button monk = new Button("Monk");
        monk.setOnAction(event -> {
            mainCharacter.setCharacterClass("Monk");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button paladin = new Button("Paladin");
        paladin.setOnAction(event -> {
            mainCharacter.setCharacterClass("Paladin");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button ranger = new Button("Ranger");
        ranger.setOnAction(event -> {
            mainCharacter.setCharacterClass("Ranger");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button rogue = new Button("Rogue");
        rogue.setOnAction(event -> {
            mainCharacter.setCharacterClass("Rogue");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button sorcerer = new Button("Sorcerer");
        sorcerer.setOnAction(event -> {
            mainCharacter.setCharacterClass("Sorcerer");
           label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button warlock = new Button("Warlock");
        warlock.setOnAction(event -> {
            mainCharacter.setCharacterClass("Warlock");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });
        Button wizard = new Button("Wizard");
        wizard.setOnAction(event -> {
            mainCharacter.setCharacterClass("Wizard");
            label.setText("You have chosen " + mainCharacter.getCharacterClass());
            continueButton.setDisable(false);
        });

        ButtonBar row1 = new ButtonBar();
        row1.getButtons().addAll(barbarian,bard,cleric);
        row1.setTranslateX(-75);

        ButtonBar row2 = new ButtonBar();
        row2.getButtons().addAll(druid,fighter,monk);
        row2.setTranslateX(-75);

        ButtonBar row3 = new ButtonBar();
        row3.getButtons().addAll(paladin,ranger,rogue);
        row3.setTranslateX(-75);

        ButtonBar row4 = new ButtonBar();
        row4.getButtons().addAll(sorcerer,warlock,wizard);
        row4.setTranslateX(-75);

        layout.getChildren().addAll(chooseClass,row1,row2,row3,row4,label,continueButton);

        layout.setAlignment(Pos.CENTER);
        classStage.initStyle(StageStyle.TRANSPARENT);
        classStage.initModality(Modality.APPLICATION_MODAL);
        classStage.showAndWait();

        return "Class: " + mainCharacter.getCharacterClass();

    }

    /**
     * Creates Stage for the user to set the stage that their character will be. It then calls the respected class that the user has chosen previously for the chosen amount of levels.
     * @param mainCharacter Character that they are setting the level for
     */
    protected static void setLevel(CharacterSheet mainCharacter){
        Stage setLevelStage = new Stage();
        setLevelStage.setResizable(false);
        GridPane pane = new GridPane();
        InnerShadow shadow = new InnerShadow();
        shadow.setColor(Color.gray(.5));
        pane.setEffect(shadow);
        Scene scene = new Scene(pane,450,250);

        pane.setPadding(new Insets(10,30,10,30));
        pane.setHgap(10);
        pane.setVgap(20);

        Label chooseLevel = new Label("Choose your level.");
        pane.add(chooseLevel,4,0,4,1);

        Label choice = new Label("Level: "+ mainCharacter.getLevel());
        pane.add(choice,4,3,2,1);

        Button continueButton = new Button("Continue");

        pane.add(continueButton,4,4,2,1);
        continueButton.setDisable(true);

        Integer levelNum;
        for (int i =1; i < 21 ; i++){
            levelNum =i;
            Button numButton = new Button(levelNum.toString());
            numButton.setOnAction(e->{
                choice.setText("Level: " + Integer.parseInt(numButton.getText()));
                mainCharacter.setLevel(Integer.parseInt(numButton.getText()));
                continueButton.setDisable(false);
            });

            if (i <=10){
                pane.add(numButton,i-1,1);
            }else{
                pane.add(numButton,i%11,2);
            }

        }
        continueButton.setOnAction(e->{
            if (mainCharacter.getCharacterClass().equals("Barbarian")){
                Barbarian barbarian = new Barbarian(mainCharacter);
                barbarian.addLevel(setLevelStage,Integer.parseInt(choice.getText().split(" ")[1]),1);
            }
            if (mainCharacter.getCharacterClass().equals("Bard")){
                Bard bard = new Bard(mainCharacter);
                bard.addLevel(setLevelStage,Integer.parseInt(choice.getText().split(" ")[1]),1);
            }

        });

        setLevelStage.setScene(scene);
        setLevelStage.initStyle(StageStyle.TRANSPARENT);
        pane.setStyle("-fx-border-color: black;"+
                "-fx-background-radius: 10;"+ "-fx-border-radius: 10;");
        scene.setFill(Color.TRANSPARENT);
        setLevelStage.initModality(Modality.APPLICATION_MODAL);
        setLevelStage.showAndWait();


    }
}
