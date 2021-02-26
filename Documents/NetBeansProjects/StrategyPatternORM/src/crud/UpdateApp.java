package crud;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UpdateApp {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            City city = (City) session.get(City.class, 601);
            System.out.println("Azuriranje..." + city);
            city.setLastUpdate(new Date());
            session.update(city);
            session.getTransaction().commit();
            System.out.println(city);
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
