package ru.ziiangirov.springprojects.dao;



import ru.ziiangirov.springprojects.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void saveUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    void updateUser(User user);

    List<User> showAllUsers();


}
