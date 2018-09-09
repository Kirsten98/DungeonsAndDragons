package DungeonsAndDragons;

import java.util.Vector;

public class Tester {

    public static void main(String[] args) {
        CharacterSheet character = new CharacterSheet("Q","Elf","Bard");
        Bard bard = new Bard(character);

        bard.ChooseSkillProficiencies();


 
//        for (int i =0 ; i<20; i++){
//            System.out.println(bard.D8Roll());
//        }
//        VectorPrintOut(character.weapons);

        for (int i = 0; i < character.inventory.size(); i++){
            System.out.println(i + 1 + ".) " + character.inventory.get(i).getName());
        }
        for (int i = 0; i < character.weapons.size(); i++){
            System.out.println(i + 1 + ".) " + character.weapons.get(i).getName());
        }


    }

    public static void VectorPrintOut (Vector vector){
        for (int i = 0; i < vector.size(); i++){
            System.out.println(i + 1 + ".) " + vector.get(i).toString());
        }
    }







}
