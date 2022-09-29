package org.softwire.training.bookish.models.page;



import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.database.User;

import java.util.List;

public class UserPageModel {
    private List<User> user;

    public List<User> getUsers() {
        return user;
    }
    public void setUsers(List<User> user) {
        this.user = user;
    }
}