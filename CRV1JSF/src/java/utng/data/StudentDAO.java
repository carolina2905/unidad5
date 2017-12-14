package utng.data;

import org.hibernate.HibernateException;
import utng.model.Student;


public class StudentDAO extends DAO<Student> {
     public StudentDAO() {
        super(new Student());
    }

    
    public Student getOneById(Student student) throws HibernateException {
        return super.getOneById(student.getIdStudent()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
