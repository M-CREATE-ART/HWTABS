package app.HW13.Database;

import app.HW13.DAO.Dao;
import app.HW13.Entity.Family;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
}
