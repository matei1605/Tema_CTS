package ro.ase.acs.classes;

import ro.ase.acs.interfaces.*;
import ro.ase.acs.interfaces.DatabaseCloser;
import ro.ase.acs.interfaces.DatabaseWriter;
import ro.ase.acs.interfaces.DatabaseDataReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements DatabaseTableCreator, DatabaseWriter, DatabaseDataReader, DatabaseCloser {
    private Connection connection;
    private TableCreator creator;
    private Writer writer;
    private Reader reader;
    private Closer closer;

    public DatabaseConnection(String databaseURL) throws SQLException {
        connection = DriverManager.getConnection(databaseURL);
        connection.setAutoCommit(false);
        creator = new TableCreator(connection);
        writer = new Writer(connection);
        reader = new Reader(connection);
        closer = new Closer(connection);
    }

    @Override
    public void createTable() throws SQLException {
        creator.createTable();
    }

    @Override
    public void closeConnection() throws SQLException {
        closer.closeConnection();
    }

    @Override
    public void readData() throws SQLException {
        reader.readData();
    }

    @Override
    public void insertData() throws SQLException {
        writer.insertData();
    }

}