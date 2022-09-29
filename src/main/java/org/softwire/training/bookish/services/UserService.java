package org.softwire.training.bookish.services;

import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.database.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends DatabaseService{

    public List<User> getAllUsers() {
        return jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM user")
                        .mapToBean(User.class)
                        .list()
        );
    }

    public void addUser(User user) {
        jdbi.useHandle(handle ->
                handle.createUpdate("INSERT INTO user (firstName, lastName) VALUES (:firstName, :lastName)")
                        .bind("firstName", user.getFirstName())
                        .bind("lastName", user.getLastName())
                        .execute()
        );
    }

    public void deleteUser(int userID) {
        jdbi.useHandle(handle ->
                handle.createUpdate("DELETE FROM user WHERE userID = :userID")
                        .bind("userID", userID)
                        .execute()
        );
    }

    public void updateUser(User user){
        jdbi.useHandle(handle ->
                handle.createUpdate("UPDATE user SET firstName = :firstname , lastName = :lastname WHERE userID = :userId")
                        .bind("userId", user.getUserID())
                        .bind("firstname", user.getFirstName())
                        .bind("lastname", user.getLastName())
                        .execute()
        );

    }
}
