package utng.handler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import utng.data.RoleDAO;
import utng.data.UserDAO;
import utng.model.Role;
import utng.model.User;

@ManagedBean(name="userBean") 
@SessionScoped
public class UserBean implements Serializable{
    private List<User> users;
    private User user;
    private List<Role> roles;
    public UserBean(){
        user = new User();
        user.setRole(new Role());
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public User getUser() {
        return user;
    }
    public void setUsuario(User user) {
        this.user = user;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
     public String toList(){
        UserDAO dao = new UserDAO();
        try {
            users=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Users";
    }
    
    public String remove(){
         UserDAO dao = new UserDAO();
        try {
            dao.delete(user);
            users=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        user= new User();
        user.setRole(new Role());
        try {
            roles= new RoleDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        UserDAO dao = new UserDAO();
        try {
            if(user.getIdUser()!= 0){
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
    
    public String edit(User user){
        this.user=user;
        try {
            roles = new RoleDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
    
    public String login(){
        user = new UserDAO().login(this.user);
        if(user != null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user",user);
            return "Correcto";
        }else {
            user = new User();
            return "Incorrecto";
        }
    }
    //si retorna salir, debe haber una ruta para salir, un caso de navegacion
  
    
    
    
}
