package app.HW8;

import java.util.ArrayList;

public final class Woman extends Human {
 public String makeUp(){
  return "I finished my make up.";
 }

 @Override
 public String greetPet(int petIndex) {
  return String.format("Hello, %s. I am your Mummy \n", new ArrayList<>(getFamily().getPets()).get(petIndex).getNickname());
 }
}
