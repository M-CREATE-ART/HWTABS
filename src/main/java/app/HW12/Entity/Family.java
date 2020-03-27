package app.HW12.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Family {
    private Man father;
    private Woman mother;

    private ArrayList<Human> children = new ArrayList<>();
    private Set<Pet> pets = new HashSet<>();

    public Family(Man father, Woman mother, ArrayList<Human> children) {
        this.father = father;
        this.mother = mother;
        this.children = children;

    }

    public Human getFather() {
        return father;
    }

    public void setFather(Man father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Woman mother) {
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

    public String childPrettyFormat() {
        StringBuilder childBuilder = new StringBuilder();
        children.forEach(child -> childBuilder.append(child.prettyFormat()).append("\n"));
        return childBuilder.toString();
    }

    public  String prettyFormat(){

        return String.format("family: \n mother:%s \n father:%s \n children: \n %s \n pets: %s \n",
                mother.prettyFormat(), father.prettyFormat(), childPrettyFormat(), pets);
    }


    @Override
    public String toString() {
        return String.format("Family{father=%s, mother=%s, children=%s, pets=%s}", father, mother, children, pets);
    }


}


