package app.HW13.Entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class  Human {
    private String name;
    private String surname;
    private Family family;
    private long birthDate;
    private int iq;
    private HashMap<String, String> schedule = new HashMap<>();


    public Human() {

    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(birthDate);
            this.birthDate = date.getTime();
        } catch (Exception e) {
            System.out.println("Wrong date input!");
        }
    }

    public Human(String name, String surname, String birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.iq = iq;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(birthDate);
            this.birthDate = date.getTime();
        } catch (Exception e) {
            System.out.println("Wrong date input!");
        }
    }

    public Human(String name, String surname, String birthDate, int iq, Family family ) {
        this.name = name;
        this.surname = surname;
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = format.parse(birthDate);
            this.birthDate = date.getTime();
        } catch (Exception e) {
            System.out.println("Wrong date input!");
        }        this.iq = iq;

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

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
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
        return String.format("I have a %s, he is %d years old, he is %s", new ArrayList<>(family.getPets()).
                get(petIndex).getSpecies(),new ArrayList<>(family.getPets()).get(petIndex).getAge(), trick);
    }

    public String describeAge() {
        LocalDate today = LocalDate.now();
        Date birthday = new Date(birthDate);
        LocalDate localBirthDate = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(localBirthDate, today);
        return String.format("%s years %s months %s days", period.getYears(), period.getMonths(), period.getDays());
    }

    public  String prettyFormat(){

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = formatter.format(birthDate);

        return String.format("{name='%s', surname='%s', Date of birth='%s', iq=%d, schedule=%s}",
                name, surname, dateFormatted, iq, schedule.toString());

    }
    public String humanToFile(){
        return String.format("%s:%s:%d:%d", name, surname, birthDate, iq);
    }

    @Override
    public String toString() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormatted = formatter.format(birthDate);

        return String.format("Human{name='%s', surname='%s', Date of birth='%s', iq=%d, schedule=%s}",
        name, surname, dateFormatted, iq, schedule.toString());
    }

}
