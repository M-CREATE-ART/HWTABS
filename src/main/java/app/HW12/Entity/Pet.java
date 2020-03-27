package app.HW12.Entity;

import app.HW12.Database.Species;

import java.util.HashSet;

public abstract class Pet {
    private String nickname;
    private String species;
    private int age;
    private int trickLevel;
    private HashSet<String> habits = new HashSet<>();


    public Pet() {
    }

    public Pet(String nickname, int age, int trickLevel, HashSet<String> habits) {
        this.species = Species.UNKNOWN.name();
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public HashSet<String> getHabits() {
        return habits;
    }

    public void setHabits(HashSet<String> habits) {
        this.habits = habits;
    }

    public String eat() {
        return String.format("I am eating");
    }

    public abstract String respond();

    public String foul() {
        return String.format("I need to cover it up");
    }

    public  String prettyFormat(){
        return String.format("[species=%s', nickname=%s', age=%d, trickLevel=%d, habits=%s']",
                species, nickname, age, trickLevel, habits);
    }

    @Override
    public String toString() {
        return String.format("Pet[species=%s', nickname=%s', age=%d, trickLevel=%d, habits=%s']",
                species, nickname, age, trickLevel, habits);
    }


}
