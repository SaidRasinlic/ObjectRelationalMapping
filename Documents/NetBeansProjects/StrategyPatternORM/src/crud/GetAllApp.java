package crud;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class GetAllApp {

    public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            Query query = session.createQuery("from City");
            session.getTransaction().commit();

            List<City> cityList = query.list();
            cityList.forEach((City cl) -> {
                System.out.println(cl);
            });
            System.exit(0);
        } catch (HibernateException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
