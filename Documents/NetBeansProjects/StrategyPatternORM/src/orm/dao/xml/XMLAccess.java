package orm.dao.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.model.Computers;

public class XMLAccess implements Dao {

    private final String FILE_NAME = "computers.xml";

    @Override
    public void writeStock(List<Computers> computers) throws DaoException {
        if (computers == null || computers.isEmpty()) {
            return;
        }
        try (XMLEncoder xmlEn = new XMLEncoder(new FileOutputStream(FILE_NAME))) {
            xmlEn.writeObject(computers);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Computers> readStock() throws DaoException {
        try (XMLDecoder xmlDe = new XMLDecoder(new FileInputStream(FILE_NAME))) {
            List<Computers> computersList = (List<Computers>) xmlDe.readObject();
            return computersList;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}