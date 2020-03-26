package app.HW8;

import java.util.ArrayList;

public final class Man extends Human {

 public String repairCar(){
     return "I can repair your car.";
 }

    @Override
    public String greetPet(int petIndex) {
        return String.format("Hello, %s. I am your Dad. \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
    }
}
