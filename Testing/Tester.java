package DungeonsAndDragons.Testing;

import DungeonsAndDragons.MainCharacter.Barbarian;
import DungeonsAndDragons.MainCharacter.CharacterSheet;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Vector;

import static javafx.application.Application.launch;

public class Tester extends Application {

    public static void main(String[] args) {
        launch(args);



    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i).toString());
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        CharacterSheet mainCharacter = new CharacterSheet();
        mainCharacter.setCharacterClass("Barbarian");
        Stage stage = new Stage();
        Barbarian barbarian = new Barbarian(mainCharacter);

        barbarian.addLevel(stage,20,16);
//        Abilities.chooseAbilities(new Button("Continue Button"),mainCharacter);

//        bard.addLevel(stage,2,1);
        stage.initStyle(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }
}

