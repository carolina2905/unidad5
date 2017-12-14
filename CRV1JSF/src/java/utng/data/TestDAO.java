package utng.data;

import org.hibernate.HibernateException;
import utng.model.Test;


public class TestDAO extends DAO<Test> {
     public TestDAO() {
        super(new Test());
    }

    
    public Test getOneById(Test test) throws HibernateException {
        return super.getOneById(test.getIdTest()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
