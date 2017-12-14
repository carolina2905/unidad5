/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Unity;

/**
 *
 * @author sarai
 */

public class UnityDAO extends DAO<Unity> {
     public UnityDAO() {
        super(new Unity());
    }

    
    public Unity getOneById(Unity unity) throws HibernateException {
        return super.getOneById(unity.getIdUnity()); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
