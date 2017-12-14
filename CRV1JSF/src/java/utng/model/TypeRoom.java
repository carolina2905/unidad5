 package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeRoom")
public class TypeRoom implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_typeRoom")
    private Long idTypeRoom;
    @Column(length=30)
    private String codeTypeRoom;
   
    

    public TypeRoom() {
        this.idTypeRoom=0L;
    }

    public Long getIdTypeRoom() {
        return idTypeRoom;
    }

    public void setIdTypeRoom(Long idTypeRoom) {
        this.idTypeRoom = idTypeRoom;
    }

    public String getCodeTypeRoom() {
        return codeTypeRoom;
    }

    public void setCodeTypeRoom(String codeTypeRoom) {
        this.codeTypeRoom = codeTypeRoom;
    }

    
}

