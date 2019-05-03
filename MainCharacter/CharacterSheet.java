package DungeonsAndDragons.MainCharacter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Vector;

public class CharacterSheet {
    // TODO Clean-up, condense weapons/armor into Item[] - Don't fix unless it is broken (Needs to be done but not a priority)
    //TODO make Hash Table to keep track of items and quantity. Key = name of item, Value = quantity
    //TODO Clean-up make vectors / ObservableArrayLists arraylists.
    //TODO Create a "Level Up" Where it levels the user up 1 level without removing previous presets.

    private int primaryKey;
    private String name = "";
    private String race = "";
    private int proficiencyMod;
    private String characterClass = "";
    private int strengthScore;
    private int dexterityScore;
    private int charismaScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaMod;
    private int dexterityMod;
    private int strengthMod;
    private int constitutionMod;
    private int intelligenceMod;
    private int wisdomMod;
    private int speed;
    private String alignment;
    private int age;
    private int hitPoints;
    private int ac;
    private int level;
    private int baseHitPoints;
    private int baseSpeed;
    private ObservableList featuresList = FXCollections.observableArrayList();
    ObservableList classProficienciesList = FXCollections.observableArrayList();
    ObservableList levelProficienciesList = FXCollections.observableArrayList();
    private ObservableList misc = FXCollections.observableArrayList();


    private String[] lightArmor = {"Padded", "Leather","Studded Leather"};
    private int[] lightArmorCost = {5,10,45};
    private int[] lightArmorAC={11+dexterityMod, 11+dexterityMod, 12+dexterityMod};
    private String[] lightArmorDescription = {"Padded armor consists of quilted layers of cloth batting","The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.", "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes"};
    //For when converting 4 separate String Arrays to 1 Item array
//    private Item[] lightArmor = {new Item("Padded","Padded armor consists of quilted layers of cloth batting",0,5),
//        new Item("Leather","The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.",0,10),
//        new Item("Studded Leather","Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes",0,45)};

    private String[] mediumArmor= {"Hide", "Chain Shirt", "Scale Mail", "Breastplate", "Halfplate"};
    private int[] mediumArmorCost = {10,50,50,400,750};
    private int[] mediumArmorAC = {12+dexterityMod, 13+dexterityMod , 14+dexterityMod, 14+dexterityMod,15+dexterityMod};
    private String[] mediumArmorDescription = {"This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.","Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.","This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. This suit includes gauntlets.", "This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.", "Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps."};

    // For when converting 4 separate String Arrays to 1 Item array
    //    private Item[] mediumArmor = {new Item("Hide","This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.",0,10),
//        new Item("Chain Shirt","Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.",0,50),
//        new Item("Scale Mail","This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. This suit includes gauntlets.",0,50),
//        new Item("Breastplate","This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.",0,400),
//        new Item("Halfplate","Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps.",0,750)};

    private String[] heavyArmor = {"Ring Mail", "Chain Mail" , "Splint", "Plate"};
    private int[] heavyArmorCost = {30,75,200,1500};
    private int[] heavyArmorAC = {14,16,17,18};
    private String[] heavyArmorDescriptions= {"This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn by those who can't afford better armor.", "Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets."," This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.", "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body."};
//        For when converting 4 separate String Arrays to 1 Item array
//    private Item[] heavyArmor = {new Item("Ring Mail","This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn by those who can't afford better armor.",0,30),
//            new Item("Chain Mail","Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets.",0,75),
//            new Item("Splint"," This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.",0,200),
//            new Item("Plate","Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body.",0,1500)};
    String[] nonProficientArmor;
    private boolean shield; // If shield = true , +2 to AC
    private String armor;

    private String[] allArmor = {"Padded", "Leather","Studded Leather","Hide", "Chain Shirt", "Scale Mail", "Breastplate", "Halfplate", "Ring Mail",  "Chain Mail" , "Splint", "Plate","Shield"};
    private int[] allArmorCost = {5,10,45,10,50,50,400,750,30,75,200,1500};
    private int[] allArmorAC = {11+dexterityMod, 11+dexterityMod, 12+dexterityMod,12+dexterityMod, 13+dexterityMod , 14+dexterityMod, 14+dexterityMod,15+dexterityMod,14+dexterityMod,16+dexterityMod,17+dexterityMod,18+dexterityMod};
    private String[] allArmorDescriptions = {"Padded armor consists of quilted layers of cloth batting","The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.", "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes","This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.","Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.","This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. This suit includes gauntlets.", "This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.", "Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps.","This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn by those who can't afford better armor.", "Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets."," This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.", "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body."};

//    For when converting 4 separate String Arrays to 1 Item array
//    private Item[] allArmor = {lightArmor[0],lightArmor[1],lightArmor[2],mediumArmor[0],mediumArmor[1],mediumArmor[2],mediumArmor[3],mediumArmor[4],heavyArmor[0],heavyArmor[1],heavyArmor[2],heavyArmor[3]};

    private String[] simpleMeleeWeapons  = {"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear"};
    private String[] simpleMeleeWeaponProperties = {"Light","Finesse, light, thrown(range 20/60)","Two-handed","Light, thrown (range 20/60)","Thrown (range 30/120)","Light, thrown (range 20/60)","","Versatile (1d8)","Light","Thrown (range 20/60), versatile (1d8)"};
    private int[] simpleMeleeWeaponsCost = {1,2,2,5,5,2,5,2,1,1};


    private String[] simpleRangedWeapons = {"Light Crossbow", "Dart", "Shortbow","Sling"};
    private String[] simpleRangedWeaponsProperties = {"Ammunition (range 80/320), loading, two-handed","Finesse, thrown (range 20/60)","Ammunition (range 80/320), two-handed","Ammunition (range 30/120)"};
    private int[] simpleRangedWeaponsCost = {25,5,25,1};


    private String[] martialMeleeWeapons = {"Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance","Longsword", "Maul","Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip"};
    private String[] martialMeleeWeaponsProperties = {"Versatile (1d10)","","Heavy , reach, two-handed","Heavy, two-handed","Heavy , two-handed","Heavy, reach, two-handed","Reach, special","Versatile (1d10)","Heavy, two-handed","","Heavy, reach, two-handed","Finesse","Finesse, light","Finesse, light","Thrown (range 20/60), versatile (1d8","","Versatile (1d10)","Finesse, reach"};
    private int[] martialMeleeWeaponCost = {10,10,20,30,50,20,10,15,10,15,5,25,25,10,5,5,15,2};


    private String[] martialRangedWeapons = {"Blowgun", "Hand Crossbow", "Heavy Crossbow", "Longbow", "Net"};
    private String[] martialRangedWeaponProperties = {"Ammunition (range 25/100), loading","Ammunition (range 30/120), light, loading","Ammunition (range 100/400), heavy, loading, two-handed","Ammunition (range 150/600), heavy, two-handed","Special, thrown (range 5/15)"};
    private int[] martialRangedWeaponCost ={10,75,50,50,1};


    private String[] allWeapons = {"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear","Light Crossbow", "Dart", "Sling","Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance","Longsword", "Maul","Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip", "Blowgun", "Hand Crossbow", "Heavy Crossbow", "Longbow", "Net"};
    private String[] allWeaponsProperties = {"Light","Finesse, light, thrown(range 20/60)","Two-handed","Light, thrown (range 20/60)","Thrown (range 30/120)","Light, thrown (range 20/60)","","Versatile (1d8)","Light","Thrown (range 20/60), versatile (1d8)","Ammunition (range 80/320), loading, two-handed","Finesse, thrown (range 20/60)","Ammunition (range 80/320), two-handed","Ammunition (range 30/120)","Versatile (1d10)","","Heavy , reach, two-handed","Heavy, two-handed","Heavy , two-handed","Heavy, reach, two-handed","Reach, special","Versatile (1d10)","Heavy, two-handed","","Heavy, reach, two-handed","Finesse","Finesse, light","Finesse, light","Thrown (range 20/60), versatile (1d8","","Versatile (1d10)","Finesse, reach","Ammunition (range 25/100), loading","Ammunition (range 30/120), light, loading","Ammunition (range 100/400), heavy, loading, two-handed","Ammunition (range 150/600), heavy, two-handed","Special, thrown (range 5/15)"};
    private int[] allWeaponCost = {1,2,2,5,5,2,5,2,1,1,25,5,25,1,10,10,20,30,50,20,10,15,10,15,5,25,25,10,5,5,15,2,10,75,50,50,1};

    private String[] musicalInstruments = {"Bagpipes","Drum","Dulcimer","Flute","Lute","Lyre","Horn","Pan Flute","Shawm","Viol"};

    Vector<Item> weapons = new Vector();
    Vector<Item> armorList = new Vector<>();
    Vector<String> instruments = new Vector<>();
    Vector<String> languages = new Vector();
     Vector<String> raceTraits = new Vector();
     Vector<Item> inventory = new Vector();

     private String[] strengthSkills = {"Athletics"};
     private String[] dexteritySkills = {"Acrobatics","Sleight of Hand","Stealth"};
     private String[] intelligenceSkills = {"Arcana","History","Investigation","Nature","Religion"};
     private String[] wisdomSkills = {"Animal Handling","Insight","Medicine","Perception","Survival"};
     private String[] charismaSkills = {"Deception","Intimidation","Performance","Persuasion"};
     private String[] allSkills = {"Athletics","Acrobatics","Sleight of Hand","Stealth","Arcana","History","Investigation","Nature","Religion","Animal Handling","Insight","Medicine","Perception","Survival","Deception","Intimidation","Performance","Persuasion"};
    private ObservableList allLanguages = FXCollections.observableArrayList("Common","Dwarvish","Elvish","Giant","Gnomish","Goblin","Halfling","Orc","Abyssal","Celestial","Draconic","Deep Speech","Infernal","Aquan","Auran","Ignan","Terran","Sylvan","Undercommon","Aarakocra","Druidic","Gith","Thieves' Cant","Dambrathan","Bedine","Alzhedo","Chondathan","Damaran","Waelan","Guran","Halruaan","Illuskan","Roushoum","Chessentan","Mulhorandi","Untheric","Thayan","Rashemi","Shaaran","Shou","Tuigan","Turmic","Uluik","Blink Dog","Bullywug","Giant Eagle","Giant Elk","Giant Owl","Gnoll","Grell","Grung","Hook Horror","Kruthik","Modron","Otyugh","Sahuagin","Slaad","Sphinx","Thri-kreen","Tlincalli","Troglodyte","Umber Hulk","Vegepygmy","Winter Wolf","Worg","Yeti");

    String[] allLanguagesArray= {"Common","Dwarvish","Elvish","Giant","Gnomish","Goblin","Halfling","Orc","Abyssal","Celestial","Draconic","Deep Speech","Infernal","Aquan","Auran","Ignan","Terran","Sylvan","Undercommon","Aarakocra","Druidic","Gith","Thieves' Cant","Dambrathan","Bedine","Alzhedo","Chondathan","Damaran","Waelan","Guran","Halruaan","Illuskan","Roushoum","Chessentan","Mulhorandi","Untheric","Thayan","Rashemi","Shaaran","Shou","Tuigan","Turmic","Uluik","Blink Dog","Bullywug","Giant Eagle","Giant Elk","Giant Owl","Gnoll","Grell","Grung","Hook Horror","Kruthik","Modron","Otyugh","Sahuagin","Slaad","Sphinx","Thri-kreen","Tlincalli","Troglodyte","Umber Hulk","Vegepygmy","Winter Wolf","Worg","Yeti"};

    String[] allRaceTraits = {"Artificer's Lore","Brave","Damage resistance: ","Darkvision","Drow Magic","Drow Weapon Training","Dwarven Armor Training","Dwarven Combat Training","Dwarven Resilience","Elf Weapon Training","Fey Ancestry","Gnome Cunning","Halfling Nimbleness","Hellish Resistance","Infernal Legacy","Keen Senses","Lucky","Menacing","Natural Illusionist","Naturally Stealthy","Relentless Endurance","Savage Attacks","Skill Versatility","Speak with Small Beasts","Stonecunning","Stout Resilience","Sunlight Sensitivity","Superior Darkvision","Tinker","Tool Proficiency","Trance"};

    private String[] adventuringGear = {"Shovel","Abacus","Acid","Alchemist's Fire","Arrows","Blowgun Needles","CrossBow Bolts","Sling Bullets","Antitoxin","Crystal","Orb","Rod","Staff","Wand","Backpack","Ball Bearings","Barrel","Basket","Bedroll","Bell","Blanket","Block and Tackle","Book","Bottle","Bucket","Caltrops","Candle","Crossbow Bolt Case","Map or Scroll Case","Chain","Chalk","Chest","Climber's Kit","Common Clothes","Costume Clothes","Fine Clothes","Traveler's Clothes","Component Pouch","Crowbar","Sprig of Mistletoe","Totem","Wooden Staff","Yew Wand","Fishing Tackle","Flask or Tankard","Grappling Hook","Hammer","Sledge Hammer","Healers Kit","Amulet","Emblem","Reliquary","Holy Water","Hourglass","Hunting Trap","Ink","Ink Pen","Jug or Pitcher","Ladder","Lamp","Bullseye Lantern","Hooded Lantern","Lock","Magnifying Glass","Manacles","Mess Kit","Steel Mirror","Oil","Paper","Parchment","Perfume","Miner's Pick","Piton","Basic Poison","Pole","Iron Pot","Potion of Healing","Pouch","Quiver","Portable Ram","Rations","Robes","Hempen Rope","Silk Rope","Sack","Merchants Scale","Sealing Wax","Signal Whistle","Signet Ring","Soap","Spellbook","Iron Spikes","Spy Glass","Two Person Tent","Tinderbox","Torch","Vial","Waterskin","Whetstone"};

    ListView cantripsListView = new ListView();
    ListView firstLevelSpellListView = new ListView();
    ListView secondLevelSpellListView = new ListView();
    ListView thirdLevelSpellListView = new ListView();
    ListView fourthLevelSpellListView = new ListView();
    ListView fifthLevelSpellListView = new ListView();
    ListView sixthLevelSpellListView = new ListView();
    ListView seventhLevelSpellListView = new ListView();
    ListView eighthLevelSpellListView = new ListView();
    ListView ninthLevelSpellListView = new ListView();


    public CharacterSheet() {
    }


    // Base information

    /**
     * Retrieves the Characters Set Name
     * @return String of Characters Names
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Character's name
     * @param name The name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the race of the Character
     * @return Returns a String of the race of the Character
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets the race for the character
     * @param race String of the race the character
     */
    public void setRace(String race) {
        this.race = race;
    }


    /**
     * Retrieves the class of the Character
     * @return String of the class of the Character (Example: "Bard")
     */
    public String getCharacterClass() {
        return characterClass;
    }

    /**
     * Sets the class for the Character
     * @param characterClass String of the class for the Character
     */
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }


    /**
     * Retrieves the age of the Character
     * @return int reflecting the characters age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the characters age
     * @param age int to set the Characters age to
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Retrieves the Character's speed
     * @return int correlating to the characters speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the characters speed based off of the integer provided
     * @param speed integer to set as the character's speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Retrieves the characters base speed in correlation to the characters race.
     * @return int the reflects the character's base speed
     */
    public int getBaseSpeed() {
        return baseSpeed;
    }

    /**
     * Sets the base speed for the character
     * @param baseSpeed int to set the characters base speed
     */
    public void setBaseSpeed(int baseSpeed) {
        this.baseSpeed = baseSpeed;
    }


    /**
     * Retrieves a String of reflecting the character's morale alignment
     * @return String containing the character's morale alignment (Example: Chaotic Neutral)
     */
    public String getAlignment() {
        return alignment;
    }

    /**
     * Sets the character's morale alignment
     * @param alignment String to set the character's morale alignment as.
     */
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }


    /**
     * Retrieves the current maximum hit points of the character
     * @return int reflecting the maximum hit points for the character
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Sets the characters maximum hit points
     * @param hitPoints int to set the character's maximum hit points
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Retrieves the base hit points that the character starts with.
     * @return int reflecting the character's base hit points
     */
    public int getBaseHitPoints() {
        return baseHitPoints;
    }

    /**
     * Sets the character's base hit points. This is used when the character sheet makes any changes by switching classes or races, the base hit points will be the character's starting hit points.
     * @param baseHitPoints int to set as the character's base hit points
     */
    public void setBaseHitPoints(int baseHitPoints) {
        this.baseHitPoints = baseHitPoints;
    }


    /**
     * Retrieves the characters Armor Class modifier
     * @return int reflecting the character's Armor class modifier.
     */
    public int getAc() {
        return ac;
    }

    /**
     * Sets the character's Armor Class modifier
     * @param ac int to set as the character's armor class modifier
     */
    public void setAc(int ac) {
        this.ac = ac;
    }


    /**
     * Retrieves the Character's level
     * @return int reflecting the character's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the character's level
     * @param level int to set the character's level
     */
    public void setLevel(int level) {
        this.level = level;
    }


    // Ability Scores

    /**
     * Retrieves the character's Strength Score
     * @return int reflecting the character's strength score
     */
    public int getStrengthScore() {
        return strengthScore;
    }

    /**
     * Sets the character's Strength score
     * @param strengthScore int to be set as the character's strength score
     */
    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }


    /**
     * Retrieves the character's Dexterity Score
     * @return int reflecting the character's dexterity score
     */
    public int getDexterityScore() {
        return dexterityScore;
    }

    /**
     * Sets the character's Dexterity score
     * @param dexterityMod int to be set as the character's Dexterity score
     */
    public void setDexterityScore(int dexterityMod) {
        this.dexterityScore = dexterityMod;
    }


    /**
     * Retrieves the character's Charisma Score
     * @return int reflecting the character's Charisma score
     */
    public int getCharismaScore() {
        return charismaScore;
    }

    /**
     * Sets the character's Charisma score
     * @param charismaScore int to be set as the character's Charisma score
     */
    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }


    /**
     * Retrieves the character's Constitution Score
     * @return int reflecting the character's Constitution score
     */
    public int getConstitutionScore() {
        return constitutionScore;
    }

    /**
     * Sets the character's Constitution score
     * @param constitutionScore int to be set as the character's Constitution score
     */
    public void setConstitutionScore(int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }


    /**
     * Retrieves the character's Intelligence Score
     * @return int reflecting the character's Intelligence score
     */
    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    /**
     * Sets the character's Intelligence  score
     * @param intelligenceScore int to be set as the character's Intelligence score
     */
    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }


    /**
     * Retrieves the character's Wisdom Score
     * @return int reflecting the character's Wisdom score
     */
    public int getWisdomScore() {
        return wisdomScore;
    }

    /**
     * Sets the character's Wisdom score
     * @param wisdomScore int to be set as the character's Wisdom score
     */
    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }



    // Ability Modifiers

    /**
     * Retrieves the character's Charisma Ability Modifier based off of the Charisma Ability Score
     * @return int reflecting the Charisma Ability Modifier
     */
    public int getCharismaMod() {
        return charismaMod;
    }

    /**
     * Sets the character's Charisma Ability Modifier based off of the Character's Charisma score
     * @param charismaMod int to set the Character's Charisma Ability Modifier
     */
    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
    }


    /**
     * Retrieves the character's Intelligence Ability Modifier based off of the Intelligence Ability Score
     * @return int reflecting the Intelligence Ability Modifier
     */
    public int getIntelligenceMod() {
        return intelligenceMod;
    }

    /**
     * Sets the character's Intelligence Ability Modifier based off of the Character's Intelligence score
     * @param intelligenceMod int to set the Character's Intelligence Ability Modifier
     */
    public void setIntelligenceMod(int intelligenceMod) {
        this.intelligenceMod = intelligenceMod;
    }


    /**
     * Retrieves the character's Wisdom Ability Modifier based off of the Wisdom Ability Score
     * @return int reflecting the Wisdom Ability Modifier
     */
    public int getWisdomMod() {
        return wisdomMod;
    }

    /**
     * Sets the character's Wisdom Ability Modifier based off of the Character's Wisdom score
     * @param wisdomMod int to set the Character's Wisdom Ability Modifier
     */
    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }


    /**
     * Retrieves the character's Constitution Ability Modifier based off of the Constitution Ability Score
     * @return int reflecting the Constitution Ability Modifier
     */
    public int getConstitutionMod() {
        return constitutionMod;
    }

    /**
     * Sets the character's Constitution Ability Modifier based off of the Character's Constitution score
     * @param constitutionMod int to set the Character's Constitution Ability Modifier
     */
    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }


    /**
     * Retrieves the character's Strength Ability Modifier based off of the Strength Ability Score
     * @return int reflecting the Strength Ability Modifier
     */
    public int getStrengthMod() {
        return strengthMod;
    }

    /**
     * Sets the character's Strength Ability Modifier based off of the Character's Strength score
     * @param strengthMod int to set the Character's Strength Ability Modifier
     */
    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }


    /**
     * Retrieves the character's Dexterity Ability Modifier based off of the Dexterity Ability Score
     * @return int reflecting the Dexterity Ability Modifier
     */
    public int getDexterityMod() {
        return dexterityMod;
    }

    /**
     * Sets the character's Dexterity Ability Modifier based off of the Character's Dexterity score
     * @param dexterityMod int to set the Character's Dexterity Ability Modifier
     */
    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }


    // Armor

    /**
     * Retrieves an Array of Strings containing the names of all of the Light Armor options
     * @return String Array containing the possible options for Light Armor
     */
    public String[] getLightArmor() {
        return lightArmor;
    }

    /**
     * Retrieves an int array of the Light Armor AC's. The indexes correlate to the indexes for getLightArmor()
     * @return int Array of all of the light armor AC's
     */
    public int[] getLightArmorAC() {
        return lightArmorAC;
    }

    /**
     * Retrieves an int array of the Light Armor cost. The indexes correlate to the indexes for getLightArmor()
     * @return int Array of all of the light armor cost
     */
    public int[] getLightArmorCost() {
        return lightArmorCost;
    }

    /**
     * Retrieves an String array of the Light Armor description. The indexes correlate to the indexes for getLightArmor()
     * @return String Array of all of the light armor descriptions
     */
    public String[] getLightArmorDescription() {
        return lightArmorDescription;
    }


    /**
     * Retrieves an Array of Strings containing the names of all of the Medium Armor options
     * @return String Array containing the possible options for Medium Armor
     */
    public String[] getMediumArmor() {
        return mediumArmor;
    }

    /**
     * Retrieves an int array of the Medium Armor AC's. The indexes correlate to the indexes for getMediumArmor()
     * @return int Array of all of the Medium armor AC's
     */
    public int[] getMediumArmorAC() {
        return mediumArmorAC;
    }

    /**
     * Retrieves an int array of the Medium Armor cost. The indexes correlate to the indexes for getMediumArmor()
     * @return int Array of all of the Medium armor cost
     */
    public int[] getMediumArmorCost() {
        return mediumArmorCost;
    }

    /**
     * Retrieves a String array of the Medium Armor Descriptions. The indexes correlate to the indexes for getMediumArmor()
     * @return String Array of all of the Medium armor Descriptions
     */
    public String[] getMediumArmorDescription() {
        return mediumArmorDescription;
    }


    /**
     * Retrieves an Array of Strings containing the names of all of the Heavy Armor options
     * @return String Array containing the possible options for Heavy Armor
     */
    public String[] getHeavyArmor() {
        return heavyArmor;
    }

    /**
     * Retrieves an int array of the Heavy Armor AC's. The indexes correlate to the indexes for getHeavyArmor()
     * @return int Array of all of the Heavy armor AC's
     */
    public int[] getHeavyArmorAC() {
        return heavyArmorAC;
    }

    /**
     * Retrieves an int array of the Heavy Armor cost. The indexes correlate to the indexes for getHeavyArmor()
     * @return int Array of all of the Heavy armor cost
     */
    public int[] getHeavyArmorCost() {
        return heavyArmorCost;
    }

    /**
     * Retrieves a String array of the Heavy Armor descriptions. The indexes correlate to the indexes for getHeavyArmor()
     * @return String Array of all of the Heavy armor descriptions
     */
    public String[] getHeavyArmorDescriptions() {
        return heavyArmorDescriptions;
    }

    /**
     * Retrieves if the character contains a shield
     * @return True of the character has a shield, false otherwise
     */
    public boolean isShield() {
        return shield;
    }

    /**
     * Sets the character boolean to if they have a shield
     * @param shield Parameter should be true if the character has a shield, false otherwise
     */
    public void setShield(boolean shield) {
        this.shield = shield;
    }

//TODO Remove getArmor() and setArmor() amd use the armor list in RPGCharacterSheet
    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }


    /**
     * Retrieves an Array of Strings containing all of the names of all of the Armor options (Light / Medium/ Heavy)
     * @return String Array containing all of the possible options for Armor
     */
    public String[] getAllArmor() {
        return allArmor;
    }

    /**
     * Retrieves an int array of all of the Armor costs. The indexes correlate to the indexes for getAllArmor()
     * @return int Array of all of the armor costs
     */
    public int[] getAllArmorCost() {
        return allArmorCost;
    }

    /**
     * Retrieves an int array of all of the Armor AC's. The indexes correlate to the indexes for getAllArmor()
     * @return int Array of all of the- armor AC's
     */
    public int[] getAllArmorAC() {
        return allArmorAC;
    }

    /**
     * Retrieves an String array of all of the Armor descriptions. The indexes correlate to the indexes for getAllArmor()
     * @return String Array of all of the armor descriptions
     */
    public String[] getAllArmorDescriptions() {
        return allArmorDescriptions;
    }


    // Weapons

    /**
     * Retrieves String array of all listed Simple Melee Weapons (Cannot be changed)
     * @return String Array of all listed Simple Melee Weapons
     */
    public String[] getSimpleMeleeWeapons() {
        return simpleMeleeWeapons;
    }

    /**
     * Retrieves String array of all listed Simple Melee Weapons properties (Cannot be changed) indexes are in correspondence of getSimpleMeleeWeapons()
     * @return String Array of all listed Simple Melee Weapons properties
     */
    public String[] getSimpleMeleeWeaponProperties() {
        return simpleMeleeWeaponProperties;
    }

    /**
     * Retrieves integer array of all listed Simple Melee Weapons costs (Cannot be changed) indexes are in correspondence of getSimpleMeleeWeapons()
     * @return int Array of all listed Simple Melee Weapons costs
     */
    public int[] getSimpleMeleeWeaponsCost() {
        return simpleMeleeWeaponsCost;
    }


    /**
     * Retrieves String array of all listed Simple Ranged Weapons (Cannot be changed)
     * @return String Array of all listed Simple Ranged Weapons
     */
    public String[] getSimpleRangedWeapons() {
        return simpleRangedWeapons;
    }

    /**
     * Retrieves String array of all listed Simple Ranged Weapons properties (Cannot be changed) indexes are in correspondence of getSimpleRangedWeapons()
     * @return String Array of all listed Simple Ranged Weapons properties
     */
    public String[] getSimpleRangedWeaponsProperties() {
        return simpleRangedWeaponsProperties;
    }

    /**
     * Retrieves int array of all listed Simple Ranged Weapons costs (Cannot be changed) indexes are in correspondence of getSimpleRangedWeapons()
     * @return int Array of all listed Simple Ranged Weapons costs
     */
    public int[] getSimpleRangedWeaponsCost() {
        return simpleRangedWeaponsCost;
    }


    /**
     * Retrieves String array of all listed Martial Melee Weapons (Cannot be changed)
     * @return String Array of all listed Martial Melee Weapons
     */
    public String[] getMartialMeleeWeapons() {
        return martialMeleeWeapons;
    }

    /**
     * Retrieves String array of all listed Martial Melee Weapons properties (Cannot be changed) indexes are in correspondence of getMartialMeleeWeapons()
     * @return String Array of all listed Martial Melee Weapons properties
     */
    public String[] getMartialMeleeWeaponsProperties() {
        return martialMeleeWeaponsProperties;
    }

    /**
     * Retrieves int array of all listed Martial Melee Weapons costs (Cannot be changed) indexes are in correspondence of getMartialMeleeWeapons()
     * @return int Array of all listed Martial Melee Weapons costs
     */
    public int[] getMartialMeleeWeaponCost() {
        return martialMeleeWeaponCost;
    }


    /**
     * Retrieves String array of all listed Martial Ranged Weapons (Cannot be changed)
     * @return String Array of all listed Martial Ranged Weapons
     */
    public String[] getMartialRangedWeapons() {
        return martialRangedWeapons;
    }

    /**
     * Retrieves String array of all listed Martial Ranged Weapons properties (Cannot be changed) indexes are in correspondence of getMartialRangedWeapons()
     * @return String Array of all listed Martial Ranged Weapons properties
     */
    public String[] getMartialRangedWeaponProperties() {
        return martialRangedWeaponProperties;
    }

    /**
     * Retrieves int array of all listed Martial Ranged Weapons costs (Cannot be changed) indexes are in correspondence of getMartialRangedWeapons()
     * @return int Array of all listed Martial Ranged Weapons costs
     */
    public int[] getMartialRangedWeaponCost() {
        return martialRangedWeaponCost;
    }


    /**
     * Retrieves String array of all Weapons (Cannot be changed)
     * @return String Array of all listed Weapons
     */
    public String[] getAllWeapons() {
        return allWeapons;
    }

    /**
     * Retrieves String array of all listed Weapons properties (Cannot be changed) indexes are in correspondence of getAllWeapons()
     * @return String Array of all listed Weapons properties
     */
    public String[] getAllWeaponsProperties() {
        return allWeaponsProperties;
    }

    /**
     * Retrieves int array of all listed Weapons costs (Cannot be changed) indexes are in correspondence of getAllWeapons()
     * @return int Array of all listed Weapons costs
     */
    public int[] getAllWeaponCost() {
        return allWeaponCost;
    }


    // Instruments

    /**
     * Retrieves String array containing all of the listed musical instruments (Cannot be changed)
     * @return String Array that contains all the listed musical instruments
     */
    public String[] getMusicalInstruments() {
        return musicalInstruments;
    }


    //Skills

    /**
     * Retrieves a String of all the ability skills (Cannot be changed)
     * @return String array of all the ability skills
     */
    public String[] getAllSkills() {
        return allSkills;
    }

    /**
     * Retrieves a String of all the Charisma ability skills (Cannot be changed)
     * @return String array of all the Charisma ability skills
     */
    public String[] getCharismaSkills() {
        return charismaSkills;
    }

    /**
     * Retrieves a String of all the Wisdom ability skills (Cannot be changed)
     * @return String array of all the Wisdom ability skills
     */
    public String[] getWisdomSkills() {
        return wisdomSkills;
    }

    /**
     * Retrieves a String of all the Intelligence ability skills (Cannot be changed)
     * @return String array of all the Intelligence ability skills
     */
    public String[] getIntelligenceSkills() {
        return intelligenceSkills;
    }

    /**
     * Retrieves a String of all the Dexterity ability skills (Cannot be changed)
     * @return String array of all the Dexterity ability skills
     */
    public String[] getDexteritySkills() {
        return dexteritySkills;
    }

    /**
     * Retrieves a String of all the Strength ability skills (Cannot be changed)
     * @return String array of all the Strength ability skills
     */
    public String[] getStrengthSkills() {
        return strengthSkills;
    }


    // Features

    /**
     * Observable list that tracks the character's features, can be modified throughout the character creation
     * @return Observable list of character's current features
     */
    public ObservableList getFeaturesList() {
        return featuresList;
    }


    // Misc

    /**
     * Observable list that tracks the character's miscellaneous features that can be modified throughout the character's creation based on their class.
     * @return Observable list of character's current miscellaneous features
     */
    public ObservableList getMisc() {
        return misc;
    }

    /**
     * Sets the character's list of miscellaneous features.
     * @param misc Observable list to set as the character's miscellaneous features
     */
    public void setMisc(ObservableList misc) {
        this.misc = misc;
    }


    // Languages

    /**
     * Retrieves observable list of all the languages listed in Player's Handbook (Should not be changed)
     * @return Observable list of all the languages listed in the player's handbook
     */
    public ObservableList getAllLanguages() {
        return allLanguages;
    }


    // SQL information

    /**
     * Retrieves the primary key for the character sheet information in the SQL Schema
     * @return int to represent the primary key in SQL Schema for that user
     */
    public int getPrimaryKey() {
        return primaryKey;
    }

    /**
     * Set's the character sheets primary key for the SQL Schema. Should only be set once the username and password has been set
     * @param primaryKey int to represent as the character sheet's primary key in SQL Schema
     */
    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }


   // Proficiency

    /**
     * Retrieves the proficiency modifier for the character
     * @return int reflecting the character's proficiency modifier
     */
    public int getProficiencyMod() {
        return proficiencyMod;
    }

    /**
     * Sets the proficiency modifier for the character
     * @param proficiencyMod int to set as the character's proficiency modifier
     */
    public void setProficiencyMod(int proficiencyMod) {
        this.proficiencyMod = proficiencyMod;
    }


    // Adventuring Gear

    /**
     * Retrieves String Array adventuring gear options listed in the Player Handbook (Cannot be changed)
     * @return String Array adventuring gear options listed in the Player Handbook
     */
    public String[] getAdventuringGear() {
        return adventuringGear;
    }
}
