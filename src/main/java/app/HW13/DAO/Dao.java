package app.HW13.DAO;

import java.util.List;

public interface Dao<M> {

    List<M> getAllFamilies();

    M getFamilyByIndex(int index);

    boolean deleteFamily(int index);

    void saveFamily(M m);



}
