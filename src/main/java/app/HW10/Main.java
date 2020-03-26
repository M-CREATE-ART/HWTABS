package app.HW10;

import app.HW10.Controller.FamilyController;
import app.HW10.Entity.*;
import app.HW10.Entity.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FamilyController familyController = new FamilyController();

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

        Man father = new Man("Mehman", "Abdull", "15/03/1974", 190);
        Woman mother = new Woman("Faxranda", "Abdull", "10/05/2000", 190);

        ArrayList<Human> children = new ArrayList<>();

        Family abdull = new Family(father, mother, children);

        Set<Pet> pets = new HashSet<>();

        Human maryam = new Human("Maryam", "Mammadzadeh", "20/09/1998", 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", "08/08/1997", 161);
        children.add(maryam);
        children.add(gulshan);
        familyController.saveFamily(abdull);

        HashSet<String> habits = new HashSet<String>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        Pet pet = new Dog("Rock", 5, 75, habits);
        pets.add(pet);
        abdull.setPets(pets);

        System.out.println("GetAllFamily");

        System.out.println(familyController.getAllFamilies());

        System.out.println("GetFamilyByIndex");

        System.out.println(familyController.getFamilyByIndex(0));
        familyController.deleteFamily(0);

        System.out.println("FamilyAfterDelete");

        System.out.println(familyController.getAllFamilies());
        Man dad = new Man("Meh", "Abb", "03/03/1995", 199);
        Woman mom = new Woman("Fax", "Abb", "15/07/2001", 199);

        ArrayList<Human> children1= new ArrayList<>();
        Human child1 = new Human();
        children.add(child1);
        Family abb = new Family(dad, mom, children1);
        familyController.getAllFamilies().add(abb) ;

        System.out.println(familyController.displayAllFamilies());

        familyController.bornChild(abb, "Alex", "Alexandra");
        Human adoptChild= new Human();
        Human anna = new Human("Anna", "Abb", "12/02/1995", 157);
        Human annal = new Human("Annal", "Abb", "15/05/1996", 161);
        children1.add(anna);
        children1.add(annal);
        familyController.adoptChild(abb, adoptChild);

        System.out.println("AfterBorningAndAdoptingChild");

        System.out.println(familyController.getAllFamilies());

        familyController.deleteAllChildrenOlderThen(21);

        System.out.println("AfterDeletingOlderChild");

        System.out.println(familyController.getAllFamilies());

        System.out.println("Counting");

        System.out.println(familyController.count());

        System.out.println("GettingPets");

        System.out.println(familyController.getPets(0));
        HashSet<String> habitss = new HashSet<>();
        habitss.add("eat");
        habitss.add("drink");
        habitss.add("sleep");
        Pet petto = new Dog("Petty", 5, 45, habitss);
        familyController.addPet(0, petto);

        System.out.println("LastGettingAllFamily");

        System.out.println(familyController.getAllFamilies());


    }
}
