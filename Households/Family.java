package Households;

import People.People;

import java.util.ArrayList;

import java.util.List;

public class Family {
    private int numberOfMember;
    private int houseNumber;
    private List<People> familyMembers;


    public Family(int numberOfMember, int houseNumber) {
        this.numberOfMember = numberOfMember;
        this.houseNumber = houseNumber;
        this.familyMembers = new ArrayList<>();
    }


    public void addPeople(People people) {
        familyMembers.add(people);
    }


    public void editPersonInformation(int index, People people) {
        familyMembers.set(index, people);
    }


    public void removePerson(int index) {
        familyMembers.remove(index);
    }

    public void deleteAllPeople() {
        familyMembers.clear();
    }


    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<People> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<People> familyMembers) {
        this.familyMembers = familyMembers;
    }
}