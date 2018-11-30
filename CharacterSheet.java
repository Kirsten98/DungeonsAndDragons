package DungeonsAndDragons;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Vector;

public class CharacterSheet {

    private int primaryKey;

    private String name = "";
    private String race = "";
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
    private ObservableList featuresList = FXCollections.observableArrayList();
    private ObservableList proficienciesList = FXCollections.observableArrayList();
    private ObservableList misc = FXCollections.observableArrayList();
    private String[] lightArmor = {"Padded", "Leather","Studded Leather"};
    private int[] lightArmorCost = {5,10,45};
    private int[] lightArmorAC={11+dexterityMod, 11+dexterityMod, 12+dexterityMod};
    private String[] lightArmorDescription = {"Padded armor consists of quilted layers of cloth batting","The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.", "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes"};

    private String[] mediumArmor= {"Hide", "Chain Shirt", "Scale Mail", "Breastplate", "Halfplate"};
    private int[] mediumArmorCost = {10,50,50,400,750};
    private int[] mediumArmorAC = {12+dexterityMod, 13+dexterityMod , 14+dexterityMod, 14+dexterityMod,15+dexterityMod};
    private String[] mediumArmorDescription = {"This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.","Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.","This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. This suit includes gauntlets.", "This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.", "Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps."};

    private String[] heavyArmor = {"Ring Mail", " Chain Mail" , "Splint", "Plate"};
    private int[] heavyArmorCost = {30,75,200,1500};
    private int[] heavyArmorAC = {14,16,17,18};
    private String[] heavyArmorDescriptions= {"This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn by those who can't afford better armor.", "Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets."," This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.", "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body."};

    private boolean shield; // If shield = true , +2 to AC
    private String armor;

    private String[] allArmor = {"Padded", "Leather","Studded Leather","Hide", "Chain Shirt", "Scale Mail", "Breastplate", "Halfplate", "Ring Mail",  "Chain Mail" , "Splint, Plate"};
    private int[] allArmorCost = {5,10,45,10,50,50,400,750,30,75,200,1500};
    private int[] allArmorAC = {11+dexterityMod, 11+dexterityMod, 12+dexterityMod,12+dexterityMod, 13+dexterityMod , 14+dexterityMod, 14+dexterityMod,15+dexterityMod,14+dexterityMod,16+dexterityMod,17+dexterityMod,18+dexterityMod};
    private String[] allArmorDescriptions = {"Padded armor consists of quilted layers of cloth batting","The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.", "Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes","This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.","Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.","This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. This suit includes gauntlets.", "This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.", "Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps.","This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn by those who can't afford better armor.", "Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets."," This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.", "Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body."};

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
     Vector<String> skills = new Vector();
     Vector<Item> inventory = new Vector();
//    Vector<String> inventory = new Vector();
     private String[] strengthSkills = {"Athletics"};
     private String[] dexteritySkills = {"Acrobatics","Sleight of Hand","Stealth"};
     private String[] intelligenceSkills = {"Arcana","History","Investigation","Nature","Religion"};
     private String[] wisdomSkills = {"Animal Handling","Insight","Medicine","Perception","Survival"};
     private String[] charismaSkills = {"Deception","Intimidation","Performance","Persuasion"};
     private String[] allSkills = {"Athletics","Acrobatics","Sleight of Hand","Stealth","Arcana","History","Investigation","Nature","Religion","Animal Handling","Insight","Medicine","Perception","Survival","Deception","Intimidation","Performance","Persuasion"};
    private ObservableList allLanguages = FXCollections.observableArrayList("Common","Dwarvish","Elvish","Giant","Gnomish","Goblin","Halfling","Orc","Abyssal","Celestial","Draconic","Deep Speech","Infernal","Aquan","Auran","Ignan","Terran","Sylvan","Undercommon","Aarakocra","Druidic","Gith","Thieves' Cant","Dambrathan","Bedine","Alzhedo","Chondathan","Damaran","Waelan","Guran","Halruaan","Illuskan","Roushoum","Chessentan","Mulhorandi","Untheric","Thayan","Rashemi","Shaaran","Shou","Tuigan","Turmic","Uluik","Blink Dog","Bullywug","Giant Eagle","Giant Elk","Giant Owl","Gnoll","Grell","Grung","Hook Horror","Kruthik","Modron","Otyugh","Sahuagin","Slaad","Sphinx","Thri-kreen","Tlincalli","Troglodyte","Umber Hulk","Vegepygmy","Winter Wolf","Worg","Yeti");

    public CharacterSheet( int primaryKey) {
        this.primaryKey = primaryKey;
    }


    public String getName() {
         return name;
    }


    public String getRace() {
        return race;
    }



    public String getCharacterClass() {
        return characterClass;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }
    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

    public int getDexterityScore() {
        return dexterityScore;
    }

    public void setDexterityScore(int dexterityMod) {
        this.dexterityScore = dexterityMod;
    }

    public int getCharismaScore() {
        return charismaScore;
    }

    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }

    public int getConstitutionScore() {
        return constitutionScore;
    }

    public void setConstitutionScore(int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public int getWisdomScore() {
        return wisdomScore;
    }

    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getCharismaMod() {
        return charismaMod;
    }

    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
    }

    public int getIntelligenceMod() {
        return intelligenceMod;
    }

    public void setIntelligenceMod(int intelligenceMod) {
        this.intelligenceMod = intelligenceMod;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public int getConstitutionMod() {
        return constitutionMod;
    }

    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }


    public int getDexterityMod() {
        return dexterityMod;
    }

    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }

    public String[] getLightArmor() {
        return lightArmor;
    }

    public int[] getLightArmorAC() {
        return lightArmorAC;
    }

    public String[] getMediumArmor() {
        return mediumArmor;
    }

    public int[] getMediumArmorAC() {
        return mediumArmorAC;
    }

    public String[] getHeavyArmor() {
        return heavyArmor;
    }

    public int[] getHeavyArmorAC() {
        return heavyArmorAC;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String[] getSimpleMeleeWeapons() {
        return simpleMeleeWeapons;
    }

    public void setSimpleMeleeWeapons(String[] simpleMeleeWeapons) {
        this.simpleMeleeWeapons = simpleMeleeWeapons;
    }

    public String[] getSimpleRangedWeapons() {
        return simpleRangedWeapons;
    }

    public void setSimpleRangedWeapons(String[] simpleRangedWeapons) {
        this.simpleRangedWeapons = simpleRangedWeapons;
    }

    public String[] getMartialMeleeWeapons() {
        return martialMeleeWeapons;
    }

    public void setMartialMeleeWeapons(String[] martialMeleeWeapons) {
        this.martialMeleeWeapons = martialMeleeWeapons;
    }

    public String[] getMartialRangedWeapons() {
        return martialRangedWeapons;
    }

    public void setMartialRangedWeapons(String[] martialRangedWeapons) {
        this.martialRangedWeapons = martialRangedWeapons;
    }

    public String[] getMusicalInstruments() {
        return musicalInstruments;
    }

    public void setMusicalInstruments(String[] musicalInstruments) {
        this.musicalInstruments = musicalInstruments;
    }

    public String[] getAllSkills() {
        return allSkills;
    }

    public String[] getCharismaSkills() {
        return charismaSkills;
    }

    public String[] getWisdomSkills() {
        return wisdomSkills;
    }

    public String[] getIntelligenceSkills() {
        return intelligenceSkills;
    }

    public String[] getDexteritySkills() {
        return dexteritySkills;
    }

    public String[] getStrengthSkills() {
        return strengthSkills;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public String[] getAllWeapons() {
        return allWeapons;
    }

    public int[] getLightArmorCost() {
        return lightArmorCost;
    }

    public int[] getMediumArmorCost() {
        return mediumArmorCost;
    }

    public int[] getHeavyArmorCost() {
        return heavyArmorCost;
    }

    public String[] getLightArmorDescription() {
        return lightArmorDescription;
    }

    public String[] getMediumArmorDescription() {
        return mediumArmorDescription;
    }

    public String[] getHeavyArmorDescriptions() {
        return heavyArmorDescriptions;
    }

    public String[] getSimpleMeleeWeaponProperties() {
        return simpleMeleeWeaponProperties;
    }

    public int[] getSimpleMeleeWeaponsCost() {
        return simpleMeleeWeaponsCost;
    }

    public String[] getSimpleRangedWeaponsProperties() {
        return simpleRangedWeaponsProperties;
    }

    public int[] getSimpleRangedWeaponsCost() {
        return simpleRangedWeaponsCost;
    }

    public String[] getMartialMeleeWeaponsProperties() {
        return martialMeleeWeaponsProperties;
    }

    public int[] getMartialMeleeWeaponCost() {
        return martialMeleeWeaponCost;
    }

    public String[] getMartialRangedWeaponProperties() {
        return martialRangedWeaponProperties;
    }

    public int[] getMartialRangedWeaponCost() {
        return martialRangedWeaponCost;
    }

    public String[] getAllWeaponsProperties() {
        return allWeaponsProperties;
    }

    public int[] getAllWeaponCost() {
        return allWeaponCost;
    }

    public String[] getAllArmor() {
        return allArmor;
    }

    public int[] getAllArmorCost() {
        return allArmorCost;
    }

    public int[] getAllArmorAC() {
        return allArmorAC;
    }

    public String[] getAllArmorDescriptions() {
        return allArmorDescriptions;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ObservableList getFeaturesList() {
        return featuresList;
    }

    public void setFeaturesList(ObservableList featuresList) {
        this.featuresList = featuresList;
    }

    public ObservableList getProficienciesList() {
        return proficienciesList;
    }

    public void setProficienciesList(ObservableList proficienciesList) {
        this.proficienciesList = proficienciesList;
    }

    public ObservableList getMisc() {
        return misc;
    }

    public void setMisc(ObservableList misc) {
        this.misc = misc;
    }

    public ObservableList getAllLanguages() {
        return allLanguages;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }
}
