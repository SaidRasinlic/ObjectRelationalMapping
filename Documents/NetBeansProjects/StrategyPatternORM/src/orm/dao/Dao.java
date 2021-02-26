package orm.dao;

import java.util.List;
import orm.model.Computers;

public interface Dao {

    public void writeStock(List<Computers> computers) throws DaoException;

    public List<Computers> readStock() throws DaoException;
}
