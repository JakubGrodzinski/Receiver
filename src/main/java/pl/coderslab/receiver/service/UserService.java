package pl.coderslab.receiver.service;

import pl.coderslab.receiver.model.User;

public interface UserService
{
    User findByUserName (String name);
    void saveUser (User user);
}
