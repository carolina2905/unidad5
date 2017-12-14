package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.EmployeDAO;
import utng.model.Employe;

@ManagedBean
@SessionScoped
public class EmployeBean implements Serializable{
    private List<Employe>employes;
    private Employe employe;
    public EmployeBean(){}

    public List<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    
    public String toList(){
        EmployeDAO dao = new EmployeDAO();
        try {
            employes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Employes";
    }
    
    public String remove(){
         EmployeDAO dao = new EmployeDAO();
        try {
            dao.delete(employe);
            employes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";
    }
    
    public String start(){
        employe= new Employe();
        return "Start";
    }
    
    public String save(){
        EmployeDAO dao = new EmployeDAO();
        try {
            if(employe.getIdEmploye()!= 0){
                dao.update(employe);
            }else {
                dao.insert(employe);
            }
            employes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Employe employe){
        this.employe=employe;
        return "Edit";
    }
    
}
