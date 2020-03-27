package app.HW12.Entity;

import app.HW12.Database.Species;

import java.util.HashSet;

public class Dog extends Pet {

    public Dog(String nickname, int age, int trickLevel, HashSet<String > habits) {
        this.setSpecies(Species.DOG.name());
        this.setNickname(nickname);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);
    }

    @Override
    public String respond() {
        return String.format("Hello i am your lovely dog, %s", getNickname());
    }

    @Override
    public String foul() {
        return super.foul();
    }
}
