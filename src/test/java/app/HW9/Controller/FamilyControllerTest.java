package app.HW9.Controller;

import app.HW9.Entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyControllerTest {
    FamilyController familyController = new FamilyController();

    @BeforeEach
    void setUp() {

        Man father = new Man("Mehman", "Abdull", 1974, 190);
        Woman mother = new Woman("Faxranda", "Abdull", 1976, 190);
        familyController.createNewFamily(father, mother);
    }

    @Test
    void getAllFamilies() {
        int expected = 1;
        int actual = familyController.getAllFamilies().size();

        assertEquals(expected, actual);

    }

    @Test
    void getFamilyByIndex() {
        int index = 0;
        Family expected = familyController.getFamilyByIndex(index);
        Family actual = familyController.getAllFamilies().get(index);

        assertEquals(expected, actual);

    }

    @Test
    void deleteFamily() {
        Man dad = new Man("Meh", "Abb", 1970, 199);
        Woman mom = new Woman("Fax", "Abb", 1972, 199);

        familyController.createNewFamily(dad, mom);
        int index = 1;
        boolean expected = true;
        boolean actual = familyController.deleteFamily(index);

        assertEquals(expected, actual);
    }


    @Test
    void getFamiliesBiggerThan() {
        int index = 1;
        int expected = 1;
        int actual = familyController.getFamiliesBiggerThan(index).size();

        assertEquals(expected, actual);

    }

    @Test
    void getFamiliesLessThan() {
        int index = 3;
        int expected = 1;
        int actual = familyController.getFamiliesLessThan(index).size();

        assertEquals(expected, actual);


    }

    @Test
    void countFamiliesWithMemberNumber() {
        int index = 2;
        int expected = 1;
        int actual = familyController.countFamiliesWithMemberNumber(index).size();
        assertEquals(expected, actual);


    }

    @Test
    void createNewFamily() {
        Man dad = new Man("Meh", "Abb", 1970, 199);
        Woman mom = new Woman("Fax", "Abb", 1972, 199);
        familyController.createNewFamily(dad, mom);
        int expected = 2;
        int actual = familyController.getAllFamilies().size();
        assertEquals(expected, actual);


    }

    @Test
    void bornChild() {
        Man dad = new Man("Meh", "Abb", 1970, 199);
        Woman mom = new Woman("Fax", "Abb", 1972, 199);
        familyController.createNewFamily(dad, mom);
        Family family = familyController.getAllFamilies().get(1);
        familyController.bornChild(family, "Jane", "Alex");

        int expected = 3;
        int actual = family.countFamily();
        assertEquals(expected, actual);

    }

    @Test
    void adoptChild() {
        Man father = new Man("Mehman", "Abdull", 1974, 190);
        Woman mother = new Woman("Faxranda", "Abdull", 1976, 190);
        familyController.familyService.createNewFamily(father, mother);
        Human childAdopt = new Human("Lily", "Abdull", 1990, 189);

        Family family = familyController.getAllFamilies().get(1);
        familyController.adoptChild(family, childAdopt);

        int expected = 3;
        int actual = family.countFamily();
        assertEquals(expected, actual);
    }

    @Test
    void deleteAllChildrenOlderThen() {
        Man father = new Man("Mehman", "Abdull", 1974, 190);
        Woman mother = new Woman("Faxranda", "Abdull", 1976, 190);
        familyController.familyService.createNewFamily(father, mother);
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);
        Family family = familyController.getAllFamilies().get(1);
        family.addChild(maryam);
        family.addChild(gulshan);

        familyController.familyService.deleteAllChildrenOlderThen(21);

        int expected = 2;
        int actual = family.countFamily();

        assertEquals(expected, actual);
    }

    @Test
    void count() {
        int expected = 1;
        int actual = familyController.getAllFamilies().size();

        assertEquals(expected, actual);

    }

    @Test
    void getPets() {
        HashSet<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        Man dad = new Man("Meh", "Abb", 1970, 199);
        Woman mom = new Woman("Fax", "Abb", 1972, 199);
        Pet pet1 = new Dog("Petty", 3, 55, habits);
        Pet pet2 = new Dog("Nino", 3, 50, habits);
        familyController.familyService.createNewFamily(dad, mom);
        Family family = familyController.getAllFamilies().get(1);

        familyController.addPet(1, pet1);
        familyController.addPet(1, pet2);

        int expected = 2;
        int actual = familyController.familyService.getPets(1).size();
        assertEquals(expected, actual);

    }

    @Test
    void addPet() {
        HashSet<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        Man dad = new Man("Meh", "Abb", 1970, 199);
        Woman mom = new Woman("Fax", "Abb", 1972, 199);
        Pet pet1 = new Dog("Petty", 3, 55, habits);
        familyController.familyService.createNewFamily(dad, mom);
        Family family = familyController.getAllFamilies().get(1);

        familyController.addPet(1, pet1);
        familyController.familyService.addPet(1, pet1);

        int expected = 1;
        int actual = familyController.familyService.getPets(1).size();
        assertEquals(expected, actual);
    }
}