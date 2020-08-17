package ru.job4j.design.srp;

import java.util.function.Predicate;

public class HRReport extends ReportEngine {

    public HRReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Store store = getStore();
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        for (Employee employee : store.sortSalaryDesc(store.findBy(filter))) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
