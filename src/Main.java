import employee.Department;
import employee.Employee;
import employee.EmployeeBook;

public class Main {
    public static void main(String[] args) {
        //тесты
        EmployeeBook employeeBook = new EmployeeBook();
        Employee test1 = new Employee("тест1 тестович1 тестов1", Department.DEPARTMENT_1, 30000, employeeBook);
        Employee test2 = new Employee("тест2 тестович2 тестов2", Department.DEPARTMENT_5, 40000, employeeBook);
        Employee test3 = new Employee("тест3 тестович3 тестов3", Department.DEPARTMENT_3, 15000, employeeBook);
        Employee test4 = new Employee("тест4 тестович4 тестов4", Department.DEPARTMENT_1, 60000, employeeBook);
        System.out.println(employeeBook.toString());
        System.out.println(employeeBook.calculateTotalSalaryPerMonth());
        employeeBook.printPoorEmployee();
        employeeBook.printRichEmployee();
        System.out.println(employeeBook.calculateAverageSalary());
        employeeBook.printAllFio();
        employeeBook.updateSalary(10);
        System.out.println(employeeBook.toString());
        employeeBook.findPoorEmployeeInDepartment(Department.DEPARTMENT_1);
        System.out.println(employeeBook.calculateSumSalaryInDepartment(Department.DEPARTMENT_1));
        System.out.println(employeeBook.calculateSumSalaryInDepartment(Department.DEPARTMENT_2));
        System.out.println(employeeBook.calculateSumSalaryInDepartment(Department.DEPARTMENT_3));
        System.out.println(employeeBook.calculateAverageSalaryInDepartment(Department.DEPARTMENT_1));
        System.out.println(employeeBook.calculateAverageSalaryInDepartment(Department.DEPARTMENT_2));
        System.out.println(employeeBook.calculateAverageSalaryInDepartment(Department.DEPARTMENT_3));
        employeeBook.printAllEmloyeeInDepartment(Department.DEPARTMENT_1);
        employeeBook.printAllDepartment();


    }
}