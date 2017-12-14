package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.Sell;

public class SellDAO  extends DAO<Sell>{

    public SellDAO() {
        super(new Sell());
    }
    public Sell getOneById(Sell venta) throws HibernateException {
        return super.getOneById(venta.getIdSell()); 
    }
  
    
}