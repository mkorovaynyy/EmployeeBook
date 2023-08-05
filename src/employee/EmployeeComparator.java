package employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getSalaryPerMonth() > o2.getSalaryPerMonth()) {
            return 1;
        } else if (o1.getSalaryPerMonth() == o2.getSalaryPerMonth()) {
            if (o1.getId() > o1.getId()) {
                return -1;
            } else return 1;
        } else return -1;

    }
}
