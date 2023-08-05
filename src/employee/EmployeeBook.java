package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class EmployeeBook {
    //использую ArrayList вместо массива, тк кол-во сотрудников не фиксировано, и они могут добавляться/удаляться/обновляться
    //(ну и массивы знаю вдоль и поперек, а коллекции начал учить только и хочется с ними поработать на практике)
    private List<Employee> employeeArrayList = new ArrayList<>();

    //Получить список всех сотрудников со всеми имеющимися по ним данными (вывести в консоль значения всех полей (toString)
    public void printAllEmployee() {
        System.out.println(employeeArrayList.toString());
    }

    //Посчитать сумму затрат на зарплаты в месяц.
    public double calculateTotalSalaryPerMonth() {
        double totalSalary = 0;
        for (Employee employee : employeeArrayList) {
            totalSalary += employee.getSalaryPerMonth();
        }
        return totalSalary;
    }

    //Найти сотрудника с минимальной зарплатой
    public void printPoorEmployee() {
        Collections.sort(employeeArrayList, new EmployeeComparator());
        System.out.println("Сотрудник с минимальной зарплатой " + employeeArrayList.get(0).toString());
    }

    //Найти сотрудника с максимальной зарплатой.
    public void printRichEmployee() {
        Collections.sort(employeeArrayList, new EmployeeComparator());
        System.out.println("Сотрудник с максимальной зарплатой " + employeeArrayList.get(employeeArrayList.size() - 1).toString());
    }

    //Подсчитать среднее значение зарплат (можно использовать для этого метод из пункта b).
    public double calculateAverageSalary() {
        if (employeeArrayList.size() > 0) {
            return calculateTotalSalaryPerMonth() / employeeArrayList.size();
        } else return 0;
    }

    //Получить Ф. И. О. всех сотрудников (вывести в консоль)
    public void printAllFio() {
        for (Employee employee : employeeArrayList) {
            System.out.println(employee.getFio());
        }
    }

    //Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
    public void updateSalary(int salaryIncrease) {
        for (int i = 0; i < employeeArrayList.size(); i++) {
            int increase = employeeArrayList.get(i).getSalaryPerMonth() + (employeeArrayList.get(i).getSalaryPerMonth() / 100) * salaryIncrease;
            employeeArrayList.get(i).setSalaryPerMonth(increase);
        }
    }

    //2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
    //    1. Сотрудника с минимальной зарплатой.
    public void findPoorEmployeeInDepartment(Department department) {
        List<Employee> departmentList = findEmployeeWithSameDepartment(department);
        Collections.sort(departmentList, new EmployeeComparator());
        System.out.println(departmentList.get(0));
    }

    //Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов)
    //Сотрудника с максимальной зарплатой.
    public void findRichEmployeeInDepartment(Department department) {
        List<Employee> departmentList = findEmployeeWithSameDepartment(department);
        Collections.sort(departmentList, new EmployeeComparator());
        System.out.println(departmentList.get(departmentList.size() - 1));
    }

    //Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов)
    //Сумму затрат на зарплату по отделу.
    public int calculateSumSalaryInDepartment(Department department) {
        List<Employee> departmentList = findEmployeeWithSameDepartment(department);
        int sumSalaryInDepartment = 0;
        for (Employee employee : departmentList) {
            sumSalaryInDepartment += employee.getSalaryPerMonth();
        }
        return sumSalaryInDepartment;
    }

    //Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов)
    //Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
    public int calculateAverageSalaryInDepartment(Department department) {
        int countEmployee = 0;
        for (Employee employee : employeeArrayList) {
            if (employee.getDepartment().name().equals(department.name())) {
                countEmployee++;
            }
        }
        if (countEmployee > 0) {
            return calculateSumSalaryInDepartment(department) / countEmployee;
        } else return 0;
    }

    //Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
    public void updateSalaryInDepartment(Department department, int salaryIncrease) {
        List<Employee> departmentList = findEmployeeWithSameDepartment(department);
        for (Employee employee : departmentList) {
            int increaase = (employee.getSalaryPerMonth() / 100) * salaryIncrease + employee.getSalaryPerMonth();
            employee.setSalaryPerMonth(increaase);
        }
    }

    //Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void printAllEmloyeeInDepartment(Department department) {
        List<Employee> departmentList = findEmployeeWithSameDepartment(department);
        for (Employee employee : departmentList) {
            System.out.println("ФИО= " + employee.getFio() + " , " + "Зарплата в месяц= " + employee.getSalaryPerMonth()
                    + " , " + "идентификатор= " + employee.getEmployeeId());
        }
    }

    //перемещаю сотрудников отдела в отдельный list
    public List<Employee> findEmployeeWithSameDepartment(Department department) {
        List<Employee> departmentList = new ArrayList<>();
        for (Employee employee : employeeArrayList) {
            if (department.name().equals(employee.getDepartment().name())) {
                departmentList.add(employee);
            }
        }
        return departmentList;
    }

    //Получить в качестве параметра число и найти: Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой консоль)
    public void printEmployeeBelowThisSalary(int salary) {
        List<Employee> employeeBelowThisSalary = new ArrayList<>();
        for (Employee employee : employeeArrayList) {
            if (employee.getSalaryPerMonth() < salary) {
                employeeBelowThisSalary.add(employee);
            }
        }
        for (Employee employee : employeeBelowThisSalary) {
            System.out.println("id сотрудника = " + employee.getEmployeeId() + " , " +
                    "ФИО = " + employee.getFio() + " , " + "зарплата сотрудника = " + employee.getSalaryPerMonth());
        }
    }

    //Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
    public void printEmployeeAboveThisSalary(int salary) {
        List<Employee> employeeAboveThisSalary = new ArrayList<>();
        for (Employee employee : employeeArrayList) {
            if (employee.getSalaryPerMonth() >= salary) {
                employeeAboveThisSalary.add(employee);
            }
        }
        for (Employee employee : employeeAboveThisSalary) {
            System.out.println("id сотрудника = " + employee.getEmployeeId() + " , " +
                    "ФИО = " + employee.getFio() + " , " + "зарплата сотрудника = " + employee.getSalaryPerMonth());
        }
    }

    //Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
    public void addNewEmployee(Employee employee) {
        employeeArrayList.add(employee);
    }

    //Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id
    public void removeEmployee(int id) {
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (employeeArrayList.get(i).getEmployeeId() == id) {
                employeeArrayList.remove(i);
            }
        }
    }

    public void removeEmployee(String fio) {
        for (int i = 0; i < employeeArrayList.size(); i++) {
            if (employeeArrayList.get(i).getFio().equals(fio)) {
                employeeArrayList.remove(i);
            }
        }
    }

    //5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
    //    1. Изменить зарплату.
    //    2. Изменить отдел.
    public void updateEmployee(String fio, int salary, Department department) {
        for(int i = 0; i < employeeArrayList.size(); i++) {
            if(employeeArrayList.get(i).getFio().equals(fio)) {
                employeeArrayList.get(i).setSalaryPerMonth(salary);
                employeeArrayList.get(i).setDepartment(department);
            }
        }
    }

    //Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
    public void printAllDepartment() {
        List<Employee> department1 = findEmployeeWithSameDepartment(Department.DEPARTMENT_1);
        System.out.println(Department.DEPARTMENT_1.name() + ":");
        for(Employee employee:department1) {
            System.out.println(employee);
        }
        List<Employee> department2 = findEmployeeWithSameDepartment(Department.DEPARTMENT_2);
        System.out.println(Department.DEPARTMENT_2.name() + ":");
        for(Employee employee:department2) {
            System.out.println(employee);
        }
        List<Employee> department3 = findEmployeeWithSameDepartment(Department.DEPARTMENT_3);
        System.out.println(Department.DEPARTMENT_3.name() + ":");
        for(Employee employee:department3) {
            System.out.println(employee);
        }
        List<Employee> department4 = findEmployeeWithSameDepartment(Department.DEPARTMENT_4);
        System.out.println(Department.DEPARTMENT_4.name() + ":");
        for(Employee employee:department4) {
            System.out.println(employee);
        }
        List<Employee> department5 = findEmployeeWithSameDepartment(Department.DEPARTMENT_5);
        System.out.println(Department.DEPARTMENT_5.name() + ":");
        for(Employee employee:department5) {
            System.out.println(employee);
        }
    }

    public List<Employee> getEmployeeArrayList() {
        return employeeArrayList;
    }

    public void setEmployeeArrayList(List<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;
    }

    @Override
    public String toString() {
        return "Cписок сотрудников:" + "\n" +
                employeeArrayList;

    }
}
