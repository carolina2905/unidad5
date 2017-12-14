package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.StudentDAO;
import utng.data.UnityDAO;
import utng.model.Student;
import utng.model.Unity;

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable {
    private List<Student>students;
    private Student student;
    private List<Unity> unitys;
    public StudentBean(){
        student = new Student();
        student.setUnity(new Unity());
    }

    public List<Unity> getUnitys(){
        return unitys;
    }
    
    public void setUnitys(List<Unity> unitys){
        this.unitys = unitys;
    }
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public String toList(){
       StudentDAO dao = new StudentDAO();
        try {
            students=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Student";
    }
    
    public String remove(){
        StudentDAO dao = new StudentDAO();
        try {
            dao.delete(student);
            students=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        student= new Student();
        student.setUnity(new Unity());
        try{
            unitys = new UnityDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
       StudentDAO dao = new StudentDAO();
        try {
            if(student.getIdStudent()!= 0){
                dao.update(student);
            }else {
                dao.insert(student);
            }
            students=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Student student){
        this.student=student;
        try{
            unitys = new UnityDAO().getAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Edit";
    }
        
}
