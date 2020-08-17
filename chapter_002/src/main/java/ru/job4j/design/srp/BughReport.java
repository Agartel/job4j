package ru.job4j.design.srp;

import java.util.function.Predicate;

public class BughReport extends ReportEngine {

    public BughReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Store store = getStore();
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary(rub);").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
