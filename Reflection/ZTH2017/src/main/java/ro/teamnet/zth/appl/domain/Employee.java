package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.util.Date;

/**
 * Created by Tiberiu.Danciu on 7/12/2017.
 */
@Table(name = "employees")
public class Employee {
    @Id(name = "employee_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone-number")
    private String phoneNumber;
    @Column(name = "hire_date")
    private Date data;
    @Column(name = "salary")
    private Float salary;
    @Column(name = "commission_pct")
    private Long comission;
    @Column(name = "manager_id")
    private Employee managerid;
    @Column(name = "department_id")
    private Department departmentid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Long getComission() {
        return comission;
    }

    public void setComission(Long comission) {
        this.comission = comission;
    }

    public Employee getManagerid() {
        return managerid;
    }

    public void setManagerid(Employee managerid) {
        this.managerid = managerid;
    }

    public Department getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Department departmentid) {
        this.departmentid = departmentid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", data=" + data +
                ", salary=" + salary +
                ", comission=" + comission +
                ", managerid=" + managerid +
                ", departmentid=" + departmentid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!id.equals(employee.id)) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!email.equals(employee.email)) return false;
        if (!phoneNumber.equals(employee.phoneNumber)) return false;
        if (!data.equals(employee.data)) return false;
        if (!salary.equals(employee.salary)) return false;
        if (!comission.equals(employee.comission)) return false;
        if (!managerid.equals(employee.managerid)) return false;
        return departmentid.equals(employee.departmentid);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + comission.hashCode();
        result = 31 * result + managerid.hashCode();
        result = 31 * result + departmentid.hashCode();
        return result;
    }
}
