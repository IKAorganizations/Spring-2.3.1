package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private  EntityManager entityManager;

    public List<User> findAll() {
        List<User> list = entityManager.createQuery("select u from User u", User.class).getResultList();
        return list;
    }

    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }


    public void save(User user) {
        entityManager.persist(user);
    }


    public User update(User updatedUser) {
        return entityManager.merge(updatedUser);
    }


    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}