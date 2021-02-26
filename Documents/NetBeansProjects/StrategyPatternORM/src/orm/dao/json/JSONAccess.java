package orm.dao.json;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import orm.dao.Dao;
import orm.dao.DaoException;
import orm.model.Computers;

public class JSONAccess implements Dao {

    private final String FILE_NAME = "computers.json";

    @Override
    public void writeStock(List<Computers> computers) throws DaoException {
        if (computers == null || computers.isEmpty()) {
            return;
        }
        try {
            JSONArray jsonArr = new JSONArray();
            for (Computers computer : computers) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("computerName", computer.getComputerName());
                jsonObj.put("computerMemory", computer.getComputerMemory());
                jsonObj.put("computerAge", computer.getComputerAge());
                jsonObj.put("computerAvailabilty", computer.getComputerStockAvailabilty());
                jsonArr.add(jsonObj);
            }
            try (FileWriter fw = new FileWriter(FILE_NAME)) {

                String jsonStr = jsonArr.toJSONString();
                fw.write(jsonStr);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public List<Computers> readStock() throws DaoException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            JSONParser parser = new JSONParser();
            JSONArray jsonArr = (JSONArray) parser.parse(reader);
            List<Computers> computersList = new ArrayList<>();
            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                Computers computers = new Computers(jsonObj.get("computerName").toString(), jsonObj.get("computerMemory").toString(), Integer.parseInt(jsonObj.get("computerAge").toString()), Boolean.valueOf(jsonObj.get("computerAvailabilty").toString()));
                computersList.add(computers);
            }
            return computersList;

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}