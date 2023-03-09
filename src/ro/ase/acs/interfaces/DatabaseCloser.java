package ro.ase.acs.interfaces;

import java.sql.SQLException;

public interface DatabaseCloser {
    void closeConnection() throws SQLException;
}