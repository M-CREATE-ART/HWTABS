package app.HW8;

import app.HW8.Family;
import app.HW8.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyTest {


    Family family;

    @BeforeEach
    void setUp() {
        Human father = new Human("Mehman", "Abdull", 1974, 190);
        Human mother = new Human("Faxranda", "Abdull", 1976, 190);
        ArrayList<Human> children = new ArrayList<>();
        family = new Family(father, mother, children);

    }

    @Test
    void addChild() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);

        family.addChild(maryam);
        family.addChild(gulshan);

        int expected = 4;
        int actual = family.countFamily();
        assertEquals(expected, actual);

    }

    @Test
    void deleteChild() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);
        family.addChild(maryam);
        family.addChild(gulshan);

        boolean expected = true;
        boolean actual = family.deleteChild(0);
        assertEquals(expected, actual);
    }

    @Test
    void deleteChild2() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);
        family.addChild(maryam);
        family.addChild(gulshan);

        boolean expected = false;
        boolean actual = family.deleteChild(3);
        assertEquals(expected, actual);
    }

    @Test
    void deleteChild3() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);
        family.addChild(maryam);
        family.addChild(gulshan);

        boolean expected = true;
        boolean actual = family.deleteChild(maryam);
        assertEquals(expected, actual);
    }

    @Test
    void deleteChild4() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 1998, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 1997, 161);
        family.addChild(maryam);

        boolean expected = false;
        boolean actual = family.deleteChild(gulshan);
        assertEquals(expected, actual);
    }

    @Test
    void countFamily() {
        Human maryam = new Human("Maryam", "Mammadzadeh", 198, 157);
        Human gulshan = new Human("Gulshan", "Mammadzadeh", 198, 161);
        family.addChild(maryam);
        family.addChild(gulshan);
        int expected = 4;
        int actual = family.countFamily();
        assertEquals(expected, actual);
    }

}