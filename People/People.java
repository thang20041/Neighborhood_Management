package People;

public class People {
    private String name;
    private int age;
    private String job;
    private String numberCMND;


    public People(String name, int age, String job, String numberCMND) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.numberCMND = numberCMND;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(String numberCMND) {
        this.numberCMND = numberCMND;
    }

    @Override
    public String toString() {
        return "People{" +
                "Họ tên='" + name + '\'' +
                ", Tuổi=" + age +
                ", Nghề nghiệp='" + job + '\'' +
                ", số CMND='" + name + '\'' +
                '}';
    }
}

