package DungeonsAndDragons.MainCharacter;

import com.mysql.cj.util.TestUtils;
import de.saxsys.javafx.test.JfxRunner;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;


import javax.swing.*;

import static org.junit.Assert.*;

public class RPGCharacterSheetTest extends ApplicationTest {

   // Tests for abilityAddition()
    @Test
    /**
     * Test Cases:
     * 1.) Providing Charisma Ability score that after the addition, is less than one
     * 2.) Providing Charisma Ability score that after the addition, would be between/ including 1-30
     * 3.)Providing Charisma Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionCharisma() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setCharismaScore(-2);
        characterSheet.setCharismaMod(-2);
        System.out.println("1.) Charisma Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,1,2);
        int expectedCharismaScore = 0;
        int expectedCharismaMod = -6;
        assertEquals(expectedCharismaScore, characterSheet.getCharismaScore());
        assertEquals(expectedCharismaMod,characterSheet.getCharismaMod());

        characterSheet.setCharismaScore(28);
        characterSheet.setCharismaMod(28);
        System.out.println("\n2.) Charisma Test\nSet information:Score = 28 | Modifier = 28");
        expectedCharismaScore = 30;
        expectedCharismaMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,1,2);
        assertEquals(expectedCharismaScore, characterSheet.getCharismaScore());
        assertEquals(expectedCharismaMod,characterSheet.getCharismaMod());

        characterSheet.setCharismaScore(31);
        characterSheet.setCharismaMod(31);
        System.out.println("\n3.) Charisma Test\nSet information:Score = 31 | Modifier = 31");
        expectedCharismaScore = 30;
        expectedCharismaMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,1,2);
        assertEquals(expectedCharismaScore, characterSheet.getCharismaScore());
        assertEquals(expectedCharismaMod,characterSheet.getCharismaMod());

    }

    @Test
    /**
     * Test Cases:
     * 1.) Providing Strength Ability score that after the addition, is less than one
     * 2.) Providing Strength Ability score that after the addition, would be between/ including 1-30
     * 3.) Providing Strength Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionStrength() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setStrengthScore(-2);
        characterSheet.setStrengthMod(-2);
        System.out.println("1.) Strength Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,2,2);
        int expectedStrengthScore = 0;
        int expectedStrengthMod = -6;
        assertEquals(expectedStrengthScore, characterSheet.getStrengthScore());
        assertEquals(expectedStrengthMod,characterSheet.getStrengthMod());

        characterSheet.setStrengthScore(28);
        characterSheet.setStrengthMod(28);
        System.out.println("\n2.) Strength Test\nSet information:Score = 28 | Modifier = 28");
        expectedStrengthScore = 30;
        expectedStrengthMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,2,2);
        assertEquals(expectedStrengthScore, characterSheet.getStrengthScore());
        assertEquals(expectedStrengthMod,characterSheet.getStrengthMod());

        characterSheet.setStrengthScore(31);
        characterSheet.setStrengthMod(31);
        System.out.println("\n3.) Strength Test\nSet information:Score = 31 | Modifier = 31");
        expectedStrengthScore = 30;
        expectedStrengthMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,2,2);
        assertEquals(expectedStrengthScore, characterSheet.getStrengthScore());
        assertEquals(expectedStrengthMod,characterSheet.getStrengthMod());

    }


    @Test
    /**
     * Test Cases:
     * 1.) Providing Dexterity Ability score that after the addition, is less than one
     * 2.) Providing Dexterity Ability score that after the addition, would be between/ including 1-30
     * 3.) Providing Dexterity Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionDexterity() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setDexterityScore(-2);
        characterSheet.setDexterityMod(-2);
        System.out.println("1.) Dexterity Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,3,2);
        int expectedDexterityScore = 0;
        int expectedDexterityMod = -6;
        assertEquals(expectedDexterityScore, characterSheet.getDexterityScore());
        assertEquals(expectedDexterityMod,characterSheet.getDexterityMod());

        characterSheet.setDexterityScore(28);
        characterSheet.setDexterityMod(28);
        System.out.println("\n2.) Dexterity Test\nSet information:Score = 28 | Modifier = 28");
        expectedDexterityScore = 30;
        expectedDexterityMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,3,2);
        assertEquals(expectedDexterityScore, characterSheet.getDexterityScore());
        assertEquals(expectedDexterityMod,characterSheet.getDexterityMod());

        characterSheet.setDexterityScore(31);
        characterSheet.setDexterityMod(31);
        System.out.println("\n3.) Dexterity Test\nSet information:Score = 31 | Modifier = 31");
        expectedDexterityScore = 30;
        expectedDexterityMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,3,2);
        assertEquals(expectedDexterityScore, characterSheet.getDexterityScore());
        assertEquals(expectedDexterityMod,characterSheet.getDexterityMod());

    }

    @Test
    /**
     * Test Cases:
     * 1.) Providing Wisdom Ability score that after the addition, is less than one
     * 2.) Providing Wisdom Ability score that after the addition, would be between/ including 1-30
     * 3.) Providing Wisdom Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionWisdom() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setWisdomScore(-2);
        characterSheet.setWisdomMod(-2);
        System.out.println("1.) Wisdom Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,4,2);
        int expectedWisdomScore = 0;
        int expectedWisdomMod = -6;
        assertEquals(expectedWisdomScore, characterSheet.getWisdomScore());
        assertEquals(expectedWisdomMod,characterSheet.getWisdomMod());

        characterSheet.setWisdomScore(28);
        characterSheet.setWisdomMod(28);
        System.out.println("\n2.) Wisdom Test\nSet information:Score = 28 | Modifier = 28");
        expectedWisdomScore = 30;
        expectedWisdomMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,4,2);
        assertEquals(expectedWisdomScore, characterSheet.getWisdomScore());
        assertEquals(expectedWisdomMod,characterSheet.getWisdomMod());

        characterSheet.setWisdomScore(31);
        characterSheet.setWisdomMod(31);
        System.out.println("\n3.) Wisdom Test\nSet information:Score = 31 | Modifier = 31");
        expectedWisdomScore = 30;
        expectedWisdomMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,4,2);
        assertEquals(expectedWisdomScore, characterSheet.getWisdomScore());
        assertEquals(expectedWisdomMod,characterSheet.getWisdomMod());

    }

    @Test
    /**
     * Test Cases:
     * 1.) Providing Intelligence Ability score that after the addition, is less than one
     * 2.) Providing Intelligence Ability score that after the addition, would be between/ including 1-30
     * 3.) Providing Intelligence Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionIntelligence() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setIntelligenceScore(-2);
        characterSheet.setIntelligenceMod(-2);
        System.out.println("1.) Intelligence Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,5,2);
        int expectedIntelligenceScore = 0;
        int expectedIntelligenceMod = -6;
        assertEquals(expectedIntelligenceScore, characterSheet.getIntelligenceScore());
        assertEquals(expectedIntelligenceMod,characterSheet.getIntelligenceMod());

        characterSheet.setIntelligenceScore(28);
        characterSheet.setIntelligenceMod(28);
        System.out.println("\n2.) Intelligence Test\nSet information:Score = 28 | Modifier = 28");
        expectedIntelligenceScore = 30;
        expectedIntelligenceMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,5,2);
        assertEquals(expectedIntelligenceScore, characterSheet.getIntelligenceScore());
        assertEquals(expectedIntelligenceMod,characterSheet.getIntelligenceMod());

        characterSheet.setIntelligenceScore(31);
        characterSheet.setIntelligenceMod(31);
        System.out.println("\n3.) Intelligence Test\nSet information:Score = 31 | Modifier = 31");
        expectedIntelligenceScore = 30;
        expectedIntelligenceMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,5,2);
        assertEquals(expectedIntelligenceScore, characterSheet.getIntelligenceScore());
        assertEquals(expectedIntelligenceMod,characterSheet.getIntelligenceMod());

    }

    @Test
    /**
     * Test Cases:
     * 1.) Providing Constitution Ability score that after the addition, is less than one
     * 2.) Providing Constitution Ability score that after the addition, would be between/ including 1-30
     * 3.) Providing Constitution Ability score that after the addition, would be greater than 30
     */
    public void testAbilityAdditionConstitution() {
        JFXPanel fxPanel = new JFXPanel();
        CharacterSheet characterSheet = new CharacterSheet();

        characterSheet.setConstitutionScore(-2);
        characterSheet.setConstitutionMod(-2);
        System.out.println("1.) Constitution Test\nSet information: Score = -2 | Modifier = -2");
        RPGCharacterSheet.abilityAddition(characterSheet,6,2);
        int expectedConstitutionScore = 0;
        int expectedConstitutionMod = -6;
        assertEquals(expectedConstitutionScore, characterSheet.getConstitutionScore());
        assertEquals(expectedConstitutionMod,characterSheet.getConstitutionMod());

        characterSheet.setConstitutionScore(28);
        characterSheet.setConstitutionMod(28);
        System.out.println("\n2.) Constitution Test\nSet information:Score = 28 | Modifier = 28");
        expectedConstitutionScore = 30;
        expectedConstitutionMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,6,2);
        assertEquals(expectedConstitutionScore, characterSheet.getConstitutionScore());
        assertEquals(expectedConstitutionMod,characterSheet.getConstitutionMod());

        characterSheet.setConstitutionScore(31);
        characterSheet.setConstitutionMod(31);
        System.out.println("\n3.) Constitution Test\nSet information:Score = 31 | Modifier = 31");
        expectedConstitutionScore = 30;
        expectedConstitutionMod = 10;
        RPGCharacterSheet.abilityAddition(characterSheet,6,2);
        assertEquals(expectedConstitutionScore, characterSheet.getConstitutionScore());
        assertEquals(expectedConstitutionMod,characterSheet.getConstitutionMod());

    }



    //Tests for findAbilityMod()
    @Test
    /**
     * Test Cases:
     * 1.) Provide findAbilityMod() with int that is less than 1
     * 2.) Provide findAbilityMod() with int that is between and includes 1-30 (Sanity)
     * 3.) Provide findAbilityMod() with int that is greater than 30
     * 4.) Provide findAbilityMod() with int that is equal to 1( Edge)
     * 5.) Provide findAbilityMod() with int that is equal to 30 (Edge)
     */
    public void findAbilityModTest() {
        JFXPanel fxPanel = new JFXPanel();

        System.out.println("Test Case 1 : Input 0 ~ Expected -6");
        assertEquals(-6, RPGCharacterSheet.findAbilityMod(0));

        System.out.println("Test Case 1 : Input 20 ~ Expected 5");
        assertEquals(5, RPGCharacterSheet.findAbilityMod(20));

        System.out.println("Test Case 3 : Input 31 ~ Expected 10");
        assertEquals(10, RPGCharacterSheet.findAbilityMod(31));

        System.out.println("Test Case 4 : Input 5 ~ Expected -5");
        assertEquals(-5, RPGCharacterSheet.findAbilityMod(1));

        System.out.println("Test Case 5 : Input 30 ~ Expected 10");
        assertEquals(10, RPGCharacterSheet.findAbilityMod(30));

    }


    //Tests checkIfArmorIsNotProficient()
    @Test
    /**
     * Test Cases
     * 1.) Method is provided an empty String Array (False)
     * 2.) Method is provided an item that is not in the String array (False)
     * 3.) Method is provided an item that is in the String array (True)
     * 4.) Method is provided a valid String Array, but the String is null (False)
     * 5.) Method is provided a valid String Array, but the String is empty (False)
     * 6.) Method is provided a empty String Array, but the String is empty (False)
     * 7.) Method is provided a valid String Array and the String is in the Array, but the case of characters are incorrect (False)
     * 8.) Method is provided an empty String Array and the String is null (False)
     */
    public void checkIfArmorIsNotProficientTest() {
        String[] listOfArmor = {"Leather", "Chain Shirt", "Sword","Weapons"};
        String armor = "";


        System.out.println("Test Case 1: Empty Array with valid String");
        armor = "Breastplate";
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(new String[30],armor));

        System.out.println("Test Case 2: Valid String Array, but the string is not listed in the array");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(listOfArmor,armor));

        System.out.println("Test Case 3: Valid String Array and the String is in the Array");
        armor = "Leather";
        assertEquals(true, RPGCharacterSheet.checkIfArmorIsNotProficient(listOfArmor,armor));

        System.out.println("Test Case 4: Valid String Array and the String is null");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(listOfArmor,null));

        System.out.println("Test Case 5: Valid String Array and the String is empty");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(listOfArmor,""));

        System.out.println("Test Case 6: Empty String Array and the String is empty");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(new String[30],""));

        System.out.println("Test Case 7: Valid String Array and the String is in the array, but the string case does not match the case that is in the array");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(listOfArmor,"leather"));

        System.out.println("Test Case 8: Empty String array and a null String");
        assertEquals(false, RPGCharacterSheet.checkIfArmorIsNotProficient(new String[30],null));

    }

    @Test
    public void testStart(){
        new RPGCharacterSheetTest();
        //TODO Need to traverse GUI
    }

    //Test findArrayPosition()

    /**
     * Test Cases:
     * 1.) Method is provided a valid string that is listed in the Valid Object Array (Sanity)
     * 2.) Method is provided an empty String and a valid Object (String) Array (-1)
     * 3.) Method is provided a null String and a valid Object (String) Array (-1)
     * 4.) Method is provided a valid String and an empty Object (String) Array (-1)
     * 5.) Method is provided a valid Sting and an empty Object (Integer) Array (-1)
     * 6.) Method is provided a valid String and a valid Object (Integer) Array (-1)
     * 7.) Method is provided an empty String and a empty Object (String) Array (-1)
     * 8.) Method is provided a null String and a null Object (String) Array (Sanity)
     * 9.) Method is provided a null String and a valid Object (String) Array that has one index set to Null (Sanity)
     * 10.) Method is provided a null String and a valid Object (Integer) Array that has one index set to Null (Sanity)
     * 11.) Method is provided a valid String and a valid Object (String) Array but the case of the strings do not match (-1)
     */
    @Test
    public void findArrayPositionTest() {
        String[] emptyStringArray = {};
        Integer[] emptyIntegerArray = {};

        String[] validStringArrayWithNull = {"Blue","Purple", "Yellow",null};
        String[] validStringArrayWithoutNull = {"Blue","Purple", "Yellow"};
        Integer[] validIntegerArray = {1,2,3,null};

        String[] nullStringArray = new String[30];
        Integer[] nullIntegerArray = new Integer[30];

        System.out.println("Test Case 1: Method is provided a valid string that is listed in the Valid Object Array (Sanity)");
        assertEquals(1, RPGCharacterSheet.findArrayPosition("Purple", validStringArrayWithoutNull));

        System.out.println("Test Case 2: Method is provided an empty String and a valid Object (String) Array (-1))");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("", validStringArrayWithoutNull));

        System.out.println("Test Case 3:Method is provided a null String and a valid Object (String) Array (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition(null, validStringArrayWithoutNull));

        System.out.println("Test Case 4: Method is provided a valid String and an empty Object (String) Array (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("Purple", emptyStringArray));

        System.out.println("Test Case 5: Method is provided a valid Sting and an empty Object (Integer) Array (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("Purple", emptyIntegerArray));

        System.out.println("Test Case 6: Method is provided a valid String and a valid Object (Integer) Array (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("Purple", validIntegerArray));

        System.out.println("Test Case 7: Method is provided an empty String and a empty Object (String) Array (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("", emptyStringArray));

        System.out.println("Test Case 8: Method is provided a null String and a null Object (String) Array (Sanity)");
        assertEquals(0, RPGCharacterSheet.findArrayPosition(null, nullStringArray));

        System.out.println("Test Case 9: Method is provided a null String and a valid Object (String) Array that has one index set to Null (Sanity)");
        assertEquals(3, RPGCharacterSheet.findArrayPosition(null, validStringArrayWithNull));

        System.out.println("Test Case 10: Method is provided a null String and a valid Object (Integer) Array that has one index set to Null (Sanity)");
        assertEquals(3, RPGCharacterSheet.findArrayPosition(null, validIntegerArray));

        System.out.println("Test Case 11: Method is provided a valid String and a valid Object (String) Array but the case of the strings do not match (-1)");
        assertEquals(-1, RPGCharacterSheet.findArrayPosition("purple", validStringArrayWithoutNull));

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        com.sun.javafx.application.PlatformImpl.startup(()->{});
        Scene scene = new Scene(new Pane(),600,600);
        Stage stage =new Stage();
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }
}