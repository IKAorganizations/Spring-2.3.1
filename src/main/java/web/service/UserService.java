package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    User update(User updatedUser);

    void delete(int id);



}
