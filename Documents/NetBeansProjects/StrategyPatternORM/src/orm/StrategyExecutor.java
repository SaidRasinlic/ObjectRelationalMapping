package orm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.dao.txt.FileAccess;
import orm.model.Computers;

public class StrategyExecutor {

    public static void main(String[] args) throws DaoException {

        Dao dao = new FileAccess();
        StrategyPattern strategyPattern = new StrategyPattern(dao);
        List<Computers> computers = new ArrayList<>(Arrays.asList(
                new Computers("Acer", "1TB", 2020, true),
                new Computers("MAC Apple", "2TB SSD", 2020, true)));
        strategyPattern.writeStock(computers);
        for (Computers pc : strategyPattern.readStock()) {
            System.out.println(pc);
        }
    }
}
