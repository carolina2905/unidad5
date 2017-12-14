package utng.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_student")
    private Long idStudent;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_unity")    
    private Unity unity;
    
    @Column(name="name",length=30)
    private String name;
    
    @Column(name="last_name",length=30)
    private String lastName;
    
    @Column(name="age")
    private Integer age ;
   
    @Column(name="career",length=30)
    private String career;

    public Student(Long idStudent, Unity unity, String name, String lastName, Integer age, String career) {
        this.idStudent = idStudent;
        this.unity = unity;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.career = career;
    }
    
    public Student() {
        this.idStudent=0L;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    public Unity getUnity() {
        return unity;
    }

    public void setUnity(Unity unity) {
        this.unity = unity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    
}
