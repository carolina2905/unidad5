/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Answer;

/**
 *
 * @author sarai
 */

public class AnswerDAO extends DAO<Answer> {
     public AnswerDAO() {
        super(new Answer());
    }

    
    public Answer getOneById(Answer answer) throws HibernateException {
        return super.getOneById(answer.getIdAnswer()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
