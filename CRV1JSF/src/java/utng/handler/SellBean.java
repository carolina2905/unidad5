package utng.handler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import utng.data.EmployeDAO;
import utng.data.SellDAO;
import utng.model.Employe;
import utng.model.Sell;

@ManagedBean(name="sellBean") 
@SessionScoped
public class SellBean implements Serializable{
    private List<Sell> users;
    private Sell user;
    private List<Employe> employes;
    public SellBean(){
        user = new Sell();
        user.setEmploye(new Employe());
    }

    public List<Sell> getSells() {
        return users;
    }
    public void setSells(List<Sell> users) {
        this.users = users;
    }
    public Sell getSell() {
        return user;
    }
    public void setUsuario(Sell user) {
        this.user = user;
    }
    public List<Employe> getEmployes() {
        return employes;
    }
    public void setEmployes(List<Employe> employes) {
        this.employes = employes;
    }
    
     public String toList(){
        SellDAO dao = new SellDAO();
        try {
            users=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sells";
    }
    
    public String remove(){
         SellDAO dao = new SellDAO();
        try {
            dao.delete(user);
            users=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        user= new Sell();
        user.setEmploye(new Employe());
        try {
            employes= new EmployeDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        SellDAO dao = new SellDAO();
        try {
            if(user.getIdSell()!= 0){
                dao.update(user);
            }else {
                dao.insert(user);
            }
            users=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Sell user){
        this.user=user;
        try {
            employes = new EmployeDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }

    }
    //si retorna salir, debe haber una ruta para salir, un caso de navegacion
  
    
    
    


