package DungeonsAndDragons;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Vector;

public class Tester {

    public static void main(String[] args) {
        CharacterSheet mainCharacter = new CharacterSheet();
        mainCharacter.setCharacterClass("Barbarian");




    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i).toString());
        }
    }







}
