package app.HW9.Entity;

import app.HW9.Database.Species;

import java.util.HashSet;

class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, HashSet<String > habits) {
        this.setSpecies(Species.FISH.name());
        this.setNickname(nickname);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);

    }

    @Override
    public String respond() {
        return String.format("Hello i am your lovely fish, %s", getNickname());
    }


}
