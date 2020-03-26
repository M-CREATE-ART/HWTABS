package app.HW11.Entity;

import java.util.ArrayList;

public final class Woman extends Human {
 public Woman() {
 }

 public Woman(String name, String surname, String birthDate, int iq) {
  super(name, surname, birthDate, iq);
 }

 public Woman(String name, String surname, String birthDate, int iq, Family family) {
  super(name, surname, birthDate, iq, family);
 }

 public String makeUp(){
  return "I finished my make up.";
 }

 @Override
 public String greetPet(int petIndex) {
  return String.format("Hello, %s. I am your Mummy \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
 }
}
