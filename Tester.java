package DungeonsAndDragons;

public class Tester {

    public static void main(String[] args) {
        CharacterSheet character = new CharacterSheet("Q","Elf","Barbarian");
        Barbarian barbarian = new Barbarian(character);

        barbarian.ChooseWeapon();

    }






}
