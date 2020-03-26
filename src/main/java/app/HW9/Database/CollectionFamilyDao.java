package app.HW9.Database;

import app.HW9.DAO.Dao;
import app.HW9.Entity.Family;

import java.util.ArrayList;
import java.util.List;

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

}
