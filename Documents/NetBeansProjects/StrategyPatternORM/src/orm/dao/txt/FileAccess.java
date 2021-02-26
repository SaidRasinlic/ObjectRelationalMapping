package orm.dao.txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.model.Computers;

public class FileAccess implements Dao {
    
    private final String FILE_NAME = "computers.txt";
    @Override
    public void writeStock(List<Computers> computers) throws DaoException {
        if (computers == null || computers.isEmpty()) {
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            computers.forEach((Computers computerList) -> {
                pw.println(computerList.getComputerName() + ";" + computerList.getComputerMemory()
                        + ";" + computerList.getComputerAge() + ";" + computerList.getComputerStockAvailabilty()
                );
            });
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Computers> readStock() throws DaoException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            List<Computers> computerList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String computerName = tokenizer.nextToken();
                String computerMemory = tokenizer.nextToken();
                int computerAge = Integer.parseInt(tokenizer.nextToken());
                boolean computerAvailability = Boolean.parseBoolean(tokenizer.nextToken());
                Computers computers = new Computers(computerName, computerMemory, computerAge, computerAvailability);
                computerList.add(computers);
            }
            return computerList;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}