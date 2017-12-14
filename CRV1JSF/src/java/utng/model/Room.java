package utng.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_room")
    private Long idRoom;
    @Column(name="nameRoom", length=10)
    private String nameRoom;
    @Column(length=40)
    private String priceRoom;
    @ManyToOne()
    @JoinColumn(name="id_typeRoom")
    private TypeRoom typeRoom;

    public Room(Long idRoom, String nameRoom, String priceRoom, TypeRoom typeRoom) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.priceRoom = priceRoom;
        this.typeRoom = typeRoom;
    }

    

    public Room() {
        this.idRoom=0L;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(String priceRoom) {
        this.priceRoom = priceRoom;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }
    
    
}

