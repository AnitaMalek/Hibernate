package sda;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PHONE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer phone_id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "phone",
            fetch = FetchType.EAGER)
    private Employee employee;

    public Integer getPhone_id() {
        return phone_id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Phone() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(phone_id, phone.phone_id) &&
                Objects.equals(mark, phone.mark) &&
                Objects.equals(model, phone.model) &&
                Objects.equals(employee, phone.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone_id, mark, model, employee);
    }
}
