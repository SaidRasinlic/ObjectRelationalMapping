package crud;

import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class InsertApp {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            int in = 5;
            short sn =(short) in;
            City city = new City("Sarajevo",sn, new Date());
            session.persist(city);
            session.getTransaction().commit();
            System.out.println("Insertovan : " + city.getCityId());
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}

