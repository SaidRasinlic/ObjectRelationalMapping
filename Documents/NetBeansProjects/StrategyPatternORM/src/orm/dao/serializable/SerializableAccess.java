package orm.dao.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.model.Computers;

public class SerializableAccess implements Dao {
    
    private final String FILE_NAME = "computers.dat";
    
    @Override
    public void writeStock(List<Computers> computers) throws DaoException {
        if (computers == null || computers.isEmpty()) {
            return;
        }
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            ous.writeObject(computers);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    @Override
    public List<Computers> readStock() throws DaoException {
       try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
           List<Computers> computerList =(List<Computers>) ois.readObject();
           return computerList;
       }catch(Exception ex){
           throw new RuntimeException(ex.getMessage());
       }
    }
    
}
