package java8;

/*
 * Java 8 Stream API - Employee Management Examples
 * Demonstrates advanced Stream operations on Employee records.
 *
 * Operations Covered:
 * - Grouping by city, age, department, gender
 * - Counting (male/female, by department)
 * - Filtering (by age, department, city)
 * - Finding (oldest, youngest, highest paid)
 * - Sorting (by name, age, salary)
 * - Statistical operations (average, sum, min, max)
 * - Partitioning and nested grouping
 * - Multi-level grouping (department + gender)
 *
 * Key Collectors Used:
 * - groupingBy, counting, averagingInt/Double
 * - maxBy, minBy, summarizingDouble
 */

import java.util.*;
import java.util.stream.Collectors;

record Employee(
        int id,
        String name,
        int age,
        long salary,
        String gender,
        String deptName,
        String city,
        int yearOfJoining
) {
}

public class EmployeeExample {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

        // Group the Employees by city.
        Map<String, List<Employee>> empCityMap = empList.stream().collect(Collectors.groupingBy(Employee::city));
        System.out.println("Employees grouped by city:: \n" + empCityMap);

        //Group the Employees by age
        Map<Integer, List<Employee>> empAgeMap = empList.stream().collect(Collectors.groupingBy(Employee::age));
        System.out.println("Employees grouped by age:: \n" + empAgeMap);

        //Find the count of male and female employees present in the organization
        Map<String, Long> countEmpMap = empList.stream().collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
        System.out.println("Employees grouped by count:: \n" + countEmpMap);

        //Find the count of male and female present in each department
        Map<String, Map<String, Long>> countEmpByDeptMap = empList.stream().collect(Collectors.groupingBy(Employee::deptName, Collectors.groupingBy(Employee::gender, Collectors.counting())));
        System.out.println("Employees grouped by count:: \n" + countEmpByDeptMap);

        //Print the names of all distinct departments in the organization.
        System.out.println("names of all distinct departments in the organization");
        empList.stream().map(Employee::deptName).distinct().forEach(System.out::println);

        //Print employee details whose age is greater than 28 in the organisation.
        System.out.println("employee details whose age is greater than 28 in the organisation");
        empList.stream().filter(e -> e.age() > 28).forEach(System.out::println);

        //Find maximum age/oldest of employee in the organisation.
        System.out.println("maximum age/oldest of employee in the organisation" +
                empList.stream().mapToInt(Employee::age).max());

        //Print Average age of Male and Female Employees in the organisation.
        Map<String, Double> empGenderMap = empList.stream().collect(Collectors
                .groupingBy(Employee::gender, Collectors
                        .averagingInt(Employee::age)));
        System.out.println("Average age of Male and Female Employees in the organisation::" + empGenderMap);

        //Print Average age of Male and Female Employees in each department.
        Map<String, Map<String, Double>> avgGenderByDeptMap = empList.stream().collect(Collectors
                .groupingBy(Employee::deptName, Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age))));

        //Print the number of employees in each department.
        Map<String, Long> empCountDept = empList.stream().collect(Collectors
                .groupingBy(Employee::deptName, Collectors.counting()));
        System.out.println("number of employees in each department::" + empCountDept);

        //Find longest serving employees in the organization.
        Optional<Employee> seniorEmp = empList.stream().sorted(Comparator.comparingInt(Employee::yearOfJoining)).findFirst();
        System.out.println("senior emp in org::" + seniorEmp.get());

        //Find longest serving employee in each department
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.minBy(Comparator.comparing(Employee::yearOfJoining))))
                .forEach((dept, empObj) -> empObj
                        .ifPresent(e -> System.out.println(dept + " " + e.name() + " " + e.yearOfJoining())));


        //Find average age of gender in each department.
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age))))
                .forEach((dept, empObj) -> empObj
                        .forEach((gender, age) ->
                                System.out.println(gender + " " + age)));

        //Find youngest female employee in the organisation.
        empList.stream().filter(employee -> Objects.equals(employee.gender(), "F"))
                .min(Comparator.comparing(Employee::age)).ifPresent(System.out::println);

        //Find the youngest employee in each department
        empList.stream().collect(Collectors.groupingBy(Employee::deptName
                        , Collectors.maxBy(Comparator.comparingInt(Employee::age))))
                .forEach((dept, emp) ->
                        emp.ifPresent(e ->
                                System.out.println(dept + " " + e.name() + " " + e.deptName())));

        //Find employees whose age is greater than 30 and less than 30
        Map<String, List<Employee>> partitionMap = empList.stream().collect(Collectors.groupingBy(e -> {
            if (e.age() > 30) return "greater";
            else if (e.age() < 30) return "lesser";
            else return "equals";
        }));
        System.out.println("Greater than 30: " + partitionMap.get("greater"));
        System.out.println("Less than 30: " + partitionMap.get("lesser"));
        System.out.println("Equal to 30: " + partitionMap.get("equal"));

        //Find the department name which has the highest number of employees.
        System.out.println("department name which has the highest number of employees.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        //Find if there any employees from HR Department.
        System.out.println("Any employees from HR Department.");
        empList.stream().filter(e -> Objects.equals(e.deptName(), "HR")).findAny().ifPresent(System.out::println);

        //Find the department names that these employees work for, where the number
        // of employees in the department is over 3.
        System.out.println("department names that these employees work for, where the number \n" +
                "of employees in the department is over 3.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 3)
                .forEach(System.out::println);

        //Find all employees who lives in ‘Blore’ city,
        // sort them by their name and print the names of employees.
        System.out.println("all employees who lives in ‘Blore’ city,sort them by their name and print the names of employees.");
        empList.stream().filter(e -> e.city() == "Blore").sorted(Comparator.comparing(Employee::name)).
                forEach(employee -> System.out.println(employee.name()));

        //No of employees in the organisation.
        System.out.println("No of employees in the organisation.");
        System.out.println((long) empList.size());

        //Find employee count in every department
        System.out.println("employee count in every department");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .forEach((dept, empCount) -> System.out.println(dept + " " + empCount));

        //Find the department which has the highest number of employees.
        System.out.println("Find the department which has the highest number of employees.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue))
                .ifPresent(System.out::println);

        //Sorting a Stream by age and name fields.
        System.out.println("Sorting based on name and age:: ");
        empList.stream().sorted(Comparator.comparing(Employee::age)
                .thenComparing(Employee::name)).forEach(System.out::println);

        //Print average and total salary of the organization.
        DoubleSummaryStatistics stats = empList.stream().collect(Collectors.summarizingDouble(Employee::salary));
        System.out.println("average salary of the organization.::" + stats.getAverage());
        System.out.println("total salary of the organization.::" + stats.getSum());

        //Print Average salary of each department.
        System.out.println("Average salary of each department");
        Map<String, Double> avgSalaryByDept = empList.stream().collect(Collectors.groupingBy(Employee::deptName
                , Collectors.averagingDouble(Employee::salary)));
        avgSalaryByDept.forEach((dept, sal) -> System.out.println("Dept " + dept
                + " " + sal));

        //Print Average salary by gender in each department.
        System.out.println("Print Average salary by gender in each department .");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.groupingBy(Employee::gender, Collectors.averagingDouble(Employee::salary))))
                .forEach((dept, genderMap) -> genderMap.entrySet()
                        .forEach((gender ->
                                System.out.println("dept " + dept + " Gender " + gender.getKey() + " "
                                        + "avg " + gender.getValue()))));

        //To get a list of employees from each department whose salary is
        // greater than the average salary of their department
        System.out.println("list of employees from each department whose salary is\n" +
                "        // greater than the average salary of their department");
        empList.stream().filter(e -> e.salary() > avgSalaryByDept.get(e.deptName()))
                .forEach(System.out::println);

        //Find Highest salary in the organisation.
        System.out.println("Highest salary in the organisation");
        empList.stream().max(Comparator.comparing(Employee::salary))
                .ifPresent(System.out::println);

        //Find Second-Highest salary in the organisation.
        System.out.println("Second Highest salary in the organisation");
        empList.stream().sorted(Comparator.comparing(Employee::salary).reversed()).skip(1)
                .findFirst().ifPresent(System.out::println);

        //Find Fourth-Highest salary in the organisation.
        int n = 4;
        System.out.println("Nth Highest distinct salary in the organisation");
        empList.stream().map(Employee::salary).distinct().sorted(Comparator.reverseOrder()).skip(n - 1)
                .findFirst().ifPresent(System.out::println);

        //Print the top 3 highest salary earned employees in the organisation
        System.out.println("Top 3 highest salary earned employees in the organisation");
        empList.stream().sorted(Comparator.comparing(Employee::salary).reversed()).limit(3).distinct().forEach(System.out::println);


        //Print the top 2 highest salary earned employees in each department
        System.out.println("top 2 highest salary earned employees in each department");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName))
                .forEach((dept, emp) ->
                        emp.stream()
                                .sorted(Comparator.comparing(Employee::salary).reversed())
                                .limit(2).forEach(System.out::println));

        //Find highest paid salary in the organisation based on gender.
        System.out.println("Find highest paid salary in the organisation based on gender.");
        empList.stream().collect(Collectors.groupingBy(Employee::gender,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))))
                .forEach((gender, salMap) ->
                        salMap.ifPresent(employee -> System.out.println("Gender " + gender
                                + " " + employee.salary())));

        //Find lowest paid salary in the organisation
        System.out.println("Lowest paid in the organisation");
        empList.stream().min(Comparator.comparing(Employee::salary)).ifPresent(System.out::println);

        //Find lowest paid salary in each department based on the gender.
        System.out.println("lowest paid salary in each department based on the gender.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.groupingBy(Employee::gender,
                                Collectors.minBy(Comparator.comparing(Employee::salary)))))
                .forEach((dept, genderMap) ->
                        System.out.println(dept + " " + genderMap));


        //Sort the employees salary in the organization in ascending order
        System.out.println("Sort the employees salary in the organisation in ascending order");
        empList.stream().sorted(Comparator.comparing(Employee::salary))
                .forEach(System.out::println);

        //Sort the employees salary in the organization in descending order.
        System.out.println("Sort the employees salary in the organisation in descending order");
        empList.stream().sorted(Comparator.comparing(Employee::salary).reversed())
                .forEach(System.out::println);

        //Highest salary based on department.
        System.out.println("Highest salary based on department.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.maxBy(Comparator.comparing(Employee::salary))))
                .forEach((dept, emp) -> emp.ifPresent(e ->
                        System.out.println(dept + " " + e.salary())));

        //If there is a tie in salary in each department.

        //Lowest paid based in each department
        System.out.println("Lowest salary based on department.");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName,
                        Collectors.minBy(Comparator.comparing(Employee::salary))))
                .forEach((dept, emp) -> emp.ifPresent(e ->
                        System.out.println(dept + " " + e.salary())));

        //List of employee’s second highest record based on department
        System.out.println("employee’s second highest record based on department");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName))
                .forEach((dept, emp) -> emp.stream()
                        .sorted(Comparator.comparing(Employee::salary).reversed()).skip(1)
                        .findFirst()
                        .ifPresent(e -> System.out.println(dept + "->" + e)));


        //Sort the employees salary in each department in ascending order
        System.out.println("Sort the employees salary in each department in ascending order");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName))
                .forEach((dept, emp) -> {
                    emp.stream().sorted(Comparator.comparing(Employee::salary))
                            .forEach(employee -> System.out.println("dept  " + dept + " " + employee));
                });


        //Sort the employees salary in each department in descending order
        System.out.println("Sort the employees salary in each department in descending order");
        empList.stream().collect(Collectors.groupingBy(Employee::deptName))
                .forEach((dept, emp) -> {
                    emp.stream().sorted(Comparator.comparing(Employee::salary).reversed())
                            .forEach(employee -> System.out.println("dept  " + dept + " " + employee));
                });

        //Find list of employees whose age is less than 30 in Department HR
        System.out.println("List of employees whose age is less than 30 in Department HR");
        empList.stream().filter(e -> e.deptName().equals("HR"))
                .filter(e -> e.age() < 30).forEach(System.out::println);

        //Find the employees whose name start with J.
        System.out.println("Employees whose name start with Y.");
        empList.stream().filter(e -> e.name().startsWith("Y")).forEach(System.out::println);

        //Find the dept wise employees name
        System.out.println("Find the dept wise employees name");
        Map<String , List<String>> deptEmpList = empList.stream().collect(Collectors.groupingBy(Employee::deptName,Collectors.mapping(Employee::name,Collectors.toList())));
                /*.forEach((dept, employees) ->{ System.out.println(dept +
                        employees.stream().map(Employee::name).toList());}
                );*/
        deptEmpList.forEach((dept,employees) -> {
            System.out.println(dept + employees);
        });

    }
}
