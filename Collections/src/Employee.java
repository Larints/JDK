import java.util.*;

public class Employee implements Comparable<Employee> {
    private String name;
    private int personalId;
    private List<String> phoneNumbers;
    private int workExperience;

    public Employee(String name, int personalId, int workExperience) {
        this.name = name;
        this.personalId = personalId;
        this.workExperience = workExperience;
        phoneNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            phoneNumbers.add(String.valueOf(random.nextInt(111111111, 999999999)));
        }
    }

    public String getName() {
        return name;
    }


    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public int compareTo(Employee o) {
        return this.personalId - o.personalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return personalId == employee.personalId && workExperience == employee.workExperience && Objects.equals(name, employee.name) && Objects.equals(phoneNumbers, employee.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, personalId, phoneNumbers, workExperience);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", personalId=" + personalId +
                ", phoneNumbers=" + phoneNumbers +
                ", workExperience=" + workExperience +
                '}';
    }
}
