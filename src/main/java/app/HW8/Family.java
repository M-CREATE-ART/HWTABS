package app.HW8;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Family {
    private Human father;
    private Human mother;
    private ArrayList<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    public Family(Human father, Human mother, ArrayList<Human> children, Set<Pet> pets) {
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.pets = pets;
    }
        public Family(Human father, Human mother, ArrayList<Human> children) {
            this.father = father;
            this.mother = mother;
            this.children = children;
        }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }


    public void addChild(Human child) {
        children.add(child);
    }

    public boolean deleteChild(int index) {
        if (index >= children.size()) {
            return false;
        } else {
            children.remove(children.get(index));
            return true;
        }


    }

    public boolean deleteChild(Human child) {
        if (children.contains(child)) {
            children.remove(child);
            return true;
        }
        return false;
    }

    public int countFamily() {

        return 2 + children.size();
    }


    @Override
    public String toString() {
        return String.format("Family{father=%s, mother=%s, children=%s, pets=%s}", father, mother, children, pets);
    }


}


