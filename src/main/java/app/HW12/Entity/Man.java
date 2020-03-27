package app.HW12.Entity;

import java.util.ArrayList;

public final class Man extends Human {

    public Man() {
    }

    public Man(String name, String surname, String birthDate, int iq) {
        super(name, surname, birthDate, iq);
    }

    public Man(String name, String surname, String birthDate, int iq, Family family) {
        super(name, surname, birthDate, iq, family);
    }

    public String repairCar(){
     return "I can repair your car.";
 }

    @Override
    public String greetPet(int petIndex) {
        return String.format("Hello, %s. I am your Dad. \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
    }
}
