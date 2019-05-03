package DungeonsAndDragons.MainCharacter;

import java.util.Scanner;
import java.util.Vector;

public class Spells {


    /** Creates Vectors for each Level for the Bard Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> bardSpellSetUp(int level){
        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Blade Ward");
        cantripList.add("Dancing Lights");
        cantripList.add("Friends");
        cantripList.add("Light");
        cantripList.add("Mage Hand");
        cantripList.add("Mending");
        cantripList.add("Message");
        cantripList.add("Minor Illusion");
        cantripList.add("Prestigitation");
        cantripList.add("True Strike");
        cantripList.add("Vicious Mockery");

        firstLevelSpells.add("Animal Friendship");
        firstLevelSpells.add("Bane");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Comprehend Languages");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Disguise Self");
        firstLevelSpells.add("Dissonant Whispers");
        firstLevelSpells.add("Faerie Fire");
        firstLevelSpells.add("Feather Fall");
        firstLevelSpells.add("Healing Word");
        firstLevelSpells.add("Heroism");
        firstLevelSpells.add("Identify");
        firstLevelSpells.add("Illusory Script");
        firstLevelSpells.add("Longstrider");
        firstLevelSpells.add("Silent Image");
        firstLevelSpells.add("Sleep");
        firstLevelSpells.add("Speak with Animals");
        firstLevelSpells.add("Tasha's Hideous Laughter");
        firstLevelSpells.add("Thunderwave");
        firstLevelSpells.add("Unseen Servant");

        secondLevelSpells.add("Animal Messenger");
        secondLevelSpells.add("Blindness/Deafness");
        secondLevelSpells.add("Calm Emotions");
        secondLevelSpells.add("Cloud of Daggers");
        secondLevelSpells.add("Crown of Madness");
        secondLevelSpells.add("Detect Thoughts");
        secondLevelSpells.add("Enhance Ability");
        secondLevelSpells.add("Enthrall");
        secondLevelSpells.add("Heat Metal");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Invisibility");
        secondLevelSpells.add("Knock");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Locate Animals or Plants");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Magic Mouth");
        secondLevelSpells.add("Phantasmal Force");
        secondLevelSpells.add("See Invisibility");
        secondLevelSpells.add("Shatter");
        secondLevelSpells.add("Silence");
        secondLevelSpells.add("Suggestion");
        secondLevelSpells.add("Zone of Truth");

        thirdLevelSpells.add("Bestow Curse");
        thirdLevelSpells.add("Clairvoyance");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Fear");
        thirdLevelSpells.add("Feign Death");
        thirdLevelSpells.add("Glyph of Warding");
        thirdLevelSpells.add("Hypnotic Pattern");
        thirdLevelSpells.add("Leomund's Tiny Hut");
        thirdLevelSpells.add("Major Image");
        thirdLevelSpells.add("Nondetection");
        thirdLevelSpells.add("Plant Growth");
        thirdLevelSpells.add("Sending");
        thirdLevelSpells.add("Speak with Dead");
        thirdLevelSpells.add("Speak with Plants");
        thirdLevelSpells.add("Stinking Clouds");
        thirdLevelSpells.add("Tongues");

        fourthLevelSpells.add("Compulsion");
        fourthLevelSpells.add("Confusion");
        fourthLevelSpells.add("Dimension Door");
        fourthLevelSpells.add("Freedom of Movement");
        fourthLevelSpells.add("Greater Invisibility");
        fourthLevelSpells.add("Hallucinatory Terrain");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Polymorph");

        fifthLevelSpells.add("Animate Objects");
        fifthLevelSpells.add("Awaken");
        fifthLevelSpells.add("Dominate Person");
        fifthLevelSpells.add("Dream");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Greater Restoration");
        fifthLevelSpells.add("Hold Monster");
        fifthLevelSpells.add("Legend Lore");
        fifthLevelSpells.add("Mass Cure Wounds");
        fifthLevelSpells.add("Mislead");
        fifthLevelSpells.add("Modify Memory");
        fifthLevelSpells.add("Planar Binding");
        fifthLevelSpells.add("Raise Dead");
        fifthLevelSpells.add("Scrying");
        fifthLevelSpells.add("Seeming");
        fifthLevelSpells.add("Teleportation Circle");

        sixthLevelSpells.add("Eyebite");
        sixthLevelSpells.add("Find the Path");
        sixthLevelSpells.add("Guards and Wards");
        sixthLevelSpells.add("Mass Suggestion");
        sixthLevelSpells.add("Otto's Irresistible Dance");
        sixthLevelSpells.add("Programmed Illusion");
        sixthLevelSpells.add("True Seeing");

        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Forcecage");
        seventhLevelSpells.add("Mirage Arcane");
        seventhLevelSpells.add("Mordenkainen's Magnificent Mansion");
        seventhLevelSpells.add("Project Image");
        seventhLevelSpells.add("Regenerate");
        seventhLevelSpells.add("Resurrection");
        seventhLevelSpells.add("Symbol");
        seventhLevelSpells.add("Teleport");

        eighthLevelSpells.add("Dominate Monster");
        eighthLevelSpells.add("Feeblemind");
        eighthLevelSpells.add("Glibness");
        eighthLevelSpells.add("Mind Blank");
        eighthLevelSpells.add("Power Word Stun");

        ninthLevelSpells.add("Foresight");
        ninthLevelSpells.add("Power Word Heal");
        ninthLevelSpells.add("Power Word Kill");
        ninthLevelSpells.add("True Polymorph");

        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }

    }

    /** Creates Vectors for each Level for the Cleric Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> clericSpellSetUp(int level){
        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Guidance");
        cantripList.add("Light");
        cantripList.add("Mending");
        cantripList.add("Resistance");
        cantripList.add("Sacred Flame");
        cantripList.add("Spare the Dying");
        cantripList.add("Thaumaturgy");

        firstLevelSpells.add("Bane");
        firstLevelSpells.add("Bless");
        firstLevelSpells.add("Command");
        firstLevelSpells.add("Create or Destroy Water");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Evil and Good");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Detect Poison and Disease ");
        firstLevelSpells.add("Guiding Bolt");
        firstLevelSpells.add("Healing Word");
        firstLevelSpells.add("Inflict Wounds");
        firstLevelSpells.add("Protection from Evil and Good");
        firstLevelSpells.add("Purify Food and Drink");
        firstLevelSpells.add("Sanctuary");
        firstLevelSpells.add("Shield of Faith");

        secondLevelSpells.add("Aid");
        secondLevelSpells.add("Augury");
        secondLevelSpells.add("Blindness/Deafness");
        secondLevelSpells.add("Calm Emotions");
        secondLevelSpells.add("Continual Flame");
        secondLevelSpells.add("Enhance Ability");
        secondLevelSpells.add("Find Traps");
        secondLevelSpells.add("Gentle Repose");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Prayer of Healing");
        secondLevelSpells.add("Protection from Poison");
        secondLevelSpells.add("Silence");
        secondLevelSpells.add("Spiritual Weapon");
        secondLevelSpells.add("Warding Bond");
        secondLevelSpells.add("Zone of Truth");

        thirdLevelSpells.add("Animate Dead");
        thirdLevelSpells.add("Beacon of Hope");
        thirdLevelSpells.add("Bestow Curse");
        thirdLevelSpells.add("Clairvoyance");
        thirdLevelSpells.add("Create Food and Water");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Feign Death");
        thirdLevelSpells.add("Glyph of Warding");
        thirdLevelSpells.add("Magic Circle");
        thirdLevelSpells.add("Mass Healing Word");
        thirdLevelSpells.add("Meld into Stone");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Revivify");
        thirdLevelSpells.add("Sending");
        thirdLevelSpells.add("Speak with Dead");
        thirdLevelSpells.add("Spirit Guardians");
        thirdLevelSpells.add("Tongues");
        thirdLevelSpells.add("Water Walk");

        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Control Water");
        fourthLevelSpells.add("Death Ward");
        fourthLevelSpells.add("Divination");
        fourthLevelSpells.add("Freedom of Movement");
        fourthLevelSpells.add("Guardian of Faith");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Stone Shape");

        fifthLevelSpells.add("Commune");
        fifthLevelSpells.add("Contagion");
        fifthLevelSpells.add("Dispel Evil and Good");
        fifthLevelSpells.add("Flame Strike");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Greater Restoration");
        fifthLevelSpells.add("Hallow");
        fifthLevelSpells.add("Insect Plague");
        fifthLevelSpells.add("Legend Lore");
        fifthLevelSpells.add("Mass Cure Wounds");
        fifthLevelSpells.add("Planar Binding");
        fifthLevelSpells.add("Raise Dead");
        fifthLevelSpells.add("Scrying");

        sixthLevelSpells.add("Blade Barrier");
        sixthLevelSpells.add("Create Undead");
        sixthLevelSpells.add("Find the Path");
        sixthLevelSpells.add("Forbiddance");
        sixthLevelSpells.add("Harm");
        sixthLevelSpells.add("Heal");
        sixthLevelSpells.add("Heroes' Feast");
        sixthLevelSpells.add("Planar Ally");
        sixthLevelSpells.add("True Seeing");
        sixthLevelSpells.add("Word of Recall");

        seventhLevelSpells.add("Conjure Celestial");
        seventhLevelSpells.add("Divine Word");
        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Fire Storm");
        seventhLevelSpells.add("Plane Shift");
        seventhLevelSpells.add("Regenerate");
        seventhLevelSpells.add("Resurrection");
        seventhLevelSpells.add("Symbol");

        eighthLevelSpells.add("Antimagic Field");
        eighthLevelSpells.add("Control Weather");
        eighthLevelSpells.add("Earthquake");
        eighthLevelSpells.add("Holy Aura");

        ninthLevelSpells.add("Astral Projection");
        ninthLevelSpells.add("Gate");
        ninthLevelSpells.add("Mass Heal");
        ninthLevelSpells.add("True Resurrection");

        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }

    }


    /** Creates Vectors for each Level for the Druid Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> druidSpellSetUp(int level){

        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Druidcraft");
        cantripList.add("Guidance");
        cantripList.add("Mending");
        cantripList.add("Posion Spray");
        cantripList.add("Produce Flame");
        cantripList.add("Resistance");
        cantripList.add("Shillelagh");
        cantripList.add("Thorn Whip");

        firstLevelSpells.add("Animal Friendship");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Create or Destroy Water");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Detect Poison and Disease");
        firstLevelSpells.add("Entangle");
        firstLevelSpells.add("Faerie Fire");
        firstLevelSpells.add("Fog Cloud");
        firstLevelSpells.add("Goodberry");
        firstLevelSpells.add("Healing Word");
        firstLevelSpells.add("Jump");
        firstLevelSpells.add("Longstrider");
        firstLevelSpells.add("Purify Food and Drink");
        firstLevelSpells.add("Speak with Animals");
        firstLevelSpells.add("Thunderwave");

        secondLevelSpells.add("Animal Messenger");
        secondLevelSpells.add("Barkskin");
        secondLevelSpells.add("Beast Sense");
        secondLevelSpells.add("Darkvision");
        secondLevelSpells.add("Enhance Ability");
        secondLevelSpells.add("Find Traps");
        secondLevelSpells.add("Flame Blade");
        secondLevelSpells.add("Flaming Sphere");
        secondLevelSpells.add("Gust of Wind");
        secondLevelSpells.add("Heat Metal");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Locate Animal or Plants");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Moonbeam");
        secondLevelSpells.add("Pass without Trace");
        secondLevelSpells.add("Protection from Poison");
        secondLevelSpells.add("Spike Growth");

        thirdLevelSpells.add("Call Lightning");
        thirdLevelSpells.add("Conjure Animals");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Feign Death");
        thirdLevelSpells.add("Meld into Stone");
        thirdLevelSpells.add("Plant Growth");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Sleet Storm");
        thirdLevelSpells.add("Speak with Plants");
        thirdLevelSpells.add("Water Breathing");
        thirdLevelSpells.add("Water Walk");
        thirdLevelSpells.add("Wind Wall");

        fourthLevelSpells.add("Blight");
        fourthLevelSpells.add("Confusion");
        fourthLevelSpells.add("Conjure Minor Elementals");
        fourthLevelSpells.add("Conjure Woodland Beings");
        fourthLevelSpells.add("Control Water");
        fourthLevelSpells.add("Dominate Beast");
        fourthLevelSpells.add("Freedom of Movement");
        fourthLevelSpells.add("Giant Insect");
        fourthLevelSpells.add("Grasping Vine");
        fourthLevelSpells.add("Hallucinatory Terrain");
        fourthLevelSpells.add("Ice Storm");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Polymorph");
        fourthLevelSpells.add("Stone Shape");
        fourthLevelSpells.add("Stoneskin");
        fourthLevelSpells.add("Wall of Fire");

        fifthLevelSpells.add("Antilife Shell");
        fifthLevelSpells.add("Awaken");
        fifthLevelSpells.add("Commune with Nature");
        fifthLevelSpells.add("Conjure Elemental");
        fifthLevelSpells.add("Contagion");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Greater Restoration");
        fifthLevelSpells.add("Insect Plague");
        fifthLevelSpells.add("Mass Cure Wounds");
        fifthLevelSpells.add("Planar Binding");
        fifthLevelSpells.add("Reincarnate");
        fifthLevelSpells.add("Scrying");
        fifthLevelSpells.add("Tree Stride");
        fifthLevelSpells.add("Wall of Stone");

        sixthLevelSpells.add("Conjure Fey");
        sixthLevelSpells.add("Find the Path");
        sixthLevelSpells.add("Heal");
        sixthLevelSpells.add("Heroes' Feast");
        sixthLevelSpells.add("Move Earth");
        sixthLevelSpells.add("Sunbeam");
        sixthLevelSpells.add("Transport via Plants");
        sixthLevelSpells.add("Wall of Thorns");
        sixthLevelSpells.add("Wind Walk");

        seventhLevelSpells.add("Fire Storm");
        seventhLevelSpells.add("Mirage Arcane");
        seventhLevelSpells.add("Plane Shift");
        seventhLevelSpells.add("Regenerate");
        seventhLevelSpells.add("Reverse Gravity");

        eighthLevelSpells.add("Animal Shapes");
        eighthLevelSpells.add("Antipathy/Sympathy");
        eighthLevelSpells.add("Control Weather");
        eighthLevelSpells.add("Earthquake");
        eighthLevelSpells.add("Feeblemind");
        eighthLevelSpells.add("Sunburst");
        eighthLevelSpells.add("Tsunami");

        ninthLevelSpells.add("Foresight");
        ninthLevelSpells.add("Shapechange");
        ninthLevelSpells.add("Storm of Vengeance");
        ninthLevelSpells.add("True Resurrection");

        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }

    }

    /** Creates Vectors for each Level for the Paladin Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> paladinSpellSetUp(int level){
        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();

        firstLevelSpells.add("Bless");
        firstLevelSpells.add("Command");
        firstLevelSpells.add("Compelled Duel");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Evil and Good");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Detect Poison and Disease");
        firstLevelSpells.add("Divine Favor");
        firstLevelSpells.add("Heroism");
        firstLevelSpells.add("Protection from Evil and Good");
        firstLevelSpells.add("Purify Food and Drink");
        firstLevelSpells.add("Searing Smite");
        firstLevelSpells.add("Shield of Faith");
        firstLevelSpells.add("Thunderous Smite");
        firstLevelSpells.add("Wrathful Smite");

        secondLevelSpells.add("Aid");
        secondLevelSpells.add("Branding Smite");
        secondLevelSpells.add("Find Steed");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Magic Weapon");
        secondLevelSpells.add("Protection from Poison");
        secondLevelSpells.add("Zone of Truth");

        thirdLevelSpells.add("Aura of Vitality");
        thirdLevelSpells.add("Blinding Smite");
        thirdLevelSpells.add("Create Food and Water");
        thirdLevelSpells.add("Crusader's Mantle");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Elemental Weapon");
        thirdLevelSpells.add("Magic Circle");
        thirdLevelSpells.add("Remove Curse");
        thirdLevelSpells.add("Revivify");

        fourthLevelSpells.add("Aura of Life");
        fourthLevelSpells.add("Aura of Purity");
        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Death Ward");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Staggering Smite");

        fifthLevelSpells.add("Banishing Smite");
        fifthLevelSpells.add("Circle of Power");
        fifthLevelSpells.add("Destructive Wave");
        fifthLevelSpells.add("Dispel Evil and Good");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Raise Dead");

       while (level<1||level>5){
           Scanner scanner = new Scanner(System.in);
           System.out.println("Incorrect Level, please choose a different option");
           int choice = scanner.nextInt();
           String endOfLine = scanner.nextLine();
           paladinSpellSetUp(choice);
       }
        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
            return fifthLevelSpells;
    }

    /** Creates Vectors for each Level for the Ranger Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> rangerSpellSetUp(int level){
        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();

        firstLevelSpells.add("Alarm");
        firstLevelSpells.add("Animal Friendship");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Detect Poison and Disease");
        firstLevelSpells.add("Ensnaring Strike");
        firstLevelSpells.add("Fog Cloud");
        firstLevelSpells.add("Good Berry");
        firstLevelSpells.add("Hail of Thorns");
        firstLevelSpells.add("Hunter's Mask");
        firstLevelSpells.add("Jump");
        firstLevelSpells.add("Longstrider");
        firstLevelSpells.add("Speak with Animals");

        secondLevelSpells.add("Animal Messenger");
        secondLevelSpells.add("Barkskin");
        secondLevelSpells.add("Beast Sense");
        secondLevelSpells.add("Cordon of Arrows");
        secondLevelSpells.add("Darkvision");
        secondLevelSpells.add("Find Traps");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Locate Animals or Plants");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Pass without Trace");
        secondLevelSpells.add("Protection from Poison");
        secondLevelSpells.add("Silence");
        secondLevelSpells.add("Spike Growth");

        thirdLevelSpells.add("Conjure Animals");
        thirdLevelSpells.add("Conjure Barrage");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Lightning Arrow");
        thirdLevelSpells.add("Nondetection");
        thirdLevelSpells.add("Plant Growth");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Speak with Plants");
        thirdLevelSpells.add("Water Breathing");
        thirdLevelSpells.add("Water Walk");
        thirdLevelSpells.add("Wind Wall");

        fourthLevelSpells.add("Conjure Woodland Beings");
        fourthLevelSpells.add("Freedom of Movement");
        fourthLevelSpells.add("Grasping Vine");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Stoneskin");

        fifthLevelSpells.add("Commune with Nature");
        fifthLevelSpells.add("Conjure Volley");
        fifthLevelSpells.add("Swift Quiver");
        fifthLevelSpells.add("Tree Stride");

        while (level<1||level>5){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Incorrect Level, please choose a different option");
            int choice = scanner.nextInt();
            String endOfLine = scanner.nextLine();
            paladinSpellSetUp(choice);
        }
        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        return fifthLevelSpells;
    }

    /** Creates Vectors for each Level for the Sorcerer Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> sorcererSpellSetUp(int level){
        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Acid Splash");
        cantripList.add("Blade Ward");
        cantripList.add("Chill Touch");
        cantripList.add("Dancing Lights");
        cantripList.add("Fire Bolt");
        cantripList.add("Friends");
        cantripList.add("Light");
        cantripList.add("Mage Hand");
        cantripList.add("Mending");
        cantripList.add("Message");
        cantripList.add("Minor Illusion");
        cantripList.add("Poison Spray");
        cantripList.add("Prestidigitation");
        cantripList.add("Ray of Frost");
        cantripList.add("Shocking Grasp");
        cantripList.add("True Strike");

        firstLevelSpells.add("Burning Hands");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Chromatic Orb");
        firstLevelSpells.add("Color Spray");
        firstLevelSpells.add("Comprehend Languages");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Disguise Self");
        firstLevelSpells.add("Expeditious Retreat");
        firstLevelSpells.add("False Life");
        firstLevelSpells.add("Feather Fall");
        firstLevelSpells.add("Fog Cloud");
        firstLevelSpells.add("Jump");
        firstLevelSpells.add("Mage Armor");
        firstLevelSpells.add("Magic Missile");
        firstLevelSpells.add("Ray of Sickness");
        firstLevelSpells.add("Shield");
        firstLevelSpells.add("Silent Image");
        firstLevelSpells.add("Sleep");
        firstLevelSpells.add("Thunderwave");
        firstLevelSpells.add("Witch Bolt");

        secondLevelSpells.add("Alter Self");
        secondLevelSpells.add("Blindness/Deafness");
        secondLevelSpells.add("Blur");
        secondLevelSpells.add("Cloud of Daggers");
        secondLevelSpells.add("Crown of Madness");
        secondLevelSpells.add("Darkness");
        secondLevelSpells.add("Darkvision");
        secondLevelSpells.add("Detect Thoughts");
        secondLevelSpells.add("Enhance Ability");
        secondLevelSpells.add("Enlarge/Reduce");
        secondLevelSpells.add("Gust of Wind");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Invisibility");
        secondLevelSpells.add("Knock");
        secondLevelSpells.add("Levitate");
        secondLevelSpells.add("Mirror Image");
        secondLevelSpells.add("Misty Step");
        secondLevelSpells.add("Phantasmal Force");
        secondLevelSpells.add("Scorching Ray");
        secondLevelSpells.add("See Invisibilty");
        secondLevelSpells.add("Shatter");
        secondLevelSpells.add("Spider Climb");
        secondLevelSpells.add("Suggestion");
        secondLevelSpells.add("Web");

        thirdLevelSpells.add("Blink");
        thirdLevelSpells.add("Clairvoyance");
        thirdLevelSpells.add("Counterspell");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Fear");
        thirdLevelSpells.add("Fireball");
        thirdLevelSpells.add("Fly");
        thirdLevelSpells.add("Gaseous Form");
        thirdLevelSpells.add("Haste");
        thirdLevelSpells.add("Hypnotic Pattern");
        thirdLevelSpells.add("Lightning Bolt");
        thirdLevelSpells.add("Major Image");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Sleet Storm");
        thirdLevelSpells.add("Slow");
        thirdLevelSpells.add("Stinking Clouds");
        thirdLevelSpells.add("Tongues");
        thirdLevelSpells.add("Water Breathing");
        thirdLevelSpells.add("Water Walk");

        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Blight");
        fourthLevelSpells.add("Confusion");
        fourthLevelSpells.add("Dimension Door");
        fourthLevelSpells.add("Dominate Beast");
        fourthLevelSpells.add("Greater Invisibility");
        fourthLevelSpells.add("Ice Storm");
        fourthLevelSpells.add("Polymorph");
        fourthLevelSpells.add("Stoneskin");
        fourthLevelSpells.add("Wall of Fire");

        fifthLevelSpells.add("Animate Objects");
        fifthLevelSpells.add("Cloudkill");
        fifthLevelSpells.add("Cone of Cold");
        fifthLevelSpells.add("Creation");
        fifthLevelSpells.add("Dominate Person");
        fifthLevelSpells.add("Hold Monster");
        fifthLevelSpells.add("Insect Plague");
        fifthLevelSpells.add("Seeming");
        fifthLevelSpells.add("Telekinesis");
        fifthLevelSpells.add("Teleportation Circle");
        fifthLevelSpells.add("Wall of Stone");

        sixthLevelSpells.add("Arcane Gate");
        sixthLevelSpells.add("Chain Lightning");
        sixthLevelSpells.add("Circle of Death");
        sixthLevelSpells.add("Disintegrate");
        sixthLevelSpells.add("Eyebite");
        sixthLevelSpells.add("Globe of Invulnerability");
        sixthLevelSpells.add("Mass Suggestion");
        sixthLevelSpells.add("Move Earth");
        sixthLevelSpells.add("Sunbeam");
        sixthLevelSpells.add("True Seeing");

        seventhLevelSpells.add("Delayed Blast Fireball");
        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Finger of Death");
        seventhLevelSpells.add("Fire Storm");
        seventhLevelSpells.add("Plane Shift");
        seventhLevelSpells.add("Prismatic Spray");
        seventhLevelSpells.add("Reverse Gravity");
        seventhLevelSpells.add("Teleport");

        eighthLevelSpells.add("Dominate Monster");
        eighthLevelSpells.add("Earthquake");
        eighthLevelSpells.add("Incendiary Cloud");
        eighthLevelSpells.add("Power Word Stun");
        eighthLevelSpells.add("Sunburst");

        ninthLevelSpells.add("Gate");
        ninthLevelSpells.add("Meteor Swarm");
        ninthLevelSpells.add("Power Word Kill");
        ninthLevelSpells.add("Time Stop");
        ninthLevelSpells.add("Wish");




        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }

    }

    /** Creates Vectors for each Level for the Warlock Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> warlockSpellSetUp(int level){

        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Blade Ward");
        cantripList.add("Chill Touch");
        cantripList.add("Eldritch Blast");
        cantripList.add("Friends");
        cantripList.add("Mage Hand");
        cantripList.add("Minor Illusion");
        cantripList.add("Poison Spray");
        cantripList.add("Prestidigtation");
        cantripList.add("True Strike");

        firstLevelSpells.add("Armor of Agathys");
        firstLevelSpells.add("Arms of Hadar");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Comprehend Languages");
        firstLevelSpells.add("Expeditious Retreat");
        firstLevelSpells.add("Hellish Rebuke");
        firstLevelSpells.add("Hex");
        firstLevelSpells.add("Illusory Script");
        firstLevelSpells.add("Protection from Evil and Good");
        firstLevelSpells.add("Unseen Servant");
        firstLevelSpells.add("Witch Bolt");

        secondLevelSpells.add("Cloud of Daggers");
        secondLevelSpells.add("Crown of Madness");
        secondLevelSpells.add("Darkness");
        secondLevelSpells.add("Enthrall");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Invisibility");
        secondLevelSpells.add("Mirror Image");
        secondLevelSpells.add("Misty Step");
        secondLevelSpells.add("Ray of Enfeeblement");
        secondLevelSpells.add("Shatter");
        secondLevelSpells.add("Spider Climb");
        secondLevelSpells.add("Suggestion");

        thirdLevelSpells.add("Counterspell");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Fear");
        thirdLevelSpells.add("Fly");
        thirdLevelSpells.add("Gaseous Form");
        thirdLevelSpells.add("Hunger of Hadar");
        thirdLevelSpells.add("Hypnotic Pattern");
        thirdLevelSpells.add("Magic Circle");
        thirdLevelSpells.add("Major Image");
        thirdLevelSpells.add("Remove Curse");
        thirdLevelSpells.add("Tongues");
        thirdLevelSpells.add("Vampiric Touch");

        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Blight");
        fourthLevelSpells.add("Dimension Door");
        fourthLevelSpells.add("Hallucinatory Terrain");

        fifthLevelSpells.add("Contact Other Plane");
        fifthLevelSpells.add("Dream");
        fifthLevelSpells.add("Hold Monster");
        fifthLevelSpells.add("Scrying");

        sixthLevelSpells.add("Arcane Gate");
        sixthLevelSpells.add("Circle of Death");
        sixthLevelSpells.add("Conjure Fey");
        sixthLevelSpells.add("Create Undead");
        sixthLevelSpells.add("Eyebite");
        sixthLevelSpells.add("Flesh to Stone");
        sixthLevelSpells.add("Mass Suggestion");
        sixthLevelSpells.add("True Seeing");

        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Finger of Death");
        seventhLevelSpells.add("Forecage");
        seventhLevelSpells.add("Plane Shift");

        eighthLevelSpells.add("Demiplane");
        eighthLevelSpells.add("Dominate Monster");
        eighthLevelSpells.add("Feeblemind");
        eighthLevelSpells.add("Glibness");
        eighthLevelSpells.add("Power Word Stun");

        ninthLevelSpells.add("Astral Projection");
        ninthLevelSpells.add("Foresight");
        ninthLevelSpells.add("Imprisonment");
        ninthLevelSpells.add("Power Word Kill");
        ninthLevelSpells.add("True Polymorph");


        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }
    }

    /** Creates Vectors for each Level for the Wizard Class
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> wizardSpellSetUp(int level){

        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Acid Splash");
        cantripList.add("Blade Ward");
        cantripList.add("Chill Touch");
        cantripList.add("Dancing Lights");
        cantripList.add("Fire bolts");
        cantripList.add("Friends");
        cantripList.add("Light");
        cantripList.add("Mage Hand");
        cantripList.add("Mending");
        cantripList.add("Message");
        cantripList.add("Minor Illusion");
        cantripList.add("Poison Spray");
        cantripList.add("Prestidigitation");
        cantripList.add("Ray of Frost");
        cantripList.add("Shocking Grasp");
        cantripList.add("True Strike");

        firstLevelSpells.add("Alarm");
        firstLevelSpells.add("Burning Hands");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Chromatic Orb");
        firstLevelSpells.add("Color Spray");
        firstLevelSpells.add("Comprehend Languages");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Disguise Self");
        firstLevelSpells.add("Expeditious Retreat");
        firstLevelSpells.add("False Life");
        firstLevelSpells.add("Feather Fall");
        firstLevelSpells.add("Find Familiar");
        firstLevelSpells.add("Fog Cloud");
        firstLevelSpells.add("Grease");
        firstLevelSpells.add("Identify");
        firstLevelSpells.add("Illusory Script");
        firstLevelSpells.add("Jump");
        firstLevelSpells.add("Longstrider");
        firstLevelSpells.add("Mage Armor");
        firstLevelSpells.add("Magic Missle");
        firstLevelSpells.add("Protection from Good or Evil");
        firstLevelSpells.add("Ray of Sickness");
        firstLevelSpells.add("Shield");
        firstLevelSpells.add("Silent Image");
        firstLevelSpells.add("Sleep");
        firstLevelSpells.add("Tasha's Hideous Laughter");
        firstLevelSpells.add("Tenser's Floating Disk");
        firstLevelSpells.add("Thunderwave");
        firstLevelSpells.add("Unseen Servant");
        firstLevelSpells.add("Witch Bolt");

        secondLevelSpells.add("Alter Self");
        secondLevelSpells.add("Arcane Lock");
        secondLevelSpells.add("Blindness/Deafness");
        secondLevelSpells.add("Blur");
        secondLevelSpells.add("Cloud of Daggers");
        secondLevelSpells.add("Continual Flame");
        secondLevelSpells.add("Crown of Madness");
        secondLevelSpells.add("Darkness");
        secondLevelSpells.add("Darkvision");
        secondLevelSpells.add("Detect Thoughts");
        secondLevelSpells.add("Enlarge/Reduce");
        secondLevelSpells.add("Flaming Sphere");
        secondLevelSpells.add("Gentle Repose");
        secondLevelSpells.add("Gust of Wind");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Invisibility");
        secondLevelSpells.add("Knock");
        secondLevelSpells.add("Levitate");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Magic Mouth");
        secondLevelSpells.add("Magic Weapon");
        secondLevelSpells.add("Melf's Acid Arrow");
        secondLevelSpells.add("Mirror Image");
        secondLevelSpells.add("Misty Step");
        secondLevelSpells.add("Nystul's Magic Aura");
        secondLevelSpells.add("Phantasmal Force");
        secondLevelSpells.add("Ray of Enfeeblement");
        secondLevelSpells.add("Rope Trick");
        secondLevelSpells.add("Scorching Ray");
        secondLevelSpells.add("See Invisibility");
        secondLevelSpells.add("Shatter");
        secondLevelSpells.add("Spider Climb");
        secondLevelSpells.add("Suggestion");
        secondLevelSpells.add("Web");

        thirdLevelSpells.add("Animate Dead");
        thirdLevelSpells.add("Bestow Curse");
        thirdLevelSpells.add("Blink");
        thirdLevelSpells.add("Clairvoyance");
        thirdLevelSpells.add("Counterspell");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Fear");
        thirdLevelSpells.add("Feign Death");
        thirdLevelSpells.add("Fireball");
        thirdLevelSpells.add("Fly");
        thirdLevelSpells.add("Gaseous Form");
        thirdLevelSpells.add("Glyph of Warding");
        thirdLevelSpells.add("Haste");
        thirdLevelSpells.add("Hypnotic Pattern");
        thirdLevelSpells.add("Leomund's Tiny Hut");
        thirdLevelSpells.add("Lightning Bolt");
        thirdLevelSpells.add("Magic Circle");
        thirdLevelSpells.add("Major Image");
        thirdLevelSpells.add("Nondetection");
        thirdLevelSpells.add("Phantom Steed");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Remove Curse");
        thirdLevelSpells.add("Sending");
        thirdLevelSpells.add("Sleet Storm");
        thirdLevelSpells.add("Slow");
        thirdLevelSpells.add("Stinking Cloud");
        thirdLevelSpells.add("Tongues");
        thirdLevelSpells.add("Vampiric Touch");
        thirdLevelSpells.add("Water Breathing");

        fourthLevelSpells.add("Arcane Eye");
        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Blight");
        fourthLevelSpells.add("Confusion");
        fourthLevelSpells.add("Conjure Minor Element");
        fourthLevelSpells.add("Contol Water");
        fourthLevelSpells.add("Dimension Door");
        fourthLevelSpells.add("Evard's Black Tentacles");
        fourthLevelSpells.add("Fabricate");
        fourthLevelSpells.add("Fire Shield");
        fourthLevelSpells.add("Greater Invisibility");
        fourthLevelSpells.add("Hallucinatory Terrain");
        fourthLevelSpells.add("Ice Storm");
        fourthLevelSpells.add("Leomund's Secret Chest");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Mordenkainen's Faithful Hound");
        fourthLevelSpells.add("Mordenkainen's Private Sanctum");
        fourthLevelSpells.add("Otiluke's Resilient Sphere");
        fourthLevelSpells.add("Phantasmal Killer");
        fourthLevelSpells.add("Polymorph");
        fourthLevelSpells.add("Stone Shape");
        fourthLevelSpells.add("Stoneskin");
        fourthLevelSpells.add("Wall of Fire");

        fifthLevelSpells.add("Animate Objects");
        fifthLevelSpells.add("Bigby's Hand");
        fifthLevelSpells.add("Cloudkill");
        fifthLevelSpells.add("Cone of Cold");
        fifthLevelSpells.add("Conjure Elemental");
        fifthLevelSpells.add("Contact Other Plane");
        fifthLevelSpells.add("Creation");
        fifthLevelSpells.add("Dominate Person");
        fifthLevelSpells.add("Dream");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Hold Monster");
        fifthLevelSpells.add("Legend Lore");
        fifthLevelSpells.add("Mislead");
        fifthLevelSpells.add("Modify Memory");
        fifthLevelSpells.add("Passwall");
        fifthLevelSpells.add("Planar Binding");
        fifthLevelSpells.add("Rary's Telepathic Bond");
        fifthLevelSpells.add("Scrying");
        fifthLevelSpells.add("Seeming");
        fifthLevelSpells.add("Telekinesis Circle");
        fifthLevelSpells.add("Wall of Force");
        fifthLevelSpells.add("Wall of Stone");

        sixthLevelSpells.add("Arcane Gate");
        sixthLevelSpells.add("Chain Lightning");
        sixthLevelSpells.add("Circle of Death");
        sixthLevelSpells.add("Contingency");
        sixthLevelSpells.add("Create Undead");
        sixthLevelSpells.add("Disintegrate");
        sixthLevelSpells.add("Drawmij's Instant Summons");
        sixthLevelSpells.add("Eyebite");
        sixthLevelSpells.add("Flesh to Stone");
        sixthLevelSpells.add("Globe of Invulnerability");
        sixthLevelSpells.add("Guards of Wards");
        sixthLevelSpells.add("Magic Jar");
        sixthLevelSpells.add("Mass Suggestion");
        sixthLevelSpells.add("Move Earth");
        sixthLevelSpells.add("Otilukes's Freezing Sphere");
        sixthLevelSpells.add("Otto's Irresistable Dance");
        sixthLevelSpells.add("Programmed Illusion");
        sixthLevelSpells.add("Sunbeam");
        sixthLevelSpells.add("True Seeing");
        sixthLevelSpells.add("Wall of Ice");

        seventhLevelSpells.add("Delayed Blast Fireball");
        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Finger of Death");
        seventhLevelSpells.add("Forecage");
        seventhLevelSpells.add("Mirage Arcane");
        seventhLevelSpells.add("Mordenkainen's Magnificent Mansion");
        seventhLevelSpells.add("Mordenkainen's Sword");
        seventhLevelSpells.add("Plane Shift");
        seventhLevelSpells.add("Prismatic Spray");
        seventhLevelSpells.add("Project Image");
        seventhLevelSpells.add("Reverse Gravity");
        seventhLevelSpells.add("Sequester");
        seventhLevelSpells.add("Simulation");
        seventhLevelSpells.add("Symbol");
        seventhLevelSpells.add("Teleport");

        eighthLevelSpells.add("Antimagic Field");
        eighthLevelSpells.add("Antipathy/Sympathy");
        eighthLevelSpells.add("Clone");
        eighthLevelSpells.add("Control Weather");
        eighthLevelSpells.add("Demiplane");
        eighthLevelSpells.add("Dominate Monster");
        eighthLevelSpells.add("Feeblemind");
        eighthLevelSpells.add("Incendiary Cloud");
        eighthLevelSpells.add("Maze");
        eighthLevelSpells.add("Mind Blank");
        eighthLevelSpells.add("Power Word Stun");
        eighthLevelSpells.add("Sunburst");
        eighthLevelSpells.add("Telepathy");

        ninthLevelSpells.add("Astral Projection");
        ninthLevelSpells.add("Foresight");
        ninthLevelSpells.add("Gate");
        ninthLevelSpells.add("Imprisonment");
        ninthLevelSpells.add("Meteor Swarm");
        ninthLevelSpells.add("Power Word Kill");
        ninthLevelSpells.add("Prismatic Wall");
        ninthLevelSpells.add("Shapechange");
        ninthLevelSpells.add("Time Stop");
        ninthLevelSpells.add("True Polymorph");
        ninthLevelSpells.add("Weird");
        ninthLevelSpells.add("Wish");

        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }
    }

    /** Creates Vectors for each Level for the all Classes
     * @param level Enter level for the spell you needed returned (1-9). Any integer that is not 1-9 will return the Cantrips.
     * @return Vector of spells for the level provided.
     */
    public static Vector<String> allClassSpellSetUp(int level){

        Vector<String> firstLevelSpells = new Vector<>();
        Vector<String> secondLevelSpells = new Vector<>();
        Vector<String> thirdLevelSpells = new Vector<>();
        Vector<String> fourthLevelSpells = new Vector<>();
        Vector<String> fifthLevelSpells = new Vector<>();
        Vector<String> sixthLevelSpells = new Vector<>();
        Vector<String> seventhLevelSpells = new Vector<>();
        Vector<String> eighthLevelSpells = new Vector<>();
        Vector<String> ninthLevelSpells = new Vector<>();
        Vector<String> cantripList = new Vector<>();

        cantripList.add("Acid Splash");
        cantripList.add("Blade Ward");
        cantripList.add("Chill Touch");
        cantripList.add("Dancing Lights");
        cantripList.add("Druidcraft");
        cantripList.add("Eldritch Blast");
        cantripList.add("Fire bolts");
        cantripList.add("Friends");
        cantripList.add("Guidance");
        cantripList.add("Light");
        cantripList.add("Mage Hand");
        cantripList.add("Mending");
        cantripList.add("Message");
        cantripList.add("Minor Illusion");
        cantripList.add("Poison Spray");
        cantripList.add("Prestidigitation");
        cantripList.add("Produce Flame");
        cantripList.add("Ray of Frost");
        cantripList.add("Resistance");
        cantripList.add("Sacred Flame");
        cantripList.add("Shillelagh");
        cantripList.add("Shocking Grasp");
        cantripList.add("Spare the Dying");
        cantripList.add("Thaumaturgy");
        cantripList.add("Thorn Whip");
        cantripList.add("True Strike");
        cantripList.add("Vicious Mockery");

        firstLevelSpells.add("Alarm");
        firstLevelSpells.add("Animal Friendship");
        firstLevelSpells.add("Armor of Agathys");
        firstLevelSpells.add("Arms of Hadar");
        firstLevelSpells.add("Bane");
        firstLevelSpells.add("Bless");
        firstLevelSpells.add("Burning Hands");
        firstLevelSpells.add("Charm Person");
        firstLevelSpells.add("Chromatic Orb");
        firstLevelSpells.add("Color Spray");
        firstLevelSpells.add("Command");
        firstLevelSpells.add("Compelled Duel");
        firstLevelSpells.add("Comprehend Languages");
        firstLevelSpells.add("Create or Destroy Water");
        firstLevelSpells.add("Cure Wounds");
        firstLevelSpells.add("Detect Evil and Good");
        firstLevelSpells.add("Detect Magic");
        firstLevelSpells.add("Detect Poison and Disease");
        firstLevelSpells.add("Disguise Self");
        firstLevelSpells.add("Dissonant Whispers");
        firstLevelSpells.add("Divine Favor");
        firstLevelSpells.add("Ensnaring Strike");
        firstLevelSpells.add("Entangle");
        firstLevelSpells.add("Expeditious Retreat");
        firstLevelSpells.add("Faerie Fire");
        firstLevelSpells.add("False Life");
        firstLevelSpells.add("Feather Fall");
        firstLevelSpells.add("Find Familiar");
        firstLevelSpells.add("Fog Cloud");
        firstLevelSpells.add("Good Berry");
        firstLevelSpells.add("Grease");
        firstLevelSpells.add("Guiding Bolt");
        firstLevelSpells.add("Hail of Thorns");
        firstLevelSpells.add("Healing Word");
        firstLevelSpells.add("Hellish Rebuke");
        firstLevelSpells.add("Heroism");
        firstLevelSpells.add("Hex");
        firstLevelSpells.add("Hunter's Mask");
        firstLevelSpells.add("Identify");
        firstLevelSpells.add("Illusory Script");
        firstLevelSpells.add("Inflict Wounds");
        firstLevelSpells.add("Jump");
        firstLevelSpells.add("Longstrider");
        firstLevelSpells.add("Mage Armor");
        firstLevelSpells.add("Magic Missile");
        firstLevelSpells.add("Protection from Good or Evil");
        firstLevelSpells.add("Purify Food and Drink");
        firstLevelSpells.add("Ray of Sickness");
        firstLevelSpells.add("Sanctuary");
        firstLevelSpells.add("Searing Smite");
        firstLevelSpells.add("Shield");
        firstLevelSpells.add("Shield of Faith");
        firstLevelSpells.add("Silent Image");
        firstLevelSpells.add("Sleep");
        firstLevelSpells.add("Speak with Animals");
        firstLevelSpells.add("Tasha's Hideous Laughter");
        firstLevelSpells.add("Tenser's Floating Disk");
        firstLevelSpells.add("Thunderous Smite");
        firstLevelSpells.add("Thunderwave");
        firstLevelSpells.add("Unseen Servant");
        firstLevelSpells.add("Witch Bolt");
        firstLevelSpells.add("Wrathful Smite");


        secondLevelSpells.add("Aid");
        secondLevelSpells.add("Alter Self");
        secondLevelSpells.add("Animal Messenger");
        secondLevelSpells.add("Arcane Lock");
        secondLevelSpells.add("Augury");
        secondLevelSpells.add("Barkskin");
        secondLevelSpells.add("Beast Sense");
        secondLevelSpells.add("Blindness/Deafness");
        secondLevelSpells.add("Blur");
        secondLevelSpells.add("Branding Smite");
        secondLevelSpells.add("Calm Emotions");
        secondLevelSpells.add("Cloud of Daggers");
        secondLevelSpells.add("Continual Flame");
        secondLevelSpells.add("Cordon of Arrows");
        secondLevelSpells.add("Crown of Madness");
        secondLevelSpells.add("Darkness");
        secondLevelSpells.add("Darkvision");
        secondLevelSpells.add("Detect Thoughts");
        secondLevelSpells.add("Enhance Ability");
        secondLevelSpells.add("Enlarge/Reduce");
        secondLevelSpells.add("Enthrall");
        secondLevelSpells.add("Find Steed");
        secondLevelSpells.add("Find Traps");
        secondLevelSpells.add("Flame Blade");
        secondLevelSpells.add("Flaming Sphere");
        secondLevelSpells.add("Gentle Repose");
        secondLevelSpells.add("Gust of Wind");
        secondLevelSpells.add("Heat Metal");
        secondLevelSpells.add("Hold Person");
        secondLevelSpells.add("Invisibility");
        secondLevelSpells.add("Knock");
        secondLevelSpells.add("Lesser Restoration");
        secondLevelSpells.add("Levitate");
        secondLevelSpells.add("Locate Animals or Plants");
        secondLevelSpells.add("Locate Object");
        secondLevelSpells.add("Magic Mouth");
        secondLevelSpells.add("Magic Weapon");
        secondLevelSpells.add("Melf's Acid Arrow");
        secondLevelSpells.add("Mirror Image");
        secondLevelSpells.add("Misty Step");
        secondLevelSpells.add("Moonbeam");
        secondLevelSpells.add("Nystul's Magic Aura");
        secondLevelSpells.add("Pass without Trace");
        secondLevelSpells.add("Phantasmal Force");
        secondLevelSpells.add("Prayer of Healing");
        secondLevelSpells.add("Protection from Poison");
        secondLevelSpells.add("Ray of Enfeeblement");
        secondLevelSpells.add("Rope Trick");
        secondLevelSpells.add("Scorching Ray");
        secondLevelSpells.add("See Invisibility");
        secondLevelSpells.add("Shatter");
        secondLevelSpells.add("Silence");
        secondLevelSpells.add("Spider Climb");
        secondLevelSpells.add("Spike Growth");
        secondLevelSpells.add("Spiritual Weapon");
        secondLevelSpells.add("Suggestion");
        secondLevelSpells.add("Warding Bond");
        secondLevelSpells.add("Web");
        secondLevelSpells.add("Zone of Truth");

        thirdLevelSpells.add("Animate Dead");
        thirdLevelSpells.add("Aura of Vitality");
        thirdLevelSpells.add("Beacon of Hope");
        thirdLevelSpells.add("Bestow Curse");
        thirdLevelSpells.add("Blinding Smite");
        thirdLevelSpells.add("Blink");
        thirdLevelSpells.add("Call Lightning");
        thirdLevelSpells.add("Clairvoyance");
        thirdLevelSpells.add("Conjure Animals");
        thirdLevelSpells.add("Conjure Barrage");
        thirdLevelSpells.add("Counterspell");
        thirdLevelSpells.add("Create Food and Water");
        thirdLevelSpells.add("Crusader's Mantle");
        thirdLevelSpells.add("Daylight");
        thirdLevelSpells.add("Dispel Magic");
        thirdLevelSpells.add("Elemental Weapon");
        thirdLevelSpells.add("Fear");
        thirdLevelSpells.add("Feign Death");
        thirdLevelSpells.add("Fireball");
        thirdLevelSpells.add("Fly");
        thirdLevelSpells.add("Gaseous Form");
        thirdLevelSpells.add("Glyph of Warding");
        thirdLevelSpells.add("Haste");
        thirdLevelSpells.add("Hunger of Hadar");
        thirdLevelSpells.add("Hypnotic Pattern");
        thirdLevelSpells.add("Leomund's Tiny Hut");
        thirdLevelSpells.add("Lightning Bolt");
        thirdLevelSpells.add("Mass Healing Word");
        thirdLevelSpells.add("Magic Circle");
        thirdLevelSpells.add("Major Image");
        thirdLevelSpells.add("Meld into Stone");
        thirdLevelSpells.add("Nondetection");
        thirdLevelSpells.add("Phantom Steed");
        thirdLevelSpells.add("Plant Growth");
        thirdLevelSpells.add("Protection from Energy");
        thirdLevelSpells.add("Remove Curse");
        thirdLevelSpells.add("Revivify");
        thirdLevelSpells.add("Sending");
        thirdLevelSpells.add("Sleet Storm");
        thirdLevelSpells.add("Slow");
        thirdLevelSpells.add("Speak with Dead");
        thirdLevelSpells.add("Speak with Plants");
        thirdLevelSpells.add("Spirit Guardians");
        thirdLevelSpells.add("Stinking Cloud");
        thirdLevelSpells.add("Tongues");
        thirdLevelSpells.add("Vampiric Touch");
        thirdLevelSpells.add("Water Breathing");
        thirdLevelSpells.add("Water Walk");
        thirdLevelSpells.add("Wind Wall");

        fourthLevelSpells.add("Arcane Eye");
        fourthLevelSpells.add("Aura of Life");
        fourthLevelSpells.add("Aura of Purity");
        fourthLevelSpells.add("Banishment");
        fourthLevelSpells.add("Blight");
        fourthLevelSpells.add("Compulsion");
        fourthLevelSpells.add("Confusion");
        fourthLevelSpells.add("Conjure Minor Elementals");
        fourthLevelSpells.add("Conjure Woodland Beings");
        fourthLevelSpells.add("Control Water");
        fourthLevelSpells.add("Death Ward");
        fourthLevelSpells.add("Dimension Door");
        fourthLevelSpells.add("Divination");
        fourthLevelSpells.add("Dominate Beast");
        fourthLevelSpells.add("Evard's Black Tentacles");
        fourthLevelSpells.add("Fabricate");
        fourthLevelSpells.add("Fire Shield");
        fourthLevelSpells.add("Freedom of Movement");
        fourthLevelSpells.add("Giant Insect");
        fourthLevelSpells.add("Grasping Vine");
        fourthLevelSpells.add("Greater Invisibility");
        fourthLevelSpells.add("Guardian of Faith");
        fourthLevelSpells.add("Hallucinatory Terrain");
        fourthLevelSpells.add("Ice Storm");
        fourthLevelSpells.add("Leomund's Secret Chest");
        fourthLevelSpells.add("Locate Creature");
        fourthLevelSpells.add("Mordenkainen's Faithful Hound");
        fourthLevelSpells.add("Mordenkainen's Private Sanctum");
        fourthLevelSpells.add("Otiluke's Resilient Sphere");
        fourthLevelSpells.add("Phantasmal Killer");
        fourthLevelSpells.add("Polymorph");
        fourthLevelSpells.add("Staggering Smite");
        fourthLevelSpells.add("Stone Shape");
        fourthLevelSpells.add("Stoneskin");
        fourthLevelSpells.add("Wall of Fire");

        fifthLevelSpells.add("Animate Objects");
        fifthLevelSpells.add("Antilife Shell");
        fifthLevelSpells.add("Awaken");
        fifthLevelSpells.add("Banishing Smite");
        fifthLevelSpells.add("Bigby's Hand");
        fifthLevelSpells.add("Circle of Power");
        fifthLevelSpells.add("Cloudkill");
        fifthLevelSpells.add("Commune");
        fifthLevelSpells.add("Commune with Nature");
        fifthLevelSpells.add("Cone of Cold");
        fifthLevelSpells.add("Conjure Elemental");
        fifthLevelSpells.add("Conjure Volley");
        fifthLevelSpells.add("Contact Other Plane");
        fifthLevelSpells.add("Contagion");
        fifthLevelSpells.add("Creation");
        fifthLevelSpells.add("Destructive Wave");
        fifthLevelSpells.add("Dispel Evil and Good");
        fifthLevelSpells.add("Dominate Person");
        fifthLevelSpells.add("Dream");
        fifthLevelSpells.add("Flame Strike");
        fifthLevelSpells.add("Geas");
        fifthLevelSpells.add("Greater Restoration");
        fifthLevelSpells.add("Hallow");
        fifthLevelSpells.add("Hold Monster");
        fifthLevelSpells.add("Insect Plague");
        fifthLevelSpells.add("Legend Lore");
        fifthLevelSpells.add("Mass Cure Wounds");
        fifthLevelSpells.add("Mislead");
        fifthLevelSpells.add("Modify Memory");
        fifthLevelSpells.add("Passwall");
        fifthLevelSpells.add("Planar Binding");
        fifthLevelSpells.add("Raise Dead");
        fifthLevelSpells.add("Rary's Telepathic Bond");
        fifthLevelSpells.add("Reincarnate");
        fifthLevelSpells.add("Scrying");
        fifthLevelSpells.add("Seeming");
        fifthLevelSpells.add("Swift Quiver");
        fifthLevelSpells.add("Telekinesis Circle");
        fifthLevelSpells.add("Teleportation Circle");
        fifthLevelSpells.add("Tree Stride");
        fifthLevelSpells.add("Wall of Force");
        fifthLevelSpells.add("Wall of Stone");

        sixthLevelSpells.add("Arcane Gate");
        sixthLevelSpells.add("Blade Barrier");
        sixthLevelSpells.add("Chain Lightning");
        sixthLevelSpells.add("Circle of Death");
        sixthLevelSpells.add("Conjure Fey");
        sixthLevelSpells.add("Contingency");
        sixthLevelSpells.add("Create Undead");
        sixthLevelSpells.add("Disintegrate");
        sixthLevelSpells.add("Drawmij's Instant Summons");
        sixthLevelSpells.add("Eyebite");
        sixthLevelSpells.add("Find the Path");
        sixthLevelSpells.add("Flesh to Stone");
        sixthLevelSpells.add("Forbiddance");
        sixthLevelSpells.add("Globe of Invulnerability");
        sixthLevelSpells.add("Guards of Wards");
        sixthLevelSpells.add("Harm");
        sixthLevelSpells.add("Heal");
        sixthLevelSpells.add("Heroes' Feast");
        sixthLevelSpells.add("Magic Jar");
        sixthLevelSpells.add("Mass Suggestion");
        sixthLevelSpells.add("Move Earth");
        sixthLevelSpells.add("Otilukes's Freezing Sphere");
        sixthLevelSpells.add("Otto's Irresistible Dance");
        sixthLevelSpells.add("Planar Ally");
        sixthLevelSpells.add("Programmed Illusion");
        sixthLevelSpells.add("Sunbeam");
        sixthLevelSpells.add("Transport via Plants");
        sixthLevelSpells.add("True Seeing");
        sixthLevelSpells.add("Wall of Ice");
        sixthLevelSpells.add("Wall of Thorns");
        sixthLevelSpells.add("Wind Walk");
        sixthLevelSpells.add("Word of Recall");

        seventhLevelSpells.add("Conjure Celestial");
        seventhLevelSpells.add("Delayed Blast Fireball");
        seventhLevelSpells.add("Divine Word");
        seventhLevelSpells.add("Etherealness");
        seventhLevelSpells.add("Finger of Death");
        seventhLevelSpells.add("Fire Storm");
        seventhLevelSpells.add("Forecage");
        seventhLevelSpells.add("Mirage Arcane");
        seventhLevelSpells.add("Mordenkainen's Magnificent Mansion");
        seventhLevelSpells.add("Mordenkainen's Sword");
        seventhLevelSpells.add("Plane Shift");
        seventhLevelSpells.add("Prismatic Spray");
        seventhLevelSpells.add("Project Image");
        seventhLevelSpells.add("Regenerate");
        seventhLevelSpells.add("Resurrection");
        seventhLevelSpells.add("Reverse Gravity");
        seventhLevelSpells.add("Sequester");
        seventhLevelSpells.add("Simulation");
        seventhLevelSpells.add("Symbol");
        seventhLevelSpells.add("Teleport");

        eighthLevelSpells.add("Animal Shapes");
        eighthLevelSpells.add("Antimagic Field");
        eighthLevelSpells.add("Antipathy/Sympathy");
        eighthLevelSpells.add("Clone");
        eighthLevelSpells.add("Control Weather");
        eighthLevelSpells.add("Demiplane");
        eighthLevelSpells.add("Dominate Monster");
        eighthLevelSpells.add("Earthquake");
        eighthLevelSpells.add("Feeblemind");
        eighthLevelSpells.add("Glibness");
        eighthLevelSpells.add("Holy Aura");
        eighthLevelSpells.add("Incendiary Cloud");
        eighthLevelSpells.add("Maze");
        eighthLevelSpells.add("Mind Blank");
        eighthLevelSpells.add("Power Word Stun");
        eighthLevelSpells.add("Sunburst");
        eighthLevelSpells.add("Telepathy");
        eighthLevelSpells.add("Tsunami");

        ninthLevelSpells.add("Astral Projection");
        ninthLevelSpells.add("Foresight");
        ninthLevelSpells.add("Gate");
        ninthLevelSpells.add("Imprisonment");
        ninthLevelSpells.add("Mass Heal");
        ninthLevelSpells.add("Meteor Swarm");
        ninthLevelSpells.add("Power Word Heal");
        ninthLevelSpells.add("Power Word Kill");
        ninthLevelSpells.add("Prismatic Wall");
        ninthLevelSpells.add("Shapechange");
        ninthLevelSpells.add("Storm of Vengeance");
        ninthLevelSpells.add("Time Stop");
        ninthLevelSpells.add("True Polymorph");
        ninthLevelSpells.add("True Resurrection");
        ninthLevelSpells.add("Weird");
        ninthLevelSpells.add("Wish");



        if (level==1){
            return firstLevelSpells;
        }
        if (level==2){
            return secondLevelSpells;
        }
        if (level==3){
            return thirdLevelSpells;
        }
        if (level==4){
            return fourthLevelSpells;
        }
        if (level==5){
            return fifthLevelSpells;
        }
        if (level==6){
            return sixthLevelSpells;
        }
        if (level==7){
            return seventhLevelSpells;
        }
        if (level==8) {
            return eighthLevelSpells;

        }if(level ==9){
            return ninthLevelSpells;
        }
        else{
            return cantripList;
        }
    }
}


