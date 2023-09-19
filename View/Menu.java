package View;

import Households.Family;
import People.People;
import Town.Town;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private Town town;
    private Scanner scanner;

    public Menu(Town town) {
        this.town = town;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("===== Quản lý hộ dân cư trong khu phố =====");
            System.out.println("1. Thêm hộ gia đình");
            System.out.println("2. Sửa thông tin hộ gia đình");
            System.out.println("3. Xóa hộ gia đình");
            System.out.println("4. Hiển thị thông tin các hộ gia đình");
            System.out.println("5. Tìm kiếm người theo CMND");
            System.out.println("6. Xóa thành viên trong hộ gia đình theo CMND");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    additionalHouseholds();
                    break;
                case 2:
                    editHouseholdInformation();
                    break;
                case 3:
                    deleteHousehold();
                    break;
                case 4:
                    showHouseholdInformation();
                    break;
                case 5:
                    searchHouseholdsByHouseNumber();
                case 6:
                    deleteHouseholdMembers();
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 0);
    }

    private void additionalHouseholds() {
        System.out.print("Nhập số thành viên trong gia đình: ");
        int numberOfMember = scanner.nextInt();
        System.out.print("Nhập số nhà: ");
        int  houseNumber = scanner.nextInt();
        scanner.nextLine();

        Family  family = new Family(numberOfMember, houseNumber);
        for (int i = 0; i < numberOfMember; i++) {
            System.out.println("Nhập thông tin thành viên thứ " + (i + 1));
            System.out.print("Họ tên: ");
            String name = scanner.nextLine();
            System.out.print("Tuổi: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nghề nghiệp: ");
            String job = scanner.nextLine();
            System.out.print("Số CMND: ");
            String numberCMND = scanner.nextLine();

            People people = new People(name, age, job, numberCMND);
            family.addPeople(people);
        }

        town.additionalHouseholds(family);
        System.out.println("Thêm hộ gia đình thành công!");
    }

    private void editHouseholdInformation() {
        System.out.print("Nhập số nhà của hộ gia đình cần sửa thông tin: ");
        int houseNumber = scanner.nextInt();
        scanner.nextLine();


        Family family = null;
        for (Family ho : town.getListFamily()) {
            if (ho.getHouseNumber() == houseNumber) {
                family = ho;
                break;
            }
        }

        if (family == null) {
            System.out.println("Không tìm thấy hộ gia đình với số nhà " + houseNumber);
        } else {
            System.out.println("Nhập thông tin mới cho hộ gia đình số nhà " + houseNumber);
            System.out.print("Nhập số thành viên trong gia đình: ");
            int numberOfMember = scanner.nextInt();
            scanner.nextLine();

            family.setNumberOfMember(numberOfMember);

            family.deleteAllPeople();
            for (int i = 0; i < numberOfMember; i++) {
                System.out.println("Nhập thông tin thành viên thứ " + (i + 1));
                System.out.print("Họ tên: ");
                String newName = scanner.nextLine();
                System.out.print("Tuổi: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nghề nghiệp: ");
                String newJob = scanner.nextLine();
                System.out.print("Số CMND: ");
                String newNumberCMND = scanner.nextLine();

                People people = new People(newName, newAge, newJob, newNumberCMND);
                family.addPeople(people);
            }

            System.out.println("Sửa thông tin hộ gia đình thành công!");
        }
    }

    private void deleteHousehold() {
        System.out.print("Nhập số nhà của hộ gia đình cần xóa: ");
        int numberHouse = scanner.nextInt();
        scanner.nextLine();


        Family deleteHousehold = null;


        for (Family ho : town.getListFamily()) {
            if (ho.getHouseNumber() == numberHouse) {
                deleteHousehold = ho;
                break;
            }
        }

        if (deleteHousehold == null) {
            System.out.println("Không tìm thấy hộ gia đình với số nhà " + numberHouse);
        } else {
            town.deleteHousehold(deleteHousehold);
            System.out.println("Xóa hộ gia đình thành công!");
        }
    }
    private void searchHouseholdsByHouseNumber() {
        System.out.print("Nhập số nhà cần tìm kiếm: ");
        int houseNumberToLookFor = scanner.nextInt();
        scanner.nextLine();
        boolean find = false;

        System.out.println("Kết quả tìm kiếm theo số nhà " + houseNumberToLookFor + ":");
        List<Family> listOfHouseholds = town.getListFamily();
        for (Family ho : listOfHouseholds) {
            if (ho.getHouseNumber() == houseNumberToLookFor) {
                System.out.println("Số nhà: " + ho.getHouseNumber());
                System.out.println("Số thành viên: " + ho.getNumberOfMember());
                System.out.println("Danh sách thành viên:");
                List<People> familyMembers = ho.getFamilyMembers();
                for (int i = 0; i < familyMembers.size(); i++) {
                    System.out.println("Thành viên " + (i + 1) + ":");
                    People people = familyMembers.get(i);
                    System.out.println("Họ tên: " + people.getName());
                    System.out.println("Tuổi: " + people.getAge());
                    System.out.println("Nghề nghiệp: " + people.getJob());
                    System.out.println("Số CMND: " + people.getNumberCMND());
                }
                find = true;
            }
        }

        if (!find) {
            System.out.println("Không tìm thấy hộ gia đình nào với số nhà " + houseNumberToLookFor);
        }
    }
    private void deleteHouseholdMembers() {
        System.out.print("Nhập số nhà của hộ gia đình: ");
        int numberHouse = scanner.nextInt();
        scanner.nextLine();


        Family family = null;
        for (Family ho : town.getListFamily()) {
            if (ho.getHouseNumber() == numberHouse) {
                family = ho;
                break;
            }
        }

        if (family == null) {
            System.out.println("Không tìm thấy hộ gia đình với số nhà " + numberHouse);
        } else {
            System.out.print("Nhập số thứ tự của thành viên cần xóa: ");
            int ordinalNumber = scanner.nextInt();
            scanner.nextLine();

            if (ordinalNumber <= 0 || ordinalNumber > family.getNumberOfMember()) {
                System.out.println("Số thứ tự không hợp lệ.");
            } else {
                family.removePerson(numberHouse -1);
                System.out.println("Xóa thành viên thành công!");
            }
        }
    }

    private void showHouseholdInformation() {
        System.out.println("Danh sách các hộ gia đình trong khu phố:");
        List<Family> listOfHouseholds = town.getListFamily();
        for (Family ho : listOfHouseholds) {
            System.out.println("Số nhà: " + ho.getHouseNumber());
            System.out.println("Số thành viên: " + ho.getNumberOfMember());
            System.out.println("Danh sách thành viên:");
            List<People> familyMembers = ho.getFamilyMembers();
            for (int i = 0; i < familyMembers.size(); i++) {
                System.out.println("Thành viên " + (i + 1) + ":");
                People people = familyMembers.get(i);
                System.out.println("Họ tên: " + people.getName());
                System.out.println("Tuổi: " + people.getAge());
                System.out.println("Nghề nghiệp: " + people.getJob());
                System.out.println("Số CMND: " + people.getNumberCMND());
            }
        }
    }
}


