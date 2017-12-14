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
@Table(name="sell_")
public class Sell implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_sell")
    private Long idSell;
    @Column(name="dateSell", length=10)
    private String dateSell;
    @Column(length=40)
    private String totalSell;
    @ManyToOne()
    @JoinColumn(name="id_employe")
    private Employe employe;

    public Sell(Long idSell, String dateSell, String totalSell, Employe employe) {
        this.idSell = idSell;
        this.dateSell = dateSell;
        this.totalSell = totalSell;
        this.employe = employe;
    }

    

    public Sell() {
        this.idSell=0L;
    }

    public Long getIdSell() {
        return idSell;
    }

    public void setIdSell(Long idSell) {
        this.idSell = idSell;
    }

    public String getDateSell() {
        return dateSell;
    }

    public void setDateSell(String dateSell) {
        this.dateSell = dateSell;
    }

    public String getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(String totalSell) {
        this.totalSell = totalSell;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
    
}
