package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.User;
import peaksoft.repository.UserRepository;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUser(Long id, User newUser) {
        User foundedUser1 = entityManager.find(User.class, id);
        foundedUser1.setFullName(newUser.getFullName());
        foundedUser1.setEmail(newUser.getEmail());
        foundedUser1.setPhoto(newUser.getPhoto());
        foundedUser1.setAge(newUser.getAge());
        entityManager.merge(foundedUser1);
    }

    @Override
    public void deleteUserById(Long id) {
        try {
            System.out.println("before delete");
            entityManager.remove(entityManager.find(User.class, id));
            System.out.println("after delete");
//        entityManager.createQuery("delete fromom User u where u.id=:id")
//                .setParameter("id", id).executeUpdate();
        } catch (HibernateException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<User> searchUser(String word) {
        return entityManager.createQuery("select u from User u where u.fullName ilike :word", User.class)
                .setParameter("word", "%" + word + "%")
                .getResultList();
    }
}
