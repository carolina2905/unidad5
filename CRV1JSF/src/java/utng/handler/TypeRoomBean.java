package utng.handler;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.TypeRoomDAO;
import utng.model.TypeRoom;

@ManagedBean
@SessionScoped
public class TypeRoomBean implements Serializable{
    private List<TypeRoom>typeRooms;
    private TypeRoom typeRoom;
    public TypeRoomBean(){}

    public List<TypeRoom> getTypeRooms() {
        return typeRooms;
    }

    public void setTypeRooms(List<TypeRoom> typeRooms) {
        this.typeRooms = typeRooms;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }
    
    
    public String toList(){
        TypeRoomDAO dao = new TypeRoomDAO();
        try {
            typeRooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "TypeRooms";
    }
    
    public String remove(){
         TypeRoomDAO dao = new TypeRoomDAO();
        try {
            dao.delete(typeRoom);
            typeRooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";
    }
    
    public String start(){
        typeRoom= new TypeRoom();
        return "Start";
    }
    
    public String save(){
        TypeRoomDAO dao = new TypeRoomDAO();
        try {
            if(typeRoom.getIdTypeRoom()!= 0){
                dao.update(typeRoom);
            }else {
                dao.insert(typeRoom);
            }
            typeRooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(TypeRoom typeRoom){
        this.typeRoom=typeRoom;
        return "Edit";
    }
    
}
