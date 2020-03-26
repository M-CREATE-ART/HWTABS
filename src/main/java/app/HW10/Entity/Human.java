package app.HW10.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class  Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private HashMap<String, String> schedule = new HashMap<>();

    public Human() {

    }

    public Human(String name, String surname, int year, int iq) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
    }

    public Human(String name, String surname, int year, int iq, Family family ) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public HashMap<String, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(HashMap<String, String> schedule) {
        this.schedule = schedule;
    }

    public String greetPet(int petIndex) {
        return String.format(" Hello, %s", new ArrayList<>(family.getPets()).get(petIndex).getNickname());
    }

    public String describePet(int petIndex) {
        String trick = new ArrayList<>(family.getPets()).get(petIndex).getTrickLevel() >= 50 ? "very sly.\n" : "almost not sly.\n";
        return String.format("I have a %s, he is %d years old, he is %s", new ArrayList<>(family.getPets()).get(petIndex).getSpecies(),new ArrayList<>(family.getPets()).get(petIndex).getAge(), trick);
    }


    @Override
    public String toString() {
        return String.format("Human[name='%s', surname='%s', year=%d, iq=%d]", name, surname, year, iq);
    }

}
