package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.UnityDAO;
import utng.model.Unity;

@ManagedBean
@SessionScoped
public class UnityBean implements Serializable {
    private List<Unity>unitys;
    private Unity unity;
    public UnityBean(){}

    public Unity getUnity() {
        return unity;
    }

    public void setUnity(Unity unity) {
        this.unity = unity;
    }

    public List<Unity> getUnitys() {
        return unitys;
    }

    public void setUnitys(List<Unity> unitys) {
        this.unitys = unitys;
    }
    
    public String toList(){
        UnityDAO dao = new UnityDAO();
        try {
            unitys=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unity";
    }
    
    public String remove(){
         UnityDAO dao = new UnityDAO();
        try {
            dao.delete(unity);
            unitys=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        unity= new Unity();
        return "Start";
    }
    
    public String save(){
        UnityDAO dao = new UnityDAO();
        try {
            if(unity.getIdUnity()!= 0){
                dao.update(unity);
            }else {
                dao.insert(unity);
            }
            unitys=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Unity unity){
        this.unity=unity;
        return "Edit";
    }
        
}
