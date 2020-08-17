package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ProgrammerReport extends ReportEngine {

    public ProgrammerReport(Store store) {
        super(store);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Store store = getStore();
        StringBuilder text = new StringBuilder();
        text.append("<Report>").append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append("<Employee>").append(System.lineSeparator())
                    .append("<Name>").append(employee.getName()).append("</Name>").append(System.lineSeparator())
                    .append("<Hired>").append(employee.getHired()).append("</Hired>").append(System.lineSeparator())
                    .append("<Fired>").append(employee.getFired()).append("</Fired>").append(System.lineSeparator())
                    .append("<Salary>").append(employee.getSalary()).append("</Salary>").append(System.lineSeparator())
                    .append("</Employee>")
                    .append(System.lineSeparator());
        }
        text.append("</Report>").append(System.lineSeparator());
        return text.toString();
    }
}
