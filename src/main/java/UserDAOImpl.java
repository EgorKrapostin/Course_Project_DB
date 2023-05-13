import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = createEntityManager();
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        EntityManager entityManager = createEntityManager();
        return entityManager.find(User.class, id);
    }

    @Override
    public User createUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        entityManager.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user.setDateOfCange(LocalDateTime.now());
        entityManager.merge(user);
        transaction.commit();
        entityManager.close();
}

    @Override
    public void deleteUser(User user) {
        EntityManager entityManager = createEntityManager();
        entityManager.find(User.class, user.getUserId());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(user);
        transaction.commit();
        entityManager.close();
    }

    private static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");

        return entityManagerFactory.createEntityManager();
    }
}
