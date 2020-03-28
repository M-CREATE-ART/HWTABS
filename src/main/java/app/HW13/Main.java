package app.HW13;

import app.HW13.Controller.FamilyController;
import app.HW13.Entity.*;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder();
        sb.append("\n1. Fill the test data\n");
        sb.append("2. Display the entire list of families\n");
        sb.append("3. Display a list of families where the number of people is greater than the specified number\n");
        sb.append("4. Display a list of families where the number of people is less than the specified number\n");
        sb.append("5. Calculate the number of families where the number of members is\n");
        sb.append("6. Create a new family\n");
        sb.append("7. Delete a family by its index in the general list\n");
        sb.append("8. Edit a family by its index in the general list\n");
        sb.append("9. Remove all children over the age of majority\n");
        sb.append("10. Save and Exit\n");

        FamilyController familyController = new FamilyController();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("10")) {

            System.out.println(sb.toString());
            System.out.print("Please enter your command by index: ");
            command = scanner.next();
            switch (command) {
                case "1": {

                    System.out.println("Load your data");
                    familyController.getData();
                    System.out.println(" Your data has been loaded :)");

                    break;
                }

                case "2": {
                    System.out.println(familyController.displayAllFamilies());
                    System.out.println("Please press enter to go back to main menu. \n");
                    break;
                }

                case "3": {
                    System.out.println("Enter the count of family mambers ");
                    try {
                        int count = scanner.nextInt();
                        familyController.getFamiliesBiggerThan(count).forEach(family -> System.out.println(family.prettyFormat()));
                        System.out.println("Please press enter to go back to main menu. \n");
                        command = scanner.next();
                    } catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.next();
                    }

                    break;
                }

                case "4": {
                    System.out.println("Enter the count of family mambers ");
                    try {
                        int count1 = scanner.nextInt();
                        familyController.getFamiliesLessThan(count1).forEach(family -> System.out.println(family.prettyFormat()));
                        System.out.println("Please press enter to go back to main menu. \n");
                        command = scanner.next();
                    } catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.next();
                    }

                    break;
                }

                case "5": {
                    System.out.println("Enter the count of family mambers ");
                    try {
                        int count2 = scanner.nextInt();
                        familyController.countFamiliesWithMemberNumber(count2).forEach(family -> System.out.println(family.prettyFormat()));
                        System.out.println("Please press enter to go back to main menu. \n");
                        command = scanner.next();
                    } catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.next();
                    }

                    break;
                }

                case "6": {
                    try {
                        System.out.println("Mother's name:");
                        String nameMother = scanner.next();
                        System.out.println("Mother's last name:");
                        String surnameMother = scanner.next();
                        System.out.println("Mother's birth year");
                        int birthyearMother = scanner.nextInt();
                        System.out.println("Mother's birth month");
                        int birthMonthMother = scanner.nextInt();
                        System.out.println("Mother's birth day");
                        int birthDayMother = scanner.nextInt();
                        String motherBirthDate = String.format("%d/%d/%d", birthDayMother, birthMonthMother, birthyearMother);

                        System.out.println("Father's name:");
                        String nameFather = scanner.next();
                        System.out.println("Father's last name:");
                        String surnameFather = scanner.next();
                        System.out.println("Father's birth year");
                        int birthyearFather = scanner.nextInt();
                        System.out.println("Father's birth month");
                        int birthMonthFather = scanner.nextInt();
                        System.out.println("Father's birth day");
                        int birthDayFather = scanner.nextInt();
                        String fatherBirthDate = String.format("%d/%d/%d", birthDayFather, birthMonthFather, birthyearFather);

                        familyController.createNewFamily(new Man(nameFather, surnameFather, fatherBirthDate, 90),
                                new Woman(nameMother, surnameMother, motherBirthDate, 90));

                        HashSet<String> habits = new HashSet<String>();
                        habits.add("eat");
                        habits.add("drink");
                        habits.add("sleep");

                        Set<Pet> pets = new HashSet<>();
                        Pet rock = new Dog("Rock", 5, 75, habits);

                        familyController.addPet(familyController.getAllFamilies().size() - 1, rock);

                        System.out.println("Family created successfully :). Please press enter to go back to main menu.");
                    } catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");

                    }

                    break;

                }

                case "7": {
                    try {
                        System.out.println("Please, enter the ID of family that you want to delete");
                        int ID = scanner.nextInt();
                        familyController.deleteFamily(ID);

                    } catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.next();
                    }
                    break;
                }


                case "8": {
                    try {

                    System.out.println("Choose the option \n 1.Give birth to a baby. \n 2.Adopt a child. \n 3.Return to main menu");


                        System.out.print("Please enter your option by index: ");
                        String option = scanner.next();
                        switch (option) {
                            case "1": {
                                System.out.println("Please, enter the family ID");
                                int ID1 = scanner.nextInt();
                                System.out.println("Enter girl name");
                                String girlName = scanner.next();
                                System.out.println("Enter boy name");
                                String boyName = scanner.next();
                                familyController.bornChild(familyController.getFamilyByIndex(ID1), boyName, girlName);
                                System.out.println("Successfully added");
                                System.out.println(" Please press enter to go back to main menu");
                                command = scanner.nextLine();

                                break;
                            }
                            case "2": {
                                System.out.println("Please, enter the family ID");
                                int ID2 = scanner.nextInt();
                                System.out.println("Name of the child");
                                String nameChild = scanner.next();
                                System.out.println("Surname of the child");
                                String surnameChild = scanner.next();
                                System.out.println("Child's birth year");
                                int birthyearChild = scanner.nextInt();
                                System.out.println("Child's birth month");
                                int birthMonthChild = scanner.nextInt();
                                System.out.println("Child's birth day");
                                int birthDayChild = scanner.nextInt();
                                System.out.println("Child's IQ");
                                int childIQ = scanner.nextInt();
                                String childBirthDate = String.format("%d/%d/%d", birthDayChild, birthMonthChild, birthyearChild);
                                Human child = new Human(nameChild, surnameChild, childBirthDate, childIQ);
                                familyController.adoptChild(familyController.getFamilyByIndex(ID2), child);
                                System.out.println("Successfully added");
                                System.out.println(" Please press enter to go back to main menu");
                                command = scanner.nextLine();

                                break;
                            }
                            case "3": {
                                System.out.println(" Please press enter to go back to main menu");
                                command = scanner.nextLine();
                            }
                        }

                            break;

                    }catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.nextLine();

                    }
                }
                case "9": {
                        System.out.println("Enter the age of children that you wanted to delete");
                    try {
                        int age= scanner.nextInt();
                        familyController.deleteAllChildrenOlderThen(age);
                        System.out.println("Successfully deleted");

                    }catch (Exception e) {
                        System.out.println("You entered incorrect value. Please press enter to go back to main menu");
                        command = scanner.next();
                    }

                    break;


                }

                case "10":{

                    familyController.loadData();
                    System.out.println(" Your data is saved and you are exited from the program  ");
            }

                default:
                    System.out.println("You entered incorrect command. Please press enter to go back to main menu");
                    command = scanner.next();


            }
        }
    }
}

