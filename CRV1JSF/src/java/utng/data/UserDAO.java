package utng.data;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import utng.model.User;

public class UserDAO  extends DAO<User>{

    public UserDAO() {
        super(new User());
    }
    public User getOneById(User usuario) throws HibernateException {
        return super.getOneById(usuario.getIdUser()); 
    }
    public User login (User user){
        List<String> parametros= new ArrayList<String>();
        List<Object>valores= new ArrayList<Object>();
        parametros.add("nameUser");
        parametros.add("password");
        valores.add(user.getNameUser());
        valores.add(user.getPassword());
        user = query("SELECT p FROM "
                +modelo.getClass().getName()
                +" p WHERE p.nameUser =:nameUser "
                +"AND p.password=:password",
                        parametros, valores);
        return user;
    }
    
}