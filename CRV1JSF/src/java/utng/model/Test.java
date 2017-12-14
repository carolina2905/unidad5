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
@Table(name="test")
public class Test implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_test")
    private Long idTest;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_answer")    
    private Answer answer;
    
    @Column(name="subject",length=30)
    private String subject;
    
    @Column(name="semester",length=30)
    private String semester;
    
    @Column(name="score",length=30)
    private String score;
   
    @Column(name="final_score",length=30)
    private String finalScore;

    public Test(Long idTest, Answer answer, String subject, String semester, String score, String finalScore) {
        this.idTest = idTest;
        this.answer = answer;
        this.subject = subject;
        this.semester = semester;
        this.score = score;
        this.finalScore = finalScore;
    }
    
    public Test() {
        this.idTest=0L;
    }

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }
    
    
}
