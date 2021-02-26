package crud;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class RetrieveApp {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            City city = (City) session.get(City.class, 601);
            session.getTransaction().commit();
            System.out.println(city);
            System.exit(0);
        } catch (HibernateException exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
