package ro.ase.acs.interfaces;

import java.sql.SQLException;

public interface DatabaseDataReader {
    void readData() throws SQLException;
}