package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDaoImp;

    @Autowired
    public UserServiceImpl(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    public List<User> findAll() {
        return userDaoImp.findAll();
    }

    public User findOne(int id) {
        return userDaoImp.findOne(id);
    }

    public void save(User user) {
        userDaoImp.save(user);
    }


    public User update(User updatedUser) {
        return userDaoImp.update(updatedUser);
    }


    public void delete(int id) {
        userDaoImp.delete(id);
    }



}


