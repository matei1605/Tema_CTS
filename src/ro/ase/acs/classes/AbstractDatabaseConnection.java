package ro.ase.acs.classes;

import ro.ase.acs.interfaces.*;
import ro.ase.acs.interfaces.DatabaseDataReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDatabaseConnection implements DatabaseCloser, DatabaseDataReader, DatabaseTableCreator, DatabaseWriter {
    protected Connection connection;

    public AbstractDatabaseConnection(String databaseURL) {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connection = DriverManager.getConnection(databaseURL);
            this.connection.setAutoCommit(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}