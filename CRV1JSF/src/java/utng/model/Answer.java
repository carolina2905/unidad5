package utng.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_answer")
    private Long idAnswer;
    @Column(name="name_answer", length=10)
    private String name;
    @Column(name="subject",length=40)
    private String subject;
    
    @Column(name="periodd",length=40)
    private String periodd;

    public Answer(Long idAnswer, String name, String subject, String periodd) {
        this.idAnswer = idAnswer;
        this.name = name;
        this.subject = subject;
        this.periodd = periodd;
    }
    
    public Answer() {
        this.idAnswer=0L;
    }
    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPeriodd() {
        return periodd;
    }

    public void setPeriodd(String periodd) {
        this.periodd = periodd;
    }

   
    
    
   
   
    
}
