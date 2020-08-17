package ru.job4j.design.srp;

import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenProgRepGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker2);
        ReportEngine engine = new ProgrammerReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<Report>").append(System.lineSeparator());
        expect.append("<Employee>").append(System.lineSeparator())
            .append("<Name>").append(worker.getName()).append("</Name>").append(System.lineSeparator())
            .append("<Hired>").append(worker.getHired()).append("</Hired>").append(System.lineSeparator())
            .append("<Fired>").append(worker.getFired()).append("</Fired>").append(System.lineSeparator())
            .append("<Salary>").append(worker.getSalary()).append("</Salary>").append(System.lineSeparator())
            .append("</Employee>")
            .append(System.lineSeparator());
        expect.append("<Employee>").append(System.lineSeparator())
                .append("<Name>").append(worker2.getName()).append("</Name>").append(System.lineSeparator())
                .append("<Hired>").append(worker2.getHired()).append("</Hired>").append(System.lineSeparator())
                .append("<Fired>").append(worker2.getFired()).append("</Fired>").append(System.lineSeparator())
                .append("<Salary>").append(worker2.getSalary()).append("</Salary>").append(System.lineSeparator())
                .append("</Employee>")
                .append(System.lineSeparator());
        expect.append("</Report>").append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHRRepGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee worker2 = new Employee("Valera", now, now, 500);
        store.add(worker2);
        Employee worker3 = new Employee("Alex", now, now, 200);
        store.add(worker3);
        ReportEngine engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenBughRepGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new BughReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary(rub);")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}