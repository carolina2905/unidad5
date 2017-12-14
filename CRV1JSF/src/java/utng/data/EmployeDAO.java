package utng.data;

import org.hibernate.HibernateException;
import utng.model.Employe;


public class EmployeDAO extends DAO<Employe> {
     public EmployeDAO() {
        super(new Employe());
    }

    
    public Employe getOneById(Employe employe) throws HibernateException {
        return super.getOneById(employe.getIdEmploye()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
