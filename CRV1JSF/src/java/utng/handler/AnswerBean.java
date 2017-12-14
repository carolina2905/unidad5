package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.AnswerDAO;
import utng.model.Answer;

@ManagedBean
@SessionScoped
public class AnswerBean implements Serializable {
    private List<Answer>answers;
    private Answer answer;
    public AnswerBean(){}

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    
    public String toList(){
        AnswerDAO dao = new AnswerDAO();
        try {
            answers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Answer";
    }
    
    public String remove(){
         AnswerDAO dao = new AnswerDAO();
        try {
            dao.delete(answer);
            answers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        answer= new Answer();
        return "Start";
    }
    
    public String save(){
        AnswerDAO dao = new AnswerDAO();
        try {
            if(answer.getIdAnswer()!= 0){
                dao.update(answer);
            }else {
                dao.insert(answer);
            }
            answers=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Answer answer){
        this.answer=answer;
        return "Edit";
    }
        
}
