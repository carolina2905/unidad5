package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.TestDAO;
import utng.data.AnswerDAO;
import utng.model.Test;
import utng.model.Answer;

@ManagedBean
@SessionScoped
public class TestBean implements Serializable {
    private List<Test>tests;
    private Test test;
    private List<Answer> answers;
    public TestBean(){
        test = new Test();
        test.setAnswer(new Answer());
    }

    public List<Test> getTests(){
        return tests;
    }
    
    public void setTests(List<Test> tests){
        this.tests = tests;
    }
    
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    
    public String toList(){
        TestDAO dao = new TestDAO();
        try {
            tests=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Test";
    }
    
    public String remove(){
         TestDAO dao = new TestDAO();
        try {
            dao.delete(test);
            tests=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        test= new Test();
        test.setAnswer(new Answer());
        try{
            answers = new AnswerDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        TestDAO dao = new TestDAO();
        try {
            if(test.getIdTest()!= 0){
                dao.update(test);
            }else {
                dao.insert(test);
            }
            tests=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Test test){
        this.test=test;
        try{
            answers = new AnswerDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Edit";
    }
        
}
