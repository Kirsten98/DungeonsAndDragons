package DungeonsAndDragons;

import java.util.Vector;

public class CharacterSheet {
    private String name;
    private String race;
    private String characterClass;
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
    private String[] lightArmor = {"Padded", "Leather","Studded Leather"};
    private int[] lightArmorAC={11+dexterityMod, 11+dexterityMod, 12+dexterityMod};
    private String[] mediumArmor= {"Hide", "Chain Shirt", "Scale Mail", "Breastplate", "Halfplate"};
    private int[] mediumArmorAC = {12+dexterityMod, 13+dexterityMod , 14+dexterityMod, 14+dexterityMod,15+dexterityMod};
    private String[] heavyArmor = {"Ring Mail", " Chain Mail" , "Splint", "Plate"};
    private int[] heavyArmorAC = {14,16,17,18};
    private boolean shield; // If shield = true , +2 to AC
    private String armor;
    private String[] simpleMeleeWeapons  = {"Club", "Dagger", "Greatclub", "Handaxe", "Javelin", "Light Hammer", "Mace", "Quarterstaff", "Sickle", "Spear"};
    private String[] simpleRangedWeapons = {"Light Crossbow", "Dart", "Sling"};
    private String[] martialMeleeWeapons = {"Battleaxe", "Flail", "Glaive", "Greataxe", "Greatsword", "Halberd", "Lance","Longsword", "Maul","Morningstar", "Pike", "Rapier", "Scimitar", "Shortsword", "Trident", "War Pick", "Warhammer", "Whip"};
    private String[] martialRangedWeapons = {"Blowgun", "Hand Crossbow", "Heavy Crossbow", "Longbow", "Net"};
    private String[] musicalInstruments = {"Bagpipes","Drum","Dulcimer","Flute","Lute","Lyre","Horn","Pan Flute","Shawm","Viol"};
    Vector<String> weapons = new Vector();
    Vector<String> armorList = new Vector<>();
    Vector<String> instruments = new Vector<>();
    Vector<String> languages = new Vector();
     Vector<String> skills = new Vector();
     Vector<String> inventory = new Vector();
     private String[] strengthSkills = {"Athletics"};
     private String[] dexteritySkills = {"Acrobatics","Sleight of Hand","Stealth"};
     private String[] intelligenceSkills = {"Arcana","History","Investigation","Nature","Religion"};
     private String[] wisdomSkills = {"Animal Handling","Insight","Medicine","Perception","Survival"};
     private String[] charismaSkills = {"Deception","Intimidation","Performance","Persuasion"};
     private String[] allSkills = {"Athletics","Acrobatics","Sleight of Hand","Stealth","Arcana","History","Investigation","Nature","Religion","Animal Handling","Insight","Medicine","Perception","Survival","Deception","Intimidation","Performance","Persuasion"};




    public CharacterSheet(String name, String race, String characterClass){
        this.name = name;
        this.race = race;
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
}
