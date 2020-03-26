package app.HW10.Controller;

import app.HW10.Entity.*;
import app.HW10.Service.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {
    FamilyService familyService = new FamilyService();

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return familyService.deleteFamily(index);
    }

    public void saveFamily(Family family) {
        familyService.saveFamily(family);
    }

    public String displayAllFamilies() {
        return familyService.displayAllFamilies();
    }

    public Family getFamilyById(int Id) {
        return familyService.getFamilyById(Id);
    }

    public List<Family> getFamiliesBiggerThan(int memberCount) {
        return familyService.getFamiliesBiggerThan(memberCount);
    }

    public List<Family> getFamiliesLessThan(int memberCount) {
        return familyService.getFamiliesLessThan(memberCount);
    }

    public List<Family> countFamiliesWithMemberNumber(int memberCount) {
        return familyService.countFamiliesWithMemberNumber(memberCount);
    }

    public void createNewFamily(Man father, Woman mother) {
        familyService.createNewFamily(father, mother);
    }

    public Family bornChild(Family family, String masculine, String feminine) {
        return familyService.bornChild(family, masculine, feminine);
    }

    public Family adoptChild(Family family, Human child) {
        return familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public void addPet(int familyIndex, Pet pet) {
        familyService.addPet(familyIndex, pet);
    }
}
