package sda;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer project_id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "Project_Employee",
            joinColumns = {
                    @JoinColumn(name = "project_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "employee_id")}
    )
    private Set<Employee> employees;

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Project() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(project_id, project.project_id) &&
                Objects.equals(name, project.name) &&
                Objects.equals(employees, project.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(project_id, name, employees);
    }
}
