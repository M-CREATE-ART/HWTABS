package app.HW13.Database;

import app.HW13.DAO.Dao;
import app.HW13.Entity.*;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements Dao<Family> {
    ArrayList<Family> familyList = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return familyList;
    }

    @Override
    public Family getFamilyByIndex(int index) {

        return familyList.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= familyList.size()) return false;
        familyList.remove(index);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (familyList.contains(family)) {
            Family currentFamily = familyList.get(familyList.indexOf(family));
            currentFamily = family;
        } else {
            familyList.add(family);
        }

    }

    public void loadData() {
        File file = new File("src/main/java/app/HW13/Database/families.txt");

        try {
            new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            for (Family family : familyList) {
                bw.write(family.familyToFile());
                bw.write("\n");
            }

            bw.close();

        } catch (IOException e) {
            new FileNotFoundException();

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                for (Family family : familyList) {
                    bw.write(family.familyToFile());
                    bw.write("\n");
                }

                bw.close();

            } catch (Exception e1) {
                new IllegalArgumentException("Something went wrong");
            }
        }


    }

    public void getData() {
        File file = new File("src/main/java/app/HW13/Database/families.txt");
        List<Family> families = new ArrayList<>();

        if (familyList.size() == 0) {
            try {
                List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
                for (String line : lines) {
                    String[] splitted = line.split("#");
                    String[] mother = splitted[0].split(":");

                    long motherBirthDate = Long.parseLong(mother[2]);
                    LocalDate date = Instant.ofEpochMilli(motherBirthDate).atZone(ZoneId.systemDefault()).toLocalDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String motherFormattedBirthdate = date.format(formatter);


                    Woman woman = new Woman(mother[0], mother[1], motherFormattedBirthdate, Integer.parseInt(mother[3]));

                    String[] father = splitted[1].split(":");

                    long fatherBirthDate = Long.parseLong(father[2]);
                    LocalDate date2 = Instant.ofEpochMilli(fatherBirthDate).atZone(ZoneId.systemDefault()).toLocalDate();
                    String formattedBirthDateDad = date2.format(formatter);


                    Man man = new Man(father[0], father[1], formattedBirthDateDad, Integer.parseInt(father[3]));


                    String[] children = splitted[2].split(",");
                    String[] pets = splitted[3].split("~");

                    ArrayList<Human> childrenList = new ArrayList<>();
                    Set<Pet> petSet = new HashSet<>();

                    for (String childData : children) {
                        String[] c1 = childData.split(":");
                        String name = c1[0];
                        String surname = c1[1];
                        String birthDate = c1[2];
                        String iq = c1[3];

                        long childBirthDate = Long.parseLong(birthDate);
                        LocalDate date3 = Instant.ofEpochMilli(childBirthDate).atZone(ZoneId.systemDefault()).toLocalDate();
                        String formattedBirthDate = date3.format(formatter);

                        childrenList.add(new Human(name, surname, formattedBirthDate, Integer.parseInt(iq)));
                    }

                    for (String petData : pets) {
                        String[] p1 = petData.split(";");
                        String name = p1[1];
                        String age = p1[2];
                        String trickLevel = p1[3];
                        String habits = p1[4].replaceAll(";\\[", "").replaceAll("]", "");

                        String[] habitArray = habits.split(", ");

                        HashSet<String> habitSet = new HashSet<>();
                        for (String h : habitArray) habitSet.add(h);

                        petSet.add(new Dog(name, Integer.parseInt(age), Integer.parseInt(trickLevel), habitSet));

                    }
                    families.add(new Family(man, woman, childrenList, petSet));
                }
                familyList.addAll(families);

            } catch (FileNotFoundException e) {
                new FileNotFoundException();
            }
        }


    }
}
