package utng.handler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import utng.data.TypeRoomDAO;
import utng.data.RoomDAO;
import utng.model.TypeRoom;
import utng.model.Room;

@ManagedBean(name="roomBean") 
@SessionScoped
public class RoomBean implements Serializable{
    private List<Room> rooms;
    private Room room;
    private List<TypeRoom> typeRooms;
    public RoomBean(){
        room = new Room();
        room.setTypeRoom(new TypeRoom());
    }

    public List<Room> getRooms() {
        return rooms;
    }
    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public List<TypeRoom> getTypeRooms() {
        return typeRooms;
    }
    public void setTypeRooms(List<TypeRoom> typeRooms) {
        this.typeRooms = typeRooms;
    }
    
     public String toList(){
        RoomDAO dao = new RoomDAO();
        try {
            rooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Rooms";
    }
    
    public String remove(){
         RoomDAO dao = new RoomDAO();
        try {
            dao.delete(room);
            rooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Remove";//no me queda claro si este es es lo que devuelve 
    }
    
    public String start(){
        room= new Room();
        room.setTypeRoom(new TypeRoom());
        try {
            typeRooms= new TypeRoomDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }
    
    public String save(){
        RoomDAO dao = new RoomDAO();
        try {
            if(room.getIdRoom()!= 0){
                dao.update(room);
            }else {
                dao.insert(room);
            }
            rooms=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
    return "Cancel";
    }
    
    public String edit(Room room){
        this.room=room;
        try {
            typeRooms = new TypeRoomDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }

    }
    //si retorna salir, debe haber una ruta para salir, un caso de navegacion
  
    
    


