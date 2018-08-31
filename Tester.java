package DungeonsAndDragons;

import java.util.Vector;

public class Tester {

    public static void main(String[] args) {
        CharacterSheet character = new CharacterSheet("Q","Elf","Bard");
        Bard bard = new Bard(character);

        bard.ChooseWeapon();




    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i));
        }
    }







}
