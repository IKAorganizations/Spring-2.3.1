package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional(readOnly = true)
public class UserDao {

    @PersistenceContext
    private  EntityManager entityManager;

    public List<User> findAll() {
        List<User> list = entityManager.createQuery("select u from User u", User.class).getResultList();
        return list;
    }

    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public User update(User updatedUser) {
        return entityManager.merge(updatedUser);
    }

    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}