package DungeonsAndDragons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import static javafx.application.Application.launch;

public class Tester extends Application {

    public static void main(String[] args) {
//        launch(args);

        AtomicInteger cantripCounter = new AtomicInteger(0);
        for (int i =0; i<10 ; i++){
            cantripCounter.getAndAdd(1);
            System.out.println(cantripCounter);
        }




    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i).toString());
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        CharacterSheet mainCharacter = new CharacterSheet();
        mainCharacter.setCharacterClass("Bard");
        Stage stage = new Stage();
        Bard bard = new Bard(mainCharacter);
        bard.addLevel(stage,6,6);
        stage.initStyle(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }
}

