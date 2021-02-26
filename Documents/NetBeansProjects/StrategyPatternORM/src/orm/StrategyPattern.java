package orm;

import java.util.List;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.model.Computers;

public class StrategyPattern {

    private Dao dao;

    public StrategyPattern(Dao dao) {
        this.dao = dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public void writeStock(List<Computers> computers) throws DaoException {
        dao.writeStock(computers);
    }

    public List<Computers> readStock() throws DaoException {
        return dao.readStock();
    }
}
