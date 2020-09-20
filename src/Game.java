//package com.company;

public class Game {

    String characterName;
    String weaponName;
    int weaponDamage;
    int hp;
    static int hammerMaximumDamage = 50;
    static int hammerMinimumDamage = 10;

    static int hammer = (int) (Math.random() * ((hammerMaximumDamage - hammerMinimumDamage) + 1)) + hammerMinimumDamage;
    static int magicWandMaximumDamage = 100;
    static int magicWandMinimumDamage = 0;
    static int magicWand = (int) (Math.random() * (magicWandMaximumDamage - magicWandMinimumDamage));
    static int excalibur = 1000;

    public Game(String charName, int wDamage, int health, String wName) {
        characterName = charName;
        weaponName = wName;
        weaponDamage = wDamage;
        hp = health;
    }

    public void beingAttacked(String attackerName, int attackerWeaponDamage, String attackerWeaponName) {
        System.out.println(attackerName + " STRIKES " + characterName + " WITH A " + attackerWeaponName);
        if (hp <= 0){
            System.out.println("** YOU CANNOT ATTACK - HE'S ALREADY DEAD, MATE! **");
        }else if(weaponName.equals("Excalibur")) {
            System.out.println("** YOU CANNOT ATTACK SOMEONE WHO HAS EXCALIBUR **");
        } else {
            System.out.println("IT DOES " + attackerWeaponDamage + " DAMAGE");
            hp = (hp - attackerWeaponDamage);
            if(hp < 1){
                System.out.println(characterName + " HAS SNUFFED IT!");
            }else {
                System.out.println(characterName + " HAS " + hp + " REMAINING HEALTH! ");
            }
        }

    }

    public String searchWeapon(String searchWeaponName) {
        switch (searchWeaponName) {
            case "Hammer":
            case "Magic wand":
            case "Excalibur":
                if (searchWeaponName.equals(weaponName)) {
                    System.out.println("Found " + weaponName + " on " + characterName);
                    return characterName;
                } else {
                    //valid weapon but not found
                    System.out.println("Couldn't find " + searchWeaponName + " on " + characterName
                            + " (They have " + weaponName + ")");
                }
                break;
            default:
                //Invalid weapon
                System.out.println("Ghosted!");


        }
        return "";
    }

    public void armWithExcalibur() {
        System.out.println("Arming " + characterName + " with Excalibur");
        weaponName = "Excalibur";
        weaponDamage = excalibur;
    }


    public void drinkingHealingPotion() {
        int healingPotion = 20;
        hp = hp + healingPotion;
        System.out.println(characterName + " GAINED " + healingPotion + " HEALTH BY DRINKING A HEALING POTION");
        System.out.println(characterName + " NOW HAS A HEALTH OF " + hp);
    }

    public static void main(String[] args) {
        Game goodGuy = new Game("Muppet", hammer, 100, "Hammer");
        Game evilGuy = new Game("Geezer", magicWand, 80, "Magic Wand");

        evilGuy.beingAttacked(goodGuy.characterName, goodGuy.weaponDamage, goodGuy.weaponName);
        goodGuy.beingAttacked(evilGuy.characterName, evilGuy.weaponDamage, evilGuy.weaponName);

        goodGuy.drinkingHealingPotion();
        evilGuy.drinkingHealingPotion();

        if (!goodGuy.searchWeapon("Excalibur").equals(goodGuy.characterName)) {
            goodGuy.armWithExcalibur();
        }
        goodGuy.searchWeapon("Excalibur");
        goodGuy.beingAttacked(evilGuy.characterName, evilGuy.weaponDamage, evilGuy.weaponName);
        evilGuy.beingAttacked(goodGuy.characterName, goodGuy.weaponDamage, goodGuy.weaponName);


    }

}