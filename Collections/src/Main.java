public class Main {

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();
        directory.addEmployee(new Employee("John", 1, 3));
        directory.addEmployee(new Employee("Allen", 2, 4));
        directory.addEmployee(new Employee("Boris", 3, 3));
        System.out.println(directory.searchEmployeeByPersonalId(1));
        System.out.println(directory.searchEmployeesByWorkExp(3));
        System.out.println(directory.searchPhoneNumbers("Boris"));
    }
}
