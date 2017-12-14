package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.Room;

public class RoomDAO  extends DAO<Room>{

    public RoomDAO() {
        super(new Room());
    }
    public Room getOneById(Room habitacion) throws HibernateException {
        return super.getOneById(habitacion.getIdRoom()); 
    }
  
    
}