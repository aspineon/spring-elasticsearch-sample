package com.hendisantika.springelasticsearchsample.repository;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.hendisantika.springelasticsearchsample.domain.Department;
import com.hendisantika.springelasticsearchsample.domain.Employee;
import com.hendisantika.springelasticsearchsample.domain.Organization;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-elasticsearch-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/12/19
 * Time: 06.37
 */
public class EmployeeRepositoryPerformanceTest extends AbstractBenchmark {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryPerformanceTest.class);

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    private TestRestTemplate template = new TestRestTemplate();
    private Random r = new Random();

    @Test
    @BenchmarkOptions(concurrency = 30, benchmarkRounds = 500, warmupRounds = 2)
    public void addTest() {
        Employee employee = new Employee();
        employee.setName("John Smith");
        employee.setAge(r.nextInt(100));
        employee.setPosition("Developer");
        employee.setDepartment(new Department((long) r.nextInt(1000), "TestD"));
        employee.setOrganization(new Organization((long) r.nextInt(100), "TestO", "Test Street No. 1"));
        employee = template.postForObject("http://localhost:8080/employees", employee, Employee.class);
        Assert.assertNotNull(employee);
        Assert.assertNotNull(employee.getId());
    }
}
