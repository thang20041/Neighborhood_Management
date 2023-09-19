package iManage;

import People.People;

import java.util.List;

public interface iManage {
    void addPeople(People people);
    void editPersonInformation(int index, People people);
    void removePerson(int index);
    List<People> getFamilyMembers();
    int getNumberOfMember();
    int getHouseNumber();
}
