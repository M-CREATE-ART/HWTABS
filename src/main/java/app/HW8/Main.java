package app.HW8;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        HashMap<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(),
                "do home work");
        schedule.put(DayOfWeek.TUESDAY.name(),
                "go to courses");
        schedule.put(DayOfWeek.WEDNESDAY.name(),
                "watch a film");
        schedule.put(DayOfWeek.THURSDAY.name(),
                "go for a walk");
        schedule.put(DayOfWeek.FRIDAY.name(),
                "meet with friends");
        schedule.put(DayOfWeek.SATURDAY.name(),
                "play football");
        schedule.put(DayOfWeek.SUNDAY.name(),
                "do not go out");
        Human father = new Human("Mehman", "Abdull", 1974, 190);
        Human mother = new Human("Faxranda", "Abdull", 1976, 190);
        ArrayList<Human> children= new ArrayList<>();
        Human maryam= new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan= new Human("Gulshan", "Mammadzadeh", 1997, 161);
        HashSet<String > habits= new HashSet<String>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");


        Set<Pet> pets = new HashSet<>();
        Pet pet = new Dog("Rock", 5, 75, habits);
        pets.add(pet);
        Family abdull= new Family(father, mother, children);
        abdull.addChild(maryam);
        abdull.addChild(gulshan);
        abdull.setPets(pets);

        abdull.countFamily();


    }
}
