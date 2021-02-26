package orm.model;

import java.io.Serializable;

public class Computers implements Serializable {

    private String computerName;
    private String computerMemory;
    private int computerAge;
    private boolean computerStockAvailabilty;

    public Computers(String computerName, String computerMemory, int computerAge, boolean computerStockAvailabilty) {
        this.computerName = computerName;
        this.computerMemory = computerMemory;
        this.computerAge = computerAge;
        this.computerStockAvailabilty = computerStockAvailabilty;
    }

    public Computers() {
    }

    public void setComputerAge(int computerAge) {
        this.computerAge = computerAge;
    }

    public void setComputerMemory(String computerMemory) {
        this.computerMemory = computerMemory;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public void setComputerStockAvailabilty(boolean computerStockAvailabilty) {
        this.computerStockAvailabilty = computerStockAvailabilty;
    }

    public int getComputerAge() {
        return computerAge;
    }

    public String getComputerMemory() {
        return computerMemory;
    }

    public String getComputerName() {
        return computerName;
    }

    public boolean getComputerStockAvailabilty() {
        return computerStockAvailabilty;
    }

    @Override
    public String toString() {
        return computerName + " " + computerMemory + " " + computerAge + " " + computerStockAvailabilty;
    }
}