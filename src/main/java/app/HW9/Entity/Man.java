package app.HW9.Entity;

import java.util.ArrayList;

public final class Man extends Human {

    public Man() {
    }

    public Man(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    public Man(String name, String surname, int year, int iq, Family family) {
        super(name, surname, year, iq, family);
    }

    public String repairCar(){
     return "I can repair your car.";
 }

    @Override
    public String greetPet(int petIndex) {
        return String.format("Hello, %s. I am your Dad. \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
    }
}
