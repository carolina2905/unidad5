package utng.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="unity")
public class Unity implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_unity")
    private Long idUnity;
    @Column(name="name_unity", length=10)
    private String name;

    public Unity(Long idUnity, String name) {
        this.idUnity = idUnity;
        this.name = name;
    }

   
    public Unity() {
        this.idUnity=0L;
    }

    public Long getIdUnity() {
        return idUnity;
    }

    public void setIdUnity(Long idUnity) {
        this.idUnity = idUnity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
    
   
    
}
