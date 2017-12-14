package utng.data;

import org.hibernate.HibernateException;
import utng.model.TypeRoom;


public class TypeRoomDAO extends DAO<TypeRoom> {
     public TypeRoomDAO() {
        super(new TypeRoom());
    }

    
    public TypeRoom getOneById(TypeRoom typeRoom) throws HibernateException {
        return super.getOneById(typeRoom.getIdTypeRoom()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}