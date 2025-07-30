package org.example.testing;

public class Service {
    private Database database;

    public Service(Database database) {
        this.database = database;
    }

    public boolean query(String query) {
        // some logic

        return database.isAvailable();
    }

    public boolean isExist(String request) {
        return database.isExist(request);
    }

    @Override
    public String toString() {
        return "Using dataBAse with ID: " + String.valueOf(database.getUniqueId());
    }
}
