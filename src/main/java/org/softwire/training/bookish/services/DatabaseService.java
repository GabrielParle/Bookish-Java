package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;

public abstract class DatabaseService {

    private final String hostname = "localhost";
    private final String database = "bookish";
    private final String user = "root";
    private final String password = System.getenv("DB_PASS");
    private final String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false";

    protected final Jdbi jdbi = Jdbi.create(connectionString);
}
