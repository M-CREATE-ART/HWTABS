package app.HW11.Service;

import app.HW11.Database.CollectionFamilyDao;
import app.HW11.Entity.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    CollectionFamilyDao collectionFamilyDao = new CollectionFamilyDao();

    public List<Family> getAllFamilies() {
        return collectionFamilyDao.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return collectionFamilyDao.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return collectionFamilyDao.deleteFamily(index);
    }

    public void saveFamily(Family family) {
        collectionFamilyDao.saveFamily(family);
    }

    public String displayAllFamilies() {
        StringBuilder familyString = new StringBuilder();
        getAllFamilies().forEach(family -> familyString.append(family));
        return familyString.toString();
    }

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        List<Family> biggerFamily = getAllFamilies().stream()
                .filter(family -> family.countFamily() > memberCount).collect(Collectors.toList());

        return biggerFamily;
    }

    public Family getFamilyById(int id) {
        return getFamilyByIndex(id - 1);
    }

    public List<Family> getFamiliesLessThan(int memberCount) {
        List<Family> lessFamily = getAllFamilies().stream()
                .filter(family -> family.countFamily() < memberCount).collect(Collectors.toList());

        return lessFamily;
    }

    public List<Family> countFamiliesWithMemberNumber(int memberCount) {
        List<Family> equFamily = getAllFamilies().stream()
                .filter(family -> family.countFamily() == memberCount).collect(Collectors.toList());

        return equFamily;
    }

    public void createNewFamily(Man father, Woman mother) {
        ArrayList<Human> children = new ArrayList<>();
        Family family = new Family(father, mother, children);
        getAllFamilies().add(family);
    }

    public Family bornChild(Family family, String masculine, String feminine) {
        int rn = (int) (Math.random() * 2);
        String name = rn == 0 ? masculine : feminine;
        Human child = new Human(name, family.getFather().getSurname(), "15/5/1995");
        child.setSchedule(family.getFather().getSchedule());
        child.setIq(5);
        getAllFamilies().get(getAllFamilies().indexOf(family)).addChild(child);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        getAllFamilies().get(getAllFamilies().indexOf(family)).addChild(child);
        saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        getAllFamilies().forEach(family -> {
            int year = LocalDate.now().getYear();
            family.getChildren().removeIf(children -> age < (year -
                    Instant.ofEpochMilli(children.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate().getYear()));
            saveFamily(family);
        });
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Set<Pet> getPets(int index) {
        return getAllFamilies().get(index).getPets();

    }

    public void addPet(int familyIndex, Pet pet) {
        getAllFamilies().get(familyIndex).getPets().add(pet);
        saveFamily(getFamilyByIndex(familyIndex));
    }

}

