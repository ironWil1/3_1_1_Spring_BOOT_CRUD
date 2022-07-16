package ru.ziiangirov.springprojects.service;


import ru.ziiangirov.springprojects.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    void deleteUser(long id);

    User getUser(long id);

    List<User> getAll();
}
