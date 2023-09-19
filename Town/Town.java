package Town;


import Households.Family;

import java.util.ArrayList;
import java.util.List;

public class Town {
    private List<Family> listFamily;

    public Town() {
        listFamily = new ArrayList<>();
    }

    public void additionalHouseholds(Family family) {
        listFamily.add(family);
    }

    public void editHouseholdInformation(int index, Family family) {
        listFamily.set(index, family);
    }

    public void deleteHousehold(Family family) {
        listFamily.remove(family);
    }

    public List<Family> getListFamily() {
        return listFamily;
    }
    public void setListFamily(List<Family> listFamily1) {
        this.listFamily = listFamily1;
    }
}
