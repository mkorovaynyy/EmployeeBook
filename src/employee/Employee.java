package employee;

import java.util.Objects;

public class Employee {
    private String fio;
    private Department department;
    private static int id = 0;
    private int salaryPerMonth;
    private int employeeId;

    public Employee(String fio, Department department, int salaryPerMonth, EmployeeBook employeeBook) {
        this.fio = fio;
        this.department = department;
        this.salaryPerMonth = salaryPerMonth;
        id++;
        employeeId = id;
        employeeBook.getEmployeeArrayList().add(this);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(int salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

    public static int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salaryPerMonth == employee.salaryPerMonth && Objects.equals(fio, employee.fio) && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, department, salaryPerMonth);
    }

    @Override
    public String toString() {
        return  "ФИО='" + fio + '\'' +
                ", Отдел=" + department.name() +
                ", Зарплата в месяц=" + salaryPerMonth +
                ", идентификатор=" + employeeId  + "\n";
    }
}
